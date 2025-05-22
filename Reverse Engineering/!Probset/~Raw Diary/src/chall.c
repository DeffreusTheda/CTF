#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <string.h>

char* we_listen_we_do_not_judge() {
    char* buffer = NULL;
    size_t capacity = 0;
    size_t length = 0;
    size_t chunk_size = 128;
    int c;
    
    // Read input character by character until EOF
    while ((c = getchar()) != EOF) {
        // Resize buffer if needed
        if (length + 1 >= capacity) {
            capacity += chunk_size;
            char* new_buffer = realloc(buffer, capacity);
            if (!new_buffer) {
                free(buffer);
                return NULL;
            }
            buffer = new_buffer;
        }
        
        // Store character (including newlines)
        buffer[length++] = (char)c;
    }
    
    // Add null terminator if buffer exists
    if (buffer) {
        // Ensure space for null terminator
        if (length + 1 >= capacity) {
            char* new_buffer = realloc(buffer, length + 1);
            if (new_buffer) {
                buffer = new_buffer;
            }
        }
        buffer[length] = '\0';
    } else {
        // Handle empty input
        buffer = malloc(1);
        if (buffer) {
            buffer[0] = '\0';
        }
    }
    
    return buffer;
}

int main() {
  FILE* fflag = fopen("flag.txt", "r");
  if (fflag == NULL) {
    perror("eepy! flag.txt is GONE.\n");
    return 1;
  }
  fseek(fflag, 0L, SEEK_END);
  int flag_len = ftell(fflag);
  fseek(fflag, 0L, SEEK_SET);
  char* flag = malloc(flag_len + 4);
  if (flag == NULL) {
    perror("aaaa! can't malloc D:\n");
    return 1;
  }
  fgets(flag, flag_len, fflag);
  fclose(fflag);

  int t = (int)time(NULL);
  srand(t);
  printf("%d\n", t);

  FILE* encrypted = fopen("output.txt", "w");
  if (encrypted == NULL) {
    perror("what's wrong with you? -_-\n");
    return 1;
  }

  char* vent = we_listen_we_do_not_judge();
  if (!vent) {
    fprintf(stderr, "i'm too tired for this.\n");
    return 1;
  }

  fprintf(encrypted, "\n[%s %s]\n%s\n", __DATE__, __TIME__, vent);

  for (int i = 0; i < flag_len; ++i) {
    char c = flag[i] ^ rand();
    fprintf(encrypted, "%c", c);
  }
  fprintf(encrypted, "\n");

  fclose(encrypted);
}
