/*
**
** Shuffle Poset Implementation & Test
**
*/

#include "mr4th_base.h"
#include "mr4th_base.stdio.h"
#include "mr4th_keywords.h"
#include "mr4th_prng.h"

#include "shuffle_poset.h"

#include "mr4th_base.c"
#include "mr4th_prng.c"

////////////////////////////////
// Functions

// poset

function POSET_Loose*
poset_new(Arena *arena, U32 element_count){
  POSET_Loose *poset = push_array(arena, POSET_Loose, 1);
  poset->element_count = element_count;
  return(poset);
}

function void
poset_order(Arena *arena, POSET_Loose *poset, U32 ls, U32 gr){
  Assert(ls < poset->element_count);
  Assert(gr < poset->element_count);
  
  POSET_Pair *pair = push_array(arena, POSET_Pair, 1);
  SLLQueuePush(poset->first, poset->last, pair);
  poset->pair_count += 1;
  pair->ls = ls;
  pair->gr = gr;
}

function POSET*
poset_bake(Arena *arena, POSET_Loose *loose){
  U32 element_count = loose->element_count;
  POSET *poset = push_array(arena, POSET, 1);
  S8 *compare_grid = push_array(arena, S8, element_count*element_count);
  
  // write pairs into compare grid
  for (POSET_Pair *pair = loose->first;
       pair != 0;
       pair = pair->next){
    compare_grid[pair->ls + pair->gr*element_count] = -1;
    compare_grid[pair->gr + pair->ls*element_count] = +1;
  }
  
  // close the graph paths
  for (;;){
    B32 update = 0;
    for (U32 i = 0; i < element_count; i += 1){
      for (U32 j = i + 1; j < element_count; j += 1){
        for (U32 k = j + 1; k < element_count; k += 1){
          if (compare_grid[i + j*element_count] < 0 &&
              compare_grid[j + k*element_count] < 0){
            if (compare_grid[i + k*element_count] == 0){
              compare_grid[i + k*element_count] = -1;
              compare_grid[k + i*element_count] = +1;
              update = 1;
            }
          }
        }
      }
    }
    if (!update){
      break;
    }
  }
  
  poset->compare = compare_grid;
  poset->element_count = element_count;
  return(poset);
}

function U32*
poset_topological_sort(Arena *arena, POSET *poset){
  U32 element_count = poset->element_count;
  
  // initialize array {0,...,n-1}
  U32 *array = push_array(arena, U32, element_count);
  for (U32 i = 0; i < element_count; i += 1){
    array[i] = i;
  }
  
  // topological sort
  for (U32 i = 0; i + 1 < element_count; i += 1){
    U32 j = i;
    U32 je = array[j];
    for (U32 k = j + 1; k < element_count; k += 1){
      U32 ke = array[k];
      if (poset->compare[je + ke*element_count] > 0){
        j = k;
        je = ke;
      }
    }
    Swap(U32, array[i], array[j]);
  }
  
  return(array);
}

function U32*
poset_shuffle(Arena *arena, PRNG *prng, POSET *poset){
  U32 element_count = poset->element_count;
  U32 *array = poset_topological_sort(arena, poset);
  
  F32 n = (F32)element_count;
  F32 t = (4.f/(pi_F32*pi_F32)*n*n*n*ln_F32(n));
  U64 num_swaps = (U64)ceil_F32(t);
  U64 num_passes = CeilIntDiv(num_swaps, element_count);
  
  for (U64 p = 0; p < num_passes; p += 1){
    // even pass
    for (U32 i = 0; i + 1 < element_count; i += 2){
      U32 je = array[i];
      U32 ke = array[i + 1];
      if (poset->compare[je + ke*element_count] == 0 &&
          prng_roll_bounded(prng, 2)){
        Swap(U32, array[i], array[i + 1]);
      }
    }
    
    // odd pass
    for (U32 i = 1; i + 1  < element_count; i += 2){
      U32 je = array[i];
      U32 ke = array[i + 1];
      if (poset->compare[je + ke*element_count] == 0 &&
          prng_roll_bounded(prng, 2)){
        Swap(U32, array[i], array[i + 1]);
      }
    }
    
  }
  
  return(array);
}

// distribution

function DISTRIBUTION*
distribution_new(Arena *arena, U32 element_count){
  DISTRIBUTION *distribution = push_array(arena, DISTRIBUTION, 1);
  distribution->element_count = element_count;
  return(distribution);
}

