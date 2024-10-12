#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

#define FLAGSIZE_MAX 64
#define INPUT_DATA_SIZE 11
#define SAFE_VAR_SIZE 11
#define SERVER_IP "147.79.68.192" 
#define SERVER_PORT 12345  

char *safe_var;
char *input_data;

void get_flag_from_server() {
    int client_socket;
    struct sockaddr_in server_addr;
    char buffer[FLAGSIZE_MAX] = {0};

    // Buat socket
    client_socket = socket(AF_INET, SOCK_STREAM, 0);
    if (client_socket < 0) {
        perror("Gagal membuat socket");
        exit(1);
    }

    // Set alamat server
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(SERVER_PORT);
    server_addr.sin_addr.s_addr = inet_addr(SERVER_IP);

    // Koneksi ke server
    if (connect(client_socket, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0) {
        perror("Koneksi ke server gagal");
        close(client_socket);
        exit(1);
    }

    // Minta flag dari server
    send(client_socket, "GET_FLAG", strlen("GET_FLAG"), 0);

    // Terima flag dari server
    recv(client_socket, buffer, FLAGSIZE_MAX, 0);
    printf("Flag: %s\n", buffer);

    // Tutup koneksi
    close(client_socket);
}

void check_win() {
    if (strcmp(safe_var, "@techtonic") != 0) {
        printf("\nSelamat! Kamu telah mengubah safe_var!\n");
        
        // Mengambil flag dari server
        get_flag_from_server();
        
        exit(0);
    } else {
        printf("Lebih semangat lagi! hehe\n");
        printf("\nBelum ada flag buat kamu :(\n");
    }
}

void print_menu() {
    printf("\n1. Cetak Heap:\t\t(cetak keadaan heap saat ini)"
           "\n2. Tulis ke buffer:\t(tulis ke blok data pribadi kamu di heap)"
           "\n3. Cetak safe_var:\t(Lihat variabel safe_var di heap)"
           "\n4. Cetak Flag:\t\t(Coba cetak flag, semoga berhasil)"
           "\n5. Keluar\n\nMasukkan pilihan kamu: ");
    fflush(stdout);
}

void init() {
    printf("\nSelamat datang di TechTonic!\n");
    printf("Aku meletakkan data ku di heap, jadi seharusnya aman dari exploit :D.\n\n");
    
    input_data = malloc(INPUT_DATA_SIZE);
    if (!input_data) {
        perror("Failed to allocate memory for input_data");
        exit(1);
    }
    strncpy(input_data, "TechTonic", INPUT_DATA_SIZE);
    
    safe_var = malloc(SAFE_VAR_SIZE);
    if (!safe_var) {
        perror("Failed to allocate memory for safe_var");
        exit(1);
    }
    strncpy(safe_var, "@techtonic", SAFE_VAR_SIZE);
}

void write_buffer() {
    printf("Data for buffer: ");
    fflush(stdout);
    scanf("%s", input_data);
}

void print_heap() {
    printf("Heap State:\n");
    printf("+-------------+----------------+\n");
    printf("[*] Address   ->   Heap Data   \n");
    printf("+-------------+----------------+\n");
    printf("[*]   %p  ->   %s\n", input_data, input_data);
    printf("+-------------+----------------+\n");
    printf("[*]   %p  ->   %s\n", safe_var, safe_var);
    printf("+-------------+----------------+\n");
    fflush(stdout);
}

int main(void) {
    init();
    print_heap();

    int choice;

    while (1) {
        print_menu();
        int rval = scanf("%d", &choice);
        if (rval == EOF) {
            exit(0);
        }
        if (rval != 1) {
            exit(0);
        }

        switch (choice) {
        case 1:
            print_heap();
            break;
        case 2:
            write_buffer();
            break;
        case 3:
            printf("\n\nLihat variabel safe_var: %s\n\n", safe_var);
            fflush(stdout);
            break;
        case 4:
            check_win();
            break;
        case 5:
            return 0;
        default:
            printf("Pilihan tidak valid.\n");
            fflush(stdout);
        }
    }
}
