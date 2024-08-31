;redcode
;name Dwarf
;assert 1
dat.f #0, #0
dat.f   #0, #0
add.ab  #4, $-1
mov.ab  #0, @-2
jmp.a   $-2, #0
end
