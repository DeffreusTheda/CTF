#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void encrypt(long long content,int len, const char *data) {
  char bVar1;
  size_t data_len;
  unsigned long long idx2;
  char data_long [256];
  unsigned char indexes [256];
  unsigned int tmp;
  int jdx;
  int offset;
  int idx;

  printf("initalizing rc4\n");
  offset = 0;
  for (idx = 0; idx < 0x100; idx = idx + 1) {
    indexes[idx] = (char)idx;
    idx2 = (unsigned long long)idx;
    data_len = strlen(data);
    data_long[idx] = data[idx2 % data_len];
  }

  printf("swapping rc4\n");
  for (idx = 0; idx < 0x100; idx = idx + 1) {
    offset = (int)((unsigned int)data_long[idx] + (unsigned int)indexes[idx] + offset) % 0x100;
    bVar1 = indexes[idx];
    indexes[idx] = indexes[offset];
    indexes[offset] = bVar1;
  }
  for (idx = 0; idx < 0x100; idx = idx + 1) {
    printf("%d: %d\n", idx, indexes[idx]);
  }

  printf("xoring rc4\n");
  offset = 0;
  idx = 0;
  for (jdx = 0; jdx < len; jdx = jdx + 1) {
    idx = (idx + 1) % 0x100;
    offset = (int)(offset + (unsigned int)indexes[idx]) % 0x100;
    tmp = (unsigned int)indexes[idx];
    indexes[idx] = indexes[offset];
    indexes[offset] = (char)tmp;
    *(char *)(content + jdx) =
         indexes[(int)(unsigned int)(char)(indexes[offset] + indexes[idx])] ^ *(char *)(content + jdx);
  }
}

void swap_pairs(long long data,int end) {
  char idx;
  char tmp;
  
  for (idx = 0; idx < end + -1; idx = idx + 2) {
    tmp = *(char *)(data + (long long)idx * 8);
    *(char *)(data + (long long)idx * 8) = *(char *)(data + ((long long)idx + 1) * 8);
    *(char *)(((long long)idx + 1) * 8 + data) = tmp;
  }
  printf("success\n");
}

void decrypt(long long content, int len, char *data) {
  char bVar1;
  size_t data_len;
  unsigned long long idx2;
  unsigned char data_long[256];
  unsigned char indexes[256];
  unsigned int tmp;
  int jdx;
  int offset;
  int idx;

  printf("content: %lld\n", content);

  // Initialize indexes and data_long
  printf("initalizing rc4\n");
  offset = 0;
  for (idx = 0; idx < 0x100; idx++) {
    indexes[idx] = (char)idx;
    idx2 = (unsigned long long)idx;
    data_len = strlen(data);
    data_long[idx] = data[idx2 % data_len];
  }

  // Key-scheduling algorithm (KSA)
  printf("swapping rc4\n");
  for (idx = 0; idx < 0x100; idx++) {
    offset = (int)((unsigned int)data_long[idx] + (unsigned int)indexes[idx] + offset) % 0x100;
    bVar1 = indexes[idx];
    indexes[idx] = indexes[offset];
    indexes[offset] = bVar1;
  }

  // Pseudo-random generation and XOR decryption
  printf("decrypting rc4\n");
  offset = 0;
  idx = 0;
  for (jdx = 0; jdx < len; jdx++) {
    idx = (idx + 1) % 0x100;
    offset = (int)(offset + (unsigned int)indexes[idx]) % 0x100;
    tmp = (unsigned int)indexes[idx];
    indexes[idx] = indexes[offset];
    indexes[offset] = (char)tmp;

    // Reverse XOR transformation
    *(char *)(content + jdx) =
        indexes[(int)(unsigned int)(char)(indexes[offset] + indexes[idx])] ^ *(char *)(content + jdx);
    printf("%d", *(char *)(content + jdx));
  }
  putchar('\n');
  printf("success\n");
}

