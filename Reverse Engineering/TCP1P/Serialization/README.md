# Serialization Writeup by Deffreus - TCP1P Playground 365

Homemade serial number generator!
I made the program generates serial number very long so that it's safe!
or is it safe?

## Recon

After unzipping `d04b9f8d64f85306b2eb3782a046d75081f1c84d06b890fe979f016e9f24572a.zip`, I got `dist/main` and `dist/output.txt`.

```$  file dist/main 
/home/vinnie/Downloads/main: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=c22ad7ed4a6b15da03045bfeabce539a960ea29a, for GNU/Linux 3.2.0, not stripped
```

I used [Decompiler Explorer](https://dogbolt.org/?id=c562c97e-7a1d-43d0-85ed-d41f1e343af6) (Hex-Rays), and omagaa there's 102 variables in `main()`...

```

## About the Vulnerability

## Exploitation


## Conclusion


