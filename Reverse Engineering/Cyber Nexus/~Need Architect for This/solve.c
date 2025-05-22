#include <stdint.h>
#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>

struct Node {
  struct Node* next;
  int8_t data;
};

struct Node* head;
//char input[] = {(char)237, (char)255, (char)255, (char)255, (char)72, (char)255, (char)255, (char)255, (char)64, (char)246, (char)220, (char)111, (char)64, (char)214, (char)220, (char)110, (char)64, (char)214, (char)220, (char)110, (char)64, (char)214, (char)212, (char)110, (char)64, (char)212, (char)148, (char)110, (char)0, (char)212, (char)148, (char)106, (char)0, (char)212, (char)148, (char)106, (char)0, (char)212, (char)148, (char)42, (char)0, (char)208, (char)148, (char)42, (char)0, (char)128, (char)148, (char)42, (char)0, (char)128, (char)148, (char)42, (char)0, (char)0, (char)148, (char)42, (char)0, (char)0, (char)148, (char)42, (char)0, (char)0, (char)144, (char)42, (char)0, (char)0, (char)144, (char)42, (char)0, (char)0, (char)128, (char)42, (char)0, (char)0, (char)128, (char)42, (char)0, (char)0, (char)0, (char)42, (char)0, (char)0, (char)0, (char)40, (char)0, (char)0, (char)0, (char)40, (char)0, (char)0, (char)0, (char)40, (char)0, (char)0, (char)0, (char)40, (char)0, (char)0, (char)0, (char)32, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0, (char)0};
int data[] = {48, 48, 48, 48, 49, 51, 52, 52, 67, 68, 69, 71, 78, 83, 83, 85, 88, 89, 95, 95, 95, 95, 99, 104, 111, 111, 111, 114, 115, 116, 116, 117, 123, 125};
int magic = 34;
//char* in = input;
char* input = "Hello World!";

void record() {

}

void xor() {
  if (head->next != NULL) {
    if (head->next->data < head->data) {
      head->next->data = head->data ^ head->next->data;
      head->data = head->next->data ^ head->data;
      head->next->data = head->data ^ head->next->data;
      record();
    }
    head = head->next;
    magic = magic + 1;
    if (7 < magic) {
      ++input;
      magic = 0;
    }
    xor();
  }
}

void sort(struct Node* node) {
  magic = magic + -1;
  if (0 < magic) {
    sort(node);
    xor();
  }
  head = node;
}

void create_linked_list() {
  struct Node *node;
  struct Node *next;
  unsigned long i;
  
  node = malloc(0x10);
  head = node;
  node->data= 0;
  node->next = NULL;
  for (i = 0; i < 34; i = i + 1) {
    next = malloc(0x10);
    next-> data = data[i];
    next->next = NULL;
    for (; head->next != NULL; head = head->next) {}
    head->next = next;
  }
  head = node;
}

int main(int argc, char** argv) {
  create_linked_list();
  sort(head);
  for (; head->next != NULL; head = head->next) {
    printf("%c", head->data);
  }

  
}

// 00001344CDEGNSSUXY____chooorsttu{}
