import sys

def main:
    for line in sys.stdin:
        for c in line:
            print(binary(ord(c)), end='-')
        print()

if __name__ == "__main__":
    main()
