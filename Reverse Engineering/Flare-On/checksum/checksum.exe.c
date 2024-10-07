typedef unsigned char   undefined;

typedef unsigned char    bool;
typedef unsigned char    byte;
typedef unsigned int    dword;
float4
float8
typedef pointer32 ImageBaseOffset32;

typedef long long    longlong;
typedef unsigned int    qword;
typedef char    sbyte;
typedef int    sdword;
typedef int    sqword;
typedef short    sword;
typedef unsigned char    uchar;
typedef unsigned int    uint;
typedef unsigned long    ulong;
typedef unsigned long long    ulonglong;
typedef unsigned char    undefined1;
typedef unsigned short    undefined2;
typedef unsigned int    undefined4;
typedef unsigned int    undefined8;
typedef unsigned short    ushort;
typedef int    wchar_t;
typedef unsigned short    word;
typedef struct _IMAGE_RUNTIME_FUNCTION_ENTRY _IMAGE_RUNTIME_FUNCTION_ENTRY, *P_IMAGE_RUNTIME_FUNCTION_ENTRY;

struct _IMAGE_RUNTIME_FUNCTION_ENTRY {
    ImageBaseOffset32 BeginAddress;
    ImageBaseOffset32 EndAddress;
    ImageBaseOffset32 UnwindInfoAddressOrData;
};

typedef struct GoName_20_0_0 GoName_20_0_0, *PGoName_20_0_0;

typedef struct GoVarlenString_1_19 GoVarlenString_1_19, *PGoVarlenString_1_19;

struct GoVarlenString_1_19 {
    byte strlen[1];
    char value[19];
};

struct GoName_20_0_0 {
    byte flags;
    struct GoVarlenString_1_19 name;
};

typedef struct GoName_47_0_0 GoName_47_0_0, *PGoName_47_0_0;

typedef struct GoVarlenString_1_46 GoVarlenString_1_46, *PGoVarlenString_1_46;

struct GoVarlenString_1_46 {
    byte strlen[1];
    char value[46];
};

struct GoName_47_0_0 {
    byte flags;
    struct GoVarlenString_1_46 name;
};

typedef struct GoName_12_0_0 GoName_12_0_0, *PGoName_12_0_0;

typedef struct GoVarlenString_1_11 GoVarlenString_1_11, *PGoVarlenString_1_11;

struct GoVarlenString_1_11 {
    byte strlen[1];
    char value[11];
};

struct GoName_12_0_0 {
    byte flags;
    struct GoVarlenString_1_11 name;
};

typedef struct GoBuildInfo_inline_1_8_2_370 GoBuildInfo_inline_1_8_2_370, *PGoBuildInfo_inline_1_8_2_370;

struct GoBuildInfo_inline_1_8_2_370 {
    char magic[14]; // \xff Go buildinf:
    byte ptrSize;
    byte flags;
    byte padding[16];
    byte versionlen[1];
    char version[8];
    byte modulelen[2];
    byte sentinelstart[16];
    char moduleinfo[338];
    byte sentinelend[16];
};

typedef struct GoName_43_0_0 GoName_43_0_0, *PGoName_43_0_0;

typedef struct GoVarlenString_1_42 GoVarlenString_1_42, *PGoVarlenString_1_42;

struct GoVarlenString_1_42 {
    byte strlen[1];
    char value[42];
};

struct GoName_43_0_0 {
    byte flags;
    struct GoVarlenString_1_42 name;
};

typedef struct GoName_32_0_0 GoName_32_0_0, *PGoName_32_0_0;

typedef struct GoVarlenString_1_31 GoVarlenString_1_31, *PGoVarlenString_1_31;

struct GoVarlenString_1_31 {
    byte strlen[1];
    char value[31];
};

struct GoName_32_0_0 {
    byte flags;
    struct GoVarlenString_1_31 name;
};

typedef struct GoName_39_0_0 GoName_39_0_0, *PGoName_39_0_0;

typedef struct GoVarlenString_1_38 GoVarlenString_1_38, *PGoVarlenString_1_38;

struct GoVarlenString_1_38 {
    byte strlen[1];
    char value[38];
};

struct GoName_39_0_0 {
    byte flags;
    struct GoVarlenString_1_38 name;
};

typedef struct GoName_27_0_0 GoName_27_0_0, *PGoName_27_0_0;

typedef struct GoVarlenString_1_26 GoVarlenString_1_26, *PGoVarlenString_1_26;

struct GoVarlenString_1_26 {
    byte strlen[1];
    char value[26];
};

struct GoName_27_0_0 {
    byte flags;
    struct GoVarlenString_1_26 name;
};

typedef struct GoName_19_0_0 GoName_19_0_0, *PGoName_19_0_0;

typedef struct GoVarlenString_1_18 GoVarlenString_1_18, *PGoVarlenString_1_18;

struct GoVarlenString_1_18 {
    byte strlen[1];
    char value[18];
};

struct GoName_19_0_0 {
    byte flags;
    struct GoVarlenString_1_18 name;
};

typedef struct GoName_6_0_4 GoName_6_0_4, *PGoName_6_0_4;

typedef struct GoVarlenString_1_5 GoVarlenString_1_5, *PGoVarlenString_1_5;

typedef sdword int32;

struct GoVarlenString_1_5 {
    byte strlen[1];
    char value[5];
};

struct GoName_6_0_4 {
    byte flags;
    struct GoVarlenString_1_5 name;
    int32 pkgPath;
};

typedef struct GoName_36_0_0 GoName_36_0_0, *PGoName_36_0_0;

typedef struct GoVarlenString_1_35 GoVarlenString_1_35, *PGoVarlenString_1_35;

struct GoVarlenString_1_35 {
    byte strlen[1];
    char value[35];
};

struct GoName_36_0_0 {
    byte flags;
    struct GoVarlenString_1_35 name;
};

typedef struct GoVarlenString_1_7 GoVarlenString_1_7, *PGoVarlenString_1_7;

struct GoVarlenString_1_7 {
    byte strlen[1];
    char value[7];
};

typedef struct GoVarlenString_1_6 GoVarlenString_1_6, *PGoVarlenString_1_6;

struct GoVarlenString_1_6 {
    byte strlen[1];
    char value[6];
};

typedef struct GoVarlenString_1_9 GoVarlenString_1_9, *PGoVarlenString_1_9;

struct GoVarlenString_1_9 {
    byte strlen[1];
    char value[9];
};

typedef struct GoVarlenString_1_8 GoVarlenString_1_8, *PGoVarlenString_1_8;

struct GoVarlenString_1_8 {
    byte strlen[1];
    char value[8];
};

typedef struct GoVarlenString_1_1 GoVarlenString_1_1, *PGoVarlenString_1_1;

struct GoVarlenString_1_1 {
    byte strlen[1];
    char value[1];
};

typedef struct GoVarlenString_1_0 GoVarlenString_1_0, *PGoVarlenString_1_0;

struct GoVarlenString_1_0 {
    byte strlen[1];
    char value[0];
};

typedef struct GoVarlenString_1_3 GoVarlenString_1_3, *PGoVarlenString_1_3;

struct GoVarlenString_1_3 {
    byte strlen[1];
    char value[3];
};

typedef struct GoVarlenString_1_2 GoVarlenString_1_2, *PGoVarlenString_1_2;

struct GoVarlenString_1_2 {
    byte strlen[1];
    char value[2];
};

typedef struct GoVarlenString_1_4 GoVarlenString_1_4, *PGoVarlenString_1_4;

struct GoVarlenString_1_4 {
    byte strlen[1];
    char value[4];
};

typedef struct GoName_23_0_0 GoName_23_0_0, *PGoName_23_0_0;

typedef struct GoVarlenString_1_22 GoVarlenString_1_22, *PGoVarlenString_1_22;

struct GoVarlenString_1_22 {
    byte strlen[1];
    char value[22];
};

struct GoName_23_0_0 {
    byte flags;
    struct GoVarlenString_1_22 name;
};

typedef struct GoName_40_0_0 GoName_40_0_0, *PGoName_40_0_0;

typedef struct GoVarlenString_1_39 GoVarlenString_1_39, *PGoVarlenString_1_39;

struct GoVarlenString_1_39 {
    byte strlen[1];
    char value[39];
};

struct GoName_40_0_0 {
    byte flags;
    struct GoVarlenString_1_39 name;
};

typedef struct GoName_6_0_0 GoName_6_0_0, *PGoName_6_0_0;

struct GoName_6_0_0 {
    byte flags;
    struct GoVarlenString_1_5 name;
};

typedef struct GoVarlenString_1_25 GoVarlenString_1_25, *PGoVarlenString_1_25;

struct GoVarlenString_1_25 {
    byte strlen[1];
    char value[25];
};

typedef struct GoVarlenString_1_24 GoVarlenString_1_24, *PGoVarlenString_1_24;

struct GoVarlenString_1_24 {
    byte strlen[1];
    char value[24];
};

typedef struct GoVarlenString_1_27 GoVarlenString_1_27, *PGoVarlenString_1_27;

struct GoVarlenString_1_27 {
    byte strlen[1];
    char value[27];
};

typedef struct GoVarlenString_1_29 GoVarlenString_1_29, *PGoVarlenString_1_29;

struct GoVarlenString_1_29 {
    byte strlen[1];
    char value[29];
};

typedef struct GoVarlenString_1_28 GoVarlenString_1_28, *PGoVarlenString_1_28;

struct GoVarlenString_1_28 {
    byte strlen[1];
    char value[28];
};

typedef struct GoName_7_0_0 GoName_7_0_0, *PGoName_7_0_0;

struct GoName_7_0_0 {
    byte flags;
    struct GoVarlenString_1_6 name;
};

typedef struct GoVarlenString_1_21 GoVarlenString_1_21, *PGoVarlenString_1_21;

struct GoVarlenString_1_21 {
    byte strlen[1];
    char value[21];
};

typedef struct GoVarlenString_1_20 GoVarlenString_1_20, *PGoVarlenString_1_20;

struct GoVarlenString_1_20 {
    byte strlen[1];
    char value[20];
};

typedef struct GoVarlenString_1_23 GoVarlenString_1_23, *PGoVarlenString_1_23;

struct GoVarlenString_1_23 {
    byte strlen[1];
    char value[23];
};

typedef struct GoBuildId GoBuildId, *PGoBuildId;

struct GoBuildId {
    char magic[16];
    char buildId[83];
};

typedef struct GoVarlenString_1_14 GoVarlenString_1_14, *PGoVarlenString_1_14;

struct GoVarlenString_1_14 {
    byte strlen[1];
    char value[14];
};

typedef struct GoVarlenString_1_13 GoVarlenString_1_13, *PGoVarlenString_1_13;

struct GoVarlenString_1_13 {
    byte strlen[1];
    char value[13];
};

typedef struct GoVarlenString_1_16 GoVarlenString_1_16, *PGoVarlenString_1_16;

struct GoVarlenString_1_16 {
    byte strlen[1];
    char value[16];
};

typedef struct GoVarlenString_1_15 GoVarlenString_1_15, *PGoVarlenString_1_15;

struct GoVarlenString_1_15 {
    byte strlen[1];
    char value[15];
};

typedef struct GoName_31_0_0 GoName_31_0_0, *PGoName_31_0_0;

typedef struct GoVarlenString_1_30 GoVarlenString_1_30, *PGoVarlenString_1_30;

struct GoVarlenString_1_30 {
    byte strlen[1];
    char value[30];
};

struct GoName_31_0_0 {
    byte flags;
    struct GoVarlenString_1_30 name;
};

typedef struct GoVarlenString_1_17 GoVarlenString_1_17, *PGoVarlenString_1_17;

struct GoVarlenString_1_17 {
    byte strlen[1];
    char value[17];
};

typedef struct GoName_28_0_0 GoName_28_0_0, *PGoName_28_0_0;

struct GoName_28_0_0 {
    byte flags;
    struct GoVarlenString_1_27 name;
};

typedef struct GoVarlenString_1_10 GoVarlenString_1_10, *PGoVarlenString_1_10;

struct GoVarlenString_1_10 {
    byte strlen[1];
    char value[10];
};

typedef struct GoVarlenString_1_12 GoVarlenString_1_12, *PGoVarlenString_1_12;

struct GoVarlenString_1_12 {
    byte strlen[1];
    char value[12];
};

typedef struct GoName_13_0_0 GoName_13_0_0, *PGoName_13_0_0;

struct GoName_13_0_0 {
    byte flags;
    struct GoVarlenString_1_12 name;
};

typedef struct GoName_2_0_0 GoName_2_0_0, *PGoName_2_0_0;

struct GoName_2_0_0 {
    byte flags;
    struct GoVarlenString_1_1 name;
};

typedef struct GoName_3_0_0 GoName_3_0_0, *PGoName_3_0_0;

struct GoName_3_0_0 {
    byte flags;
    struct GoVarlenString_1_2 name;
};

typedef struct GoName_24_0_0 GoName_24_0_0, *PGoName_24_0_0;

struct GoName_24_0_0 {
    byte flags;
    struct GoVarlenString_1_23 name;
};

typedef struct GoName_35_0_0 GoName_35_0_0, *PGoName_35_0_0;

typedef struct GoVarlenString_1_34 GoVarlenString_1_34, *PGoVarlenString_1_34;

struct GoVarlenString_1_34 {
    byte strlen[1];
    char value[34];
};

struct GoName_35_0_0 {
    byte flags;
    struct GoVarlenString_1_34 name;
};

typedef struct GoVarlenString_1_110 GoVarlenString_1_110, *PGoVarlenString_1_110;

struct GoVarlenString_1_110 {
    byte strlen[1];
    char value[110];
};

typedef struct GoName_18_0_0 GoName_18_0_0, *PGoName_18_0_0;

struct GoName_18_0_0 {
    byte flags;
    struct GoVarlenString_1_17 name;
};

typedef struct GoName_8_0_0 GoName_8_0_0, *PGoName_8_0_0;

struct GoName_8_0_0 {
    byte flags;
    struct GoVarlenString_1_7 name;
};

typedef struct GoName_37_0_0 GoName_37_0_0, *PGoName_37_0_0;

typedef struct GoVarlenString_1_36 GoVarlenString_1_36, *PGoVarlenString_1_36;

struct GoVarlenString_1_36 {
    byte strlen[1];
    char value[36];
};

struct GoName_37_0_0 {
    byte flags;
    struct GoVarlenString_1_36 name;
};

typedef struct GoName_8_0_4 GoName_8_0_4, *PGoName_8_0_4;

struct GoName_8_0_4 {
    byte flags;
    struct GoVarlenString_1_7 name;
    int32 pkgPath;
};

typedef struct GoName_29_0_0 GoName_29_0_0, *PGoName_29_0_0;

struct GoName_29_0_0 {
    byte flags;
    struct GoVarlenString_1_28 name;
};

typedef struct GoVarlenString_1_58 GoVarlenString_1_58, *PGoVarlenString_1_58;

struct GoVarlenString_1_58 {
    byte strlen[1];
    char value[58];
};

typedef struct GoVarlenString_1_52 GoVarlenString_1_52, *PGoVarlenString_1_52;

struct GoVarlenString_1_52 {
    byte strlen[1];
    char value[52];
};

typedef struct GoName_30_0_0 GoName_30_0_0, *PGoName_30_0_0;

struct GoName_30_0_0 {
    byte flags;
    struct GoVarlenString_1_29 name;
};

typedef struct GoName_1_0_0 GoName_1_0_0, *PGoName_1_0_0;

struct GoName_1_0_0 {
    byte flags;
    struct GoVarlenString_1_0 name;
};

typedef struct GoName_45_0_0 GoName_45_0_0, *PGoName_45_0_0;

typedef struct GoVarlenString_1_44 GoVarlenString_1_44, *PGoVarlenString_1_44;

struct GoVarlenString_1_44 {
    byte strlen[1];
    char value[44];
};

struct GoName_45_0_0 {
    byte flags;
    struct GoVarlenString_1_44 name;
};

typedef struct GoName_14_0_0 GoName_14_0_0, *PGoName_14_0_0;

struct GoName_14_0_0 {
    byte flags;
    struct GoVarlenString_1_13 name;
};

typedef struct GoVarlenString_1_49 GoVarlenString_1_49, *PGoVarlenString_1_49;

struct GoVarlenString_1_49 {
    byte strlen[1];
    char value[49];
};

typedef struct GoName_25_0_0 GoName_25_0_0, *PGoName_25_0_0;

struct GoName_25_0_0 {
    byte flags;
    struct GoVarlenString_1_24 name;
};

typedef struct GoVarlenString_1_41 GoVarlenString_1_41, *PGoVarlenString_1_41;

struct GoVarlenString_1_41 {
    byte strlen[1];
    char value[41];
};

typedef struct GoName_17_0_0 GoName_17_0_0, *PGoName_17_0_0;

struct GoName_17_0_0 {
    byte flags;
    struct GoVarlenString_1_16 name;
};

typedef struct GoName_34_0_0 GoName_34_0_0, *PGoName_34_0_0;

typedef struct GoVarlenString_1_33 GoVarlenString_1_33, *PGoVarlenString_1_33;

struct GoVarlenString_1_33 {
    byte strlen[1];
    char value[33];
};

struct GoName_34_0_0 {
    byte flags;
    struct GoVarlenString_1_33 name;
};

typedef struct GoName_4_0_4 GoName_4_0_4, *PGoName_4_0_4;

struct GoName_4_0_4 {
    byte flags;
    struct GoVarlenString_1_3 name;
    int32 pkgPath;
};

typedef struct GoName_111_0_0 GoName_111_0_0, *PGoName_111_0_0;

struct GoName_111_0_0 {
    byte flags;
    struct GoVarlenString_1_110 name;
};

typedef struct GoName_4_0_0 GoName_4_0_0, *PGoName_4_0_0;

struct GoName_4_0_0 {
    byte flags;
    struct GoVarlenString_1_3 name;
};

typedef struct GoName_42_0_0 GoName_42_0_0, *PGoName_42_0_0;

struct GoName_42_0_0 {
    byte flags;
    struct GoVarlenString_1_41 name;
};

typedef struct GoVarlenString_1_32 GoVarlenString_1_32, *PGoVarlenString_1_32;

struct GoVarlenString_1_32 {
    byte strlen[1];
    char value[32];
};

typedef struct GoName_53_0_0 GoName_53_0_0, *PGoName_53_0_0;

struct GoName_53_0_0 {
    byte flags;
    struct GoVarlenString_1_52 name;
};

typedef struct GoName_10_0_0 GoName_10_0_0, *PGoName_10_0_0;

struct GoName_10_0_0 {
    byte flags;
    struct GoVarlenString_1_9 name;
};

typedef struct GoName_11_0_0 GoName_11_0_0, *PGoName_11_0_0;

struct GoName_11_0_0 {
    byte flags;
    struct GoVarlenString_1_10 name;
};

typedef struct GoName_9_0_0 GoName_9_0_0, *PGoName_9_0_0;

struct GoName_9_0_0 {
    byte flags;
    struct GoVarlenString_1_8 name;
};

typedef struct GoName_21_0_0 GoName_21_0_0, *PGoName_21_0_0;

struct GoName_21_0_0 {
    byte flags;
    struct GoVarlenString_1_20 name;
};

typedef struct GoName_15_0_0 GoName_15_0_0, *PGoName_15_0_0;

struct GoName_15_0_0 {
    byte flags;
    struct GoVarlenString_1_14 name;
};

typedef struct GoName_26_0_0 GoName_26_0_0, *PGoName_26_0_0;

struct GoName_26_0_0 {
    byte flags;
    struct GoVarlenString_1_25 name;
};

typedef struct GoName_50_0_0 GoName_50_0_0, *PGoName_50_0_0;

struct GoName_50_0_0 {
    byte flags;
    struct GoVarlenString_1_49 name;
};

typedef struct GoName_33_0_0 GoName_33_0_0, *PGoName_33_0_0;

struct GoName_33_0_0 {
    byte flags;
    struct GoVarlenString_1_32 name;
};

typedef struct GoName_59_0_0 GoName_59_0_0, *PGoName_59_0_0;

struct GoName_59_0_0 {
    byte flags;
    struct GoVarlenString_1_58 name;
};

typedef struct GoName_16_0_0 GoName_16_0_0, *PGoName_16_0_0;

struct GoName_16_0_0 {
    byte flags;
    struct GoVarlenString_1_15 name;
};

typedef struct GoName_22_0_0 GoName_22_0_0, *PGoName_22_0_0;

struct GoName_22_0_0 {
    byte flags;
    struct GoVarlenString_1_21 name;
};

typedef struct GoName_5_0_4 GoName_5_0_4, *PGoName_5_0_4;

struct GoName_5_0_4 {
    byte flags;
    struct GoVarlenString_1_4 name;
    int32 pkgPath;
};

typedef struct GoName_5_0_0 GoName_5_0_0, *PGoName_5_0_0;

struct GoName_5_0_0 {
    byte flags;
    struct GoVarlenString_1_4 name;
};

typedef struct _SYSTEM_INFO _SYSTEM_INFO, *P_SYSTEM_INFO;

typedef struct _SYSTEM_INFO *LPSYSTEM_INFO;

typedef union _union_552 _union_552, *P_union_552;

typedef ulong DWORD;

typedef void *LPVOID;

typedef ulonglong ULONG_PTR;

typedef ULONG_PTR DWORD_PTR;

typedef ushort WORD;

typedef struct _struct_553 _struct_553, *P_struct_553;

struct _struct_553 {
    WORD wProcessorArchitecture;
    WORD wReserved;
};

union _union_552 {
    DWORD dwOemId;
    struct _struct_553 s;
};

struct _SYSTEM_INFO {
    union _union_552 u;
    DWORD dwPageSize;
    LPVOID lpMinimumApplicationAddress;
    LPVOID lpMaximumApplicationAddress;
    DWORD_PTR dwActiveProcessorMask;
    DWORD dwNumberOfProcessors;
    DWORD dwProcessorType;
    DWORD dwAllocationGranularity;
    WORD wProcessorLevel;
    WORD wProcessorRevision;
};

typedef struct _OVERLAPPED _OVERLAPPED, *P_OVERLAPPED;

typedef union _union_540 _union_540, *P_union_540;

typedef void *HANDLE;

typedef struct _struct_541 _struct_541, *P_struct_541;

typedef void *PVOID;

struct _struct_541 {
    DWORD Offset;
    DWORD OffsetHigh;
};

union _union_540 {
    struct _struct_541 s;
    PVOID Pointer;
};

struct _OVERLAPPED {
    ULONG_PTR Internal;
    ULONG_PTR InternalHigh;
    union _union_540 u;
    HANDLE hEvent;
};

typedef struct _SECURITY_ATTRIBUTES _SECURITY_ATTRIBUTES, *P_SECURITY_ATTRIBUTES;

typedef int BOOL;

struct _SECURITY_ATTRIBUTES {
    DWORD nLength;
    LPVOID lpSecurityDescriptor;
    BOOL bInheritHandle;
};

typedef struct _OFSTRUCT _OFSTRUCT, *P_OFSTRUCT;

typedef uchar BYTE;

typedef char CHAR;

struct _OFSTRUCT {
    BYTE cBytes;
    BYTE fFixedDisk;
    WORD nErrCode;
    WORD Reserved1;
    WORD Reserved2;
    CHAR szPathName[128];
};

typedef struct _OVERLAPPED_ENTRY _OVERLAPPED_ENTRY, *P_OVERLAPPED_ENTRY;

typedef struct _OVERLAPPED *LPOVERLAPPED;

struct _OVERLAPPED_ENTRY {
    ULONG_PTR lpCompletionKey;
    LPOVERLAPPED lpOverlapped;
    ULONG_PTR Internal;
    DWORD dwNumberOfBytesTransferred;
};

typedef struct _OVERLAPPED_ENTRY *LPOVERLAPPED_ENTRY;

typedef DWORD (*PTHREAD_START_ROUTINE)(LPVOID);

typedef PTHREAD_START_ROUTINE LPTHREAD_START_ROUTINE;

typedef struct _SECURITY_ATTRIBUTES *LPSECURITY_ATTRIBUTES;

typedef struct _OFSTRUCT *LPOFSTRUCT;

typedef struct _CONTEXT _CONTEXT, *P_CONTEXT;

typedef struct _CONTEXT *PCONTEXT;

typedef PCONTEXT LPCONTEXT;

typedef ulonglong DWORD64;

typedef union _union_54 _union_54, *P_union_54;

typedef struct _M128A _M128A, *P_M128A;

typedef struct _M128A M128A;

typedef struct _XSAVE_FORMAT _XSAVE_FORMAT, *P_XSAVE_FORMAT;

typedef struct _XSAVE_FORMAT XSAVE_FORMAT;

typedef XSAVE_FORMAT XMM_SAVE_AREA32;

typedef struct _struct_55 _struct_55, *P_struct_55;

typedef ulonglong ULONGLONG;

typedef longlong LONGLONG;

struct _M128A {
    ULONGLONG Low;
    LONGLONG High;
};

struct _XSAVE_FORMAT {
    WORD ControlWord;
    WORD StatusWord;
    BYTE TagWord;
    BYTE Reserved1;
    WORD ErrorOpcode;
    DWORD ErrorOffset;
    WORD ErrorSelector;
    WORD Reserved2;
    DWORD DataOffset;
    WORD DataSelector;
    WORD Reserved3;
    DWORD MxCsr;
    DWORD MxCsr_Mask;
    M128A FloatRegisters[8];
    M128A XmmRegisters[16];
    BYTE Reserved4[96];
};

struct _struct_55 {
    M128A Header[2];
    M128A Legacy[8];
    M128A Xmm0;
    M128A Xmm1;
    M128A Xmm2;
    M128A Xmm3;
    M128A Xmm4;
    M128A Xmm5;
    M128A Xmm6;
    M128A Xmm7;
    M128A Xmm8;
    M128A Xmm9;
    M128A Xmm10;
    M128A Xmm11;
    M128A Xmm12;
    M128A Xmm13;
    M128A Xmm14;
    M128A Xmm15;
};

union _union_54 {
    XMM_SAVE_AREA32 FltSave;
    struct _struct_55 s;
};

struct _CONTEXT {
    DWORD64 P1Home;
    DWORD64 P2Home;
    DWORD64 P3Home;
    DWORD64 P4Home;
    DWORD64 P5Home;
    DWORD64 P6Home;
    DWORD ContextFlags;
    DWORD MxCsr;
    WORD SegCs;
    WORD SegDs;
    WORD SegEs;
    WORD SegFs;
    WORD SegGs;
    WORD SegSs;
    DWORD EFlags;
    DWORD64 Dr0;
    DWORD64 Dr1;
    DWORD64 Dr2;
    DWORD64 Dr3;
    DWORD64 Dr6;
    DWORD64 Dr7;
    DWORD64 Rax;
    DWORD64 Rcx;
    DWORD64 Rdx;
    DWORD64 Rbx;
    DWORD64 Rsp;
    DWORD64 Rbp;
    DWORD64 Rsi;
    DWORD64 Rdi;
    DWORD64 R8;
    DWORD64 R9;
    DWORD64 R10;
    DWORD64 R11;
    DWORD64 R12;
    DWORD64 R13;
    DWORD64 R14;
    DWORD64 R15;
    DWORD64 Rip;
    union _union_54 u;
    M128A VectorRegister[26];
    DWORD64 VectorControl;
    DWORD64 DebugControl;
    DWORD64 LastBranchToRip;
    DWORD64 LastBranchFromRip;
    DWORD64 LastExceptionToRip;
    DWORD64 LastExceptionFromRip;
};

typedef void (*PTIMERAPCROUTINE)(LPVOID, DWORD, DWORD);

typedef enum _EXCEPTION_DISPOSITION {
    ExceptionContinueExecution=0,
    ExceptionContinueSearch=1,
    ExceptionNestedException=2,
    ExceptionCollidedUnwind=3
} _EXCEPTION_DISPOSITION;

typedef struct _EXCEPTION_RECORD _EXCEPTION_RECORD, *P_EXCEPTION_RECORD;

struct _EXCEPTION_RECORD {
    DWORD ExceptionCode;
    DWORD ExceptionFlags;
    struct _EXCEPTION_RECORD *ExceptionRecord;
    PVOID ExceptionAddress;
    DWORD NumberParameters;
    ULONG_PTR ExceptionInformation[15];
};

typedef enum _EXCEPTION_DISPOSITION EXCEPTION_DISPOSITION;

typedef struct _EXCEPTION_POINTERS _EXCEPTION_POINTERS, *P_EXCEPTION_POINTERS;

typedef struct _EXCEPTION_RECORD EXCEPTION_RECORD;

typedef EXCEPTION_RECORD *PEXCEPTION_RECORD;

struct _EXCEPTION_POINTERS {
    PEXCEPTION_RECORD ExceptionRecord;
    PCONTEXT ContextRecord;
};

typedef BOOL (*PHANDLER_ROUTINE)(DWORD);

typedef ulonglong size_t;

typedef dword uint32;

typedef uint uintptr;

typedef byte runtime.limiterEventType;

typedef byte uint8;

typedef word uint16;

typedef byte encoding/hex.InvalidByteError;

typedef qword uint64;

typedef byte runtime.scavChunkFlags;

typedef undefined complex128[16];

typedef byte runtime.traceGoStopReason;

typedef byte runtime.spanClass;

typedef float8 float64;


// WARNING! conflicting data type names: /DWARF/uint - /uint

typedef int runtime.lockRank;

typedef byte runtime.waitReason;

typedef int runtime.profBufReadMode;

typedef int runtime.gcTriggerKind;

typedef uint runtime.chunkIdx;

typedef int internal/abi.ChanDir;

typedef uint runtime.puintptr;

typedef qword runtime.traceArg;

typedef float4 float32;

typedef sqword time.Duration;

typedef int runtime.selectDir;

typedef dword runtime.sweepClass;

typedef int runtime.gcMarkWorkerMode;

typedef qword runtime.hex;

typedef sdword internal/abi.NameOff;

typedef bool .param2;

typedef uint reflect.flag;

typedef byte runtime.traceEv;

typedef sbyte int8;

typedef sqword int64;

typedef int runtime.gcMode;

typedef int runtime.bucketType;

typedef dword io/fs.FileMode;

typedef byte internal/poll.fileKind;

typedef int reflect.abiStepKind;

typedef byte runtime.traceGoStatus;

typedef uint runtime.statDep;

typedef byte runtime.unwindFlags;

typedef uint runtime.muintptr;

typedef int reflect.SelectDir;

typedef int slices.sortedHint;

typedef byte runtime.spanAllocType;

typedef qword runtime.taggedPointer;

typedef uint runtime.guintptr;

typedef uint runtime.gclinkptr;

typedef uint internal/reflectlite.flag;

typedef int time.ruleKind;

typedef qword runtime.sysMemStat;

typedef uint syscall.Errno;

typedef byte runtime.boundsErrorCode;

typedef uint runtime.arenaIdx;

typedef dword internal/syscall/windows.TokenType;

typedef int time.Month;

typedef qword runtime.traceTime;

typedef qword runtime.lfstack;

typedef byte internal/abi.FuncFlag;

typedef dword runtime.pollInfo;

typedef qword runtime.pallocSum;

typedef byte internal/abi.FuncID;

typedef uint crypto.Hash;

typedef qword runtime.profIndex;

typedef int os.readdirMode;

typedef int internal/goarch.ArchFamilyType;

typedef int crypto/internal/boring.randReader;

typedef byte runtime.traceProcStatus;

typedef int runtime.gcDrainFlags;

typedef bool go.shape.bool;

typedef uint reflect.Kind;

typedef int runtime.abiPartKind;

typedef int reflect.ChanDir;

typedef sbyte bytes.readOp;

typedef byte runtime.stwReason;

typedef int sort.sortedHint;

typedef uint internal/abi.Kind;

typedef int runtime.metricKind;

typedef byte runtime.mSpanState;

typedef qword complex64;

typedef int syscall.Signal;

typedef qword runtime.headTailIndex;

typedef qword runtime.limiterEventStamp;

typedef byte runtime.traceBlockReason;

typedef sdword internal/abi.TypeOff;

typedef uint internal/syscall/windows/registry.Key;

typedef int time.Weekday;

typedef int runtime.semaProfileFlags;

typedef qword runtime.profAtomic;

typedef byte internal/abi.TFlag;

typedef uint syscall.Handle;

typedef dword runtime.throwType;

typedef sdword internal/abi.TextOff;

typedef dword runtime.goroutineProfileState;

typedef struct reflect.StructTag reflect.StructTag, *Preflect.StructTag;

struct reflect.StructTag {
    uint8 *str;
    int len;
};

typedef struct reflect.emptyInterface reflect.emptyInterface, *Preflect.emptyInterface;

typedef struct internal/abi.Type internal/abi.Type, *Pinternal/abi.Type;

struct reflect.emptyInterface {
    struct internal/abi.Type *typ;
    void *word;
};

struct internal/abi.Type {
    uintptr Size_;
    uintptr PtrBytes;
    uint32 Hash;
    internal/abi.TFlag TFlag;
    uint8 Align_;
    uint8 FieldAlign_;
    uint8 Kind_;
    void (**Equal)(void *, void *, bool *);
    uint8 *GCData;
    internal/abi.NameOff Str;
    internal/abi.TypeOff PtrToThis;
};

typedef struct []runtime.modulehash []runtime.modulehash, *P[]runtime.modulehash;

typedef struct runtime.modulehash runtime.modulehash, *Pruntime.modulehash;


// WARNING! conflicting data type names: /DWARF/_UNCATEGORIZED_/string - /string

struct []runtime.modulehash {
    struct runtime.modulehash *array;
    int len;
    int cap;
};

struct runtime.modulehash {
    struct string modulename;
    struct string linktimehash;
    struct string *runtimehash;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*fmt.pp;_X1_interface_{};_X2_int32_} noalg.struct_{_F_uintptr;_X0_*fmt.pp;_X1_interface_{};_X2_int32_}, *Pnoalg.struct_{_F_uintptr;_X0_*fmt.pp;_X1_interface_{};_X2_int32_};

typedef struct fmt.pp fmt.pp, *Pfmt.pp;

typedef struct runtime.eface runtime.eface, *Pruntime.eface;

typedef struct runtime.eface interface_{};

typedef struct fmt.buffer fmt.buffer, *Pfmt.buffer;

typedef struct reflect.Value reflect.Value, *Preflect.Value;

typedef struct fmt.fmt fmt.fmt, *Pfmt.fmt;

typedef struct []int []int, *P[]int;

typedef struct fmt.fmtFlags fmt.fmtFlags, *Pfmt.fmtFlags;

struct reflect.Value {
    struct internal/abi.Type *typ_;
    void *ptr;
    reflect.flag flag;
};

struct fmt.fmtFlags {
    bool widPresent;
    bool precPresent;
    bool minus;
    bool plus;
    bool sharp;
    bool space;
    bool zero;
    bool plusV;
    bool sharpV;
};

struct fmt.fmt {
    struct fmt.buffer *buf;
    struct fmt.fmtFlags fmtFlags;
    int wid;
    int prec;
    uint8 intbuf[68];
};

struct runtime.eface {
    struct internal/abi.Type *_type;
    void *data;
};

struct fmt.buffer {
    uint8 *array;
    int len;
    int cap;
};

struct []int {
    int *array;
    int len;
    int cap;
};

struct fmt.pp {
    struct fmt.buffer buf;
    interface_{} arg;
    struct reflect.Value value;
    struct fmt.fmt fmt;
    bool reordered;
    bool goodArgNum;
    bool panicking;
    bool erroring;
    bool wrapErrs;
    struct []int wrappedErrs;
};

struct noalg.struct_{_F_uintptr;_X0_*fmt.pp;_X1_interface_{};_X2_int32_} { // Original name: noalg.struct { F uintptr; X0 *fmt.pp; X1 interface {}; X2 int32 }
    uintptr F;
    struct fmt.pp *X0;
    interface_{} X1;
    int32 X2;
};

typedef struct strconv.mult128bitPow10_multivalue_return_type strconv.mult128bitPow10_multivalue_return_type, *Pstrconv.mult128bitPow10_multivalue_return_type;

struct strconv.mult128bitPow10_multivalue_return_type { // Artificial data type to hold a function's return values
    uint64 resM; // ordinal: 0
    int resE; // ordinal: 1
    bool exact; // ordinal: 2
};

typedef struct bucket<uint32,[]*internal/abi.Type> bucket<uint32,[]*internal/abi.Type>, *Pbucket<uint32,[]*internal/abi.Type>;

typedef struct []*internal/abi.Type []*internal/abi.Type, *P[]*internal/abi.Type;

struct []*internal/abi.Type {
    struct internal/abi.Type **array;
    int len;
    int cap;
};

struct bucket<uint32,[]*internal/abi.Type> {
    uint8 tophash[8];
    uint32 keys[8];
    struct []*internal/abi.Type values[8];
    struct bucket<uint32,[]*internal/abi.Type> *overflow;
};

typedef struct noalg.struct_{_F_uintptr;_X0_uint32_} noalg.struct_{_F_uintptr;_X0_uint32_}, *Pnoalg.struct_{_F_uintptr;_X0_uint32_};

struct noalg.struct_{_F_uintptr;_X0_uint32_} { // Original name: noalg.struct { F uintptr; X0 uint32 }
    uintptr F;
    uint32 X0;
};

typedef struct runtime.overlappedEntry runtime.overlappedEntry, *Pruntime.overlappedEntry;

typedef struct runtime.pollDesc runtime.pollDesc, *Pruntime.pollDesc;

typedef struct runtime.net_op runtime.net_op, *Pruntime.net_op;

typedef struct runtime/internal/sys.NotInHeap runtime/internal/sys.NotInHeap, *Pruntime/internal/sys.NotInHeap;

typedef struct runtime/internal/atomic.Uintptr runtime/internal/atomic.Uintptr, *Pruntime/internal/atomic.Uintptr;

typedef struct runtime/internal/atomic.Uint32 runtime/internal/atomic.Uint32, *Pruntime/internal/atomic.Uint32;

typedef struct runtime.mutex runtime.mutex, *Pruntime.mutex;

typedef struct runtime.timer runtime.timer, *Pruntime.timer;

typedef struct runtime.overlapped runtime.overlapped, *Pruntime.overlapped;

typedef struct runtime/internal/sys.nih runtime/internal/sys.nih, *Pruntime/internal/sys.nih;

typedef struct runtime/internal/atomic.noCopy runtime/internal/atomic.noCopy, *Pruntime/internal/atomic.noCopy;

typedef struct runtime.lockRankStruct runtime.lockRankStruct, *Pruntime.lockRankStruct;

struct runtime/internal/atomic.noCopy {
};

struct runtime/internal/atomic.Uint32 {
    struct runtime/internal/atomic.noCopy noCopy;
    uint32 value;
};

struct runtime.timer {
    runtime.puintptr pp;
    int64 when;
    int64 period;
    void (**f)(interface_{}, uintptr);
    interface_{} arg;
    uintptr seq;
    int64 nextwhen;
    struct runtime/internal/atomic.Uint32 status;
};

struct runtime.overlappedEntry {
    struct runtime.pollDesc *key;
    struct runtime.net_op *op;
    uintptr internal;
    uint32 qty;
};

struct runtime/internal/sys.nih {
};

struct runtime.overlapped {
    uintptr internal;
    uintptr internalhigh;
    uint8 anon0[8];
    uint8 *hevent;
};

struct runtime.net_op {
    struct runtime.overlapped o;
    struct runtime.pollDesc *pd;
    int32 mode;
    int32 errno;
    uint32 qty;
};

struct runtime/internal/atomic.Uintptr {
    struct runtime/internal/atomic.noCopy noCopy;
    uintptr value;
};

struct runtime.lockRankStruct {
};

struct runtime.mutex {
    struct runtime.lockRankStruct lockRankStruct;
    uintptr key;
};

struct runtime/internal/sys.NotInHeap {
    struct runtime/internal/sys.nih _;
};

struct runtime.pollDesc {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.pollDesc *link;
    uintptr fd;
    struct runtime/internal/atomic.Uintptr fdseq;
    struct runtime/internal/atomic.Uint32 atomicInfo;
    struct runtime/internal/atomic.Uintptr rg;
    struct runtime/internal/atomic.Uintptr wg;
    struct runtime.mutex lock;
    bool closing;
    uint32 user;
    uintptr rseq;
    struct runtime.timer rt;
    int64 rd;
    uintptr wseq;
    struct runtime.timer wt;
    int64 wd;
    struct runtime.pollDesc *self;
};

typedef struct hchan<bool> hchan<bool>, *Phchan<bool>;

typedef struct waitq<bool> waitq<bool>, *Pwaitq<bool>;

typedef struct sudog<bool> sudog<bool>, *Psudog<bool>;

typedef struct runtime.g runtime.g, *Pruntime.g;

typedef struct runtime.sudog runtime.sudog, *Pruntime.sudog;

typedef struct runtime.hchan runtime.hchan, *Pruntime.hchan;

typedef struct runtime.stack runtime.stack, *Pruntime.stack;

typedef struct runtime._panic runtime._panic, *Pruntime._panic;

typedef struct runtime._defer runtime._defer, *Pruntime._defer;

typedef struct runtime.m runtime.m, *Pruntime.m;

typedef struct runtime.gobuf runtime.gobuf, *Pruntime.gobuf;

typedef struct runtime/internal/atomic.Bool runtime/internal/atomic.Bool, *Pruntime/internal/atomic.Bool;

typedef struct []uint8 []uint8, *P[]uint8;

typedef struct []runtime.ancestorInfo []runtime.ancestorInfo, *P[]runtime.ancestorInfo;

typedef struct []uintptr []uintptr, *P[]uintptr;

typedef struct runtime.coro runtime.coro, *Pruntime.coro;

typedef struct runtime.goroutineProfileStateHolder runtime.goroutineProfileStateHolder, *Pruntime.goroutineProfileStateHolder;

typedef struct runtime.gTraceState runtime.gTraceState, *Pruntime.gTraceState;

typedef struct runtime.waitq runtime.waitq, *Pruntime.waitq;

typedef struct runtime/internal/atomic.Pointer[runtime._defer] runtime/internal/atomic.Pointer[runtime._defer], *Pruntime/internal/atomic.Pointer[runtime._defer];

typedef struct runtime.sigset runtime.sigset, *Pruntime.sigset;

typedef struct runtime.gsignalStack runtime.gsignalStack, *Pruntime.gsignalStack;

typedef uintptr runtime.cgoCallers[32];

typedef struct runtime.note runtime.note, *Pruntime.note;

typedef struct runtime.mLockProfile runtime.mLockProfile, *Pruntime.mLockProfile;

typedef struct runtime.mTraceState runtime.mTraceState, *Pruntime.mTraceState;

typedef struct runtime.libcall runtime.libcall, *Pruntime.libcall;

typedef struct runtime.pcvalueCache runtime.pcvalueCache, *Pruntime.pcvalueCache;

typedef struct runtime.dlogPerM runtime.dlogPerM, *Pruntime.dlogPerM;

typedef struct runtime.mOS runtime.mOS, *Pruntime.mOS;

typedef struct internal/chacha8rand.State internal/chacha8rand.State, *Pinternal/chacha8rand.State;

typedef struct runtime.heldLockInfo runtime.heldLockInfo, *Pruntime.heldLockInfo;

typedef struct runtime/internal/atomic.Uint8 runtime/internal/atomic.Uint8, *Pruntime/internal/atomic.Uint8;

typedef struct runtime.ancestorInfo runtime.ancestorInfo, *Pruntime.ancestorInfo;

typedef struct runtime.traceSchedResourceState runtime.traceSchedResourceState, *Pruntime.traceSchedResourceState;

typedef struct runtime/internal/atomic.UnsafePointer runtime/internal/atomic.UnsafePointer, *Pruntime/internal/atomic.UnsafePointer;

typedef struct runtime/internal/atomic.Int64 runtime/internal/atomic.Int64, *Pruntime/internal/atomic.Int64;

typedef struct runtime.traceBuf runtime.traceBuf, *Pruntime.traceBuf;

typedef struct runtime.pcvalueCacheEnt runtime.pcvalueCacheEnt, *Pruntime.pcvalueCacheEnt;

typedef struct runtime/internal/atomic.align64 runtime/internal/atomic.align64, *Pruntime/internal/atomic.align64;

typedef struct runtime.traceBufHeader runtime.traceBufHeader, *Pruntime.traceBufHeader;

struct runtime.heldLockInfo {
    uintptr lockAddr;
    runtime.lockRank rank;
};

struct runtime.goroutineProfileStateHolder {
    struct runtime/internal/atomic.noCopy noCopy;
    uint32 value;
};

struct runtime.traceSchedResourceState {
    struct runtime/internal/atomic.Uint32 statusTraced[3];
    uint64 seq[2];
};

struct runtime.gTraceState {
    struct runtime.traceSchedResourceState traceSchedResourceState;
};

struct waitq<bool> {
    struct sudog<bool> *first;
    struct sudog<bool> *last;
};

struct hchan<bool> {
    uint qcount;
    uint dataqsiz;
    void *buf;
    uint16 elemsize;
    uint32 closed;
    struct internal/abi.Type *elemtype;
    uint sendx;
    uint recvx;
    struct waitq<bool> recvq;
    struct waitq<bool> sendq;
    struct runtime.mutex lock;
};

struct runtime._panic {
    void *argp;
    interface_{} arg;
    struct runtime._panic *link;
    uintptr startPC;
    void *startSP;
    void *sp;
    uintptr lr;
    void *fp;
    uintptr retpc;
    uint8 *deferBitsPtr;
    void *slotsPtr;
    bool recovered;
    bool goexit;
    bool deferreturn;
};

struct runtime/internal/atomic.align64 {
};

struct runtime/internal/atomic.Int64 {
    struct runtime/internal/atomic.align64 _;
    struct runtime/internal/atomic.noCopy noCopy;
    int64 value;
};

struct runtime.mLockProfile {
    struct runtime/internal/atomic.Int64 waitTime;
    uintptr stack[32];
    uintptr pending;
    int64 cycles;
    int64 cyclesLost;
    bool disabled;
};

struct runtime.libcall {
    uintptr fn;
    uintptr n;
    uintptr args;
    uintptr r1;
    uintptr r2;
    uintptr err;
};

struct runtime.sigset {
};

struct runtime.gobuf {
    uintptr sp;
    uintptr pc;
    runtime.guintptr g;
    void *ctxt;
    uintptr ret;
    uintptr lr;
    uintptr bp;
};

struct runtime.waitq {
    struct runtime.sudog *first;
    struct runtime.sudog *last;
};

struct runtime/internal/atomic.UnsafePointer {
    struct runtime/internal/atomic.noCopy noCopy;
    void *value;
};

struct runtime/internal/atomic.Uint8 {
    struct runtime/internal/atomic.noCopy noCopy;
    uint8 value;
};

struct runtime/internal/atomic.Bool {
    struct runtime/internal/atomic.Uint8 u;
};

struct runtime.stack {
    uintptr lo;
    uintptr hi;
};

struct []uint8 {
    uint8 *array;
    int len;
    int cap;
};

struct runtime.mOS {
    struct runtime.mutex threadLock;
    uintptr thread;
    uintptr waitsema;
    uintptr resumesema;
    uintptr highResTimer;
    uint32 preemptExtLock;
};

struct runtime.mTraceState {
    struct runtime/internal/atomic.Uintptr seqlock;
    struct runtime.traceBuf *buf[2];
    struct runtime.m *link;
};

struct runtime.coro {
    runtime.guintptr gp;
    void (**f)(struct runtime.coro *);
};

struct runtime.dlogPerM {
};

struct []uintptr {
    uintptr *array;
    int len;
    int cap;
};

struct runtime.ancestorInfo {
    struct []uintptr pcs;
    uint64 goid;
    uintptr gopc;
};

struct runtime.gsignalStack {
};

struct runtime.pcvalueCacheEnt {
    uintptr targetpc;
    uint32 off;
    int32 val;
    uintptr valPC;
};

struct runtime.pcvalueCache {
    struct runtime.pcvalueCacheEnt entries[2][8];
    int inUse;
};

struct []runtime.ancestorInfo {
    struct runtime.ancestorInfo *array;
    int len;
    int cap;
};

struct runtime.sudog {
    struct runtime.g *g;
    struct runtime.sudog *next;
    struct runtime.sudog *prev;
    void *elem;
    int64 acquiretime;
    int64 releasetime;
    uint32 ticket;
    bool isSelect;
    bool success;
    uint16 waiters;
    struct runtime.sudog *parent;
    struct runtime.sudog *waitlink;
    struct runtime.sudog *waittail;
    struct runtime.hchan *c;
};

struct runtime.note {
    uintptr key;
};

struct runtime.traceBufHeader {
    struct runtime.traceBuf *link;
    runtime.traceTime lastTime;
    int pos;
    int lenPos;
};

struct runtime.traceBuf {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.traceBufHeader traceBufHeader;
    uint8 arr[65504];
};

struct runtime.hchan {
    uint qcount;
    uint dataqsiz;
    void *buf;
    uint16 elemsize;
    uint32 closed;
    struct internal/abi.Type *elemtype;
    uint sendx;
    uint recvx;
    struct runtime.waitq recvq;
    struct runtime.waitq sendq;
    struct runtime.mutex lock;
};

struct runtime._defer {
    bool heap;
    bool rangefunc;
    uintptr sp;
    uintptr pc;
    void (**fn)(void);
    struct runtime._defer *link;
    struct runtime/internal/atomic.Pointer[runtime._defer] *head;
};

struct internal/chacha8rand.State {
    uint64 buf[32];
    uint64 seed[4];
    uint32 i;
    uint32 n;
    uint32 c;
};

struct runtime.m {
    struct runtime.g *g0;
    struct runtime.gobuf morebuf;
    uint32 divmod;
    uint32 _;
    uint64 procid;
    struct runtime.g *gsignal;
    struct runtime.sigset sigmask;
    struct runtime.gsignalStack goSigStack;
    uintptr tls[6];
    void (**mstartfn)(void);
    struct runtime.g *curg;
    runtime.guintptr caughtsig;
    runtime.puintptr p;
    runtime.puintptr nextp;
    runtime.puintptr oldp;
    int64 id;
    int32 mallocing;
    runtime.throwType throwing;
    struct string preemptoff;
    int32 locks;
    int32 dying;
    int32 profilehz;
    bool spinning;
    bool blocked;
    bool newSigstack;
    int8 printlock;
    bool incgo;
    bool isextra;
    bool isExtraInC;
    bool isExtraInSig;
    struct runtime/internal/atomic.Uint32 freeWait;
    bool needextram;
    uint8 traceback;
    uint64 ncgocall;
    int32 ncgo;
    struct runtime/internal/atomic.Uint32 cgoCallersUse;
    runtime.cgoCallers *cgoCallers;
    struct runtime.note park;
    struct runtime.m *alllink;
    runtime.muintptr schedlink;
    runtime.guintptr lockedg;
    uintptr createstack[32];
    uint32 lockedExt;
    uint32 lockedInt;
    runtime.muintptr nextwaitm;
    struct runtime.mLockProfile mLockProfile;
    void (**waitunlockf)(struct runtime.g *, void *, bool *);
    void *waitlock;
    runtime.traceBlockReason waitTraceBlockReason;
    int waitTraceSkip;
    uint32 syscalltick;
    struct runtime.m *freelink;
    struct runtime.mTraceState trace;
    struct runtime.libcall libcall;
    uintptr libcallpc;
    uintptr libcallsp;
    runtime.guintptr libcallg;
    struct runtime.libcall syscall;
    uintptr vdsoSP;
    uintptr vdsoPC;
    struct runtime/internal/atomic.Uint32 preemptGen;
    struct runtime/internal/atomic.Uint32 signalPending;
    struct runtime.pcvalueCache pcvalueCache;
    struct runtime.dlogPerM dlogPerM;
    struct runtime.mOS mOS;
    struct internal/chacha8rand.State chacha8;
    uint64 cheaprand;
    int locksHeldLen;
    struct runtime.heldLockInfo locksHeld[10];
};

struct runtime.g {
    struct runtime.stack stack;
    uintptr stackguard0;
    uintptr stackguard1;
    struct runtime._panic *_panic;
    struct runtime._defer *_defer;
    struct runtime.m *m;
    struct runtime.gobuf sched;
    uintptr syscallsp;
    uintptr syscallpc;
    uintptr stktopsp;
    void *param;
    struct runtime/internal/atomic.Uint32 atomicstatus;
    uint32 stackLock;
    uint64 goid;
    runtime.guintptr schedlink;
    int64 waitsince;
    runtime.waitReason waitreason;
    bool preempt;
    bool preemptStop;
    bool preemptShrink;
    bool asyncSafePoint;
    bool paniconfault;
    bool gcscandone;
    bool throwsplit;
    bool activeStackChans;
    struct runtime/internal/atomic.Bool parkingOnChan;
    bool inMarkAssist;
    bool coroexit;
    int8 raceignore;
    bool nocgocallback;
    bool tracking;
    uint8 trackingSeq;
    int64 trackingStamp;
    int64 runnableTime;
    runtime.muintptr lockedm;
    uint32 sig;
    struct []uint8 writebuf;
    uintptr sigcode0;
    uintptr sigcode1;
    uintptr sigpc;
    uint64 parentGoid;
    uintptr gopc;
    struct []runtime.ancestorInfo *ancestors;
    uintptr startpc;
    uintptr racectx;
    struct runtime.sudog *waiting;
    struct []uintptr cgoCtxt;
    void *labels;
    struct runtime.timer *timer;
    struct runtime/internal/atomic.Uint32 selectDone;
    struct runtime.coro *coroarg;
    struct runtime.goroutineProfileStateHolder goroutineProfiled;
    struct runtime.gTraceState trace;
    int64 gcAssistBytes;
};

struct runtime/internal/atomic.Pointer[runtime._defer] {
    struct runtime/internal/atomic.UnsafePointer u;
};

struct sudog<bool> {
    struct runtime.g *g;
    struct runtime.sudog *next;
    struct runtime.sudog *prev;
    bool *elem;
    int64 acquiretime;
    int64 releasetime;
    uint32 ticket;
    bool isSelect;
    bool success;
    uint16 waiters;
    struct runtime.sudog *parent;
    struct runtime.sudog *waitlink;
    struct runtime.sudog *waittail;
    struct runtime.hchan *c;
};

typedef struct sync.Once sync.Once, *Psync.Once;

typedef struct sync/atomic.Uint32 sync/atomic.Uint32, *Psync/atomic.Uint32;

typedef struct sync.Mutex sync.Mutex, *Psync.Mutex;

typedef struct sync/atomic.noCopy sync/atomic.noCopy, *Psync/atomic.noCopy;

struct sync.Mutex {
    int32 state;
    uint32 sema;
};

struct sync/atomic.noCopy {
};

struct sync/atomic.Uint32 {
    struct sync/atomic.noCopy _;
    uint32 v;
};

struct sync.Once {
    struct sync/atomic.Uint32 done;
    struct sync.Mutex m;
};

typedef struct runtime.specialprofile runtime.specialprofile, *Pruntime.specialprofile;

typedef struct runtime.special runtime.special, *Pruntime.special;

typedef struct runtime.bucket runtime.bucket, *Pruntime.bucket;

struct runtime.special {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.special *next;
    uint16 offset;
    uint8 kind;
};

struct runtime.specialprofile {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.special special;
    struct runtime.bucket *b;
};

struct runtime.bucket {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.bucket *next;
    struct runtime.bucket *allnext;
    runtime.bucketType typ;
    uintptr hash;
    uintptr size;
    uintptr nstk;
};

typedef struct syscall.WSAProtocolInfo syscall.WSAProtocolInfo, *Psyscall.WSAProtocolInfo;

typedef struct syscall.GUID syscall.GUID, *Psyscall.GUID;

typedef struct syscall.WSAProtocolChain syscall.WSAProtocolChain, *Psyscall.WSAProtocolChain;

struct syscall.WSAProtocolChain {
    int32 ChainLen;
    uint32 ChainEntries[7];
};

struct syscall.GUID {
    uint32 Data1;
    uint16 Data2;
    uint16 Data3;
    uint8 Data4[8];
};

struct syscall.WSAProtocolInfo {
    uint32 ServiceFlags1;
    uint32 ServiceFlags2;
    uint32 ServiceFlags3;
    uint32 ServiceFlags4;
    uint32 ProviderFlags;
    struct syscall.GUID ProviderId;
    uint32 CatalogEntryId;
    struct syscall.WSAProtocolChain ProtocolChain;
    int32 Version;
    int32 AddressFamily;
    int32 MaxSockAddr;
    int32 MinSockAddr;
    int32 SocketType;
    int32 Protocol;
    int32 ProtocolMaxOffset;
    int32 NetworkByteOrder;
    int32 SecurityScheme;
    uint32 MessageSize;
    uint32 ProviderReserved;
    uint16 ProtocolName[256];
};

typedef struct bucket<unsafe.Pointer,int32> bucket<unsafe.Pointer,int32>, *Pbucket<unsafe.Pointer,int32>;

struct bucket<unsafe.Pointer,int32> {
    uint8 tophash[8];
    void *keys[8];
    int32 values[8];
    struct bucket<unsafe.Pointer,int32> *overflow;
};

typedef struct runtime.exitHook runtime.exitHook, *Pruntime.exitHook;

struct runtime.exitHook {
    void (**f)(void);
    bool runOnNonZeroExit;
};

typedef struct struct_{_runtime.base_runtime.offAddr;_runtime.bound_runtime.offAddr_} struct_{_runtime.base_runtime.offAddr;_runtime.bound_runtime.offAddr_}, *Pstruct_{_runtime.base_runtime.offAddr;_runtime.bound_runtime.offAddr_};

typedef struct runtime.offAddr runtime.offAddr, *Pruntime.offAddr;

struct runtime.offAddr {
    uintptr a;
};

struct struct_{_runtime.base_runtime.offAddr;_runtime.bound_runtime.offAddr_} { // Original name: struct { runtime.base runtime.offAddr; runtime.bound runtime.offAddr }
    struct runtime.offAddr base;
    struct runtime.offAddr bound;
};

typedef struct internal/abi.StructField internal/abi.StructField, *Pinternal/abi.StructField;

typedef struct internal/abi.Name internal/abi.Name, *Pinternal/abi.Name;

struct internal/abi.Name {
    uint8 *Bytes;
};

struct internal/abi.StructField {
    struct internal/abi.Name Name;
    struct internal/abi.Type *Typ;
    uintptr Offset;
};

typedef struct runtime.inlineUnwinder runtime.inlineUnwinder, *Pruntime.inlineUnwinder;

typedef struct runtime.funcInfo runtime.funcInfo, *Pruntime.funcInfo;

typedef struct runtime.inlinedCall runtime.inlinedCall, *Pruntime.inlinedCall;

typedef struct runtime._func runtime._func, *Pruntime._func;

typedef struct runtime.moduledata runtime.moduledata, *Pruntime.moduledata;

typedef struct runtime.pcHeader runtime.pcHeader, *Pruntime.pcHeader;

typedef struct []uint32 []uint32, *P[]uint32;

typedef struct []runtime.functab []runtime.functab, *P[]runtime.functab;

typedef struct []runtime.textsect []runtime.textsect, *P[]runtime.textsect;

typedef struct []int32 []int32, *P[]int32;

typedef struct []*runtime.itab []*runtime.itab, *P[]*runtime.itab;

typedef struct []runtime.ptabEntry []runtime.ptabEntry, *P[]runtime.ptabEntry;

typedef struct []*runtime.initTask []*runtime.initTask, *P[]*runtime.initTask;

typedef struct runtime.bitvector runtime.bitvector, *Pruntime.bitvector;

typedef struct hash<internal/abi.TypeOff,*internal/abi.Type> hash<internal/abi.TypeOff,*internal/abi.Type>, *Phash<internal/abi.TypeOff,*internal/abi.Type>;

typedef struct hash<internal/abi.TypeOff,*internal/abi.Type> *map[internal/abi.TypeOff]*internal/abi.Type;

typedef struct runtime.functab runtime.functab, *Pruntime.functab;

typedef struct runtime.textsect runtime.textsect, *Pruntime.textsect;

typedef struct runtime.itab runtime.itab, *Pruntime.itab;

typedef struct runtime.ptabEntry runtime.ptabEntry, *Pruntime.ptabEntry;

typedef struct runtime.initTask runtime.initTask, *Pruntime.initTask;

typedef struct bucket<internal/abi.TypeOff,*internal/abi.Type> bucket<internal/abi.TypeOff,*internal/abi.Type>, *Pbucket<internal/abi.TypeOff,*internal/abi.Type>;

typedef struct runtime.mapextra runtime.mapextra, *Pruntime.mapextra;

typedef struct internal/abi.InterfaceType internal/abi.InterfaceType, *Pinternal/abi.InterfaceType;

typedef struct []*runtime.bmap []*runtime.bmap, *P[]*runtime.bmap;

typedef struct runtime.bmap runtime.bmap, *Pruntime.bmap;

typedef struct []internal/abi.Imethod []internal/abi.Imethod, *P[]internal/abi.Imethod;

typedef struct internal/abi.Imethod internal/abi.Imethod, *Pinternal/abi.Imethod;

struct []internal/abi.Imethod {
    struct internal/abi.Imethod *array;
    int len;
    int cap;
};

struct internal/abi.InterfaceType {
    struct internal/abi.Type Type;
    struct internal/abi.Name PkgPath;
    struct []internal/abi.Imethod Methods;
};

struct runtime.itab {
    struct internal/abi.InterfaceType *inter;
    struct internal/abi.Type *_type;
    uint32 hash;
    uint8 _[4];
    uintptr fun[1];
};

struct runtime._func {
    struct runtime/internal/sys.NotInHeap NotInHeap;
    uint32 entryOff;
    int32 nameOff;
    int32 args;
    uint32 deferreturn;
    uint32 pcsp;
    uint32 pcfile;
    uint32 pcln;
    uint32 npcdata;
    uint32 cuOffset;
    int32 startLine;
    internal/abi.FuncID funcID;
    internal/abi.FuncFlag flag;
    uint8 _[1];
    uint8 nfuncdata;
};

struct []uint32 {
    uint32 *array;
    int len;
    int cap;
};

struct []*runtime.initTask {
    struct runtime.initTask **array;
    int len;
    int cap;
};

struct internal/abi.Imethod {
    internal/abi.NameOff Name;
    internal/abi.TypeOff Typ;
};

struct runtime.funcInfo {
    struct runtime._func *_func;
    struct runtime.moduledata *datap;
};

struct []*runtime.itab {
    struct runtime.itab **array;
    int len;
    int cap;
};

struct []runtime.textsect {
    struct runtime.textsect *array;
    int len;
    int cap;
};

struct runtime.textsect {
    uintptr vaddr;
    uintptr end;
    uintptr baseaddr;
};

struct runtime.initTask {
    uint32 state;
    uint32 nfns;
};

struct runtime.ptabEntry {
    internal/abi.NameOff name;
    internal/abi.TypeOff typ;
};

struct runtime.bitvector {
    int32 n;
    uint8 *bytedata;
};

struct bucket<internal/abi.TypeOff,*internal/abi.Type> {
    uint8 tophash[8];
    internal/abi.TypeOff keys[8];
    struct internal/abi.Type *values[8];
    struct bucket<internal/abi.TypeOff,*internal/abi.Type> *overflow;
};

struct runtime.pcHeader {
    uint32 magic;
    uint8 pad1;
    uint8 pad2;
    uint8 minLC;
    uint8 ptrSize;
    int nfunc;
    uint nfiles;
    uintptr textStart;
    uintptr funcnameOffset;
    uintptr cuOffset;
    uintptr filetabOffset;
    uintptr pctabOffset;
    uintptr pclnOffset;
};

struct hash<internal/abi.TypeOff,*internal/abi.Type> {
    int count;
    uint8 flags;
    uint8 B;
    uint16 noverflow;
    uint32 hash0;
    struct bucket<internal/abi.TypeOff,*internal/abi.Type> *buckets;
    struct bucket<internal/abi.TypeOff,*internal/abi.Type> *oldbuckets;
    uintptr nevacuate;
    struct runtime.mapextra *extra;
};

struct []runtime.functab {
    struct runtime.functab *array;
    int len;
    int cap;
};

struct []runtime.ptabEntry {
    struct runtime.ptabEntry *array;
    int len;
    int cap;
};

struct []int32 {
    int32 *array;
    int len;
    int cap;
};

struct runtime.moduledata {
    struct runtime/internal/sys.NotInHeap NotInHeap;
    struct runtime.pcHeader *pcHeader;
    struct []uint8 funcnametab;
    struct []uint32 cutab;
    struct []uint8 filetab;
    struct []uint8 pctab;
    struct []uint8 pclntable;
    struct []runtime.functab ftab;
    uintptr findfunctab;
    uintptr minpc;
    uintptr maxpc;
    uintptr text;
    uintptr etext;
    uintptr noptrdata;
    uintptr enoptrdata;
    uintptr data;
    uintptr edata;
    uintptr bss;
    uintptr ebss;
    uintptr noptrbss;
    uintptr enoptrbss;
    uintptr covctrs;
    uintptr ecovctrs;
    uintptr end;
    uintptr gcdata;
    uintptr gcbss;
    uintptr types;
    uintptr etypes;
    uintptr rodata;
    uintptr gofunc;
    struct []runtime.textsect textsectmap;
    struct []int32 typelinks;
    struct []*runtime.itab itablinks;
    struct []runtime.ptabEntry ptab;
    struct string pluginpath;
    struct []runtime.modulehash pkghashes;
    struct []*runtime.initTask inittasks;
    struct string modulename;
    struct []runtime.modulehash modulehashes;
    uint8 hasmain;
    struct runtime.bitvector gcdatamask;
    struct runtime.bitvector gcbssmask;
    map[internal/abi.TypeOff]*internal/abi.Type typemap;
    bool bad;
    struct runtime.moduledata *next;
};

struct runtime.mapextra {
    struct []*runtime.bmap *overflow;
    struct []*runtime.bmap *oldoverflow;
    struct runtime.bmap *nextOverflow;
};

struct []*runtime.bmap {
    struct runtime.bmap **array;
    int len;
    int cap;
};

struct runtime.bmap {
    uint8 tophash[8];
};

struct runtime.inlineUnwinder {
    struct runtime.funcInfo f;
    struct runtime.inlinedCall (*inlTree)[1048576];
};

struct runtime.inlinedCall {
    internal/abi.FuncID funcID;
    uint8 _[3];
    int32 nameOff;
    int32 parentPc;
    int32 startLine;
};

struct runtime.functab {
    uint32 entryoff;
    uint32 funcoff;
};

typedef struct golang.org/x/crypto/chacha20poly1305.xchacha20poly1305 golang.org/x/crypto/chacha20poly1305.xchacha20poly1305, *Pgolang.org/x/crypto/chacha20poly1305.xchacha20poly1305;

struct golang.org/x/crypto/chacha20poly1305.xchacha20poly1305 {
    uint8 key[32];
};

typedef struct runtime.(*pallocBits).find_multivalue_return_type runtime.(*pallocBits).find_multivalue_return_type, *Pruntime.(*pallocBits).find_multivalue_return_type;

struct runtime.(*pallocBits).find_multivalue_return_type { // Artificial data type to hold a function's return values
    uint ~r0; // ordinal: 0
    uint ~r1; // ordinal: 1
};

typedef struct runtime.heapArena runtime.heapArena, *Pruntime.heapArena;

typedef struct runtime.heapArenaPtrScalar runtime.heapArenaPtrScalar, *Pruntime.heapArenaPtrScalar;

typedef struct runtime.mspan runtime.mspan, *Pruntime.mspan;

typedef struct runtime.checkmarksMap runtime.checkmarksMap, *Pruntime.checkmarksMap;

typedef struct runtime.mSpanList runtime.mSpanList, *Pruntime.mSpanList;

typedef struct runtime.gcBits runtime.gcBits, *Pruntime.gcBits;

typedef struct runtime.mSpanStateBox runtime.mSpanStateBox, *Pruntime.mSpanStateBox;

typedef struct runtime.addrRange runtime.addrRange, *Pruntime.addrRange;

struct runtime.checkmarksMap {
    struct runtime/internal/sys.NotInHeap _;
    uint8 b[65536];
};

struct runtime.mSpanList {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.mspan *first;
    struct runtime.mspan *last;
};

struct runtime.addrRange {
    struct runtime.offAddr base;
    struct runtime.offAddr limit;
};

struct runtime.heapArenaPtrScalar {
};

struct runtime.heapArena {
    struct runtime.heapArenaPtrScalar heapArenaPtrScalar;
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.mspan *spans[512];
    uint8 pageInUse[64];
    uint8 pageMarks[64];
    uint8 pageSpecials[64];
    struct runtime.checkmarksMap *checkmarks;
    uintptr zeroedBase;
};

struct runtime.mSpanStateBox {
    struct runtime/internal/atomic.Uint8 s;
};

struct runtime.mspan {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.mspan *next;
    struct runtime.mspan *prev;
    struct runtime.mSpanList *list;
    uintptr startAddr;
    uintptr npages;
    runtime.gclinkptr manualFreeList;
    uint16 freeindex;
    uint16 nelems;
    uint16 freeIndexForScan;
    uint64 allocCache;
    struct runtime.gcBits *allocBits;
    struct runtime.gcBits *gcmarkBits;
    struct runtime.gcBits *pinnerBits;
    uint32 sweepgen;
    uint32 divMul;
    uint16 allocCount;
    runtime.spanClass spanclass;
    struct runtime.mSpanStateBox state;
    uint8 needzero;
    bool isUserArenaChunk;
    uint16 allocCountBeforeCache;
    uintptr elemsize;
    uintptr limit;
    struct runtime.mutex speciallock;
    struct runtime.special *specials;
    struct runtime.addrRange userArenaChunkFree;
    struct internal/abi.Type *largeType;
};

struct runtime.gcBits {
    struct runtime/internal/sys.NotInHeap _;
    uint8 x;
};

typedef struct runtime.dbgVar runtime.dbgVar, *Pruntime.dbgVar;

typedef struct runtime/internal/atomic.Int32 runtime/internal/atomic.Int32, *Pruntime/internal/atomic.Int32;

struct runtime.dbgVar {
    struct string name;
    int32 *value;
    struct runtime/internal/atomic.Int32 *atomic;
    int32 def;
};

struct runtime/internal/atomic.Int32 {
    struct runtime/internal/atomic.noCopy noCopy;
    int32 value;
};

typedef struct runtime.stackObject runtime.stackObject, *Pruntime.stackObject;

typedef struct runtime.stackObjectRecord runtime.stackObjectRecord, *Pruntime.stackObjectRecord;

struct runtime.stackObject {
    struct runtime/internal/sys.NotInHeap _;
    uint32 off;
    uint32 size;
    struct runtime.stackObjectRecord *r;
    struct runtime.stackObject *left;
    struct runtime.stackObject *right;
};

struct runtime.stackObjectRecord {
    int32 off;
    int32 size;
    int32 _ptrdata;
    uint32 gcdataoff;
};

typedef struct runtime.traceRegionAllocBlock runtime.traceRegionAllocBlock, *Pruntime.traceRegionAllocBlock;

struct runtime.traceRegionAllocBlock {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.traceRegionAllocBlock *next;
    uint8 data[65528];
};

typedef struct internal/poll.errNetClosing internal/poll.errNetClosing, *Pinternal/poll.errNetClosing;

struct internal/poll.errNetClosing {
};

typedef struct runtime.iface runtime.iface, *Pruntime.iface;

typedef struct runtime.iface math/rand/v2.Source;

struct runtime.iface {
    struct runtime.itab *tab;
    void *data;
};

typedef struct runtime.stackObjectBuf runtime.stackObjectBuf, *Pruntime.stackObjectBuf;

typedef struct runtime.stackObjectBufHdr runtime.stackObjectBufHdr, *Pruntime.stackObjectBufHdr;

typedef struct runtime.workbufhdr runtime.workbufhdr, *Pruntime.workbufhdr;

typedef struct runtime.lfnode runtime.lfnode, *Pruntime.lfnode;

struct runtime.lfnode {
    uint64 next;
    uintptr pushcnt;
};

struct runtime.workbufhdr {
    struct runtime.lfnode node;
    int nobj;
};

struct runtime.stackObjectBufHdr {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.workbufhdr workbufhdr;
    struct runtime.stackObjectBuf *next;
};

struct runtime.stackObjectBuf {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.stackObjectBufHdr stackObjectBufHdr;
    struct runtime.stackObject obj[63];
};

typedef struct runtime.addrRanges runtime.addrRanges, *Pruntime.addrRanges;

typedef struct []runtime.addrRange []runtime.addrRange, *P[]runtime.addrRange;

struct []runtime.addrRange {
    struct runtime.addrRange *array;
    int len;
    int cap;
};

struct runtime.addrRanges {
    struct []runtime.addrRange ranges;
    uintptr totalBytes;
    runtime.sysMemStat *sysStat;
};

typedef struct runtime.markBits runtime.markBits, *Pruntime.markBits;

struct runtime.markBits {
    uint8 *bytep;
    uint8 mask;
    uintptr index;
};

typedef struct syscall.Filetime syscall.Filetime, *Psyscall.Filetime;

struct syscall.Filetime {
    uint32 LowDateTime;
    uint32 HighDateTime;
};

typedef struct noalg.struct_{_F_uintptr;_X0_int64;_X1_runtime.worldStop_} noalg.struct_{_F_uintptr;_X0_int64;_X1_runtime.worldStop_}, *Pnoalg.struct_{_F_uintptr;_X0_int64;_X1_runtime.worldStop_};

typedef struct runtime.worldStop runtime.worldStop, *Pruntime.worldStop;

struct runtime.worldStop {
    runtime.stwReason reason;
    int64 start;
};

struct noalg.struct_{_F_uintptr;_X0_int64;_X1_runtime.worldStop_} { // Original name: noalg.struct { F uintptr; X0 int64; X1 runtime.worldStop }
    uintptr F;
    int64 X0;
    struct runtime.worldStop X1;
};

typedef struct runtime.m128a runtime.m128a, *Pruntime.m128a;

struct runtime.m128a {
    uint64 low;
    int64 high;
};

typedef struct runtime.cgoSymbolizerArg runtime.cgoSymbolizerArg, *Pruntime.cgoSymbolizerArg;

struct runtime.cgoSymbolizerArg {
    uintptr pc;
    uint8 *file;
    uintptr lineno;
    uint8 *funcName;
    uintptr entry;
    uintptr more;
    uintptr data;
};

typedef struct struct_{_runtime.gList;_runtime.n_int32_} struct_{_runtime.gList;_runtime.n_int32_}, *Pstruct_{_runtime.gList;_runtime.n_int32_};

typedef struct runtime.gList runtime.gList, *Pruntime.gList;

struct runtime.gList {
    runtime.guintptr head;
};

struct struct_{_runtime.gList;_runtime.n_int32_} { // Original name: struct { runtime.gList; runtime.n int32 }
    struct runtime.gList gList;
    int32 n;
};

typedef struct encoding/binary.bigEndian encoding/binary.bigEndian, *Pencoding/binary.bigEndian;

struct encoding/binary.bigEndian {
};

typedef struct []runtime.pallocSum []runtime.pallocSum, *P[]runtime.pallocSum;

struct []runtime.pallocSum {
    runtime.pallocSum *array;
    int len;
    int cap;
};

typedef struct runtime/internal/atomic.Pointer[go.shape.string] runtime/internal/atomic.Pointer[go.shape.string], *Pruntime/internal/atomic.Pointer[go.shape.string];

struct runtime/internal/atomic.Pointer[go.shape.string] {
    struct runtime/internal/atomic.UnsafePointer u;
};

typedef struct hash<uint32,[]*internal/abi.Type> hash<uint32,[]*internal/abi.Type>, *Phash<uint32,[]*internal/abi.Type>;

typedef struct hash<uint32,[]*internal/abi.Type> *map[uint32][]*internal/abi.Type;

struct hash<uint32,[]*internal/abi.Type> {
    int count;
    uint8 flags;
    uint8 B;
    uint16 noverflow;
    uint32 hash0;
    struct bucket<uint32,[]*internal/abi.Type> *buckets;
    struct bucket<uint32,[]*internal/abi.Type> *oldbuckets;
    uintptr nevacuate;
    struct runtime.mapextra *extra;
};

typedef struct runtime.gcBitsArena runtime.gcBitsArena, *Pruntime.gcBitsArena;

struct runtime.gcBitsArena {
    struct runtime/internal/sys.NotInHeap _;
    uintptr free;
    struct runtime.gcBitsArena *next;
    struct runtime.gcBits bits[65520];
};

typedef struct noalg.struct_{_F_uintptr;_R_*runtime.itabTableType_} noalg.struct_{_F_uintptr;_R_*runtime.itabTableType_}, *Pnoalg.struct_{_F_uintptr;_R_*runtime.itabTableType_};

typedef struct runtime.itabTableType runtime.itabTableType, *Pruntime.itabTableType;

struct noalg.struct_{_F_uintptr;_R_*runtime.itabTableType_} { // Original name: noalg.struct { F uintptr; R *runtime.itabTableType }
    uintptr F;
    struct runtime.itabTableType *R;
};

struct runtime.itabTableType {
    uintptr size;
    uintptr count;
    struct runtime.itab *entries[512];
};

typedef struct encoding/base64.Encoding encoding/base64.Encoding, *Pencoding/base64.Encoding;

struct encoding/base64.Encoding {
    uint8 encode[64];
    uint8 decodeMap[256];
    int32 padChar;
    bool strict;
};

typedef struct struct_{_runtime.cgocheck_int32;_runtime.clobberfree_int32;_runtime.disablethp_int32;_runtime.dontfreezetheworld_int32;_runtime.efence_int32;_runtime.gccheckmark_int32;_runtime.gcpacertrace_int32;_runtime.gcshrinkstackoff_int32;_runtime.gcstoptheworld_int32;_runtime.gctrace_int32;_runtime.invalidptr_int32;_runtime.madvdontneed_int32;_runtime.runtimeContentionStacks_runtime/internal/atomic.Int32;_runtime.scavtrace_int32;_runtime.scheddetail_int32;_runtime.schedtrace_int32;_runtime.tracebackancestors_int32;_runtime.asyncpreemptoff_int32;_runtime.harddecommit_int32;_runtime.adaptivestackstart_int32;_runtime.tracefpunwindoff_int32;_runtime.traceadvanceperiod_int32;_runtime.malloc_bool;_runtime.allocfreetrace_int32;_runtime.inittrace_int32;_runtime.sbrk_int32;_runtime.panicnil_runtime/internal/atomic.Int32_} struct_{_runtime.cgocheck_int32;_runtime.clobberfree_int32;_runtime.disablethp_int32;_runtime.dontfreezetheworld_int32;_runtime.efence_int32;_runtime.gccheckmark_int32;_runtime.gcpacertrace_int32;_runtime.gcshrinkstackoff_int32;_runtime.gcstoptheworld_int32;_runtime.gctrace_int32;_runtime.invalidptr_int32;_runtime.madvdontneed_int32;_runtime.runtimeContentionStacks_runtime/internal/atomic.Int32;_runtime.scavtrace_int32;_runtime.scheddetail_int32;_runtime.schedtrace_int32;_runtime.tracebackancestors_int32;_runtime.asyncpreemptoff_int32;_runtime.harddecommit_int32;_runtime.adaptivestackstart_int32;_runtime.tracefpunwindoff_int32;_runtime.traceadvanceperiod_int32;_runtime.malloc_bool;_runtime.allocfreetrace_int32;_runtime.inittrace_int32;_runtime.sbrk_int32;_runtime.panicnil_runtime/internal/atomic.Int32_}, *Pstruct_{_runtime.cgocheck_int32;_runtime.clobberfree_int32;_runtime.disablethp_int32;_runtime.dontfreezetheworld_int32;_runtime.efence_int32;_runtime.gccheckmark_int32;_runtime.gcpacertrace_int32;_runtime.gcshrinkstackoff_int32;_runtime.gcstoptheworld_int32;_runtime.gctrace_int32;_runtime.invalidptr_int32;_runtime.madvdontneed_int32;_runtime.runtimeContentionStacks_runtime/internal/atomic.Int32;_runtime.scavtrace_int32;_runtime.scheddetail_int32;_runtime.schedtrace_int32;_runtime.tracebackancestors_int32;_runtime.asyncpreemptoff_int32;_runtime.harddecommit_int32;_runtime.adaptivestackstart_int32;_runtime.tracefpunwindoff_int32;_runtime.traceadvanceperiod_int32;_runtime.malloc_bool;_runtime.allocfreetrace_int32;_runtime.inittrace_int32;_runtime.sbrk_int32;_runtime.panicnil_runtime/internal/atomic.Int32_};

struct struct_{_runtime.cgocheck_int32;_runtime.clobberfree_int32;_runtime.disablethp_int32;_runtime.dontfreezetheworld_int32;_runtime.efence_int32;_runtime.gccheckmark_int32;_runtime.gcpacertrace_int32;_runtime.gcshrinkstackoff_int32;_runtime.gcstoptheworld_int32;_runtime.gctrace_int32;_runtime.invalidptr_int32;_runtime.madvdontneed_int32;_runtime.runtimeContentionStacks_runtime/internal/atomic.Int32;_runtime.scavtrace_int32;_runtime.scheddetail_int32;_runtime.schedtrace_int32;_runtime.tracebackancestors_int32;_runtime.asyncpreemptoff_int32;_runtime.harddecommit_int32;_runtime.adaptivestackstart_int32;_runtime.tracefpunwindoff_int32;_runtime.traceadvanceperiod_int32;_runtime.malloc_bool;_runtime.allocfreetrace_int32;_runtime.inittrace_int32;_runtime.sbrk_int32;_runtime.panicnil_runtime/internal/atomic.Int32_} { // Original name: struct { runtime.cgocheck int32; runtime.clobberfree int32; runtime.disablethp int32; runtime.dontfreezetheworld int32; runtime.efence int32; runtime.gccheckmark int32; runtime.gcpacertrace int32; runtime.gcshrinkstackoff int32; runtime.gcstoptheworld int32; runtime.gctrace int32; runtime.invalidptr int32; runtime.madvdontneed int32; runtime.runtimeContentionStacks runtime/internal/atomic.Int32; runtime.scavtrace int32; runtime.scheddetail int32; runtime.schedtrace int32; runtime.tracebackancestors int32; runtime.asyncpreemptoff int32; runtime.harddecommit int32; runtime.adaptivestackstart int32; runtime.tracefpunwindoff int32; runtime.traceadvanceperiod int32; runtime.malloc bool; runtime.allocfreetrace int32; runtime.inittrace int32; runtime.sbrk int32; runtime.panicnil runtime/internal/atomic.Int32 }
    int32 cgocheck;
    int32 clobberfree;
    int32 disablethp;
    int32 dontfreezetheworld;
    int32 efence;
    int32 gccheckmark;
    int32 gcpacertrace;
    int32 gcshrinkstackoff;
    int32 gcstoptheworld;
    int32 gctrace;
    int32 invalidptr;
    int32 madvdontneed;
    struct runtime/internal/atomic.Int32 runtimeContentionStacks;
    int32 scavtrace;
    int32 scheddetail;
    int32 schedtrace;
    int32 tracebackancestors;
    int32 asyncpreemptoff;
    int32 harddecommit;
    int32 adaptivestackstart;
    int32 tracefpunwindoff;
    int32 traceadvanceperiod;
    bool malloc;
    int32 allocfreetrace;
    int32 inittrace;
    int32 sbrk;
    struct runtime/internal/atomic.Int32 panicnil;
};

typedef struct []runtime.liveUserArenaChunk []runtime.liveUserArenaChunk, *P[]runtime.liveUserArenaChunk;

typedef struct runtime.liveUserArenaChunk runtime.liveUserArenaChunk, *Pruntime.liveUserArenaChunk;

struct runtime.liveUserArenaChunk {
    struct runtime.mspan *mspan;
    void *x;
};

struct []runtime.liveUserArenaChunk {
    struct runtime.liveUserArenaChunk *array;
    int len;
    int cap;
};

typedef struct noalg.struct_{_F_uintptr;_X0_runtime.traceLocker_} noalg.struct_{_F_uintptr;_X0_runtime.traceLocker_}, *Pnoalg.struct_{_F_uintptr;_X0_runtime.traceLocker_};

typedef struct runtime.traceLocker runtime.traceLocker, *Pruntime.traceLocker;

struct runtime.traceLocker {
    struct runtime.m *mp;
    uintptr gen;
};

struct noalg.struct_{_F_uintptr;_X0_runtime.traceLocker_} { // Original name: noalg.struct { F uintptr; X0 runtime.traceLocker }
    uintptr F;
    struct runtime.traceLocker X0;
};

typedef struct hash<interface_{},*sync.entry> hash<interface_{},*sync.entry>, *Phash<interface_{},*sync.entry>;

typedef struct hash<interface_{},*sync.entry> *map[interface_{}]*sync.entry;

typedef struct bucket<interface_{},*sync.entry> bucket<interface_{},*sync.entry>, *Pbucket<interface_{},*sync.entry>;

typedef struct sync.entry sync.entry, *Psync.entry;

typedef struct sync/atomic.Pointer[interface_{}] sync/atomic.Pointer[interface_{}], *Psync/atomic.Pointer[interface_{}];

struct hash<interface_{},*sync.entry> { // Original name: hash<interface {},*sync.entry>
    int count;
    uint8 flags;
    uint8 B;
    uint16 noverflow;
    uint32 hash0;
    struct bucket<interface_{},*sync.entry> *buckets;
    struct bucket<interface_{},*sync.entry> *oldbuckets;
    uintptr nevacuate;
    struct runtime.mapextra *extra;
};

struct bucket<interface_{},*sync.entry> { // Original name: bucket<interface {},*sync.entry>
    uint8 tophash[8];
    interface_{} keys[8];
    struct sync.entry *values[8];
    struct bucket<interface_{},*sync.entry> *overflow;
};

struct sync/atomic.Pointer[interface_{}] { // Original name: sync/atomic.Pointer[interface {}]
    struct sync/atomic.noCopy _;
    interface_{} *_[0];
    void *v;
};

struct sync.entry {
    struct sync/atomic.Pointer[interface_{}] p;
};

typedef struct runtime.funcinl runtime.funcinl, *Pruntime.funcinl;

struct runtime.funcinl {
    uint32 ones;
    uintptr entry;
    struct string name;
    struct string file;
    int32 line;
    int32 startLine;
};

typedef struct reflect.ValueError reflect.ValueError, *Preflect.ValueError;

struct reflect.ValueError {
    struct string Method;
    reflect.Kind Kind;
};

typedef struct bucket<runtime._typePair,struct_{}> bucket<runtime._typePair,struct_{}>, *Pbucket<runtime._typePair,struct_{}>;

typedef struct runtime._typePair runtime._typePair, *Pruntime._typePair;

typedef struct struct_{} struct_{}, *Pstruct_{};

struct runtime._typePair {
    struct internal/abi.Type *t1;
    struct internal/abi.Type *t2;
};

struct struct_{} { // Original name: struct {}
};

struct bucket<runtime._typePair,struct_{}> { // Original name: bucket<runtime._typePair,struct {}>
    uint8 tophash[8];
    struct runtime._typePair keys[8];
    struct struct_{} values[0];
    struct bucket<runtime._typePair,struct_{}> *overflow;
};

typedef struct syscall.RawSockaddrAny syscall.RawSockaddrAny, *Psyscall.RawSockaddrAny;

typedef struct syscall.RawSockaddr syscall.RawSockaddr, *Psyscall.RawSockaddr;

struct syscall.RawSockaddr {
    uint16 Family;
    int8 Data[14];
};

struct syscall.RawSockaddrAny {
    struct syscall.RawSockaddr Addr;
    int8 Pad[100];
};

typedef struct golang.org/x/crypto/chacha20poly1305.(*xchacha20poly1305).Open_multivalue_return_type golang.org/x/crypto/chacha20poly1305.(*xchacha20poly1305).Open_multivalue_return_type, *Pgolang.org/x/crypto/chacha20poly1305.(*xchacha20poly1305).Open_multivalue_return_type;

typedef struct runtime.iface error;

struct golang.org/x/crypto/chacha20poly1305.(*xchacha20poly1305).Open_multivalue_return_type { // Artificial data type to hold a function's return values
    struct []uint8 ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct runtime.iface internal/reflectlite.Type;

typedef struct sync.noCopy sync.noCopy, *Psync.noCopy;

struct sync.noCopy {
};

typedef struct runtime.randomEnum runtime.randomEnum, *Pruntime.randomEnum;

struct runtime.randomEnum {
    uint32 i;
    uint32 count;
    uint32 pos;
    uint32 inc;
};

typedef struct internal/abi.Method internal/abi.Method, *Pinternal/abi.Method;

struct internal/abi.Method {
    internal/abi.NameOff Name;
    internal/abi.TypeOff Mtyp;
    internal/abi.TextOff Ifn;
    internal/abi.TextOff Tfn;
};

typedef struct internal/poll.DeadlineExceededError internal/poll.DeadlineExceededError, *Pinternal/poll.DeadlineExceededError;

struct internal/poll.DeadlineExceededError {
};

typedef struct runtime.arenaHint runtime.arenaHint, *Pruntime.arenaHint;

struct runtime.arenaHint {
    struct runtime/internal/sys.NotInHeap _;
    uintptr addr;
    bool down;
    struct runtime.arenaHint *next;
};

typedef struct runtime.Frame runtime.Frame, *Pruntime.Frame;

typedef struct runtime.Func runtime.Func, *Pruntime.Func;

struct runtime.Frame {
    uintptr PC;
    struct runtime.Func *Func;
    struct string Function;
    struct string File;
    int Line;
    int startLine;
    uintptr Entry;
    struct runtime.funcInfo funcInfo;
};

struct runtime.Func {
    struct struct_{} opaque;
};

typedef struct runtime.rawstringtmp_multivalue_return_type runtime.rawstringtmp_multivalue_return_type, *Pruntime.rawstringtmp_multivalue_return_type;

struct runtime.rawstringtmp_multivalue_return_type { // Artificial data type to hold a function's return values
    struct string s; // ordinal: 0
    struct []uint8 b; // ordinal: 1
};

typedef struct runtime.timeHistogram runtime.timeHistogram, *Pruntime.timeHistogram;

typedef struct runtime/internal/atomic.Uint64 runtime/internal/atomic.Uint64, *Pruntime/internal/atomic.Uint64;

struct runtime/internal/atomic.Uint64 {
    struct runtime/internal/atomic.align64 _;
    struct runtime/internal/atomic.noCopy noCopy;
    uint64 value;
};

struct runtime.timeHistogram {
    struct runtime/internal/atomic.Uint64 counts[160];
    struct runtime/internal/atomic.Uint64 underflow;
    struct runtime/internal/atomic.Uint64 overflow;
};

typedef struct golang.org/x/crypto/chacha20poly1305.(*chacha20poly1305).openGeneric_multivalue_return_type golang.org/x/crypto/chacha20poly1305.(*chacha20poly1305).openGeneric_multivalue_return_type, *Pgolang.org/x/crypto/chacha20poly1305.(*chacha20poly1305).openGeneric_multivalue_return_type;

struct golang.org/x/crypto/chacha20poly1305.(*chacha20poly1305).openGeneric_multivalue_return_type { // Artificial data type to hold a function's return values
    struct []uint8 ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct []unsafe.Pointer []unsafe.Pointer, *P[]unsafe.Pointer;

struct []unsafe.Pointer {
    void **array;
    int len;
    int cap;
};

typedef struct runtime.(*pageAlloc).find_multivalue_return_type runtime.(*pageAlloc).find_multivalue_return_type, *Pruntime.(*pageAlloc).find_multivalue_return_type;

struct runtime.(*pageAlloc).find_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr ~r0; // ordinal: 0
    struct runtime.offAddr ~r1; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_*runtime.g_} noalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_*runtime.g_}, *Pnoalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_*runtime.g_};

struct noalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_*runtime.g_} { // Original name: noalg.struct { F uintptr; X0 uintptr; X1 uintptr; X2 *runtime.g }
    uintptr F;
    uintptr X0;
    uintptr X1;
    struct runtime.g *X2;
};

typedef struct golang.org/x/sys/cpu.option golang.org/x/sys/cpu.option, *Pgolang.org/x/sys/cpu.option;

struct golang.org/x/sys/cpu.option {
    struct string Name;
    bool *Feature;
    bool Specified;
    bool Enable;
    bool Required;
};

typedef struct runtime.iface hash.Hash;

typedef struct runtime.iface internal/testlog.Interface;

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.eface;_X1_*runtime.eface;_X2_uintptr;_X3_*internal/abi.Type;_X4_*internal/abi.PtrType_} noalg.struct_{_F_uintptr;_X0_*runtime.eface;_X1_*runtime.eface;_X2_uintptr;_X3_*internal/abi.Type;_X4_*internal/abi.PtrType_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.eface;_X1_*runtime.eface;_X2_uintptr;_X3_*internal/abi.Type;_X4_*internal/abi.PtrType_};

typedef struct internal/abi.PtrType internal/abi.PtrType, *Pinternal/abi.PtrType;

struct noalg.struct_{_F_uintptr;_X0_*runtime.eface;_X1_*runtime.eface;_X2_uintptr;_X3_*internal/abi.Type;_X4_*internal/abi.PtrType_} { // Original name: noalg.struct { F uintptr; X0 *runtime.eface; X1 *runtime.eface; X2 uintptr; X3 *internal/abi.Type; X4 *internal/abi.PtrType }
    uintptr F;
    struct runtime.eface *X0;
    struct runtime.eface *X1;
    uintptr X2;
    struct internal/abi.Type *X3;
    struct internal/abi.PtrType *X4;
};

struct internal/abi.PtrType {
    struct internal/abi.Type Type;
    struct internal/abi.Type *Elem;
};

typedef struct runtime.pallocData runtime.pallocData, *Pruntime.pallocData;

typedef uint64 runtime.pallocBits[8];

typedef uint64 runtime.pageBits[8];

struct runtime.pallocData {
    runtime.pallocBits pallocBits;
    runtime.pageBits scavenged;
};

typedef struct struct_{_runtime.mutex;_runtime.persistentAlloc_} struct_{_runtime.mutex;_runtime.persistentAlloc_}, *Pstruct_{_runtime.mutex;_runtime.persistentAlloc_};

typedef struct runtime.persistentAlloc runtime.persistentAlloc, *Pruntime.persistentAlloc;

typedef struct runtime.notInHeap runtime.notInHeap, *Pruntime.notInHeap;

struct runtime.notInHeap {
    struct runtime/internal/sys.NotInHeap _;
};

struct runtime.persistentAlloc {
    struct runtime.notInHeap *base;
    uintptr off;
};

struct struct_{_runtime.mutex;_runtime.persistentAlloc_} { // Original name: struct { runtime.mutex; runtime.persistentAlloc }
    struct runtime.mutex mutex;
    struct runtime.persistentAlloc persistentAlloc;
};

typedef struct runtime.gcCPULimiterState runtime.gcCPULimiterState, *Pruntime.gcCPULimiterState;

typedef struct struct_{_runtime.fill_uint64;_runtime.capacity_uint64_} struct_{_runtime.fill_uint64;_runtime.capacity_uint64_}, *Pstruct_{_runtime.fill_uint64;_runtime.capacity_uint64_};

struct struct_{_runtime.fill_uint64;_runtime.capacity_uint64_} { // Original name: struct { runtime.fill uint64; runtime.capacity uint64 }
    uint64 fill;
    uint64 capacity;
};

struct runtime.gcCPULimiterState {
    struct runtime/internal/atomic.Uint32 lock;
    struct runtime/internal/atomic.Bool enabled;
    struct struct_{_runtime.fill_uint64;_runtime.capacity_uint64_} bucket;
    uint64 overflow;
    bool gcEnabled;
    bool transitioning;
    struct runtime/internal/atomic.Int64 assistTimePool;
    struct runtime/internal/atomic.Int64 idleMarkTimePool;
    struct runtime/internal/atomic.Int64 idleTimePool;
    struct runtime/internal/atomic.Int64 lastUpdate;
    struct runtime/internal/atomic.Uint32 lastEnabledCycle;
    int32 nprocs;
    bool test;
};

typedef struct []syscall.WSABuf []syscall.WSABuf, *P[]syscall.WSABuf;

typedef struct syscall.WSABuf syscall.WSABuf, *Psyscall.WSABuf;

struct []syscall.WSABuf {
    struct syscall.WSABuf *array;
    int len;
    int cap;
};

struct syscall.WSABuf {
    uint32 Len;
    uint8 *Buf;
};

typedef struct runtime.gQueue runtime.gQueue, *Pruntime.gQueue;

struct runtime.gQueue {
    runtime.guintptr head;
    runtime.guintptr tail;
};

typedef struct runtime.reflectMethodValue runtime.reflectMethodValue, *Pruntime.reflectMethodValue;

struct runtime.reflectMethodValue {
    uintptr fn;
    struct runtime.bitvector *stack;
    uintptr argLen;
};

typedef struct runtime.pcvalue_multivalue_return_type runtime.pcvalue_multivalue_return_type, *Pruntime.pcvalue_multivalue_return_type;

struct runtime.pcvalue_multivalue_return_type { // Artificial data type to hold a function's return values
    int32 ~r0; // ordinal: 0
    uintptr ~r1; // ordinal: 1
};

typedef struct internal/reflectlite.rtype internal/reflectlite.rtype, *Pinternal/reflectlite.rtype;

struct internal/reflectlite.rtype {
    struct internal/abi.Type *Type;
};

typedef struct runtime.PanicNilError runtime.PanicNilError, *Pruntime.PanicNilError;

struct runtime.PanicNilError {
    struct runtime.PanicNilError *_[0];
};

typedef struct runtime/internal/atomic.UnsafePointer runtime.buckhashArray[179999];

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*runtime._panic;_X2_*bool_} noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*runtime._panic;_X2_*bool_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*runtime._panic;_X2_*bool_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*runtime._panic;_X2_*bool_} { // Original name: noalg.struct { F uintptr; X0 *runtime.g; X1 *runtime._panic; X2 *bool }
    uintptr F;
    struct runtime.g *X0;
    struct runtime._panic *X1;
    bool *X2;
};

typedef struct syscall.Overlapped syscall.Overlapped, *Psyscall.Overlapped;

struct syscall.Overlapped {
    uintptr Internal;
    uintptr InternalHigh;
    uint32 Offset;
    uint32 OffsetHigh;
    syscall.Handle HEvent;
};

typedef struct sudog<int> sudog<int>, *Psudog<int>;

struct sudog<int> {
    struct runtime.g *g;
    struct runtime.sudog *next;
    struct runtime.sudog *prev;
    int *elem;
    int64 acquiretime;
    int64 releasetime;
    uint32 ticket;
    bool isSelect;
    bool success;
    uint16 waiters;
    struct runtime.sudog *parent;
    struct runtime.sudog *waitlink;
    struct runtime.sudog *waittail;
    struct runtime.hchan *c;
};

typedef struct runtime.ticksType runtime.ticksType, *Pruntime.ticksType;

struct runtime.ticksType {
    struct runtime.mutex lock;
    int64 startTicks;
    int64 startTime;
    struct runtime/internal/atomic.Int64 val;
};

typedef struct []runtime.stackObjectRecord []runtime.stackObjectRecord, *P[]runtime.stackObjectRecord;

struct []runtime.stackObjectRecord {
    struct runtime.stackObjectRecord *array;
    int len;
    int cap;
};

typedef struct internal/poll.(*FD).readConsole_multivalue_return_type internal/poll.(*FD).readConsole_multivalue_return_type, *Pinternal/poll.(*FD).readConsole_multivalue_return_type;

struct internal/poll.(*FD).readConsole_multivalue_return_type { // Artificial data type to hold a function's return values
    int ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct internal/abi.FuncType internal/abi.FuncType, *Pinternal/abi.FuncType;

struct internal/abi.FuncType {
    struct internal/abi.Type Type;
    uint16 InCount;
    uint16 OutCount;
};

typedef struct struct_{_golang.org/x/sys/cpu.__golang.org/x/sys/cpu.CacheLinePad;_HasAES_bool;_HasADX_bool;_HasAVX_bool;_HasAVX2_bool;_HasAVX512_bool;_HasAVX512F_bool;_HasAVX512CD_bool;_HasAVX512ER_bool;_HasAVX512PF_bool;_HasAVX512VL_bool;_HasAVX512BW_bool;_HasAVX512DQ_bool;_HasAVX512IFMA_bool;_HasAVX512VBMI_bool;_HasAVX5124VNNIW_bool;_HasAVX5124FMAPS_bool;_HasAVX512VPOPCNTDQ_bool;_HasAVX512VPCLMULQDQ_bool;_HasAVX512VNNI_bool;_HasAVX512GFNI_bool;_HasAVX512VAES_bool;_HasAVX512VBMI2_bool;_HasAVX512BITALG_bool;_HasAVX512BF16_bool;_HasAMXTile_bool;_HasAMXInt8_bool;_HasAMXBF16_bool;_HasBMI1_bool;_HasBMI2_bool;_HasCX16_bool;_HasERMS_bool;_HasFMA_bool;_HasOSXSAVE_bool;_HasPCLMULQDQ_bool;_HasPOPCNT_bool;_HasRDRAND_bool;_HasRDSEED_bool;_HasSSE2_bool;_HasSSE3_bool;_HasSSSE3_bool;_HasSSE41_bool;_HasSSE42_bool;_golang.org/x/sys/cpu.__golang.org/x/sys/cpu.CacheLinePad_} struct_{_golang.org/x/sys/cpu.__golang.org/x/sys/cpu.CacheLinePad;_HasAES_bool;_HasADX_bool;_HasAVX_bool;_HasAVX2_bool;_HasAVX512_bool;_HasAVX512F_bool;_HasAVX512CD_bool;_HasAVX512ER_bool;_HasAVX512PF_bool;_HasAVX512VL_bool;_HasAVX512BW_bool;_HasAVX512DQ_bool;_HasAVX512IFMA_bool;_HasAVX512VBMI_bool;_HasAVX5124VNNIW_bool;_HasAVX5124FMAPS_bool;_HasAVX512VPOPCNTDQ_bool;_HasAVX512VPCLMULQDQ_bool;_HasAVX512VNNI_bool;_HasAVX512GFNI_bool;_HasAVX512VAES_bool;_HasAVX512VBMI2_bool;_HasAVX512BITALG_bool;_HasAVX512BF16_bool;_HasAMXTile_bool;_HasAMXInt8_bool;_HasAMXBF16_bool;_HasBMI1_bool;_HasBMI2_bool;_HasCX16_bool;_HasERMS_bool;_HasFMA_bool;_HasOSXSAVE_bool;_HasPCLMULQDQ_bool;_HasPOPCNT_bool;_HasRDRAND_bool;_HasRDSEED_bool;_HasSSE2_bool;_HasSSE3_bool;_HasSSSE3_bool;_HasSSE41_bool;_HasSSE42_bool;_golang.org/x/sys/cpu.__golang.org/x/sys/cpu.CacheLinePad_}, *Pstruct_{_golang.org/x/sys/cpu.__golang.org/x/sys/cpu.CacheLinePad;_HasAES_bool;_HasADX_bool;_HasAVX_bool;_HasAVX2_bool;_HasAVX512_bool;_HasAVX512F_bool;_HasAVX512CD_bool;_HasAVX512ER_bool;_HasAVX512PF_bool;_HasAVX512VL_bool;_HasAVX512BW_bool;_HasAVX512DQ_bool;_HasAVX512IFMA_bool;_HasAVX512VBMI_bool;_HasAVX5124VNNIW_bool;_HasAVX5124FMAPS_bool;_HasAVX512VPOPCNTDQ_bool;_HasAVX512VPCLMULQDQ_bool;_HasAVX512VNNI_bool;_HasAVX512GFNI_bool;_HasAVX512VAES_bool;_HasAVX512VBMI2_bool;_HasAVX512BITALG_bool;_HasAVX512BF16_bool;_HasAMXTile_bool;_HasAMXInt8_bool;_HasAMXBF16_bool;_HasBMI1_bool;_HasBMI2_bool;_HasCX16_bool;_HasERMS_bool;_HasFMA_bool;_HasOSXSAVE_bool;_HasPCLMULQDQ_bool;_HasPOPCNT_bool;_HasRDRAND_bool;_HasRDSEED_bool;_HasSSE2_bool;_HasSSE3_bool;_HasSSSE3_bool;_HasSSE41_bool;_HasSSE42_bool;_golang.org/x/sys/cpu.__golang.org/x/sys/cpu.CacheLinePad_};

typedef struct golang.org/x/sys/cpu.CacheLinePad golang.org/x/sys/cpu.CacheLinePad, *Pgolang.org/x/sys/cpu.CacheLinePad;

struct golang.org/x/sys/cpu.CacheLinePad {
    uint8 _[64];
};

struct struct_{_golang.org/x/sys/cpu.__golang.org/x/sys/cpu.CacheLinePad;_HasAES_bool;_HasADX_bool;_HasAVX_bool;_HasAVX2_bool;_HasAVX512_bool;_HasAVX512F_bool;_HasAVX512CD_bool;_HasAVX512ER_bool;_HasAVX512PF_bool;_HasAVX512VL_bool;_HasAVX512BW_bool;_HasAVX512DQ_bool;_HasAVX512IFMA_bool;_HasAVX512VBMI_bool;_HasAVX5124VNNIW_bool;_HasAVX5124FMAPS_bool;_HasAVX512VPOPCNTDQ_bool;_HasAVX512VPCLMULQDQ_bool;_HasAVX512VNNI_bool;_HasAVX512GFNI_bool;_HasAVX512VAES_bool;_HasAVX512VBMI2_bool;_HasAVX512BITALG_bool;_HasAVX512BF16_bool;_HasAMXTile_bool;_HasAMXInt8_bool;_HasAMXBF16_bool;_HasBMI1_bool;_HasBMI2_bool;_HasCX16_bool;_HasERMS_bool;_HasFMA_bool;_HasOSXSAVE_bool;_HasPCLMULQDQ_bool;_HasPOPCNT_bool;_HasRDRAND_bool;_HasRDSEED_bool;_HasSSE2_bool;_HasSSE3_bool;_HasSSSE3_bool;_HasSSE41_bool;_HasSSE42_bool;_golang.org/x/sys/cpu.__golang.org/x/sys/cpu.CacheLinePad_} { // Original name: struct { golang.org/x/sys/cpu._ golang.org/x/sys/cpu.CacheLinePad; HasAES bool; HasADX bool; HasAVX bool; HasAVX2 bool; HasAVX512 bool; HasAVX512F bool; HasAVX512CD bool; HasAVX512ER bool; HasAVX512PF bool; HasAVX512VL bool; HasAVX512BW bool; HasAVX512DQ bool; HasAVX512IFMA bool; HasAVX512VBMI bool; HasAVX5124VNNIW bool; HasAVX5124FMAPS bool; HasAVX512VPOPCNTDQ bool; HasAVX512VPCLMULQDQ bool; HasAVX512VNNI bool; HasAVX512GFNI bool; HasAVX512VAES bool; HasAVX512VBMI2 bool; HasAVX512BITALG bool; HasAVX512BF16 bool; HasAMXTile bool; HasAMXInt8 bool; HasAMXBF16 bool; HasBMI1 bool; HasBMI2 bool; HasCX16 bool; HasERMS bool; HasFMA bool; HasOSXSAVE bool; HasPCLMULQDQ bool; HasPOPCNT bool; HasRDRAND bool; HasRDSEED bool; HasSSE2 bool; HasSSE3 bool; HasSSSE3 bool; HasSSE41 bool; HasSSE42 bool; golang.org/x/sys/cpu._ golang.org/x/sys/cpu.CacheLinePad }
    struct golang.org/x/sys/cpu.CacheLinePad _;
    bool HasAES;
    bool HasADX;
    bool HasAVX;
    bool HasAVX2;
    bool HasAVX512;
    bool HasAVX512F;
    bool HasAVX512CD;
    bool HasAVX512ER;
    bool HasAVX512PF;
    bool HasAVX512VL;
    bool HasAVX512BW;
    bool HasAVX512DQ;
    bool HasAVX512IFMA;
    bool HasAVX512VBMI;
    bool HasAVX5124VNNIW;
    bool HasAVX5124FMAPS;
    bool HasAVX512VPOPCNTDQ;
    bool HasAVX512VPCLMULQDQ;
    bool HasAVX512VNNI;
    bool HasAVX512GFNI;
    bool HasAVX512VAES;
    bool HasAVX512VBMI2;
    bool HasAVX512BITALG;
    bool HasAVX512BF16;
    bool HasAMXTile;
    bool HasAMXInt8;
    bool HasAMXBF16;
    bool HasBMI1;
    bool HasBMI2;
    bool HasCX16;
    bool HasERMS;
    bool HasFMA;
    bool HasOSXSAVE;
    bool HasPCLMULQDQ;
    bool HasPOPCNT;
    bool HasRDRAND;
    bool HasRDSEED;
    bool HasSSE2;
    bool HasSSE3;
    bool HasSSSE3;
    bool HasSSE41;
    bool HasSSE42;
    struct golang.org/x/sys/cpu.CacheLinePad _;
};

typedef struct fmt.(*ss).ReadRune_multivalue_return_type fmt.(*ss).ReadRune_multivalue_return_type, *Pfmt.(*ss).ReadRune_multivalue_return_type;

struct fmt.(*ss).ReadRune_multivalue_return_type { // Artificial data type to hold a function's return values
    int32 r; // ordinal: 0
    int size; // ordinal: 1
    error err; // ordinal: 2
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.hchan_} noalg.struct_{_F_uintptr;_X0_*runtime.hchan_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.hchan_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.hchan_} { // Original name: noalg.struct { F uintptr; X0 *runtime.hchan }
    uintptr F;
    struct runtime.hchan *X0;
};

typedef struct sync/atomic.Pointer[go.shape.interface_{}] sync/atomic.Pointer[go.shape.interface_{}], *Psync/atomic.Pointer[go.shape.interface_{}];

typedef struct runtime.eface go.shape.interface_{};

struct sync/atomic.Pointer[go.shape.interface_{}] { // Original name: sync/atomic.Pointer[go.shape.interface {}]
    struct sync/atomic.noCopy _;
    go.shape.interface_{} *_[0];
    void *v;
};

typedef struct runtime.profBuf runtime.profBuf, *Pruntime.profBuf;

typedef struct []uint64 []uint64, *P[]uint64;

struct []uint64 {
    uint64 *array;
    int len;
    int cap;
};

struct runtime.profBuf {
    runtime.profAtomic r;
    runtime.profAtomic w;
    struct runtime/internal/atomic.Uint64 overflow;
    struct runtime/internal/atomic.Uint64 overflowTime;
    struct runtime/internal/atomic.Uint32 eof;
    uintptr hdrsize;
    struct []uint64 data;
    struct []unsafe.Pointer tags;
    runtime.profIndex rNext;
    struct []uint64 overflowBuf;
    struct runtime.note wait;
};

typedef struct runtime.findObject_multivalue_return_type runtime.findObject_multivalue_return_type, *Pruntime.findObject_multivalue_return_type;

struct runtime.findObject_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr base; // ordinal: 0
    struct runtime.mspan *s; // ordinal: 1
    uintptr objIndex; // ordinal: 2
};

typedef struct reflect.methodValue reflect.methodValue, *Preflect.methodValue;

typedef struct reflect.makeFuncCtxt reflect.makeFuncCtxt, *Preflect.makeFuncCtxt;

typedef struct reflect.bitVector reflect.bitVector, *Preflect.bitVector;

typedef uint8 internal/abi.IntArgRegBitmap[2];

struct reflect.makeFuncCtxt {
    uintptr fn;
    struct reflect.bitVector *stack;
    uintptr argLen;
    internal/abi.IntArgRegBitmap regPtrs;
};

struct reflect.methodValue {
    struct reflect.makeFuncCtxt makeFuncCtxt;
    int method;
    struct reflect.Value rcvr;
};

struct reflect.bitVector {
    uint32 n;
    struct []uint8 data;
};

typedef struct runtime.(*Frames).Next_multivalue_return_type runtime.(*Frames).Next_multivalue_return_type, *Pruntime.(*Frames).Next_multivalue_return_type;

struct runtime.(*Frames).Next_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.Frame frame; // ordinal: 0
    bool more; // ordinal: 1
};

typedef struct runtime.context runtime.context, *Pruntime.context;

struct runtime.context {
    uint64 p1home;
    uint64 p2home;
    uint64 p3home;
    uint64 p4home;
    uint64 p5home;
    uint64 p6home;
    uint32 contextflags;
    uint32 mxcsr;
    uint16 segcs;
    uint16 segds;
    uint16 seges;
    uint16 segfs;
    uint16 seggs;
    uint16 segss;
    uint32 eflags;
    uint64 dr0;
    uint64 dr1;
    uint64 dr2;
    uint64 dr3;
    uint64 dr6;
    uint64 dr7;
    uint64 rax;
    uint64 rcx;
    uint64 rdx;
    uint64 rbx;
    uint64 rsp;
    uint64 rbp;
    uint64 rsi;
    uint64 rdi;
    uint64 r8;
    uint64 r9;
    uint64 r10;
    uint64 r11;
    uint64 r12;
    uint64 r13;
    uint64 r14;
    uint64 r15;
    uint64 rip;
    uint8 anon0[512];
    struct runtime.m128a vectorregister[26];
    uint64 vectorcontrol;
    uint64 debugcontrol;
    uint64 lastbranchtorip;
    uint64 lastbranchfromrip;
    uint64 lastexceptiontorip;
    uint64 lastexceptionfromrip;
};

typedef struct struct_{_runtime.index_runtime.scavengeIndex;_runtime.releasedBg_runtime/internal/atomic.Uintptr;_runtime.releasedEager_runtime/internal/atomic.Uintptr_} struct_{_runtime.index_runtime.scavengeIndex;_runtime.releasedBg_runtime/internal/atomic.Uintptr;_runtime.releasedEager_runtime/internal/atomic.Uintptr_}, *Pstruct_{_runtime.index_runtime.scavengeIndex;_runtime.releasedBg_runtime/internal/atomic.Uintptr;_runtime.releasedEager_runtime/internal/atomic.Uintptr_};

typedef struct runtime.scavengeIndex runtime.scavengeIndex, *Pruntime.scavengeIndex;

typedef struct []runtime.atomicScavChunkData []runtime.atomicScavChunkData, *P[]runtime.atomicScavChunkData;

typedef struct runtime.atomicOffAddr runtime.atomicOffAddr, *Pruntime.atomicOffAddr;

typedef struct runtime.atomicScavChunkData runtime.atomicScavChunkData, *Pruntime.atomicScavChunkData;

struct runtime.atomicOffAddr {
    struct runtime/internal/atomic.Int64 a;
};

struct []runtime.atomicScavChunkData {
    struct runtime.atomicScavChunkData *array;
    int len;
    int cap;
};

struct runtime.scavengeIndex {
    struct []runtime.atomicScavChunkData chunks;
    struct runtime/internal/atomic.Uintptr min;
    struct runtime/internal/atomic.Uintptr max;
    struct runtime/internal/atomic.Uintptr minHeapIdx;
    struct runtime.atomicOffAddr searchAddrBg;
    struct runtime.atomicOffAddr searchAddrForce;
    struct runtime.offAddr freeHWM;
    uint32 gen;
    bool test;
};

struct struct_{_runtime.index_runtime.scavengeIndex;_runtime.releasedBg_runtime/internal/atomic.Uintptr;_runtime.releasedEager_runtime/internal/atomic.Uintptr_} { // Original name: struct { runtime.index runtime.scavengeIndex; runtime.releasedBg runtime/internal/atomic.Uintptr; runtime.releasedEager runtime/internal/atomic.Uintptr }
    struct runtime.scavengeIndex index;
    struct runtime/internal/atomic.Uintptr releasedBg;
    struct runtime/internal/atomic.Uintptr releasedEager;
};

struct runtime.atomicScavChunkData {
    struct runtime/internal/atomic.Uint64 value;
};

typedef struct sync.(*Map).Load_multivalue_return_type sync.(*Map).Load_multivalue_return_type, *Psync.(*Map).Load_multivalue_return_type;

struct sync.(*Map).Load_multivalue_return_type { // Artificial data type to hold a function's return values
    interface_{} value; // ordinal: 0
    bool ok; // ordinal: 1
};

typedef struct runtime._DISPATCHER_CONTEXT runtime._DISPATCHER_CONTEXT, *Pruntime._DISPATCHER_CONTEXT;

struct runtime._DISPATCHER_CONTEXT {
    uint64 controlPc;
    uint64 imageBase;
    uintptr functionEntry;
    uint64 establisherFrame;
    uint64 targetIp;
    struct runtime.context *context;
    uintptr languageHandler;
    uintptr handlerData;
};

typedef struct hash<string,*unicode.RangeTable> hash<string,*unicode.RangeTable>, *Phash<string,*unicode.RangeTable>;

typedef struct hash<string,*unicode.RangeTable> *map[string]*unicode.RangeTable;

typedef struct bucket<string,*unicode.RangeTable> bucket<string,*unicode.RangeTable>, *Pbucket<string,*unicode.RangeTable>;

typedef struct unicode.RangeTable unicode.RangeTable, *Punicode.RangeTable;

typedef struct []unicode.Range16 []unicode.Range16, *P[]unicode.Range16;

typedef struct []unicode.Range32 []unicode.Range32, *P[]unicode.Range32;

typedef struct unicode.Range16 unicode.Range16, *Punicode.Range16;

typedef struct unicode.Range32 unicode.Range32, *Punicode.Range32;

struct bucket<string,*unicode.RangeTable> {
    uint8 tophash[8];
    struct string keys[8];
    struct unicode.RangeTable *values[8];
    struct bucket<string,*unicode.RangeTable> *overflow;
};

struct hash<string,*unicode.RangeTable> {
    int count;
    uint8 flags;
    uint8 B;
    uint16 noverflow;
    uint32 hash0;
    struct bucket<string,*unicode.RangeTable> *buckets;
    struct bucket<string,*unicode.RangeTable> *oldbuckets;
    uintptr nevacuate;
    struct runtime.mapextra *extra;
};

struct unicode.Range16 {
    uint16 Lo;
    uint16 Hi;
    uint16 Stride;
};

struct []unicode.Range16 {
    struct unicode.Range16 *array;
    int len;
    int cap;
};

struct unicode.Range32 {
    uint32 Lo;
    uint32 Hi;
    uint32 Stride;
};

struct []unicode.Range32 {
    struct unicode.Range32 *array;
    int len;
    int cap;
};

struct unicode.RangeTable {
    struct []unicode.Range16 R16;
    struct []unicode.Range32 R32;
    int LatinOffset;
};

typedef struct internal/abi.InterfaceSwitch internal/abi.InterfaceSwitch, *Pinternal/abi.InterfaceSwitch;

typedef struct internal/abi.InterfaceSwitchCache internal/abi.InterfaceSwitchCache, *Pinternal/abi.InterfaceSwitchCache;

typedef struct internal/abi.InterfaceSwitchCacheEntry internal/abi.InterfaceSwitchCacheEntry, *Pinternal/abi.InterfaceSwitchCacheEntry;

struct internal/abi.InterfaceSwitch {
    struct internal/abi.InterfaceSwitchCache *Cache;
    int NCases;
    struct internal/abi.InterfaceType *Cases[1];
};

struct internal/abi.InterfaceSwitchCacheEntry {
    uintptr Typ;
    int Case;
    uintptr Itab;
};

struct internal/abi.InterfaceSwitchCache {
    uintptr Mask;
    struct internal/abi.InterfaceSwitchCacheEntry Entries[1];
};

typedef struct internal/abi.ArrayType internal/abi.ArrayType, *Pinternal/abi.ArrayType;

struct internal/abi.ArrayType {
    struct internal/abi.Type Type;
    struct internal/abi.Type *Elem;
    struct internal/abi.Type *Slice;
    uintptr Len;
};

typedef struct runtime.atomicSpanSetSpinePointer runtime.atomicSpanSetSpinePointer, *Pruntime.atomicSpanSetSpinePointer;

struct runtime.atomicSpanSetSpinePointer {
    struct runtime/internal/atomic.UnsafePointer a;
};

typedef struct []*runtime.moduledata []*runtime.moduledata, *P[]*runtime.moduledata;

struct []*runtime.moduledata {
    struct runtime.moduledata **array;
    int len;
    int cap;
};

typedef struct fmt.(*pp).Write_multivalue_return_type fmt.(*pp).Write_multivalue_return_type, *Pfmt.(*pp).Write_multivalue_return_type;

struct fmt.(*pp).Write_multivalue_return_type { // Artificial data type to hold a function's return values
    int ret; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct sync.poolChain sync.poolChain, *Psync.poolChain;

typedef struct sync.poolChainElt sync.poolChainElt, *Psync.poolChainElt;

typedef struct sync.poolDequeue sync.poolDequeue, *Psync.poolDequeue;

typedef struct sync/atomic.Uint64 sync/atomic.Uint64, *Psync/atomic.Uint64;

typedef struct []sync.eface []sync.eface, *P[]sync.eface;

typedef struct sync/atomic.align64 sync/atomic.align64, *Psync/atomic.align64;

typedef struct sync.eface sync.eface, *Psync.eface;

struct sync/atomic.align64 {
};

struct sync/atomic.Uint64 {
    struct sync/atomic.align64 _;
    struct sync/atomic.noCopy _;
    uint64 v;
};

struct []sync.eface {
    struct sync.eface *array;
    int len;
    int cap;
};

struct sync.poolDequeue {
    struct sync/atomic.Uint64 headTail;
    struct []sync.eface vals;
};

struct sync.poolChain {
    struct sync.poolChainElt *head;
    struct sync.poolChainElt *tail;
};

struct sync.eface {
    void *typ;
    void *val;
};

struct sync.poolChainElt {
    struct sync.poolDequeue poolDequeue;
    struct sync.poolChainElt *next;
    struct sync.poolChainElt *prev;
};

typedef struct runtime.traceback2_multivalue_return_type runtime.traceback2_multivalue_return_type, *Pruntime.traceback2_multivalue_return_type;

struct runtime.traceback2_multivalue_return_type { // Artificial data type to hold a function's return values
    int n; // ordinal: 0
    int lastN; // ordinal: 1
};

typedef struct go.shape.struct_{_sync.m_map[interface_{}]*sync.entry;_sync.amended_bool_} go.shape.struct_{_sync.m_map[interface_{}]*sync.entry;_sync.amended_bool_}, *Pgo.shape.struct_{_sync.m_map[interface_{}]*sync.entry;_sync.amended_bool_};

struct go.shape.struct_{_sync.m_map[interface_{}]*sync.entry;_sync.amended_bool_} { // Original name: go.shape.struct { sync.m map[interface {}]*sync.entry; sync.amended bool }
    map[interface_{}]*sync.entry m;
    bool amended;
};

typedef struct sync.poolLocal sync.poolLocal, *Psync.poolLocal;

typedef struct sync.poolLocalInternal sync.poolLocalInternal, *Psync.poolLocalInternal;

struct sync.poolLocalInternal {
    interface_{} private;
    struct sync.poolChain shared;
};

struct sync.poolLocal {
    struct sync.poolLocalInternal poolLocalInternal;
    uint8 pad[96];
};

typedef struct sync.readOnly sync.readOnly, *Psync.readOnly;

struct sync.readOnly {
    map[interface_{}]*sync.entry m;
    bool amended;
};

typedef struct runtime.stackWorkBufHdr runtime.stackWorkBufHdr, *Pruntime.stackWorkBufHdr;

typedef struct runtime.stackWorkBuf runtime.stackWorkBuf, *Pruntime.stackWorkBuf;

struct runtime.stackWorkBufHdr {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.workbufhdr workbufhdr;
    struct runtime.stackWorkBuf *next;
};

struct runtime.stackWorkBuf {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.stackWorkBufHdr stackWorkBufHdr;
    uintptr obj[252];
};

typedef struct internal/unsafeheader.Slice internal/unsafeheader.Slice, *Pinternal/unsafeheader.Slice;

struct internal/unsafeheader.Slice {
    void *Data;
    int Len;
    int Cap;
};

typedef struct noalg.struct_{_F_uintptr;_X0_unsafe.Pointer;_X1_*runtime.bucket_} noalg.struct_{_F_uintptr;_X0_unsafe.Pointer;_X1_*runtime.bucket_}, *Pnoalg.struct_{_F_uintptr;_X0_unsafe.Pointer;_X1_*runtime.bucket_};

struct noalg.struct_{_F_uintptr;_X0_unsafe.Pointer;_X1_*runtime.bucket_} { // Original name: noalg.struct { F uintptr; X0 unsafe.Pointer; X1 *runtime.bucket }
    uintptr F;
    void *X0;
    struct runtime.bucket *X1;
};

typedef struct runtime.scavengerState runtime.scavengerState, *Pruntime.scavengerState;

typedef struct runtime.piController runtime.piController, *Pruntime.piController;

struct runtime.piController {
    float64 kp;
    float64 ti;
    float64 tt;
    float64 min;
    float64 max;
    float64 errIntegral;
    bool errOverflow;
    bool inputOverflow;
};

struct runtime.scavengerState {
    struct runtime.mutex lock;
    struct runtime.g *g;
    bool parked;
    struct runtime.timer *timer;
    struct runtime/internal/atomic.Uint32 sysmonWake;
    float64 targetCPUFraction;
    float64 sleepRatio;
    struct runtime.piController sleepController;
    int64 controllerCooldown;
    bool printControllerReset;
    void (**sleepStub)(int64, int64 *);
    void (**scavenge)(uintptr, uintptr *, int64 *);
    void (**shouldStop)(bool *);
    void (**gomaxprocs)(int32 *);
};

typedef struct runtime.makeBucketArray_multivalue_return_type runtime.makeBucketArray_multivalue_return_type, *Pruntime.makeBucketArray_multivalue_return_type;

struct runtime.makeBucketArray_multivalue_return_type { // Artificial data type to hold a function's return values
    void *buckets; // ordinal: 0
    struct runtime.bmap *nextOverflow; // ordinal: 1
};

typedef struct syscall.WSAData syscall.WSAData, *Psyscall.WSAData;

struct syscall.WSAData {
    uint16 Version;
    uint16 HighVersion;
    uint16 MaxSockets;
    uint16 MaxUdpDg;
    uint8 *VendorInfo;
    uint8 Description[257];
    uint8 SystemStatus[129];
};

typedef struct bucket<runtime.winCallbackKey,int> bucket<runtime.winCallbackKey,int>, *Pbucket<runtime.winCallbackKey,int>;

typedef struct runtime.winCallbackKey runtime.winCallbackKey, *Pruntime.winCallbackKey;

typedef struct runtime.funcval runtime.funcval, *Pruntime.funcval;

struct runtime.funcval {
    uintptr fn;
};

struct runtime.winCallbackKey {
    struct runtime.funcval *fn;
    bool cdecl;
};

struct bucket<runtime.winCallbackKey,int> {
    uint8 tophash[8];
    struct runtime.winCallbackKey keys[8];
    int values[8];
    struct bucket<runtime.winCallbackKey,int> *overflow;
};

typedef struct fmt.(*ss).doScanf_multivalue_return_type fmt.(*ss).doScanf_multivalue_return_type, *Pfmt.(*ss).doScanf_multivalue_return_type;

struct fmt.(*ss).doScanf_multivalue_return_type { // Artificial data type to hold a function's return values
    int numProcessed; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct runtime.tracestat runtime.tracestat, *Pruntime.tracestat;

struct runtime.tracestat {
    bool active;
    uint64 id;
    uint64 allocs;
    uint64 bytes;
};

typedef struct strconv.floatInfo strconv.floatInfo, *Pstrconv.floatInfo;

struct strconv.floatInfo {
    uint mantbits;
    uint expbits;
    int bias;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.m_} noalg.struct_{_F_uintptr;_X0_*runtime.m_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.m_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.m_} { // Original name: noalg.struct { F uintptr; X0 *runtime.m }
    uintptr F;
    struct runtime.m *X0;
};

typedef struct runtime.findfuncbucket runtime.findfuncbucket, *Pruntime.findfuncbucket;

struct runtime.findfuncbucket {
    uint32 idx;
    uint8 subbuckets[16];
};

typedef struct runtime.iface runtime.stringer;

typedef struct struct_{_runtime.lock_runtime.mutex;_runtime.free_runtime.mSpanList;_runtime.busy_runtime.mSpanList_} struct_{_runtime.lock_runtime.mutex;_runtime.free_runtime.mSpanList;_runtime.busy_runtime.mSpanList_}, *Pstruct_{_runtime.lock_runtime.mutex;_runtime.free_runtime.mSpanList;_runtime.busy_runtime.mSpanList_};

struct struct_{_runtime.lock_runtime.mutex;_runtime.free_runtime.mSpanList;_runtime.busy_runtime.mSpanList_} { // Original name: struct { runtime.lock runtime.mutex; runtime.free runtime.mSpanList; runtime.busy runtime.mSpanList }
    struct runtime.mutex lock;
    struct runtime.mSpanList free;
    struct runtime.mSpanList busy;
};

typedef struct strconv.readFloat_multivalue_return_type strconv.readFloat_multivalue_return_type, *Pstrconv.readFloat_multivalue_return_type;

struct strconv.readFloat_multivalue_return_type { // Artificial data type to hold a function's return values
    uint64 mantissa; // ordinal: 0
    int exp; // ordinal: 1
    bool neg; // ordinal: 2
    bool trunc; // ordinal: 3
    bool hex; // ordinal: 4
    int i; // ordinal: 5
    bool ok; // ordinal: 6
};

typedef struct runtime.spanSetBlockAlloc runtime.spanSetBlockAlloc, *Pruntime.spanSetBlockAlloc;

struct runtime.spanSetBlockAlloc {
    runtime.lfstack stack;
};

typedef struct []map[internal/abi.TypeOff]*internal/abi.Type []map[internal/abi.TypeOff]*internal/abi.Type, *P[]map[internal/abi.TypeOff]*internal/abi.Type;

struct []map[internal/abi.TypeOff]*internal/abi.Type {
    map[internal/abi.TypeOff]*internal/abi.Type *array;
    int len;
    int cap;
};

typedef struct runtime.spanSet runtime.spanSet, *Pruntime.spanSet;

typedef struct runtime.atomicHeadTailIndex runtime.atomicHeadTailIndex, *Pruntime.atomicHeadTailIndex;

struct runtime.atomicHeadTailIndex {
    struct runtime/internal/atomic.Uint64 u;
};

struct runtime.spanSet {
    struct runtime.mutex spineLock;
    struct runtime.atomicSpanSetSpinePointer spine;
    struct runtime/internal/atomic.Uintptr spineLen;
    uintptr spineCap;
    struct runtime.atomicHeadTailIndex index;
};

typedef struct fmt.(*ss).Read_multivalue_return_type fmt.(*ss).Read_multivalue_return_type, *Pfmt.(*ss).Read_multivalue_return_type;

struct fmt.(*ss).Read_multivalue_return_type { // Artificial data type to hold a function's return values
    int n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct golang.org/x/crypto/internal/poly1305.MAC golang.org/x/crypto/internal/poly1305.MAC, *Pgolang.org/x/crypto/internal/poly1305.MAC;

typedef struct golang.org/x/crypto/internal/poly1305.mac golang.org/x/crypto/internal/poly1305.mac, *Pgolang.org/x/crypto/internal/poly1305.mac;

typedef struct golang.org/x/crypto/internal/poly1305.macGeneric golang.org/x/crypto/internal/poly1305.macGeneric, *Pgolang.org/x/crypto/internal/poly1305.macGeneric;

typedef struct golang.org/x/crypto/internal/poly1305.macState golang.org/x/crypto/internal/poly1305.macState, *Pgolang.org/x/crypto/internal/poly1305.macState;

struct golang.org/x/crypto/internal/poly1305.macState {
    uint64 h[3];
    uint64 r[2];
    uint64 s[2];
};

struct golang.org/x/crypto/internal/poly1305.macGeneric {
    struct golang.org/x/crypto/internal/poly1305.macState macState;
    uint8 buffer[16];
    int offset;
};

struct golang.org/x/crypto/internal/poly1305.mac {
    struct golang.org/x/crypto/internal/poly1305.macGeneric macGeneric;
};

struct golang.org/x/crypto/internal/poly1305.MAC {
    struct golang.org/x/crypto/internal/poly1305.mac mac;
    bool finalized;
};

typedef struct runtime.pidleget_multivalue_return_type runtime.pidleget_multivalue_return_type, *Pruntime.pidleget_multivalue_return_type;

typedef struct runtime.p runtime.p, *Pruntime.p;

typedef struct runtime.sysmontick runtime.sysmontick, *Pruntime.sysmontick;

typedef struct runtime.mcache runtime.mcache, *Pruntime.mcache;

typedef struct runtime.pageCache runtime.pageCache, *Pruntime.pageCache;

typedef struct []*runtime._defer []*runtime._defer, *P[]*runtime._defer;

typedef struct []*runtime.sudog []*runtime.sudog, *P[]*runtime.sudog;

typedef struct struct_{_runtime.len_int;_runtime.buf_[128]*runtime.mspan_} struct_{_runtime.len_int;_runtime.buf_[128]*runtime.mspan_}, *Pstruct_{_runtime.len_int;_runtime.buf_[128]*runtime.mspan_};

typedef struct runtime.pinner runtime.pinner, *Pruntime.pinner;

typedef struct runtime.pTraceState runtime.pTraceState, *Pruntime.pTraceState;

typedef struct runtime.limiterEvent runtime.limiterEvent, *Pruntime.limiterEvent;

typedef struct runtime.gcWork runtime.gcWork, *Pruntime.gcWork;

typedef struct runtime.wbBuf runtime.wbBuf, *Pruntime.wbBuf;

typedef struct []*runtime.timer []*runtime.timer, *P[]*runtime.timer;

typedef struct runtime.pageTraceBuf runtime.pageTraceBuf, *Pruntime.pageTraceBuf;

typedef struct runtime.stackfreelist runtime.stackfreelist, *Pruntime.stackfreelist;

typedef struct runtime.workbuf runtime.workbuf, *Pruntime.workbuf;

struct runtime.pidleget_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.p *~r0; // ordinal: 0
    int64 ~r1; // ordinal: 1
};

struct []*runtime.timer {
    struct runtime.timer **array;
    int len;
    int cap;
};

struct runtime.sysmontick {
    uint32 schedtick;
    int64 schedwhen;
    uint32 syscalltick;
    int64 syscallwhen;
};

struct runtime.wbBuf {
    uintptr next;
    uintptr end;
    uintptr buf[512];
};

struct runtime.stackfreelist {
    runtime.gclinkptr list;
    uintptr size;
};

struct runtime.limiterEvent {
    struct runtime/internal/atomic.Uint64 stamp;
};

struct runtime.pTraceState {
    struct runtime.traceSchedResourceState traceSchedResourceState;
    int64 mSyscallID;
    bool maySweep;
    bool inSweep;
    uintptr swept;
    uintptr reclaimed;
};

struct runtime.gcWork {
    struct runtime.workbuf *wbuf1;
    struct runtime.workbuf *wbuf2;
    uint64 bytesMarked;
    int64 heapScanWork;
    bool flushedWork;
};

struct runtime.pinner {
    struct []unsafe.Pointer refs;
    void *refStore[5];
};

struct runtime.pageTraceBuf {
};

struct runtime.pageCache {
    uintptr base;
    uint64 cache;
    uint64 scav;
};

struct runtime.workbuf {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.workbufhdr workbufhdr;
    uintptr obj[253];
};

struct []*runtime.sudog {
    struct runtime.sudog **array;
    int len;
    int cap;
};

struct struct_{_runtime.len_int;_runtime.buf_[128]*runtime.mspan_} { // Original name: struct { runtime.len int; runtime.buf [128]*runtime.mspan }
    int len;
    struct runtime.mspan *buf[128];
};

struct []*runtime._defer {
    struct runtime._defer **array;
    int len;
    int cap;
};

struct runtime.p {
    int32 id;
    uint32 status;
    runtime.puintptr link;
    uint32 schedtick;
    uint32 syscalltick;
    struct runtime.sysmontick sysmontick;
    runtime.muintptr m;
    struct runtime.mcache *mcache;
    struct runtime.pageCache pcache;
    uintptr raceprocctx;
    struct []*runtime._defer deferpool;
    struct runtime._defer *deferpoolbuf[32];
    uint64 goidcache;
    uint64 goidcacheend;
    uint32 runqhead;
    uint32 runqtail;
    runtime.guintptr runq[256];
    runtime.guintptr runnext;
    struct struct_{_runtime.gList;_runtime.n_int32_} gFree;
    struct []*runtime.sudog sudogcache;
    struct runtime.sudog *sudogbuf[128];
    struct struct_{_runtime.len_int;_runtime.buf_[128]*runtime.mspan_} mspancache;
    struct runtime.pinner *pinnerCache;
    struct runtime.pTraceState trace;
    struct runtime.persistentAlloc palloc;
    struct runtime/internal/atomic.Int64 timer0When;
    struct runtime/internal/atomic.Int64 timerModifiedEarliest;
    int64 gcAssistTime;
    int64 gcFractionalMarkTime;
    struct runtime.limiterEvent limiterEvent;
    runtime.gcMarkWorkerMode gcMarkWorkerMode;
    int64 gcMarkWorkerStartTime;
    struct runtime.gcWork gcw;
    struct runtime.wbBuf wbBuf;
    uint32 runSafePointFn;
    struct runtime/internal/atomic.Uint32 statsSeq;
    struct runtime.mutex timersLock;
    struct []*runtime.timer timers;
    struct runtime/internal/atomic.Uint32 numTimers;
    struct runtime/internal/atomic.Uint32 deletedTimers;
    uintptr timerRaceCtx;
    int64 maxStackScanDelta;
    uint64 scannedStackSize;
    uint64 scannedStacks;
    bool preempt;
    struct runtime.pageTraceBuf pageTraceBuf;
};

struct runtime.mcache {
    struct runtime/internal/sys.NotInHeap _;
    uintptr nextSample;
    uintptr scanAlloc;
    uintptr tiny;
    uintptr tinyoffset;
    uintptr tinyAllocs;
    struct runtime.mspan *alloc[136];
    struct runtime.stackfreelist stackcache[2];
    struct runtime/internal/atomic.Uint32 flushGen;
};

typedef struct golang.org/x/crypto/chacha20poly1305.chacha20poly1305 golang.org/x/crypto/chacha20poly1305.chacha20poly1305, *Pgolang.org/x/crypto/chacha20poly1305.chacha20poly1305;

struct golang.org/x/crypto/chacha20poly1305.chacha20poly1305 {
    uint8 key[32];
};

typedef struct runtime.mcentral runtime.mcentral, *Pruntime.mcentral;

struct runtime.mcentral {
    struct runtime/internal/sys.NotInHeap _;
    runtime.spanClass spanclass;
    struct runtime.spanSet partial[2];
    struct runtime.spanSet full[2];
};

typedef struct runtime.memRecordCycle runtime.memRecordCycle, *Pruntime.memRecordCycle;

struct runtime.memRecordCycle {
    uintptr allocs;
    uintptr frees;
    uintptr alloc_bytes;
    uintptr free_bytes;
};

typedef struct []*internal/abi.InterfaceType []*internal/abi.InterfaceType, *P[]*internal/abi.InterfaceType;

struct []*internal/abi.InterfaceType {
    struct internal/abi.InterfaceType **array;
    int len;
    int cap;
};

typedef struct runtime/internal/atomic.Pointer[runtime.profBuf] runtime/internal/atomic.Pointer[runtime.profBuf], *Pruntime/internal/atomic.Pointer[runtime.profBuf];

struct runtime/internal/atomic.Pointer[runtime.profBuf] {
    struct runtime/internal/atomic.UnsafePointer u;
};

typedef struct runtime.traceWriter runtime.traceWriter, *Pruntime.traceWriter;

struct runtime.traceWriter {
    struct runtime.traceLocker traceLocker;
    struct runtime.traceBuf *traceBuf;
};

typedef struct struct_{_runtime.gcPercentGoal_runtime/internal/atomic.Uint64;_runtime.memoryLimitGoal_runtime/internal/atomic.Uint64;_runtime.assistTime_runtime/internal/atomic.Int64;_runtime.backgroundTime_runtime/internal/atomic.Int64_} struct_{_runtime.gcPercentGoal_runtime/internal/atomic.Uint64;_runtime.memoryLimitGoal_runtime/internal/atomic.Uint64;_runtime.assistTime_runtime/internal/atomic.Int64;_runtime.backgroundTime_runtime/internal/atomic.Int64_}, *Pstruct_{_runtime.gcPercentGoal_runtime/internal/atomic.Uint64;_runtime.memoryLimitGoal_runtime/internal/atomic.Uint64;_runtime.assistTime_runtime/internal/atomic.Int64;_runtime.backgroundTime_runtime/internal/atomic.Int64_};

struct struct_{_runtime.gcPercentGoal_runtime/internal/atomic.Uint64;_runtime.memoryLimitGoal_runtime/internal/atomic.Uint64;_runtime.assistTime_runtime/internal/atomic.Int64;_runtime.backgroundTime_runtime/internal/atomic.Int64_} { // Original name: struct { runtime.gcPercentGoal runtime/internal/atomic.Uint64; runtime.memoryLimitGoal runtime/internal/atomic.Uint64; runtime.assistTime runtime/internal/atomic.Int64; runtime.backgroundTime runtime/internal/atomic.Int64 }
    struct runtime/internal/atomic.Uint64 gcPercentGoal;
    struct runtime/internal/atomic.Uint64 memoryLimitGoal;
    struct runtime/internal/atomic.Int64 assistTime;
    struct runtime/internal/atomic.Int64 backgroundTime;
};

typedef struct reflect.Method reflect.Method, *Preflect.Method;

typedef struct runtime.iface reflect.Type;

struct reflect.Method {
    struct string Name;
    struct string PkgPath;
    reflect.Type Type;
    struct reflect.Value Func;
    int Index;
};

typedef struct internal/abi.SliceType internal/abi.SliceType, *Pinternal/abi.SliceType;

struct internal/abi.SliceType {
    struct internal/abi.Type Type;
    struct internal/abi.Type *Elem;
};

typedef struct []runtime.arenaIdx []runtime.arenaIdx, *P[]runtime.arenaIdx;

struct []runtime.arenaIdx {
    runtime.arenaIdx *array;
    int len;
    int cap;
};

typedef struct runtime.funcNamePiecesForPrint_multivalue_return_type runtime.funcNamePiecesForPrint_multivalue_return_type, *Pruntime.funcNamePiecesForPrint_multivalue_return_type;

struct runtime.funcNamePiecesForPrint_multivalue_return_type { // Artificial data type to hold a function's return values
    struct string ~r0; // ordinal: 0
    struct string ~r1; // ordinal: 1
    struct string ~r2; // ordinal: 2
};

typedef struct internal/abi.TypeAssert internal/abi.TypeAssert, *Pinternal/abi.TypeAssert;

typedef struct internal/abi.TypeAssertCache internal/abi.TypeAssertCache, *Pinternal/abi.TypeAssertCache;

typedef struct internal/abi.TypeAssertCacheEntry internal/abi.TypeAssertCacheEntry, *Pinternal/abi.TypeAssertCacheEntry;

struct internal/abi.TypeAssert {
    struct internal/abi.TypeAssertCache *Cache;
    struct internal/abi.InterfaceType *Inter;
    bool CanFail;
};

struct internal/abi.TypeAssertCacheEntry {
    uintptr Typ;
    uintptr Itab;
};

struct internal/abi.TypeAssertCache {
    uintptr Mask;
    struct internal/abi.TypeAssertCacheEntry Entries[1];
};

typedef struct runtime.heapStatsDelta runtime.heapStatsDelta, *Pruntime.heapStatsDelta;

struct runtime.heapStatsDelta {
    int64 committed;
    int64 released;
    int64 inHeap;
    int64 inStacks;
    int64 inWorkBufs;
    int64 inPtrScalarBits;
    uint64 tinyAllocCount;
    uint64 largeAlloc;
    uint64 largeAllocCount;
    uint64 smallAllocCount[68];
    uint64 largeFree;
    uint64 largeFreeCount;
    uint64 smallFreeCount[68];
};

typedef struct noalg.struct_{_F_uintptr;_X0_*uintptr;_X1_*string_} noalg.struct_{_F_uintptr;_X0_*uintptr;_X1_*string_}, *Pnoalg.struct_{_F_uintptr;_X0_*uintptr;_X1_*string_};

struct noalg.struct_{_F_uintptr;_X0_*uintptr;_X1_*string_} { // Original name: noalg.struct { F uintptr; X0 *uintptr; X1 *string }
    uintptr F;
    uintptr *X0;
    struct string *X1;
};

typedef struct sync.(*entry).tryLoadOrStore_multivalue_return_type sync.(*entry).tryLoadOrStore_multivalue_return_type, *Psync.(*entry).tryLoadOrStore_multivalue_return_type;

struct sync.(*entry).tryLoadOrStore_multivalue_return_type { // Artificial data type to hold a function's return values
    interface_{} actual; // ordinal: 0
    bool loaded; // ordinal: 1
    bool ok; // ordinal: 2
};

typedef struct golang.org/x/crypto/chacha20.hChaCha20_multivalue_return_type golang.org/x/crypto/chacha20.hChaCha20_multivalue_return_type, *Pgolang.org/x/crypto/chacha20.hChaCha20_multivalue_return_type;

struct golang.org/x/crypto/chacha20.hChaCha20_multivalue_return_type { // Artificial data type to hold a function's return values
    struct []uint8 ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct []runtime.abiPart []runtime.abiPart, *P[]runtime.abiPart;

typedef struct runtime.abiPart runtime.abiPart, *Pruntime.abiPart;

struct []runtime.abiPart {
    struct runtime.abiPart *array;
    int len;
    int cap;
};

struct runtime.abiPart {
    runtime.abiPartKind kind;
    uintptr srcStackOffset;
    uintptr dstStackOffset;
    int dstRegister;
    uintptr len;
};

typedef struct fmt.ssave fmt.ssave, *Pfmt.ssave;

struct fmt.ssave {
    bool validSave;
    bool nlIsEnd;
    bool nlIsSpace;
    int argLimit;
    int limit;
    int maxWid;
};

typedef struct go.shape.struct_{_runtime.heap_bool;_runtime.rangefunc_bool;_runtime.sp_uintptr;_runtime.pc_uintptr;_runtime.fn_func();_runtime.link_*runtime._defer;_runtime.head_*runtime/internal/atomic.Pointer[runtime._defer]_} go.shape.struct_{_runtime.heap_bool;_runtime.rangefunc_bool;_runtime.sp_uintptr;_runtime.pc_uintptr;_runtime.fn_func();_runtime.link_*runtime._defer;_runtime.head_*runtime/internal/atomic.Pointer[runtime._defer]_}, *Pgo.shape.struct_{_runtime.heap_bool;_runtime.rangefunc_bool;_runtime.sp_uintptr;_runtime.pc_uintptr;_runtime.fn_func();_runtime.link_*runtime._defer;_runtime.head_*runtime/internal/atomic.Pointer[runtime._defer]_};

struct go.shape.struct_{_runtime.heap_bool;_runtime.rangefunc_bool;_runtime.sp_uintptr;_runtime.pc_uintptr;_runtime.fn_func();_runtime.link_*runtime._defer;_runtime.head_*runtime/internal/atomic.Pointer[runtime._defer]_} { // Original name: go.shape.struct { runtime.heap bool; runtime.rangefunc bool; runtime.sp uintptr; runtime.pc uintptr; runtime.fn func(); runtime.link *runtime._defer; runtime.head *runtime/internal/atomic.Pointer[runtime._defer] }
    bool heap;
    bool rangefunc;
    uintptr sp;
    uintptr pc;
    void (**fn)(void);
    struct runtime._defer *link;
    struct runtime/internal/atomic.Pointer[runtime._defer] *head;
};

typedef struct hchan<struct_{}> hchan<struct_{}>, *Phchan<struct_{}>;

typedef struct hchan<struct_{}> *<-chan_struct_{};

typedef struct waitq<struct_{}> waitq<struct_{}>, *Pwaitq<struct_{}>;

typedef struct sudog<struct_{}> sudog<struct_{}>, *Psudog<struct_{}>;

struct sudog<struct_{}> { // Original name: sudog<struct {}>
    struct runtime.g *g;
    struct runtime.sudog *next;
    struct runtime.sudog *prev;
    struct struct_{} *elem;
    int64 acquiretime;
    int64 releasetime;
    uint32 ticket;
    bool isSelect;
    bool success;
    uint16 waiters;
    struct runtime.sudog *parent;
    struct runtime.sudog *waitlink;
    struct runtime.sudog *waittail;
    struct runtime.hchan *c;
};

struct waitq<struct_{}> { // Original name: waitq<struct {}>
    struct sudog<struct_{}> *first;
    struct sudog<struct_{}> *last;
};

struct hchan<struct_{}> { // Original name: hchan<struct {}>
    uint qcount;
    uint dataqsiz;
    void *buf;
    uint16 elemsize;
    uint32 closed;
    struct internal/abi.Type *elemtype;
    uint sendx;
    uint recvx;
    struct waitq<struct_{}> recvq;
    struct waitq<struct_{}> sendq;
    struct runtime.mutex lock;
};

typedef struct runtime.stkframe runtime.stkframe, *Pruntime.stkframe;

struct runtime.stkframe {
    struct runtime.funcInfo fn;
    uintptr pc;
    uintptr continpc;
    uintptr lr;
    uintptr sp;
    uintptr fp;
    uintptr varp;
    uintptr argp;
};

typedef struct sync.Map sync.Map, *Psync.Map;

typedef struct sync/atomic.Pointer[sync.readOnly] sync/atomic.Pointer[sync.readOnly], *Psync/atomic.Pointer[sync.readOnly];

struct sync/atomic.Pointer[sync.readOnly] {
    struct sync/atomic.noCopy _;
    struct sync.readOnly *_[0];
    void *v;
};

struct sync.Map {
    struct sync.Mutex mu;
    struct sync/atomic.Pointer[sync.readOnly] read;
    map[interface_{}]*sync.entry dirty;
    int misses;
};

typedef struct fmt.ss fmt.ss, *Pfmt.ss;

typedef struct runtime.iface io.RuneScanner;

struct fmt.ss {
    io.RuneScanner rs;
    struct fmt.buffer buf;
    int count;
    bool atEOF;
    struct fmt.ssave ssave;
};

typedef struct io/fs.PathError io/fs.PathError, *Pio/fs.PathError;

struct io/fs.PathError {
    struct string Op;
    struct string Path;
    error Err;
};

typedef struct runtime.iface io.Writer;

typedef struct internal/poll.fdMutex internal/poll.fdMutex, *Pinternal/poll.fdMutex;

struct internal/poll.fdMutex {
    uint64 state;
    uint32 rsema;
    uint32 wsema;
};

typedef struct runtime.chanrecv_multivalue_return_type runtime.chanrecv_multivalue_return_type, *Pruntime.chanrecv_multivalue_return_type;

struct runtime.chanrecv_multivalue_return_type { // Artificial data type to hold a function's return values
    bool selected; // ordinal: 0
    bool received; // ordinal: 1
};

typedef struct sync.(*poolDequeue).popTail_multivalue_return_type sync.(*poolDequeue).popTail_multivalue_return_type, *Psync.(*poolDequeue).popTail_multivalue_return_type;

struct sync.(*poolDequeue).popTail_multivalue_return_type { // Artificial data type to hold a function's return values
    interface_{} ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct runtime.cpuStats runtime.cpuStats, *Pruntime.cpuStats;

struct runtime.cpuStats {
    int64 gcAssistTime;
    int64 gcDedicatedTime;
    int64 gcIdleTime;
    int64 gcPauseTime;
    int64 gcTotalTime;
    int64 scavengeAssistTime;
    int64 scavengeBgTime;
    int64 scavengeTotalTime;
    int64 idleTime;
    int64 userTime;
    int64 totalTime;
};

typedef struct bucket<int32,unsafe.Pointer> bucket<int32,unsafe.Pointer>, *Pbucket<int32,unsafe.Pointer>;

struct bucket<int32,unsafe.Pointer> {
    uint8 tophash[8];
    int32 keys[8];
    void *values[8];
    struct bucket<int32,unsafe.Pointer> *overflow;
};

typedef struct struct_{_runtime.lpFileName_*uint16;_runtime.hFile_uintptr;_runtime.flags_uint32_} struct_{_runtime.lpFileName_*uint16;_runtime.hFile_uintptr;_runtime.flags_uint32_}, *Pstruct_{_runtime.lpFileName_*uint16;_runtime.hFile_uintptr;_runtime.flags_uint32_};

struct struct_{_runtime.lpFileName_*uint16;_runtime.hFile_uintptr;_runtime.flags_uint32_} { // Original name: struct { runtime.lpFileName *uint16; runtime.hFile uintptr; runtime.flags uint32 }
    uint16 *lpFileName;
    uintptr hFile;
    uint32 flags;
};

typedef struct runtime.hiter runtime.hiter, *Pruntime.hiter;

typedef struct internal/abi.MapType internal/abi.MapType, *Pinternal/abi.MapType;

typedef struct runtime.hmap runtime.hmap, *Pruntime.hmap;

struct runtime.hiter {
    void *key;
    void *elem;
    struct internal/abi.MapType *t;
    struct runtime.hmap *h;
    void *buckets;
    struct runtime.bmap *bptr;
    struct []*runtime.bmap *overflow;
    struct []*runtime.bmap *oldoverflow;
    uintptr startBucket;
    uint8 offset;
    bool wrapped;
    uint8 B;
    uint8 i;
    uintptr bucket;
    uintptr checkBucket;
};

struct runtime.hmap {
    int count;
    uint8 flags;
    uint8 B;
    uint16 noverflow;
    uint32 hash0;
    void *buckets;
    void *oldbuckets;
    uintptr nevacuate;
    struct runtime.mapextra *extra;
};

struct internal/abi.MapType {
    struct internal/abi.Type Type;
    struct internal/abi.Type *Key;
    struct internal/abi.Type *Elem;
    struct internal/abi.Type *Bucket;
    void (**Hasher)(void *, uintptr, uintptr *);
    uint8 KeySize;
    uint8 ValueSize;
    uint16 BucketSize;
    uint32 Flags;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*int64;_X1_*runtime.worldStop_} noalg.struct_{_F_uintptr;_X0_*int64;_X1_*runtime.worldStop_}, *Pnoalg.struct_{_F_uintptr;_X0_*int64;_X1_*runtime.worldStop_};

struct noalg.struct_{_F_uintptr;_X0_*int64;_X1_*runtime.worldStop_} { // Original name: noalg.struct { F uintptr; X0 *int64; X1 *runtime.worldStop }
    uintptr F;
    int64 *X0;
    struct runtime.worldStop *X1;
};

typedef struct internal/syscall/windows.GetModuleFileName_multivalue_return_type internal/syscall/windows.GetModuleFileName_multivalue_return_type, *Pinternal/syscall/windows.GetModuleFileName_multivalue_return_type;

struct internal/syscall/windows.GetModuleFileName_multivalue_return_type { // Artificial data type to hold a function's return values
    uint32 n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct fmt.parseArgNumber_multivalue_return_type fmt.parseArgNumber_multivalue_return_type, *Pfmt.parseArgNumber_multivalue_return_type;

struct fmt.parseArgNumber_multivalue_return_type { // Artificial data type to hold a function's return values
    int index; // ordinal: 0
    int wid; // ordinal: 1
    bool ok; // ordinal: 2
};

typedef struct syscall.loadlibrary_multivalue_return_type syscall.loadlibrary_multivalue_return_type, *Psyscall.loadlibrary_multivalue_return_type;

struct syscall.loadlibrary_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr handle; // ordinal: 0
    uintptr err; // ordinal: 1
};

typedef struct runtime.rtype runtime.rtype, *Pruntime.rtype;

struct runtime.rtype {
    struct internal/abi.Type *Type;
};

typedef struct runtime.(*mheap).sysAlloc_multivalue_return_type runtime.(*mheap).sysAlloc_multivalue_return_type, *Pruntime.(*mheap).sysAlloc_multivalue_return_type;

struct runtime.(*mheap).sysAlloc_multivalue_return_type { // Artificial data type to hold a function's return values
    void *v; // ordinal: 0
    uintptr size; // ordinal: 1
};

typedef struct math/rand/v2.runtimeSource math/rand/v2.runtimeSource, *Pmath/rand/v2.runtimeSource;

struct math/rand/v2.runtimeSource {
};

typedef struct noalg.map.bucket[uint32][]*internal/abi.Type noalg.map.bucket[uint32][]*internal/abi.Type, *Pnoalg.map.bucket[uint32][]*internal/abi.Type;

typedef uint32 noalg.[8]uint32[8];

struct noalg.map.bucket[uint32][]*internal/abi.Type {
    uint8 topbits[8];
    noalg.[8]uint32 keys;
    noalg.[8][]*internal/abi.Type elems;
    void *overflow;
};

typedef struct []*internal/abi.Type noalg.[8][]*internal/abi.Type[8];

typedef struct runtime.(*pallocBits).findSmallN_multivalue_return_type runtime.(*pallocBits).findSmallN_multivalue_return_type, *Pruntime.(*pallocBits).findSmallN_multivalue_return_type;

struct runtime.(*pallocBits).findSmallN_multivalue_return_type { // Artificial data type to hold a function's return values
    uint ~r0; // ordinal: 0
    uint ~r1; // ordinal: 1
};

typedef struct runtime.decoderune_multivalue_return_type runtime.decoderune_multivalue_return_type, *Pruntime.decoderune_multivalue_return_type;

struct runtime.decoderune_multivalue_return_type { // Artificial data type to hold a function's return values
    int32 r; // ordinal: 0
    int pos; // ordinal: 1
};

typedef struct noalg.map.bucket[runtime._typePair]struct_{} noalg.map.bucket[runtime._typePair]struct_{}, *Pnoalg.map.bucket[runtime._typePair]struct_{};

struct noalg.map.bucket[runtime._typePair]struct_{} { // Original name: noalg.map.bucket[runtime._typePair]struct {}
    uint8 topbits[8];
    noalg.[8]runtime._typePair keys;
    noalg.[8]struct_{} elems;
    void *overflow;
};

typedef struct struct_{} noalg.[8]struct_{}[0];

typedef struct runtime._typePair noalg.[8]runtime._typePair[8];

typedef struct runtime.mapaccess2_fast64_multivalue_return_type runtime.mapaccess2_fast64_multivalue_return_type, *Pruntime.mapaccess2_fast64_multivalue_return_type;

struct runtime.mapaccess2_fast64_multivalue_return_type { // Artificial data type to hold a function's return values
    void *~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct fmt.readRune fmt.readRune, *Pfmt.readRune;

typedef struct runtime.iface io.Reader;

struct fmt.readRune {
    io.Reader reader;
    uint8 buf[4];
    int pending;
    uint8 pendBuf[4];
    int32 peekRune;
};

typedef struct runtime.spanSetSpinePointer runtime.spanSetSpinePointer, *Pruntime.spanSetSpinePointer;

struct runtime.spanSetSpinePointer {
    void *p;
};

typedef struct sync/atomic.Value sync/atomic.Value, *Psync/atomic.Value;

struct sync/atomic.Value {
    interface_{} v;
};

typedef struct runtime.netpoll_multivalue_return_type runtime.netpoll_multivalue_return_type, *Pruntime.netpoll_multivalue_return_type;

struct runtime.netpoll_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.gList ~r0; // ordinal: 0
    int32 ~r1; // ordinal: 1
};

typedef struct unicode/utf8.acceptRange unicode/utf8.acceptRange, *Punicode/utf8.acceptRange;

struct unicode/utf8.acceptRange {
    uint8 lo;
    uint8 hi;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*sync.Mutex_} noalg.struct_{_F_uintptr;_X0_*sync.Mutex_}, *Pnoalg.struct_{_F_uintptr;_X0_*sync.Mutex_};

struct noalg.struct_{_F_uintptr;_X0_*sync.Mutex_} { // Original name: noalg.struct { F uintptr; X0 *sync.Mutex }
    uintptr F;
    struct sync.Mutex *X0;
};

typedef struct runtime.wakeableSleep runtime.wakeableSleep, *Pruntime.wakeableSleep;

typedef struct hchan<struct_{}> *chan_struct_{};

struct runtime.wakeableSleep {
    struct runtime.timer *timer;
    struct runtime.mutex lock;
    chan_struct_{} wakeup;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_int_} noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_int_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_int_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_int_} { // Original name: noalg.struct { F uintptr; X0 *runtime.g; X1 int }
    uintptr F;
    struct runtime.g *X0;
    int X1;
};

typedef struct internal/abi.RegArgs internal/abi.RegArgs, *Pinternal/abi.RegArgs;

struct internal/abi.RegArgs {
    uintptr Ints[9];
    uint64 Floats[15];
    void *Ptrs[9];
    internal/abi.IntArgRegBitmap ReturnIsPtr;
};

typedef struct hash<runtime._typePair,struct_{}> hash<runtime._typePair,struct_{}>, *Phash<runtime._typePair,struct_{}>;

typedef struct hash<runtime._typePair,struct_{}> *map[runtime._typePair]struct_{};

struct hash<runtime._typePair,struct_{}> { // Original name: hash<runtime._typePair,struct {}>
    int count;
    uint8 flags;
    uint8 B;
    uint16 noverflow;
    uint32 hash0;
    struct bucket<runtime._typePair,struct_{}> *buckets;
    struct bucket<runtime._typePair,struct_{}> *oldbuckets;
    uintptr nevacuate;
    struct runtime.mapextra *extra;
};

typedef struct []runtime.exitHook []runtime.exitHook, *P[]runtime.exitHook;

struct []runtime.exitHook {
    struct runtime.exitHook *array;
    int len;
    int cap;
};

typedef struct runtime.boundsError runtime.boundsError, *Pruntime.boundsError;

struct runtime.boundsError {
    int64 x;
    int y;
    bool signed;
    runtime.boundsErrorCode code;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.mheap;_X1_uintptr;_X2_**runtime.mspan;_X3_runtime.spanClass_} noalg.struct_{_F_uintptr;_X0_*runtime.mheap;_X1_uintptr;_X2_**runtime.mspan;_X3_runtime.spanClass_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.mheap;_X1_uintptr;_X2_**runtime.mspan;_X3_runtime.spanClass_};

typedef struct runtime.mheap runtime.mheap, *Pruntime.mheap;

typedef struct runtime.pageAlloc runtime.pageAlloc, *Pruntime.pageAlloc;

typedef struct []*runtime.mspan []*runtime.mspan, *P[]*runtime.mspan;

typedef struct internal/cpu.CacheLinePad internal/cpu.CacheLinePad, *Pinternal/cpu.CacheLinePad;

typedef struct runtime.linearAlloc runtime.linearAlloc, *Pruntime.linearAlloc;

typedef struct struct_{_runtime.base_uintptr;_runtime.end_uintptr_} struct_{_runtime.base_uintptr;_runtime.end_uintptr_}, *Pstruct_{_runtime.base_uintptr;_runtime.end_uintptr_};

typedef struct struct_{_runtime.mcentral_runtime.mcentral;_runtime.pad_[24]uint8_} struct_{_runtime.mcentral_runtime.mcentral;_runtime.pad_[24]uint8_}, *Pstruct_{_runtime.mcentral_runtime.mcentral;_runtime.pad_[24]uint8_};

typedef struct runtime.fixalloc runtime.fixalloc, *Pruntime.fixalloc;

typedef struct struct_{_runtime.arenaHints_*runtime.arenaHint;_runtime.quarantineList_runtime.mSpanList;_runtime.readyList_runtime.mSpanList_} struct_{_runtime.arenaHints_*runtime.arenaHint;_runtime.quarantineList_runtime.mSpanList;_runtime.readyList_runtime.mSpanList_}, *Pstruct_{_runtime.arenaHints_*runtime.arenaHint;_runtime.quarantineList_runtime.mSpanList;_runtime.readyList_runtime.mSpanList_};

typedef struct runtime.specialfinalizer runtime.specialfinalizer, *Pruntime.specialfinalizer;

typedef struct runtime.mlink runtime.mlink, *Pruntime.mlink;

struct runtime.fixalloc {
    uintptr size;
    void (**first)(void *, void *);
    void *arg;
    struct runtime.mlink *list;
    uintptr chunk;
    uint32 nchunk;
    uint32 nalloc;
    uintptr inuse;
    runtime.sysMemStat *stat;
    bool zero;
};

struct struct_{_runtime.base_uintptr;_runtime.end_uintptr_} { // Original name: struct { runtime.base uintptr; runtime.end uintptr }
    uintptr base;
    uintptr end;
};

struct struct_{_runtime.arenaHints_*runtime.arenaHint;_runtime.quarantineList_runtime.mSpanList;_runtime.readyList_runtime.mSpanList_} { // Original name: struct { runtime.arenaHints *runtime.arenaHint; runtime.quarantineList runtime.mSpanList; runtime.readyList runtime.mSpanList }
    struct runtime.arenaHint *arenaHints;
    struct runtime.mSpanList quarantineList;
    struct runtime.mSpanList readyList;
};

struct runtime.pageAlloc {
    struct []runtime.pallocSum summary[5];
    struct runtime.pallocData (*chunks[8192])[8192];
    struct runtime.offAddr searchAddr;
    runtime.chunkIdx start;
    runtime.chunkIdx end;
    struct runtime.addrRanges inUse;
    struct struct_{_runtime.index_runtime.scavengeIndex;_runtime.releasedBg_runtime/internal/atomic.Uintptr;_runtime.releasedEager_runtime/internal/atomic.Uintptr_} scav;
    struct runtime.mutex *mheapLock;
    runtime.sysMemStat *sysStat;
    uintptr summaryMappedReady;
    bool chunkHugePages;
    bool test;
};

struct runtime.linearAlloc {
    uintptr next;
    uintptr mapped;
    uintptr end;
    bool mapMemory;
};

struct []*runtime.mspan {
    struct runtime.mspan **array;
    int len;
    int cap;
};

struct internal/cpu.CacheLinePad {
    uint8 _[64];
};

struct struct_{_runtime.mcentral_runtime.mcentral;_runtime.pad_[24]uint8_} { // Original name: struct { runtime.mcentral runtime.mcentral; runtime.pad [24]uint8 }
    struct runtime.mcentral mcentral;
    uint8 pad[24];
};

struct runtime.mheap {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.mutex lock;
    struct runtime.pageAlloc pages;
    uint32 sweepgen;
    struct []*runtime.mspan allspans;
    struct runtime/internal/atomic.Uintptr pagesInUse;
    struct runtime/internal/atomic.Uint64 pagesSwept;
    struct runtime/internal/atomic.Uint64 pagesSweptBasis;
    uint64 sweepHeapLiveBasis;
    float64 sweepPagesPerByte;
    struct runtime/internal/atomic.Uint64 reclaimIndex;
    struct runtime/internal/atomic.Uintptr reclaimCredit;
    struct internal/cpu.CacheLinePad _;
    struct runtime.heapArena *(*arenas[64])[1048576];
    bool arenasHugePages;
    struct runtime.linearAlloc heapArenaAlloc;
    struct runtime.arenaHint *arenaHints;
    struct runtime.linearAlloc arena;
    struct []runtime.arenaIdx allArenas;
    struct []runtime.arenaIdx sweepArenas;
    struct []runtime.arenaIdx markArenas;
    struct struct_{_runtime.base_uintptr;_runtime.end_uintptr_} curArena;
    struct struct_{_runtime.mcentral_runtime.mcentral;_runtime.pad_[24]uint8_} central[136];
    struct runtime.fixalloc spanalloc;
    struct runtime.fixalloc cachealloc;
    struct runtime.fixalloc specialfinalizeralloc;
    struct runtime.fixalloc specialprofilealloc;
    struct runtime.fixalloc specialReachableAlloc;
    struct runtime.fixalloc specialPinCounterAlloc;
    struct runtime.mutex speciallock;
    struct runtime.fixalloc arenaHintAlloc;
    struct struct_{_runtime.arenaHints_*runtime.arenaHint;_runtime.quarantineList_runtime.mSpanList;_runtime.readyList_runtime.mSpanList_} userArena;
    struct runtime.specialfinalizer *unused;
};

struct runtime.specialfinalizer {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.special special;
    struct runtime.funcval *fn;
    uintptr nret;
    struct internal/abi.Type *fint;
    struct internal/abi.PtrType *ot;
};

struct runtime.mlink {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.mlink *next;
};

struct noalg.struct_{_F_uintptr;_X0_*runtime.mheap;_X1_uintptr;_X2_**runtime.mspan;_X3_runtime.spanClass_} { // Original name: noalg.struct { F uintptr; X0 *runtime.mheap; X1 uintptr; X2 **runtime.mspan; X3 runtime.spanClass }
    uintptr F;
    struct runtime.mheap *X0;
    uintptr X1;
    struct runtime.mspan **X2;
    runtime.spanClass X3;
};

typedef struct reflect.abiSeq reflect.abiSeq, *Preflect.abiSeq;

typedef struct []reflect.abiStep []reflect.abiStep, *P[]reflect.abiStep;

typedef struct reflect.abiStep reflect.abiStep, *Preflect.abiStep;

struct []reflect.abiStep {
    struct reflect.abiStep *array;
    int len;
    int cap;
};

struct reflect.abiSeq {
    struct []reflect.abiStep steps;
    struct []int valueStart;
    uintptr stackBytes;
    int iregs;
    int fregs;
};

struct reflect.abiStep {
    reflect.abiStepKind kind;
    uintptr offset;
    uintptr size;
    uintptr stkOff;
    int ireg;
    int freg;
};

typedef struct runtime.consistentHeapStats runtime.consistentHeapStats, *Pruntime.consistentHeapStats;

struct runtime.consistentHeapStats {
    struct runtime.heapStatsDelta stats[3];
    struct runtime/internal/atomic.Uint32 gen;
    struct runtime.mutex noPLock;
};

typedef struct noalg.struct_{_F_uintptr;_X0_uintptr_} noalg.struct_{_F_uintptr;_X0_uintptr_}, *Pnoalg.struct_{_F_uintptr;_X0_uintptr_};

struct noalg.struct_{_F_uintptr;_X0_uintptr_} { // Original name: noalg.struct { F uintptr; X0 uintptr }
    uintptr F;
    uintptr X0;
};

typedef struct struct_{_runtime.lock_runtime.mutex;_runtime.reuse_[]runtime.liveUserArenaChunk;_runtime.fault_[]runtime.liveUserArenaChunk_} struct_{_runtime.lock_runtime.mutex;_runtime.reuse_[]runtime.liveUserArenaChunk;_runtime.fault_[]runtime.liveUserArenaChunk_}, *Pstruct_{_runtime.lock_runtime.mutex;_runtime.reuse_[]runtime.liveUserArenaChunk;_runtime.fault_[]runtime.liveUserArenaChunk_};

struct struct_{_runtime.lock_runtime.mutex;_runtime.reuse_[]runtime.liveUserArenaChunk;_runtime.fault_[]runtime.liveUserArenaChunk_} { // Original name: struct { runtime.lock runtime.mutex; runtime.reuse []runtime.liveUserArenaChunk; runtime.fault []runtime.liveUserArenaChunk }
    struct runtime.mutex lock;
    struct []runtime.liveUserArenaChunk reuse;
    struct []runtime.liveUserArenaChunk fault;
};

typedef struct syscall.Open_multivalue_return_type syscall.Open_multivalue_return_type, *Psyscall.Open_multivalue_return_type;

struct syscall.Open_multivalue_return_type { // Artificial data type to hold a function's return values
    syscall.Handle fd; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct runtime.pinnerBits runtime.pinnerBits, *Pruntime.pinnerBits;

struct runtime.pinnerBits {
    struct runtime/internal/sys.NotInHeap _;
    uint8 x;
};

typedef struct syscall.WSAEnumProtocols_multivalue_return_type syscall.WSAEnumProtocols_multivalue_return_type, *Psyscall.WSAEnumProtocols_multivalue_return_type;

struct syscall.WSAEnumProtocols_multivalue_return_type { // Artificial data type to hold a function's return values
    int32 n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct runtime.traceRegionAlloc runtime.traceRegionAlloc, *Pruntime.traceRegionAlloc;

struct runtime.traceRegionAlloc {
    struct runtime.traceRegionAllocBlock *head;
    uintptr off;
};

typedef struct struct_{_runtime.lock_runtime.mutex;_runtime.free_[35]runtime.mSpanList_} struct_{_runtime.lock_runtime.mutex;_runtime.free_[35]runtime.mSpanList_}, *Pstruct_{_runtime.lock_runtime.mutex;_runtime.free_[35]runtime.mSpanList_};

struct struct_{_runtime.lock_runtime.mutex;_runtime.free_[35]runtime.mSpanList_} { // Original name: struct { runtime.lock runtime.mutex; runtime.free [35]runtime.mSpanList }
    struct runtime.mutex lock;
    struct runtime.mSpanList free[35];
};

typedef struct crypto/sha256.digest crypto/sha256.digest, *Pcrypto/sha256.digest;

struct crypto/sha256.digest {
    uint32 h[8];
    uint8 x[64];
    int nx;
    uint64 len;
    bool is224;
};

typedef struct runtime.callbackArgs runtime.callbackArgs, *Pruntime.callbackArgs;

struct runtime.callbackArgs {
    uintptr index;
    void *args;
    uintptr result;
    uintptr retPop;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*struct_{_runtime.base_runtime.offAddr;_runtime.bound_runtime.offAddr_}_} noalg.struct_{_F_uintptr;_X0_*struct_{_runtime.base_runtime.offAddr;_runtime.bound_runtime.offAddr_}_}, *Pnoalg.struct_{_F_uintptr;_X0_*struct_{_runtime.base_runtime.offAddr;_runtime.bound_runtime.offAddr_}_};

struct noalg.struct_{_F_uintptr;_X0_*struct_{_runtime.base_runtime.offAddr;_runtime.bound_runtime.offAddr_}_} { // Original name: noalg.struct { F uintptr; X0 *struct { runtime.base runtime.offAddr; runtime.bound runtime.offAddr } }
    uintptr F;
    struct struct_{_runtime.base_runtime.offAddr;_runtime.bound_runtime.offAddr_} *X0;
};

typedef struct syscall.DLL syscall.DLL, *Psyscall.DLL;

struct syscall.DLL {
    struct string Name;
    syscall.Handle Handle;
};

typedef struct []float64 []float64, *P[]float64;

struct []float64 {
    float64 *array;
    int len;
    int cap;
};

typedef struct go.shape.310da7890f312c3e9e77825750bad066709f9dcd04a3cf1be91d69e56d19c9ef go.shape.310da7890f312c3e9e77825750bad066709f9dcd04a3cf1be91d69e56d19c9ef, *Pgo.shape.310da7890f312c3e9e77825750bad066709f9dcd04a3cf1be91d69e56d19c9ef;

struct go.shape.310da7890f312c3e9e77825750bad066709f9dcd04a3cf1be91d69e56d19c9ef {
    struct runtime.stack stack;
    uintptr stackguard0;
    uintptr stackguard1;
    struct runtime._panic *_panic;
    struct runtime._defer *_defer;
    struct runtime.m *m;
    struct runtime.gobuf sched;
    uintptr syscallsp;
    uintptr syscallpc;
    uintptr stktopsp;
    void *param;
    struct runtime/internal/atomic.Uint32 atomicstatus;
    uint32 stackLock;
    uint64 goid;
    runtime.guintptr schedlink;
    int64 waitsince;
    runtime.waitReason waitreason;
    bool preempt;
    bool preemptStop;
    bool preemptShrink;
    bool asyncSafePoint;
    bool paniconfault;
    bool gcscandone;
    bool throwsplit;
    bool activeStackChans;
    struct runtime/internal/atomic.Bool parkingOnChan;
    bool inMarkAssist;
    bool coroexit;
    int8 raceignore;
    bool nocgocallback;
    bool tracking;
    uint8 trackingSeq;
    int64 trackingStamp;
    int64 runnableTime;
    runtime.muintptr lockedm;
    uint32 sig;
    struct []uint8 writebuf;
    uintptr sigcode0;
    uintptr sigcode1;
    uintptr sigpc;
    uint64 parentGoid;
    uintptr gopc;
    struct []runtime.ancestorInfo *ancestors;
    uintptr startpc;
    uintptr racectx;
    struct runtime.sudog *waiting;
    struct []uintptr cgoCtxt;
    void *labels;
    struct runtime.timer *timer;
    struct runtime/internal/atomic.Uint32 selectDone;
    struct runtime.coro *coroarg;
    struct runtime.goroutineProfileStateHolder goroutineProfiled;
    struct runtime.gTraceState trace;
    int64 gcAssistBytes;
};

typedef struct struct_{_reflect.ityp_*internal/abi.Type;_reflect.typ_*internal/abi.Type;_reflect.hash_uint32;_reflect.__[4]uint8;_reflect.fun_[100000]unsafe.Pointer_} struct_{_reflect.ityp_*internal/abi.Type;_reflect.typ_*internal/abi.Type;_reflect.hash_uint32;_reflect.__[4]uint8;_reflect.fun_[100000]unsafe.Pointer_}, *Pstruct_{_reflect.ityp_*internal/abi.Type;_reflect.typ_*internal/abi.Type;_reflect.hash_uint32;_reflect.__[4]uint8;_reflect.fun_[100000]unsafe.Pointer_};

struct struct_{_reflect.ityp_*internal/abi.Type;_reflect.typ_*internal/abi.Type;_reflect.hash_uint32;_reflect.__[4]uint8;_reflect.fun_[100000]unsafe.Pointer_} { // Original name: struct { reflect.ityp *internal/abi.Type; reflect.typ *internal/abi.Type; reflect.hash uint32; reflect._ [4]uint8; reflect.fun [100000]unsafe.Pointer }
    struct internal/abi.Type *ityp;
    struct internal/abi.Type *typ;
    uint32 hash;
    uint8 _[4];
    void *fun[100000];
};

typedef struct strconv.NumError strconv.NumError, *Pstrconv.NumError;

struct strconv.NumError {
    struct string Func;
    struct string Num;
    error Err;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*runtime.p_} noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*runtime.p_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*runtime.p_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*runtime.p_} { // Original name: noalg.struct { F uintptr; X0 *runtime.g; X1 *runtime.p }
    uintptr F;
    struct runtime.g *X0;
    struct runtime.p *X1;
};

typedef struct []float32 []float32, *P[]float32;

struct []float32 {
    float32 *array;
    int len;
    int cap;
};

typedef struct strconv.atof64_multivalue_return_type strconv.atof64_multivalue_return_type, *Pstrconv.atof64_multivalue_return_type;

struct strconv.atof64_multivalue_return_type { // Artificial data type to hold a function's return values
    float64 f; // ordinal: 0
    int n; // ordinal: 1
    error err; // ordinal: 2
};

typedef struct syscall.ByteSliceFromString_multivalue_return_type syscall.ByteSliceFromString_multivalue_return_type, *Psyscall.ByteSliceFromString_multivalue_return_type;

struct syscall.ByteSliceFromString_multivalue_return_type { // Artificial data type to hold a function's return values
    struct []uint8 ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.mspan_} noalg.struct_{_F_uintptr;_X0_*runtime.mspan_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.mspan_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.mspan_} { // Original name: noalg.struct { F uintptr; X0 *runtime.mspan }
    uintptr F;
    struct runtime.mspan *X0;
};

typedef struct struct_{_runtime.item_runtime.stackpoolItem;_runtime.__[40]uint8_} struct_{_runtime.item_runtime.stackpoolItem;_runtime.__[40]uint8_}, *Pstruct_{_runtime.item_runtime.stackpoolItem;_runtime.__[40]uint8_};

typedef struct runtime.stackpoolItem runtime.stackpoolItem, *Pruntime.stackpoolItem;

struct runtime.stackpoolItem {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.mutex mu;
    struct runtime.mSpanList span;
};

struct struct_{_runtime.item_runtime.stackpoolItem;_runtime.__[40]uint8_} { // Original name: struct { runtime.item runtime.stackpoolItem; runtime._ [40]uint8 }
    struct runtime.stackpoolItem item;
    uint8 _[40];
};

typedef struct golang.org/x/crypto/chacha20.Cipher golang.org/x/crypto/chacha20.Cipher, *Pgolang.org/x/crypto/chacha20.Cipher;

struct golang.org/x/crypto/chacha20.Cipher {
    uint32 key[8];
    uint32 counter;
    uint32 nonce[3];
    uint8 buf[64];
    int len;
    bool overflow;
    bool precompDone;
    uint32 p1;
    uint32 p5;
    uint32 p9;
    uint32 p13;
    uint32 p2;
    uint32 p6;
    uint32 p10;
    uint32 p14;
    uint32 p3;
    uint32 p7;
    uint32 p11;
    uint32 p15;
};

typedef struct syscall.LazyDLL syscall.LazyDLL, *Psyscall.LazyDLL;

struct syscall.LazyDLL {
    struct sync.Mutex mu;
    struct syscall.DLL *dll;
    struct string Name;
};

typedef struct runtime.spanSetBlock runtime.spanSetBlock, *Pruntime.spanSetBlock;

typedef struct runtime.atomicMSpanPointer runtime.atomicMSpanPointer, *Pruntime.atomicMSpanPointer;

struct runtime.atomicMSpanPointer {
    struct runtime/internal/atomic.UnsafePointer p;
};

struct runtime.spanSetBlock {
    struct runtime.lfnode lfnode;
    struct runtime/internal/atomic.Uint32 popped;
    struct runtime.atomicMSpanPointer spans[512];
};

typedef struct noalg.struct_{_F_uintptr;_X0_*int_} noalg.struct_{_F_uintptr;_X0_*int_}, *Pnoalg.struct_{_F_uintptr;_X0_*int_};

struct noalg.struct_{_F_uintptr;_X0_*int_} { // Original name: noalg.struct { F uintptr; X0 *int }
    uintptr F;
    int *X0;
};

typedef struct runtime.errorString runtime.errorString, *Pruntime.errorString;

struct runtime.errorString {
    uint8 *str;
    int len;
};

typedef struct []runtime.StackRecord []runtime.StackRecord, *P[]runtime.StackRecord;

typedef struct runtime.StackRecord runtime.StackRecord, *Pruntime.StackRecord;

struct runtime.StackRecord {
    uintptr Stack0[32];
};

struct []runtime.StackRecord {
    struct runtime.StackRecord *array;
    int len;
    int cap;
};

typedef struct runtime.iface sort.Interface;

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.mcache_} noalg.struct_{_F_uintptr;_X0_*runtime.mcache_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.mcache_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.mcache_} { // Original name: noalg.struct { F uintptr; X0 *runtime.mcache }
    uintptr F;
    struct runtime.mcache *X0;
};

typedef struct fmt.scanError fmt.scanError, *Pfmt.scanError;

struct fmt.scanError {
    error err;
};

typedef struct syscall.loadsystemlibrary_multivalue_return_type syscall.loadsystemlibrary_multivalue_return_type, *Psyscall.loadsystemlibrary_multivalue_return_type;

struct syscall.loadsystemlibrary_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr handle; // ordinal: 0
    uintptr err; // ordinal: 1
};

typedef struct runtime.specialsIter runtime.specialsIter, *Pruntime.specialsIter;

struct runtime.specialsIter {
    struct runtime.special **pprev;
    struct runtime.special *s;
};

typedef struct runtime/internal/atomic.Pointer[go.shape.struct_{_runtime.lfnode;_runtime.popped_runtime/internal/atomic.Uint32;_runtime.spans_[512]runtime.atomicMSpanPointer_}] runtime/internal/atomic.Pointer[go.shape.struct_{_runtime.lfnode;_runtime.popped_runtime/internal/atomic.Uint32;_runtime.spans_[512]runtime.atomicMSpanPointer_}], *Pruntime/internal/atomic.Pointer[go.shape.struct_{_runtime.lfnode;_runtime.popped_runtime/internal/atomic.Uint32;_runtime.spans_[512]runtime.atomicMSpanPointer_}];

struct runtime/internal/atomic.Pointer[go.shape.struct_{_runtime.lfnode;_runtime.popped_runtime/internal/atomic.Uint32;_runtime.spans_[512]runtime.atomicMSpanPointer_}] { // Original name: runtime/internal/atomic.Pointer[go.shape.struct { runtime.lfnode; runtime.popped runtime/internal/atomic.Uint32; runtime.spans [512]runtime.atomicMSpanPointer }]
    struct runtime/internal/atomic.UnsafePointer u;
};

typedef struct syscall.Proc syscall.Proc, *Psyscall.Proc;

struct syscall.Proc {
    struct syscall.DLL *Dll;
    struct string Name;
    uintptr addr;
};

typedef struct hash<runtime.winCallbackKey,int> hash<runtime.winCallbackKey,int>, *Phash<runtime.winCallbackKey,int>;

struct hash<runtime.winCallbackKey,int> {
    int count;
    uint8 flags;
    uint8 B;
    uint16 noverflow;
    uint32 hash0;
    struct bucket<runtime.winCallbackKey,int> *buckets;
    struct bucket<runtime.winCallbackKey,int> *oldbuckets;
    uintptr nevacuate;
    struct runtime.mapextra *extra;
};

typedef struct runtime.errorAddressString runtime.errorAddressString, *Pruntime.errorAddressString;

struct runtime.errorAddressString {
    struct string msg;
    uintptr addr;
};

typedef struct runtime.gcControllerState runtime.gcControllerState, *Pruntime.gcControllerState;

typedef struct runtime/internal/atomic.Float64 runtime/internal/atomic.Float64, *Pruntime/internal/atomic.Float64;

struct runtime/internal/atomic.Float64 {
    struct runtime/internal/atomic.Uint64 u;
};

struct runtime.gcControllerState {
    struct runtime/internal/atomic.Int32 gcPercent;
    struct runtime/internal/atomic.Int64 memoryLimit;
    uint64 heapMinimum;
    struct runtime/internal/atomic.Uint64 runway;
    float64 consMark;
    float64 lastConsMark[4];
    struct runtime/internal/atomic.Uint64 gcPercentHeapGoal;
    struct runtime/internal/atomic.Uint64 sweepDistMinTrigger;
    uint64 triggered;
    uint64 lastHeapGoal;
    struct runtime/internal/atomic.Uint64 heapLive;
    struct runtime/internal/atomic.Uint64 heapScan;
    uint64 lastHeapScan;
    struct runtime/internal/atomic.Uint64 lastStackScan;
    struct runtime/internal/atomic.Uint64 maxStackScan;
    struct runtime/internal/atomic.Uint64 globalsScan;
    uint64 heapMarked;
    struct runtime/internal/atomic.Int64 heapScanWork;
    struct runtime/internal/atomic.Int64 stackScanWork;
    struct runtime/internal/atomic.Int64 globalsScanWork;
    struct runtime/internal/atomic.Int64 bgScanCredit;
    struct runtime/internal/atomic.Int64 assistTime;
    struct runtime/internal/atomic.Int64 dedicatedMarkTime;
    struct runtime/internal/atomic.Int64 fractionalMarkTime;
    struct runtime/internal/atomic.Int64 idleMarkTime;
    int64 markStartTime;
    struct runtime/internal/atomic.Int64 dedicatedMarkWorkersNeeded;
    struct runtime/internal/atomic.Uint64 idleMarkWorkers;
    struct runtime/internal/atomic.Float64 assistWorkPerByte;
    struct runtime/internal/atomic.Float64 assistBytesPerWork;
    float64 fractionalUtilizationGoal;
    runtime.sysMemStat heapInUse;
    runtime.sysMemStat heapReleased;
    runtime.sysMemStat heapFree;
    struct runtime/internal/atomic.Uint64 totalAlloc;
    struct runtime/internal/atomic.Uint64 totalFree;
    struct runtime/internal/atomic.Uint64 mappedReady;
    bool test;
    struct internal/cpu.CacheLinePad _;
};

typedef struct strconv.eiselLemire64_multivalue_return_type strconv.eiselLemire64_multivalue_return_type, *Pstrconv.eiselLemire64_multivalue_return_type;

struct strconv.eiselLemire64_multivalue_return_type { // Artificial data type to hold a function's return values
    float64 f; // ordinal: 0
    bool ok; // ordinal: 1
};

typedef struct runtime.traceWriter.ensure_multivalue_return_type runtime.traceWriter.ensure_multivalue_return_type, *Pruntime.traceWriter.ensure_multivalue_return_type;

struct runtime.traceWriter.ensure_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.traceWriter ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct encoding/binary.littleEndian encoding/binary.littleEndian, *Pencoding/binary.littleEndian;

struct encoding/binary.littleEndian {
};

typedef struct runtime.(*pageAlloc).sysGrow.func1_multivalue_return_type runtime.(*pageAlloc).sysGrow.func1_multivalue_return_type, *Pruntime.(*pageAlloc).sysGrow.func1_multivalue_return_type;

struct runtime.(*pageAlloc).sysGrow.func1_multivalue_return_type { // Artificial data type to hold a function's return values
    int ~r0; // ordinal: 0
    int ~r1; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.pageAlloc_} noalg.struct_{_F_uintptr;_X0_*runtime.pageAlloc_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.pageAlloc_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.pageAlloc_} { // Original name: noalg.struct { F uintptr; X0 *runtime.pageAlloc }
    uintptr F;
    struct runtime.pageAlloc *X0;
};

typedef struct struct_{_runtime.user_bool;_runtime.runnable_runtime.gQueue;_runtime.n_int32_} struct_{_runtime.user_bool;_runtime.runnable_runtime.gQueue;_runtime.n_int32_}, *Pstruct_{_runtime.user_bool;_runtime.runnable_runtime.gQueue;_runtime.n_int32_};

struct struct_{_runtime.user_bool;_runtime.runnable_runtime.gQueue;_runtime.n_int32_} { // Original name: struct { runtime.user bool; runtime.runnable runtime.gQueue; runtime.n int32 }
    bool user;
    struct runtime.gQueue runnable;
    int32 n;
};

typedef struct os.getModuleFileName_multivalue_return_type os.getModuleFileName_multivalue_return_type, *Pos.getModuleFileName_multivalue_return_type;

struct os.getModuleFileName_multivalue_return_type { // Artificial data type to hold a function's return values
    struct string ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct runtime/internal/atomic.Pointer[go.shape.func()] runtime/internal/atomic.Pointer[go.shape.func()], *Pruntime/internal/atomic.Pointer[go.shape.func()];

struct runtime/internal/atomic.Pointer[go.shape.func()] {
    struct runtime/internal/atomic.UnsafePointer u;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.traceMap;_X1_*uint64;_X2_unsafe.Pointer;_X3_uintptr;_X4_uintptr;_X5_*bool_} noalg.struct_{_F_uintptr;_X0_*runtime.traceMap;_X1_*uint64;_X2_unsafe.Pointer;_X3_uintptr;_X4_uintptr;_X5_*bool_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.traceMap;_X1_*uint64;_X2_unsafe.Pointer;_X3_uintptr;_X4_uintptr;_X5_*bool_};

typedef struct runtime.traceMap runtime.traceMap, *Pruntime.traceMap;

struct runtime.traceMap {
    struct runtime.mutex lock;
    struct runtime/internal/atomic.Uint64 seq;
    struct runtime.traceRegionAlloc mem;
    struct runtime/internal/atomic.UnsafePointer tab[8192];
};

struct noalg.struct_{_F_uintptr;_X0_*runtime.traceMap;_X1_*uint64;_X2_unsafe.Pointer;_X3_uintptr;_X4_uintptr;_X5_*bool_} { // Original name: noalg.struct { F uintptr; X0 *runtime.traceMap; X1 *uint64; X2 unsafe.Pointer; X3 uintptr; X4 uintptr; X5 *bool }
    uintptr F;
    struct runtime.traceMap *X0;
    uint64 *X1;
    void *X2;
    uintptr X3;
    uintptr X4;
    bool *X5;
};

typedef struct runtime.traceStackTable runtime.traceStackTable, *Pruntime.traceStackTable;

struct runtime.traceStackTable {
    struct runtime.traceMap tab;
};

typedef struct runtime.adjustinfo runtime.adjustinfo, *Pruntime.adjustinfo;

struct runtime.adjustinfo {
    struct runtime.stack old;
    uintptr delta;
    uintptr sghi;
};

typedef struct reflect.structType reflect.structType, *Preflect.structType;

typedef struct internal/abi.StructType internal/abi.StructType, *Pinternal/abi.StructType;

typedef struct []internal/abi.StructField []internal/abi.StructField, *P[]internal/abi.StructField;

struct []internal/abi.StructField {
    struct internal/abi.StructField *array;
    int len;
    int cap;
};

struct internal/abi.StructType {
    struct internal/abi.Type Type;
    struct internal/abi.Name PkgPath;
    struct []internal/abi.StructField Fields;
};

struct reflect.structType {
    struct internal/abi.StructType StructType;
};

typedef struct internal/poll.operation internal/poll.operation, *Pinternal/poll.operation;

typedef struct internal/poll.FD internal/poll.FD, *Pinternal/poll.FD;

typedef struct internal/syscall/windows.WSAMsg internal/syscall/windows.WSAMsg, *Pinternal/syscall/windows.WSAMsg;

typedef struct runtime.iface syscall.Sockaddr;

typedef struct internal/poll.pollDesc internal/poll.pollDesc, *Pinternal/poll.pollDesc;

typedef struct []uint16 []uint16, *P[]uint16;

typedef struct struct_{} *syscall.Pointer;

struct []uint16 {
    uint16 *array;
    int len;
    int cap;
};

struct internal/poll.pollDesc {
    uintptr runtimeCtx;
};

struct internal/syscall/windows.WSAMsg {
    syscall.Pointer Name;
    int32 Namelen;
    struct syscall.WSABuf *Buffers;
    uint32 BufferCount;
    struct syscall.WSABuf Control;
    uint32 Flags;
};

struct internal/poll.operation {
    struct syscall.Overlapped o;
    uintptr runtimeCtx;
    int32 mode;
    int32 errno;
    uint32 qty;
    struct internal/poll.FD *fd;
    struct syscall.WSABuf buf;
    struct internal/syscall/windows.WSAMsg msg;
    syscall.Sockaddr sa;
    struct syscall.RawSockaddrAny *rsa;
    int32 rsan;
    syscall.Handle handle;
    uint32 flags;
    struct []syscall.WSABuf bufs;
};

struct internal/poll.FD {
    struct internal/poll.fdMutex fdmu;
    syscall.Handle Sysfd;
    struct internal/poll.operation rop;
    struct internal/poll.operation wop;
    struct internal/poll.pollDesc pd;
    struct sync.Mutex l;
    struct []uint8 lastbits;
    struct []uint16 readuint16;
    struct []uint8 readbyte;
    int readbyteOffset;
    uint32 csema;
    bool skipSyncNotif;
    bool IsStream;
    bool ZeroReadIsEOF;
    bool isFile;
    internal/poll.fileKind kind;
};

typedef struct sync.Pool sync.Pool, *Psync.Pool;

struct sync.Pool {
    struct sync.noCopy noCopy;
    void *local;
    uintptr localSize;
    void *victim;
    uintptr victimSize;
    void (**New)(interface_{} *);
};

typedef struct []*runtime.g []*runtime.g, *P[]*runtime.g;

struct []*runtime.g {
    struct runtime.g **array;
    int len;
    int cap;
};

typedef struct []*runtime.p []*runtime.p, *P[]*runtime.p;

struct []*runtime.p {
    struct runtime.p **array;
    int len;
    int cap;
};

typedef struct runtime.semaRoot runtime.semaRoot, *Pruntime.semaRoot;

struct runtime.semaRoot {
    struct runtime.mutex lock;
    struct runtime.sudog *treap;
    struct runtime/internal/atomic.Uint32 nwait;
};

typedef struct runtime.Frames runtime.Frames, *Pruntime.Frames;

typedef struct []runtime.Frame []runtime.Frame, *P[]runtime.Frame;

struct []runtime.Frame {
    struct runtime.Frame *array;
    int len;
    int cap;
};

struct runtime.Frames {
    struct []uintptr callers;
    struct []runtime.Frame frames;
    struct runtime.Frame frameStore[2];
};

typedef struct struct_{_runtime.enabled_bool;_runtime.pad_[3]uint8;_runtime.alignme_uint64_} struct_{_runtime.enabled_bool;_runtime.pad_[3]uint8;_runtime.alignme_uint64_}, *Pstruct_{_runtime.enabled_bool;_runtime.pad_[3]uint8;_runtime.alignme_uint64_};

struct struct_{_runtime.enabled_bool;_runtime.pad_[3]uint8;_runtime.alignme_uint64_} { // Original name: struct { runtime.enabled bool; runtime.pad [3]uint8; runtime.alignme uint64 }
    bool enabled;
    uint8 pad[3];
    uint64 alignme;
};

typedef struct runtime.iface fmt.Scanner;

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_int64_} noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_int64_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_int64_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_int64_} { // Original name: noalg.struct { F uintptr; X0 *runtime.g; X1 int64 }
    uintptr F;
    struct runtime.g *X0;
    int64 X1;
};

typedef struct runtime.iface interface_{_Is(error)_bool_};

typedef struct struct_{_runtime.sema_uint32;_runtime.active_bool;_runtime.offset_runtime/internal/atomic.Int64;_runtime.records_[]runtime.StackRecord;_runtime.labels_[]unsafe.Pointer_} struct_{_runtime.sema_uint32;_runtime.active_bool;_runtime.offset_runtime/internal/atomic.Int64;_runtime.records_[]runtime.StackRecord;_runtime.labels_[]unsafe.Pointer_}, *Pstruct_{_runtime.sema_uint32;_runtime.active_bool;_runtime.offset_runtime/internal/atomic.Int64;_runtime.records_[]runtime.StackRecord;_runtime.labels_[]unsafe.Pointer_};

struct struct_{_runtime.sema_uint32;_runtime.active_bool;_runtime.offset_runtime/internal/atomic.Int64;_runtime.records_[]runtime.StackRecord;_runtime.labels_[]unsafe.Pointer_} { // Original name: struct { runtime.sema uint32; runtime.active bool; runtime.offset runtime/internal/atomic.Int64; runtime.records []runtime.StackRecord; runtime.labels []unsafe.Pointer }
    uint32 sema;
    bool active;
    struct runtime/internal/atomic.Int64 offset;
    struct []runtime.StackRecord records;
    struct []unsafe.Pointer labels;
};

typedef struct syscall.DLLError syscall.DLLError, *Psyscall.DLLError;

struct syscall.DLLError {
    error Err;
    struct string ObjName;
    struct string Msg;
};

typedef struct syscall.GetStdHandle_multivalue_return_type syscall.GetStdHandle_multivalue_return_type, *Psyscall.GetStdHandle_multivalue_return_type;

struct syscall.GetStdHandle_multivalue_return_type { // Artificial data type to hold a function's return values
    syscall.Handle handle; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct struct_{_internal/testlog.mu_sync.Mutex;_internal/testlog.val_bool_} struct_{_internal/testlog.mu_sync.Mutex;_internal/testlog.val_bool_}, *Pstruct_{_internal/testlog.mu_sync.Mutex;_internal/testlog.val_bool_};

struct struct_{_internal/testlog.mu_sync.Mutex;_internal/testlog.val_bool_} { // Original name: struct { internal/testlog.mu sync.Mutex; internal/testlog.val bool }
    struct sync.Mutex mu;
    bool val;
};

typedef struct internal/poll.execIO_multivalue_return_type internal/poll.execIO_multivalue_return_type, *Pinternal/poll.execIO_multivalue_return_type;

struct internal/poll.execIO_multivalue_return_type { // Artificial data type to hold a function's return values
    int ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct os.dirInfo os.dirInfo, *Pos.dirInfo;

struct os.dirInfo {
    struct []uint8 *buf;
    int bufp;
    uint32 vol;
    uint32 class;
    struct string path;
};

typedef struct runtime/internal/atomic.Pointer[func()] runtime/internal/atomic.Pointer[func()], *Pruntime/internal/atomic.Pointer[func()];

struct runtime/internal/atomic.Pointer[func()] {
    struct runtime/internal/atomic.UnsafePointer u;
};

typedef struct runtime.iface crypto/cipher.AEAD;

typedef struct runtime.blockRecord runtime.blockRecord, *Pruntime.blockRecord;

struct runtime.blockRecord {
    float64 count;
    int64 cycles;
};

typedef struct os.OpenFile_multivalue_return_type os.OpenFile_multivalue_return_type, *Pos.OpenFile_multivalue_return_type;

typedef struct os.File os.File, *Pos.File;

typedef struct os.file os.file, *Pos.file;

struct os.file {
    struct internal/poll.FD pfd;
    struct string name;
    struct os.dirInfo *dirinfo;
    bool appendMode;
};

struct os.File {
    struct os.file *file;
};

struct os.OpenFile_multivalue_return_type { // Artificial data type to hold a function's return values
    struct os.File *~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct runtime.(*piController).next_multivalue_return_type runtime.(*piController).next_multivalue_return_type, *Pruntime.(*piController).next_multivalue_return_type;

struct runtime.(*piController).next_multivalue_return_type { // Artificial data type to hold a function's return values
    float64 ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct runtime.srcFunc runtime.srcFunc, *Pruntime.srcFunc;

struct runtime.srcFunc {
    struct runtime.moduledata *datap;
    int32 nameOff;
    int32 startLine;
    internal/abi.FuncID funcID;
};

typedef struct bucket<string,bool> bucket<string,bool>, *Pbucket<string,bool>;

struct bucket<string,bool> {
    uint8 tophash[8];
    struct string keys[8];
    bool values[8];
    struct bucket<string,bool> *overflow;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*uintptr;_X1_*runtime.pageAlloc;_X2_runtime.chunkIdx;_X3_uint;_X4_uintptr_} noalg.struct_{_F_uintptr;_X0_*uintptr;_X1_*runtime.pageAlloc;_X2_runtime.chunkIdx;_X3_uint;_X4_uintptr_}, *Pnoalg.struct_{_F_uintptr;_X0_*uintptr;_X1_*runtime.pageAlloc;_X2_runtime.chunkIdx;_X3_uint;_X4_uintptr_};

struct noalg.struct_{_F_uintptr;_X0_*uintptr;_X1_*runtime.pageAlloc;_X2_runtime.chunkIdx;_X3_uint;_X4_uintptr_} { // Original name: noalg.struct { F uintptr; X0 *uintptr; X1 *runtime.pageAlloc; X2 runtime.chunkIdx; X3 uint; X4 uintptr }
    uintptr F;
    uintptr *X0;
    struct runtime.pageAlloc *X1;
    runtime.chunkIdx X2;
    uint X3;
    uintptr X4;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_uintptr;_X2_uintptr;_X3_*uint32_} noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_uintptr;_X2_uintptr;_X3_*uint32_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_uintptr;_X2_uintptr;_X3_*uint32_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_uintptr;_X2_uintptr;_X3_*uint32_} { // Original name: noalg.struct { F uintptr; X0 *runtime.g; X1 uintptr; X2 uintptr; X3 *uint32 }
    uintptr F;
    struct runtime.g *X0;
    uintptr X1;
    uintptr X2;
    uint32 *X3;
};

typedef struct sync/atomic.Pointer[go.shape.struct_{_sync.m_map[interface_{}]*sync.entry;_sync.amended_bool_}] sync/atomic.Pointer[go.shape.struct_{_sync.m_map[interface_{}]*sync.entry;_sync.amended_bool_}], *Psync/atomic.Pointer[go.shape.struct_{_sync.m_map[interface_{}]*sync.entry;_sync.amended_bool_}];

struct sync/atomic.Pointer[go.shape.struct_{_sync.m_map[interface_{}]*sync.entry;_sync.amended_bool_}] { // Original name: sync/atomic.Pointer[go.shape.struct { sync.m map[interface {}]*sync.entry; sync.amended bool }]
    struct sync/atomic.noCopy _;
    struct go.shape.struct_{_sync.m_map[interface_{}]*sync.entry;_sync.amended_bool_} *_[0];
    void *v;
};

typedef struct struct_{_runtime.lock_runtime.mutex;_runtime.stack_runtime.gList;_runtime.noStack_runtime.gList;_runtime.n_int32_} struct_{_runtime.lock_runtime.mutex;_runtime.stack_runtime.gList;_runtime.noStack_runtime.gList;_runtime.n_int32_}, *Pstruct_{_runtime.lock_runtime.mutex;_runtime.stack_runtime.gList;_runtime.noStack_runtime.gList;_runtime.n_int32_};

struct struct_{_runtime.lock_runtime.mutex;_runtime.stack_runtime.gList;_runtime.noStack_runtime.gList;_runtime.n_int32_} { // Original name: struct { runtime.lock runtime.mutex; runtime.stack runtime.gList; runtime.noStack runtime.gList; runtime.n int32 }
    struct runtime.mutex lock;
    struct runtime.gList stack;
    struct runtime.gList noStack;
    int32 n;
};

typedef struct internal/poll.(*FD).Init_multivalue_return_type internal/poll.(*FD).Init_multivalue_return_type, *Pinternal/poll.(*FD).Init_multivalue_return_type;

struct internal/poll.(*FD).Init_multivalue_return_type { // Artificial data type to hold a function's return values
    struct string ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct runtime.(*mheap).grow_multivalue_return_type runtime.(*mheap).grow_multivalue_return_type, *Pruntime.(*mheap).grow_multivalue_return_type;

struct runtime.(*mheap).grow_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_*runtime.g;_X3_*int;_X4_int;_X5_*runtime.mLockProfile_} noalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_*runtime.g;_X3_*int;_X4_int;_X5_*runtime.mLockProfile_}, *Pnoalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_*runtime.g;_X3_*int;_X4_int;_X5_*runtime.mLockProfile_};

struct noalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_*runtime.g;_X3_*int;_X4_int;_X5_*runtime.mLockProfile_} { // Original name: noalg.struct { F uintptr; X0 uintptr; X1 uintptr; X2 *runtime.g; X3 *int; X4 int; X5 *runtime.mLockProfile }
    uintptr F;
    uintptr X0;
    uintptr X1;
    struct runtime.g *X2;
    int *X3;
    int X4;
    struct runtime.mLockProfile *X5;
};

typedef struct hash<int32,unsafe.Pointer> hash<int32,unsafe.Pointer>, *Phash<int32,unsafe.Pointer>;

struct hash<int32,unsafe.Pointer> {
    int count;
    uint8 flags;
    uint8 B;
    uint16 noverflow;
    uint32 hash0;
    struct bucket<int32,unsafe.Pointer> *buckets;
    struct bucket<int32,unsafe.Pointer> *oldbuckets;
    uintptr nevacuate;
    struct runtime.mapextra *extra;
};

typedef struct golang.org/x/crypto/chacha20poly1305.(*chacha20poly1305).open_multivalue_return_type golang.org/x/crypto/chacha20poly1305.(*chacha20poly1305).open_multivalue_return_type, *Pgolang.org/x/crypto/chacha20poly1305.(*chacha20poly1305).open_multivalue_return_type;

struct golang.org/x/crypto/chacha20poly1305.(*chacha20poly1305).open_multivalue_return_type { // Artificial data type to hold a function's return values
    struct []uint8 ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct runtime.rwmutex runtime.rwmutex, *Pruntime.rwmutex;

struct runtime.rwmutex {
    struct runtime.mutex rLock;
    runtime.muintptr readers;
    uint32 readerPass;
    struct runtime.mutex wLock;
    runtime.muintptr writer;
    struct runtime/internal/atomic.Int32 readerCount;
    struct runtime/internal/atomic.Int32 readerWait;
    runtime.lockRank readRank;
};

typedef struct struct_{_runtime.root_runtime.semaRoot;_runtime.pad_[40]uint8_} struct_{_runtime.root_runtime.semaRoot;_runtime.pad_[40]uint8_}, *Pstruct_{_runtime.root_runtime.semaRoot;_runtime.pad_[40]uint8_};

struct struct_{_runtime.root_runtime.semaRoot;_runtime.pad_[40]uint8_} { // Original name: struct { runtime.root runtime.semaRoot; runtime.pad [40]uint8 }
    struct runtime.semaRoot root;
    uint8 pad[40];
};

typedef struct runtime/internal/atomic.Pointer[go.shape.struct_{_runtime.heap_bool;_runtime.rangefunc_bool;_runtime.sp_uintptr;_runtime.pc_uintptr;_runtime.fn_func();_runtime.link_*runtime._defer;_runtime.head_*runtime/internal/atomic.Pointer[runtime._defer]_}] runtime/internal/atomic.Pointer[go.shape.struct_{_runtime.heap_bool;_runtime.rangefunc_bool;_runtime.sp_uintptr;_runtime.pc_uintptr;_runtime.fn_func();_runtime.link_*runtime._defer;_runtime.head_*runtime/internal/atomic.Pointer[runtime._defer]_}], *Pruntime/internal/atomic.Pointer[go.shape.struct_{_runtime.heap_bool;_runtime.rangefunc_bool;_runtime.sp_uintptr;_runtime.pc_uintptr;_runtime.fn_func();_runtime.link_*runtime._defer;_runtime.head_*runtime/internal/atomic.Pointer[runtime._defer]_}];

struct runtime/internal/atomic.Pointer[go.shape.struct_{_runtime.heap_bool;_runtime.rangefunc_bool;_runtime.sp_uintptr;_runtime.pc_uintptr;_runtime.fn_func();_runtime.link_*runtime._defer;_runtime.head_*runtime/internal/atomic.Pointer[runtime._defer]_}] { // Original name: runtime/internal/atomic.Pointer[go.shape.struct { runtime.heap bool; runtime.rangefunc bool; runtime.sp uintptr; runtime.pc uintptr; runtime.fn func(); runtime.link *runtime._defer; runtime.head *runtime/internal/atomic.Pointer[runtime._defer] }]
    struct runtime/internal/atomic.UnsafePointer u;
};

typedef struct runtime.gcTrigger runtime.gcTrigger, *Pruntime.gcTrigger;

struct runtime.gcTrigger {
    runtime.gcTriggerKind kind;
    int64 now;
    uint32 n;
};

typedef struct runtime.winCallback runtime.winCallback, *Pruntime.winCallback;

typedef struct runtime.abiDesc runtime.abiDesc, *Pruntime.abiDesc;

struct runtime.abiDesc {
    struct []runtime.abiPart parts;
    uintptr srcStackSize;
    uintptr dstStackSize;
    uintptr dstSpill;
    int dstRegisters;
    uintptr retOffset;
};

struct runtime.winCallback {
    struct runtime.funcval *fn;
    uintptr retPop;
    struct runtime.abiDesc abiMap;
};

typedef struct syscall.LazyProc syscall.LazyProc, *Psyscall.LazyProc;

struct syscall.LazyProc {
    struct sync.Mutex mu;
    struct string Name;
    struct syscall.LazyDLL *l;
    struct syscall.Proc *proc;
};

typedef struct runtime.(*scavengerState).init.func2_multivalue_return_type runtime.(*scavengerState).init.func2_multivalue_return_type, *Pruntime.(*scavengerState).init.func2_multivalue_return_type;

struct runtime.(*scavengerState).init.func2_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr ~r0; // ordinal: 0
    int64 ~r1; // ordinal: 1
};

typedef struct runtime.mProfCycleHolder runtime.mProfCycleHolder, *Pruntime.mProfCycleHolder;

struct runtime.mProfCycleHolder {
    struct runtime/internal/atomic.Uint32 value;
};

typedef struct runtime.traceBufQueue runtime.traceBufQueue, *Pruntime.traceBufQueue;

struct runtime.traceBufQueue {
    struct runtime.traceBuf *head;
    struct runtime.traceBuf *tail;
};

typedef struct runtime.iface fmt.Formatter;

typedef struct syscall.Getenv_multivalue_return_type syscall.Getenv_multivalue_return_type, *Psyscall.Getenv_multivalue_return_type;

struct syscall.Getenv_multivalue_return_type { // Artificial data type to hold a function's return values
    struct string value; // ordinal: 0
    bool found; // ordinal: 1
};

typedef struct syscall.CreateFile_multivalue_return_type syscall.CreateFile_multivalue_return_type, *Psyscall.CreateFile_multivalue_return_type;

struct syscall.CreateFile_multivalue_return_type { // Artificial data type to hold a function's return values
    syscall.Handle handle; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct go.shape.string go.shape.string, *Pgo.shape.string;

struct go.shape.string {
    uint8 *str;
    int len;
};

typedef struct runtime.sweepLocked runtime.sweepLocked, *Pruntime.sweepLocked;

struct runtime.sweepLocked {
    struct runtime.mspan *mspan;
};

typedef struct []sync.poolLocal []sync.poolLocal, *P[]sync.poolLocal;

struct []sync.poolLocal {
    struct sync.poolLocal *array;
    int len;
    int cap;
};

typedef struct reflect.hiter reflect.hiter, *Preflect.hiter;

struct reflect.hiter {
    void *key;
    void *elem;
    void *t;
    void *h;
    void *buckets;
    void *bptr;
    struct []unsafe.Pointer *overflow;
    struct []unsafe.Pointer *oldoverflow;
    uintptr startBucket;
    uint8 offset;
    bool wrapped;
    uint8 B;
    uint8 i;
    uintptr bucket;
    uintptr checkBucket;
};

typedef struct runtime/internal/atomic.Pointer[string] runtime/internal/atomic.Pointer[string], *Pruntime/internal/atomic.Pointer[string];

struct runtime/internal/atomic.Pointer[string] {
    struct runtime/internal/atomic.UnsafePointer u;
};

typedef struct runtime.cgothreadstart runtime.cgothreadstart, *Pruntime.cgothreadstart;

struct runtime.cgothreadstart {
    runtime.guintptr g;
    uint64 *tls;
    void *fn;
};

typedef struct runtime.plainError runtime.plainError, *Pruntime.plainError;

struct runtime.plainError {
    uint8 *str;
    int len;
};

typedef struct noalg.struct_{_F_uintptr;_X0_runtime.worldStop_} noalg.struct_{_F_uintptr;_X0_runtime.worldStop_}, *Pnoalg.struct_{_F_uintptr;_X0_runtime.worldStop_};

struct noalg.struct_{_F_uintptr;_X0_runtime.worldStop_} { // Original name: noalg.struct { F uintptr; X0 runtime.worldStop }
    uintptr F;
    struct runtime.worldStop X0;
};

typedef struct strconv.atof64exact_multivalue_return_type strconv.atof64exact_multivalue_return_type, *Pstrconv.atof64exact_multivalue_return_type;

struct strconv.atof64exact_multivalue_return_type { // Artificial data type to hold a function's return values
    float64 f; // ordinal: 0
    bool ok; // ordinal: 1
};

typedef struct internal/abi.UncommonType internal/abi.UncommonType, *Pinternal/abi.UncommonType;

struct internal/abi.UncommonType {
    internal/abi.NameOff PkgPath;
    uint16 Mcount;
    uint16 Xcount;
    uint32 Moff;
    uint32 _;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.traceWriter_} noalg.struct_{_F_uintptr;_X0_*runtime.traceWriter_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.traceWriter_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.traceWriter_} { // Original name: noalg.struct { F uintptr; X0 *runtime.traceWriter }
    uintptr F;
    struct runtime.traceWriter *X0;
};

typedef struct runtime.mapaccessK_multivalue_return_type runtime.mapaccessK_multivalue_return_type, *Pruntime.mapaccessK_multivalue_return_type;

struct runtime.mapaccessK_multivalue_return_type { // Artificial data type to hold a function's return values
    void *~r0; // ordinal: 0
    void *~r1; // ordinal: 1
};

typedef struct runtime.stackmap runtime.stackmap, *Pruntime.stackmap;

struct runtime.stackmap {
    int32 n;
    int32 nbit;
    uint8 bytedata[1];
};

typedef struct noalg.struct_{_F_uintptr;_X0_*error_} noalg.struct_{_F_uintptr;_X0_*error_}, *Pnoalg.struct_{_F_uintptr;_X0_*error_};

struct noalg.struct_{_F_uintptr;_X0_*error_} { // Original name: noalg.struct { F uintptr; X0 *error }
    uintptr F;
    error *X0;
};

typedef struct runtime.stackScanState runtime.stackScanState, *Pruntime.stackScanState;

struct runtime.stackScanState {
    struct runtime.stack stack;
    bool conservative;
    struct runtime.stackWorkBuf *buf;
    struct runtime.stackWorkBuf *freeBuf;
    struct runtime.stackWorkBuf *cbuf;
    struct runtime.stackObjectBuf *head;
    struct runtime.stackObjectBuf *tail;
    int nobjs;
    struct runtime.stackObject *root;
};

typedef struct runtime.finalizer runtime.finalizer, *Pruntime.finalizer;

struct runtime.finalizer {
    struct runtime.funcval *fn;
    void *arg;
    uintptr nret;
    struct internal/abi.Type *fint;
    struct internal/abi.PtrType *ot;
};

typedef struct runtime.pidlegetSpinning_multivalue_return_type runtime.pidlegetSpinning_multivalue_return_type, *Pruntime.pidlegetSpinning_multivalue_return_type;

struct runtime.pidlegetSpinning_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.p *~r0; // ordinal: 0
    int64 ~r1; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_*internal/poll.FD_} noalg.struct_{_F_uintptr;_X0_*internal/poll.FD_}, *Pnoalg.struct_{_F_uintptr;_X0_*internal/poll.FD_};

struct noalg.struct_{_F_uintptr;_X0_*internal/poll.FD_} { // Original name: noalg.struct { F uintptr; X0 *internal/poll.FD }
    uintptr F;
    struct internal/poll.FD *X0;
};

typedef struct strconv.atof32exact_multivalue_return_type strconv.atof32exact_multivalue_return_type, *Pstrconv.atof32exact_multivalue_return_type;

struct strconv.atof32exact_multivalue_return_type { // Artificial data type to hold a function's return values
    float32 f; // ordinal: 0
    bool ok; // ordinal: 1
};

typedef struct runtime/internal/atomic.Pointer[runtime.g] runtime/internal/atomic.Pointer[runtime.g], *Pruntime/internal/atomic.Pointer[runtime.g];

struct runtime/internal/atomic.Pointer[runtime.g] {
    struct runtime/internal/atomic.UnsafePointer u;
};

typedef struct runtime.stringStruct runtime.stringStruct, *Pruntime.stringStruct;

struct runtime.stringStruct {
    void *str;
    int len;
};

typedef struct runtime.lockTimer runtime.lockTimer, *Pruntime.lockTimer;

struct runtime.lockTimer {
    struct runtime.mutex *lock;
    int64 timeRate;
    int64 timeStart;
    int64 tickStart;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.g_} noalg.struct_{_F_uintptr;_X0_*runtime.g_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.g_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.g_} { // Original name: noalg.struct { F uintptr; X0 *runtime.g }
    uintptr F;
    struct runtime.g *X0;
};

typedef struct reflect.StructField reflect.StructField, *Preflect.StructField;

struct reflect.StructField {
    struct string Name;
    struct string PkgPath;
    reflect.Type Type;
    struct reflect.StructTag Tag;
    uintptr Offset;
    struct []int Index;
    bool Anonymous;
};

typedef struct syscall.LoadDLL_multivalue_return_type syscall.LoadDLL_multivalue_return_type, *Psyscall.LoadDLL_multivalue_return_type;

struct syscall.LoadDLL_multivalue_return_type { // Artificial data type to hold a function's return values
    struct syscall.DLL *~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct os.(*File).Write_multivalue_return_type os.(*File).Write_multivalue_return_type, *Pos.(*File).Write_multivalue_return_type;

struct os.(*File).Write_multivalue_return_type { // Artificial data type to hold a function's return values
    int n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct struct_{_runtime.lock_runtime.mutex;_runtime.q_runtime.gQueue_} struct_{_runtime.lock_runtime.mutex;_runtime.q_runtime.gQueue_}, *Pstruct_{_runtime.lock_runtime.mutex;_runtime.q_runtime.gQueue_};

struct struct_{_runtime.lock_runtime.mutex;_runtime.q_runtime.gQueue_} { // Original name: struct { runtime.lock runtime.mutex; runtime.q runtime.gQueue }
    struct runtime.mutex lock;
    struct runtime.gQueue q;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_runtime.stwReason_} noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_runtime.stwReason_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_runtime.stwReason_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_runtime.stwReason_} { // Original name: noalg.struct { F uintptr; X0 *runtime.g; X1 runtime.stwReason }
    uintptr F;
    struct runtime.g *X0;
    runtime.stwReason X1;
};

typedef struct sync.(*Pool).pinSlow_multivalue_return_type sync.(*Pool).pinSlow_multivalue_return_type, *Psync.(*Pool).pinSlow_multivalue_return_type;

struct sync.(*Pool).pinSlow_multivalue_return_type { // Artificial data type to hold a function's return values
    struct sync.poolLocal *~r0; // ordinal: 0
    int ~r1; // ordinal: 1
};

typedef struct runtime.specialReachable runtime.specialReachable, *Pruntime.specialReachable;

struct runtime.specialReachable {
    struct runtime.special special;
    bool done;
    bool reachable;
};

typedef struct runtime.step_multivalue_return_type runtime.step_multivalue_return_type, *Pruntime.step_multivalue_return_type;

struct runtime.step_multivalue_return_type { // Artificial data type to hold a function's return values
    struct []uint8 newp; // ordinal: 0
    bool ok; // ordinal: 1
};

typedef struct os.Executable_multivalue_return_type os.Executable_multivalue_return_type, *Pos.Executable_multivalue_return_type;

struct os.Executable_multivalue_return_type { // Artificial data type to hold a function's return values
    struct string ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct runtime.iface interface_{_Unwrap()_[]error_};

typedef struct runtime.(*stkframe).getStackMap_multivalue_return_type runtime.(*stkframe).getStackMap_multivalue_return_type, *Pruntime.(*stkframe).getStackMap_multivalue_return_type;

struct runtime.(*stkframe).getStackMap_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.bitvector locals; // ordinal: 0
    struct runtime.bitvector args; // ordinal: 1
    struct []runtime.stackObjectRecord objs; // ordinal: 2
};

typedef struct struct_{_reflect.b_bool;_reflect.x_interface_{}_} struct_{_reflect.b_bool;_reflect.x_interface_{}_}, *Pstruct_{_reflect.b_bool;_reflect.x_interface_{}_};

struct struct_{_reflect.b_bool;_reflect.x_interface_{}_} { // Original name: struct { reflect.b bool; reflect.x interface {} }
    bool b;
    interface_{} x;
};

typedef struct noalg.struct_{_F_uintptr;_X0_uintptr;_X1_*runtime.g_} noalg.struct_{_F_uintptr;_X0_uintptr;_X1_*runtime.g_}, *Pnoalg.struct_{_F_uintptr;_X0_uintptr;_X1_*runtime.g_};

struct noalg.struct_{_F_uintptr;_X0_uintptr;_X1_*runtime.g_} { // Original name: noalg.struct { F uintptr; X0 uintptr; X1 *runtime.g }
    uintptr F;
    uintptr X0;
    struct runtime.g *X1;
};

typedef struct noalg.struct_{_F_uintptr;_X0_runtime.traceLocker;_X1_*runtime.g_} noalg.struct_{_F_uintptr;_X0_runtime.traceLocker;_X1_*runtime.g_}, *Pnoalg.struct_{_F_uintptr;_X0_runtime.traceLocker;_X1_*runtime.g_};

struct noalg.struct_{_F_uintptr;_X0_runtime.traceLocker;_X1_*runtime.g_} { // Original name: noalg.struct { F uintptr; X0 runtime.traceLocker; X1 *runtime.g }
    uintptr F;
    struct runtime.traceLocker X0;
    struct runtime.g *X1;
};

typedef struct strconv.(*decimal).floatBits_multivalue_return_type strconv.(*decimal).floatBits_multivalue_return_type, *Pstrconv.(*decimal).floatBits_multivalue_return_type;

struct strconv.(*decimal).floatBits_multivalue_return_type { // Artificial data type to hold a function's return values
    uint64 b; // ordinal: 0
    bool overflow; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_*interface_{};_X1_*bool;_X2_*go.shape.bool;_X3_*func()_go.shape.bool;_X4_*[3]uintptr_} noalg.struct_{_F_uintptr;_X0_*interface_{};_X1_*bool;_X2_*go.shape.bool;_X3_*func()_go.shape.bool;_X4_*[3]uintptr_}, *Pnoalg.struct_{_F_uintptr;_X0_*interface_{};_X1_*bool;_X2_*go.shape.bool;_X3_*func()_go.shape.bool;_X4_*[3]uintptr_};

struct noalg.struct_{_F_uintptr;_X0_*interface_{};_X1_*bool;_X2_*go.shape.bool;_X3_*func()_go.shape.bool;_X4_*[3]uintptr_} { // Original name: noalg.struct { F uintptr; X0 *interface {}; X1 *bool; X2 *go.shape.bool; X3 *func() go.shape.bool; X4 *[3]uintptr }
    uintptr F;
    interface_{} *X0;
    bool *X1;
    go.shape.bool *X2;
    void (***X3)(go.shape.bool *);
    uintptr (*X4)[3];
};

typedef struct hash<int32,unsafe.Pointer> *map[int32]unsafe.Pointer;

typedef struct runtime.stringStructDWARF runtime.stringStructDWARF, *Pruntime.stringStructDWARF;

struct runtime.stringStructDWARF {
    uint8 *str;
    int len;
};

typedef struct struct_{_internal/cpu.__internal/cpu.CacheLinePad;_HasAES_bool;_HasADX_bool;_HasAVX_bool;_HasAVX2_bool;_HasAVX512F_bool;_HasAVX512BW_bool;_HasAVX512VL_bool;_HasBMI1_bool;_HasBMI2_bool;_HasERMS_bool;_HasFMA_bool;_HasOSXSAVE_bool;_HasPCLMULQDQ_bool;_HasPOPCNT_bool;_HasRDTSCP_bool;_HasSHA_bool;_HasSSE3_bool;_HasSSSE3_bool;_HasSSE41_bool;_HasSSE42_bool;_internal/cpu.__internal/cpu.CacheLinePad_} struct_{_internal/cpu.__internal/cpu.CacheLinePad;_HasAES_bool;_HasADX_bool;_HasAVX_bool;_HasAVX2_bool;_HasAVX512F_bool;_HasAVX512BW_bool;_HasAVX512VL_bool;_HasBMI1_bool;_HasBMI2_bool;_HasERMS_bool;_HasFMA_bool;_HasOSXSAVE_bool;_HasPCLMULQDQ_bool;_HasPOPCNT_bool;_HasRDTSCP_bool;_HasSHA_bool;_HasSSE3_bool;_HasSSSE3_bool;_HasSSE41_bool;_HasSSE42_bool;_internal/cpu.__internal/cpu.CacheLinePad_}, *Pstruct_{_internal/cpu.__internal/cpu.CacheLinePad;_HasAES_bool;_HasADX_bool;_HasAVX_bool;_HasAVX2_bool;_HasAVX512F_bool;_HasAVX512BW_bool;_HasAVX512VL_bool;_HasBMI1_bool;_HasBMI2_bool;_HasERMS_bool;_HasFMA_bool;_HasOSXSAVE_bool;_HasPCLMULQDQ_bool;_HasPOPCNT_bool;_HasRDTSCP_bool;_HasSHA_bool;_HasSSE3_bool;_HasSSSE3_bool;_HasSSE41_bool;_HasSSE42_bool;_internal/cpu.__internal/cpu.CacheLinePad_};

struct struct_{_internal/cpu.__internal/cpu.CacheLinePad;_HasAES_bool;_HasADX_bool;_HasAVX_bool;_HasAVX2_bool;_HasAVX512F_bool;_HasAVX512BW_bool;_HasAVX512VL_bool;_HasBMI1_bool;_HasBMI2_bool;_HasERMS_bool;_HasFMA_bool;_HasOSXSAVE_bool;_HasPCLMULQDQ_bool;_HasPOPCNT_bool;_HasRDTSCP_bool;_HasSHA_bool;_HasSSE3_bool;_HasSSSE3_bool;_HasSSE41_bool;_HasSSE42_bool;_internal/cpu.__internal/cpu.CacheLinePad_} { // Original name: struct { internal/cpu._ internal/cpu.CacheLinePad; HasAES bool; HasADX bool; HasAVX bool; HasAVX2 bool; HasAVX512F bool; HasAVX512BW bool; HasAVX512VL bool; HasBMI1 bool; HasBMI2 bool; HasERMS bool; HasFMA bool; HasOSXSAVE bool; HasPCLMULQDQ bool; HasPOPCNT bool; HasRDTSCP bool; HasSHA bool; HasSSE3 bool; HasSSSE3 bool; HasSSE41 bool; HasSSE42 bool; internal/cpu._ internal/cpu.CacheLinePad }
    struct internal/cpu.CacheLinePad _;
    bool HasAES;
    bool HasADX;
    bool HasAVX;
    bool HasAVX2;
    bool HasAVX512F;
    bool HasAVX512BW;
    bool HasAVX512VL;
    bool HasBMI1;
    bool HasBMI2;
    bool HasERMS;
    bool HasFMA;
    bool HasOSXSAVE;
    bool HasPCLMULQDQ;
    bool HasPOPCNT;
    bool HasRDTSCP;
    bool HasSHA;
    bool HasSSE3;
    bool HasSSSE3;
    bool HasSSE41;
    bool HasSSE42;
    struct internal/cpu.CacheLinePad _;
};

typedef struct runtime.pcdatavalue2_multivalue_return_type runtime.pcdatavalue2_multivalue_return_type, *Pruntime.pcdatavalue2_multivalue_return_type;

struct runtime.pcdatavalue2_multivalue_return_type { // Artificial data type to hold a function's return values
    int32 ~r0; // ordinal: 0
    uintptr ~r1; // ordinal: 1
};

typedef struct errors.errorString errors.errorString, *Perrors.errorString;

struct errors.errorString {
    struct string s;
};

typedef struct runtime.memRecord runtime.memRecord, *Pruntime.memRecord;

struct runtime.memRecord {
    struct runtime.memRecordCycle active;
    struct runtime.memRecordCycle future[3];
};

typedef struct noalg.struct_{_F_uintptr;_X0_*int;_X1_*int;_X2_*int;_X3_*int_} noalg.struct_{_F_uintptr;_X0_*int;_X1_*int;_X2_*int;_X3_*int_}, *Pnoalg.struct_{_F_uintptr;_X0_*int;_X1_*int;_X2_*int;_X3_*int_};

struct noalg.struct_{_F_uintptr;_X0_*int;_X1_*int;_X2_*int;_X3_*int_} { // Original name: noalg.struct { F uintptr; X0 *int; X1 *int; X2 *int; X3 *int }
    uintptr F;
    int *X0;
    int *X1;
    int *X2;
    int *X3;
};

typedef struct struct_{_runtime.note_runtime.note;_runtime.mask_[3]uint32;_runtime.wanted_[3]uint32;_runtime.ignored_[3]uint32;_runtime.recv_[3]uint32;_runtime.state_runtime/internal/atomic.Uint32;_runtime.delivering_runtime/internal/atomic.Uint32;_runtime.inuse_bool_} struct_{_runtime.note_runtime.note;_runtime.mask_[3]uint32;_runtime.wanted_[3]uint32;_runtime.ignored_[3]uint32;_runtime.recv_[3]uint32;_runtime.state_runtime/internal/atomic.Uint32;_runtime.delivering_runtime/internal/atomic.Uint32;_runtime.inuse_bool_}, *Pstruct_{_runtime.note_runtime.note;_runtime.mask_[3]uint32;_runtime.wanted_[3]uint32;_runtime.ignored_[3]uint32;_runtime.recv_[3]uint32;_runtime.state_runtime/internal/atomic.Uint32;_runtime.delivering_runtime/internal/atomic.Uint32;_runtime.inuse_bool_};

struct struct_{_runtime.note_runtime.note;_runtime.mask_[3]uint32;_runtime.wanted_[3]uint32;_runtime.ignored_[3]uint32;_runtime.recv_[3]uint32;_runtime.state_runtime/internal/atomic.Uint32;_runtime.delivering_runtime/internal/atomic.Uint32;_runtime.inuse_bool_} { // Original name: struct { runtime.note runtime.note; runtime.mask [3]uint32; runtime.wanted [3]uint32; runtime.ignored [3]uint32; runtime.recv [3]uint32; runtime.state runtime/internal/atomic.Uint32; runtime.delivering runtime/internal/atomic.Uint32; runtime.inuse bool }
    struct runtime.note note;
    uint32 mask[3];
    uint32 wanted[3];
    uint32 ignored[3];
    uint32 recv[3];
    struct runtime/internal/atomic.Uint32 state;
    struct runtime/internal/atomic.Uint32 delivering;
    bool inuse;
};

typedef struct strconv.decimal strconv.decimal, *Pstrconv.decimal;

struct strconv.decimal {
    uint8 d[800];
    int nd;
    int dp;
    bool neg;
    bool trunc;
};

typedef struct fmt.(*readRune).ReadRune_multivalue_return_type fmt.(*readRune).ReadRune_multivalue_return_type, *Pfmt.(*readRune).ReadRune_multivalue_return_type;

struct fmt.(*readRune).ReadRune_multivalue_return_type { // Artificial data type to hold a function's return values
    int32 rr; // ordinal: 0
    int size; // ordinal: 1
    error err; // ordinal: 2
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.mspan;_X1_*runtime.mheap_} noalg.struct_{_F_uintptr;_X0_*runtime.mspan;_X1_*runtime.mheap_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.mspan;_X1_*runtime.mheap_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.mspan;_X1_*runtime.mheap_} { // Original name: noalg.struct { F uintptr; X0 *runtime.mspan; X1 *runtime.mheap }
    uintptr F;
    struct runtime.mspan *X0;
    struct runtime.mheap *X1;
};

typedef struct [][2]uint16 [][2]uint16, *P[][2]uint16;

struct [][2]uint16 {
    uint16 (*array)[2];
    int len;
    int cap;
};

typedef struct internal/poll.(*FD).Read_multivalue_return_type internal/poll.(*FD).Read_multivalue_return_type, *Pinternal/poll.(*FD).Read_multivalue_return_type;

struct internal/poll.(*FD).Read_multivalue_return_type { // Artificial data type to hold a function's return values
    int ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct runtime.traceMapNode runtime.traceMapNode, *Pruntime.traceMapNode;

struct runtime.traceMapNode {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime/internal/atomic.UnsafePointer link;
    uintptr hash;
    uint64 id;
    struct []uint8 data;
};

typedef struct noalg.struct_{_F_uintptr;_X0_**runtime.mcache_} noalg.struct_{_F_uintptr;_X0_**runtime.mcache_}, *Pnoalg.struct_{_F_uintptr;_X0_**runtime.mcache_};

struct noalg.struct_{_F_uintptr;_X0_**runtime.mcache_} { // Original name: noalg.struct { F uintptr; X0 **runtime.mcache }
    uintptr F;
    struct runtime.mcache **X0;
};

typedef struct runtime.debugCallWrapArgs runtime.debugCallWrapArgs, *Pruntime.debugCallWrapArgs;

struct runtime.debugCallWrapArgs {
    uintptr dispatch;
    struct runtime.g *callingG;
};

typedef struct noalg.struct_{_F_uintptr;_X0_unsafe.Pointer;_X1_int32;_X2_uint8_} noalg.struct_{_F_uintptr;_X0_unsafe.Pointer;_X1_int32;_X2_uint8_}, *Pnoalg.struct_{_F_uintptr;_X0_unsafe.Pointer;_X1_int32;_X2_uint8_};

struct noalg.struct_{_F_uintptr;_X0_unsafe.Pointer;_X1_int32;_X2_uint8_} { // Original name: noalg.struct { F uintptr; X0 unsafe.Pointer; X1 int32; X2 uint8 }
    uintptr F;
    void *X0;
    int32 X1;
    uint8 X2;
};

typedef struct fmt.Fprintf_multivalue_return_type fmt.Fprintf_multivalue_return_type, *Pfmt.Fprintf_multivalue_return_type;

struct fmt.Fprintf_multivalue_return_type { // Artificial data type to hold a function's return values
    int n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct runtime.(*stkframe).argMapInternal_multivalue_return_type runtime.(*stkframe).argMapInternal_multivalue_return_type, *Pruntime.(*stkframe).argMapInternal_multivalue_return_type;

struct runtime.(*stkframe).argMapInternal_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.bitvector argMap; // ordinal: 0
    bool hasReflectStackObj; // ordinal: 1
};

typedef struct runtime/internal/atomic.Pointer[func(string)_func()] runtime/internal/atomic.Pointer[func(string)_func()], *Pruntime/internal/atomic.Pointer[func(string)_func()];

struct runtime/internal/atomic.Pointer[func(string)_func()] { // Original name: runtime/internal/atomic.Pointer[func(string) func()]
    struct runtime/internal/atomic.UnsafePointer u;
};

typedef struct runtime.isAsyncSafePoint_multivalue_return_type runtime.isAsyncSafePoint_multivalue_return_type, *Pruntime.isAsyncSafePoint_multivalue_return_type;

struct runtime.isAsyncSafePoint_multivalue_return_type { // Artificial data type to hold a function's return values
    bool ~r0; // ordinal: 0
    uintptr ~r1; // ordinal: 1
};

typedef struct hash<unsafe.Pointer,int32> hash<unsafe.Pointer,int32>, *Phash<unsafe.Pointer,int32>;

typedef struct hash<unsafe.Pointer,int32> *map[unsafe.Pointer]int32;

struct hash<unsafe.Pointer,int32> {
    int count;
    uint8 flags;
    uint8 B;
    uint16 noverflow;
    uint32 hash0;
    struct bucket<unsafe.Pointer,int32> *buckets;
    struct bucket<unsafe.Pointer,int32> *oldbuckets;
    uintptr nevacuate;
    struct runtime.mapextra *extra;
};

typedef struct strconv.ParseFloat_multivalue_return_type strconv.ParseFloat_multivalue_return_type, *Pstrconv.ParseFloat_multivalue_return_type;

struct strconv.ParseFloat_multivalue_return_type { // Artificial data type to hold a function's return values
    float64 ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct go.shape.struct_{_runtime.lfnode;_runtime.popped_runtime/internal/atomic.Uint32;_runtime.spans_[512]runtime.atomicMSpanPointer_} go.shape.struct_{_runtime.lfnode;_runtime.popped_runtime/internal/atomic.Uint32;_runtime.spans_[512]runtime.atomicMSpanPointer_}, *Pgo.shape.struct_{_runtime.lfnode;_runtime.popped_runtime/internal/atomic.Uint32;_runtime.spans_[512]runtime.atomicMSpanPointer_};

struct go.shape.struct_{_runtime.lfnode;_runtime.popped_runtime/internal/atomic.Uint32;_runtime.spans_[512]runtime.atomicMSpanPointer_} { // Original name: go.shape.struct { runtime.lfnode; runtime.popped runtime/internal/atomic.Uint32; runtime.spans [512]runtime.atomicMSpanPointer }
    struct runtime.lfnode lfnode;
    struct runtime/internal/atomic.Uint32 popped;
    struct runtime.atomicMSpanPointer spans[512];
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.p_} noalg.struct_{_F_uintptr;_X0_*runtime.p_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.p_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.p_} { // Original name: noalg.struct { F uintptr; X0 *runtime.p }
    uintptr F;
    struct runtime.p *X0;
};

typedef struct struct_{_runtime.root_runtime.semaRoot;_runtime.pad_[40]uint8_} runtime.semTable[251];

typedef struct fmt.(*readRune).readByte_multivalue_return_type fmt.(*readRune).readByte_multivalue_return_type, *Pfmt.(*readRune).readByte_multivalue_return_type;

struct fmt.(*readRune).readByte_multivalue_return_type { // Artificial data type to hold a function's return values
    uint8 b; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_**runtime.mspan_} noalg.struct_{_F_uintptr;_X0_**runtime.mspan_}, *Pnoalg.struct_{_F_uintptr;_X0_**runtime.mspan_};

struct noalg.struct_{_F_uintptr;_X0_**runtime.mspan_} { // Original name: noalg.struct { F uintptr; X0 **runtime.mspan }
    uintptr F;
    struct runtime.mspan **X0;
};

typedef struct internal/poll.runtime_pollOpen_multivalue_return_type internal/poll.runtime_pollOpen_multivalue_return_type, *Pinternal/poll.runtime_pollOpen_multivalue_return_type;

struct internal/poll.runtime_pollOpen_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.pollDesc *~r0; // ordinal: 0
    int ~r1; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*int64;_X2_*runtime.gcWork_} noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*int64;_X2_*runtime.gcWork_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*int64;_X2_*runtime.gcWork_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*int64;_X2_*runtime.gcWork_} { // Original name: noalg.struct { F uintptr; X0 *runtime.g; X1 *int64; X2 *runtime.gcWork }
    uintptr F;
    struct runtime.g *X0;
    int64 *X1;
    struct runtime.gcWork *X2;
};

typedef struct reflect.methodReceiver_multivalue_return_type reflect.methodReceiver_multivalue_return_type, *Preflect.methodReceiver_multivalue_return_type;

struct reflect.methodReceiver_multivalue_return_type { // Artificial data type to hold a function's return values
    struct internal/abi.Type *rcvrtype; // ordinal: 0
    struct internal/abi.FuncType *t; // ordinal: 1
    void *fn; // ordinal: 2
};

typedef struct []func()_hash.Hash []func()_hash.Hash, *P[]func()_hash.Hash;

struct []func()_hash.Hash { // Original name: []func() hash.Hash
    void (***array)(hash.Hash *);
    int len;
    int cap;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.rwmutex_} noalg.struct_{_F_uintptr;_X0_*runtime.rwmutex_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.rwmutex_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.rwmutex_} { // Original name: noalg.struct { F uintptr; X0 *runtime.rwmutex }
    uintptr F;
    struct runtime.rwmutex *X0;
};

typedef struct noalg.struct_{_F_uintptr;_X0_func(int,_runtime.addrRange)_(int,_int);_X1_func(int,_int,_int)_runtime.addrRange_} noalg.struct_{_F_uintptr;_X0_func(int,_runtime.addrRange)_(int,_int);_X1_func(int,_int,_int)_runtime.addrRange_}, *Pnoalg.struct_{_F_uintptr;_X0_func(int,_runtime.addrRange)_(int,_int);_X1_func(int,_int,_int)_runtime.addrRange_};

struct noalg.struct_{_F_uintptr;_X0_func(int,_runtime.addrRange)_(int,_int);_X1_func(int,_int,_int)_runtime.addrRange_} { // Original name: noalg.struct { F uintptr; X0 func(int, runtime.addrRange) (int, int); X1 func(int, int, int) runtime.addrRange }
    uintptr F;
    void (**X0)(int, struct runtime.addrRange, int *, int *);
    void (**X1)(int, int, int, struct runtime.addrRange *);
};

typedef struct []reflect.Value []reflect.Value, *P[]reflect.Value;

struct []reflect.Value {
    struct reflect.Value *array;
    int len;
    int cap;
};

typedef struct syscall.Syscall_multivalue_return_type syscall.Syscall_multivalue_return_type, *Psyscall.Syscall_multivalue_return_type;

struct syscall.Syscall_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr r1; // ordinal: 0
    uintptr r2; // ordinal: 1
    uintptr err; // ordinal: 2
};

typedef struct reflect.nonEmptyInterface reflect.nonEmptyInterface, *Preflect.nonEmptyInterface;

struct reflect.nonEmptyInterface {
    struct struct_{_reflect.ityp_*internal/abi.Type;_reflect.typ_*internal/abi.Type;_reflect.hash_uint32;_reflect.__[4]uint8;_reflect.fun_[100000]unsafe.Pointer_} *itab;
    void *word;
};

typedef struct runtime.TypeAssertionError runtime.TypeAssertionError, *Pruntime.TypeAssertionError;

struct runtime.TypeAssertionError {
    struct internal/abi.Type *_interface;
    struct internal/abi.Type *concrete;
    struct internal/abi.Type *asserted;
    struct string missingMethod;
};

typedef struct []internal/abi.InterfaceSwitchCacheEntry []internal/abi.InterfaceSwitchCacheEntry, *P[]internal/abi.InterfaceSwitchCacheEntry;

struct []internal/abi.InterfaceSwitchCacheEntry {
    struct internal/abi.InterfaceSwitchCacheEntry *array;
    int len;
    int cap;
};

typedef struct runtime.typePointers.next_multivalue_return_type runtime.typePointers.next_multivalue_return_type, *Pruntime.typePointers.next_multivalue_return_type;

typedef struct runtime.typePointers runtime.typePointers, *Pruntime.typePointers;

struct runtime.typePointers {
    uintptr elem;
    uintptr addr;
    uintptr mask;
    struct internal/abi.Type *typ;
};

struct runtime.typePointers.next_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.typePointers ~r0; // ordinal: 0
    uintptr ~r1; // ordinal: 1
};

typedef struct runtime.scavChunkData runtime.scavChunkData, *Pruntime.scavChunkData;

struct runtime.scavChunkData {
    uint16 inUse;
    uint16 lastInUse;
    uint32 gen;
    runtime.scavChunkFlags scavChunkFlags;
};

typedef struct sync.(*Pool).pin_multivalue_return_type sync.(*Pool).pin_multivalue_return_type, *Psync.(*Pool).pin_multivalue_return_type;

struct sync.(*Pool).pin_multivalue_return_type { // Artificial data type to hold a function's return values
    struct sync.poolLocal *~r0; // ordinal: 0
    int ~r1; // ordinal: 1
};

typedef struct strconv.Unquote_multivalue_return_type strconv.Unquote_multivalue_return_type, *Pstrconv.Unquote_multivalue_return_type;

struct strconv.Unquote_multivalue_return_type { // Artificial data type to hold a function's return values
    struct string ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct os.readNextArg_multivalue_return_type os.readNextArg_multivalue_return_type, *Pos.readNextArg_multivalue_return_type;

struct os.readNextArg_multivalue_return_type { // Artificial data type to hold a function's return values
    struct []uint8 arg; // ordinal: 0
    struct string rest; // ordinal: 1
};

typedef struct syscall.Read_multivalue_return_type syscall.Read_multivalue_return_type, *Psyscall.Read_multivalue_return_type;

struct syscall.Read_multivalue_return_type { // Artificial data type to hold a function's return values
    int n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct syscall.(*DLL).FindProc_multivalue_return_type syscall.(*DLL).FindProc_multivalue_return_type, *Psyscall.(*DLL).FindProc_multivalue_return_type;

struct syscall.(*DLL).FindProc_multivalue_return_type { // Artificial data type to hold a function's return values
    struct syscall.Proc *proc; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct runtime.traceback2.func1_multivalue_return_type runtime.traceback2.func1_multivalue_return_type, *Pruntime.traceback2.func1_multivalue_return_type;

struct runtime.traceback2.func1_multivalue_return_type { // Artificial data type to hold a function's return values
    bool pr; // ordinal: 0
    bool stop; // ordinal: 1
};

typedef struct hash<string,bool> hash<string,bool>, *Phash<string,bool>;

struct hash<string,bool> {
    int count;
    uint8 flags;
    uint8 B;
    uint16 noverflow;
    uint32 hash0;
    struct bucket<string,bool> *buckets;
    struct bucket<string,bool> *oldbuckets;
    uintptr nevacuate;
    struct runtime.mapextra *extra;
};

typedef struct runtime.schedt runtime.schedt, *Pruntime.schedt;

struct runtime.schedt {
    struct runtime/internal/atomic.Uint64 goidgen;
    struct runtime/internal/atomic.Int64 lastpoll;
    struct runtime/internal/atomic.Int64 pollUntil;
    struct runtime.mutex lock;
    runtime.muintptr midle;
    int32 nmidle;
    int32 nmidlelocked;
    int64 mnext;
    int32 maxmcount;
    int32 nmsys;
    int64 nmfreed;
    struct runtime/internal/atomic.Int32 ngsys;
    runtime.puintptr pidle;
    struct runtime/internal/atomic.Int32 npidle;
    struct runtime/internal/atomic.Int32 nmspinning;
    struct runtime/internal/atomic.Uint32 needspinning;
    struct runtime.gQueue runq;
    int32 runqsize;
    struct struct_{_runtime.user_bool;_runtime.runnable_runtime.gQueue;_runtime.n_int32_} disable;
    struct struct_{_runtime.lock_runtime.mutex;_runtime.stack_runtime.gList;_runtime.noStack_runtime.gList;_runtime.n_int32_} gFree;
    struct runtime.mutex sudoglock;
    struct runtime.sudog *sudogcache;
    struct runtime.mutex deferlock;
    struct runtime._defer *deferpool;
    struct runtime.m *freem;
    struct runtime/internal/atomic.Bool gcwaiting;
    int32 stopwait;
    struct runtime.note stopnote;
    struct runtime/internal/atomic.Bool sysmonwait;
    struct runtime.note sysmonnote;
    void (**safePointFn)(struct runtime.p *);
    int32 safePointWait;
    struct runtime.note safePointNote;
    int32 profilehz;
    int64 procresizetime;
    int64 totaltime;
    struct runtime.mutex sysmonlock;
    struct runtime.timeHistogram timeToRun;
    struct runtime/internal/atomic.Int64 idleTime;
    struct runtime/internal/atomic.Int64 totalMutexWaitTime;
    struct runtime.timeHistogram stwStoppingTimeGC;
    struct runtime.timeHistogram stwStoppingTimeOther;
    struct runtime.timeHistogram stwTotalTimeGC;
    struct runtime.timeHistogram stwTotalTimeOther;
    struct runtime/internal/atomic.Int64 totalRuntimeLockWaitTime;
};

typedef struct strconv.parseFloatPrefix_multivalue_return_type strconv.parseFloatPrefix_multivalue_return_type, *Pstrconv.parseFloatPrefix_multivalue_return_type;

struct strconv.parseFloatPrefix_multivalue_return_type { // Artificial data type to hold a function's return values
    float64 ~r0; // ordinal: 0
    int ~r1; // ordinal: 1
    error ~r2; // ordinal: 2
};

typedef struct noalg.struct_{_F_uintptr;_X0_runtime.waitReason;_X1_func(*runtime.p)_} noalg.struct_{_F_uintptr;_X0_runtime.waitReason;_X1_func(*runtime.p)_}, *Pnoalg.struct_{_F_uintptr;_X0_runtime.waitReason;_X1_func(*runtime.p)_};

struct noalg.struct_{_F_uintptr;_X0_runtime.waitReason;_X1_func(*runtime.p)_} { // Original name: noalg.struct { F uintptr; X0 runtime.waitReason; X1 func(*runtime.p) }
    uintptr F;
    runtime.waitReason X0;
    void (**X1)(struct runtime.p *);
};

typedef struct reflect.rtype reflect.rtype, *Preflect.rtype;

struct reflect.rtype {
    struct internal/abi.Type t;
};

typedef struct runtime.(*pallocData).findScavengeCandidate_multivalue_return_type runtime.(*pallocData).findScavengeCandidate_multivalue_return_type, *Pruntime.(*pallocData).findScavengeCandidate_multivalue_return_type;

struct runtime.(*pallocData).findScavengeCandidate_multivalue_return_type { // Artificial data type to hold a function's return values
    uint ~r0; // ordinal: 0
    uint ~r1; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_bool_} noalg.struct_{_F_uintptr;_X0_bool_}, *Pnoalg.struct_{_F_uintptr;_X0_bool_};

struct noalg.struct_{_F_uintptr;_X0_bool_} { // Original name: noalg.struct { F uintptr; X0 bool }
    uintptr F;
    bool X0;
};

typedef struct runtime/internal/atomic.Pointer[go.shape.func(string)_func()] runtime/internal/atomic.Pointer[go.shape.func(string)_func()], *Pruntime/internal/atomic.Pointer[go.shape.func(string)_func()];

struct runtime/internal/atomic.Pointer[go.shape.func(string)_func()] { // Original name: runtime/internal/atomic.Pointer[go.shape.func(string) func()]
    struct runtime/internal/atomic.UnsafePointer u;
};

typedef struct runtime.finblock runtime.finblock, *Pruntime.finblock;

struct runtime.finblock {
    struct runtime/internal/sys.NotInHeap _;
    struct runtime.finblock *alllink;
    struct runtime.finblock *next;
    uint32 cnt;
    int32 _;
    struct runtime.finalizer fin[101];
};

typedef struct strconv.unquote_multivalue_return_type strconv.unquote_multivalue_return_type, *Pstrconv.unquote_multivalue_return_type;

struct strconv.unquote_multivalue_return_type { // Artificial data type to hold a function's return values
    struct string out; // ordinal: 0
    struct string rem; // ordinal: 1
    error err; // ordinal: 2
};

typedef struct noalg.struct_{_F_uintptr;_X0_string_} noalg.struct_{_F_uintptr;_X0_string_}, *Pnoalg.struct_{_F_uintptr;_X0_string_};

struct noalg.struct_{_F_uintptr;_X0_string_} { // Original name: noalg.struct { F uintptr; X0 string }
    uintptr F;
    struct string X0;
};

typedef struct []golang.org/x/sys/cpu.option []golang.org/x/sys/cpu.option, *P[]golang.org/x/sys/cpu.option;

struct []golang.org/x/sys/cpu.option {
    struct golang.org/x/sys/cpu.option *array;
    int len;
    int cap;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.stkframe;_X1_uintptr_} noalg.struct_{_F_uintptr;_X0_*runtime.stkframe;_X1_uintptr_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.stkframe;_X1_uintptr_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.stkframe;_X1_uintptr_} { // Original name: noalg.struct { F uintptr; X0 *runtime.stkframe; X1 uintptr }
    uintptr F;
    struct runtime.stkframe *X0;
    uintptr X1;
};

typedef struct []internal/abi.TypeAssertCacheEntry []internal/abi.TypeAssertCacheEntry, *P[]internal/abi.TypeAssertCacheEntry;

struct []internal/abi.TypeAssertCacheEntry {
    struct internal/abi.TypeAssertCacheEntry *array;
    int len;
    int cap;
};

typedef struct runtime.slice runtime.slice, *Pruntime.slice;

struct runtime.slice {
    void *array;
    int len;
    int cap;
};

typedef struct runtime.sysReserveAligned_multivalue_return_type runtime.sysReserveAligned_multivalue_return_type, *Pruntime.sysReserveAligned_multivalue_return_type;

struct runtime.sysReserveAligned_multivalue_return_type { // Artificial data type to hold a function's return values
    void *~r0; // ordinal: 0
    uintptr ~r1; // ordinal: 1
};

typedef struct runtime.gcBgMarkWorkerNode runtime.gcBgMarkWorkerNode, *Pruntime.gcBgMarkWorkerNode;

struct runtime.gcBgMarkWorkerNode {
    struct runtime.lfnode node;
    runtime.guintptr gp;
    runtime.muintptr m;
};

typedef struct syscall.Win32FileAttributeData syscall.Win32FileAttributeData, *Psyscall.Win32FileAttributeData;

struct syscall.Win32FileAttributeData {
    uint32 FileAttributes;
    struct syscall.Filetime CreationTime;
    struct syscall.Filetime LastAccessTime;
    struct syscall.Filetime LastWriteTime;
    uint32 FileSizeHigh;
    uint32 FileSizeLow;
};

typedef struct runtime.atoi64_multivalue_return_type runtime.atoi64_multivalue_return_type, *Pruntime.atoi64_multivalue_return_type;

struct runtime.atoi64_multivalue_return_type { // Artificial data type to hold a function's return values
    int64 ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct sync.(*poolDequeue).popHead_multivalue_return_type sync.(*poolDequeue).popHead_multivalue_return_type, *Psync.(*poolDequeue).popHead_multivalue_return_type;

struct sync.(*poolDequeue).popHead_multivalue_return_type { // Artificial data type to hold a function's return values
    interface_{} ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct sync/atomic.efaceWords sync/atomic.efaceWords, *Psync/atomic.efaceWords;

struct sync/atomic.efaceWords {
    void *typ;
    void *data;
};

typedef struct strconv.leftCheat strconv.leftCheat, *Pstrconv.leftCheat;

struct strconv.leftCheat {
    int delta;
    struct string cutoff;
};

typedef struct runtime.(*semaRoot).dequeue_multivalue_return_type runtime.(*semaRoot).dequeue_multivalue_return_type, *Pruntime.(*semaRoot).dequeue_multivalue_return_type;

struct runtime.(*semaRoot).dequeue_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.sudog *found; // ordinal: 0
    int64 now; // ordinal: 1
    int64 tailtime; // ordinal: 2
};

typedef struct runtime.systeminfo runtime.systeminfo, *Pruntime.systeminfo;

struct runtime.systeminfo {
    uint8 anon0[4];
    uint32 dwpagesize;
    uint8 *lpminimumapplicationaddress;
    uint8 *lpmaximumapplicationaddress;
    uintptr dwactiveprocessormask;
    uint32 dwnumberofprocessors;
    uint32 dwprocessortype;
    uint32 dwallocationgranularity;
    uint16 wprocessorlevel;
    uint16 wprocessorrevision;
};

typedef struct strconv.ParseInt_multivalue_return_type strconv.ParseInt_multivalue_return_type, *Pstrconv.ParseInt_multivalue_return_type;

struct strconv.ParseInt_multivalue_return_type { // Artificial data type to hold a function's return values
    int64 i; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct runtime.getExtraM_multivalue_return_type runtime.getExtraM_multivalue_return_type, *Pruntime.getExtraM_multivalue_return_type;

struct runtime.getExtraM_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.m *mp; // ordinal: 0
    bool last; // ordinal: 1
};

typedef struct runtime.heapBits runtime.heapBits, *Pruntime.heapBits;

struct runtime.heapBits {
};

typedef struct noalg.struct_{_F_uintptr;_X0_*int32;_X1_func(*runtime.exceptionrecord,_*runtime.context,_*runtime.g)_int32;_X2_*runtime.exceptionpointers;_X3_*runtime.g_} noalg.struct_{_F_uintptr;_X0_*int32;_X1_func(*runtime.exceptionrecord,_*runtime.context,_*runtime.g)_int32;_X2_*runtime.exceptionpointers;_X3_*runtime.g_}, *Pnoalg.struct_{_F_uintptr;_X0_*int32;_X1_func(*runtime.exceptionrecord,_*runtime.context,_*runtime.g)_int32;_X2_*runtime.exceptionpointers;_X3_*runtime.g_};

typedef struct runtime.exceptionrecord runtime.exceptionrecord, *Pruntime.exceptionrecord;

typedef struct runtime.exceptionpointers runtime.exceptionpointers, *Pruntime.exceptionpointers;

struct runtime.exceptionrecord {
    uint32 exceptioncode;
    uint32 exceptionflags;
    struct runtime.exceptionrecord *exceptionrecord;
    uintptr exceptionaddress;
    uint32 numberparameters;
    uintptr exceptioninformation[15];
};

struct runtime.exceptionpointers {
    struct runtime.exceptionrecord *record;
    struct runtime.context *context;
};

struct noalg.struct_{_F_uintptr;_X0_*int32;_X1_func(*runtime.exceptionrecord,_*runtime.context,_*runtime.g)_int32;_X2_*runtime.exceptionpointers;_X3_*runtime.g_} { // Original name: noalg.struct { F uintptr; X0 *int32; X1 func(*runtime.exceptionrecord, *runtime.context, *runtime.g) int32; X2 *runtime.exceptionpointers; X3 *runtime.g }
    uintptr F;
    int32 *X0;
    void (**X1)(struct runtime.exceptionrecord *, struct runtime.context *, struct runtime.g *, int32 *);
    struct runtime.exceptionpointers *X2;
    struct runtime.g *X3;
};

typedef struct noalg.struct_{_F_uintptr;_X0_**runtime.notInHeap;_X1_uintptr;_X2_uintptr;_X3_*runtime.sysMemStat_} noalg.struct_{_F_uintptr;_X0_**runtime.notInHeap;_X1_uintptr;_X2_uintptr;_X3_*runtime.sysMemStat_}, *Pnoalg.struct_{_F_uintptr;_X0_**runtime.notInHeap;_X1_uintptr;_X2_uintptr;_X3_*runtime.sysMemStat_};

struct noalg.struct_{_F_uintptr;_X0_**runtime.notInHeap;_X1_uintptr;_X2_uintptr;_X3_*runtime.sysMemStat_} { // Original name: noalg.struct { F uintptr; X0 **runtime.notInHeap; X1 uintptr; X2 uintptr; X3 *runtime.sysMemStat }
    uintptr F;
    struct runtime.notInHeap **X0;
    uintptr X1;
    uintptr X2;
    runtime.sysMemStat *X3;
};

typedef struct runtime.runqdrain_multivalue_return_type runtime.runqdrain_multivalue_return_type, *Pruntime.runqdrain_multivalue_return_type;

struct runtime.runqdrain_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.gQueue drainQ; // ordinal: 0
    uint32 n; // ordinal: 1
};

typedef struct runtime.(*pageAlloc).alloc_multivalue_return_type runtime.(*pageAlloc).alloc_multivalue_return_type, *Pruntime.(*pageAlloc).alloc_multivalue_return_type;

struct runtime.(*pageAlloc).alloc_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr addr; // ordinal: 0
    uintptr scav; // ordinal: 1
};

typedef struct runtime.randomOrder runtime.randomOrder, *Pruntime.randomOrder;

struct runtime.randomOrder {
    uint32 count;
    struct []uint32 coprimes;
};

typedef struct internal/abi.ChanType internal/abi.ChanType, *Pinternal/abi.ChanType;

struct internal/abi.ChanType {
    struct internal/abi.Type Type;
    struct internal/abi.Type *Elem;
    internal/abi.ChanDir Dir;
};

typedef struct internal/poll.(*FD).Write_multivalue_return_type internal/poll.(*FD).Write_multivalue_return_type, *Pinternal/poll.(*FD).Write_multivalue_return_type;

struct internal/poll.(*FD).Write_multivalue_return_type { // Artificial data type to hold a function's return values
    int ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_runtime.traceLocker;_X1_bool_} noalg.struct_{_F_uintptr;_X0_runtime.traceLocker;_X1_bool_}, *Pnoalg.struct_{_F_uintptr;_X0_runtime.traceLocker;_X1_bool_};

struct noalg.struct_{_F_uintptr;_X0_runtime.traceLocker;_X1_bool_} { // Original name: noalg.struct { F uintptr; X0 runtime.traceLocker; X1 bool }
    uintptr F;
    struct runtime.traceLocker X0;
    bool X1;
};

typedef struct runtime.(*mcache).nextFree_multivalue_return_type runtime.(*mcache).nextFree_multivalue_return_type, *Pruntime.(*mcache).nextFree_multivalue_return_type;

struct runtime.(*mcache).nextFree_multivalue_return_type { // Artificial data type to hold a function's return values
    runtime.gclinkptr v; // ordinal: 0
    struct runtime.mspan *s; // ordinal: 1
    bool shouldhelpgc; // ordinal: 2
};

typedef struct reflect.MapIter reflect.MapIter, *Preflect.MapIter;

struct reflect.MapIter {
    struct reflect.Value m;
    struct reflect.hiter hiter;
};

typedef struct hchan<int> hchan<int>, *Phchan<int>;

typedef struct hchan<int> *chan_int;

typedef struct waitq<int> waitq<int>, *Pwaitq<int>;

struct waitq<int> {
    struct sudog<int> *first;
    struct sudog<int> *last;
};

struct hchan<int> {
    uint qcount;
    uint dataqsiz;
    void *buf;
    uint16 elemsize;
    uint32 closed;
    struct internal/abi.Type *elemtype;
    uint sendx;
    uint recvx;
    struct waitq<int> recvq;
    struct waitq<int> sendq;
    struct runtime.mutex lock;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.unwinder;_X1_uintptr;_X2_uintptr;_X3_uintptr;_X4_*runtime.g;_X5_runtime.unwindFlags_} noalg.struct_{_F_uintptr;_X0_*runtime.unwinder;_X1_uintptr;_X2_uintptr;_X3_uintptr;_X4_*runtime.g;_X5_runtime.unwindFlags_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.unwinder;_X1_uintptr;_X2_uintptr;_X3_uintptr;_X4_*runtime.g;_X5_runtime.unwindFlags_};

typedef struct runtime.unwinder runtime.unwinder, *Pruntime.unwinder;

struct runtime.unwinder {
    struct runtime.stkframe frame;
    runtime.guintptr g;
    int cgoCtxt;
    internal/abi.FuncID calleeFuncID;
    runtime.unwindFlags flags;
};

struct noalg.struct_{_F_uintptr;_X0_*runtime.unwinder;_X1_uintptr;_X2_uintptr;_X3_uintptr;_X4_*runtime.g;_X5_runtime.unwindFlags_} { // Original name: noalg.struct { F uintptr; X0 *runtime.unwinder; X1 uintptr; X2 uintptr; X3 uintptr; X4 *runtime.g; X5 runtime.unwindFlags }
    uintptr F;
    struct runtime.unwinder *X0;
    uintptr X1;
    uintptr X2;
    uintptr X3;
    struct runtime.g *X4;
    runtime.unwindFlags X5;
};

typedef struct runtime.memoryBasicInformation runtime.memoryBasicInformation, *Pruntime.memoryBasicInformation;

struct runtime.memoryBasicInformation {
    uintptr baseAddress;
    uintptr allocationBase;
    uint32 allocationProtect;
    uintptr regionSize;
    uint32 state;
    uint32 protect;
    uint32 type_;
};

typedef struct noalg.struct_{_F_uintptr;_X0_**runtime.m_} noalg.struct_{_F_uintptr;_X0_**runtime.m_}, *Pnoalg.struct_{_F_uintptr;_X0_**runtime.m_};

struct noalg.struct_{_F_uintptr;_X0_**runtime.m_} { // Original name: noalg.struct { F uintptr; X0 **runtime.m }
    uintptr F;
    struct runtime.m **X0;
};

typedef struct runtime.(*stackScanState).getPtr_multivalue_return_type runtime.(*stackScanState).getPtr_multivalue_return_type, *Pruntime.(*stackScanState).getPtr_multivalue_return_type;

struct runtime.(*stackScanState).getPtr_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr p; // ordinal: 0
    bool conservative; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*runtime.g;_X2_int32_} noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*runtime.g;_X2_int32_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*runtime.g;_X2_int32_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_*runtime.g;_X2_int32_} { // Original name: noalg.struct { F uintptr; X0 *runtime.g; X1 *runtime.g; X2 int32 }
    uintptr F;
    struct runtime.g *X0;
    struct runtime.g *X1;
    int32 X2;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_int32_} noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_int32_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_int32_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_int32_} { // Original name: noalg.struct { F uintptr; X0 *runtime.g; X1 int32 }
    uintptr F;
    struct runtime.g *X0;
    int32 X1;
};

typedef struct []strconv.leftCheat []strconv.leftCheat, *P[]strconv.leftCheat;

struct []strconv.leftCheat {
    struct strconv.leftCheat *array;
    int len;
    int cap;
};

typedef struct syscall.UTF16FromString_multivalue_return_type syscall.UTF16FromString_multivalue_return_type, *Psyscall.UTF16FromString_multivalue_return_type;

struct syscall.UTF16FromString_multivalue_return_type { // Artificial data type to hold a function's return values
    struct []uint16 ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct internal/fmtsort.SortedMap internal/fmtsort.SortedMap, *Pinternal/fmtsort.SortedMap;

struct internal/fmtsort.SortedMap {
    struct []reflect.Value Key;
    struct []reflect.Value Value;
};

typedef struct runtime.evacDst runtime.evacDst, *Pruntime.evacDst;

struct runtime.evacDst {
    struct runtime.bmap *b;
    int i;
    void *k;
    void *e;
};

typedef struct crypto/sha256.(*digest).Write_multivalue_return_type crypto/sha256.(*digest).Write_multivalue_return_type, *Pcrypto/sha256.(*digest).Write_multivalue_return_type;

struct crypto/sha256.(*digest).Write_multivalue_return_type { // Artificial data type to hold a function's return values
    int nn; // ordinal: 0
    error err; // ordinal: 1
};

typedef uint8 runtime.tmpBuf[32];

typedef struct encoding/hex.Decode_multivalue_return_type encoding/hex.Decode_multivalue_return_type, *Pencoding/hex.Decode_multivalue_return_type;

struct encoding/hex.Decode_multivalue_return_type { // Artificial data type to hold a function's return values
    int ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct runtime.(*limiterEvent).consume_multivalue_return_type runtime.(*limiterEvent).consume_multivalue_return_type, *Pruntime.(*limiterEvent).consume_multivalue_return_type;

struct runtime.(*limiterEvent).consume_multivalue_return_type { // Artificial data type to hold a function's return values
    runtime.limiterEventType typ; // ordinal: 0
    int64 duration; // ordinal: 1
};

typedef struct runtime.sweepdata runtime.sweepdata, *Pruntime.sweepdata;

typedef struct runtime.activeSweep runtime.activeSweep, *Pruntime.activeSweep;

struct runtime.activeSweep {
    struct runtime/internal/atomic.Uint32 state;
};

struct runtime.sweepdata {
    struct runtime.mutex lock;
    struct runtime.g *g;
    bool parked;
    struct runtime.activeSweep active;
    runtime.sweepClass centralIndex;
};

typedef struct runtime.(*_panic).nextDefer_multivalue_return_type runtime.(*_panic).nextDefer_multivalue_return_type, *Pruntime.(*_panic).nextDefer_multivalue_return_type;

struct runtime.(*_panic).nextDefer_multivalue_return_type { // Artificial data type to hold a function's return values
    void (**~r0)(void); // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.eface_} noalg.struct_{_F_uintptr;_X0_*runtime.eface_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.eface_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.eface_} { // Original name: noalg.struct { F uintptr; X0 *runtime.eface }
    uintptr F;
    struct runtime.eface *X0;
};

typedef struct fmt.Fscanf_multivalue_return_type fmt.Fscanf_multivalue_return_type, *Pfmt.Fscanf_multivalue_return_type;

struct fmt.Fscanf_multivalue_return_type { // Artificial data type to hold a function's return values
    int n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct runtime.(*pageCache).allocN_multivalue_return_type runtime.(*pageCache).allocN_multivalue_return_type, *Pruntime.(*pageCache).allocN_multivalue_return_type;

struct runtime.(*pageCache).allocN_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr ~r0; // ordinal: 0
    uintptr ~r1; // ordinal: 1
};

typedef struct hchan<bool> *chan_bool;

typedef struct runtime.suspendGState runtime.suspendGState, *Pruntime.suspendGState;

struct runtime.suspendGState {
    struct runtime.g *g;
    bool dead;
    bool stopped;
};

typedef struct runtime.sweepLocker runtime.sweepLocker, *Pruntime.sweepLocker;

struct runtime.sweepLocker {
    uint32 sweepGen;
    bool valid;
};

typedef struct reflect.(*abiSeq).addRcvr_multivalue_return_type reflect.(*abiSeq).addRcvr_multivalue_return_type, *Preflect.(*abiSeq).addRcvr_multivalue_return_type;

struct reflect.(*abiSeq).addRcvr_multivalue_return_type { // Artificial data type to hold a function's return values
    struct reflect.abiStep *~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct runtime.findRunnable_multivalue_return_type runtime.findRunnable_multivalue_return_type, *Pruntime.findRunnable_multivalue_return_type;

struct runtime.findRunnable_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.g *gp; // ordinal: 0
    bool inheritTime; // ordinal: 1
    bool tryWakeP; // ordinal: 2
};

typedef struct strconv.formatBits_multivalue_return_type strconv.formatBits_multivalue_return_type, *Pstrconv.formatBits_multivalue_return_type;

struct strconv.formatBits_multivalue_return_type { // Artificial data type to hold a function's return values
    struct []uint8 d; // ordinal: 0
    struct string s; // ordinal: 1
};

typedef struct runtime.workType runtime.workType, *Pruntime.workType;

typedef struct struct_{_runtime.lock_runtime.mutex;_runtime.list_runtime.gList_} struct_{_runtime.lock_runtime.mutex;_runtime.list_runtime.gList_}, *Pstruct_{_runtime.lock_runtime.mutex;_runtime.list_runtime.gList_};

struct struct_{_runtime.lock_runtime.mutex;_runtime.list_runtime.gList_} { // Original name: struct { runtime.lock runtime.mutex; runtime.list runtime.gList }
    struct runtime.mutex lock;
    struct runtime.gList list;
};

struct runtime.workType {
    runtime.lfstack full;
    struct internal/cpu.CacheLinePad _;
    runtime.lfstack empty;
    struct internal/cpu.CacheLinePad _;
    struct struct_{_runtime.lock_runtime.mutex;_runtime.free_runtime.mSpanList;_runtime.busy_runtime.mSpanList_} wbufSpans;
    uint32 _;
    uint64 bytesMarked;
    uint32 markrootNext;
    uint32 markrootJobs;
    uint32 nproc;
    int64 tstart;
    uint32 nwait;
    int nDataRoots;
    int nBSSRoots;
    int nSpanRoots;
    int nStackRoots;
    uint32 baseData;
    uint32 baseBSS;
    uint32 baseSpans;
    uint32 baseStacks;
    uint32 baseEnd;
    struct []*runtime.g stackRoots;
    uint32 startSema;
    uint32 markDoneSema;
    struct runtime.note bgMarkReady;
    uint32 bgMarkDone;
    runtime.gcMode mode;
    bool userForced;
    uint64 initialHeapLive;
    struct struct_{_runtime.lock_runtime.mutex;_runtime.q_runtime.gQueue_} assistQueue;
    struct struct_{_runtime.lock_runtime.mutex;_runtime.list_runtime.gList_} sweepWaiters;
    struct runtime/internal/atomic.Uint32 cycles;
    int32 stwprocs;
    int32 maxprocs;
    int64 tSweepTerm;
    int64 tMark;
    int64 tMarkTerm;
    int64 tEnd;
    int64 pauseNS;
    uint64 heap0;
    uint64 heap1;
    uint64 heap2;
    struct runtime.cpuStats cpuStats;
};

typedef struct []string []string, *P[]string;

struct []string {
    struct string *array;
    int len;
    int cap;
};

typedef struct runtime.(*scavengerState).run_multivalue_return_type runtime.(*scavengerState).run_multivalue_return_type, *Pruntime.(*scavengerState).run_multivalue_return_type;

struct runtime.(*scavengerState).run_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr released; // ordinal: 0
    float64 worked; // ordinal: 1
};

typedef struct strconv.mult64bitPow10_multivalue_return_type strconv.mult64bitPow10_multivalue_return_type, *Pstrconv.mult64bitPow10_multivalue_return_type;

struct strconv.mult64bitPow10_multivalue_return_type { // Artificial data type to hold a function's return values
    uint32 resM; // ordinal: 0
    int resE; // ordinal: 1
    bool exact; // ordinal: 2
};

typedef struct reflect.interfaceType reflect.interfaceType, *Preflect.interfaceType;

struct reflect.interfaceType {
    struct internal/abi.InterfaceType InterfaceType;
};

typedef struct reflect.layoutType reflect.layoutType, *Preflect.layoutType;

typedef struct reflect.abiDesc reflect.abiDesc, *Preflect.abiDesc;

struct reflect.abiDesc {
    struct reflect.abiSeq call;
    struct reflect.abiSeq ret;
    uintptr stackCallArgsSize;
    uintptr retOffset;
    uintptr spill;
    struct reflect.bitVector *stackPtrs;
    internal/abi.IntArgRegBitmap inRegPtrs;
    internal/abi.IntArgRegBitmap outRegPtrs;
};

struct reflect.layoutType {
    struct internal/abi.Type *t;
    struct sync.Pool *framePool;
    struct reflect.abiDesc abid;
};

typedef struct struct_{_runtime.lock_runtime.mutex;_runtime.ctxt_[2000]runtime.winCallback;_runtime.index_map[runtime.winCallbackKey]int;_runtime.n_int_} struct_{_runtime.lock_runtime.mutex;_runtime.ctxt_[2000]runtime.winCallback;_runtime.index_map[runtime.winCallbackKey]int;_runtime.n_int_}, *Pstruct_{_runtime.lock_runtime.mutex;_runtime.ctxt_[2000]runtime.winCallback;_runtime.index_map[runtime.winCallbackKey]int;_runtime.n_int_};

typedef struct hash<runtime.winCallbackKey,int> *map[runtime.winCallbackKey]int;

struct struct_{_runtime.lock_runtime.mutex;_runtime.ctxt_[2000]runtime.winCallback;_runtime.index_map[runtime.winCallbackKey]int;_runtime.n_int_} { // Original name: struct { runtime.lock runtime.mutex; runtime.ctxt [2000]runtime.winCallback; runtime.index map[runtime.winCallbackKey]int; runtime.n int }
    struct runtime.mutex lock;
    struct runtime.winCallback ctxt[2000];
    map[runtime.winCallbackKey]int index;
    int n;
};

typedef struct syscall.SyscallN_multivalue_return_type syscall.SyscallN_multivalue_return_type, *Psyscall.SyscallN_multivalue_return_type;

struct syscall.SyscallN_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr r1; // ordinal: 0
    uintptr r2; // ordinal: 1
    uintptr err; // ordinal: 2
};

typedef struct internal/fmtsort.nilCompare_multivalue_return_type internal/fmtsort.nilCompare_multivalue_return_type, *Pinternal/fmtsort.nilCompare_multivalue_return_type;

struct internal/fmtsort.nilCompare_multivalue_return_type { // Artificial data type to hold a function's return values
    int ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct runtime.checkTimers_multivalue_return_type runtime.checkTimers_multivalue_return_type, *Pruntime.checkTimers_multivalue_return_type;

struct runtime.checkTimers_multivalue_return_type { // Artificial data type to hold a function's return values
    int64 rnow; // ordinal: 0
    int64 pollUntil; // ordinal: 1
    bool ran; // ordinal: 2
};

typedef struct strconv.special_multivalue_return_type strconv.special_multivalue_return_type, *Pstrconv.special_multivalue_return_type;

struct strconv.special_multivalue_return_type { // Artificial data type to hold a function's return values
    float64 f; // ordinal: 0
    int n; // ordinal: 1
    bool ok; // ordinal: 2
};

typedef struct runtime.(*traceMap).put_multivalue_return_type runtime.(*traceMap).put_multivalue_return_type, *Pruntime.(*traceMap).put_multivalue_return_type;

struct runtime.(*traceMap).put_multivalue_return_type { // Artificial data type to hold a function's return values
    uint64 ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_int64_} noalg.struct_{_F_uintptr;_X0_int64_}, *Pnoalg.struct_{_F_uintptr;_X0_int64_};

struct noalg.struct_{_F_uintptr;_X0_int64_} { // Original name: noalg.struct { F uintptr; X0 int64 }
    uintptr F;
    int64 X0;
};

typedef struct runtime.traceStringTable runtime.traceStringTable, *Pruntime.traceStringTable;

struct runtime.traceStringTable {
    struct runtime.mutex lock;
    struct runtime.traceBuf *buf;
    struct runtime.traceMap tab;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*bool_} noalg.struct_{_F_uintptr;_X0_*bool_}, *Pnoalg.struct_{_F_uintptr;_X0_*bool_};

struct noalg.struct_{_F_uintptr;_X0_*bool_} { // Original name: noalg.struct { F uintptr; X0 *bool }
    uintptr F;
    bool *X0;
};

typedef struct runtime.godebugInc runtime.godebugInc, *Pruntime.godebugInc;

struct runtime.godebugInc {
    struct string name;
    struct runtime/internal/atomic.Pointer[func()] inc;
};

typedef struct runtime.pollCache runtime.pollCache, *Pruntime.pollCache;

struct runtime.pollCache {
    struct runtime.mutex lock;
    struct runtime.pollDesc *first;
};

typedef struct fmt.intFromArg_multivalue_return_type fmt.intFromArg_multivalue_return_type, *Pfmt.intFromArg_multivalue_return_type;

struct fmt.intFromArg_multivalue_return_type { // Artificial data type to hold a function's return values
    int num; // ordinal: 0
    bool isInt; // ordinal: 1
    int newArgNum; // ordinal: 2
};

typedef struct runtime.(*gcControllerState).findRunnableGCWorker_multivalue_return_type runtime.(*gcControllerState).findRunnableGCWorker_multivalue_return_type, *Pruntime.(*gcControllerState).findRunnableGCWorker_multivalue_return_type;

struct runtime.(*gcControllerState).findRunnableGCWorker_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.g *~r0; // ordinal: 0
    int64 ~r1; // ordinal: 1
};

typedef struct internal/cpu.option internal/cpu.option, *Pinternal/cpu.option;

struct internal/cpu.option {
    struct string Name;
    bool *Feature;
    bool Specified;
    bool Enable;
};

typedef struct []internal/abi.Method []internal/abi.Method, *P[]internal/abi.Method;

struct []internal/abi.Method {
    struct internal/abi.Method *array;
    int len;
    int cap;
};

typedef struct runtime.(*scavengeIndex).find_multivalue_return_type runtime.(*scavengeIndex).find_multivalue_return_type, *Pruntime.(*scavengeIndex).find_multivalue_return_type;

struct runtime.(*scavengeIndex).find_multivalue_return_type { // Artificial data type to hold a function's return values
    runtime.chunkIdx ~r0; // ordinal: 0
    uint ~r1; // ordinal: 1
};

typedef struct strconv.decimalSlice strconv.decimalSlice, *Pstrconv.decimalSlice;

struct strconv.decimalSlice {
    struct []uint8 d;
    int nd;
    int dp;
};

typedef struct syscall.GetEnvironmentVariable_multivalue_return_type syscall.GetEnvironmentVariable_multivalue_return_type, *Psyscall.GetEnvironmentVariable_multivalue_return_type;

struct syscall.GetEnvironmentVariable_multivalue_return_type { // Artificial data type to hold a function's return values
    uint32 n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct runtime.traceEventWriter runtime.traceEventWriter, *Pruntime.traceEventWriter;

struct runtime.traceEventWriter {
    struct runtime.traceWriter w;
};

typedef struct fmt.Fprint_multivalue_return_type fmt.Fprint_multivalue_return_type, *Pfmt.Fprint_multivalue_return_type;

struct fmt.Fprint_multivalue_return_type { // Artificial data type to hold a function's return values
    int n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct strconv.ParseUint_multivalue_return_type strconv.ParseUint_multivalue_return_type, *Pstrconv.ParseUint_multivalue_return_type;

struct strconv.ParseUint_multivalue_return_type { // Artificial data type to hold a function's return values
    uint64 ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct strconv.eiselLemire32_multivalue_return_type strconv.eiselLemire32_multivalue_return_type, *Pstrconv.eiselLemire32_multivalue_return_type;

struct strconv.eiselLemire32_multivalue_return_type { // Artificial data type to hold a function's return values
    float32 f; // ordinal: 0
    bool ok; // ordinal: 1
};

typedef struct os.(*File).Read_multivalue_return_type os.(*File).Read_multivalue_return_type, *Pos.(*File).Read_multivalue_return_type;

struct os.(*File).Read_multivalue_return_type { // Artificial data type to hold a function's return values
    int n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct runtime.forcegcstate runtime.forcegcstate, *Pruntime.forcegcstate;

struct runtime.forcegcstate {
    struct runtime.mutex lock;
    struct runtime.g *g;
    struct runtime/internal/atomic.Bool idle;
};

typedef struct strconv.atof32_multivalue_return_type strconv.atof32_multivalue_return_type, *Pstrconv.atof32_multivalue_return_type;

struct strconv.atof32_multivalue_return_type { // Artificial data type to hold a function's return values
    float32 f; // ordinal: 0
    int n; // ordinal: 1
    error err; // ordinal: 2
};

typedef struct struct_{_runtime.lock_runtime.mutex;_runtime.next_int32;_runtime.m_map[int32]unsafe.Pointer;_runtime.minv_map[unsafe.Pointer]int32_} struct_{_runtime.lock_runtime.mutex;_runtime.next_int32;_runtime.m_map[int32]unsafe.Pointer;_runtime.minv_map[unsafe.Pointer]int32_}, *Pstruct_{_runtime.lock_runtime.mutex;_runtime.next_int32;_runtime.m_map[int32]unsafe.Pointer;_runtime.minv_map[unsafe.Pointer]int32_};

struct struct_{_runtime.lock_runtime.mutex;_runtime.next_int32;_runtime.m_map[int32]unsafe.Pointer;_runtime.minv_map[unsafe.Pointer]int32_} { // Original name: struct { runtime.lock runtime.mutex; runtime.next int32; runtime.m map[int32]unsafe.Pointer; runtime.minv map[unsafe.Pointer]int32 }
    struct runtime.mutex lock;
    int32 next;
    map[int32]unsafe.Pointer m;
    map[unsafe.Pointer]int32 minv;
};

typedef struct runtime.(*gcControllerState).heapGoalInternal_multivalue_return_type runtime.(*gcControllerState).heapGoalInternal_multivalue_return_type, *Pruntime.(*gcControllerState).heapGoalInternal_multivalue_return_type;

struct runtime.(*gcControllerState).heapGoalInternal_multivalue_return_type { // Artificial data type to hold a function's return values
    uint64 goal; // ordinal: 0
    uint64 minTrigger; // ordinal: 1
};

typedef struct runtime.newInlineUnwinder_multivalue_return_type runtime.newInlineUnwinder_multivalue_return_type, *Pruntime.newInlineUnwinder_multivalue_return_type;

typedef struct runtime.inlineFrame runtime.inlineFrame, *Pruntime.inlineFrame;

struct runtime.inlineFrame {
    uintptr pc;
    int32 index;
};

struct runtime.newInlineUnwinder_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.inlineUnwinder ~r0; // ordinal: 0
    struct runtime.inlineFrame ~r1; // ordinal: 1
};

typedef struct golang.org/x/crypto/chacha20.newUnauthenticatedCipher_multivalue_return_type golang.org/x/crypto/chacha20.newUnauthenticatedCipher_multivalue_return_type, *Pgolang.org/x/crypto/chacha20.newUnauthenticatedCipher_multivalue_return_type;

struct golang.org/x/crypto/chacha20.newUnauthenticatedCipher_multivalue_return_type { // Artificial data type to hold a function's return values
    struct golang.org/x/crypto/chacha20.Cipher *~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.traceStringTable;_X1_uintptr;_X2_uint64;_X3_*string_} noalg.struct_{_F_uintptr;_X0_*runtime.traceStringTable;_X1_uintptr;_X2_uint64;_X3_*string_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.traceStringTable;_X1_uintptr;_X2_uint64;_X3_*string_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.traceStringTable;_X1_uintptr;_X2_uint64;_X3_*string_} { // Original name: noalg.struct { F uintptr; X0 *runtime.traceStringTable; X1 uintptr; X2 uint64; X3 *string }
    uintptr F;
    struct runtime.traceStringTable *X0;
    uintptr X1;
    uint64 X2;
    struct string *X3;
};

typedef struct runtime.pMask runtime.pMask, *Pruntime.pMask;

struct runtime.pMask {
    uint32 *array;
    int len;
    int cap;
};

typedef struct struct_{_runtime.lock_runtime.mutex;_runtime.reading_*runtime.traceBuf;_runtime.empty_*runtime.traceBuf;_runtime.full_[2]runtime.traceBufQueue;_runtime.workAvailable_runtime/internal/atomic.Bool;_runtime.readerGen_runtime/internal/atomic.Uintptr;_runtime.flushedGen_runtime/internal/atomic.Uintptr;_runtime.headerWritten_bool;_runtime.doneSema_[2]uint32;_runtime.stackTab_[2]runtime.traceStackTable;_runtime.stringTab_[2]runtime.traceStringTable;_runtime.cpuLogRead_[2]*runtime.profBuf;_runtime.signalLock_runtime/internal/atomic.Uint32;_runtime.cpuLogWrite_[2]runtime/internal/atomic.Pointer[runtime.profBuf];_runtime.cpuSleep_*runtime.wakeableSleep;_runtime.cpuLogDone_<-chan_struct_{};_runtime.cpuBuf_[2]*runtime.traceBuf;_runtime.reader_runtime/internal/atomic.Pointer[runtime.g];_runtime.markWorkerLabels_[2][4]runtime.traceArg;_runtime.goStopReasons_[2][3]runtime.traceArg;_runtime.goBlockReasons_[2][15]runtime.traceArg;_runtime.gen_runtime/internal/atomic.Uintptr;_runtime.lastNonZeroGen_uintptr;_runtime.shutdown_runtime/internal/atomic.Bool;_runtime.exitingSyscall_runtime/internal/atomic.Int32;_runtime.seqGC_uint64_} struct_{_runtime.lock_runtime.mutex;_runtime.reading_*runtime.traceBuf;_runtime.empty_*runtime.traceBuf;_runtime.full_[2]runtime.traceBufQueue;_runtime.workAvailable_runtime/internal/atomic.Bool;_runtime.readerGen_runtime/internal/atomic.Uintptr;_runtime.flushedGen_runtime/internal/atomic.Uintptr;_runtime.headerWritten_bool;_runtime.doneSema_[2]uint32;_runtime.stackTab_[2]runtime.traceStackTable;_runtime.stringTab_[2]runtime.traceStringTable;_runtime.cpuLogRead_[2]*runtime.profBuf;_runtime.signalLock_runtime/internal/atomic.Uint32;_runtime.cpuLogWrite_[2]runtime/internal/atomic.Pointer[runtime.profBuf];_runtime.cpuSleep_*runtime.wakeableSleep;_runtime.cpuLogDone_<-chan_struct_{};_runtime.cpuBuf_[2]*runtime.traceBuf;_runtime.reader_runtime/internal/atomic.Pointer[runtime.g];_runtime.markWorkerLabels_[2][4]runtime.traceArg;_runtime.goStopReasons_[2][3]runtime.traceArg;_runtime.goBlockReasons_[2][15]runtime.traceArg;_runtime.gen_runtime/internal/atomic.Uintptr;_runtime.lastNonZeroGen_uintptr;_runtime.shutdown_runtime/internal/atomic.Bool;_runtime.exitingSyscall_runtime/internal/atomic.Int32;_runtime.seqGC_uint64_}, *Pstruct_{_runtime.lock_runtime.mutex;_runtime.reading_*runtime.traceBuf;_runtime.empty_*runtime.traceBuf;_runtime.full_[2]runtime.traceBufQueue;_runtime.workAvailable_runtime/internal/atomic.Bool;_runtime.readerGen_runtime/internal/atomic.Uintptr;_runtime.flushedGen_runtime/internal/atomic.Uintptr;_runtime.headerWritten_bool;_runtime.doneSema_[2]uint32;_runtime.stackTab_[2]runtime.traceStackTable;_runtime.stringTab_[2]runtime.traceStringTable;_runtime.cpuLogRead_[2]*runtime.profBuf;_runtime.signalLock_runtime/internal/atomic.Uint32;_runtime.cpuLogWrite_[2]runtime/internal/atomic.Pointer[runtime.profBuf];_runtime.cpuSleep_*runtime.wakeableSleep;_runtime.cpuLogDone_<-chan_struct_{};_runtime.cpuBuf_[2]*runtime.traceBuf;_runtime.reader_runtime/internal/atomic.Pointer[runtime.g];_runtime.markWorkerLabels_[2][4]runtime.traceArg;_runtime.goStopReasons_[2][3]runtime.traceArg;_runtime.goBlockReasons_[2][15]runtime.traceArg;_runtime.gen_runtime/internal/atomic.Uintptr;_runtime.lastNonZeroGen_uintptr;_runtime.shutdown_runtime/internal/atomic.Bool;_runtime.exitingSyscall_runtime/internal/atomic.Int32;_runtime.seqGC_uint64_};

struct struct_{_runtime.lock_runtime.mutex;_runtime.reading_*runtime.traceBuf;_runtime.empty_*runtime.traceBuf;_runtime.full_[2]runtime.traceBufQueue;_runtime.workAvailable_runtime/internal/atomic.Bool;_runtime.readerGen_runtime/internal/atomic.Uintptr;_runtime.flushedGen_runtime/internal/atomic.Uintptr;_runtime.headerWritten_bool;_runtime.doneSema_[2]uint32;_runtime.stackTab_[2]runtime.traceStackTable;_runtime.stringTab_[2]runtime.traceStringTable;_runtime.cpuLogRead_[2]*runtime.profBuf;_runtime.signalLock_runtime/internal/atomic.Uint32;_runtime.cpuLogWrite_[2]runtime/internal/atomic.Pointer[runtime.profBuf];_runtime.cpuSleep_*runtime.wakeableSleep;_runtime.cpuLogDone_<-chan_struct_{};_runtime.cpuBuf_[2]*runtime.traceBuf;_runtime.reader_runtime/internal/atomic.Pointer[runtime.g];_runtime.markWorkerLabels_[2][4]runtime.traceArg;_runtime.goStopReasons_[2][3]runtime.traceArg;_runtime.goBlockReasons_[2][15]runtime.traceArg;_runtime.gen_runtime/internal/atomic.Uintptr;_runtime.lastNonZeroGen_uintptr;_runtime.shutdown_runtime/internal/atomic.Bool;_runtime.exitingSyscall_runtime/internal/atomic.Int32;_runtime.seqGC_uint64_} { // Original name: struct { runtime.lock runtime.mutex; runtime.reading *runtime.traceBuf; runtime.empty *runtime.traceBuf; runtime.full [2]runtime.traceBufQueue; runtime.workAvailable runtime/internal/atomic.Bool; runtime.readerGen runtime/internal/atomic.Uintptr; runtime.flushedGen runtime/internal/atomic.Uintptr; runtime.headerWritten bool; runtime.doneSema [2]uint32; runtime.stackTab [2]runtime.traceStackTable; runtime.stringTab [2]runtime.traceStringTable; runtime.cpuLogRead [2]*runtime.profBuf; runtime.signalLock runtime/internal/atomic.Uint32; runtime.cpuLogWrite [2]runtime/internal/atomic.Pointer[runtime.profBuf]; runtime.cpuSleep *runtime.wakeableSleep; runtime.cpuLogDone <-chan struct {}; runtime.cpuBuf [2]*runtime.traceBuf; runtime.reader runtime/internal/atomic.Pointer[runtime.g]; runtime.markWorkerLabels [2][4]runtime.traceArg; runtime.goStopReasons [2][3]runtime.traceArg; runtime.goBlockReasons [2][15]runtime.traceArg; runtime.gen runtime/internal/atomic.Uintptr; runtime.lastNonZeroGen uintptr; runtime.shutdown runtime/internal/atomic.Bool; runtime.exitingSyscall runtime/internal/atomic.Int32; runtime.seqGC uint64 }
    struct runtime.mutex lock;
    struct runtime.traceBuf *reading;
    struct runtime.traceBuf *empty;
    struct runtime.traceBufQueue full[2];
    struct runtime/internal/atomic.Bool workAvailable;
    struct runtime/internal/atomic.Uintptr readerGen;
    struct runtime/internal/atomic.Uintptr flushedGen;
    bool headerWritten;
    uint32 doneSema[2];
    struct runtime.traceStackTable stackTab[2];
    struct runtime.traceStringTable stringTab[2];
    struct runtime.profBuf *cpuLogRead[2];
    struct runtime/internal/atomic.Uint32 signalLock;
    struct runtime/internal/atomic.Pointer[runtime.profBuf] cpuLogWrite[2];
    struct runtime.wakeableSleep *cpuSleep;
    <-chan_struct_{} cpuLogDone;
    struct runtime.traceBuf *cpuBuf[2];
    struct runtime/internal/atomic.Pointer[runtime.g] reader;
    runtime.traceArg markWorkerLabels[2][4];
    runtime.traceArg goStopReasons[2][3];
    runtime.traceArg goBlockReasons[2][15];
    struct runtime/internal/atomic.Uintptr gen;
    uintptr lastNonZeroGen;
    struct runtime/internal/atomic.Bool shutdown;
    struct runtime/internal/atomic.Int32 exitingSyscall;
    uint64 seqGC;
};

typedef struct fmt.newScanState_multivalue_return_type fmt.newScanState_multivalue_return_type, *Pfmt.newScanState_multivalue_return_type;

struct fmt.newScanState_multivalue_return_type { // Artificial data type to hold a function's return values
    struct fmt.ss *s; // ordinal: 0
    struct fmt.ssave old; // ordinal: 1
};

typedef struct hash<string,bool> *map[string]bool;

typedef struct runtime.(*addrRanges).findAddrGreaterEqual_multivalue_return_type runtime.(*addrRanges).findAddrGreaterEqual_multivalue_return_type, *Pruntime.(*addrRanges).findAddrGreaterEqual_multivalue_return_type;

struct runtime.(*addrRanges).findAddrGreaterEqual_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct runtime.cgoTracebackArg runtime.cgoTracebackArg, *Pruntime.cgoTracebackArg;

struct runtime.cgoTracebackArg {
    uintptr context;
    uintptr sigContext;
    uintptr *buf;
    uintptr max;
};

typedef struct runtime.stealWork_multivalue_return_type runtime.stealWork_multivalue_return_type, *Pruntime.stealWork_multivalue_return_type;

struct runtime.stealWork_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.g *gp; // ordinal: 0
    bool inheritTime; // ordinal: 1
    int64 rnow; // ordinal: 2
    int64 pollUntil; // ordinal: 3
    bool newWork; // ordinal: 4
};

typedef struct internal/reflectlite.emptyInterface internal/reflectlite.emptyInterface, *Pinternal/reflectlite.emptyInterface;

struct internal/reflectlite.emptyInterface {
    struct internal/abi.Type *typ;
    void *word;
};

typedef struct sync.(*poolChain).popHead_multivalue_return_type sync.(*poolChain).popHead_multivalue_return_type, *Psync.(*poolChain).popHead_multivalue_return_type;

struct sync.(*poolChain).popHead_multivalue_return_type { // Artificial data type to hold a function's return values
    interface_{} ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct fmt.(*pp).argNumber_multivalue_return_type fmt.(*pp).argNumber_multivalue_return_type, *Pfmt.(*pp).argNumber_multivalue_return_type;

struct fmt.(*pp).argNumber_multivalue_return_type { // Artificial data type to hold a function's return values
    int newArgNum; // ordinal: 0
    int newi; // ordinal: 1
    bool found; // ordinal: 2
};

typedef struct []*sync.Pool []*sync.Pool, *P[]*sync.Pool;

struct []*sync.Pool {
    struct sync.Pool **array;
    int len;
    int cap;
};

typedef struct syscall.SecurityAttributes syscall.SecurityAttributes, *Psyscall.SecurityAttributes;

struct syscall.SecurityAttributes {
    uint32 Length;
    uintptr SecurityDescriptor;
    uint32 InheritHandle;
};

typedef struct strconv.atofHex_multivalue_return_type strconv.atofHex_multivalue_return_type, *Pstrconv.atofHex_multivalue_return_type;

struct strconv.atofHex_multivalue_return_type { // Artificial data type to hold a function's return values
    float64 ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct runtime.notInHeapSlice runtime.notInHeapSlice, *Pruntime.notInHeapSlice;

struct runtime.notInHeapSlice {
    struct runtime.notInHeap *array;
    int len;
    int cap;
};

typedef struct syscall.Syscall9_multivalue_return_type syscall.Syscall9_multivalue_return_type, *Psyscall.Syscall9_multivalue_return_type;

struct syscall.Syscall9_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr r1; // ordinal: 0
    uintptr r2; // ordinal: 1
    uintptr err; // ordinal: 2
};

typedef struct noalg.struct_{_F_uintptr;_X0_**runtime.mspan;_X1_uintptr_} noalg.struct_{_F_uintptr;_X0_**runtime.mspan;_X1_uintptr_}, *Pnoalg.struct_{_F_uintptr;_X0_**runtime.mspan;_X1_uintptr_};

struct noalg.struct_{_F_uintptr;_X0_**runtime.mspan;_X1_uintptr_} { // Original name: noalg.struct { F uintptr; X0 **runtime.mspan; X1 uintptr }
    uintptr F;
    struct runtime.mspan **X0;
    uintptr X1;
};

typedef struct fmt.Fprintln_multivalue_return_type fmt.Fprintln_multivalue_return_type, *Pfmt.Fprintln_multivalue_return_type;

struct fmt.Fprintln_multivalue_return_type { // Artificial data type to hold a function's return values
    int n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct runtime.iface fmt.GoStringer;

typedef struct runtime.savedOpenDeferState runtime.savedOpenDeferState, *Pruntime.savedOpenDeferState;

struct runtime.savedOpenDeferState {
    uintptr retpc;
    uintptr deferBitsOffset;
    uintptr slotsOffset;
};

typedef struct runtime.interfaceSwitch_multivalue_return_type runtime.interfaceSwitch_multivalue_return_type, *Pruntime.interfaceSwitch_multivalue_return_type;

struct runtime.interfaceSwitch_multivalue_return_type { // Artificial data type to hold a function's return values
    int ~r0; // ordinal: 0
    struct runtime.itab *~r1; // ordinal: 1
};

typedef struct reflect.funcLayout_multivalue_return_type_x86_64 reflect.funcLayout_multivalue_return_type_x86_64, *Preflect.funcLayout_multivalue_return_type_x86_64;

struct reflect.funcLayout_multivalue_return_type_x86_64 {
    struct reflect.abiDesc abid; // stack[8] ordinal: 2
    struct internal/abi.Type *frametype; // [RAX] ordinal: 0
    struct sync.Pool *framePool; // [RBX] ordinal: 1
};

typedef struct runtime.checkIdleGCNoP_multivalue_return_type runtime.checkIdleGCNoP_multivalue_return_type, *Pruntime.checkIdleGCNoP_multivalue_return_type;

struct runtime.checkIdleGCNoP_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.p *~r0; // ordinal: 0
    struct runtime.g *~r1; // ordinal: 1
};

typedef struct []runtime.traceArg []runtime.traceArg, *P[]runtime.traceArg;

struct []runtime.traceArg {
    runtime.traceArg *array;
    int len;
    int cap;
};

typedef struct strconv.UnquoteChar_multivalue_return_type strconv.UnquoteChar_multivalue_return_type, *Pstrconv.UnquoteChar_multivalue_return_type;

struct strconv.UnquoteChar_multivalue_return_type { // Artificial data type to hold a function's return values
    int32 value; // ordinal: 0
    bool multibyte; // ordinal: 1
    struct string tail; // ordinal: 2
    error err; // ordinal: 3
};

typedef struct noalg.struct_{_F_uintptr;_X0_uint32;_X1_uint32_} noalg.struct_{_F_uintptr;_X0_uint32;_X1_uint32_}, *Pnoalg.struct_{_F_uintptr;_X0_uint32;_X1_uint32_};

struct noalg.struct_{_F_uintptr;_X0_uint32;_X1_uint32_} { // Original name: noalg.struct { F uintptr; X0 uint32; X1 uint32 }
    uintptr F;
    uint32 X0;
    uint32 X1;
};

typedef struct []interface_{} []interface_{}, *P[]interface_{};

struct []interface_{} { // Original name: []interface {}
    interface_{} *array;
    int len;
    int cap;
};

typedef struct runtime.(*sweepLocker).tryAcquire_multivalue_return_type runtime.(*sweepLocker).tryAcquire_multivalue_return_type, *Pruntime.(*sweepLocker).tryAcquire_multivalue_return_type;

struct runtime.(*sweepLocker).tryAcquire_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.sweepLocked ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct reflect.layoutKey reflect.layoutKey, *Preflect.layoutKey;

struct reflect.layoutKey {
    struct internal/abi.FuncType *ftyp;
    struct internal/abi.Type *rcvr;
};

typedef struct fmt.(*ss).complexTokens_multivalue_return_type fmt.(*ss).complexTokens_multivalue_return_type, *Pfmt.(*ss).complexTokens_multivalue_return_type;

struct fmt.(*ss).complexTokens_multivalue_return_type { // Artificial data type to hold a function's return values
    struct string real; // ordinal: 0
    struct string imag; // ordinal: 1
};

typedef struct unicode/utf8.DecodeRune_multivalue_return_type unicode/utf8.DecodeRune_multivalue_return_type, *Punicode/utf8.DecodeRune_multivalue_return_type;

struct unicode/utf8.DecodeRune_multivalue_return_type { // Artificial data type to hold a function's return values
    int32 r; // ordinal: 0
    int size; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_unsafe.Pointer;_X1_func(uint8,_uint8)_bool_} noalg.struct_{_F_uintptr;_X0_unsafe.Pointer;_X1_func(uint8,_uint8)_bool_}, *Pnoalg.struct_{_F_uintptr;_X0_unsafe.Pointer;_X1_func(uint8,_uint8)_bool_};

struct noalg.struct_{_F_uintptr;_X0_unsafe.Pointer;_X1_func(uint8,_uint8)_bool_} { // Original name: noalg.struct { F uintptr; X0 unsafe.Pointer; X1 func(uint8, uint8) bool }
    uintptr F;
    void *X0;
    void (**X1)(uint8, uint8, bool *);
};

typedef struct syscall.Write_multivalue_return_type syscall.Write_multivalue_return_type, *Psyscall.Write_multivalue_return_type;

struct syscall.Write_multivalue_return_type { // Artificial data type to hold a function's return values
    int n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct syscall.formatMessage_multivalue_return_type syscall.formatMessage_multivalue_return_type, *Psyscall.formatMessage_multivalue_return_type;

struct syscall.formatMessage_multivalue_return_type { // Artificial data type to hold a function's return values
    uint32 n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct runtime.parseByteCount_multivalue_return_type runtime.parseByteCount_multivalue_return_type, *Pruntime.parseByteCount_multivalue_return_type;

struct runtime.parseByteCount_multivalue_return_type { // Artificial data type to hold a function's return values
    int64 ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_*runtime.g;_X3_*int;_X4_int;_X5_[]uintptr_} noalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_*runtime.g;_X3_*int;_X4_int;_X5_[]uintptr_}, *Pnoalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_*runtime.g;_X3_*int;_X4_int;_X5_[]uintptr_};

struct noalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_*runtime.g;_X3_*int;_X4_int;_X5_[]uintptr_} { // Original name: noalg.struct { F uintptr; X0 uintptr; X1 uintptr; X2 *runtime.g; X3 *int; X4 int; X5 []uintptr }
    uintptr F;
    uintptr X0;
    uintptr X1;
    struct runtime.g *X2;
    int *X3;
    int X4;
    struct []uintptr X5;
};

typedef struct sync.(*Map).LoadOrStore_multivalue_return_type sync.(*Map).LoadOrStore_multivalue_return_type, *Psync.(*Map).LoadOrStore_multivalue_return_type;

struct sync.(*Map).LoadOrStore_multivalue_return_type { // Artificial data type to hold a function's return values
    interface_{} actual; // ordinal: 0
    bool loaded; // ordinal: 1
};

typedef struct runtime.iface interface_{_Unwrap()_error_};

typedef struct runtime.mapaccess2_multivalue_return_type runtime.mapaccess2_multivalue_return_type, *Pruntime.mapaccess2_multivalue_return_type;

struct runtime.mapaccess2_multivalue_return_type { // Artificial data type to hold a function's return values
    void *~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct runtime.binarySearchTree_multivalue_return_type runtime.binarySearchTree_multivalue_return_type, *Pruntime.binarySearchTree_multivalue_return_type;

struct runtime.binarySearchTree_multivalue_return_type { // Artificial data type to hold a function's return values
    struct runtime.stackObject *root; // ordinal: 0
    struct runtime.stackObjectBuf *restBuf; // ordinal: 1
    int restIdx; // ordinal: 2
};

typedef struct noalg.struct_{_F_uintptr;_X0_*interface_{};_X1_*bool;_X2_*[3]uintptr_} noalg.struct_{_F_uintptr;_X0_*interface_{};_X1_*bool;_X2_*[3]uintptr_}, *Pnoalg.struct_{_F_uintptr;_X0_*interface_{};_X1_*bool;_X2_*[3]uintptr_};

struct noalg.struct_{_F_uintptr;_X0_*interface_{};_X1_*bool;_X2_*[3]uintptr_} { // Original name: noalg.struct { F uintptr; X0 *interface {}; X1 *bool; X2 *[3]uintptr }
    uintptr F;
    interface_{} *X0;
    bool *X1;
    uintptr (*X2)[3];
};

typedef struct noalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_uintptr;_X3_*runtime.g_} noalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_uintptr;_X3_*runtime.g_}, *Pnoalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_uintptr;_X3_*runtime.g_};

struct noalg.struct_{_F_uintptr;_X0_uintptr;_X1_uintptr;_X2_uintptr;_X3_*runtime.g_} { // Original name: noalg.struct { F uintptr; X0 uintptr; X1 uintptr; X2 uintptr; X3 *runtime.g }
    uintptr F;
    uintptr X0;
    uintptr X1;
    uintptr X2;
    struct runtime.g *X3;
};

typedef struct struct_{_runtime.lock_runtime.mutex;_runtime.seed_[32]uint8;_runtime.state_internal/chacha8rand.State;_runtime.init_bool_} struct_{_runtime.lock_runtime.mutex;_runtime.seed_[32]uint8;_runtime.state_internal/chacha8rand.State;_runtime.init_bool_}, *Pstruct_{_runtime.lock_runtime.mutex;_runtime.seed_[32]uint8;_runtime.state_internal/chacha8rand.State;_runtime.init_bool_};

struct struct_{_runtime.lock_runtime.mutex;_runtime.seed_[32]uint8;_runtime.state_internal/chacha8rand.State;_runtime.init_bool_} { // Original name: struct { runtime.lock runtime.mutex; runtime.seed [32]uint8; runtime.state internal/chacha8rand.State; runtime.init bool }
    struct runtime.mutex lock;
    uint8 seed[32];
    struct internal/chacha8rand.State state;
    bool init;
};

typedef struct fmt.(*ss).hexByte_multivalue_return_type fmt.(*ss).hexByte_multivalue_return_type, *Pfmt.(*ss).hexByte_multivalue_return_type;

struct fmt.(*ss).hexByte_multivalue_return_type { // Artificial data type to hold a function's return values
    uint8 b; // ordinal: 0
    bool ok; // ordinal: 1
};

typedef struct runtime.funcline1_multivalue_return_type runtime.funcline1_multivalue_return_type, *Pruntime.funcline1_multivalue_return_type;

struct runtime.funcline1_multivalue_return_type { // Artificial data type to hold a function's return values
    struct string file; // ordinal: 0
    int32 line; // ordinal: 1
};

typedef struct []*runtime.dbgVar []*runtime.dbgVar, *P[]*runtime.dbgVar;

struct []*runtime.dbgVar {
    struct runtime.dbgVar **array;
    int len;
    int cap;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.worldStop_} noalg.struct_{_F_uintptr;_X0_*runtime.worldStop_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.worldStop_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.worldStop_} { // Original name: noalg.struct { F uintptr; X0 *runtime.worldStop }
    uintptr F;
    struct runtime.worldStop *X0;
};

typedef struct noalg.struct_{_F_uintptr;_X0_*sync/atomic.Uint32_} noalg.struct_{_F_uintptr;_X0_*sync/atomic.Uint32_}, *Pnoalg.struct_{_F_uintptr;_X0_*sync/atomic.Uint32_};

struct noalg.struct_{_F_uintptr;_X0_*sync/atomic.Uint32_} { // Original name: noalg.struct { F uintptr; X0 *sync/atomic.Uint32 }
    uintptr F;
    struct sync/atomic.Uint32 *X0;
};

typedef struct runtime/internal/atomic.Pointer[go.shape.310da7890f312c3e9e77825750bad066709f9dcd04a3cf1be91d69e56d19c9ef] runtime/internal/atomic.Pointer[go.shape.310da7890f312c3e9e77825750bad066709f9dcd04a3cf1be91d69e56d19c9ef], *Pruntime/internal/atomic.Pointer[go.shape.310da7890f312c3e9e77825750bad066709f9dcd04a3cf1be91d69e56d19c9ef];

struct runtime/internal/atomic.Pointer[go.shape.310da7890f312c3e9e77825750bad066709f9dcd04a3cf1be91d69e56d19c9ef] {
    struct runtime/internal/atomic.UnsafePointer u;
};

typedef struct runtime.printCgoTraceback.func1_multivalue_return_type runtime.printCgoTraceback.func1_multivalue_return_type, *Pruntime.printCgoTraceback.func1_multivalue_return_type;

struct runtime.printCgoTraceback.func1_multivalue_return_type { // Artificial data type to hold a function's return values
    bool pr; // ordinal: 0
    bool stop; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.funcval;_X1_*runtime.g;_X2_uintptr_} noalg.struct_{_F_uintptr;_X0_*runtime.funcval;_X1_*runtime.g;_X2_uintptr_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.funcval;_X1_*runtime.g;_X2_uintptr_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.funcval;_X1_*runtime.g;_X2_uintptr_} { // Original name: noalg.struct { F uintptr; X0 *runtime.funcval; X1 *runtime.g; X2 uintptr }
    uintptr F;
    struct runtime.funcval *X0;
    struct runtime.g *X1;
    uintptr X2;
};

typedef struct math/rand/v2.Rand math/rand/v2.Rand, *Pmath/rand/v2.Rand;

struct math/rand/v2.Rand {
    math/rand/v2.Source src;
};

typedef struct unicode/utf8.DecodeRuneInString_multivalue_return_type unicode/utf8.DecodeRuneInString_multivalue_return_type, *Punicode/utf8.DecodeRuneInString_multivalue_return_type;

struct unicode/utf8.DecodeRuneInString_multivalue_return_type { // Artificial data type to hold a function's return values
    int32 r; // ordinal: 0
    int size; // ordinal: 1
};

typedef struct runtime.(*pageCache).alloc_multivalue_return_type runtime.(*pageCache).alloc_multivalue_return_type, *Pruntime.(*pageCache).alloc_multivalue_return_type;

struct runtime.(*pageCache).alloc_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr ~r0; // ordinal: 0
    uintptr ~r1; // ordinal: 1
};

typedef struct struct_{_runtime.lock_runtime.mutex;_runtime.free_*runtime.gcBitsArena;_runtime.next_*runtime.gcBitsArena;_runtime.current_*runtime.gcBitsArena;_runtime.previous_*runtime.gcBitsArena_} struct_{_runtime.lock_runtime.mutex;_runtime.free_*runtime.gcBitsArena;_runtime.next_*runtime.gcBitsArena;_runtime.current_*runtime.gcBitsArena;_runtime.previous_*runtime.gcBitsArena_}, *Pstruct_{_runtime.lock_runtime.mutex;_runtime.free_*runtime.gcBitsArena;_runtime.next_*runtime.gcBitsArena;_runtime.current_*runtime.gcBitsArena;_runtime.previous_*runtime.gcBitsArena_};

struct struct_{_runtime.lock_runtime.mutex;_runtime.free_*runtime.gcBitsArena;_runtime.next_*runtime.gcBitsArena;_runtime.current_*runtime.gcBitsArena;_runtime.previous_*runtime.gcBitsArena_} { // Original name: struct { runtime.lock runtime.mutex; runtime.free *runtime.gcBitsArena; runtime.next *runtime.gcBitsArena; runtime.current *runtime.gcBitsArena; runtime.previous *runtime.gcBitsArena }
    struct runtime.mutex lock;
    struct runtime.gcBitsArena *free;
    struct runtime.gcBitsArena *next;
    struct runtime.gcBitsArena *current;
    struct runtime.gcBitsArena *previous;
};

typedef struct syscall.GetFileType_multivalue_return_type syscall.GetFileType_multivalue_return_type, *Psyscall.GetFileType_multivalue_return_type;

struct syscall.GetFileType_multivalue_return_type { // Artificial data type to hold a function's return values
    uint32 n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct struct_{_runtime.hooks_[]runtime.exitHook;_runtime.runningExitHooks_bool_} struct_{_runtime.hooks_[]runtime.exitHook;_runtime.runningExitHooks_bool_}, *Pstruct_{_runtime.hooks_[]runtime.exitHook;_runtime.runningExitHooks_bool_};

struct struct_{_runtime.hooks_[]runtime.exitHook;_runtime.runningExitHooks_bool_} { // Original name: struct { runtime.hooks []runtime.exitHook; runtime.runningExitHooks bool }
    struct []runtime.exitHook hooks;
    bool runningExitHooks;
};

typedef struct syscall.Syscall6_multivalue_return_type syscall.Syscall6_multivalue_return_type, *Psyscall.Syscall6_multivalue_return_type;

struct syscall.Syscall6_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr r1; // ordinal: 0
    uintptr r2; // ordinal: 1
    uintptr err; // ordinal: 2
};

typedef struct noalg.struct_{_F_uintptr;_X0_func(*runtime.g);_X1_*runtime.g_} noalg.struct_{_F_uintptr;_X0_func(*runtime.g);_X1_*runtime.g_}, *Pnoalg.struct_{_F_uintptr;_X0_func(*runtime.g);_X1_*runtime.g_};

struct noalg.struct_{_F_uintptr;_X0_func(*runtime.g);_X1_*runtime.g_} { // Original name: noalg.struct { F uintptr; X0 func(*runtime.g); X1 *runtime.g }
    uintptr F;
    void (**X0)(struct runtime.g *);
    struct runtime.g *X1;
};

typedef struct syscall.getprocaddress_multivalue_return_type syscall.getprocaddress_multivalue_return_type, *Psyscall.getprocaddress_multivalue_return_type;

struct syscall.getprocaddress_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr outhandle; // ordinal: 0
    uintptr err; // ordinal: 1
};

typedef struct io.ReadAtLeast_multivalue_return_type io.ReadAtLeast_multivalue_return_type, *Pio.ReadAtLeast_multivalue_return_type;

struct io.ReadAtLeast_multivalue_return_type { // Artificial data type to hold a function's return values
    int n; // ordinal: 0
    error err; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime._panic;_X1_*bool;_X2_*runtime.g;_X3_uintptr;_X4_uintptr_} noalg.struct_{_F_uintptr;_X0_*runtime._panic;_X1_*bool;_X2_*runtime.g;_X3_uintptr;_X4_uintptr_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime._panic;_X1_*bool;_X2_*runtime.g;_X3_uintptr;_X4_uintptr_};

struct noalg.struct_{_F_uintptr;_X0_*runtime._panic;_X1_*bool;_X2_*runtime.g;_X3_uintptr;_X4_uintptr_} { // Original name: noalg.struct { F uintptr; X0 *runtime._panic; X1 *bool; X2 *runtime.g; X3 uintptr; X4 uintptr }
    uintptr F;
    struct runtime._panic *X0;
    bool *X1;
    struct runtime.g *X2;
    uintptr X3;
    uintptr X4;
};

typedef struct runtime._DEVICE_NOTIFY_SUBSCRIBE_PARAMETERS.2 runtime._DEVICE_NOTIFY_SUBSCRIBE_PARAMETERS.2, *Pruntime._DEVICE_NOTIFY_SUBSCRIBE_PARAMETERS.2;

struct runtime._DEVICE_NOTIFY_SUBSCRIBE_PARAMETERS.2 { // Original name: runtime._DEVICE_NOTIFY_SUBSCRIBE_PARAMETERS·2
    uintptr callback;
    uintptr context;
};

typedef struct os.UserCacheDir_multivalue_return_type os.UserCacheDir_multivalue_return_type, *Pos.UserCacheDir_multivalue_return_type;

struct os.UserCacheDir_multivalue_return_type { // Artificial data type to hold a function's return values
    struct string ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct runtime.iface fmt.Stringer;

typedef struct runtime.(*gcControllerState).trigger_multivalue_return_type runtime.(*gcControllerState).trigger_multivalue_return_type, *Pruntime.(*gcControllerState).trigger_multivalue_return_type;

struct runtime.(*gcControllerState).trigger_multivalue_return_type { // Artificial data type to hold a function's return values
    uint64 ~r0; // ordinal: 0
    uint64 ~r1; // ordinal: 1
};

typedef struct runtime.mstats runtime.mstats, *Pruntime.mstats;

struct runtime.mstats {
    struct runtime.consistentHeapStats heapStats;
    runtime.sysMemStat stacks_sys;
    runtime.sysMemStat mspan_sys;
    runtime.sysMemStat mcache_sys;
    runtime.sysMemStat buckhash_sys;
    runtime.sysMemStat gcMiscSys;
    runtime.sysMemStat other_sys;
    uint64 last_gc_unix;
    uint64 pause_total_ns;
    uint64 pause_ns[256];
    uint64 pause_end[256];
    uint32 numgc;
    uint32 numforcedgc;
    float64 gc_cpu_fraction;
    uint64 last_gc_nanotime;
    uint64 lastHeapInUse;
    bool enablegc;
};

typedef struct runtime.mapaccess2_fast32_multivalue_return_type runtime.mapaccess2_fast32_multivalue_return_type, *Pruntime.mapaccess2_fast32_multivalue_return_type;

struct runtime.mapaccess2_fast32_multivalue_return_type { // Artificial data type to hold a function's return values
    void *~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct runtime.(*pallocBits).findLargeN_multivalue_return_type runtime.(*pallocBits).findLargeN_multivalue_return_type, *Pruntime.(*pallocBits).findLargeN_multivalue_return_type;

struct runtime.(*pallocBits).findLargeN_multivalue_return_type { // Artificial data type to hold a function's return values
    uint ~r0; // ordinal: 0
    uint ~r1; // ordinal: 1
};

typedef struct struct_{_runtime.lock_runtime.mutex;_runtime.newm_runtime.muintptr;_runtime.waiting_bool;_runtime.wake_runtime.note;_runtime.haveTemplateThread_uint32_} struct_{_runtime.lock_runtime.mutex;_runtime.newm_runtime.muintptr;_runtime.waiting_bool;_runtime.wake_runtime.note;_runtime.haveTemplateThread_uint32_}, *Pstruct_{_runtime.lock_runtime.mutex;_runtime.newm_runtime.muintptr;_runtime.waiting_bool;_runtime.wake_runtime.note;_runtime.haveTemplateThread_uint32_};

struct struct_{_runtime.lock_runtime.mutex;_runtime.newm_runtime.muintptr;_runtime.waiting_bool;_runtime.wake_runtime.note;_runtime.haveTemplateThread_uint32_} { // Original name: struct { runtime.lock runtime.mutex; runtime.newm runtime.muintptr; runtime.waiting bool; runtime.wake runtime.note; runtime.haveTemplateThread uint32 }
    struct runtime.mutex lock;
    runtime.muintptr newm;
    bool waiting;
    struct runtime.note wake;
    uint32 haveTemplateThread;
};

typedef struct internal/poll.(*FD).writeConsole_multivalue_return_type internal/poll.(*FD).writeConsole_multivalue_return_type, *Pinternal/poll.(*FD).writeConsole_multivalue_return_type;

struct internal/poll.(*FD).writeConsole_multivalue_return_type { // Artificial data type to hold a function's return values
    int ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct []internal/cpu.option []internal/cpu.option, *P[]internal/cpu.option;

struct []internal/cpu.option {
    struct internal/cpu.option *array;
    int len;
    int cap;
};

typedef struct strconv.Atoi_multivalue_return_type strconv.Atoi_multivalue_return_type, *Pstrconv.Atoi_multivalue_return_type;

struct strconv.Atoi_multivalue_return_type { // Artificial data type to hold a function's return values
    int ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct golang.org/x/crypto/internal/poly1305.(*mac).Write_multivalue_return_type golang.org/x/crypto/internal/poly1305.(*mac).Write_multivalue_return_type, *Pgolang.org/x/crypto/internal/poly1305.(*mac).Write_multivalue_return_type;

struct golang.org/x/crypto/internal/poly1305.(*mac).Write_multivalue_return_type { // Artificial data type to hold a function's return values
    int ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct fmt.(*ss).scanBasePrefix_multivalue_return_type fmt.(*ss).scanBasePrefix_multivalue_return_type, *Pfmt.(*ss).scanBasePrefix_multivalue_return_type;

struct fmt.(*ss).scanBasePrefix_multivalue_return_type { // Artificial data type to hold a function's return values
    int base; // ordinal: 0
    struct string digits; // ordinal: 1
    bool zeroFound; // ordinal: 2
};

typedef struct sync.(*poolChain).popTail_multivalue_return_type sync.(*poolChain).popTail_multivalue_return_type, *Psync.(*poolChain).popTail_multivalue_return_type;

struct sync.(*poolChain).popTail_multivalue_return_type { // Artificial data type to hold a function's return values
    interface_{} ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_uintptr;_X2_uintptr_} noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_uintptr;_X2_uintptr_}, *Pnoalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_uintptr;_X2_uintptr_};

struct noalg.struct_{_F_uintptr;_X0_*runtime.g;_X1_uintptr;_X2_uintptr_} { // Original name: noalg.struct { F uintptr; X0 *runtime.g; X1 uintptr; X2 uintptr }
    uintptr F;
    struct runtime.g *X0;
    uintptr X1;
    uintptr X2;
};

typedef struct os.openFileNolog_multivalue_return_type os.openFileNolog_multivalue_return_type, *Pos.openFileNolog_multivalue_return_type;

struct os.openFileNolog_multivalue_return_type { // Artificial data type to hold a function's return values
    struct os.File *~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct _CONTEXT CONTEXT;

typedef struct _RUNTIME_FUNCTION _RUNTIME_FUNCTION, *P_RUNTIME_FUNCTION;

struct _RUNTIME_FUNCTION {
    DWORD BeginAddress;
    DWORD EndAddress;
    DWORD UnwindData;
};

typedef struct _RUNTIME_FUNCTION *PRUNTIME_FUNCTION;

typedef struct _UNWIND_HISTORY_TABLE_ENTRY _UNWIND_HISTORY_TABLE_ENTRY, *P_UNWIND_HISTORY_TABLE_ENTRY;

typedef struct _UNWIND_HISTORY_TABLE_ENTRY UNWIND_HISTORY_TABLE_ENTRY;

struct _UNWIND_HISTORY_TABLE_ENTRY {
    DWORD64 ImageBase;
    PRUNTIME_FUNCTION FunctionEntry;
};

typedef union _union_61 _union_61, *P_union_61;

typedef struct _M128A *PM128A;

typedef struct _struct_62 _struct_62, *P_struct_62;

struct _struct_62 {
    PM128A Xmm0;
    PM128A Xmm1;
    PM128A Xmm2;
    PM128A Xmm3;
    PM128A Xmm4;
    PM128A Xmm5;
    PM128A Xmm6;
    PM128A Xmm7;
    PM128A Xmm8;
    PM128A Xmm9;
    PM128A Xmm10;
    PM128A Xmm11;
    PM128A Xmm12;
    PM128A Xmm13;
    PM128A Xmm14;
    PM128A Xmm15;
};

union _union_61 {
    PM128A FloatingContext[16];
    struct _struct_62 s;
};

typedef union _union_63 _union_63, *P_union_63;

typedef ulonglong *PDWORD64;

typedef struct _struct_64 _struct_64, *P_struct_64;

struct _struct_64 {
    PDWORD64 Rax;
    PDWORD64 Rcx;
    PDWORD64 Rdx;
    PDWORD64 Rbx;
    PDWORD64 Rsp;
    PDWORD64 Rbp;
    PDWORD64 Rsi;
    PDWORD64 Rdi;
    PDWORD64 R8;
    PDWORD64 R9;
    PDWORD64 R10;
    PDWORD64 R11;
    PDWORD64 R12;
    PDWORD64 R13;
    PDWORD64 R14;
    PDWORD64 R15;
};

union _union_63 {
    PDWORD64 IntegerContext[16];
    struct _struct_64 s;
};

typedef EXCEPTION_DISPOSITION (EXCEPTION_ROUTINE)(struct _EXCEPTION_RECORD *, PVOID, struct _CONTEXT *, PVOID);

typedef struct _UNWIND_HISTORY_TABLE _UNWIND_HISTORY_TABLE, *P_UNWIND_HISTORY_TABLE;

struct _UNWIND_HISTORY_TABLE {
    DWORD Count;
    BYTE LocalHint;
    BYTE GlobalHint;
    BYTE Search;
    BYTE Once;
    DWORD64 LowAddress;
    DWORD64 HighAddress;
    UNWIND_HISTORY_TABLE_ENTRY Entry[12];
};

typedef CHAR *LPCSTR;

typedef struct _MEMORY_BASIC_INFORMATION _MEMORY_BASIC_INFORMATION, *P_MEMORY_BASIC_INFORMATION;

typedef struct _MEMORY_BASIC_INFORMATION *PMEMORY_BASIC_INFORMATION;

typedef ULONG_PTR SIZE_T;

struct _MEMORY_BASIC_INFORMATION {
    PVOID BaseAddress;
    PVOID AllocationBase;
    DWORD AllocationProtect;
    SIZE_T RegionSize;
    DWORD State;
    DWORD Protect;
    DWORD Type;
};

typedef CHAR *LPSTR;

typedef long LONG;

typedef wchar_t WCHAR;

typedef struct _KNONVOLATILE_CONTEXT_POINTERS _KNONVOLATILE_CONTEXT_POINTERS, *P_KNONVOLATILE_CONTEXT_POINTERS;

struct _KNONVOLATILE_CONTEXT_POINTERS {
    union _union_61 u;
    union _union_63 u2;
};

typedef union _LARGE_INTEGER _LARGE_INTEGER, *P_LARGE_INTEGER;

typedef struct _struct_19 _struct_19, *P_struct_19;

typedef struct _struct_20 _struct_20, *P_struct_20;

struct _struct_20 {
    DWORD LowPart;
    LONG HighPart;
};

struct _struct_19 {
    DWORD LowPart;
    LONG HighPart;
};

union _LARGE_INTEGER {
    struct _struct_19 s;
    struct _struct_20 u;
    LONGLONG QuadPart;
};

typedef union _LARGE_INTEGER LARGE_INTEGER;

typedef LONG (*PVECTORED_EXCEPTION_HANDLER)(struct _EXCEPTION_POINTERS *);

typedef WCHAR *LPWCH;

typedef WCHAR *LPCWSTR;

typedef struct _UNWIND_HISTORY_TABLE *PUNWIND_HISTORY_TABLE;

typedef long HRESULT;

typedef struct _KNONVOLATILE_CONTEXT_POINTERS *PKNONVOLATILE_CONTEXT_POINTERS;

typedef EXCEPTION_ROUTINE *PEXCEPTION_ROUTINE;

typedef struct IMAGE_DOS_HEADER IMAGE_DOS_HEADER, *PIMAGE_DOS_HEADER;

struct IMAGE_DOS_HEADER {
    char e_magic[2]; // Magic number
    word e_cblp; // Bytes of last page
    word e_cp; // Pages in file
    word e_crlc; // Relocations
    word e_cparhdr; // Size of header in paragraphs
    word e_minalloc; // Minimum extra paragraphs needed
    word e_maxalloc; // Maximum extra paragraphs needed
    word e_ss; // Initial (relative) SS value
    word e_sp; // Initial SP value
    word e_csum; // Checksum
    word e_ip; // Initial IP value
    word e_cs; // Initial (relative) CS value
    word e_lfarlc; // File address of relocation table
    word e_ovno; // Overlay number
    word e_res[4][4]; // Reserved words
    word e_oemid; // OEM identifier (for e_oeminfo)
    word e_oeminfo; // OEM information; e_oemid specific
    word e_res2[10][10]; // Reserved words
    dword e_lfanew; // File address of new exe header
    byte e_program[64]; // Actual DOS program
};

typedef ULONG_PTR *PDWORD_PTR;

typedef longlong INT_PTR;

typedef ulonglong UINT_PTR;

typedef struct func(bool, func(int32) bool) ([]uint8, error)_multivalue_return_type func(bool, func(int32) bool) ([]uint8, error)_multivalue_return_type, *Pfunc(bool, func(int32) bool) ([]uint8, error)_multivalue_return_type;


// WARNING! conflicting data type names: /golang-recovered/[]uint8 - /DWARF/_UNCATEGORIZED_/[]uint8

struct func(bool, func(int32) bool) ([]uint8, error)_multivalue_return_type { // Artificial data type to hold a function's return values
    struct []uint8 ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};


// WARNING! conflicting data type names: /golang-recovered/[]runtime.modulehash - /DWARF/_UNCATEGORIZED_/[]runtime.modulehash

typedef struct []int8 []int8, *P[]int8;

struct []int8 {
    int8 *array;
    int len;
    int cap;
};

typedef struct struct { F uintptr; X0 chan int } struct { F uintptr; X0 chan int }, *Pstruct { F uintptr; X0 chan int };


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.hchan - /DWARF/_UNCATEGORIZED_/runtime.hchan

typedef struct runtime.hchan *chan int;

struct struct { F uintptr; X0 chan int } {
    uintptr F;
    chan int X0;
};

typedef struct [][]*abi.Type [][]*abi.Type, *P[][]*abi.Type;

typedef struct []*abi.Type []*abi.Type, *P[]*abi.Type;


// WARNING! conflicting data type names: /golang-recovered/internal\/abi/internal/abi.Type - /DWARF/_UNCATEGORIZED_/internal/abi.Type

struct [][]*abi.Type {
    struct []*abi.Type *array;
    int len;
    int cap;
};

struct []*abi.Type {
    struct internal/abi.Type **array;
    int len;
    int cap;
};

typedef struct runtime.hchan *chan bool;

typedef struct runtime.iface interface {};


// WARNING! conflicting data type names: /golang-recovered/complex128 - /DWARF/complex128

typedef struct struct { F uintptr; X0 *abi.Type } struct { F uintptr; X0 *abi.Type }, *Pstruct { F uintptr; X0 *abi.Type };

struct struct { F uintptr; X0 *abi.Type } {
    uintptr F;
    struct internal/abi.Type *X0;
};

typedef struct func(string) (reflect.Method, bool)_multivalue_return_type func(string) (reflect.Method, bool)_multivalue_return_type, *Pfunc(string) (reflect.Method, bool)_multivalue_return_type;


// WARNING! conflicting data type names: /golang-recovered/reflect/reflect.Method - /DWARF/_UNCATEGORIZED_/reflect.Method

struct func(string) (reflect.Method, bool)_multivalue_return_type { // Artificial data type to hold a function's return values
    struct reflect.Method ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};


// WARNING! conflicting data type names: /golang-recovered/[]reflect.Value - /DWARF/_UNCATEGORIZED_/[]reflect.Value


// WARNING! conflicting data type names: /golang-recovered/[]runtime.ptabEntry - /DWARF/_UNCATEGORIZED_/[]runtime.ptabEntry

typedef struct struct {} struct {}, *Pstruct {};

struct struct {} {
};


// WARNING! conflicting data type names: /golang-recovered/[]uintptr - /DWARF/_UNCATEGORIZED_/[]uintptr


// WARNING! conflicting data type names: /golang-recovered/[]sync.eface - /DWARF/_UNCATEGORIZED_/[]sync.eface

typedef struct []abi.Imethod []abi.Imethod, *P[]abi.Imethod;

struct []abi.Imethod {
    struct internal/abi.Imethod *array;
    int len;
    int cap;
};


// WARNING! conflicting data type names: /golang-recovered/[]runtime.textsect - /DWARF/_UNCATEGORIZED_/[]runtime.textsect

typedef struct []cpu.option.1 []cpu.option.1, *P[]cpu.option.1;

struct []cpu.option.1 {
    struct golang.org/x/sys/cpu.option *array;
    int len;
    int cap;
};

typedef struct []cpu.option.2 []cpu.option.2, *P[]cpu.option.2;

struct []cpu.option.2 {
    struct internal/cpu.option *array;
    int len;
    int cap;
};

typedef struct map.bucket[interface {}]*sync.entry map.bucket[interface {}]*sync.entry, *Pmap.bucket[interface {}]*sync.entry;


// WARNING! conflicting data type names: /golang-recovered/sync/sync.entry - /DWARF/_UNCATEGORIZED_/sync.entry

typedef pointer unsafe.Pointer;

struct map.bucket[interface {}]*sync.entry {
    uint8 topbits[8];
    interface {} keys[8];
    struct sync.entry *elems[8];
    unsafe.Pointer overflow;
};

typedef struct []*runtime.PanicNilError []*runtime.PanicNilError, *P[]*runtime.PanicNilError;


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.PanicNilError - /DWARF/_UNCATEGORIZED_/runtime.PanicNilError

struct []*runtime.PanicNilError {
    struct runtime.PanicNilError **array;
    int len;
    int cap;
};


// WARNING! conflicting data type names: /golang-recovered/[]runtime.abiPart - /DWARF/_UNCATEGORIZED_/[]runtime.abiPart

typedef struct map.bucket[int32]unsafe.Pointer map.bucket[int32]unsafe.Pointer, *Pmap.bucket[int32]unsafe.Pointer;

struct map.bucket[int32]unsafe.Pointer {
    uint8 topbits[8];
    int32 keys[8];
    unsafe.Pointer elems[8];
    unsafe.Pointer overflow;
};

typedef struct []runtime.winCallbackKey []runtime.winCallbackKey, *P[]runtime.winCallbackKey;


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.winCallbackKey - /DWARF/_UNCATEGORIZED_/runtime.winCallbackKey

struct []runtime.winCallbackKey {
    struct runtime.winCallbackKey *array;
    int len;
    int cap;
};

typedef struct []runtime.guintptr []runtime.guintptr, *P[]runtime.guintptr;

struct []runtime.guintptr {
    runtime.guintptr *array;
    int len;
    int cap;
};

typedef struct map.bucket[string]bool map.bucket[string]bool, *Pmap.bucket[string]bool;

struct map.bucket[string]bool {
    uint8 topbits[8];
    struct string keys[8];
    bool elems[8];
    unsafe.Pointer overflow;
};


// WARNING! conflicting data type names: /golang-recovered/[]*runtime.mspan - /DWARF/_UNCATEGORIZED_/[]*runtime.mspan

typedef struct func([]uint8) (int, error)_multivalue_return_type func([]uint8) (int, error)_multivalue_return_type, *Pfunc([]uint8) (int, error)_multivalue_return_type;

struct func([]uint8) (int, error)_multivalue_return_type { // Artificial data type to hold a function's return values
    int ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};

typedef struct []runtime.heldLockInfo []runtime.heldLockInfo, *P[]runtime.heldLockInfo;

struct []runtime.heldLockInfo {
    struct runtime.heldLockInfo *array;
    int len;
    int cap;
};

typedef struct []*sync.entry []*sync.entry, *P[]*sync.entry;

struct []*sync.entry {
    struct sync.entry **array;
    int len;
    int cap;
};

typedef struct struct { F uintptr; X0 *sync.Once; X1 func(); X2 *bool; X3 *interface {}; X4 *go.shape.bool; X5 *[3]uintptr } struct { F uintptr; X0 *sync.Once; X1 func(); X2 *bool; X3 *interface {}; X4 *go.shape.bool; X5 *[3]uintptr }, *Pstruct { F uintptr; X0 *sync.Once; X1 func(); X2 *bool; X3 *interface {}; X4 *go.shape.bool; X5 *[3]uintptr };


// WARNING! conflicting data type names: /golang-recovered/sync/sync.Once - /DWARF/_UNCATEGORIZED_/sync.Once

struct struct { F uintptr; X0 *sync.Once; X1 func(); X2 *bool; X3 *interface {}; X4 *go.shape.bool; X5 *[3]uintptr } {
    uintptr F;
    struct sync.Once *X0;
    void (**X1)(void);
    bool *X2;
    interface {} *X3;
    go.shape.bool *X4;
    uintptr (*X5)[3];
};


// WARNING! conflicting data type names: /golang-recovered/[]*runtime._defer - /DWARF/_UNCATEGORIZED_/[]*runtime._defer


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.hmap - /DWARF/_UNCATEGORIZED_/runtime.hmap

typedef struct runtime.hmap *map[uint32][]*abi.Type;

typedef struct []error []error, *P[]error;

struct []error {
    error *array;
    int len;
    int cap;
};


// WARNING! conflicting data type names: /golang-recovered/map[string]bool - /DWARF/_UNCATEGORIZED_/map[string]bool

typedef sword int16;

typedef struct []bool []bool, *P[]bool;

struct []bool {
    bool *array;
    int len;
    int cap;
};

typedef struct func(uintptr) (uintptr, int64)_multivalue_return_type func(uintptr) (uintptr, int64)_multivalue_return_type, *Pfunc(uintptr) (uintptr, int64)_multivalue_return_type;

struct func(uintptr) (uintptr, int64)_multivalue_return_type { // Artificial data type to hold a function's return values
    uintptr ~r0; // ordinal: 0
    int64 ~r1; // ordinal: 1
};

typedef struct struct { F uintptr; X0 *interface {}; X1 *bool; X2 *go.shape.bool; X3 *func() go.shape.bool; X4 *[3]uintptr } struct { F uintptr; X0 *interface {}; X1 *bool; X2 *go.shape.bool; X3 *func() go.shape.bool; X4 *[3]uintptr }, *Pstruct { F uintptr; X0 *interface {}; X1 *bool; X2 *go.shape.bool; X3 *func() go.shape.bool; X4 *[3]uintptr };

struct struct { F uintptr; X0 *interface {}; X1 *bool; X2 *go.shape.bool; X3 *func() go.shape.bool; X4 *[3]uintptr } {
    uintptr F;
    interface {} *X0;
    bool *X1;
    go.shape.bool *X2;
    go.shape.bool (***X3)(void);
    uintptr (*X4)[3];
};

typedef struct []runtime.stackfreelist []runtime.stackfreelist, *P[]runtime.stackfreelist;

struct []runtime.stackfreelist {
    struct runtime.stackfreelist *array;
    int len;
    int cap;
};

typedef struct func(func(string) bool) (reflect.StructField, bool)_multivalue_return_type func(func(string) bool) (reflect.StructField, bool)_multivalue_return_type, *Pfunc(func(string) bool) (reflect.StructField, bool)_multivalue_return_type;


// WARNING! conflicting data type names: /golang-recovered/reflect/reflect.StructField - /DWARF/_UNCATEGORIZED_/reflect.StructField

struct func(func(string) bool) (reflect.StructField, bool)_multivalue_return_type { // Artificial data type to hold a function's return values
    struct reflect.StructField ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct []atomic.Uint32 []atomic.Uint32, *P[]atomic.Uint32;


// WARNING! conflicting data type names: /golang-recovered/runtime\/internal\/atomic/runtime/internal/atomic.Uint32 - /DWARF/_UNCATEGORIZED_/runtime/internal/atomic.Uint32

struct []atomic.Uint32 {
    struct runtime/internal/atomic.Uint32 *array;
    int len;
    int cap;
};

typedef struct runtime.hmap *map[runtime._typePair]struct {};


// WARNING! conflicting data type names: /golang-recovered/[]unsafe.Pointer - /DWARF/_UNCATEGORIZED_/[]unsafe.Pointer


// WARNING! conflicting data type names: /golang-recovered/[]*runtime.moduledata - /DWARF/_UNCATEGORIZED_/[]*runtime.moduledata


// WARNING! conflicting data type names: /golang-recovered/[]syscall.WSABuf - /DWARF/_UNCATEGORIZED_/[]syscall.WSABuf

typedef struct map.bucket[unsafe.Pointer]int32 map.bucket[unsafe.Pointer]int32, *Pmap.bucket[unsafe.Pointer]int32;

struct map.bucket[unsafe.Pointer]int32 {
    uint8 topbits[8];
    unsafe.Pointer keys[8];
    int32 elems[8];
    unsafe.Pointer overflow;
};

typedef struct []abi.TypeOff []abi.TypeOff, *P[]abi.TypeOff;

struct []abi.TypeOff {
    internal/abi.TypeOff *array;
    int len;
    int cap;
};

typedef struct func() (int, bool)_multivalue_return_type func() (int, bool)_multivalue_return_type, *Pfunc() (int, bool)_multivalue_return_type;

struct func() (int, bool)_multivalue_return_type { // Artificial data type to hold a function's return values
    int ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct map.bucket[uint32][]*abi.Type map.bucket[uint32][]*abi.Type, *Pmap.bucket[uint32][]*abi.Type;

struct map.bucket[uint32][]*abi.Type {
    uint8 topbits[8];
    uint32 keys[8];
    struct []*abi.Type elems[8];
    unsafe.Pointer overflow;
};


// WARNING! conflicting data type names: /golang-recovered/map[int32]unsafe.Pointer - /DWARF/_UNCATEGORIZED_/map[int32]unsafe.Pointer

typedef struct runtime.hmap *map[interface {}]*sync.entry;


// WARNING! conflicting data type names: /golang-recovered/[]runtime.ancestorInfo - /DWARF/_UNCATEGORIZED_/[]runtime.ancestorInfo


// WARNING! conflicting data type names: /golang-recovered/[]uint16 - /DWARF/_UNCATEGORIZED_/[]uint16

typedef struct [][8]runtime.pcvalueCacheEnt [][8]runtime.pcvalueCacheEnt, *P[][8]runtime.pcvalueCacheEnt;

struct [][8]runtime.pcvalueCacheEnt {
    struct runtime.pcvalueCacheEnt (*array)[8];
    int len;
    int cap;
};

typedef struct []*runtime.traceBuf []*runtime.traceBuf, *P[]*runtime.traceBuf;


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.traceBuf - /DWARF/_UNCATEGORIZED_/runtime.traceBuf

struct []*runtime.traceBuf {
    struct runtime.traceBuf **array;
    int len;
    int cap;
};


// WARNING! conflicting data type names: /golang-recovered/[]*runtime.initTask - /DWARF/_UNCATEGORIZED_/[]*runtime.initTask


// WARNING! conflicting data type names: /golang-recovered/map[string]*unicode.RangeTable - /DWARF/_UNCATEGORIZED_/map[string]*unicode.RangeTable


// WARNING! conflicting data type names: /golang-recovered/[]int32 - /DWARF/_UNCATEGORIZED_/[]int32

typedef struct []struct {} []struct {}, *P[]struct {};

struct []struct {} {
    struct struct {} *array;
    int len;
    int cap;
};

typedef struct []interface {} []interface {}, *P[]interface {};

struct []interface {} {
    interface {} *array;
    int len;
    int cap;
};


// WARNING! conflicting data type names: /golang-recovered/complex64 - /DWARF/complex64

typedef struct []runtime.pcvalueCacheEnt []runtime.pcvalueCacheEnt, *P[]runtime.pcvalueCacheEnt;

struct []runtime.pcvalueCacheEnt {
    struct runtime.pcvalueCacheEnt *array;
    int len;
    int cap;
};

typedef struct []*interface {} []*interface {}, *P[]*interface {};

struct []*interface {} {
    interface {} **array;
    int len;
    int cap;
};

typedef struct func(string) (reflect.StructField, bool)_multivalue_return_type func(string) (reflect.StructField, bool)_multivalue_return_type, *Pfunc(string) (reflect.StructField, bool)_multivalue_return_type;

struct func(string) (reflect.StructField, bool)_multivalue_return_type { // Artificial data type to hold a function's return values
    struct reflect.StructField ~r0; // ordinal: 0
    bool ~r1; // ordinal: 1
};

typedef struct func() (unsafe.Pointer, int32, error)_multivalue_return_type func() (unsafe.Pointer, int32, error)_multivalue_return_type, *Pfunc() (unsafe.Pointer, int32, error)_multivalue_return_type;

struct func() (unsafe.Pointer, int32, error)_multivalue_return_type { // Artificial data type to hold a function's return values
    unsafe.Pointer ~r0; // ordinal: 0
    int32 ~r1; // ordinal: 1
    error ~r2; // ordinal: 2
};


// WARNING! conflicting data type names: /golang-recovered/[]*runtime.sudog - /DWARF/_UNCATEGORIZED_/[]*runtime.sudog


// WARNING! conflicting data type names: /golang-recovered/[]uint64 - /DWARF/_UNCATEGORIZED_/[]uint64


// WARNING! conflicting data type names: /golang-recovered/map[unsafe.Pointer]int32 - /DWARF/_UNCATEGORIZED_/map[unsafe.Pointer]int32


// WARNING! conflicting data type names: /golang-recovered/[]*runtime.timer - /DWARF/_UNCATEGORIZED_/[]*runtime.timer


// WARNING! conflicting data type names: /golang-recovered/[]uint32 - /DWARF/_UNCATEGORIZED_/[]uint32

typedef struct map.bucket[runtime._typePair]struct {} map.bucket[runtime._typePair]struct {}, *Pmap.bucket[runtime._typePair]struct {};


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime._typePair - /DWARF/_UNCATEGORIZED_/runtime._typePair

struct map.bucket[runtime._typePair]struct {} {
    uint8 topbits[8];
    struct runtime._typePair keys[8];
    unsafe.Pointer overflow; // Omitted zero-len field: elems=[8]struct {}
};


// WARNING! conflicting data type names: /golang-recovered/[]*runtime.itab - /DWARF/_UNCATEGORIZED_/[]*runtime.itab

typedef struct []runtime._typePair []runtime._typePair, *P[]runtime._typePair;

struct []runtime._typePair {
    struct runtime._typePair *array;
    int len;
    int cap;
};

typedef struct func([]uint8, []uint8, []uint8, []uint8) ([]uint8, error)_multivalue_return_type func([]uint8, []uint8, []uint8, []uint8) ([]uint8, error)_multivalue_return_type, *Pfunc([]uint8, []uint8, []uint8, []uint8) ([]uint8, error)_multivalue_return_type;

struct func([]uint8, []uint8, []uint8, []uint8) ([]uint8, error)_multivalue_return_type { // Artificial data type to hold a function's return values
    struct []uint8 ~r0; // ordinal: 0
    error ~r1; // ordinal: 1
};


// WARNING! conflicting data type names: /golang-recovered/[]runtime.Frame - /DWARF/_UNCATEGORIZED_/[]runtime.Frame

typedef struct map.bucket[abi.TypeOff]*abi.Type map.bucket[abi.TypeOff]*abi.Type, *Pmap.bucket[abi.TypeOff]*abi.Type;

struct map.bucket[abi.TypeOff]*abi.Type {
    uint8 topbits[8];
    internal/abi.TypeOff keys[8];
    struct internal/abi.Type *elems[8];
    unsafe.Pointer overflow;
};


// WARNING! conflicting data type names: /golang-recovered/[]unicode.Range16 - /DWARF/_UNCATEGORIZED_/[]unicode.Range16

typedef struct func() (int32, int, error)_multivalue_return_type func() (int32, int, error)_multivalue_return_type, *Pfunc() (int32, int, error)_multivalue_return_type;

struct func() (int32, int, error)_multivalue_return_type { // Artificial data type to hold a function's return values
    int32 ~r0; // ordinal: 0
    int ~r1; // ordinal: 1
    error ~r2; // ordinal: 2
};

typedef struct map.bucket[string]*unicode.RangeTable map.bucket[string]*unicode.RangeTable, *Pmap.bucket[string]*unicode.RangeTable;


// WARNING! conflicting data type names: /golang-recovered/unicode/unicode.RangeTable - /DWARF/_UNCATEGORIZED_/unicode.RangeTable

struct map.bucket[string]*unicode.RangeTable {
    uint8 topbits[8];
    struct string keys[8];
    struct unicode.RangeTable *elems[8];
    unsafe.Pointer overflow;
};


// WARNING! conflicting data type names: /golang-recovered/map[runtime.winCallbackKey]int - /DWARF/_UNCATEGORIZED_/map[runtime.winCallbackKey]int

typedef struct []*unicode.RangeTable []*unicode.RangeTable, *P[]*unicode.RangeTable;

struct []*unicode.RangeTable {
    struct unicode.RangeTable **array;
    int len;
    int cap;
};


// WARNING! conflicting data type names: /golang-recovered/[]*runtime.bmap - /DWARF/_UNCATEGORIZED_/[]*runtime.bmap

typedef struct map.bucket[runtime.winCallbackKey]int map.bucket[runtime.winCallbackKey]int, *Pmap.bucket[runtime.winCallbackKey]int;

struct map.bucket[runtime.winCallbackKey]int {
    uint8 topbits[8];
    struct runtime.winCallbackKey keys[8];
    int elems[8];
    unsafe.Pointer overflow;
};


// WARNING! conflicting data type names: /golang-recovered/[]reflect.abiStep - /DWARF/_UNCATEGORIZED_/[]reflect.abiStep


// WARNING! conflicting data type names: /golang-recovered/[]unicode.Range32 - /DWARF/_UNCATEGORIZED_/[]unicode.Range32

typedef struct runtime.hmap *map[abi.TypeOff]*abi.Type;


// WARNING! conflicting data type names: /golang-recovered/[]runtime.functab - /DWARF/_UNCATEGORIZED_/[]runtime.functab


// WARNING! conflicting data type names: /golang-recovered/runtime\/internal\/atomic/runtime/internal/atomic.Uint64 - /DWARF/_UNCATEGORIZED_/runtime/internal/atomic.Uint64


// WARNING! conflicting data type names: /golang-recovered/runtime\/internal\/atomic/runtime/internal/atomic.Int64 - /DWARF/_UNCATEGORIZED_/runtime/internal/atomic.Int64


// WARNING! conflicting data type names: /golang-recovered/runtime\/internal\/atomic/runtime/internal/atomic.UnsafePointer - /DWARF/_UNCATEGORIZED_/runtime/internal/atomic.UnsafePointer


// WARNING! conflicting data type names: /golang-recovered/runtime\/internal\/atomic/runtime/internal/atomic.Uint8 - /DWARF/_UNCATEGORIZED_/runtime/internal/atomic.Uint8


// WARNING! conflicting data type names: /golang-recovered/runtime\/internal\/atomic/runtime/internal/atomic.Bool - /DWARF/_UNCATEGORIZED_/runtime/internal/atomic.Bool


// WARNING! conflicting data type names: /golang-recovered/runtime\/internal\/atomic/runtime/internal/atomic.align64 - /DWARF/_UNCATEGORIZED_/runtime/internal/atomic.align64


// WARNING! conflicting data type names: /golang-recovered/runtime\/internal\/atomic/runtime/internal/atomic.noCopy - /DWARF/_UNCATEGORIZED_/runtime/internal/atomic.noCopy


// WARNING! conflicting data type names: /golang-recovered/runtime\/internal\/atomic/runtime/internal/atomic.Pointer[runtime._defer] - /DWARF/_UNCATEGORIZED_/runtime/internal/atomic.Pointer[runtime._defer]


// WARNING! conflicting data type names: /golang-recovered/runtime\/internal\/atomic/runtime/internal/atomic.Uintptr - /DWARF/_UNCATEGORIZED_/runtime/internal/atomic.Uintptr


// WARNING! conflicting data type names: /golang-recovered/internal\/unsafeheader/internal/unsafeheader.Slice - /DWARF/_UNCATEGORIZED_/internal/unsafeheader.Slice


// WARNING! conflicting data type names: /golang-recovered/fmt/fmt.buffer - /DWARF/_UNCATEGORIZED_/fmt.buffer


// WARNING! conflicting data type names: /golang-recovered/fmt/fmt.fmt - /DWARF/_UNCATEGORIZED_/fmt.fmt

typedef struct runtime.iface fmt.ScanState;


// WARNING! conflicting data type names: /golang-recovered/fmt/fmt.ss - /DWARF/_UNCATEGORIZED_/fmt.ss


// WARNING! conflicting data type names: /golang-recovered/fmt/fmt.pp - /DWARF/_UNCATEGORIZED_/fmt.pp

typedef struct runtime.iface fmt.State;


// WARNING! conflicting data type names: /golang-recovered/reflect/reflect.abiSeq - /DWARF/_UNCATEGORIZED_/reflect.abiSeq


// WARNING! conflicting data type names: /golang-recovered/reflect/reflect.makeFuncCtxt - /DWARF/_UNCATEGORIZED_/reflect.makeFuncCtxt


// WARNING! conflicting data type names: /golang-recovered/reflect/reflect.Value - /DWARF/_UNCATEGORIZED_/reflect.Value


// WARNING! conflicting data type names: /golang-recovered/reflect/reflect.layoutKey - /DWARF/_UNCATEGORIZED_/reflect.layoutKey


// WARNING! conflicting data type names: /golang-recovered/reflect/reflect.layoutType - /DWARF/_UNCATEGORIZED_/reflect.layoutType


// WARNING! conflicting data type names: /golang-recovered/reflect/reflect.methodValue - /DWARF/_UNCATEGORIZED_/reflect.methodValue


// WARNING! conflicting data type names: /golang-recovered/reflect/reflect.abiDesc - /DWARF/_UNCATEGORIZED_/reflect.abiDesc


// WARNING! conflicting data type names: /golang-recovered/reflect/reflect.rtype - /DWARF/_UNCATEGORIZED_/reflect.rtype


// WARNING! conflicting data type names: /golang-recovered/reflect/reflect.bitVector - /DWARF/_UNCATEGORIZED_/reflect.bitVector


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.goroutineProfileStateHolder - /DWARF/_UNCATEGORIZED_/runtime.goroutineProfileStateHolder


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.mutex - /DWARF/_UNCATEGORIZED_/runtime.mutex


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.coro - /DWARF/_UNCATEGORIZED_/runtime.coro


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.pcHeader - /DWARF/_UNCATEGORIZED_/runtime.pcHeader

typedef struct struct { runtime.gList; n int32 } struct { runtime.gList; n int32 }, *Pstruct { runtime.gList; n int32 };

struct struct { runtime.gList; n int32 } {
    struct runtime.gList gList;
    int32 n;
};

typedef struct string runtime.stringInterfacePtr;


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.pollDesc - /DWARF/_UNCATEGORIZED_/runtime.pollDesc


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.moduledata - /DWARF/_UNCATEGORIZED_/runtime.moduledata


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.pinner - /DWARF/_UNCATEGORIZED_/runtime.pinner


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.pageTraceBuf - /DWARF/_UNCATEGORIZED_/runtime.pageTraceBuf


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.traceSchedResourceState - /DWARF/_UNCATEGORIZED_/runtime.traceSchedResourceState


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime._panic - /DWARF/_UNCATEGORIZED_/runtime._panic


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.TypeAssertionError - /DWARF/_UNCATEGORIZED_/runtime.TypeAssertionError


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.gcBits - /DWARF/_UNCATEGORIZED_/runtime.gcBits


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.gobuf - /DWARF/_UNCATEGORIZED_/runtime.gobuf


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.itab - /DWARF/_UNCATEGORIZED_/runtime.itab


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime._defer - /DWARF/_UNCATEGORIZED_/runtime._defer


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.p - /DWARF/_UNCATEGORIZED_/runtime.p


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.m - /DWARF/_UNCATEGORIZED_/runtime.m


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.g - /DWARF/_UNCATEGORIZED_/runtime.g

typedef struct runtime.sliceInterfacePtr runtime.sliceInterfacePtr, *Pruntime.sliceInterfacePtr;

struct runtime.sliceInterfacePtr {
    uint8 *array;
    int len;
    int cap;
};


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.mspan - /DWARF/_UNCATEGORIZED_/runtime.mspan


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.mSpanStateBox - /DWARF/_UNCATEGORIZED_/runtime.mSpanStateBox


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.bitvector - /DWARF/_UNCATEGORIZED_/runtime.bitvector


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.mLockProfile - /DWARF/_UNCATEGORIZED_/runtime.mLockProfile


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.special - /DWARF/_UNCATEGORIZED_/runtime.special


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.waitq - /DWARF/_UNCATEGORIZED_/runtime.waitq


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.mcache - /DWARF/_UNCATEGORIZED_/runtime.mcache


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.debugCallWrapArgs - /DWARF/_UNCATEGORIZED_/runtime.debugCallWrapArgs


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.funcInfo - /DWARF/_UNCATEGORIZED_/runtime.funcInfo


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.timer - /DWARF/_UNCATEGORIZED_/runtime.timer


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.sigset - /DWARF/_UNCATEGORIZED_/runtime.sigset


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.ancestorInfo - /DWARF/_UNCATEGORIZED_/runtime.ancestorInfo


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime._func - /DWARF/_UNCATEGORIZED_/runtime._func


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.Frames - /DWARF/_UNCATEGORIZED_/runtime.Frames


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.gsignalStack - /DWARF/_UNCATEGORIZED_/runtime.gsignalStack


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.mTraceState - /DWARF/_UNCATEGORIZED_/runtime.mTraceState

typedef struct struct { len int; buf [128]*runtime.mspan } struct { len int; buf [128]*runtime.mspan }, *Pstruct { len int; buf [128]*runtime.mspan };

struct struct { len int; buf [128]*runtime.mspan } {
    int len;
    struct runtime.mspan *buf[128];
};


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.workbuf - /DWARF/_UNCATEGORIZED_/runtime.workbuf


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.mOS - /DWARF/_UNCATEGORIZED_/runtime.mOS

typedef dword runtime.uint32InterfacePtr;


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.Frame - /DWARF/_UNCATEGORIZED_/runtime.Frame


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.limiterEvent - /DWARF/_UNCATEGORIZED_/runtime.limiterEvent


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.pTraceState - /DWARF/_UNCATEGORIZED_/runtime.pTraceState


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.sudog - /DWARF/_UNCATEGORIZED_/runtime.sudog


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.abiDesc - /DWARF/_UNCATEGORIZED_/runtime.abiDesc

typedef qword runtime.uint64InterfacePtr;


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.winCallback - /DWARF/_UNCATEGORIZED_/runtime.winCallback


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.gTraceState - /DWARF/_UNCATEGORIZED_/runtime.gTraceState

typedef word runtime.uint16InterfacePtr;


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.lockRankStruct - /DWARF/_UNCATEGORIZED_/runtime.lockRankStruct


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.mSpanList - /DWARF/_UNCATEGORIZED_/runtime.mSpanList


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.dlogPerM - /DWARF/_UNCATEGORIZED_/runtime.dlogPerM


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.gcWork - /DWARF/_UNCATEGORIZED_/runtime.gcWork


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.persistentAlloc - /DWARF/_UNCATEGORIZED_/runtime.persistentAlloc


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.notInHeap - /DWARF/_UNCATEGORIZED_/runtime.notInHeap


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.scavengerState - /DWARF/_UNCATEGORIZED_/runtime.scavengerState


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.traceBufHeader - /DWARF/_UNCATEGORIZED_/runtime.traceBufHeader


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.mapextra - /DWARF/_UNCATEGORIZED_/runtime.mapextra


// WARNING! conflicting data type names: /golang-recovered/runtime/runtime.Func - /DWARF/_UNCATEGORIZED_/runtime.Func


// WARNING! conflicting data type names: /golang-recovered/sync/sync.poolDequeue - /DWARF/_UNCATEGORIZED_/sync.poolDequeue


// WARNING! conflicting data type names: /golang-recovered/sync/sync.poolChainElt - /DWARF/_UNCATEGORIZED_/sync.poolChainElt


// WARNING! conflicting data type names: /golang-recovered/sync/sync.poolLocal - /DWARF/_UNCATEGORIZED_/sync.poolLocal


// WARNING! conflicting data type names: /golang-recovered/sync/sync.poolChain - /DWARF/_UNCATEGORIZED_/sync.poolChain


// WARNING! conflicting data type names: /golang-recovered/sync/sync.Pool - /DWARF/_UNCATEGORIZED_/sync.Pool


// WARNING! conflicting data type names: /golang-recovered/sync/sync.readOnly - /DWARF/_UNCATEGORIZED_/sync.readOnly


// WARNING! conflicting data type names: /golang-recovered/sync/sync.eface - /DWARF/_UNCATEGORIZED_/sync.eface


// WARNING! conflicting data type names: /golang-recovered/sync/sync.noCopy - /DWARF/_UNCATEGORIZED_/sync.noCopy


// WARNING! conflicting data type names: /golang-recovered/sync/sync.poolLocalInternal - /DWARF/_UNCATEGORIZED_/sync.poolLocalInternal


// WARNING! conflicting data type names: /golang-recovered/internal\/abi/internal/abi.FuncType - /DWARF/_UNCATEGORIZED_/internal/abi.FuncType


// WARNING! conflicting data type names: /golang-recovered/internal\/abi/internal/abi.RegArgs - /DWARF/_UNCATEGORIZED_/internal/abi.RegArgs


// WARNING! conflicting data type names: /golang-recovered/internal\/abi/internal/abi.InterfaceType - /DWARF/_UNCATEGORIZED_/internal/abi.InterfaceType


// WARNING! conflicting data type names: /golang-recovered/internal\/abi/internal/abi.Name - /DWARF/_UNCATEGORIZED_/internal/abi.Name


// WARNING! conflicting data type names: /golang-recovered/runtime\/internal\/sys/runtime/internal/sys.nih - /DWARF/_UNCATEGORIZED_/runtime/internal/sys.nih


// WARNING! conflicting data type names: /golang-recovered/runtime\/internal\/sys/runtime/internal/sys.NotInHeap - /DWARF/_UNCATEGORIZED_/runtime/internal/sys.NotInHeap


// WARNING! conflicting data type names: /golang-recovered/syscall/syscall.LazyDLL - /DWARF/_UNCATEGORIZED_/syscall.LazyDLL


// WARNING! conflicting data type names: /golang-recovered/syscall/syscall.Proc - /DWARF/_UNCATEGORIZED_/syscall.Proc


// WARNING! conflicting data type names: /golang-recovered/syscall/syscall.WSABuf - /DWARF/_UNCATEGORIZED_/syscall.WSABuf


// WARNING! conflicting data type names: /golang-recovered/sync\/atomic/sync/atomic.Uint32 - /DWARF/_UNCATEGORIZED_/sync/atomic.Uint32


// WARNING! conflicting data type names: /golang-recovered/sync\/atomic/sync/atomic.Uint64 - /DWARF/_UNCATEGORIZED_/sync/atomic.Uint64

typedef struct sync/atomic.Pointer[interface {}] sync/atomic.Pointer[interface {}], *Psync/atomic.Pointer[interface {}];

struct sync/atomic.Pointer[interface {}] {
    unsafe.Pointer v; // Omitted zero-len field: _=[0]*interface {}
Omitted zero-len field: _=atomic.noCopy
};


// WARNING! conflicting data type names: /golang-recovered/sync\/atomic/sync/atomic.align64 - /DWARF/_UNCATEGORIZED_/sync/atomic.align64


// WARNING! conflicting data type names: /golang-recovered/sync\/atomic/sync/atomic.noCopy - /DWARF/_UNCATEGORIZED_/sync/atomic.noCopy


// WARNING! conflicting data type names: /golang-recovered/internal\/fmtsort/internal/fmtsort.SortedMap - /DWARF/_UNCATEGORIZED_/internal/fmtsort.SortedMap


// WARNING! conflicting data type names: /golang-recovered/internal\/reflectlite/internal/reflectlite.rtype - /DWARF/_UNCATEGORIZED_/internal/reflectlite.rtype

typedef struct runtime.iface math/rand/rand.Source;

typedef struct math/rand/rand.runtimeSource math/rand/rand.runtimeSource, *Pmath/rand/rand.runtimeSource;

struct math/rand/rand.runtimeSource {
};


// WARNING! conflicting data type names: /golang-recovered/os/os.dirInfo - /DWARF/_UNCATEGORIZED_/os.dirInfo


// WARNING! conflicting data type names: /golang-recovered/os/os.file - /DWARF/_UNCATEGORIZED_/os.file


// WARNING! conflicting data type names: /golang-recovered/os/os.File - /DWARF/_UNCATEGORIZED_/os.File


// WARNING! conflicting data type names: /golang-recovered/internal\/poll/internal/poll.FD - /DWARF/_UNCATEGORIZED_/internal/poll.FD


// WARNING! conflicting data type names: /golang-recovered/internal\/poll/internal/poll.errNetClosing - /DWARF/_UNCATEGORIZED_/internal/poll.errNetClosing


// WARNING! conflicting data type names: /golang-recovered/internal\/poll/internal/poll.operation - /DWARF/_UNCATEGORIZED_/internal/poll.operation


// WARNING! conflicting data type names: /golang-recovered/internal\/poll/internal/poll.DeadlineExceededError - /DWARF/_UNCATEGORIZED_/internal/poll.DeadlineExceededError


// WARNING! conflicting data type names: /golang-recovered/internal\/syscall\/windows/internal/syscall/windows.WSAMsg - /DWARF/_UNCATEGORIZED_/internal/syscall/windows.WSAMsg

typedef ulong ULONG;

typedef INT_PTR (*FARPROC)(void);

typedef HANDLE *LPHANDLE;

typedef DWORD *LPDWORD;

typedef int HFILE;

typedef struct HINSTANCE__ HINSTANCE__, *PHINSTANCE__;

struct HINSTANCE__ {
    int unused;
};

typedef DWORD *PDWORD;

typedef ULONG *PULONG;

typedef struct HINSTANCE__ *HINSTANCE;

typedef uchar UCHAR;

typedef void *LPCVOID;

typedef HINSTANCE HMODULE;

typedef uint UINT;

typedef struct IMAGE_OPTIONAL_HEADER64 IMAGE_OPTIONAL_HEADER64, *PIMAGE_OPTIONAL_HEADER64;

typedef struct IMAGE_DATA_DIRECTORY IMAGE_DATA_DIRECTORY, *PIMAGE_DATA_DIRECTORY;

struct IMAGE_DATA_DIRECTORY {
    ImageBaseOffset32 VirtualAddress;
    dword Size;
};

struct IMAGE_OPTIONAL_HEADER64 {
    word Magic;
    byte MajorLinkerVersion;
    byte MinorLinkerVersion;
    dword SizeOfCode;
    dword SizeOfInitializedData;
    dword SizeOfUninitializedData;
    ImageBaseOffset32 AddressOfEntryPoint;
    ImageBaseOffset32 BaseOfCode;
    pointer64 ImageBase;
    dword SectionAlignment;
    dword FileAlignment;
    word MajorOperatingSystemVersion;
    word MinorOperatingSystemVersion;
    word MajorImageVersion;
    word MinorImageVersion;
    word MajorSubsystemVersion;
    word MinorSubsystemVersion;
    dword Win32VersionValue;
    dword SizeOfImage;
    dword SizeOfHeaders;
    dword CheckSum;
    word Subsystem;
    word DllCharacteristics;
    qword SizeOfStackReserve;
    qword SizeOfStackCommit;
    qword SizeOfHeapReserve;
    qword SizeOfHeapCommit;
    dword LoaderFlags;
    dword NumberOfRvaAndSizes;
    struct IMAGE_DATA_DIRECTORY DataDirectory[16];
};

typedef struct IMAGE_SECTION_HEADER IMAGE_SECTION_HEADER, *PIMAGE_SECTION_HEADER;

typedef union Misc Misc, *PMisc;

typedef enum SectionFlags {
    IMAGE_SCN_TYPE_NO_PAD=8,
    IMAGE_SCN_RESERVED_0001=16,
    IMAGE_SCN_CNT_CODE=32,
    IMAGE_SCN_CNT_INITIALIZED_DATA=64,
    IMAGE_SCN_CNT_UNINITIALIZED_DATA=128,
    IMAGE_SCN_LNK_OTHER=256,
    IMAGE_SCN_LNK_INFO=512,
    IMAGE_SCN_RESERVED_0040=1024,
    IMAGE_SCN_LNK_REMOVE=2048,
    IMAGE_SCN_LNK_COMDAT=4096,
    IMAGE_SCN_GPREL=32768,
    IMAGE_SCN_MEM_16BIT=131072,
    IMAGE_SCN_MEM_PURGEABLE=131072,
    IMAGE_SCN_MEM_LOCKED=262144,
    IMAGE_SCN_MEM_PRELOAD=524288,
    IMAGE_SCN_ALIGN_1BYTES=1048576,
    IMAGE_SCN_ALIGN_2BYTES=2097152,
    IMAGE_SCN_ALIGN_4BYTES=3145728,
    IMAGE_SCN_ALIGN_8BYTES=4194304,
    IMAGE_SCN_ALIGN_16BYTES=5242880,
    IMAGE_SCN_ALIGN_32BYTES=6291456,
    IMAGE_SCN_ALIGN_64BYTES=7340032,
    IMAGE_SCN_ALIGN_128BYTES=8388608,
    IMAGE_SCN_ALIGN_256BYTES=9437184,
    IMAGE_SCN_ALIGN_512BYTES=10485760,
    IMAGE_SCN_ALIGN_1024BYTES=11534336,
    IMAGE_SCN_ALIGN_2048BYTES=12582912,
    IMAGE_SCN_ALIGN_4096BYTES=13631488,
    IMAGE_SCN_ALIGN_8192BYTES=14680064,
    IMAGE_SCN_LNK_NRELOC_OVFL=16777216,
    IMAGE_SCN_MEM_DISCARDABLE=33554432,
    IMAGE_SCN_MEM_NOT_CACHED=67108864,
    IMAGE_SCN_MEM_NOT_PAGED=134217728,
    IMAGE_SCN_MEM_SHARED=268435456,
    IMAGE_SCN_MEM_EXECUTE=536870912,
    IMAGE_SCN_MEM_READ=1073741824,
    IMAGE_SCN_MEM_WRITE=2147483648
} SectionFlags;

union Misc {
    dword PhysicalAddress;
    dword VirtualSize;
};

struct IMAGE_SECTION_HEADER {
    char Name[8];
    union Misc Misc;
    ImageBaseOffset32 VirtualAddress;
    dword SizeOfRawData;
    dword PointerToRawData;
    dword PointerToRelocations;
    dword PointerToLinenumbers;
    word NumberOfRelocations;
    word NumberOfLinenumbers;
    enum SectionFlags Characteristics;
};

typedef struct IMAGE_NT_HEADERS64 IMAGE_NT_HEADERS64, *PIMAGE_NT_HEADERS64;

typedef struct IMAGE_FILE_HEADER IMAGE_FILE_HEADER, *PIMAGE_FILE_HEADER;

struct IMAGE_FILE_HEADER {
    word Machine; // 34404
    word NumberOfSections;
    dword TimeDateStamp;
    dword PointerToSymbolTable;
    dword NumberOfSymbols;
    word SizeOfOptionalHeader;
    word Characteristics;
};

struct IMAGE_NT_HEADERS64 {
    char Signature[4];
    struct IMAGE_FILE_HEADER FileHeader;
    struct IMAGE_OPTIONAL_HEADER64 OptionalHeader;
};

typedef struct WSAData WSAData, *PWSAData;

typedef struct WSAData WSADATA;

struct WSAData {
    WORD wVersion;
    WORD wHighVersion;
    ushort iMaxSockets;
    ushort iMaxUdpDg;
    char *lpVendorInfo;
    char szDescription[257];
    char szSystemStatus[129];
};

typedef WSADATA *LPWSADATA;

typedef UINT_PTR SOCKET;




// Golang function info: {@address 0055aa50 "Flags: [ASM], ID: NORMAL"}
// Golang source: C:/Program Files/Go/src/runtime/asm_amd64.s:1230

uint aeshashbody(undefined (*param_1) [16],undefined8 param_2,uint param_3)

{
  uint uVar1;
  undefined auVar2 [16];
  undefined auVar3 [16];
  undefined auVar4 [16];
  undefined auVar5 [16];
  undefined auVar6 [16];
  undefined auVar7 [16];
  undefined auVar8 [16];
  undefined auVar9 [16];
  undefined auVar10 [16];
  
  auVar2._8_8_ = param_3 & 0xffff;
  auVar2._0_8_ = param_2;
  auVar2 = pshufhw(auVar2,auVar2,0);
  auVar3 = aesenc(auVar2 ^ runtime_aeskeysched._0_16_,auVar2 ^ runtime_aeskeysched._0_16_);
  if (param_3 < 0x10) {
    if (param_3 == 0) {
      auVar2 = aesenc(auVar3,auVar3);
      return auVar2._0_8_;
    }
    if (((uint)(param_1 + 1) & 0xff0) == 0) {
      auVar2 = pshufb(*(undefined (*) [16])(param_1[-1] + param_3),
                      *(undefined (*) [16])(&shifts + param_3 * 0x10));
    }
    else {
      auVar2 = *param_1 & *(undefined (*) [16])(&masks + param_3 * 0x10);
    }
  }
  else {
    if (param_3 != 0x10) {
      if (param_3 < 0x21) {
        auVar2 = aesenc(auVar2 ^ runtime_aeskeysched._16_16_,auVar2 ^ runtime_aeskeysched._16_16_);
        auVar2 = *(undefined (*) [16])(param_1[-1] + param_3) ^ auVar2;
        auVar3 = aesenc(*param_1 ^ auVar3,*param_1 ^ auVar3);
        auVar4 = aesenc(auVar2,auVar2);
        auVar2 = aesenc(auVar3,auVar3);
        auVar3 = aesenc(auVar4,auVar4);
        auVar2 = aesenc(auVar2,auVar2);
        auVar3 = aesenc(auVar3,auVar3);
        return auVar2._0_8_ ^ auVar3._0_8_;
      }
      if (0x40 < param_3) {
        if (0x80 < param_3) {
          auVar4 = aesenc(auVar2 ^ runtime_aeskeysched._16_16_,auVar2 ^ runtime_aeskeysched._16_16_)
          ;
          auVar5 = aesenc(auVar2 ^ runtime_aeskeysched._32_16_,auVar2 ^ runtime_aeskeysched._32_16_)
          ;
          auVar6 = aesenc(auVar2 ^ runtime_aeskeysched._48_16_,auVar2 ^ runtime_aeskeysched._48_16_)
          ;
          auVar7 = aesenc(auVar2 ^ runtime_aeskeysched._64_16_,auVar2 ^ runtime_aeskeysched._64_16_)
          ;
          auVar8 = aesenc(auVar2 ^ runtime_aeskeysched._80_16_,auVar2 ^ runtime_aeskeysched._80_16_)
          ;
          auVar9 = aesenc(auVar2 ^ runtime_aeskeysched._96_16_,auVar2 ^ runtime_aeskeysched._96_16_)
          ;
          auVar2 = aesenc(auVar2 ^ runtime_aeskeysched._112_16_,
                          auVar2 ^ runtime_aeskeysched._112_16_);
          auVar3 = *(undefined (*) [16])(param_1[-8] + param_3) ^ auVar3;
          auVar4 = *(undefined (*) [16])(param_1[-7] + param_3) ^ auVar4;
          auVar5 = *(undefined (*) [16])(param_1[-6] + param_3) ^ auVar5;
          auVar6 = *(undefined (*) [16])(param_1[-5] + param_3) ^ auVar6;
          auVar7 = *(undefined (*) [16])(param_1[-4] + param_3) ^ auVar7;
          auVar8 = *(undefined (*) [16])(param_1[-3] + param_3) ^ auVar8;
          auVar9 = *(undefined (*) [16])(param_1[-2] + param_3) ^ auVar9;
          auVar2 = *(undefined (*) [16])(param_1[-1] + param_3) ^ auVar2;
          uVar1 = param_3 - 1 >> 7;
          do {
            auVar3 = aesenc(auVar3,auVar3);
            auVar4 = aesenc(auVar4,auVar4);
            auVar5 = aesenc(auVar5,auVar5);
            auVar6 = aesenc(auVar6,auVar6);
            auVar7 = aesenc(auVar7,auVar7);
            auVar8 = aesenc(auVar8,auVar8);
            auVar9 = aesenc(auVar9,auVar9);
            auVar2 = aesenc(auVar2,auVar2);
            auVar3 = aesenc(auVar3,*param_1);
            auVar4 = aesenc(auVar4,param_1[1]);
            auVar5 = aesenc(auVar5,param_1[2]);
            auVar6 = aesenc(auVar6,param_1[3]);
            auVar7 = aesenc(auVar7,param_1[4]);
            auVar8 = aesenc(auVar8,param_1[5]);
            auVar9 = aesenc(auVar9,param_1[6]);
            auVar2 = aesenc(auVar2,param_1[7]);
            param_1 = param_1 + 8;
            uVar1 = uVar1 - 1;
          } while (uVar1 != 0);
          auVar3 = aesenc(auVar3,auVar3);
          auVar4 = aesenc(auVar4,auVar4);
          auVar5 = aesenc(auVar5,auVar5);
          auVar6 = aesenc(auVar6,auVar6);
          auVar7 = aesenc(auVar7,auVar7);
          auVar8 = aesenc(auVar8,auVar8);
          auVar9 = aesenc(auVar9,auVar9);
          auVar10 = aesenc(auVar2,auVar2);
          auVar2 = aesenc(auVar3,auVar3);
          auVar3 = aesenc(auVar4,auVar4);
          auVar4 = aesenc(auVar5,auVar5);
          auVar5 = aesenc(auVar6,auVar6);
          auVar6 = aesenc(auVar7,auVar7);
          auVar7 = aesenc(auVar8,auVar8);
          auVar8 = aesenc(auVar9,auVar9);
          auVar9 = aesenc(auVar10,auVar10);
          auVar2 = aesenc(auVar2,auVar2);
          auVar3 = aesenc(auVar3,auVar3);
          auVar4 = aesenc(auVar4,auVar4);
          auVar5 = aesenc(auVar5,auVar5);
          auVar6 = aesenc(auVar6,auVar6);
          auVar7 = aesenc(auVar7,auVar7);
          auVar8 = aesenc(auVar8,auVar8);
          auVar9 = aesenc(auVar9,auVar9);
          return auVar2._0_8_ ^ auVar6._0_8_ ^ auVar4._0_8_ ^ auVar8._0_8_ ^
                 auVar3._0_8_ ^ auVar7._0_8_ ^ auVar5._0_8_ ^ auVar9._0_8_;
        }
        auVar4 = aesenc(auVar2 ^ runtime_aeskeysched._16_16_,auVar2 ^ runtime_aeskeysched._16_16_);
        auVar5 = aesenc(auVar2 ^ runtime_aeskeysched._32_16_,auVar2 ^ runtime_aeskeysched._32_16_);
        auVar6 = aesenc(auVar2 ^ runtime_aeskeysched._48_16_,auVar2 ^ runtime_aeskeysched._48_16_);
        auVar7 = aesenc(auVar2 ^ runtime_aeskeysched._64_16_,auVar2 ^ runtime_aeskeysched._64_16_);
        auVar8 = aesenc(auVar2 ^ runtime_aeskeysched._80_16_,auVar2 ^ runtime_aeskeysched._80_16_);
        auVar9 = aesenc(auVar2 ^ runtime_aeskeysched._96_16_,auVar2 ^ runtime_aeskeysched._96_16_);
        auVar2 = aesenc(auVar2 ^ runtime_aeskeysched._112_16_,auVar2 ^ runtime_aeskeysched._112_16_)
        ;
        auVar7 = *(undefined (*) [16])(param_1[-4] + param_3) ^ auVar7;
        auVar8 = *(undefined (*) [16])(param_1[-3] + param_3) ^ auVar8;
        auVar9 = *(undefined (*) [16])(param_1[-2] + param_3) ^ auVar9;
        auVar2 = *(undefined (*) [16])(param_1[-1] + param_3) ^ auVar2;
        auVar3 = aesenc(*param_1 ^ auVar3,*param_1 ^ auVar3);
        auVar4 = aesenc(param_1[1] ^ auVar4,param_1[1] ^ auVar4);
        auVar5 = aesenc(param_1[2] ^ auVar5,param_1[2] ^ auVar5);
        auVar6 = aesenc(param_1[3] ^ auVar6,param_1[3] ^ auVar6);
        auVar7 = aesenc(auVar7,auVar7);
        auVar8 = aesenc(auVar8,auVar8);
        auVar9 = aesenc(auVar9,auVar9);
        auVar10 = aesenc(auVar2,auVar2);
        auVar2 = aesenc(auVar3,auVar3);
        auVar3 = aesenc(auVar4,auVar4);
        auVar4 = aesenc(auVar5,auVar5);
        auVar5 = aesenc(auVar6,auVar6);
        auVar6 = aesenc(auVar7,auVar7);
        auVar7 = aesenc(auVar8,auVar8);
        auVar8 = aesenc(auVar9,auVar9);
        auVar9 = aesenc(auVar10,auVar10);
        auVar2 = aesenc(auVar2,auVar2);
        auVar3 = aesenc(auVar3,auVar3);
        auVar4 = aesenc(auVar4,auVar4);
        auVar5 = aesenc(auVar5,auVar5);
        auVar6 = aesenc(auVar6,auVar6);
        auVar7 = aesenc(auVar7,auVar7);
        auVar8 = aesenc(auVar8,auVar8);
        auVar9 = aesenc(auVar9,auVar9);
        return auVar2._0_8_ ^ auVar6._0_8_ ^ auVar4._0_8_ ^ auVar8._0_8_ ^
               auVar3._0_8_ ^ auVar7._0_8_ ^ auVar5._0_8_ ^ auVar9._0_8_;
      }
      auVar4 = aesenc(auVar2 ^ runtime_aeskeysched._16_16_,auVar2 ^ runtime_aeskeysched._16_16_);
      auVar5 = aesenc(auVar2 ^ runtime_aeskeysched._32_16_,auVar2 ^ runtime_aeskeysched._32_16_);
      auVar2 = aesenc(auVar2 ^ runtime_aeskeysched._48_16_,auVar2 ^ runtime_aeskeysched._48_16_);
      auVar5 = *(undefined (*) [16])(param_1[-2] + param_3) ^ auVar5;
      auVar2 = *(undefined (*) [16])(param_1[-1] + param_3) ^ auVar2;
      auVar3 = aesenc(*param_1 ^ auVar3,*param_1 ^ auVar3);
      auVar4 = aesenc(param_1[1] ^ auVar4,param_1[1] ^ auVar4);
      auVar5 = aesenc(auVar5,auVar5);
      auVar6 = aesenc(auVar2,auVar2);
      auVar2 = aesenc(auVar3,auVar3);
      auVar3 = aesenc(auVar4,auVar4);
      auVar4 = aesenc(auVar5,auVar5);
      auVar5 = aesenc(auVar6,auVar6);
      auVar2 = aesenc(auVar2,auVar2);
      auVar3 = aesenc(auVar3,auVar3);
      auVar4 = aesenc(auVar4,auVar4);
      auVar5 = aesenc(auVar5,auVar5);
      return auVar2._0_8_ ^ auVar4._0_8_ ^ auVar3._0_8_ ^ auVar5._0_8_;
    }
    auVar2 = *param_1;
  }
  auVar2 = aesenc(auVar2 ^ auVar3,auVar2 ^ auVar3);
  auVar2 = aesenc(auVar2,auVar2);
  auVar2 = aesenc(auVar2,auVar2);
  return auVar2._0_8_;
}


