# credit to (Discord) @c0nst3llati0n
from hashlib import md5
from string import printable
with open("./hardcore.bnk",'rb') as f:
    hashes=f.read()
hash_map={}
for i in range(0,len(hashes),16):
    hash_map[hashes[i:i+16].hex()]=True
def dfs(current_flag):
    if len(current_flag)==62:
        print(current_flag)
        return
    for char in printable:
        if md5((current_flag+char).encode()).hexdigest() not in hash_map.keys():
            dfs(current_flag+char)
dfs("srdnlen{")
