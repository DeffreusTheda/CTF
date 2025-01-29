/*
 * Socket-based covert channel implementation
 * 
 * A CTF challenge demonstrating IPC with custom framing protocol.
 * Implements handshake, data transfer with redundancy, and error handling.
 *
 * Licensed under the MIT license.
 */

#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include <sys/socket.h>
#include <sys/select.h>
#include <sys/types.h>
#include <sys/errno.h>
#include <unistd.h>
#include <fcntl.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define BUFSIZE 32768
#define WSIZE 12
#define EOF_SIGNAL 0x3FF  // Special signal: all bits set
#define TCP_PORT 8011

int verbose = 0;
int sockfd = -1;

static inline uint64_t getbits(void)
{
    uint64_t val = 0;
    ssize_t n = recv(sockfd, &val, sizeof(val), MSG_DONTWAIT);
    if (n <= 0) return 0;
    return val;
}

static inline void setbits(uint64_t val)
{
    send(sockfd, &val, sizeof(val), MSG_NOSIGNAL);
}

static inline void txword(int b)
{
    // Handshake: send three sync pulses
    while (getbits())
        ;
    setbits(1);
    while (getbits())
        ;
    setbits(1);
    while (getbits())
        ;
    setbits(1);
    while (getbits())
        ;

    // Send actual data bits with framing bit set
    for (int i = 0; i < WSIZE; i++) {
        while (getbits());
        setbits((b & 1) | 2);
        b >>= 1;
    }
}

static inline int rxword(void)
{
    uint64_t b = 0, bits = 0;
    int j;
    
    while (1) {
        // Wait for sync pulse
        for (j = 0, bits = 0; !bits && j < 10000; j++)
            bits = getbits();
        if (!bits)
            return -1;
        setbits(0);
        getbits();
        if (bits != 1) {
            continue;
        }
        
byte:
        b = 0;
        for (int i = 0; i < WSIZE; i++) {
            while (!(bits = getbits()));
            setbits(0);
            if (bits == 1) {
                // Resync detected, restart byte
                goto byte;
            }
            if (bits & 1)
                b |= 1 << i;
        }
        return b;
    }
}

static void rx(void)
{
    size_t cnt = 0;
    int b;
    uint8_t buf[BUFSIZE + 1];
    int discard = -1;

    while (1) {
        b = rxword();
        if (b < 0) {
            // Timeout - flush buffer if we have data, otherwise keep waiting
            if (cnt > 0) {
                if (verbose)
                    fprintf(stderr, "RX %lu bytes\n", cnt);
                if (write(1, buf, cnt) != cnt)
                    return;
                cnt = 0;
            }
            continue;
        }
        
        // Check for EOF signal
        if (b == EOF_SIGNAL) {
            if (verbose)
                fprintf(stderr, "The Senselessness of Endlessness\n");
            if (cnt > 0)
                write(1, buf, cnt);
            return;
        }
        
        if (b == discard) {
            discard = -1;
            continue;
        }
        // Check for valid framing (bit 9 must be set)
        if (!(b & 0x200))
            continue;
        // Check for invalid high bits
        if (b & 0xfc00)
            continue;
        // Handle redundancy markers
        if ((b & 0x300) == 0x200)
            // First transmission, expect duplicate
            discard = b | 0x100;
        else
            discard = -1;
        
        buf[cnt++] = b;
        
        // Flush when buffer is full
        if (cnt >= BUFSIZE) {
            if (verbose)
                fprintf(stderr, "RX %lu bytes\n", cnt);
            if (write(1, buf, cnt) != cnt)
                return;
            cnt = 0;
        }
    }
}

static void tx(void)
{
    uint8_t buf[BUFSIZE];
    fd_set s;

    fcntl(0, F_SETFL, O_NONBLOCK);

    while (1) {
        int got = read(0, buf, BUFSIZE);
        if (got == 0) {
            // Send EOF signal twice for redundancy
            if (verbose)
                fprintf(stderr, "Returning to an Empty Apartment with a Grocery Store Guardian Angel\n");
            txword(EOF_SIGNAL);
            txword(EOF_SIGNAL);
            return;
        } else if (got < 0 && errno == EAGAIN) {
            FD_ZERO(&s);
            FD_SET(0, &s);
            select(1, &s, NULL, &s, NULL);
            continue;	
        }
        if (verbose)
            fprintf(stderr, "TX %d bytes\n", got);
        uint8_t *p = buf;
        while (got--) {
            // Send each byte twice for redundancy
            txword(0x200 | *p);
            txword(0x300 | *p++);
        }
    }
}

