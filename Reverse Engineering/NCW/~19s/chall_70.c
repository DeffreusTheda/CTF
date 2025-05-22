typedef unsigned char   undefined;

typedef unsigned char    byte;
typedef unsigned char    dwfenc;
typedef unsigned int    dword;
typedef long double    longdouble;
typedef long long    longlong;
typedef unsigned long    qword;
typedef unsigned char    uchar;
typedef unsigned int    uint;
typedef unsigned long    ulong;
typedef unsigned long long    ulonglong;
typedef unsigned char    undefined1;
typedef unsigned int    undefined4;
typedef unsigned long    undefined8;
typedef unsigned short    ushort;
typedef unsigned short    word;
typedef struct eh_frame_hdr eh_frame_hdr, *Peh_frame_hdr;

struct eh_frame_hdr {
    byte eh_frame_hdr_version; // Exception Handler Frame Header Version
    dwfenc eh_frame_pointer_encoding; // Exception Handler Frame Pointer Encoding
    dwfenc eh_frame_desc_entry_count_encoding; // Encoding of # of Exception Handler FDEs
    dwfenc eh_frame_table_encoding; // Exception Handler Table Encoding
};

typedef struct NoteGnuPropertyElement_4 NoteGnuPropertyElement_4, *PNoteGnuPropertyElement_4;

struct NoteGnuPropertyElement_4 {
    dword prType;
    dword prDatasz;
    byte data[4];
};

typedef struct fde_table_entry fde_table_entry, *Pfde_table_entry;

struct fde_table_entry {
    dword initial_loc; // Initial Location
    dword data_loc; // Data location
};

typedef struct C_ptable_entry_struct C_ptable_entry_struct, *PC_ptable_entry_struct;

typedef struct C_ptable_entry_struct C_PTABLE_ENTRY;

struct C_ptable_entry_struct {
    char *id;
    void *ptr;
};

typedef struct C_block_struct C_block_struct, *PC_block_struct;

typedef struct C_block_struct C_SCHEME_BLOCK;

struct C_block_struct {
    ulong header;
    long data[0];
};

typedef void (*C_proc)(long, long *);

typedef struct evp_pkey_ctx_st evp_pkey_ctx_st, *Pevp_pkey_ctx_st;

typedef struct evp_pkey_ctx_st EVP_PKEY_CTX;

struct evp_pkey_ctx_st {
};

typedef enum Elf_ProgramHeaderType {
    PT_NULL=0,
    PT_LOAD=1,
    PT_DYNAMIC=2,
    PT_INTERP=3,
    PT_NOTE=4,
    PT_SHLIB=5,
    PT_PHDR=6,
    PT_TLS=7,
    PT_GNU_EH_FRAME=1685382480,
    PT_GNU_STACK=1685382481,
    PT_GNU_RELRO=1685382482
} Elf_ProgramHeaderType;

typedef struct Elf64_Shdr Elf64_Shdr, *PElf64_Shdr;

typedef enum Elf_SectionHeaderType {
    SHT_NULL=0,
    SHT_PROGBITS=1,
    SHT_SYMTAB=2,
    SHT_STRTAB=3,
    SHT_RELA=4,
    SHT_HASH=5,
    SHT_DYNAMIC=6,
    SHT_NOTE=7,
    SHT_NOBITS=8,
    SHT_REL=9,
    SHT_SHLIB=10,
    SHT_DYNSYM=11,
    SHT_INIT_ARRAY=14,
    SHT_FINI_ARRAY=15,
    SHT_PREINIT_ARRAY=16,
    SHT_GROUP=17,
    SHT_SYMTAB_SHNDX=18,
    SHT_ANDROID_REL=1610612737,
    SHT_ANDROID_RELA=1610612738,
    SHT_GNU_ATTRIBUTES=1879048181,
    SHT_GNU_HASH=1879048182,
    SHT_GNU_LIBLIST=1879048183,
    SHT_CHECKSUM=1879048184,
    SHT_SUNW_move=1879048186,
    SHT_SUNW_COMDAT=1879048187,
    SHT_SUNW_syminfo=1879048188,
    SHT_GNU_verdef=1879048189,
    SHT_GNU_verneed=1879048190,
    SHT_GNU_versym=1879048191
} Elf_SectionHeaderType;

struct Elf64_Shdr {
    dword sh_name;
    enum Elf_SectionHeaderType sh_type;
    qword sh_flags;
    qword sh_addr;
    qword sh_offset;
    qword sh_size;
    dword sh_link;
    dword sh_info;
    qword sh_addralign;
    qword sh_entsize;
};

typedef struct Elf64_Dyn Elf64_Dyn, *PElf64_Dyn;

typedef enum Elf64_DynTag {
    DT_NULL=0,
    DT_NEEDED=1,
    DT_PLTRELSZ=2,
    DT_PLTGOT=3,
    DT_HASH=4,
    DT_STRTAB=5,
    DT_SYMTAB=6,
    DT_RELA=7,
    DT_RELASZ=8,
    DT_RELAENT=9,
    DT_STRSZ=10,
    DT_SYMENT=11,
    DT_INIT=12,
    DT_FINI=13,
    DT_SONAME=14,
    DT_RPATH=15,
    DT_SYMBOLIC=16,
    DT_REL=17,
    DT_RELSZ=18,
    DT_RELENT=19,
    DT_PLTREL=20,
    DT_DEBUG=21,
    DT_TEXTREL=22,
    DT_JMPREL=23,
    DT_BIND_NOW=24,
    DT_INIT_ARRAY=25,
    DT_FINI_ARRAY=26,
    DT_INIT_ARRAYSZ=27,
    DT_FINI_ARRAYSZ=28,
    DT_RUNPATH=29,
    DT_FLAGS=30,
    DT_PREINIT_ARRAY=32,
    DT_PREINIT_ARRAYSZ=33,
    DT_RELRSZ=35,
    DT_RELR=36,
    DT_RELRENT=37,
    DT_ANDROID_REL=1610612751,
    DT_ANDROID_RELSZ=1610612752,
    DT_ANDROID_RELA=1610612753,
    DT_ANDROID_RELASZ=1610612754,
    DT_ANDROID_RELR=1879040000,
    DT_ANDROID_RELRSZ=1879040001,
    DT_ANDROID_RELRENT=1879040003,
    DT_GNU_PRELINKED=1879047669,
    DT_GNU_CONFLICTSZ=1879047670,
    DT_GNU_LIBLISTSZ=1879047671,
    DT_CHECKSUM=1879047672,
    DT_PLTPADSZ=1879047673,
    DT_MOVEENT=1879047674,
    DT_MOVESZ=1879047675,
    DT_FEATURE_1=1879047676,
    DT_POSFLAG_1=1879047677,
    DT_SYMINSZ=1879047678,
    DT_SYMINENT=1879047679,
    DT_GNU_XHASH=1879047924,
    DT_GNU_HASH=1879047925,
    DT_TLSDESC_PLT=1879047926,
    DT_TLSDESC_GOT=1879047927,
    DT_GNU_CONFLICT=1879047928,
    DT_GNU_LIBLIST=1879047929,
    DT_CONFIG=1879047930,
    DT_DEPAUDIT=1879047931,
    DT_AUDIT=1879047932,
    DT_PLTPAD=1879047933,
    DT_MOVETAB=1879047934,
    DT_SYMINFO=1879047935,
    DT_VERSYM=1879048176,
    DT_RELACOUNT=1879048185,
    DT_RELCOUNT=1879048186,
    DT_FLAGS_1=1879048187,
    DT_VERDEF=1879048188,
    DT_VERDEFNUM=1879048189,
    DT_VERNEED=1879048190,
    DT_VERNEEDNUM=1879048191,
    DT_AUXILIARY=2147483645,
    DT_FILTER=2147483647
} Elf64_DynTag;