function void
distribution_add(Arena *arena, DISTRIBUTION *distribution, F32 weight, ...){
  ArenaTemp scratch = arena_get_scratch(&arena, 1);
  
  U32 element_count = distribution->element_count;
  U32 *order = push_array(scratch.arena, U32, element_count);
  {
    va_list args;
    va_start(args, weight);
    for (U32 idx = 0; idx < distribution->element_count; idx += 1){
      U32 x = va_arg(args, U32);
      if (x = max_U32){
        break;
      }
      order[idx] = x;
    }
    va_end(args);
  }
  
  distribution_add_order(arena, distribution, weight, order);
  
  arena_release_scratch(&scratch);
}

function void
distribution_add_order(Arena *arena, DISTRIBUTION *distribution, F32 weight, U32 *order){
  U32 element_count = distribution->element_count;
  
  U32 hash = 1337;
  for (U32 idx = 0; idx < element_count; idx += 1){
    hash = (hash << 5) - hash + (idx + 1)*order[idx];
  }
  
  U32 bucket_idx = hash%ArrayCount(distribution->buckets);
  DISTRIBUTION_Bucket *match_bucket = 0;
  for (DISTRIBUTION_Bucket *bucket = distribution->buckets[bucket_idx];
       bucket != 0;
       bucket = bucket->next_hash){
    if (bucket->hash == hash &&
        memcmp(bucket->order, order, sizeof(*order)*element_count) == 0){
      match_bucket = bucket;
      break;
    }
  }
  
  if (match_bucket == 0){
    match_bucket = push_array(arena, DISTRIBUTION_Bucket, 1);
    SLLQueuePush(distribution->first, distribution->last, match_bucket);
    
    U32 *order_cpy = push_array(arena, U32, element_count);
    MemoryCopy(order_cpy, order, sizeof(*order)*element_count);
    
    match_bucket->order = order_cpy;
    match_bucket->hash = hash;
    
    SLLStackPush_N(distribution->buckets[bucket_idx], match_bucket, next_hash);
    
    distribution->bucket_count += 1;
  }
  
  match_bucket->weight += weight;
}


function void
distribution_normalize(DISTRIBUTION *distribution){
  F32 total_weight = 0.f;
  for (DISTRIBUTION_Bucket *bucket = distribution->first;
       bucket != 0;
       bucket = bucket->next){
    total_weight += bucket->weight;
  }
  
  if (total_weight > 0.f){
    F32 norm = 1.f/total_weight;
    for (DISTRIBUTION_Bucket *bucket = distribution->first;
         bucket != 0;
         bucket = bucket->next){
      bucket->weight *= norm;
    }
  }
}

function void
distribution_sort(DISTRIBUTION *distribution){
  ArenaTemp scratch = arena_get_scratch(0, 0);
  
  // flatten buckets
  U32 bucket_count = distribution->bucket_count;
  DISTRIBUTION_Bucket **buckets =
    push_array(scratch.arena, DISTRIBUTION_Bucket*, bucket_count);
  {
    U32 idx = 0;
    for (DISTRIBUTION_Bucket *bucket = distribution->first;
         bucket != 0;
         bucket = bucket->next, idx += 1){
      buckets[idx] = bucket;
    }
  }
  
  // sort
  sort_merge(buckets, sizeof(*buckets), bucket_count,
             distribution_bucket_compare,
             PtrFromInt(distribution->element_count));
  
  // reorder buckets
  distribution->first = 0;
  distribution->last = 0;
  for (U32 i = 0; i < bucket_count; i += 1){
    DISTRIBUTION_Bucket *bucket = buckets[i];
    bucket->next = 0;
    SLLQueuePush(distribution->first, distribution->last, bucket);
  }
  
  arena_release_scratch(&scratch);
}

function S32
distribution_bucket_compare(void *a, void *b, void *udata){
  U32 element_count = (U32)IntFromPtr(udata);
  DISTRIBUTION_Bucket *abucket = *(DISTRIBUTION_Bucket**)a;
  DISTRIBUTION_Bucket *bbucket = *(DISTRIBUTION_Bucket**)b;
  S32 result = memcmp(abucket->order, bbucket->order, sizeof(*abucket->order)*element_count);
  return(result);
}

// tests

