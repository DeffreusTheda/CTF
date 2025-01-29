
from __future__ import print_function
import os
import struct
import marshal
import zlib
import sys
from uuid import uuid4 as uniquename


class CTOCEntry:
    def __init__(self, position, cmprsdDataSize, uncmprsdDataSize, cmprsFlag, typeCmprsData, name):
        self.position = position
        self.cmprsdDataSize = cmprsdDataSize
        self.uncmprsdDataSize = uncmprsdDataSize
        self.cmprsFlag = cmprsFlag
        self.typeCmprsData = typeCmprsData
        self.name = name


class Archive:
    PYINST20_COOKIE_SIZE = 24  
    PYINST21_COOKIE_SIZE = 24 + 64  
    MAGIC = b"MEI\014\013\012\013\016"  

    def __init__(self, path):
        self.filePath = path
        self.pycMagic = b"\0" * 4
        self.barePycList = []  

    def open(self):
        try:
            self.fPtr = open(self.filePath, "rb")
            self.fileSize = os.stat(self.filePath).st_size
        except:
            
            return False
        return True

    def close(self):
        try:
            self.fPtr.close()
        except:
            pass

    

    
    def parseTOC(self):
        
        self.fPtr.seek(self.tableOfContentsPos, os.SEEK_SET)

        self.tocList = []
        parsedLen = 0

        
        while parsedLen < self.tableOfContentsSize:
            (entrySize,) = struct.unpack("!i", self.fPtr.read(4))
            nameLen = struct.calcsize("!iIIIBc")

            (entryPos, cmprsdDataSize, uncmprsdDataSize, cmprsFlag, typeCmprsData, name) = struct.unpack(
                "!IIIBc{0}s".format(entrySize - nameLen), self.fPtr.read(entrySize - 4)
            )

            try:
                name = name.decode("utf-8").rstrip("\0")
            except UnicodeDecodeError:
                newName = str(uniquename())
                
                name = newName

            
            if name.startswith("/"):
                name = name.lstrip("/")

            if len(name) == 0:
                name = str(uniquename())
                

            self.tocList.append(
                CTOCEntry(self.overlayPos + entryPos, cmprsdDataSize, uncmprsdDataSize, cmprsFlag, typeCmprsData, name)
            )

            parsedLen += entrySize
        

    def _writeRawData(self, filepath, data):
        nm = filepath.replace("\\", os.path.sep).replace("/", os.path.sep).replace("..", "__")
        nmDir = os.path.dirname(nm)
        if nmDir != "" and not os.path.exists(nmDir):  
            os.makedirs(nmDir)

        with open(nm, "wb") as f:
            f.write(data)

    def extractFiles(self):
        
        extractionDir = os.path.join(os.getcwd(), os.path.basename(self.filePath) + "_extracted")

        if not os.path.exists(extractionDir):
            os.mkdir(extractionDir)

        os.chdir(extractionDir)

        for entry in self.tocList:
            self.fPtr.seek(entry.position, os.SEEK_SET)
            data = self.fPtr.read(entry.cmprsdDataSize)

            if entry.cmprsFlag == 1:
                try:
                    data = zlib.decompress(data)
                except zlib.error:
                    
                    continue
                
                
                assert len(data) == entry.uncmprsdDataSize  

            if entry.typeCmprsData == b"d" or entry.typeCmprsData == b"o":
                
                
                
                continue

            basePath = os.path.dirname(entry.name)
            if basePath != "":
                
                if not os.path.exists(basePath):
                    os.makedirs(basePath)

            if entry.typeCmprsData == b"s":
                
                
                

                if self.pycMagic == b"\0" * 4:
                    
                    self.barePycList.append(entry.name + ".pyc")
                self._writePyc(entry.name + ".pyc", data)

            elif entry.typeCmprsData == b"M" or entry.typeCmprsData == b"m":
                
                
                

                
                
                if data[2:4] == b"\r\n":
                    
                    if self.pycMagic == b"\0" * 4:
                        self.pycMagic = data[0:4]
                    self._writeRawData(entry.name + ".pyc", data)

                else:
                    
                    if self.pycMagic == b"\0" * 4:
                        
                        self.barePycList.append(entry.name + ".pyc")

                    self._writePyc(entry.name + ".pyc", data)

            else:
                self._writeRawData(entry.name, data)

                if entry.typeCmprsData == b"z" or entry.typeCmprsData == b"Z":
                    self._extractPyz(entry.name)

        
        self._fixBarePycs()

    def _fixBarePycs(self):
        for pycFile in self.barePycList:
            with open(pycFile, "r+b") as pycFile:
                
                pycFile.write(self.pycMagic)

    def _writePyc(self, filename, data):
        with open(filename, "wb") as pycFile:
            pycFile.write(self.pycMagic)  

            if self.pymaj >= 3 and self.pymin >= 7:  
                pycFile.write(b"\0" * 4)  
                pycFile.write(b"\0" * 8)  

            else:
                pycFile.write(b"\0" * 4)  
                if self.pymaj >= 3 and self.pymin >= 3:
                    pycFile.write(b"\0" * 4)  

            pycFile.write(data)

    def _extractPyz(self, name):
        dirName = name + "_extracted"
        
        if not os.path.exists(dirName):
            os.mkdir(dirName)

        with open(name, "rb") as f:
            pyzMagic = f.read(4)
            assert pyzMagic == b"PYZ\0"  

            pyzPycMagic = f.read(4)  

            if self.pycMagic == b"\0" * 4:
                self.pycMagic = pyzPycMagic

            elif self.pycMagic != pyzPycMagic:
                self.pycMagic = pyzPycMagic
                

            
            if self.pymaj != sys.version_info.major or self.pymin != sys.version_info.minor:
                print(
                    "[!] Warning: This script is running in a different Python version than the one used to build the executable."
                )
                print(
                    "[!] Please run this script in Python {0}.{1} to prevent extraction errors during unmarshalling".format(
                        self.pymaj, self.pymin
                    )
                )
                
                return

            (tocPosition,) = struct.unpack("!i", f.read(4))
            f.seek(tocPosition, os.SEEK_SET)

            try:
                toc = marshal.load(f)
            except:
                
                return

            

            
            if type(toc) == list:
                toc = dict(toc)

            for key in toc.keys():
                (ispkg, pos, length) = toc[key]
                f.seek(pos, os.SEEK_SET)
                fileName = key

                try:
                    
                    fileName = fileName.decode("utf-8")
                except:
                    pass

                
                fileName = fileName.replace("..", "__").replace(".", os.path.sep)

                if ispkg == 1:
                    filePath = os.path.join(dirName, fileName, "__init__.pyc")

                else:
                    filePath = os.path.join(dirName, fileName + ".pyc")

                fileDir = os.path.dirname(filePath)
                if not os.path.exists(fileDir):
                    os.makedirs(fileDir)

                try:
                    data = f.read(length)
                    data = zlib.decompress(data)
                except:
                    
                    open(filePath + ".encrypted", "wb").write(data)
                else:
                    self._writePyc(filePath, data)


def main():
   
    dbg = Archive(sys.argv[1])
    if dbg.open():
      
    
        dbg.parseTOC()
        dbg.extractFiles()
        dbg.close()
        return

    dbg.close()


if __name__ == "__main__":
    main()
