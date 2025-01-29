m = {'AAAAA': 'A', 'AAAAB': 'B', 'AAABA': 'C', 'AAABB': 'D', 'AABAA': 'E', 'AABAB': 'F', 'AABBA': 'G', 'AABBB': 'H', 'ABAAA': 'I', 'ABAAB': 'J', 'ABABA': 'K', 'ABABB': 'L', 'ABBAA': 'M', 'ABBAB': 'N', 'ABBBA': 'O', 'ABBBB': 'P', 'BAAAA': 'Q', 'BAAAB': 'R', 'BAABA': 'S', 'BAABB': 'T', 'BABAA': 'U', 'BABAB': 'V', 'BABBA': 'W', 'BABBB': 'X', 'BBAAA': 'Y', 'BBAAB': 'Z'}
m2 = {'AAAAA':'A',  'AAAAB':'B',  'AAABA':'C',  'AAABB':'D',  'AABAA':'E',  'AABAB':'F',  'AABBA':'G',  'AABBB':'H',  'ABAAA':'I',  'ABAAA':'J',  'ABAAB':'K',  'ABABA':'L',  'ABABB':'M',  'ABBAA':'N',  'ABBAB':'O',  'ABBBA':'P',  'ABBBB':'Q',  'BAAAA':'R',  'BAAAB':'S',  'BAABA':'T',  'BAABB':'U',  'BAABB':'V',  'BABAA':'W',  'BABAB':'X',  'BABBA':'Y',  'BABBB':'Z'}
enc = ['AAABB', 'AAABA', 'ABBAB', 'AAABB', 'AABAA', 'AAAAB', 'AAAAA', 'AAABA', 'ABBAB', 'ABBAA']
for x in enc:
    print(m2[x], end='')
print()