
define twi = Character("Twilyght Spakyl")
define rb = Character("Rainbom Bash")
define fs = Character("Flubbershy")

label start:
    $ nodes = [0]
    scene bg1
    with dissolve
    with fade
    with pixellate
    with wipeleft
    with wiperight
    show rb at left
    with hpunch
    with vpunch
    with moveinbottom
    with moveinright
    
    "Rainbom Bash wake up in mornin, cloudz all over"
    
    rb "ughh not cloudz again. i hate cloudz"
    
    show fs at right
    with zoomin
    with moveinleft
    with hpunch
    
    rb "flubbershy qwick come i gotta smash cloudz"
    fs "cant i got zen day"
    rb "and i dont like cloud"
    
    with vpunch
    with hpunch
    
    fs "zen day very important for my animal friends"
    
    rb "more important than smashin cloudz?"
    
    fs "yes zen make me calm for whole week"
    
    rb "fine i find somepony else to help"
    
    with dissolve
    with pixellate
    with blinds
    
    fs "mayb ask spakyl she always know what do"
    
    rb "spakyl always make me do all work anyway"
    
    hide fs
    with moveoutright
    with vpunch
    with dissolve
    
    hide rb
    with moveoutleft
    with hpunch
    with pixellate
    
    scene bg2
    with squares
    with blinds
    with dissolve
    with fade
    
    "Later at spakyl house with all the book"
    
    show rb at left
    with moveinleft
    with vpunch
    
    show twi at right
    with moveinright
    with zoomin
    with hpunch
    
    twi "rainbom bash qwick come cloudz is everywher"
    rb "cant im already layin"
    twi "rainbom now is not time for layin"
    rb "then do it yurself if u so smart"
    twi "i got no wing only brain"
    rb "then let ur brain do flyin"
    
    with pixellate
    with dissolve
    with squares
    
    twi "my brain too heavy for flyin"
    
    rb "then what we do about cloudz"
    
    twi "u must smash them all before sunset"
    
    rb "too many cloudz for one pony"
    
    twi "u strongest flyer in ponyville u can do it"
    
    rb "but i was plannin on layin all day"
    
    with vpunch
    with hpunch
    
    twi "layin can wait cloudz cannot"
    
    rb "ughhh fine but u owe me big nap after"
    
    hide rb
    with moveoutbottom
    with vpunch
    with pixellate
    
    twi "she best cloud smasher when not busy layin"
    
    "Help Rainbom Bash smash all the clouds in the fastest possible way and return to the origin.
    I heard it's a well known problem..."
    jump cloud0


label dispatch:
    if len(nodes) == 21:
        jump ending
    if nodes[-1] == 0:
        jump cloud0
    if nodes[-1] == 6:
        jump cloud6
    if nodes[-1] == 1:
        jump cloud1
    if nodes[-1] == 2:
        jump cloud2
    if nodes[-1] == 3:
        jump cloud3
    if nodes[-1] == 4:
        jump cloud4
    if nodes[-1] == 5:
        jump cloud5
    if nodes[-1] == 7:
        jump cloud7
    if nodes[-1] == 8:
        jump cloud8
    if nodes[-1] == 9:
        jump cloud9
    if nodes[-1] == 10:
        jump cloud10
    if nodes[-1] == 11:
        jump cloud11
    if nodes[-1] == 12:
        jump cloud12
    if nodes[-1] == 13:
        jump cloud13
    if nodes[-1] == 14:
        jump cloud14
    if nodes[-1] == 15:
        jump cloud15
    if nodes[-1] == 16:
        jump cloud16
    if nodes[-1] == 17:
        jump cloud17
    if nodes[-1] == 18:
        jump cloud18
    if nodes[-1] == 19:
        jump cloud19

label cloud0:
menu:
    "fly to cloud6 which is 18267351 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud0 which is 0 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud1 which is 27207933 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 29257191 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud3 which is 30767375 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud4 which is 33358061 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud5 which is 31710853 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud7 which is 28646422 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud8 which is 25181575 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud9 which is 32668955 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud10 which is 31721351 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud11 which is 31311914 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud12 which is 17436287 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud13 which is 31231519 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud14 which is 27398390 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud15 which is 26665226 pony units away":
        $ nodes.append(15)
        jump dispatch
    "fly to cloud16 which is 33405147 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud17 which is 29479064 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud18 which is 28859609 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud19 which is 32875400 pony units away":
        $ nodes.append(19)
        jump dispatch