struct Elf64_Dyn {
    enum Elf64_DynTag d_tag;
    qword d_val;
};

typedef struct Elf64_Sym Elf64_Sym, *PElf64_Sym;

struct Elf64_Sym {
    dword st_name;
    byte st_info;
    byte st_other;
    word st_shndx;
    qword st_value;
    qword st_size;
};

typedef struct GnuBuildId GnuBuildId, *PGnuBuildId;

struct GnuBuildId {
    dword namesz; // Length of name field
    dword descsz; // Length of description field
    dword type; // Vendor specific type
    char name[4]; // Vendor name
    byte hash[20];
};

typedef struct NoteGnuProperty_4 NoteGnuProperty_4, *PNoteGnuProperty_4;

struct NoteGnuProperty_4 {
    dword namesz; // Length of name field
    dword descsz; // Length of description field
    dword type; // Vendor specific type
    char name[4]; // Vendor name
};

typedef struct Elf64_Ehdr Elf64_Ehdr, *PElf64_Ehdr;

struct Elf64_Ehdr {
    byte e_ident_magic_num;
    char e_ident_magic_str[3];
    byte e_ident_class;
    byte e_ident_data;
    byte e_ident_version;
    byte e_ident_osabi;
    byte e_ident_abiversion;
    byte e_ident_pad[7];
    word e_type;
    word e_machine;
    dword e_version;
    qword e_entry;
    qword e_phoff;
    qword e_shoff;
    dword e_flags;
    word e_ehsize;
    word e_phentsize;
    word e_phnum;
    word e_shentsize;
    word e_shnum;
    word e_shstrndx;
};

typedef struct Elf64_Rela Elf64_Rela, *PElf64_Rela;

struct Elf64_Rela {
    qword r_offset; // location to apply the relocation action
    qword r_info; // the symbol table index and the type of relocation
    qword r_addend; // a constant addend used to compute the relocatable field value
};

typedef struct Elf64_Phdr Elf64_Phdr, *PElf64_Phdr;

struct Elf64_Phdr {
    enum Elf_ProgramHeaderType p_type;
    dword p_flags;
    qword p_offset;
    qword p_vaddr;
    qword p_paddr;
    qword p_filesz;
    qword p_memsz;
    qword p_align;
};

typedef struct NoteAbiTag NoteAbiTag, *PNoteAbiTag;

struct NoteAbiTag {
    dword namesz; // Length of name field
    dword descsz; // Length of description field
    dword type; // Vendor specific type
    char name[4]; // Vendor name
    dword abiType; // 0 == Linux
    dword requiredKernelVersion[3]; // Major.minor.patch
};




int _init(EVP_PKEY_CTX *ctx)

{
  int iVar1;
  
  iVar1 = __gmon_start__();
  return iVar1;
}



void FUN_00102020(void)

{
  (*(code *)(undefined *)0x0)();
  return;
}



void C_initialize_lf(void)

{
  C_initialize_lf();
  return;
}



void C_i_car(void)

{
  C_i_car();
  return;
}



void C_i_list_tail(void)

{
  C_i_list_tail();
  return;
}



void C_data_2dstructures_toplevel(void)

{
  C_data_2dstructures_toplevel();
  return;
}



void C_save_and_reclaim_args(void)

{
  C_save_and_reclaim_args();
  return;
}



void C_i_lessp(void)

{
  C_i_lessp();
  return;
}



void C_s_a_i_plus(void)

{
  C_s_a_i_plus();
  return;
}



void C_check_nursery_minimum(void)

{
  C_check_nursery_minimum();
  return;
}



void C_trace(void)

{
  C_trace();
  return;
}



void C_i_length(void)

{
  C_i_length();
  return;
}



void C_bad_argc_2(void)

{
  C_bad_argc_2();
  return;
}



void C_library_toplevel(void)

{
  C_library_toplevel();
  return;
}



void C_h_intern(void)

{
  C_h_intern();
  return;
}



void C_save_and_reclaim(void)

{
                    // WARNING: Subroutine does not return
  C_save_and_reclaim();
}



void C_i_nequalp(void)

{
  C_i_nequalp();
  return;
}



void C_raise_interrupt(void)

{
  C_raise_interrupt();
  return;
}



void C_extras_toplevel(void)

{
  C_extras_toplevel();
  return;
}



void C_s_a_i_bitwise_xor(void)

{
  C_s_a_i_bitwise_xor();
  return;
}



void C_register_lf2(void)

{
  C_register_lf2();
  return;
}



void C_decode_literal(void)

{
  C_decode_literal();
  return;
}



void C_eval_toplevel(void)

{
  C_eval_toplevel();
  return;
}



void C_rereclaim2(void)

{
  C_rereclaim2();
  return;
}



void C_i_greater_or_equalp(void)

{
  C_i_greater_or_equalp();
  return;
}



void C_unbound_variable(void)

{
  C_unbound_variable();
  return;
}



void CHICKEN_main(void)

{
  CHICKEN_main();
  return;
}



void C_toplevel_entry(void)

{
  C_toplevel_entry();
  return;
}



void C_mutate_slot(void)

{
  C_mutate_slot();
  return;
}



void __cxa_finalize(void)

{
  __cxa_finalize();
  return;
}



int main(int argc,char **argv)

{
  int iVar1;
  
  iVar1 = CHICKEN_main(argc,argv,C_toplevel);
  return iVar1;
}



void processEntry _start(undefined8 param_1,undefined8 param_2)

{
  undefined auStack_8 [8];
  
  __libc_start_main(main,param_2,&stack0x00000008,0,0,param_1,auStack_8);
  do {
                    // WARNING: Do nothing block with infinite loop
  } while( true );
}



// WARNING: Removing unreachable block (ram,0x00102243)
// WARNING: Removing unreachable block (ram,0x0010224f)

void deregister_tm_clones(void)

{
  return;
}



// WARNING: Removing unreachable block (ram,0x00102284)
// WARNING: Removing unreachable block (ram,0x00102290)

void register_tm_clones(void)

{
  return;
}



void __do_global_dtors_aux(void)

{
  if (completed_0 != '\0') {
    return;
  }
  __cxa_finalize(__dso_handle);
  deregister_tm_clones();
  completed_0 = 1;
  return;
}



void frame_dummy(void)

{
  register_tm_clones();
  return;
}



void C_toplevel(long c,long *av)

