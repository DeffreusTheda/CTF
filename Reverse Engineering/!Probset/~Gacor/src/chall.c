#include <stdio.h>
#include <string.h>
#include <stdint.h>
#include <time.h>
#include <stdlib.h>

#define SOLVER  0

typedef struct {
  uint8_t color : 1; // 0 = black, 1 = red
  uint8_t suit  : 2; // 0 = clubs, 1 = diamonds, 2 = hearts, 3 = spades
  uint8_t rank  : 4; // 0 = Cat, 1 = ace, 2-10 = numeric, 11 = jack, 12 = king, 13 = queen, 14 = hero, 15 = hengker
} Card;

struct tm *tm_struct;

Card charToCard(char c) {
  Card card;

  if (((c >> 7) & 1) == 1) {
    perror("IRChat has crashed.\n");
    exit(1);
  }
  
  card.color = c & 0x01;       // 1st bit for color
  card.suit = (c >> 1) & 0x03; // 2nd-3rd bits for suit
  card.rank = (c >> 3) & 0x0F; // 4th-7th bits for rank
  
  return card;
}

#if SOLVER == 1
char cardToChar(Card card) {
  return (card.rank) << 3 | (card.suit << 1) | card.color;
}
#endif

// Returns positive if a > b, negative if a < b, 0 if equal
int compareCards(const Card *a, const Card *b) {
  if (a->suit != b->suit) {
    return b->suit - a->suit;
  }
  
  return b->rank - a->rank;
}

void selectionSort(Card *cards, int n) {
  int i, j, maxIdx;
  Card temp;
  FILE* hidden = fopen(".effie", "w");
  if (!hidden) {
    fprintf(stderr, "%d:%d:%d   effie  broohh let me play :<\n", tm_struct->tm_hour, tm_struct->tm_min, tm_struct->tm_sec);
    fclose(hidden);
    exit(1);
  }
  
  for (i = 0; i < n - 1; i++) {
    maxIdx = i;
    
    for (j = i + 1; j < n; j++) {
      if (compareCards(&cards[maxIdx], &cards[j]) < 0) {
        maxIdx = j;
      }
    }

    fprintf(hidden, "%c", maxIdx);
    
    if (maxIdx != i) {
      temp = cards[i];
      cards[i] = cards[maxIdx];
      cards[maxIdx] = temp;
    }
  }
  
#if SOLVER == 1
  printf("sort: ");
  for (i = 0; i < n; ++i) {
    printf("%c", cardToChar(cards[i]));
  }
  putchar('\n');
#endif

  fclose(hidden);
}

#if SOLVER == 1
void solve(Card *cards, int n) {
  // player should be able to construct the card themselves
  // they might pre-process the cards into char
  
  FILE* hidden = fopen(".effie", "r");
  if (!hidden) {
    perror(".effie is offline\n");
    return;
  }
  for (int i = 0; i < n; ++i) {
    Card card = cards[i];
    printf("%d|%2d|%d\n", card.color, card.rank, card.suit);
  }

  // reverse the selection sort
  for (int i = n - 2; i >= 0; i--) {
    fseek(hidden, i, SEEK_SET);
    
    int maxIdx = fgetc(hidden);
    
    if (maxIdx != i) {
      Card temp = cards[i];
      cards[i] = cards[maxIdx];
      cards[maxIdx] = temp;
    }
  }
  
  fclose(hidden);

  printf("SOLUTION: ");
  for (int i = 0; i < n; ++i) {
    int sign = ((i & 1) == 1) ? 1 : -1;
    char c = cardToChar(cards[i]);
    c = c + (((i % 0xC) + 1) / 2) * sign;
    printf("%c", c);
  }
  putchar('\n');
}
#endif

void printCard(const Card *card) {
  const char *colorNames[] = {"Black", "Red"};
  const char *suitNames[] = {"Clubs", "Diamonds", "Hearts", "Spades"};
  const char *rankNames[] = {"Cat", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Hero", "Hacker", "Queen"};
  
  printf("                 %s\t%s\t%s\n", colorNames[card->color], rankNames[card->rank], suitNames[card->suit]);
}

void disconnect() {
  printf("%d:%d:%d  !  connection error! disconnected from #gamabargabukber\n", tm_struct->tm_hour, tm_struct->tm_min, tm_struct->tm_sec);
}

int main() {
  char flag[256];
  Card cards[256];
  int flagLen;
  time_t now = time(NULL);
  tm_struct = localtime(&now);
  
  printf("%d:%d:%d  !  effie  ~thedaa@user/effie  has joined #gamabargabukber\n", tm_struct->tm_hour, tm_struct->tm_min, tm_struct->tm_sec);
  printf("%d:%d:%d   effie  heyy, anyone wanna play poker? :p\n", tm_struct->tm_hour, tm_struct->tm_min, tm_struct->tm_sec);
  printf("[#gamabargabukber] ");
  if (!fgets(flag, sizeof(flag), stdin)) {
    fprintf(stderr, "you don't wanna play?? >:/\n");
    return 1;
  }
  
  flagLen = strlen(flag);
  if (flagLen > 0 && flag[flagLen - 1] == '\n') {
    flag[--flagLen] = '\0';
  }
  
  for (int i = 0; i < flagLen; i++) {
    if (((flag[i] >> 7) & 1) == 1) {
      printf("%d:%d:%d   effie  HEH what did you just said??? D:\n", tm_struct->tm_hour, tm_struct->tm_min, tm_struct->tm_sec);
      disconnect();
      return 1;
    }
    int sign = ((i & 1) == 0) ? 1 : -1;
    int delta = (((i % 0xC) + 1) / 2) * sign;
    cards[i] = charToCard(flag[i] + delta);
    // printf("%c", flag[i] + delta);
  }
  
  selectionSort(cards, flagLen);
  
  printf("\n%d:%d:%d   effie  okay, whatever! here's the deck!! ;)\n", tm_struct->tm_hour, tm_struct->tm_min, tm_struct->tm_sec);
  for (int i = 0; i < flagLen; i++) {
    printCard(&cards[i]);
  }
  printf("[#gamabargabukber] \n");
  disconnect();

#if SOLVER == 1
  solve(cards, flagLen);
#endif
  
  return 1;
}
