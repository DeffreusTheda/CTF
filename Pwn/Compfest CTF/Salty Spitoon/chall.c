void salty_spitoon(void) {
  puts("Selamat datang di Salty Spitoon, wah ternyata tuan adalah orang paling greget sedunia!😱😱😱");
  puts("Dengan datangnya tamu spesial seperti tuan, kami akan menghidangkan menu spesial kami. Mohon tunggu sebentar, tuan!");
  sleep(3);
  FILE *__stream = fopen("flag.txt","r");
  if ( __stream == (FILE *)0x0 ) {
    puts("Waduh, ternyata menu spesial kami lagi kosong. Mohon maaf, tuan."); // WARNING: Subroutine does not return
    exit(1);
  }
  puts("Terima kasih sudah menunggu. Selamat menikmati menu spesial kami, tuan.");
  while( true ) {
    int result = fgetc(__stream);
    if ( (char)result == -1 )
			break;
    putchar((int)(char)result);
  }
  fclose(__stream);
  puts("\nTerima kasih atas kunjungannya. Mampir lagi ya, tuan!");
  return;
}

int main(void) {
  char buf[60];
  int input;

  setvbuf(stdin,(char *)0x0,2,0);
  setvbuf(stdout,(char *)0x0,2,0);

  while( true ) {
    while( true ) {
      while( true ) {
        puts("\n=-=-=-=-=-=-=-= [MENU] =-=-=-=-=-=-=-=");
        puts("Kamu berada di depan pintu Salty Spitoon...");
        puts("Kafe paling greget di seluruh Bikini Bottom!");
        puts("Apakah kamu termasuk orang yang greget?");
        puts("1. Ya");
        puts("2. Tidak, tapi saya ingin menjadi greget!!! 💪🔥💪🔥");
        puts("3. Mamah, aku takut. Aku mau ke wingstop ajah 😭😭😭😭");
        printf("> ");
        __isoc99_scanf("%d%*c", &input);
        if ( input != 1 )
					break;
        puts("Selamat datang di Salty Spitoon, seberapa greget kamu?!");
        gets(buf);
        puts("Cuih! Kamu tidak greget sama sekali!");
      }
      if ( input != 2 )
				break;
      puts("Kamu memulai perjalananmu untuk menjadi greget...\n");
      puts("Setelah bertapa selama 1000 tahun...");
      puts("Kamu menemukan sebuah harta karun!");
      printf("Berikut isinya: %p\n",main);
    }
    if ( input == 3 )
			break;
    puts("Tolong, pilih opsi yang benar!");
  }
  puts("Kamu tidak greget, pergilah! hush hush");
  return 0;
}

// 0x56264807a334
// 14+16+16+16+10 == 72
