cards = [
    ["Black", "6",      "Clubs"   ],
    ["Black", "6",      "Clubs"   ],
    ["Red",   "6",      "Clubs"   ],
    ["Red",   "7",      "Clubs"   ],
    ["Black", "7",      "Clubs"   ],
    ["Black", "8",      "Clubs"   ],
    ["Red",   "10",     "Clubs"   ],
    ["Red",   "Jack",   "Clubs"   ],
    ["Red",   "King",   "Clubs"   ],
    ["Red",   "Hero",   "Clubs"   ],
    ["Black", "Hero",   "Clubs"   ],
    ["Black", "Hero",   "Clubs"   ],
    ["Red",   "Hero",   "Clubs"   ],
    ["Red",   "Hero",   "Clubs"   ],
    ["Black", "Hero",   "Clubs"   ],
    ["Black", "Hacker", "Clubs"   ],
    ["Red",   "Hacker", "Clubs"   ],
    ["Black", "Hacker", "Clubs"   ],
    ["Black", "Hacker", "Clubs"   ],
    ["Red",   "Queen",  "Clubs"   ],
    ["Black", "Queen",  "Clubs"   ],
    ["Red",   "Queen",  "Clubs"   ],
    ["Black", "Queen",  "Clubs"   ],
    ["Red",   "Queen",  "Clubs"   ],
    ["Red",   "4",      "Diamonds"],
    ["Red",   "6",      "Diamonds"],
    ["Black", "6",      "Diamonds"],
    ["Red",   "6",      "Diamonds"],
    ["Black", "6",      "Diamonds"],
    ["Red",   "6",      "Diamonds"],
    ["Red",   "7",      "Diamonds"],
    ["Black", "10",     "Diamonds"],
    ["Red",   "Jack",   "Diamonds"],
    ["Black", "Jack",   "Diamonds"],
    ["Red",   "King",   "Diamonds"],
    ["Red",   "King",   "Diamonds"],
    ["Red",   "King",   "Diamonds"],
    ["Red",   "King",   "Diamonds"],
    ["Black", "King",   "Diamonds"],
    ["Red",   "Hero",   "Diamonds"],
    ["Red",   "Hacker", "Diamonds"],
    ["Red",   "Hacker", "Diamonds"],
    ["Red",   "Hacker", "Diamonds"],
    ["Black", "Queen",  "Diamonds"],
    ["Red",   "Queen",  "Diamonds"],
    ["Red",   "Queen",  "Diamonds"],
    ["Black", "Queen",  "Diamonds"],
    ["Black", "3",      "Hearts"  ],
    ["Black", "4",      "Hearts"  ],
    ["Black", "5",      "Hearts"  ],
    ["Black", "5",      "Hearts"  ],
    ["Black", "6",      "Hearts"  ],
    ["Black", "6",      "Hearts"  ],
    ["Black", "7",      "Hearts"  ],
    ["Black", "8",      "Hearts"  ],
    ["Black", "9",      "Hearts"  ],
    ["Black", "Jack",   "Hearts"  ],
    ["Black", "Jack",   "Hearts"  ],
    ["Black", "Jack",   "Hearts"  ],
    ["Red",   "King",   "Hearts"  ],
    ["Black", "King",   "Hearts"  ],
    ["Black", "King",   "Hearts"  ],
    ["Black", "King",   "Hearts"  ],
    ["Black", "Hero",   "Hearts"  ],
    ["Red",   "Hero",   "Hearts"  ],
    ["Black", "Hero",   "Hearts"  ],
    ["Red",   "Hero",   "Hearts"  ],
    ["Black", "Hacker", "Hearts"  ],
    ["Black", "3",      "Spades"  ],
    ["Black", "5",      "Spades"  ],
    ["Red",   "5",      "Spades"  ],
    ["Black", "6",      "Spades"  ],
    ["Red",   "6",      "Spades"  ],
    ["Black", "7",      "Spades"  ],
    ["Red",   "9",      "Spades"  ],
    ["Black", "10",     "Spades"  ],
    ["Black", "10",     "Spades"  ],
    ["Black", "Jack",   "Spades"  ],
    ["Black", "Jack",   "Spades"  ],
    ["Black", "Jack",   "Spades"  ],
    ["Red",   "King",   "Spades"  ],
    ["Black", "King",   "Spades"  ],
    ["Red",   "King",   "Spades"  ],
    ["Black", "King",   "Spades"  ],
    ["Red",   "King",   "Spades"  ],
    ["Black", "King",   "Spades"  ],
    ["Black", "Hero",   "Spades"  ],
    ["Red",   "Hero",   "Spades"  ],
    ["Black", "Hacker", "Spades"  ],
    ["Black", "Hacker", "Spades"  ],
]

suits = ["Clubs", "Diamonds", "Hearts", "Spades"]
ranks = ["Cat", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Hero", "Hacker", "Queen"]

chars = []

for card in cards:
    v = 0
    v |= 1 if card[0] == "Red" else 0
    for i, suit in enumerate(suits):
        if suit == card[2]:
            v |= (i << 1)
    for i, rank in enumerate(ranks):
        if rank == card[1]:
            v |= (i << 3)
    chars.append(v)
    # print(end=f'{chr(v)}')
print()

effie = open(".effie", 'rb').read()
n = len(effie)
for i in range(n - 2, -1, -1):
    maxIdx = effie[i]
    if maxIdx != i:
        tmp = chars[i]
        chars[i] = chars[maxIdx]
        chars[maxIdx] = tmp

for i, c in enumerate(chars):
    sign = 1 if i & 1 == 1 else -1
    c += (((i % 12) + 1) // 2) * sign
    print(end=f'{chr(c)}')
