#!/bin/bash

. bin/begin_bld_session.sh
bld_print_implicit_opts

bld_unit /c/mr4th/mr4th/src/mr4th_base.target.c mr4th_base -- dll

bld_unit $src_path/shuffle_poset.c shuffle_poset

