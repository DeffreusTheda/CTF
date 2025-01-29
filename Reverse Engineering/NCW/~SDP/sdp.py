# Decompiled with PyLingual (https://pylingual.io)
# Internal filename: sdp.py
# Bytecode version: 3.12.0rc2 (3531)
# Source timestamp: 2024-10-05 16:39:43 UTC (1728146383)

import struct
from enum import Enum
from typing import *

class SdpDataType(Enum):
    INTEGER_POSITIVE = 0
    INTEGER_NEGATIVE = 1
    FLOAT = 2
    DOUBLE = 3
    STRING = 4
    LIST = 5
    DICT = 6
    STRUCT_BEGIN = 7
    STRUCT_END = 8

class SdpStruct:

    def __init__(self, data: Dict[int, Any]=None):
        self._data = data or {}

    def __getitem__(self, key: int) -> Any:
        return self._data[key]

    def __setitem__(self, key: int, value: Any) -> None:
        self._data[key] = value

    def __delitem__(self, key: int) -> None:
        del self._data[key]

    def __repr__(self) -> str:
        return f'{self._data}'

    def __eq__(self, other: 'SdpStruct') -> bool:
        return isinstance(other, SdpStruct) and self._data == other._data

    def __iter__(self):
        return iter(self._data)

    def __len__(self):
        return len(self._data)

    def __contains__(self, key):
        return key in self._data

    def __json__(self):
        return self._data

    def get(self, key, default=None):
        return self._data.get(key, default)

    def items(self):
        return self._data.items()

    @staticmethod
    def _pack_number(value: int) -> bytes:
        result = bytearray()
        while value > 127:
            result.append(value & 127 | 128)
            value >>= 7
        result.append(value)
        return bytes(result)

    @staticmethod
    def _unpack_number(data: bytes, offset: int) -> tuple[int, int]:
        # raise NotImplementedError
        result = 0
        shift = 0
        while True:
            byte = data[offset]
            offset += 1
            result |= (byte & 127) << shift
            if byte < 128:
                break
            shift += 7
        return result, offset

    @classmethod
    def _pack_value(cls, tag: int, value: Any) -> bytes:
        if isinstance(value, int):
            type_ = SdpDataType.INTEGER_POSITIVE if value >= 0 else SdpDataType.INTEGER_NEGATIVE
            header = type_.value << 4 | (tag if tag < 15 else 15)
            result = bytes([header])
            if tag >= 15:
                result += cls._pack_number(tag)
            result += cls._pack_number(abs(value))
            return result
        if isinstance(value, float):
            type_ = SdpDataType.DOUBLE
            header = type_.value << 4 | (tag if tag < 15 else 15)
            result = bytes([header])
            if tag >= 15:
                result += cls._pack_number(tag)
            result += struct.pack('d', value)
            return result
        if isinstance(value, str) or isinstance(value, bytes):
            type_ = SdpDataType.STRING
            header = type_.value << 4 | (tag if tag < 15 else 15)
            result = bytes([header])
            if tag >= 15:
                result += cls._pack_number(tag)
            encoded = value.encode('utf-8') if isinstance(value, str) else value
            result += cls._pack_number(len(encoded)) + encoded
            return result
        if isinstance(value, list):
            type_ = SdpDataType.LIST
            header = type_.value << 4 | (tag if tag < 15 else 15)
            result = bytes([header])
            if tag >= 15:
                result += cls._pack_number(tag)
            result += cls._pack_number(len(value))
            for item in value:
                result += cls._pack_value(0, item)
            return result
        elif isinstance(value, dict):
            type_ = SdpDataType.DICT
            header = type_.value << 4 | (tag if tag < 15 else 15)
            result = bytes([header])
            if tag >= 15:
                result += cls._pack_number(tag)
            result += cls._pack_number(len(value))
            for k, v in value.items():
                result += cls._pack_value(0, k)
                result += cls._pack_value(0, v)
            return result
        elif isinstance(value, SdpStruct):
            type_ = SdpDataType.STRUCT_BEGIN
            header = type_.value << 4 | (tag if tag < 15 else 15)
            result = bytes([header])
            if tag >= 15:
                result += cls._pack_number(tag)
            for sub_tag, sub_value in value.items():
                result += cls._pack_value(sub_tag, sub_value)
            result += bytes([SdpDataType.STRUCT_END.value << 4])
            return result
        else:
            raise ValueError(f'Unsupported type: {type(value)}')

    def pack(self) -> bytes:
        result = bytes([SdpDataType.STRUCT_BEGIN.value << 4])
        for tag, value in sorted(self._data.items()):
            result += self._pack_value(tag, value)
        result += bytes([SdpDataType.STRUCT_END.value << 4])
        return result

    @classmethod
    def _unpack_value(cls, data: bytes, offset: int) -> tuple[int, Any, int]:
        # raise NotImplementedError
        header = data[offset]
        offset += 1
        type_ = SdpDataType(header >> 4)
        tag = header & 15
        if tag == 15:
            tag, offset = cls._unpack_number(data, offset)

        if type_ in (SdpDataType.INTEGER_POSITIVE, SdpDataType.INTEGER_NEGATIVE):
            value, offset = cls._unpack_number(data, offset)
            if type_ == SdpDataType.INTEGER_NEGATIVE:
                value = -value
        elif type_ == SdpDataType.DOUBLE:
            value = struct.unpack('d', data[offset:offset+8])[0]
            offset += 8
        elif type_ == SdpDataType.STRING:
            length, offset = cls._unpack_number(data, offset)
            value = data[offset:offset+length]
            offset += length
        elif type_ == SdpDataType.LIST:
            length, offset = cls._unpack_number(data, offset)
            value = []
            for _ in range(length):
                _, item, offset = cls._unpack_value(data, offset)
                value.append(item)
        elif type_ == SdpDataType.DICT:
            length, offset = cls._unpack_number(data, offset)
            value = {}
            for _ in range(length):
                _, k, offset = cls._unpack_value(data, offset)
                _, v, offset = cls._unpack_value(data, offset)
                value[k] = v
        elif type_ == SdpDataType.STRUCT_BEGIN:
            value = SdpStruct()
            while True:
                if data[offset] >> 4 == SdpDataType.STRUCT_END.value:
                    offset += 1
                    break
                sub_tag, sub_value, offset = cls._unpack_value(data, offset)
                value[sub_tag] = sub_value
        else:
            raise ValueError(f'Unsupported type: {type_}')

        return tag, value, offset

    @classmethod
    def unpack(cls, data: bytes) -> 'SdpStruct':
        # raise NotImplementedError
        if data[0] >> 4 != SdpDataType.STRUCT_BEGIN.value:
            raise ValueError('Invalid SDP struct: does not start with STRUCT_BEGIN')
        
        result = cls()
        offset = 1
        while offset < len(data):
            if data[offset] >> 4 == SdpDataType.STRUCT_END.value:
                break
            tag, value, offset = cls._unpack_value(data, offset)
            result[tag] = value

        if offset >= len(data) or data[offset] >> 4 != SdpDataType.STRUCT_END.value:
            raise ValueError('Invalid SDP struct: does not end with STRUCT_END')

        return result
