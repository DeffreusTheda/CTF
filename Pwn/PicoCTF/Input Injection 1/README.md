Author: Yahaya Meddy

A friendly program wants to greet you… but its goodbye might say more than it should. Can you convince it to reveal the flag?

connect to the challenge instance nc amiable-citadel.picoctf.net 54543. You can Download the program file here. And source code

## Solution

This is a buffer overflow into another buffer:
```
@ fun function
name_buffer[10]
cmd_buffer[10]
```
But, there is `fgets(name, 200, stdin)`, so yeah.
`name` is defined as `char name[208]`,
but it's `strcpy`ed to a buffer of size 10 in the `fun` function.
I inputted `THISISCMD!ls` and remote shows `flag.txt`.
Next, do `THISISCMD!cat flag.txt`.
