#!/bin/sh
socat tcp-l:8011,reuseaddr,fork exec:"./chall stx <flag.txt"