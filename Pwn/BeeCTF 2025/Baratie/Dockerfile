FROM ubuntu:latest

RUN apt-get update 
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/* /etc/xinetd.d/*

RUN useradd -U -m -s /bin/bash support

WORKDIR /home/support

COPY ./flag.txt /flag.txt
COPY ./baratie .
COPY ./ynetd /usr/bin/ynetd

RUN chown root:root /flag.txt && chmod 444 /flag.txt
RUN chown -R root:support /home/support
RUN chmod 750 /home/support/baratie
RUN chown root:support /usr/bin/ynetd
RUN chmod 750 /usr/bin/ynetd

USER support
EXPOSE 13375
CMD ["/usr/bin/ynetd", "-p", "13375", "/home/support/baratie"]
