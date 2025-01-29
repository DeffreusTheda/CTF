#!/bin/zsh

while read -r LINE; do
  git reset --hard "$LINE"
  tar xvf payload.zip flag.txt >/dev/null 2>/dev/null
  cat flag.txt | base64 -d
done <./hashes
