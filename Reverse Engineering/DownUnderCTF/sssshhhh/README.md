# sssshhhh Writeup by Deffreus - DownUnderCTF 2024

```$ file server 
server: ELF 64-bit LSB executable, x86-64, version 1 (SYSV), statically linked, Go BuildID=5DHiw-uVqt9-bLaMwzf9/GvveOb53z0hFnP1V7yBN/rPDclINOAfnhZ6BNmxUs/7v92hxyWD-SzIPOrtMWE, with debug_info, not stripped
```
```$ du -h server
6.6M	server
```

Duh, my ghidra need update.

1 hour later...

Heck, this is the weirdest looking `main` I've seen so far.
I hope Ghidra isn't drunk.

```server.c
void main.main(
  runtime.heapArena *param_1,
  runtime.p *param_2,
  undefined8 param_3,
  undefined8 param_4,
  runtime/internal/atomic.Int64 param_5,
  runtime.p *param_6
)
{
  undefined8 extraout_RDX;
  undefined8 extraout_RDX_00;
  long unaff_R14;
  
  while (&stack0x00000000 <= *(undefined **)(unaff_R14 + 0x10)) {
    runtime.morestack_noctxt(param_1,param_2);
    param_3 = extraout_RDX_00;
  }
  main.StartLogger(param_1,(undefined *)param_2,param_3,param_4,param_5,param_6);
  main.RunSSH(param_1,param_2,extraout_RDX,param_4,param_5,param_6);
  return;
}
```

I think I should just try the ssh connection directly in see what's going on.

```
./attempt.sh 
The authenticity of host '[2024.ductf.dev]:30012 ([34.87.243.24]:30012)' can't be established.
ED25519 key fingerprint is SHA256:fk+GazQ8AHB7nNF/S4l0B6lWDiDMAk/nC6EYusuco0o.
This key is not known by any other names.
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added '[2024.ductf.dev]:30012' (ED25519) to the list of known hosts.
 ____  __.             __          ___.                               
|    |/ _|____   ____ |  | _______ \_ |__  __ _____________________   
|      < /  _ \ /  _ \|  |/ /\__  \ | __ \|  |  \_  __ \_  __ \__  \  
|    |  (  <_> |  <_> )    <  / __ \| \_\ \  |  /|  | \/|  | \// __ \_
|____|__ \____/ \____/|__|_ \(____  /___  /____/ |__|   |__|  (____  /
        \/                 \/     \/    \/                         \/ 
  ___ ___        .__       .___.__                                    
 /   |   \  ____ |  |    __| _/|__| ____    ____                      
/    ~    \/  _ \|  |   / __ | |  |/    \  / ___\                     
\    Y    (  <_> )  |__/ /_/ | |  |   |  \/ /_/  >                    
 \___|_  / \____/|____/\____ | |__|___|  /\___  /                     
       \/                   \/         \//_____/                      
_________        .__  .__                                             
\_   ___ \  ____ |  | |  |   ______                                   
/    \  \/_/ __ \|  | |  |  /  ___/                                   
\     \___\  ___/|  |_|  |__\___ \                                    
 \______  /\___  >____/____/____  >                                   
        \/     \/               \/                                    
vinnie@2024.ductf.dev's password:
```

Snap! (is bad)
Seems like I gotta figure it out from this headache-inducing `server.c`.
