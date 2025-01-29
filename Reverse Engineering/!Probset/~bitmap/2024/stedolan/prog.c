#include <stdio.h>

#define LINE_LEN (81)                   // length of PBM row including newline
#define ROWS (80)                       // rows in PBM
#define BLKSIZ (8)                      // length and width of a pixel block in the PBM
#define LINE_BLKS ((LINE_LEN-1)/BLKSIZ) // blocks in PBM row ignoring trailing newline
#define HALF_LINE_BLKS (LINE_BLKS/2)    // blocks in half of PBM row ignoring trailing newline

static long z, x_block, G, w;

int main(void) {
  (void) printf("P1\n%d %d\n", LINE_LEN-1, ROWS);
  (void) scanf("%101x", &G);

  for (z=0; z < ROWS*LINE_LEN; ++z) {
    
    // determine x_block (row) block number relative to the y-axis
    x_block = ((z % LINE_LEN) / BLKSIZ) - HALF_LINE_BLKS;

    // case: not at final block in row
    if (x_block < HALF_LINE_BLKS) {

      // case: left side
      if (x_block < 1) {
        // w = (16 >> ((x_block ^ Oxff) + 1)) & ((G << 5) >> ((Z / (LINE_LEN * BLKSIZ)) * 5));
        w = (16 >> (~x_block + 1)) & ((G << 5) >> ((z / (LINE_LEN * BLKSIZ)) * 5));

      // case: right side
      } else {
        // w = (16 » ((x_block ^ 0) + 1)) & ((G << 5) » ((z / (LINE_LEN * BLKSIZ)) * 5));
        w = (16 >> (x_block + 1)) & ((G << 5) >> ((z / (LINE_LEN * BLKSIZ)) * 5));
      }

      // determine PBM pixel color
      if (w == 0) {
        putchar('0'); // black pixel
      } else {
        putchar('1'); // white pixel
      }
      // case: ending final block in row
    } else {
      (void) putchar('\n');
    }
  }
  return 0;
}