#include <stdint.h>
#include <stdio.h>

unsigned long long Pad7Bit(char a1) {
	return a1
		& 1
		| (
				(unsigned long long) (
					a1
					& 0x7F
				)
				<< 32
			)
		& 0x1000000001LL
		| (
				(
					a1
					& 0xF
					| (
							(unsigned long long) (
								a1
								& 0x7F
							)
							<< 32
						)
					& 0x700000000FLL
				)
				<< 16
			)
		& 0x40001000040001LL
		| (
				(
					a1
					& 3
					| (
							(unsigned long long) (
								a1
								& 0x7F
							)
							<< 32
						)
					& 0x3000000003LL
					| (
							(
								a1
								& 0xF
								| (
										(unsigned long long) (
											a1
											& 0x7F
										)
										<< 32
									)
								& 0x700000000FLL
							)
							<< 16
						)
					& 0x400030000C0003LL
				)
				<< 8
			)
		& 0x40201008040201LL;
}

int putb(unsigned long long n) {
    char b[(sizeof n * 8) + 1];
    char *p = b + sizeof b;
    *--p = '\0';
    do {
        *--p = '0' + (n & 1);
    } while (n >>= 1);
    return puts(p);
}
int main() {
	while ( 1 ) {
		char input;
		
		scanf("%c", &input);
		putb(Pad7Bit(input));
	}
}
