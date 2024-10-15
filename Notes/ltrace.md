
**ltrace** - A [[library call]] tracer

ltrace [-CdfhiLrStttV] [-a column] [-e expr] [-l filename] [-n nr] [-o filename] [-p pid] ... [-s strsize] [-u username] [-X extern] [-x extern] ... [--align=column] [--debug] [--demangle] [--help] [--indent=nr] [--library=filename] [--output=filename] [--version] [command [arg ...]]

ltrace is a program that simply runs the specified command until it exits. It intercepts and records the [[dynamic library]] calls which are called by the executed process and the [[signals]] which are received by that process. It can also intercept and print the [[system calls]] executed by the program.

Its use is very similar to [[strace]](1).