function TEST
make_test1(Arena *arena){
  // POSET:
  //   0   1
  //  / \ / \
  // 2   3   4
  // 
  // ORDERS:
  // 01234
  // 01243
  // 01324
  // 01342
  // 01423
  // 01432
  // 02134
  // 02143
  // 10234
  // 10243
  // 10324
  // 10342
  // 10423
  // 10432
  // 14023
  // 14032
  
  ArenaTemp scratch = arena_get_scratch(&arena, 1);
  
  POSET_Loose *poset = poset_new(scratch.arena, 5);
  poset_order(scratch.arena, poset, 0, 2);
  poset_order(scratch.arena, poset, 0, 3);
  poset_order(scratch.arena, poset, 1, 3);
  poset_order(scratch.arena, poset, 1, 4);
  
  DISTRIBUTION *distribution = distribution_new(arena, 5);
  distribution_add(arena, distribution, 1,  0,1,2,3,4);
  distribution_add(arena, distribution, 1,  0,1,2,4,3);
  distribution_add(arena, distribution, 1,  0,1,3,2,4);
  distribution_add(arena, distribution, 1,  0,1,3,4,2);
  distribution_add(arena, distribution, 1,  0,1,4,2,3);
  distribution_add(arena, distribution, 1,  0,1,4,3,2);
  distribution_add(arena, distribution, 1,  0,2,1,3,4);
  distribution_add(arena, distribution, 1,  0,2,1,4,3);
  
  distribution_add(arena, distribution, 1,  1,0,2,3,4);
  distribution_add(arena, distribution, 1,  1,0,2,4,3);
  distribution_add(arena, distribution, 1,  1,0,3,2,4);
  distribution_add(arena, distribution, 1,  1,0,3,4,2);
  distribution_add(arena, distribution, 1,  1,0,4,2,3);
  distribution_add(arena, distribution, 1,  1,0,4,3,2);
  distribution_add(arena, distribution, 1,  1,4,0,3,2);
  distribution_add(arena, distribution, 1,  1,4,0,2,3);
  
  distribution_normalize(distribution);
  
  TEST test = {0};
  test.poset = poset_bake(arena, poset);
  test.distribution = distribution;
  
  arena_release_scratch(&scratch);
  
  return(test);
}

function POSET*
make_big_poset(Arena *arena){
  
  ArenaTemp scratch = arena_get_scratch(&arena, 1);
  
  POSET_Loose *poset = poset_new(scratch.arena, 10);
  for (U32 i = 1; i < 10; i += 1){
    for (U32 j = i + 1; j < 10; j += 1){
      if ((j%i) == 0){
        poset_order(arena, poset, i, j);
      }
    }
  }
  
  POSET *result = poset_bake(arena, poset);
  
  arena_release_scratch(&scratch);
  
  return(result);
}

int main(void){
  Arena *arena = arena_alloc();
  PRNG prng = {0};
  {
    PRNG_Seed seed = {0};
    os_get_entropy(&seed, sizeof(seed));
    prng = prng_init_from_seed(&seed);
  }
  
#if 1
  TEST test1 = make_test1(arena);
  POSET *poset = test1.poset;
#endif
  
#if 0
  POSET *poset = make_big_poset(arena);
#endif
  
#if 0  
  {
    m4_printf("MATRIX:\n");
    U32 element_count = poset->element_count;;
    for (U32 row = 0; row < element_count; row += 1){
      for (U32 col = 0; col < element_count; col += 1){
        S8 v = poset->compare[row + col*element_count];
        if (v < 0){
          m4_printf("-");
        }
        else if (v == 0){
          m4_printf("0");
        }
        else if (v > 0){
          m4_printf("+");
        }
      }
      m4_printf("\n");
    }
    m4_printf("\n");
  }
#endif
  
#if 0  
  {
    U32 *array = poset_topological_sort(arena, poset);
    {
      m4_printf("INITIAL SORT: { ");
      for (U32 i = 0; i < poset->element_count; i += 1){
        m4_printf("%u, ", array[i]);
      }
      m4_printf("}\n");
    }
  }
#endif
  
#if 1
  DISTRIBUTION *test_distribution = distribution_new(arena, poset->element_count);
  
  Arena *test_arena = arena_alloc();
  for (U32 r = 0; r < Million(100); r += 1){
    U32 *array = poset_shuffle(test_arena, &prng, poset);
    distribution_add_order(arena, test_distribution, 1.f, array);
    arena_pop_to(test_arena, 0);
  }
  
  distribution_normalize(test_distribution);
  distribution_sort(test_distribution);
  
  {
    m4_printf("DISTRIBUTION:\n");
    for (DISTRIBUTION_Bucket *bucket = test_distribution->first;
         bucket != 0;
         bucket = bucket->next){
      m4_printf("{ ");
      for (U32 i = 0; i < poset->element_count; i += 1){
        m4_printf("%u, ", bucket->order[i]);
      }
      m4_printf("} - %.5f\n", bucket->weight);
    }
    m4_printf("\n");
  }
#endif
  
  return(0);
}