label cloud6:
menu:
    "fly to cloud0 which is 18267351 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud4 which is 16937956 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud6 which is 0 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud1 which is 26073565 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 25822626 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud3 which is 28073673 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud5 which is 27018180 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud7 which is 25268124 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud8 which is 32590760 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud9 which is 27138017 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud10 which is 32999152 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud11 which is 26220279 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud12 which is 26204222 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud13 which is 27031462 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud14 which is 25273715 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud15 which is 25443122 pony units away":
        $ nodes.append(15)
        jump dispatch
    "fly to cloud16 which is 28617815 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud17 which is 27829458 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud18 which is 29730434 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud19 which is 29457736 pony units away":
        $ nodes.append(19)
        jump dispatch
label cloud1:
menu:
    "fly to cloud0 which is 27207933 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 26073565 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 27706598 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 26989354 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 33402104 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud8 which is 30552119 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud3 which is 27461140 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud10 which is 32910477 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud9 which is 31028215 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud13 which is 32961668 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud19 which is 28354374 pony units away":
        $ nodes.append(19)
        jump dispatch
    "fly to cloud7 which is 31907885 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud17 which is 29926349 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud14 which is 32744601 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud11 which is 33323884 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud5 which is 17153389 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud2 which is 18723267 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud1 which is 0 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud12 which is 31917434 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud15 which is 32930203 pony units away":
        $ nodes.append(15)
        jump dispatch
label cloud2:
menu:
    "fly to cloud0 which is 29257191 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 25822626 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 30094007 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 27936885 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 28667078 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud8 which is 30354002 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud3 which is 26971581 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud10 which is 26252638 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud9 which is 29221683 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud13 which is 26305193 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud19 which is 25722954 pony units away":
        $ nodes.append(19)
        jump dispatch
    "fly to cloud7 which is 31797481 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud17 which is 30263697 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud14 which is 32130369 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud11 which is 25958512 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud5 which is 26800381 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud1 which is 18723267 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud15 which is 17552296 pony units away":
        $ nodes.append(15)
        jump dispatch
    "fly to cloud2 which is 0 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud12 which is 30021148 pony units away":
        $ nodes.append(12)
        jump dispatch
label cloud3:
menu:
    "fly to cloud0 which is 30767375 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 28073673 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 31156816 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 27739929 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 29721951 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud8 which is 18396217 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud10 which is 16791286 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud3 which is 0 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud1 which is 27461140 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 26971581 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud5 which is 30331322 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud7 which is 26204203 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud9 which is 25838588 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud11 which is 26131377 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud12 which is 29700497 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud13 which is 27798881 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud14 which is 33059254 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud15 which is 29477864 pony units away":
        $ nodes.append(15)
        jump dispatch
    "fly to cloud17 which is 29439773 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud19 which is 30777073 pony units away":
        $ nodes.append(19)
        jump dispatch
label cloud4:
menu:
    "fly to cloud0 which is 33358061 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 16937956 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud18 which is 17392801 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud4 which is 0 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud1 which is 27706598 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 30094007 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud3 which is 31156816 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud5 which is 27346875 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud7 which is 32281098 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud8 which is 30112898 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud9 which is 27364910 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud10 which is 30685671 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud11 which is 33231675 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud12 which is 28723588 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud13 which is 31226010 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud14 which is 30541690 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud15 which is 25856444 pony units away":
        $ nodes.append(15)
        jump dispatch
    "fly to cloud16 which is 31229621 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud17 which is 31201226 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud19 which is 27161053 pony units away":
        $ nodes.append(19)
        jump dispatch
