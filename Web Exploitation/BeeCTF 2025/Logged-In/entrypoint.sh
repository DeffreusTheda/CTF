#!/bin/sh
set -e

if [ -f /var/www/flag.txt ]; then
  HEX="$(od -An -N16 -tx1 /dev/urandom | tr -d ' \n')"
  mv /var/www/flag.txt "/var/www/${HEX}.txt"
  chown root:root "/var/www/${HEX}.txt"
  chmod 444 "/var/www/${HEX}.txt"
fi

[ -x /clear_log.sh ] && /clear_log.sh &

exec apache2-foreground