int main() {
    char key[] = "helloworld";
    char plaintext[] = "This is a secret!";
    int len = strlen(plaintext);

    // Allocate memory for encryption
    printf("allocating\n");
    char *encrypted = malloc(len + 1);
    memcpy(encrypted, plaintext, len + 1); // Copy plaintext to encrypted buffer

    // Encrypt the data
    printf("encrypting\n");
    encrypt((long long)encrypted, len, key);
    printf("Encrypted: ");
    for (int i = 0; i < len; i++) {
        printf("%02x ", (unsigned char)encrypted[i]);
    }
    printf("\n");

    // Decrypt the data
    decrypt((long long)encrypted, len, key);
    printf("Decrypted: %s\n", encrypted);

    printf("\nOKAY\n\n");

    char* flag = "\000\025]\000\002\000\000\025]g\250\250\b\000E\000\004\034\357\237\000\000\200\001\000\000\300\250K1{o\352E\b\000$v@\003\001\000\f\nYx\033\a\270\3535\322X\252\304\3544q\254\201v\325:\204s\205V\374\276\v\227\017\272\252\203\351X\231\212\3556l\372\226~\aQ\353\326\226;F\367=\323\2027\315\001\264\351\002\302,\217\235b\374\a\017C\"\322\213`\376\205z\374\002\022\347\204F#\364)\367\v\001\317L\332\030\003\310\006\325\251@\261w\237\371\201O@C\376\224\an\202\265Qm\022\206/\371\356]Q\355\016\020g\177\223\274\022\367N\024p\a\247aM|\225|\210\005\214\354\037\207\303w\347\354F\027\354\361\326\361\203\270\202zbU\235%\314\"\031.\347\354s;b\351\224\357$\266!\324\263\256U\317\353\247E\372\373\274\245\022\211=7a\3012=\036eZ\243\230&\377\345\370v\303\226@\362\006\336\333k\367\\\232\326\034\245}\206j\032%8\266\237\272>\330Vi#0#\024\336k\0171\231'G\224P\2527G\345\304h\327\276(1/\351M(\331\202\204\357\021\375.\317\234\306\\+\023s\346\016\306\301\2756`\270\030\251\242\341\272\310q\3106\264\203\273Wky\232\270O\345,\233=\335\340>koCpfE\241\362\004\304t\273M\252\177\230\037\f\206\036\361\tA\2130f\277\3003g\250\344\324\301]1\327\344\272\251\254\231\326\370-$\203\t\363\351.\245@\260R\242\363\215\256\3779b\265\305\301-\202\243/\264\275l'N?Z\217\rg\322\243T_\276\317\031\3613C\002\342\256g\274~\033\217\361;\273\342.\316\253\v\353R\323:\373\371\r)\263\"\bD\033E\243\201\303\024\353r:\332\211Yz\243(Go\177\317\v\227\330F\320m\333\a\342\323KO\332\304\343\"\2268\341y$\304\201\200\332{\215\\\031Q1\236#\323\205\027\t\351\306\305\342P\265D\352\302>\262L?\024\017 \vo\274\026\326#vP\310\314\251\2607\263\016\017\3066\253\317\311\24768o\256\350b\231\217r\273\025\035\r\004.H\315f\216\257\257\361\346\027C\321\364\345\353\371\2418J\327\227+\374\261\373\2341\r\246g\271\260&\262\215`\303,\371\377\027\242\261o\205\272{:#\326\246\336\236\314\244\256\235d\320\314\337{\252\226\226\214;\217\253\323\325+\345d\352M\261\363\236\226O_\031g\021\343\277\351>\232N\235\230\321 \205\377\207\256\024\252\031;\030\311\345\246\257(\203\370\244\364S(\220\377\271\021\030d\306\276{\355\343\367\233\245\026\363q'\177.`\a\023\300~\332Yd\357\355\356\235\207\340\325-\302}\205`\344\376\216\232\270\324\207(7_Gz^j\v\202\203\357\303}\3256v\036C;\220\311\000\202\230X\r\001A\354\227@Y\024N\300\306\360\006\020c\036\307\246h\\\325\346%h\230\333V8~\337\024\253\306N\270\303\033\314\305\220\a\303$\201\350\210\313d<\017\020\306\033M\235uY\352\037~\363\250\000\031r\334\034y!72\017}\272~+\240$\205S\266\255\355\\al\234\346h4\272:\331\201\267\a\ae\312\341o\256\306\277\f\222g'D\036\355'\b\001=\227%2\244\264D\240c0\"\235\351\025\346\217\276\352Zq\021\244j\023\215\0357\030*DR\005\331\232\203\337\241\304K\363z@\276c\306O>\313\333C\377\270\263\366\232\373\351\317\201d\003,\254\020<K?\201]\307'\216\266d\304\243\363\025\227\367\020\f\335v\016\n\247\357\360\331L\327yH\273?G\v\346_\272\340\ty\251\301<\266\377\335\367\374&\242@jA\001\235\031\366/\376\360\313\215A\312U\nN.L\361\321\264\207\022`\344\313\364V\024\374\214\313\342\324z\326\257Q!+\n\252\334]\374)X\340\277X\312\024`\346\362\367\351\343O\237\265\237\026l\223\210\325FTfT#\377";
    int flag_len = strlen(flag);

    // Decrypt the flag
    swap_pairs((long long)flag, flag_len);
    decrypt((long long)flag, flag_len, key);
    for (int i = 0; i < flag_len; i++) {
      printf("%c", flag[i]);
    }

    free(encrypted);
    return 0;
}