label cloud5:
menu:
    "fly to cloud0 which is 31710853 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 27018180 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 27346875 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 25178897 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 27754527 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud8 which is 28340609 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud3 which is 30331322 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud10 which is 31493000 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud9 which is 26024216 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud13 which is 26366524 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud19 which is 25771567 pony units away":
        $ nodes.append(19)
        jump dispatch
    "fly to cloud7 which is 26738900 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud17 which is 30294100 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud14 which is 28566084 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud11 which is 17879357 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud1 which is 17153389 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud5 which is 0 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud2 which is 26800381 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud12 which is 33432247 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud15 which is 30498671 pony units away":
        $ nodes.append(15)
        jump dispatch
label cloud7:
menu:
    "fly to cloud0 which is 28646422 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 25268124 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 32281098 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 31905380 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 28136501 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud8 which is 25545320 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud3 which is 26204203 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud10 which is 31145177 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud9 which is 33382954 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud13 which is 27768727 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud19 which is 18428695 pony units away":
        $ nodes.append(19)
        jump dispatch
    "fly to cloud17 which is 18433903 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud7 which is 0 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud1 which is 31907885 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 31797481 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud5 which is 26738900 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud11 which is 27664100 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud12 which is 32470009 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud14 which is 27949390 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud15 which is 27242094 pony units away":
        $ nodes.append(15)
        jump dispatch
label cloud8:
menu:
    "fly to cloud0 which is 25181575 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 32590760 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 30112898 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 29889268 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 17863705 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud3 which is 18396217 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud8 which is 0 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud1 which is 30552119 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 30354002 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud5 which is 28340609 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud7 which is 25545320 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud9 which is 27003713 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud10 which is 25437214 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud11 which is 31796476 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud12 which is 32892705 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud13 which is 25571056 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud14 which is 29517404 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud15 which is 29493907 pony units away":
        $ nodes.append(15)
        jump dispatch
    "fly to cloud17 which is 30959457 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud19 which is 30146332 pony units away":
        $ nodes.append(19)
        jump dispatch
label cloud9:
menu:
    "fly to cloud0 which is 32668955 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 27138017 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 27364910 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 25934690 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 27950322 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud8 which is 27003713 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud3 which is 25838588 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud10 which is 18199400 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud13 which is 17432494 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud9 which is 0 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud1 which is 31028215 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 29221683 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud5 which is 26024216 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud7 which is 33382954 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud11 which is 27564338 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud12 which is 29696304 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud14 which is 29903977 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud15 which is 25517772 pony units away":
        $ nodes.append(15)
        jump dispatch
    "fly to cloud17 which is 31033257 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud19 which is 27689266 pony units away":
        $ nodes.append(19)
        jump dispatch
label cloud10:
menu:
    "fly to cloud0 which is 31721351 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 32999152 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 30685671 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 30621460 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 30132076 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud8 which is 25437214 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud3 which is 16791286 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud9 which is 18199400 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud10 which is 0 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud1 which is 32910477 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 26252638 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud5 which is 31493000 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud7 which is 31145177 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud11 which is 25876546 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud12 which is 31958139 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud13 which is 27864810 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud14 which is 28321738 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud15 which is 32744171 pony units away":
        $ nodes.append(15)
        jump dispatch
    "fly to cloud17 which is 26162759 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud19 which is 26660593 pony units away":
        $ nodes.append(19)
        jump dispatch
label cloud11:
menu:
    "fly to cloud0 which is 31311914 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 26220279 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 33231675 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 31975694 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 28330910 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud8 which is 31796476 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud3 which is 26131377 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud10 which is 25876546 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud9 which is 27564338 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud13 which is 26446653 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud19 which is 29184736 pony units away":
        $ nodes.append(19)
        jump dispatch
    "fly to cloud7 which is 27664100 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud17 which is 27423379 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud14 which is 18665171 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud5 which is 17879357 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud11 which is 0 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud1 which is 33323884 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 25958512 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud12 which is 28787506 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud15 which is 26795144 pony units away":
        $ nodes.append(15)
        jump dispatch
