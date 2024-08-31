printable = '`1234567890-=qwertyuiop[]\\asdfghjkl;\'zxcvbnm,./~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?'

file = open('./unzlib', 'rb').read()
for b in file:
    try:
        if b - prev == 12:
            print(f'{prev} -> {b}')
        prev = b
    except:
        prev = b

for key in arr:
    if not chr(key) in printable:
        continue
    print(f'{arr[key]:03d} ({chr(key)}) ({key})')

# from PIL import Image
# from collections import Counter
#
# # Open the image
# img = Image.open('./coming_soon_colorfest.png')
#
# # Convert image to RGB mode if it's not already
# img = img.convert('RGB')
#
# # Get the dimensions of the image
# width, height = img.size
#
# # Create a list of all pixels
# pixels = list(img.getdata())
#
# # Count occurrences of each color
# color_counts = Counter(pixels)
#
# # Calculate total number of pixels
# total_pixels = width * height
#
# # Sort colors by count in descending order
# sorted_colors = sorted(color_counts.items(), key=lambda x: x[1], reverse=True)
#
# # Print results
# concat = ''
# for color, count in color_counts.most_common():
#     hex_color = '#{:02x}{:02x}{:02x}'.format(*color)
#     if count < 100:
#         continue
#     # print(f"{count:07d} -> {hex_color}")
#     hex_color = hex_color[1:]
#     a = int(hex_color[:2], 16)
#     b = int(hex_color[2:4], 16)
#     c = int(hex_color[4:6], 16)
#     if b - a == 12 or c - b == 12:
#         print(f'{a} -> {b} @ {count}')
#
#     concat += hex_color[1:]
# # for i in range(0,len(concat),6):
# #
# #     print( chr(a ^ b ^ c), end='' )

