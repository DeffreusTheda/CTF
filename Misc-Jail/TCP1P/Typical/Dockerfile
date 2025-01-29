FROM ubuntu:latest

RUN apt-get -y update && apt-get -y install socat python3 --fix-missing && rm -rf /var/lib/apt/lists/*

WORKDIR /opt/chall

COPY typical.py typical.py
COPY flag.txt /flag.txt
RUN chmod 644 /flag.txt && mv /flag.txt /flag-$(head -c8 /dev/urandom | md5sum | tr -cd '[:alnum:]')

EXPOSE 5000
# ENTRYPOINT socat -dd TCP4-LISTEN:5000,fork,reuseaddr EXEC:"./typical.py",su=nobody
ENTRYPOINT socat -dd TCP4-LISTEN:5000,fork,reuseaddr EXEC:"python3 ./typical.py",su=nobody
# CMD ["socat", "-dd", "TCP4-LISTEN:5000,fork,reuseaddr", "EXEC:./typical.py,su=nobody"]
