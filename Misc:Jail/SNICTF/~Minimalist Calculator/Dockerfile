FROM python:3.12-slim

RUN apt-get update && \
    apt-get install -y --no-install-recommends socat && \
    rm -rf /var/cache/apt/archives /var/lib/apt/lists

RUN groupadd -r ctf && useradd -r -g ctf ctf

COPY chall.py /home/ctf/chall.py
COPY secret.py /home/ctf/secret.py

RUN chmod 644 /home/ctf/secret.py
RUN chmod 755 /home/ctf/chall.py
RUN chown -R root:ctf /home/ctf

WORKDIR /home/ctf
USER ctf
CMD ["socat", "TCP-LISTEN:5000,reuseaddr,fork,max-children=200", "EXEC:./chall.py,stderr,pty,cfmakeraw,echo=0"]
