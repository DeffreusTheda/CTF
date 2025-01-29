#include <defs.h>

struct __attribute__((packed)) __attribute__((aligned(1))) struct_runtime // sizeof=0x3B
{
    _QWORD segcode;
    _QWORD segstring;
    _QWORD segheap;
    _QWORD segdata;
    _QWORD data_size;
    _QWORD entry;
    _BYTE gap30[3];
    _DWORD CHOSER;
    _DWORD MAGIC;
};

// Custom _bittest implementation
int _bittest(const int *base, int bit)
{
  if (bit < 0 || bit >= (int)(sizeof(int) * 8)) {
    // Bit out of range
    return -1;
  }

  return (*base >> bit) & 1;
}


unsigned __int8 choose_vm(struct struct_runtime *runtime)
{
  int choose; // edx
  int choose_1; // eax
  int v3; // eax

  choose = runtime->CHOSER;                     // 0x1000
  choose_1 = choose - 0xFF9;                    // 0x7
  if ( choose - 0x1000 >= 0 )
    choose_1 = runtime->CHOSER - 0x1000;
  v3 = *(unsigned __int8 *)(runtime->segdata + (choose_1 >> 3));
  return _bittest(&v3, choose & 7);
}

int main() {
  
}
