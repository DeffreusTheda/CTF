;redcode
;name Silklet
;assert 1
        org     start
step    equ     1800
copies  equ     10
start   spl     1,          <-200
        spl     1,          <-300
        mov.i   -1,         0
silk    spl     @0,         }step
        mov.i   }-1,        >-1
        mov.i   bomba,      }1001
cnt     djn.f   silk,       <-1151
bomba   dat     >2667,      >5334
for     copies-4
        mov.i   bomba,      }bombs
rof
bombs   dat     0,0
end