{
  long lVar1;
  long *plVar2;
  long *plVar3;
  undefined8 *puVar4;
  long lVar5;
  long avk [2];
  
  plVar3 = avk;
  lVar5 = av[1];
  if (toplevel_initialized != 0) {
    av = avk;
    c = 2;
    avk[1] = 0x1e;
    avk[0] = lVar5;
    (**(code **)(lVar5 + 8))();
  }
  C_toplevel_entry("toplevel");
  lVar1 = (ulong)(c < 3) * 2 + 3;
  C_check_nursery_minimum(lVar1);
  if (lVar1 + C_scratch_usage < (long)avk - C_stack_limit >> 3) {
    toplevel_initialized = 1;
    plVar2 = avk;
    if (C_fromspace_limit <= C_fromspace_top + 0x6a8U) {
      plVar2 = C_temporary_stack + -1;
      C_temporary_stack = C_temporary_stack + -1;
      *plVar2 = lVar5;
      C_rereclaim2(0x6a8,1);
      lVar5 = *C_temporary_stack;
      plVar2 = avk;
      C_temporary_stack = C_temporary_stack + 1;
    }
    for (; plVar2 != avk; plVar2 = (long *)((long)plVar2 + -0x1000)) {
      *(undefined8 *)((long)plVar2 + -8) = *(undefined8 *)((long)plVar2 + -8);
    }
    plVar3 = (long *)((long)plVar2 + -0x20);
    *(undefined8 *)((long)plVar2 + -8) = *(undefined8 *)((long)plVar2 + -8);
    c = (long)&C_fromspace_top;
    *(undefined8 *)((long)plVar2 + -0x28) = 0x1023e6;
    C_initialize_lf(lf,0xd);
    *(undefined8 *)((long)plVar2 + -0x28) = 0x1023fa;
    lf[0] = C_h_intern(lf,7,"schemes");
    puVar4 = (undefined8 *)((ulong)((long)plVar2 + -0x11) & 0xfffffffffffffff0);
    *(undefined8 *)((long)plVar2 + -0x28) = 0x102419;
    lf[1] = C_decode_literal(&C_fromspace_top,&DAT_00104190);
    *(undefined8 *)((long)plVar2 + -0x28) = 0x102435;
    lf[2] = C_h_intern(0x1062d0,3,"nth");
    *(undefined8 *)((long)plVar2 + -0x28) = 0x102451;
    lf[3] = C_h_intern(0x1062d8,0x12,"chicken.base#error");
    *(undefined8 *)((long)plVar2 + -0x28) = 0x102467;
    lf[4] = C_decode_literal(&C_fromspace_top,&DAT_001043f0);
    *(undefined8 *)((long)plVar2 + -0x28) = 0x102483;
    lf[5] = C_h_intern(0x1062e8,5,"input");
    *(undefined8 *)((long)plVar2 + -0x28) = 0x10249f;
    lf[6] = C_h_intern(0x1062f0,2,&DAT_0010402e);
    *(undefined8 *)((long)plVar2 + -0x28) = 0x1024bb;
    lf[7] = C_h_intern(0x1062f8,0x22,"chicken.base#implicit-exit-handler");
    *(undefined8 *)((long)plVar2 + -0x28) = 0x1024d7;
    lf[8] = C_h_intern(0x106300,0x12,"chicken.base#print");
    *(undefined8 *)((long)plVar2 + -0x28) = 0x1024ed;
    lf[9] = C_decode_literal(&C_fromspace_top,&DAT_00104411);
    *(undefined8 *)((long)plVar2 + -0x28) = 0x102503;
    lf[10] = C_decode_literal(&C_fromspace_top,&DAT_00104419);
    *(undefined8 *)((long)plVar2 + -0x28) = 0x10251f;
    lf[0xb] = C_h_intern(0x106318,0x12,"##sys#string->list");
    *(undefined8 *)((long)plVar2 + -0x28) = 0x10253b;
    lf[0xc] = C_h_intern(0x106320,0x14,"chicken.io#read-line");
    *(undefined8 *)((long)plVar2 + -0x28) = 0x102556;
    C_register_lf2(lf,0xd,ptable);
    puVar4[2] = lVar5;
    *av = 0x1e;
    *puVar4 = 0x2400000000000002;
    puVar4[1] = f_154;
    av[1] = (long)puVar4;
    *(undefined8 *)((long)plVar2 + -0x28) = 0x10258d;
    C_library_toplevel(2,av);
  }
                    // WARNING: Subroutine does not return
  *(undefined8 *)((long)plVar3 + -8) = 0x10259f;
  C_save_and_reclaim(C_toplevel,c & 0xffffffff,av);
}



void f_210(long c,long *av)

{
  long lVar1;
  ulong *puVar2;
  code *pcVar3;
  long in_FS_OFFSET;
  undefined auStack_48 [8];
  ulong *local_40;
  undefined8 local_30;
  
  lVar1 = *av;
  puVar2 = (ulong *)av[1];
  local_30 = *(undefined8 *)(in_FS_OFFSET + 0x28);
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  if (C_timer_interrupt_counter < 1) {
    local_40 = (ulong *)av;
    C_raise_interrupt(0xff);
    av = (long *)local_40;
  }
  if ((long)((ulong)(c < 2) + C_scratch_usage) < (long)(auStack_48 + -C_stack_limit) >> 3) {
    *av = (long)puVar2;
    ((ulong *)av)[1] = *(ulong *)(lVar1 + 0x10);
    if ((((ulong)puVar2 & 3) == 0) && ((*puVar2 & 0xff00000000000000) == 0x2400000000000000))
    goto LAB_0010267f;
    pcVar3 = C_invalid_procedure;
    do {
      (*pcVar3)(2);
LAB_0010267f:
      pcVar3 = (code *)puVar2[1];
    } while( true );
  }
                    // WARNING: Subroutine does not return
  C_save_and_reclaim(f_210,c & 0xffffffff,av);
}



void f_154(long c,long *av)

{
  undefined8 uVar1;
  undefined8 *puVar2;
  undefined *puVar3;
  undefined *puVar4;
  undefined *puVar5;
  long in_FS_OFFSET;
  undefined auStack_38 [8];
  undefined8 local_30;
  long _av;
  
  puVar5 = auStack_38;
  _av = *av;
  local_30 = *(undefined8 *)(in_FS_OFFSET + 0x28);
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  puVar3 = auStack_38;
  if (C_timer_interrupt_counter < 1) goto LAB_00102781;
  while (puVar4 = puVar3,
        (long)(C_scratch_usage + 3 + (ulong)(c < 3) * 2) < (long)puVar3 - C_stack_limit >> 3) {
    for (; puVar4 != puVar3; puVar4 = puVar4 + -0x1000) {
      *(undefined8 *)(puVar4 + -8) = *(undefined8 *)(puVar4 + -8);
    }
    puVar5 = puVar4 + -0x20;
    *(undefined8 *)(puVar4 + -8) = *(undefined8 *)(puVar4 + -8);
    puVar2 = (undefined8 *)((ulong)(puVar4 + -0x11) & 0xfffffffffffffff0);
    *puVar2 = 0x2400000000000002;
    puVar2[1] = f_157;
    uVar1 = *(undefined8 *)(_av + 0x10);
    *av = 0x1e;
    puVar2[2] = uVar1;
    av[1] = (long)puVar2;
    *(undefined8 *)(puVar4 + -0x28) = 0x102781;
    C_eval_toplevel(2,av);
LAB_00102781:
    *(undefined8 *)(puVar5 + -8) = 0x10278b;
    C_raise_interrupt(0xff);
    puVar3 = puVar5;
  }
                    // WARNING: Subroutine does not return
  *(Alignment **)(puVar3 + -8) = &UNK_001027a2;
  C_save_and_reclaim(f_154,c & 0xffffffff,av);
}



