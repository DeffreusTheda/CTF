from mt19937predictor import MT19937Predictor

# These are generated before our leak

hom = open('./shc/home.html', 'rb').read()
unknown = [int.from_bytes(hom[i:i+4]) for i in range(0,len(hom),4)]

predictor = MT19937Predictor()

ec = open('./shc/imgs/ECSC_2022_img_10.jpg', 'rb').read()
for i in range(0,len(ec),4):
    predictor.setrandbits(int.from_bytes(ec[i:i+4]), 32)

print(dir(predictor))
predictor.offset(len(ec))  # Offset by 624 to get the state before our leak
predictor.offset(len(hom))  # Offset by 1000 to get the state right before the unknowns

# Now the predicted values will line up
assert unknown == [predictor.getrandbits(32) for _ in range(1000)]