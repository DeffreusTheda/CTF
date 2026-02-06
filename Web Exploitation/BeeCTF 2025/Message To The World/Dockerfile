FROM python:3.11-slim

ENV PYTHONDONTWRITEBYTECODE=1 PYTHONUNBUFFERED=1
WORKDIR /app

RUN apt-get update && apt-get install -y --no-install-recommends coreutils \
 && rm -rf /var/lib/apt/lists/*

RUN pip install --no-cache-dir Flask==3.0.3

COPY src/ /app/

COPY flag.txt /flag.txt
RUN set -eux; \
    BLACKLIST="os eval env class exec self"; \
    while :; do \
        FLAG_SUFFIX="$(tr -dc 'A-Za-z0-9' </dev/urandom | head -c8)"; \
        bad=0; \
        for word in $BLACKLIST; do \
          if printf '%s' "$FLAG_SUFFIX" | grep -qi "$word"; then bad=1; break; fi; \
        done; \
        [ $bad -eq 0 ] && break; \
    done; \
    mv /flag.txt "/app/flag_${FLAG_SUFFIX}.txt"; \
    chmod 0444 "/app/flag_${FLAG_SUFFIX}.txt"; \
    rm -f /flag.txt

RUN find /app -type d -exec chmod 0555 {} \; \
 && find /app -type f -exec chmod 0444 {} \; \
 && chown -R root:root /app

RUN useradd -U -m -s /bin/bash ctf

RUN echo '#!/bin/bash\nexec timeout 10s "$@"' > /usr/local/bin/safe-sh \
 && chmod +x /usr/local/bin/safe-sh \
 && chsh -s /usr/local/bin/safe-sh ctf

USER ctf

EXPOSE 5000
CMD ["python", "app.py"]
