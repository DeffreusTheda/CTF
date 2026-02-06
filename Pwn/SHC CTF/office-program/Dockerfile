FROM ubuntu:16.04

RUN apt update
RUN apt-get install -y \
    gcc \
    libc6-dev \
    socat \
    libc6

ADD main.c ./main.c
ADD flag.txt ./flag.txt
RUN gcc main.c -o main

ENTRYPOINT socat tcp-l:1337,fork,reuseaddr exec:./main && /bin/sh