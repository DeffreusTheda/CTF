input length must be a multiple of 5 + 4, or 38 -> 181 (close to 179)?
no, it's 34! $n = 34$

So, it makes a linked list, with head from input[0] to the end of input[N-1]
The link node is the value (8 bytes) then the next pointer (8 bytes)
wait no sorry it's reversed!

```py
# first initial call, len is 0
# this will xors() until it reach the linked list tail!
def xors():
  if current != null:
    if next->value < current->value:
      next->value = current->value ^ next->value
      current->value = next->value ^ current->value
      next->value = current->value ^ next->value
      input->value |= (1 << len & 0x1f)
    current = current->next
    len += 1
    if len >= 8:
      input += 1
      len = 0
    xors()
# at the last xors() call, len will be 
```

this just xor with rand, we just need to find the seed
yeah, find the seed first!
damn, seems hard.
