FROM alpine

WORKDIR /app

RUN apk add --no-cache --update \
    python3 \
    py3-pip \
    socat

RUN pip3 install pycryptodome --break-system-packages

COPY secret.py .
COPY challenge.py .

RUN chmod +x challenge.py

ENTRYPOINT socat tcp-l:5000,fork,reuseaddr exec:./challenge.py && /bin/bash