void f_157(long c,long *av)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 *puVar3;
  undefined *puVar4;
  undefined *puVar5;
  undefined *puVar6;
  long in_FS_OFFSET;
  undefined auStack_38 [8];
  undefined8 local_30;
  
  puVar6 = auStack_38;
  lVar1 = *av;
  local_30 = *(undefined8 *)(in_FS_OFFSET + 0x28);
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  puVar4 = auStack_38;
  if (C_timer_interrupt_counter < 1) goto LAB_00102881;
  while (puVar5 = puVar4,
        (long)(C_scratch_usage + 3 + (ulong)(c < 3) * 2) < (long)puVar4 - C_stack_limit >> 3) {
    for (; puVar5 != puVar4; puVar5 = puVar5 + -0x1000) {
      *(undefined8 *)(puVar5 + -8) = *(undefined8 *)(puVar5 + -8);
    }
    puVar6 = puVar5 + -0x20;
    *(undefined8 *)(puVar5 + -8) = *(undefined8 *)(puVar5 + -8);
    puVar3 = (undefined8 *)((ulong)(puVar5 + -0x11) & 0xfffffffffffffff0);
    *puVar3 = 0x2400000000000002;
    puVar3[1] = f_160;
    uVar2 = *(undefined8 *)(lVar1 + 0x10);
    *av = 0x1e;
    puVar3[2] = uVar2;
    av[1] = (long)puVar3;
    *(undefined8 *)(puVar5 + -0x28) = 0x102881;
    C_extras_toplevel(2,av);
LAB_00102881:
    *(undefined8 *)(puVar6 + -8) = 0x10288b;
    C_raise_interrupt(0xff);
    puVar4 = puVar6;
  }
                    // WARNING: Subroutine does not return
  *(Alignment **)(puVar4 + -8) = &UNK_001028a2;
  C_save_and_reclaim(f_157,c & 0xffffffff,av);
}



void f_160(long c,long *av)

{
  long lVar1;
  undefined8 uVar2;
  undefined8 *puVar3;
  undefined *puVar4;
  undefined *puVar5;
  undefined *puVar6;
  long in_FS_OFFSET;
  undefined auStack_38 [8];
  undefined8 local_30;
  
  puVar6 = auStack_38;
  lVar1 = *av;
  local_30 = *(undefined8 *)(in_FS_OFFSET + 0x28);
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  puVar4 = auStack_38;
  if (C_timer_interrupt_counter < 1) goto LAB_00102981;
  while (puVar5 = puVar4,
        (long)(C_scratch_usage + 3 + (ulong)(c < 3) * 2) < (long)puVar4 - C_stack_limit >> 3) {
    for (; puVar5 != puVar4; puVar5 = puVar5 + -0x1000) {
      *(undefined8 *)(puVar5 + -8) = *(undefined8 *)(puVar5 + -8);
    }
    puVar6 = puVar5 + -0x20;
    *(undefined8 *)(puVar5 + -8) = *(undefined8 *)(puVar5 + -8);
    puVar3 = (undefined8 *)((ulong)(puVar5 + -0x11) & 0xfffffffffffffff0);
    *puVar3 = 0x2400000000000002;
    puVar3[1] = f_163;
    uVar2 = *(undefined8 *)(lVar1 + 0x10);
    *av = 0x1e;
    puVar3[2] = uVar2;
    av[1] = (long)puVar3;
    *(undefined8 *)(puVar5 + -0x28) = 0x102981;
    C_data_2dstructures_toplevel(2,av);
LAB_00102981:
    *(undefined8 *)(puVar6 + -8) = 0x10298b;
    C_raise_interrupt(0xff);
    puVar4 = puVar6;
  }
                    // WARNING: Subroutine does not return
  *(Alignment **)(puVar4 + -8) = &UNK_001029a2;
  C_save_and_reclaim(f_160,c & 0xffffffff,av);
}



void f_228(long t0,long t1,long t2)

{
  undefined8 uVar1;
  long lVar2;
  code *pcVar3;
  undefined *puVar4;
  long *plVar5;
  long *plVar6;
  undefined8 *unaff_R13;
  long av2 [2];
  
  plVar5 = av2;
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  plVar6 = av2;
  if (C_timer_interrupt_counter < 1) goto LAB_00102a6a;
  while( true ) {
    puVar4 = (undefined *)plVar6;
    if ((long)plVar6 - C_stack_limit >> 3 <= C_scratch_usage + 0xc) goto LAB_00102b2a;
    for (; (long *)puVar4 != plVar6; puVar4 = puVar4 + -0x1000) {
      *(undefined8 *)(puVar4 + -8) = *(undefined8 *)(puVar4 + -8);
    }
    plVar5 = (long *)(puVar4 + -0x50);
    plVar6 = (long *)(puVar4 + -0x50);
    *(undefined8 *)(puVar4 + -8) = *(undefined8 *)(puVar4 + -8);
    unaff_R13 = (undefined8 *)((ulong)(puVar4 + -0x41) & 0xfffffffffffffff0);
    *(undefined8 *)(puVar4 + -0x58) = 0x102a4c;
    lVar2 = C_i_greater_or_equalp(t2,0x65);
    if (lVar2 == 6) break;
    av2[1] = 0x1e;
    pcVar3 = *(code **)(t1 + 8);
    *(undefined8 *)(puVar4 + -0x58) = 0x102a6a;
    av2[0] = t1;
    (*pcVar3)(2,av2);
LAB_00102a6a:
    *(undefined8 *)((long)plVar5 + -8) = 0x102a74;
    C_raise_interrupt(0xff);
    plVar6 = plVar5;
  }
  unaff_R13[2] = t2;
  *unaff_R13 = 0x2400000000000004;
  unaff_R13[1] = f_238;
  uVar1 = *(undefined8 *)(t0 + 0x10);
  unaff_R13[4] = t1;
  unaff_R13[3] = uVar1;
  unaff_R13[5] = 0x2400000000000003;
  unaff_R13[6] = f_257;
  unaff_R13[7] = t2;
  unaff_R13[8] = unaff_R13;
  unaff_R13 = unaff_R13 + 5;
  *(undefined8 *)(puVar4 + -0x58) = 0x102ad4;
  C_trace("test.scm:26: nth");
  av2[0] = *(ulong *)(lf[2] + 8);
  if (((av2[0] & 3U) == 0) && ((*(ulong *)av2[0] & 0xff00000000000000) == 0x2400000000000000))
  goto LAB_00102b46;
  pcVar3 = C_invalid_procedure;
  plVar6 = (long *)(puVar4 + -0x50);
  do {
    *(undefined8 *)((long)plVar6 + -8) = 0x102b2a;
    av2[1] = (long)unaff_R13;
    (*pcVar3)(4,av2);
LAB_00102b2a:
    *(undefined8 *)((long)plVar6 + -8) = 0x102b46;
    av2[0] = C_save_and_reclaim_args(trf_228,3,t0,t1,t2);
LAB_00102b46:
    pcVar3 = *(code **)(av2[0] + 8);
  } while( true );
}



void trf_228(long c,long *av)

{
                    // WARNING: Subroutine does not return
  f_228(av[2],av[1],*av);
}



void f_238(long t0,long t1)

