#!/bin/bash

root_path=$PWD
opts_path="$root_path/bin/options"
bld_path="$root_path/bin/bld"
local_path="$root_path/local"
src_path="$root_path/src"
build_path="$root_path/build"
program_pather="$local_path/exe_paths.txt"

. $local_path/local_vars.sh
. $bld_path/bld_core.sh