label cloud12:
menu:
    "fly to cloud0 which is 17436287 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 26204222 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 28723588 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 25437981 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 26932680 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud8 which is 32892705 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud3 which is 29700497 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud10 which is 31958139 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud9 which is 29696304 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud13 which is 30143172 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud19 which is 31899333 pony units away":
        $ nodes.append(19)
        jump dispatch
    "fly to cloud7 which is 32470009 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud17 which is 31591461 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud14 which is 25912069 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud11 which is 28787506 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud5 which is 33432247 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud1 which is 31917434 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 30021148 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud15 which is 18840703 pony units away":
        $ nodes.append(15)
        jump dispatch
    "fly to cloud12 which is 0 pony units away":
        $ nodes.append(12)
        jump dispatch
label cloud13:
menu:
    "fly to cloud0 which is 31231519 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 27031462 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 31226010 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 33245767 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 33332666 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud8 which is 25571056 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud3 which is 27798881 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud10 which is 27864810 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud9 which is 17432494 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud19 which is 18585598 pony units away":
        $ nodes.append(19)
        jump dispatch
    "fly to cloud13 which is 0 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud1 which is 32961668 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 26305193 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud5 which is 26366524 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud7 which is 27768727 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud11 which is 26446653 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud12 which is 30143172 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud14 which is 31608667 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud15 which is 32254626 pony units away":
        $ nodes.append(15)
        jump dispatch
    "fly to cloud17 which is 28876524 pony units away":
        $ nodes.append(17)
        jump dispatch
label cloud14:
menu:
    "fly to cloud0 which is 27398390 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 25273715 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 30541690 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 28664099 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 31369881 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud8 which is 29517404 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud3 which is 33059254 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud10 which is 28321738 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud9 which is 29903977 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud13 which is 31608667 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud19 which is 32553702 pony units away":
        $ nodes.append(19)
        jump dispatch
    "fly to cloud7 which is 27949390 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud17 which is 17023154 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud11 which is 18665171 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud14 which is 0 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud1 which is 32744601 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 32130369 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud5 which is 28566084 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud12 which is 25912069 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud15 which is 32919698 pony units away":
        $ nodes.append(15)
        jump dispatch
label cloud15:
menu:
    "fly to cloud0 which is 26665226 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 25443122 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 25856444 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 27812923 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 32324337 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud8 which is 29493907 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud3 which is 29477864 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud10 which is 32744171 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud9 which is 25517772 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud13 which is 32254626 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud19 which is 28001748 pony units away":
        $ nodes.append(19)
        jump dispatch
    "fly to cloud7 which is 27242094 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud17 which is 31222350 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud14 which is 32919698 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud11 which is 26795144 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud5 which is 30498671 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud1 which is 32930203 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 17552296 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud12 which is 18840703 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud15 which is 0 pony units away":
        $ nodes.append(15)
        jump dispatch
label cloud16:
menu:
    "fly to cloud0 which is 33405147 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 28617815 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 31229621 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 18709664 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud8 which is 17863705 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud16 which is 0 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud1 which is 33402104 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 28667078 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud3 which is 29721951 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud5 which is 27754527 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud7 which is 28136501 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud9 which is 27950322 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud10 which is 30132076 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud11 which is 28330910 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud12 which is 26932680 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud13 which is 33332666 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud14 which is 31369881 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud15 which is 32324337 pony units away":
        $ nodes.append(15)
        jump dispatch
    "fly to cloud17 which is 26022470 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud19 which is 29315967 pony units away":
        $ nodes.append(19)
        jump dispatch
label cloud17:
menu:
    "fly to cloud0 which is 29479064 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 27829458 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 31201226 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 29138946 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 26022470 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud8 which is 30959457 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud3 which is 29439773 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud10 which is 26162759 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud9 which is 31033257 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud13 which is 28876524 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud19 which is 27237135 pony units away":
        $ nodes.append(19)
        jump dispatch
    "fly to cloud7 which is 18433903 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud14 which is 17023154 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud17 which is 0 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud1 which is 29926349 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 30263697 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud5 which is 30294100 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud11 which is 27423379 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud12 which is 31591461 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud15 which is 31222350 pony units away":
        $ nodes.append(15)
        jump dispatch