{
  undefined8 uVar1;
  long lVar2;
  ulong uVar3;
  long t2;
  undefined8 uVar4;
  long lVar5;
  long **pplVar6;
  undefined **ppuVar7;
  long *plVar8;
  code *pcVar9;
  long in_FS_OFFSET;
  undefined *puStack_60;
  undefined8 uStack_58;
  long lStack_50;
  long lStack_48;
  long *a;
  undefined8 local_20;
  
  pplVar6 = &a;
  local_20 = *(undefined8 *)(in_FS_OFFSET + 0x28);
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  if (C_timer_interrupt_counter < 1) {
    C_raise_interrupt(0xff);
  }
  if (C_scratch_usage + 0x1f < (long)&a - C_stack_limit >> 3) {
    for (; pplVar6 != &a; pplVar6 = (long **)((long)pplVar6 + -0x1000)) {
      *(undefined8 *)((long)pplVar6 + -8) = *(undefined8 *)((long)pplVar6 + -8);
    }
    *(undefined8 *)((long)pplVar6 + -8) = *(undefined8 *)((long)pplVar6 + -8);
    uVar1 = *(undefined8 *)(t0 + 0x10);
    a = (long *)((ulong)((long)pplVar6 + -0xe1) & 0xfffffffffffffff0);
    *(undefined8 *)((long)pplVar6 + -0xf8) = 0x102c1a;
    t2 = C_s_a_i_plus(&a,2,uVar1,3);
    lVar2 = *(long *)(t0 + 0x20);
    lVar5 = *(long *)(*(long *)(t0 + 0x18) + 8);
                    // WARNING: Subroutine does not return
    *(undefined8 *)((long)pplVar6 + -0xf8) = 0x102c30;
    f_228(lVar5,lVar2,t2);
  }
  plVar8 = (long *)0x2;
  pcVar9 = trf_238;
  C_save_and_reclaim_args(trf_238,2,t0,t1);
  lStack_48 = t0;
  lStack_50 = t1;
  ppuVar7 = &puStack_60;
  lVar2 = *plVar8;
  uVar3 = plVar8[1];
  uStack_58 = *(undefined8 *)(in_FS_OFFSET + 0x28);
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  if (C_timer_interrupt_counter < 1) {
    C_raise_interrupt(0xff);
  }
  if ((long)((ulong)((long)pcVar9 < 2) + 5 + C_scratch_usage) <
      (long)&puStack_60 - C_stack_limit >> 3) {
    for (; ppuVar7 != &puStack_60; ppuVar7 = (undefined **)((long)ppuVar7 + -0x1000)) {
      *(undefined8 *)((long)ppuVar7 + -8) = *(undefined8 *)((long)ppuVar7 + -8);
    }
    *(undefined8 *)((long)ppuVar7 + -8) = *(undefined8 *)((long)ppuVar7 + -8);
    puStack_60 = (undefined *)((long)ppuVar7 + -0x30);
    uVar1 = *(undefined8 *)(lVar2 + 0x10);
    *(undefined8 *)((long)ppuVar7 + -0x38) = 0x102d2a;
    uVar4 = C_s_a_i_bitwise_xor(&puStack_60,2,(uint)(uVar3 >> 7) & 0x3ffffe | 1,uVar1);
    uVar1 = *(undefined8 *)(lVar2 + 0x18);
    *(undefined8 *)((long)ppuVar7 + -0x38) = 0x102d36;
    lVar5 = C_i_nequalp(uVar1,uVar4);
    if (lVar5 != 6) {
      lVar2 = *(long *)(lVar2 + 0x20);
                    // WARNING: Subroutine does not return
      *(undefined8 *)((long)ppuVar7 + -0x38) = 0x102d4a;
      f_238(lVar2,0x1e);
    }
    *(undefined8 *)(lf[6] + 8) = 1;
    lVar2 = *(long *)(lVar2 + 0x20);
                    // WARNING: Subroutine does not return
    *(undefined8 *)((long)ppuVar7 + -0x38) = 0x102d67;
    f_238(lVar2,1);
  }
                    // WARNING: Subroutine does not return
  C_save_and_reclaim(f_269,(ulong)pcVar9 & 0xffffffff,plVar8);
}



void f_269(long c,long *av)

{
  long lVar1;
  ulong uVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  long lVar5;
  long **pplVar6;
  long in_FS_OFFSET;
  long *a;
  undefined8 local_30;
  
  pplVar6 = &a;
  lVar1 = *av;
  uVar2 = av[1];
  local_30 = *(undefined8 *)(in_FS_OFFSET + 0x28);
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  if (C_timer_interrupt_counter < 1) {
    C_raise_interrupt(0xff);
  }
  if ((long)&a - C_stack_limit >> 3 <= (long)((ulong)(c < 2) + 5 + C_scratch_usage)) {
                    // WARNING: Subroutine does not return
    C_save_and_reclaim(f_269,c & 0xffffffff,av);
  }
  for (; pplVar6 != &a; pplVar6 = (long **)((long)pplVar6 + -0x1000)) {
    *(undefined8 *)((long)pplVar6 + -8) = *(undefined8 *)((long)pplVar6 + -8);
  }
  *(undefined8 *)((long)pplVar6 + -8) = *(undefined8 *)((long)pplVar6 + -8);
  a = (long *)((ulong)((long)pplVar6 + -0x21) & 0xfffffffffffffff0);
  uVar3 = *(undefined8 *)(lVar1 + 0x10);
  *(undefined8 *)((long)pplVar6 + -0x38) = 0x102d2a;
  uVar4 = C_s_a_i_bitwise_xor(&a,2,(uint)(uVar2 >> 7) & 0x3ffffe | 1,uVar3);
  uVar3 = *(undefined8 *)(lVar1 + 0x18);
  *(undefined8 *)((long)pplVar6 + -0x38) = 0x102d36;
  lVar5 = C_i_nequalp(uVar3,uVar4);
  if (lVar5 != 6) {
    lVar1 = *(long *)(lVar1 + 0x20);
                    // WARNING: Subroutine does not return
    *(undefined8 *)((long)pplVar6 + -0x38) = 0x102d4a;
    f_238(lVar1,0x1e);
  }
  *(undefined8 *)(lf[6] + 8) = 1;
  lVar1 = *(long *)(lVar1 + 0x20);
                    // WARNING: Subroutine does not return
  *(undefined8 *)((long)pplVar6 + -0x38) = 0x102d67;
  f_238(lVar1,1);
}



void trf_238(long c,long *av)

{
                    // WARNING: Subroutine does not return
  f_238(av[1],*av);
}



void f_201(long c,long *av)

