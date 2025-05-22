#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void print_check(unsigned char check) {
    printf("Flag's a 🅱️ust, rule %d != vibin.\n", check);
    return;
}

void main() {
    unsigned char ohio[100];
    printf("Enter the flag: ");
    fread(ohio, 100, stdin);
    
    unsigned char rizz = strlen(ohio);
    if (rizz > 0 && ohio[rizz - 1] == '\n') {
        ohio[rizz - 1] = '\0';
        rizz -= 1;
    }

    if(rizz != 51) return print_check(0);
    
    unsigned char boomer[6];
    memcpy(boomer, &ohio, 5);
    if(strcmp(boomer, "udctf") != 0) return print_check(1);

    if(ohio[rizz-1] != 0x7d) return print_check(2);

    if((ohio[5]*4)%102 != 'T') return print_check(3);

    if((ohio[35] &ohio[33]) != 0x69) return print_check(4);

    if(ohio[6] ^ ohio[31]) return print_check(5);

    if((ohio[31] + ohio[35]) != (ohio[6] * 2)) return print_check(6);

    if((ohio[7] == ohio[10]) + (ohio[14] == ohio[23]) + (ohio[28] == ohio[36]) != 3) return print_check(7);

    if(!((ohio[42] == ohio[28]) && (ohio[36] == ohio[23]) && (ohio[10] == ohio[42]))) return print_check(8);

    if(ohio[10] != 0x5f) return print_check(9);

    unsigned char fanum[7] = {0x47, 0x4a, 0x13, 0x42, 0x58, 0x57, 0x1b};
    unsigned char simp[8];
    unsigned char vi[8];
    unsigned char drip[9];
    memcpy(simp, &ohio[29], 7);
    memcpy(vi, &ohio[43], 7);
    memcpy(drip, &ohio[15], 8);
    for (int i = 0; i < 7; i++) {
        simp[i] = fanum[i] ^ simp[i];
    }
    for (int i = 0; i < 7; i++) {
        vi[i] = fanum[i] ^ vi[i];
    }
    for (int i = 0; i < 8; i++) {
        drip[i] = vi[i%7] ^ drip[i];
    }
    
    if(strcmp(simp, "r!zz13r") != 0) return print_check(10);

    if(strcmp(vi, "5ki8idi") != 0) return print_check(11);

    unsigned char woke[9] = {0x40,0x05,0x5c,0x48,0x59,0x0f,0x5a,0x5b,0x00};
    if(strcmp(drip, woke) != 0) return print_check(12);

    if((ohio[24] &ohio[19]) != '0') return print_check(13);

    if((ohio[24] | ohio[27]) != '0') return print_check(14);

    if(ohio[26] != ohio[44]) return print_check(15);

    unsigned char clout[7] = "      ";
    memcpy(clout, &ohio[8], 6);
    for (int i = 0; i < 6; i++) {
        clout[i] = clout[i] + 1;
    }
    unsigned char zest[7] = {0x62,0x6e,0x60,0x75,0x69,0x34,0x00};
    if(strcmp(clout, zest) != 0) return print_check(16);

    unsigned char snack[6] = "     ";
    unsigned char L[6] = {0x05,0x17,0x01,0x01,0x1d,0x00};
    memcpy(snack, &ohio[37], 5);
    for (int i = 0; i < 5; i++) {
        snack[i] = snack[i] ^ zest[i];
    }
    if(strcmp(snack, L) != 0) return print_check(17);

    printf("All rules vi! 😝👉👈 Flag is correct! ✅\n");
    return;
}