label cloud18:
menu:
    "fly to cloud0 which is 28859609 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 29730434 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 17392801 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud16 which is 18709664 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud18 which is 0 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud1 which is 26989354 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 27936885 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud3 which is 27739929 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud5 which is 25178897 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud7 which is 31905380 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud8 which is 29889268 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud9 which is 25934690 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud10 which is 30621460 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud11 which is 31975694 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud12 which is 25437981 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud13 which is 33245767 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud14 which is 28664099 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud15 which is 27812923 pony units away":
        $ nodes.append(15)
        jump dispatch
    "fly to cloud17 which is 29138946 pony units away":
        $ nodes.append(17)
        jump dispatch
    "fly to cloud19 which is 30105348 pony units away":
        $ nodes.append(19)
        jump dispatch
label cloud19:
menu:
    "fly to cloud0 which is 32875400 pony units away":
        $ nodes.append(0)
        jump dispatch
    "fly to cloud6 which is 29457736 pony units away":
        $ nodes.append(6)
        jump dispatch
    "fly to cloud4 which is 27161053 pony units away":
        $ nodes.append(4)
        jump dispatch
    "fly to cloud18 which is 30105348 pony units away":
        $ nodes.append(18)
        jump dispatch
    "fly to cloud16 which is 29315967 pony units away":
        $ nodes.append(16)
        jump dispatch
    "fly to cloud8 which is 30146332 pony units away":
        $ nodes.append(8)
        jump dispatch
    "fly to cloud3 which is 30777073 pony units away":
        $ nodes.append(3)
        jump dispatch
    "fly to cloud10 which is 26660593 pony units away":
        $ nodes.append(10)
        jump dispatch
    "fly to cloud9 which is 27689266 pony units away":
        $ nodes.append(9)
        jump dispatch
    "fly to cloud13 which is 18585598 pony units away":
        $ nodes.append(13)
        jump dispatch
    "fly to cloud7 which is 18428695 pony units away":
        $ nodes.append(7)
        jump dispatch
    "fly to cloud19 which is 0 pony units away":
        $ nodes.append(19)
        jump dispatch
    "fly to cloud1 which is 28354374 pony units away":
        $ nodes.append(1)
        jump dispatch
    "fly to cloud2 which is 25722954 pony units away":
        $ nodes.append(2)
        jump dispatch
    "fly to cloud5 which is 25771567 pony units away":
        $ nodes.append(5)
        jump dispatch
    "fly to cloud11 which is 29184736 pony units away":
        $ nodes.append(11)
        jump dispatch
    "fly to cloud12 which is 31899333 pony units away":
        $ nodes.append(12)
        jump dispatch
    "fly to cloud14 which is 32553702 pony units away":
        $ nodes.append(14)
        jump dispatch
    "fly to cloud15 which is 28001748 pony units away":
        $ nodes.append(15)
        jump dispatch
    "fly to cloud17 which is 27237135 pony units away":
        $ nodes.append(17)
        jump dispatch


label ending:
    python:
        import hashlib


        flag = b""

        
        def xor(target, key):
            out = [c ^ key[i % len(key)] for i, c in enumerate(target)]
            return bytearray(out)


        def key_from_path(path):
            return hashlib.sha256(str(path).encode()).digest()


        def check_path(path, enc_flag):
            global flag
            flag1 = xor(enc_flag, key_from_path(path))
            flag2 = xor(enc_flag, key_from_path(list(reversed(path))))
            if flag1.startswith(b"BtSCTF"):
                flag = flag1
                print(flag)
                flag = bytes(flag).replace(b"{", b"{{").decode('ascii')
                return True
            if flag2.startswith(b"BtSCTF"):
                flag = flag2
                print(flag)
                flag = bytes(flag).replace(b"{", b"{{").decode('ascii')
                return True
            return False


        is_correct = check_path(nodes, bytearray(b'\xc2\x92\xf9\xf66\xe8\xa5\xa6\x17\xb6mGE\xcfQ\x90Mk:\x9a\xbb\x905&\x19\x8e\xc4\x9a\x0b\x1f\xf8C\xf4\xb9\xc9\x85R\xc2\xbb\x8d\x07\x94[R_\xf5z\x9fAl\x11\x9c\xbb\x9255\x08\x8e\xf6\xd6\x04'))
    if is_correct:
        rb "all cloudz smashed im the queen"
        rb "i got 100% swag"
        "[flag]"
    else:
        "Sadly, Rainbom Bash was too slow and wasn't able to smash all clouds."
    return