{
  ulong *puVar1;
  long lVar2;
  code *pcVar3;
  undefined *puVar4;
  undefined *puVar5;
  undefined *puVar6;
  undefined *puVar7;
  undefined *puVar8;
  undefined8 *puVar9;
  long lVar10;
  long in_FS_OFFSET;
  undefined auStack_38 [8];
  undefined8 local_30;
  
  puVar8 = auStack_38;
  lVar10 = *av;
  local_30 = *(undefined8 *)(in_FS_OFFSET + 0x28);
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  puVar7 = auStack_38;
  if (C_timer_interrupt_counter < 1) goto LAB_00102fcb;
  while (lVar2 = lf[6], puVar4 = puVar7,
        (long)(C_scratch_usage + 3 + (ulong)(c < 3) * 2) < (long)puVar7 - C_stack_limit >> 3) {
    for (; puVar4 != puVar7; puVar4 = puVar4 + -0x1000) {
      *(undefined8 *)(puVar4 + -8) = *(undefined8 *)(puVar4 + -8);
    }
    puVar5 = puVar4 + -0x20;
    puVar6 = puVar4 + -0x20;
    *(undefined8 *)(puVar4 + -8) = *(undefined8 *)(puVar4 + -8);
    puVar9 = (undefined8 *)((ulong)(puVar4 + -0x11) & 0xfffffffffffffff0);
    *puVar9 = 0x2400000000000002;
    puVar9[1] = f_204;
    puVar9[2] = *(undefined8 *)(lVar10 + 0x10);
    lVar10 = *(long *)(lVar2 + 8);
    if (lVar10 == 0x2e) {
      *(undefined8 *)(puVar4 + -0x28) = 0x102e86;
      C_unbound_variable();
    }
    *(undefined8 *)(puVar4 + -0x28) = 0x102e93;
    lVar2 = C_i_nequalp(lVar10,3);
    puVar8 = puVar4 + -0x20;
    if (lVar2 != 6) {
      *(undefined8 *)(puVar4 + -0x28) = 0x102ea9;
      C_trace("test.scm:34: chicken.base#print");
      puVar1 = *(ulong **)(lf[8] + 8);
      if ((((ulong)puVar1 & 3) == 0) && ((*puVar1 & 0xff00000000000000) == 0x2400000000000000)) {
        pcVar3 = (code *)puVar1[1];
      }
      else {
        pcVar3 = C_invalid_procedure;
      }
      if (c < 3) {
        for (; puVar5 != puVar4 + -0x20; puVar5 = puVar5 + -0x1000) {
          *(undefined8 *)(puVar5 + -8) = *(undefined8 *)(puVar5 + -8);
        }
        puVar6 = puVar5 + -0x20;
        *(undefined8 *)(puVar5 + -8) = *(undefined8 *)(puVar5 + -8);
        av = (long *)((ulong)(puVar5 + -0x11) & 0xfffffffffffffff0);
      }
      *av = (long)puVar1;
      ((ulong *)av)[1] = (ulong)puVar9;
      ((ulong *)av)[2] = lf[9];
      *(undefined8 *)(puVar6 + -8) = 0x102f36;
      (*pcVar3)(3,av);
      puVar8 = puVar6;
    }
    *(undefined8 *)(puVar8 + -8) = 0x102f42;
    C_trace("test.scm:35: chicken.base#print");
    puVar1 = *(ulong **)(lf[8] + 8);
    if ((((ulong)puVar1 & 3) == 0) && ((*puVar1 & 0xff00000000000000) == 0x2400000000000000)) {
      pcVar3 = (code *)puVar1[1];
    }
    else {
      pcVar3 = C_invalid_procedure;
    }
    puVar7 = puVar8;
    if (c < 3) {
      for (; puVar7 != puVar8; puVar7 = puVar7 + -0x1000) {
        *(undefined8 *)(puVar7 + -8) = *(undefined8 *)(puVar7 + -8);
      }
      puVar8 = puVar7 + -0x20;
      *(undefined8 *)(puVar7 + -8) = *(undefined8 *)(puVar7 + -8);
      av = (long *)((ulong)(puVar7 + -0x11) & 0xfffffffffffffff0);
    }
    *av = (long)puVar1;
    ((ulong *)av)[1] = (ulong)puVar9;
    ((ulong *)av)[2] = lf[10];
    *(undefined8 *)(puVar8 + -8) = 0x102fcb;
    (*pcVar3)(3,av);
LAB_00102fcb:
    *(undefined8 *)(puVar8 + -8) = 0x102fd5;
    C_raise_interrupt(0xff);
    puVar7 = puVar8;
  }
                    // WARNING: Subroutine does not return
  *(Alignment **)(puVar7 + -8) = &UNK_00102ffb;
  C_save_and_reclaim(f_201,c & 0xffffffff,av);
}



void f_257(long c,long *av)

{
  long lVar1;
  long lVar2;
  undefined8 uVar3;
  ulong *puVar4;
  undefined *puVar5;
  undefined *puVar6;
  undefined *puVar7;
  undefined *puVar8;
  undefined8 *puVar9;
  code *pcVar10;
  long in_FS_OFFSET;
  undefined auStack_48 [8];
  undefined8 local_40;
  
  puVar8 = auStack_48;
  lVar1 = *av;
  lVar2 = av[1];
  local_40 = *(undefined8 *)(in_FS_OFFSET + 0x28);
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  puVar5 = auStack_48;
  if (C_timer_interrupt_counter < 1) goto LAB_0010317a;
  while (puVar6 = puVar5,
        (long)((ulong)(c < 4) * 3 + 5 + C_scratch_usage) < (long)puVar5 - C_stack_limit >> 3) {
    for (; puVar6 != puVar5; puVar6 = puVar6 + -0x1000) {
      *(undefined8 *)(puVar6 + -8) = *(undefined8 *)(puVar6 + -8);
    }
    puVar7 = puVar6 + -0x30;
    puVar8 = puVar6 + -0x30;
    *(undefined8 *)(puVar6 + -8) = *(undefined8 *)(puVar6 + -8);
    puVar9 = (undefined8 *)((ulong)(puVar6 + -0x21) & 0xfffffffffffffff0);
    *puVar9 = 0x2400000000000004;
    puVar9[1] = f_269;
    uVar3 = *(undefined8 *)(lVar1 + 0x10);
    puVar9[3] = lVar2;
    puVar9[2] = uVar3;
    puVar9[4] = *(undefined8 *)(lVar1 + 0x18);
    *(undefined8 *)(puVar6 + -0x38) = 0x1030dd;
    C_trace("test.scm:28: nth");
    puVar4 = *(ulong **)(lf[2] + 8);
    if ((((ulong)puVar4 & 3) == 0) && ((*puVar4 & 0xff00000000000000) == 0x2400000000000000)) {
      pcVar10 = (code *)puVar4[1];
    }
    else {
      pcVar10 = C_invalid_procedure;
    }
    if (c < 4) {
      for (; puVar7 != puVar6 + -0x30; puVar7 = puVar7 + -0x1000) {
        *(undefined8 *)(puVar7 + -8) = *(undefined8 *)(puVar7 + -8);
      }
      puVar8 = puVar7 + -0x30;
      *(undefined8 *)(puVar7 + -8) = *(undefined8 *)(puVar7 + -8);
      av = (long *)((ulong)(puVar7 + -0x21) & 0xfffffffffffffff0);
    }
    *av = (long)puVar4;
    ((ulong *)av)[1] = (ulong)puVar9;
    ((ulong *)av)[2] = *(ulong *)(lVar1 + 0x10);
    c = *(ulong *)(lf[5] + 8);
    if (c == 0x2e) {
      *(undefined8 *)(puVar8 + -8) = 0x103194;
      C_unbound_variable();
    }
    ((ulong *)av)[3] = c;
    *(undefined8 *)(puVar8 + -8) = 0x10317a;
    (*pcVar10)(4,av);
LAB_0010317a:
    *(undefined8 *)(puVar8 + -8) = 0x103184;
    C_raise_interrupt(0xff);
    puVar5 = puVar8;
  }
                    // WARNING: Subroutine does not return
  *(undefined8 *)(puVar5 + -8) = 0x1031a8;
  C_save_and_reclaim(f_257,c & 0xffffffff,av);
}



