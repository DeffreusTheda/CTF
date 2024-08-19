int main(int argc, const char **argv, const char **envp);
int win();
int vuln();

const char aPertamaMasukka[60] = "Pertama, masukkan umur kalian untuk disesuaikan sama input ("; // idb
_UNKNOWN unk_20F4; // weak
const char aDibilangGaBole[34] = "Dibilang ga boleh input 'n'!!!!!! "; // idb
FILE *stdout; // idb
FILE *stdin; // idb
FILE *stderr; // idb

// __fastcall __noreturn
int main(int argc, const char **argv, const char **envp) {
  setvbuf(stdout, 0LL, 2, 0LL);
  setvbuf(stdin, 0LL, 2, 0LL);
  setvbuf(stderr, 0LL, 2, 0LL);
  vuln();
  exit(1);
}

int win() {
  FILE *stream;
  char s[264];

  puts("Semoga masih gampang banged yh");
  if ( stream ) {
		stream = fopen("flag.txt", "r");
    fgets(s, 256, stream);
    return puts(s);
  }
  else {
    printf("File flag.txt does not exist! >:(");
    return 69;
  }
}

int vuln() {
  char buf[24]; // 24 bytes; rbp-0x20

  int v1 = 0; // 4 bytes; rbp-0x34
	char *v4 = buf; // a byte; unused; rbp-0x28 -> rbp-0x18
  puts("Halo, aku Peokra!! Aku bikin program yang bisa nerima input dari kalian.");
	printf(aPertamaMasukka);
  // angr, dewolf, Reko, Relyze, RetDec, rev.ng, & Snowman: format string is "%d"
  __isoc99_scanf(&unk_20F4, &v1);
  v4 += 4 * v1;
  puts("Sekarang input, tapi kalian gak boleh masukin huruf 'n' ya:");
	int v2 = 1; // 4 bytes; rbp-0x30
	for ( int i = 0 /* rbp-0x2c */; i < v1 - 1; ++i ) {
    v1 = read(0, buf, 0x10uLL);
    if ( buf[i] == 110 /* 0x6e; 'n' */ ) {
      v2 = 0;
      break;
    }
  }
  if ( v2 ) {
    printf("Kamu menginput: ");
    return printf(buf);
  } else {
    puts(aDibilangGaBole);
    return 0;
  }
}
