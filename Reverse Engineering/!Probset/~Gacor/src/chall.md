chall: uno! (rev)

- input flag
- each character turned into a card data structure
- card data structure, values based on character value
  - charset: `4BCD3F6H1JKLMN09QR57UVWXYZ_{}bcdfhjklmnqruvwxyz!` (len: 48)
  - types: Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Queen, and King
  - odd/even: black/red
  - type: (character index in charset modulo 12) + 1
  - symbol: (character index in charset + 1) div 4
- 
