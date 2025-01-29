a = ['sennsu', 'eeegnw', 'ewveer', 'vtfesg', 'rexifr', 'wsfwes', 'xgtgee', 'reerux', 'eisifh', 'enwege', 'eetggx', 'regvws', 'vgeuge', 'heisif', 'fftfei', 'eegfgf', 'gtxgee', 'etftve', 'sverwg', 'gveegu', 'nggeug', 'ieffgf', 'eenesv', 'eshiif', 'fehiis', 'uextst', 'wrwuee', 'revwsg', 'ewvsrg', 'iifhse', 'wereev', 'sxtsws', 'xgeget', 'gteuvg', 'wuweer', 'ettnen', 'ggffee', 'eggext', 'ihiefs', 'urweew', 'erxrue', 'hisfie', 'sxeeeu', 'egngwt', 'gtxeeg', 'vfteee', 'eihsif', 'tswtxi', 'sefihi', 'esvsve', 'eegtgx', 'wrieww', 'ftevee', 'vgeeug', 'ersntv']
letters = {
    'e': 9,
    'u': 1,
    'y': 1,
    'f': 0.2484519975,
    'o': 1,
    'v': 0.0276057775,
    'g': 4.7702783519,
    'x': 0.0026291216,
    'w': 1/5,
    't': 10,
    'n': 1/9,
    'i': 81,
    'h': 0.0002300481,
    'r': 16.0996894379,
    's': 28.1744565164
}
for aa in a:
    sum = 1
    for c in aa:
        sum *= letters[c]
    print(chr(int(round(sum))), end='')
    # print(sum, end='\t')
print()