void * C_fast_retrieve_symbol_proc(long sym)

{
  ulong *puVar1;
  
  puVar1 = *(ulong **)(sym + 8);
  if (puVar1 == (ulong *)0x2e) {
    C_unbound_variable();
    return C_invalid_procedure;
  }
  if ((((ulong)puVar1 & 3) == 0) && ((*puVar1 & 0xff00000000000000) == 0x2400000000000000)) {
    return (void *)puVar1[1];
  }
  return C_invalid_procedure;
}



void f_204(long c,long *av)

{
  long lVar1;
  code *pcVar2;
  undefined *puVar3;
  undefined *puVar4;
  undefined *puVar5;
  long in_FS_OFFSET;
  undefined auStack_38 [8];
  undefined8 local_30;
  
  puVar5 = auStack_38;
  lVar1 = *av;
  local_30 = *(undefined8 *)(in_FS_OFFSET + 0x28);
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  puVar3 = auStack_38;
  if (C_timer_interrupt_counter < 1) goto LAB_001032fa;
  while (puVar4 = puVar3,
        (long)(C_scratch_usage + 3 + (ulong)(c < 3) * 2) < (long)puVar3 - C_stack_limit >> 3) {
    for (; puVar4 != puVar3; puVar4 = puVar4 + -0x1000) {
      *(undefined8 *)(puVar4 + -8) = *(undefined8 *)(puVar4 + -8);
    }
    puVar5 = puVar4 + -0x20;
    *(undefined8 *)(puVar4 + -8) = *(undefined8 *)(puVar4 + -8);
    c = (ulong)(puVar4 + -0x11) & 0xfffffffffffffff0;
    *(undefined8 *)c = 0x2400000000000002;
    *(code **)(c + 8) = f_210;
    *(undefined8 *)(c + 0x10) = *(undefined8 *)(lVar1 + 0x10);
    *(undefined8 *)(puVar4 + -0x28) = 0x1032cc;
    C_trace("chicken.base#implicit-exit-handler");
    *(undefined8 *)(puVar4 + -0x28) = 0x1032d8;
    pcVar2 = (code *)C_fast_retrieve_symbol_proc(lf[7]);
    *av = *(long *)(lf[7] + 8);
    av[1] = c;
    *(undefined8 *)(puVar4 + -0x28) = 0x1032fa;
    (*pcVar2)(2,av);
LAB_001032fa:
    *(undefined8 *)(puVar5 + -8) = 0x103304;
    C_raise_interrupt(0xff);
    puVar3 = puVar5;
  }
                    // WARNING: Subroutine does not return
  *(Alignment **)(puVar3 + -8) = &UNK_0010331b;
  C_save_and_reclaim(f_204,c & 0xffffffff,av);
}



void f_166(long c,long *av)

{
  ulong uVar1;
  long lVar2;
  long lVar3;
  ulong *puVar4;
  long lVar5;
  undefined8 uVar6;
  ulong uVar7;
  code *pcVar8;
  long extraout_RDX;
  ulong *unaff_RBX;
  undefined8 *puVar9;
  long in_FS_OFFSET;
  undefined auStack_38 [8];
  undefined8 local_30;
  
  lVar5 = *av;
  uVar1 = av[1];
  local_30 = *(undefined8 *)(in_FS_OFFSET + 0x28);
  lVar2 = av[2];
  lVar3 = av[3];
  if (c != 4) goto LAB_0010340d;
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  if (C_timer_interrupt_counter < 1) goto LAB_00103417;
  do {
    if ((long)(auStack_38 + -C_stack_limit) >> 3 <= C_scratch_usage) {
                    // WARNING: Subroutine does not return
      C_save_and_reclaim(f_166,4,av);
    }
    lVar5 = C_i_lessp(lVar2,1,lVar5);
    if (lVar5 == 6) {
      uVar6 = C_i_length(lVar3);
      lVar5 = C_i_greater_or_equalp(lVar2,uVar6);
      if (lVar5 == 6) {
        *av = uVar1;
        uVar6 = C_i_list_tail(lVar3,lVar2);
        uVar7 = C_i_car(uVar6);
        puVar9 = (undefined8 *)0x2;
        ((ulong *)av)[1] = uVar7;
        (**(code **)(uVar1 + 8))();
        if (((ulong)av & 3) != 0) {
          *puVar9 = av;
          return;
        }
        C_mutate_slot();
        return;
      }
    }
    C_trace("test.scm:11: chicken.base#error");
    puVar4 = *(ulong **)(lf[3] + 8);
    if ((((ulong)puVar4 & 3) == 0) && ((*puVar4 & 0xff00000000000000) == 0x2400000000000000)) {
      pcVar8 = (code *)puVar4[1];
    }
    else {
      pcVar8 = C_invalid_procedure;
    }
    *av = (long)puVar4;
    ((ulong *)av)[1] = uVar1;
    ((ulong *)av)[2] = lf[4];
    (*pcVar8)(3,av);
    unaff_RBX = (ulong *)av;
LAB_0010340d:
    av = (long *)unaff_RBX;
    C_bad_argc_2();
LAB_00103417:
    C_raise_interrupt(0xff);
    lVar5 = extraout_RDX;
  } while( true );
}



long C_mutate(long *slot,long val)

{
  long in_RAX;
  long lVar1;
  
  if ((val & 3U) != 0) {
    *slot = val;
    return in_RAX;
  }
  lVar1 = C_mutate_slot();
  return lVar1;
}



void f_197(long c,long *av)

{
  long lVar1;
  undefined8 uVar2;
  long lVar3;
  undefined8 *t1;
  undefined *puVar4;
  long in_FS_OFFSET;
  undefined auStack_38 [8];
  undefined8 local_30;
  
  puVar4 = auStack_38;
  lVar3 = *av;
  lVar1 = av[1];
  local_30 = *(undefined8 *)(in_FS_OFFSET + 0x28);
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  if (C_timer_interrupt_counter < 1) {
    C_raise_interrupt(0xff);
  }
  if ((long)(auStack_38 + -C_stack_limit) >> 3 <= (long)((ulong)(c < 4) * 3 + 9 + C_scratch_usage))
  {
                    // WARNING: Subroutine does not return
    C_save_and_reclaim(f_197,c & 0xffffffff,av);
  }
  for (; puVar4 != auStack_38; puVar4 = puVar4 + -0x1000) {
    *(undefined8 *)(puVar4 + -8) = *(undefined8 *)(puVar4 + -8);
  }
  *(undefined8 *)(puVar4 + -8) = *(undefined8 *)(puVar4 + -8);
  *(undefined8 *)(puVar4 + -0x58) = 0x103552;
  C_mutate((long *)(lf[5] + 8),lVar1);
  t1 = (undefined8 *)((ulong)(puVar4 + -0x41) & 0xfffffffffffffff0);
  *(undefined8 *)(lf[6] + 8) = 3;
  lVar1 = lf[5];
  *t1 = 0x2400000000000002;
  t1[1] = f_201;
  t1[2] = *(undefined8 *)(lVar3 + 0x10);
  lVar3 = *(long *)(lVar1 + 8);
  if (lVar3 == 0x2e) {
    *(undefined8 *)(puVar4 + -0x58) = 0x10359b;
    C_unbound_variable();
  }
  *(undefined8 *)(puVar4 + -0x58) = 0x1035a3;
  uVar2 = C_i_length(lVar3);
  *(undefined8 *)(puVar4 + -0x58) = 0x1035b0;
  lVar3 = C_i_nequalp(uVar2,0x65);
  if (lVar3 != 6) {
    t1[7] = t1 + 3;
    t1[5] = 0x2400000000000003;
    t1[3] = 1;
    t1[6] = f_228;
    t1[8] = li1;
    t1[4] = t1 + 5;
                    // WARNING: Subroutine does not return
    *(undefined8 *)(puVar4 + -0x58) = 0x1035ff;
    f_228((long)(t1 + 5),(long)t1,1);
  }
  *(undefined8 *)(lf[6] + 8) = 1;
  *av = (long)t1;
  av[1] = 1;
                    // WARNING: Subroutine does not return
  *(undefined8 *)(puVar4 + -0x58) = 0x103628;
  f_201(2,av);
}



