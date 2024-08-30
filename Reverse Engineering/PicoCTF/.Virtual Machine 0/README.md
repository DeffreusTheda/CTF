# Virtual Machine 0 Writeup by Deffreus - PicoCTF 2023

###### Author: LT 'syreal' Jones

## Description

Can you crack this black box?<br>
We grabbed this design doc from enemy servers: [Download](https://artifacts.picoctf.net/c/361/Virtual-Machine-0.zip). We know that the rotation of the red axle is input and the rotation of the blue axle is output. The following input gives the flag as output: [Download](https://artifacts.picoctf.net/c/361/input.txt).

## Files

```
$ unzip Virtual-Machine-0.zip 
Archive:  Virtual-Machine-0.zip
  inflating: Virtual-Machine-0.dae   
$ file Virtual-Machine-0.dae input.txt 
Virtual-Machine-0.dae: COLLADA model, XML document
input.txt:             ASCII text, with no line terminators
```

`input.txt`:

```
39722847074734820757600524178581224432297292490103995916782275668358702105%
```

`Virtual-Machine-0.dae` is ~1300 lines. I won't show it here.

## Solution

[Source](https://github.com/Cyberguru1/PicoCTF2023_Writeup?tab=readme-ov-file#vm0-100-points)

A Collada file is a type of 3D model file format that is used to represent 3D graphics in a variety of applications.
Here, it shows a driver gear with 40 teeths and another driven gear with 8 teeths. So, if the driver gear makes 1 rotation, the driven gear will make 5 rotations. If you recall we have an input we got from the file we downloaded from the task description. So, if the input is the number of rotations the driver gear this means the driven gear will make 5 times the rotation of the driver gear. This number of rotations for the driven gear is actually encoded.

```
$ python3
>>> x = hex(39722847074734820757600524178581224432297292490103995916782275668358702105*5)
'0x7069636f4354467b67333472355f30665f6d3072335f35636139373832347d'
>>> for i in range(2,len(x),2):
...     print(chr(int(x[i:i+2], 16)), end='')
...
picoCTF{g34r5_0f_m0r3_5ca97824}>>> 
```

FLAG: `picoCTF{g34r5_0f_m0r3_5ca97824}`
