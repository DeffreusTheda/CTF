# Privnote

####### Author: Lev Reznichenko (@mkvfaa), SPbCTF

| ML: 35% | CTF: 65% | llm | web |

The idea behind Privnote is simple: you create a short note, the recipient reads it once, and the note is forever gone.

The backend only stores the ciphertext, and all the encryption happens entirely on the client side.

But here’s the catch—I have a tip that the admin of this so-called “private note” service left a note in his own account. That note contains the IP address of his personal file stash where he keeps his private documents. And we really need to doxx him!

Maybe you can dig it up?

ai-privnote-501zwjpa.spbctf.com/

Source code: [privnote_f8b4cff.tar.gz](./privnote_f8b4cff.tar.gz)
