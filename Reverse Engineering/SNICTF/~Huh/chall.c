#include "types-and-globals.h"
#include "helpers.h"

_ABI(raw_x86_64)
artificial_struct_returned_by_rawfunction_22 function_0x401780_Code_x86_64(pointer_or_number64_t register_rcx _REG(rcx_x86_64), pointer_or_number64_t register_rdx _REG(rdx_x86_64), pointer_or_number64_t register_rsi _REG(rsi_x86_64), pointer_or_number64_t register_rdi _REG(rdi_x86_64), pointer_or_number64_t register_r8 _REG(r8_x86_64), pointer_or_number64_t register_r9 _REG(r9_x86_64)) {
  artificial_struct_returned_by_rawfunction_22 _var_0;
  *((generic64_t *) (((__init_local_sp() + 8) & 0xFFFFFFFFFFFFFFF0) - 16)) = ((__init_local_sp() + 8) & 0xFFFFFFFFFFFFFFF0) - 8;
  _var_0 = ((rawfunction_22 *) ((pointer_or_number64_t) &segment_0x401000_Generic64_474765.unreserved__text + 16240))(0, __init_local_sp() + 8, *((generic64_t *) __init_local_sp()), (pointer_or_number64_t) &segment_0x401000_Generic64_474765.unreserved__text + 10523, 0, register_rdx);
}

