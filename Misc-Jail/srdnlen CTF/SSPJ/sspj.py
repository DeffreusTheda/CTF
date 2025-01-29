import random

class SSPJ(object):
    def __init__(self):
        print("Welcome to the Super Secure Python Jail (SSPJ)!")
        print("You can run your code here, but be careful not to break the rules...")

        self.code = self.code_sanitizer(input("Enter your data: "))

        # I'm so confident in my SSPJ that 
        # I don't even need to delete any globals/builtins
        exec(self.code, globals())
        return

    def code_sanitizer(self, code: str) -> str:
        if not code.isascii():
            print("Alien material detected... Exiting.")
            exit()

        banned_chars = [
            # Why do you need these characters?
            "m", "o", "w", "q", "b", "y", "u", "h", "c", "v", "z", "x", "k"
        ]

        banned_digits = [
            # Why do you need these digits?
            "0", "7", "1"
        ]

        banned_symbols = [
            # You don't need these...
            ".", "(", "'", "=", "{", ":", "@", '"', "[", "`"
        ]

        banned_words = [
            # Oh no, you can't use these words!
            "globals", "breakpoint", "locals", "self", "system", "open",
            "eval", "import", "exec", "flag", "os", "subprocess", "input",
            "random", "builtins", "code_sanitizer"
        ]

        blacklist = banned_chars + banned_digits + banned_symbols + banned_words
        random.shuffle(blacklist)

        if any(map(lambda c: c in code, blacklist)):
            print("Are you trying to cheat me!? Emergency exit in progress.")
            exit()

        return code.lower()

if __name__ == "__main__":
    SSPJ()