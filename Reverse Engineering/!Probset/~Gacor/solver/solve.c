#include <stdio.h>
#include <stdint.h>
#include <time.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
  uint8_t color : 1; // 0 = black, 1 = red
  uint8_t suit  : 2; // 0 = clubs, 1 = diamonds, 2 = hearts, 3 = spades
  uint8_t rank  : 4; // 0 = NULL, 1 = ace, 2-10 = numeric, 11 = jack, 12 = king, 13 = queen, 14 = hero, 15 = hengker
} Card;

struct tm *tm_struct;

char cardToChar(Card card) {
  return (card.rank) << 3 | (card.suit << 1) | card.color;
}

// Returns positive if a > b, negative if a < b, 0 if equal
int compareCards(const Card *a, const Card *b) {
  if (a->suit != b->suit) {
    return b->suit - a->suit;
  }
  
  return b->rank - a->rank;
}

void solve(char *cards, int n) {
  // player should be able to construct the card themselves
  // they might pre-process the cards into char
  
  FILE* hidden = fopen(".effie", "r");
  if (!hidden) {
    perror(".effie is offline\n");
    return;
  }

  // reverse the selection sort
  for (int i = n - 2; i >= 0; i--) {
    fseek(hidden, i, SEEK_SET);
    
    int maxIdx = fgetc(hidden);
    
    if (maxIdx != i) {
      char temp = cards[i];
      cards[i] = cards[maxIdx];
      cards[maxIdx] = temp;
    }
  }
  
  fclose(hidden);

  printf("UNSORTED: ");
  for (int i = 0; i < n; ++i) {
    printf("%c", cards[i]);
  }
  printf("\nSOLUTION: ");
  for (int i = 0; i < n; ++i) {
    int sign = ((i & 1) == 1) ? 1 : -1;
    char c = cards[i];
    c = c + (((i % 0xC) + 1) / 2) * sign;
    printf("%c", c);
  }
  putchar('\n');
}

int main() {
  char flag[256];
  char cards[256];
  char* line;
  size_t len;

  FILE* out = fopen("output.txt", "r");

  // cards to char
  int line_idx = 0;
  while ((line_idx++, getline(&line, &len, out)) != -1) {
    line[strcspn(line, "\n")] = '\0';
    char* card = strtok(line, "\t");
    char c = 0;

    // color
    char* color = strrchr(card, ' ') + 1;
    uint8_t vc = 0;
    if (!strcmp(color, "Red")) {
      vc = 1;
    } else if (!strcmp(color, "Black")) {
      vc = 0;
    } else {
      continue;
    }
    c |= vc;
    printf("|%2x:%5s|", c, color);

    // rank
    char* rank = strtok(NULL, "\t");
    uint8_t vr = 0;
    if (!strcmp(rank, "Cat")) {
      vr = 0;
    } else if (!strcmp(rank, "Ace")) {
      vr = 1;
    } else if (!strcmp(rank, "Jack")) {
      vr = 11;
    } else if (!strcmp(rank, "King")) {
      vr = 12;
    } else if (!strcmp(rank, "Hero")) {
      vr = 13;
    } else if (!strcmp(rank, "Hacker")) {
      vr = 14;
    } else if (!strcmp(rank, "Queen")) {
      vr = 15;
    } else {
      vr = atoi(rank);
    }
    c |= ((vr & 0xF) << 3);
    printf("|%2x:%6s|", c, rank);

    // suit
    char* suit = strtok(NULL, "\t");
    uint8_t vs = 0;
    if (!strcmp(suit, "Clubs")) {
      vs = 0;
    } else if (!strcmp(suit, "Diamonds")) {
      vs = 1;
    } else if (!strcmp(suit, "Hearts")) {
      vs = 2;
    } else if (!strcmp(suit, "Spades")) {
      vs = 3;
    }
    c |= ((vs & 0x3) << 1);
    printf("|%2x:%8s|", c, suit);

    cards[line_idx - 5] = c;
    printf("[%2d] %2d:%2d:%2d = %2x:%c\n", line_idx - 5, vc, vr, vs, c, c);
  }

  solve(cards, line_idx - 4);
  
  return 1;
}