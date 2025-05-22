// gcc -o chall chall.c

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define DEF_PRINTER(NAME, COLOR)                                                                                       \
    void print_##NAME(char *s)                                                                                         \
    {                                                                                                                  \
        printf("\033[" #COLOR "m%s\033[0m", s);                                                                        \
    }

DEF_PRINTER(black, 30);
DEF_PRINTER(red, 31);
DEF_PRINTER(green, 32);
DEF_PRINTER(yellow, 33);
DEF_PRINTER(blue, 34);
DEF_PRINTER(magenta, 35);
DEF_PRINTER(cyan, 36);
DEF_PRINTER(white, 37);

typedef void (*color_printer)(char *);

typedef struct
{
    color_printer color;
    char text[];
} color_text;

#define NUM_TEXTS 16
#define NUM_COLORS 8

color_text *texts[NUM_TEXTS];
color_printer printers[] = {print_black, print_red,     print_green, print_yellow,
                            print_blue,  print_magenta, print_cyan,  print_white};

void init()
{
    setbuf(stdin, NULL);
    setbuf(stdout, NULL);
    setbuf(stderr, NULL);
    alarm(60);
}

color_printer choose_color()
{
    printf("Available colors:\n");
    print_black("1. Black\n");
    print_red("2. Red\n");
    print_green("3. Green\n");
    print_yellow("4. Yellow\n");
    print_blue("5. Blue\n");
    print_magenta("6. Magenta\n");
    print_cyan("7. Cyan\n");
    print_white("8. White\n");
    printf("Color: ");
    size_t choice;
    scanf("%zu", &choice);
    if (choice - 1 >= NUM_COLORS)
    {
        printf("Invalid color\n");
        return NULL;
    }
    return printers[choice - 1];
}

void create_text()
{
    size_t index, size;
    printf("Index (1-16): ");
    scanf("%zu", &index);
    if (index - 1 >= NUM_TEXTS)
    {
        printf("Invalid index\n");
        return;
    }
    printf("Size: ");
    scanf("%zu", &size);
    color_printer color = choose_color();
    if (color == NULL)
    {
        return;
    }
    texts[index] = malloc(sizeof(color_text) + size - 1);
    printf("Text: ");
    int n = read(STDIN_FILENO, texts[index]->text, size);
    if (texts[index]->text[n - 1] == '\n')
    {
        texts[index]->text[n - 1] = '\0';
    }
    texts[index]->color = color;
    printf("Text %zu created\n", index);
}

void print_text()
{
    size_t index;
    printf("Index (1-16): ");
    scanf("%zu", &index);
    if (index - 1 >= NUM_TEXTS)
    {
        printf("Invalid index\n");
        return;
    }
    if (texts[index] == NULL)
    {
        printf("Text %zu does not exist\n", index);
        return;
    }
    texts[index]->color(texts[index]->text);
    putchar('\n');
}

void delete_text()
{
    size_t index;
    printf("Index (1-16): ");
    scanf("%zu", &index);
    if (index - 1 >= NUM_TEXTS)
    {
        printf("Invalid index\n");
        return;
    }
    if (texts[index] == NULL)
    {
        printf("Text %zu does not exist\n", index);
        return;
    }
    free(texts[index]);
    texts[index] = NULL;
    printf("Text %zu deleted\n", index);
}

void change_color()
{
    size_t index;
    printf("Index (1-16): ");
    scanf("%zu", &index);
    if (index - 1 >= NUM_TEXTS)
    {
        printf("Invalid index\n");
        return;
    }
    if (texts[index] == NULL)
    {
        printf("Text %zu does not exist\n", index);
        return;
    }
    color_printer color = choose_color();
    if (color == NULL)
    {
        return;
    }
    texts[index]->color = color;
    printf("Color %zu changed\n", index);
}

void debug()
{
    system("id");
}

int main()
{
    init();
    while (1)
    {
        printf("1. Create text\n"
               "2. Print text\n"
               "3. Delete text\n"
               "4. Change color\n"
               "5. Exit\n"
               ">> ");
        int choice;
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            create_text();
            break;
        case 2:
            print_text();
            break;
        case 3:
            delete_text();
            break;
        case 4:
            change_color();
            break;
        case 5:
            exit(0);
        default:
            printf("Invalid choice\n");
        }
        putchar('\n');
    }
    return 0;
}