void f_193(long c,long *av)

{
  long val;
  code *pcVar1;
  long *plVar2;
  undefined *puVar3;
  undefined *puVar4;
  long *plVar5;
  undefined8 *puVar6;
  long lVar7;
  long in_FS_OFFSET;
  long lVar8;
  long local_58;
  undefined8 *puStack_50;
  undefined8 local_40;
  
  plVar5 = &local_58;
  lVar7 = *av;
  val = av[1];
  local_40 = *(undefined8 *)(in_FS_OFFSET + 0x28);
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  plVar2 = &local_58;
  if (C_timer_interrupt_counter < 1) goto LAB_001037b9;
  while (puVar3 = (undefined *)plVar2,
        (long)(C_scratch_usage + 3 + (ulong)(c < 3) * 2) < (long)plVar2 - C_stack_limit >> 3) {
    for (; (long *)puVar3 != plVar2; puVar3 = puVar3 + -0x1000) {
      *(undefined8 *)(puVar3 + -8) = *(undefined8 *)(puVar3 + -8);
    }
    puVar4 = puVar3 + -0x20;
    plVar5 = (long *)(puVar3 + -0x20);
    *(undefined8 *)(puVar3 + -8) = *(undefined8 *)(puVar3 + -8);
    *(undefined8 *)(puVar3 + -0x28) = 0x103704;
    C_mutate((long *)(lf[5] + 8),val);
    puVar6 = (undefined8 *)((ulong)(puVar3 + -0x11) & 0xfffffffffffffff0);
    *puVar6 = 0x2400000000000002;
    puVar6[1] = f_197;
    puVar6[2] = *(undefined8 *)(lVar7 + 0x10);
    *(undefined8 *)(puVar3 + -0x28) = 0x103735;
    C_trace("##sys#string->list");
    lVar7 = *(long *)(lf[0xb] + 8);
    lVar8 = lVar7;
    if (lVar7 == 0x2e) {
      *(undefined8 *)(puVar3 + -0x28) = 0x10375d;
      local_58 = lVar7;
      puStack_50 = puVar6;
      C_unbound_variable();
      lVar8 = local_58;
      puVar6 = puStack_50;
    }
    if (c < 3) {
      for (; puVar4 != puVar3 + -0x20; puVar4 = puVar4 + -0x1000) {
        *(undefined8 *)(puVar4 + -8) = *(undefined8 *)(puVar4 + -8);
      }
      plVar5 = (long *)(puVar4 + -0x20);
      *(undefined8 *)(puVar4 + -8) = *(undefined8 *)(puVar4 + -8);
      av = (long *)((ulong)(puVar4 + -0x11) & 0xfffffffffffffff0);
    }
    *av = lVar8;
    av[1] = (long)puVar6;
    c = *(ulong *)(lf[5] + 8);
    if (c == 0x2e) {
      *(undefined8 *)((long)plVar5 + -8) = 0x1037cd;
      C_unbound_variable();
    }
    av[2] = c;
    pcVar1 = *(code **)(lVar7 + 8);
    *(undefined8 *)((long)plVar5 + -8) = 0x1037b9;
    (*pcVar1)(3,av);
LAB_001037b9:
    *(undefined8 *)((long)plVar5 + -8) = 0x1037c3;
    C_raise_interrupt(0xff);
    plVar2 = plVar5;
  }
                    // WARNING: Subroutine does not return
  *(Alignment **)((long)plVar2 + -8) = &UNK_001037e1;
  C_save_and_reclaim(f_193,c & 0xffffffff,av);
}



void f_163(long c,long *av)

{
  long lVar1;
  long lVar2;
  code *pcVar3;
  undefined *puVar4;
  undefined *puVar5;
  undefined *puVar6;
  undefined8 *val;
  long in_FS_OFFSET;
  undefined auStack_38 [8];
  undefined8 local_30;
  
  puVar6 = auStack_38;
  lVar1 = *av;
  local_30 = *(undefined8 *)(in_FS_OFFSET + 0x28);
  C_timer_interrupt_counter = C_timer_interrupt_counter + -1;
  puVar4 = auStack_38;
  if (C_timer_interrupt_counter < 1) goto LAB_00103937;
  while (puVar5 = puVar4,
        (long)(C_scratch_usage + 6 + (ulong)(c < 5) * 4) < (long)puVar4 - C_stack_limit >> 3) {
    for (; puVar5 != puVar4; puVar5 = puVar5 + -0x1000) {
      *(undefined8 *)(puVar5 + -8) = *(undefined8 *)(puVar5 + -8);
    }
    puVar6 = puVar5 + -0x40;
    *(undefined8 *)(puVar5 + -8) = *(undefined8 *)(puVar5 + -8);
    *(undefined8 *)(puVar5 + -0x48) = 0x1038a7;
    C_mutate((long *)(lf[0] + 8),lf[1]);
    val = (undefined8 *)((ulong)(puVar5 + -0x31) & 0xfffffffffffffff0);
    val[1] = f_166;
    c = (long)(val + 3);
    val[2] = li0;
    lVar2 = lf[2];
    *val = 0x2400000000000002;
    *(undefined8 *)(puVar5 + -0x48) = 0x1038e4;
    C_mutate((long *)(lVar2 + 8),(long)val);
    *(undefined8 *)c = 0x2400000000000002;
    val[4] = f_193;
    val[5] = *(undefined8 *)(lVar1 + 0x10);
    *(undefined8 *)(puVar5 + -0x48) = 0x103909;
    C_trace("test.scm:15: chicken.io#read-line");
    *(undefined8 *)(puVar5 + -0x48) = 0x103915;
    pcVar3 = (code *)C_fast_retrieve_symbol_proc(lf[0xc]);
    *av = *(long *)(lf[0xc] + 8);
    av[1] = c;
    *(undefined8 *)(puVar5 + -0x48) = 0x103937;
    (*pcVar3)(2,av);
LAB_00103937:
    *(undefined8 *)(puVar6 + -8) = 0x103941;
    C_raise_interrupt(0xff);
    puVar4 = puVar6;
  }
                    // WARNING: Subroutine does not return
  *(code **)(puVar4 + -8) = _fini;
  C_save_and_reclaim(f_163,c & 0xffffffff,av);
}



void _fini(void)

{
  return;
}