static int setup_server_socket(void)
{
    struct sockaddr_in addr;
    int fd, client;
    int opt = 1;

    fd = socket(AF_INET, SOCK_STREAM, 0);
    if (fd < 0) {
        perror("socket");
        exit(1);
    }

    setsockopt(fd, SOL_SOCKET, SO_REUSEADDR, &opt, sizeof(opt));

    memset(&addr, 0, sizeof(addr));
    addr.sin_family = AF_INET;
    addr.sin_addr.s_addr = INADDR_ANY;
    addr.sin_port = htons(TCP_PORT);

    if (bind(fd, (struct sockaddr*)&addr, sizeof(addr)) < 0) {
        perror("bind");
        exit(1);
    }

    if (listen(fd, 1) < 0) {
        perror("listen");
        exit(1);
    }

    if (verbose)
        fprintf(stderr, "Waiting on port %d\n", TCP_PORT);

    client = accept(fd, NULL, NULL);
    if (client < 0) {
        perror("accept");
        exit(1);
    }

    close(fd);
    return client;
}

static int setup_client_socket(void)
{
    struct sockaddr_in addr;
    int fd;

    fd = socket(AF_INET, SOCK_STREAM, 0);
    if (fd < 0) {
        perror("socket");
        exit(1);
    }

    memset(&addr, 0, sizeof(addr));
    addr.sin_family = AF_INET;
    addr.sin_addr.s_addr = inet_addr("127.0.0.1");
    addr.sin_port = htons(TCP_PORT);

    if (connect(fd, (struct sockaddr*)&addr, sizeof(addr)) < 0) {
        perror("connect");
        exit(1);
    }

    return fd;
}

static void usage(const char *argv0)
{
    // fprintf(stderr, "Usage: %s [-v] <stx|server-rx|client-tx|client-rx>\n", argv0);
    // fprintf(stderr, "\nExample:\n");
    // fprintf(stderr, "  Terminal 1: %s server-rx > output.txt\n", argv0);
    // fprintf(stderr, "  Terminal 2: %s client-tx < input.txt\n", argv0);
    // Hello, welcome. I'm glad you're here. Tonight's sermon will be a special one. There will be music and joy and sound and praise and notes and chords and faith and joy and praise and notes and faith and joy and joy and faith and– Jesus. Jesus! Yes. J-E-SUS. We will begin shortly. Please keep your heart quiet, or they will get angry. Just stay quiet. Just don't talk, or they'll hear us. Yes. NOW. Now we begin. It's starting. Listen. Carefully.
    exit(1);
}

