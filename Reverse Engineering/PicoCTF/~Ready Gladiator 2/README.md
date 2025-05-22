# Ready Gladiator 2 Writeup by Deffreus - PicoCTF 2023

###### Author: LT 'syreal' Jones

## Description

Can you make a CoreWars warrior that wins every single round?<br>Your opponent is the Imp. The source is available here. If you wanted to pit the Imp against himself, you could download the Imp and connect to the CoreWars server like this:

`nc saturn.picoctf.net 63232 < imp.red`

To get the flag, you must beat the Imp all 100 rounds.

<details><summary>Hint 1</summary>
If your warrior is close, try again, it may work on subsequent tries... why is that?
</details>

## Solution

I've read the solution from [here](https://medium.com/@khanzjoel55/picoctf-2023-writeups-2521309bf3c8) and I feel like the explanation is not enough.

```
;redcode
;name warrior
;assert 1
jmp 0,<-2
end
```

The warrior only consist of `jmp 0,<-2`.
This instruction does two things in each cycle:<br>
It jumps to itself (jmp 0), creating an infinite loop;<br>
It decrements the B-field of the instruction located two addresses before it (<-2)<br>
The B-field is the `1` in `mov 0, 1`.

The killer part is the `<-2` part. This is a pre-decrement indirect addressing mode.
As the warrior executes, it continuously decrements memory locations in the core, moving backwards.
Eventually, it will decrement the instruction of the imp (`mov 0, 1`), changing it to `mov 0, 0`.
Once the imp's instruction becomes `mov 0, 0`, the imp effectively stops moving and starts overwriting itself in the same location.
This allows the warrior to continue decrementing core locations undisturbed,
eventually hitting the imp again and further corrupting it.
Effie will continue running indefinitely, while the imp is rendered ineffective.

The reason this warrior is so effective against the imp is that:

- It runs at the same speed as the imp (one instruction per cycle).
- It modifies the core in a way that eventually disrupts the imp's operation.
- Once it has modified the imp, it continues running without being affected by the now-stationary imp.

This strategy is particularly effective against the basic imp because the imp has no defense mechanism and its simple operation is easily disrupted by core modification.

```
$ nc saturn.picoctf.net 49867
Submit your warrior: (enter 'end' when done)

;redcode
;redcode
;name Effie
;name Effie
;assert 1
;assert 1
jmp 0,<-2
jmp 0,<-2
end
end
Warrior1:
;redcode
;name Effie
;assert 1
jmp 0,<-2
end

Rounds: 100
Warrior 1 wins: 100
Warrior 2 wins: 0
Ties: 0
You did it!
picoCTF{d3m0n_3xpung3r_47037b25}
```

Got the flag!

FLAG: `picoCTF{d3m0n_3xpung3r_47037b25}`
