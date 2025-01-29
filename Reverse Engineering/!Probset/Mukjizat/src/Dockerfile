FROM alpine:latest

RUN apk update && apk add --no-cache socat gcc musl-dev

RUN adduser -D -u 1001 -s /bin/bash ctf

RUN mkdir /home/ctf/chall

RUN mkdir /home/ctf/chall/src

COPY ./chall.c /home/ctf/chall/src
COPY ./run.sh /home/ctf/chall/src
COPY ./flag.txt /home/ctf/chall/src

RUN gcc -o /home/ctf/chall/src/chall /home/ctf/chall/src/chall.c -pthread
RUN chmod +x /home/ctf/chall/src/chall

RUN chown -R root:root /home/ctf/chall
RUN chmod -R 555 /home/ctf/chall
USER ctf
WORKDIR /home/ctf/chall/src

CMD ["./run.sh"]
