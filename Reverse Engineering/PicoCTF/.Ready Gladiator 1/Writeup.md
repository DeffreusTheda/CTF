# Ready Gladiator 1 Writeup by Deffreus - PicoCTF 2023

So, this is the CoreWars, eh?
Seems like here, bombing your enemies is a prominent strategy.
Who doesn't like explosion?

Warriors in CoreWars, aren't that intelligent on their own,
but they're absolutely obedient to their master.
I mean like, it's their creator, after all.
But, there's no rule that say I can't yoink a warrior from who knows where.
Aight! Let's just throw whatever we found to the vile Imp!

I'll try with the old Dwarf made by A. K. Dewdney, which said to "Bombs every fourth instruction".

```dwarf.red
ORG     1          ; Indicates execution begins with the second
                   ; instruction (ORG is not actually loaded, and is
                   ; therefore not counted as an instruction).
DAT.F   #0, #0     ; Pointer to target instruction.
ADD.AB  #4, $-1    ; Increments pointer by step.
MOV.AB  #0, @-2    ; Bombs target instruction.
JMP.A   $-2, #0    ; Loops back two instructions.
```

```$ nc saturn.picoctf.net 50150 < dwarf.red 
Warrior1:
;redcode
;name Dwarf
;assert 1
dat.f #0, #0
dat.f   #0, #0
add.ab  #4, $-1
mov.ab  #0, @-2
jmp.a   $-2, #0
end

Rounds: 100
Warrior 1 wins: 0
Warrior 2 wins: 100
Ties: 0
Try again. Your warrior (warrior 1) must win at least once.
```

Terrible.
It always lose.
After consultation with Count Claude 3.5 Sonnet, we've decided to unleash the Stone warrior upon the imp!
We will step by set the step value to 420!

Let's see...

```$ nc saturn.picoctf.net 50150 < stone.red
Warrior1:
;redcode
;name Stone
;assert 1
        org     start
step    equ     420
start   mov.i   #step, @step
        add.ab  #step, $start
        jmp     $start-1
        dat     #0, #0
end

Rounds: 100
Warrior 1 wins: 0
Warrior 2 wins: 100
Ties: 0
Try again. Your warrior (warrior 1) must win at least once.
```

The fuck!
What is this Imp?
This is a great threat, I need stronger warrior!
This time, the titled: "Count Claude's Redeemed Arsenal", I'll unleash: Silklet!

```$ nc saturn.picoctf.net 57537
Submit your warrior: (enter 'end' when done)

Warrior1:
;redcode
;name Silklet
;assert 1
	org	start
step	equ	1800
copies	equ	10
start	spl	1,	<-200
	spl	1,	<-300
	mov.i	-1,	0
silk	spl	@0,	}step
	mov.i	}-1,	>-1
cnt	djn.f	silk,	<-1151
bomba	dat	>2667,	>5334
for	copies-4
	mov.i	bomba,	}bombs
rof
bombs	dat	0,	0
end

Rounds: 100
Warrior 1 wins: 58
Warrior 2 wins: 0
Ties: 42
You did it!
picoCTF{1mp_1n_7h3_cr055h41r5_0b0942be}
```
Amusing.
Such a magnificent showcase of strength!
I like it!
Be my servant!
I wanna see how well this guy scale up with upcoming challenges.
