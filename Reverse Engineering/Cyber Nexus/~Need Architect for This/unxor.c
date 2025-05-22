#include <stdio.h>
#include <stdlib.h>

int main() {
  srand(125);

  char output[] = {(char)26, (char)171, (char)94, (char)52, (char)234, (char)236, (char)193, (char)171, (char)8, (char)193, (char)115, (char)139, (char)105, (char)94, (char)41, (char)11, (char)229, (char)89, (char)167, (char)64, (char)31, (char)209, (char)255, (char)24, (char)29, (char)99, (char)170, (char)0, (char)43, (char)18, (char)8, (char)205, (char)76, (char)139, (char)55, (char)56, (char)128, (char)131, (char)28, (char)118, (char)183, (char)195, (char)211, (char)147, (char)71, (char)126, (char)81, (char)165, (char)172, (char)93, (char)238, (char)201, (char)69, (char)173, (char)231, (char)16, (char)46, (char)142, (char)32, (char)1, (char)40, (char)37, (char)13, (char)26, (char)7, (char)230, (char)34, (char)143, (char)209, (char)200, (char)115, (char)249, (char)177, (char)42, (char)114, (char)154, (char)62, (char)134, (char)21, (char)237, (char)93, (char)188, (char)139, (char)115, (char)91, (char)10, (char)113, (char)44, (char)58, (char)239, (char)2, (char)11, (char)226, (char)80, (char)123, (char)243, (char)241, (char)240, (char)78, (char)166, (char)236, (char)232, (char)212, (char)162, (char)66, (char)108, (char)236, (char)108, (char)114, (char)43, (char)217, (char)187, (char)151, (char)78, (char)175, (char)102, (char)132, (char)8, (char)147, (char)51, (char)230, (char)189, (char)62, (char)92, (char)15, (char)145, (char)79, (char)112, (char)148, (char)182, (char)23, (char)16, (char)96, (char)203, (char)178, (char)34, (char)49, (char)158, (char)142, (char)36, (char)159, (char)103, (char)223, (char)54, (char)204, (char)142, (char)157, (char)80, (char)175, (char)48, (char)131, (char)149, (char)197, (char)193, (char)241, (char)212, (char)123, (char)65, (char)69, (char)15, (char)223, (char)92, (char)31, (char)63, (char)71, (char)210, (char)97, (char)120, (char)112, (char)239, (char)156, (char)16, (char)86, (char)124, (char)70, (char)34, (char)10, (char)227, (char)115};

  for (int i = 0; i < 179; ++i) {
    printf("%d, ", output[i] ^ (char)rand());
  }
}
