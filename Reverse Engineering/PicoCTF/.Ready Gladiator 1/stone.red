;redcode
;name Stone
;assert 1
        org     start
step    equ     3044
start   mov.i   #step, @step
        add.ab  #step, $start
        jmp     $start-1
        dat     #0, #0
end
