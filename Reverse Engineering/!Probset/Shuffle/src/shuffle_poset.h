#ifndef SHUFFLE_POSET_H
#define SHUFFLE_POSET_H

////////////////////////////////
// Types

typedef struct POSET_Pair{
  struct POSET_Pair *next;
  U32 ls;
  U32 gr;
} POSET_Pair;

typedef struct POSET_Loose{
  POSET_Pair *first;
  POSET_Pair *last;
  U64 pair_count;
  U32 element_count;
} POSET_Loose;

typedef struct POSET{
  S8 *compare;
  U32 element_count;
} POSET;

typedef struct DISTRIBUTION_Bucket{
  struct DISTRIBUTION_Bucket *next;
  struct DISTRIBUTION_Bucket *next_hash;
  U32 *order;
  U32 hash;
  F32 weight;
} DISTRIBUTION_Bucket;

typedef struct DISTRIBUTION{
  DISTRIBUTION_Bucket *first;
  DISTRIBUTION_Bucket *last;
  DISTRIBUTION_Bucket *buckets[32];
  U32 element_count;
  U32 bucket_count;
} DISTRIBUTION;

typedef struct TEST{
  POSET *poset;
  DISTRIBUTION *distribution;
} TEST;

////////////////////////////////
// Functions

// poset

function POSET_Loose* poset_new(Arena *arena, U32 element_count);
function void         poset_order(Arena *arena, POSET_Loose *poset, U32 ls, U32 gr);
function POSET*       poset_bake(Arena *arena, POSET_Loose *loose);

function U32* poset_topological_sort(Arena *arena, POSET *poset);
function U32* poset_shuffle(Arena *arena, PRNG *prng, POSET *poset);

// distribution

function DISTRIBUTION* distribution_new(Arena *arena, U32 element_count);
function void          distribution_add(Arena *arena, DISTRIBUTION *distribution, F32 weight, ...);
function void          distribution_add_order(Arena *arena, DISTRIBUTION *distribution, F32 weight, U32 *order);
function void          distribution_normalize(DISTRIBUTION *distribution);
function void          distribution_sort(DISTRIBUTION *distribution);
function S32           distribution_bucket_compare(void *a, void *b, void *udata);

// test cases

function TEST  make_test1(Arena *arena);
function POSET*make_big_poset(Arena *arena);

#endif //SHUFFLE_POSET_H