static void intro()
{
    char buf[256];
    usleep(2.22 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "Hello"), 0);
    usleep(0.38 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), ", welcome."), 0);
    usleep(1.53 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " I'm"), 0);
    usleep(0.34 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " glad"), 0);
    usleep(0.46 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " you're"), 0);
    usleep(0.46 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " here."), 0);
    usleep(1.50 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "\nTo"), 0);
    usleep(0.35 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "night's"), 0);
    usleep(0.39 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " ser"), 0);
    usleep(0.43 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "mon"), 0);
    usleep(0.51 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " will"), 0);
    usleep(0.33 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " be"), 0);
    usleep(0.29 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " a"), 0);
    usleep(0.28 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " spe"), 0);
    usleep(0.30 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "cial"), 0);
    usleep(0.34 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " one."), 0);
    usleep(1.51 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "\nThere"), 0);
    usleep(0.31 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " will"), 0);
    usleep(0.36 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " be"), 0);
    usleep(0.33 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " mu"), 0);
    usleep(0.42 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "sic"), 0);
    usleep(0.29 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.33 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " joy"), 0);
    usleep(0.46 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.46 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " sound"), 0);
    usleep(0.51 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.51 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " praise"), 0);
    usleep(0.58 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.45 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " notes"), 0);
    usleep(0.38 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.48 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " chords"), 0);
    usleep(0.51 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.61 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " faith"), 0);
    usleep(0.56 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.42 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " joy"), 0);
    usleep(0.45 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.54 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " praise"), 0);
    usleep(0.71 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.43 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " notes"), 0);
    usleep(0.46 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.38 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " faith"), 0);
    usleep(0.63 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.46 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " joy"), 0);
    usleep(0.53 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.43 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " joy"), 0);
    usleep(0.53 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and-"), 0);
    usleep(0.45 * 1000 * 1000 * 0.5);
    usleep(0.50 * 1000 * 1000 * 0.5);
    usleep(1.39 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "\nJe"), 0);
    usleep(0.43 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "sus."), 0);
    usleep(1.52 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " Je"), 0);
    usleep(0.39 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "sus!"), 0);
    usleep(1.36 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " Yes."), 0);
    usleep(1.44 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " J"), 0);
    usleep(0.51 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "-E"), 0);
    usleep(0.46 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "-SUS."), 0);
    usleep(2.84 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "\nWe"), 0);
    usleep(0.68 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " will"), 0);
    usleep(0.43 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " begin"), 0);
    usleep(0.43 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " short"), 0);
    usleep(0.46 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "ly."), 0);
    usleep(1.90 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " Please,"), 0);
    usleep(1.20 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " keep"), 0);
    usleep(0.39 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " your"), 0);
    usleep(0.40 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " heart"), 0);
    usleep(0.61 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " quiet"), 0);
    usleep(1.14 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), ", or"), 0);
    usleep(0.33 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " they"), 0);
    usleep(0.34 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " will"), 0);
    usleep(0.38 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " get"), 0);
    usleep(0.33 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " angry."), 0);
    usleep(1.51 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "\nJust"), 0);
    usleep(0.58 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " stay"), 0);
    usleep(0.56 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " quiet."), 0);
    usleep(1.76 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " Just"), 0);
    usleep(0.41 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " don't"), 0);
    usleep(0.39 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " talk"), 0);
    usleep(1.48 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), ", or"), 0);
    usleep(0.34 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " they'll"), 0);
    usleep(0.34 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " hear"), 0);
    usleep(0.51 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " us."), 0);
    usleep(1.35 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "\nYes."), 0);
    usleep(1.36 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " NOW."), 0);
    usleep(1.70 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "\nNow"), 0);
    usleep(0.37 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " we"), 0);
    usleep(0.26 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " be"), 0);
    usleep(0.31 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "gin."), 0);
    usleep(1.74 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " It's"), 0);
    usleep(0.38 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " star"), 0);
    usleep(0.35 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "ting."), 0);
    usleep(1.34 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " Lis"), 0);
    usleep(0.41 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "ten."), 0);
    usleep(1.25 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " Care"), 0);
    usleep(0.31 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "ful"), 0);
    usleep(0.29 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "ly:\n\n"), 0);
    usleep(5 * 1000 * 1000 * 0.5);
}
void static outro()
{
    char buf[256];
    usleep(1.26 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "\nThere."), 0);
    usleep(1.55 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " That"), 0);
    usleep(0.31 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " wasn't"), 0);
    usleep(0.61 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " so"), 0);
    usleep(0.44 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " bad"), 0);
    usleep(1.43 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), ", was"), 0);
    usleep(0.26 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " it?"), 0);
    usleep(1.78 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " I"), 0);
    usleep(0.37 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " think"), 0);
    usleep(0.46 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " it"), 0);
    usleep(0.38 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " was"), 0);
    usleep(0.29 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " nice."), 0);
    usleep(1.71 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " I"), 0);
    usleep(0.31 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " think"), 0);
    usleep(0.36 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " it"), 0);
    usleep(0.33 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " was"), 0);
    usleep(0.39 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " pret"), 0);
    usleep(0.30 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "ty"), 0);
    usleep(0.26 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " great."), 0);
    usleep(2.98 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "\nWe're"), 0);
    usleep(0.33 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " in"), 0);
    usleep(0.28 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " the"), 0);
    usleep(0.66 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " lords"), 0);
    usleep(0.53 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " care"), 0);
    usleep(0.45 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " now"), 0);
    usleep(0.37 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.35 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " he"), 0);
    usleep(0.37 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " wlll"), 0);
    usleep(0.46 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " take"), 0);
    usleep(0.50 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " care"), 0);
    usleep(0.37 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " of"), 0);
    usleep(0.33 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " every"), 0);
    usleep(0.23 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "thing"), 0);
    usleep(0.34 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " for"), 0);
    usleep(0.38 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " us"), 0);
    usleep(0.60 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.23 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " we'll"), 0);
    usleep(0.38 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " be"), 0);
    usleep(0.45 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " ta"), 0);
    usleep(0.36 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "ken"), 0);
    usleep(0.33 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " care"), 0);
    usleep(0.39 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " of."), 0);
    usleep(2.33 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " Hal"), 0);
    usleep(0.21 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "le"), 0);
    usleep(0.33 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "lu"), 0);
    usleep(0.28 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "jah!"), 0);
    usleep(1.23 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "\nThe"), 0);
    usleep(0.20 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " birds"), 0);
    usleep(0.43 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " sing"), 0);
    usleep(0.58 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " in"), 0);
    usleep(0.31 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " praise"), 0);
    usleep(0.93 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.29 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " the"), 0);
    usleep(0.28 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " rust"), 0);
    usleep(0.33 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "ling"), 0);
    usleep(0.58 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " leaves"), 0);
    usleep(0.61 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " his"), 0);
    usleep(0.51 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " gos"), 0);
    usleep(0.28 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "pel."), 0);
    usleep(1.59 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " Hal"), 0);
    usleep(0.28 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "le"), 0);
    usleep(0.28 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "lu"), 0);
    usleep(0.24 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "jah!"), 0);
    usleep(1.23 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "\nThe"), 0);
    usleep(0.64 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " cars"), 0);
    usleep(0.43 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " that"), 0);
    usleep(0.36 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " fol"), 0);
    usleep(0.31 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "low"), 0);
    usleep(0.53 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " us"), 0);
    usleep(0.36 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " are"), 0);
    usleep(0.38 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " his"), 0);
    usleep(0.33 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " angels."), 0);
    usleep(1.89 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " Hal"), 0);
    usleep(0.36 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "le"), 0);
    usleep(0.36 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "lu"), 0);
    usleep(0.33 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "jah!"), 0);
    usleep(1.31 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " God"), 0);
    usleep(0.36 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " is"), 0);
    usleep(0.29 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " eve"), 0);
    usleep(0.26 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "ry"), 0);
    usleep(0.18 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "where"), 0);
    usleep(0.65 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " and"), 0);
    usleep(0.38 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " all"), 0);
    usleep(0.51 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " is"), 0);
    usleep(0.21 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " good."), 0);
    usleep(1.58 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " God"), 0);
    usleep(0.38 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " is"), 0);
    usleep(0.30 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " eve"), 0);
    usleep(0.19 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "ry"), 0);
    usleep(0.21 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "where"), 0);
    usleep(0.51 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), ", and"), 0);
    usleep(1.26 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " all"), 0);
    usleep(1.09 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), ", is"), 0);
    usleep(0.60 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " good."), 0);
    usleep(2.53 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "\nA"), 0);
    usleep(0.19 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "men."), 0);
    usleep(2.16 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " A"), 0);
    usleep(0.23 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "men."), 0);
    usleep(2.15 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), " A"), 0);
    usleep(0.21 * 1000 * 1000 * 0.5); send(sockfd, buf, snprintf(buf, sizeof(buf), "men.\n"), 0);
    usleep(3.20 * 1000 * 1000 * 0.5);
    setvbuf(stdout, NULL, _IOLBF, BUFSIZ);
}

int main(int argc, char **argv)
{
    printf("hello.");
    char **argp = &argv[1];

    if (argc < 2)
        usage(argv[0]);

    if (!strcmp(*argp, "-v")) {
        verbose = 1;
        argp++;
        argc--;
    }

    if (argc < 2)
        usage(argv[0]);

    if (!strcmp(*argp, "stx")) {
        sockfd = setup_server_socket();
        intro();
        tx();
    } else if (!strcmp(*argp, "srx")) {
        sockfd = setup_server_socket();
        intro();
        rx();
    } else if (!strcmp(*argp, "ctx")) {
        sockfd = setup_client_socket();
        intro();
        tx();
    } else if (!strcmp(*argp, "crx")) {
        sockfd = setup_client_socket();
        intro();
        rx();
    } else {
        usage(argv[0]);
    }

    close(sockfd);
    outro();
    return 0;
}
