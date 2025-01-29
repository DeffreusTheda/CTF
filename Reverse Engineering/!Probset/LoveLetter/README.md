inspo: https://www.youtube.com/watch?v=8VbwWVvw-zI

charset = "1234567890" + "QWERTYUIOPASDFGHJKLZXCVBNM" + ",.!?\"-~_';:" + "qwertyuiopasdfghjklzxcvbnm"

Check A: Punctuation
FOR (!), (?), or (.): +10 IF there is a capital letter 3 chars ahead ELSE -10
+20 IF the last character in the letter is (!), (?), or (.)

Check B: Trigram Check
FOR every word that start with a common trigram (first 3 character) DO increment _counter_
+(_counter_ * 3)

Check C: Starting Capital Check
+20 IF the first non-whitespace character is capitalized ELSE -10

Check D: Sequential Character Check
-50 IF the same alphabet character is repeated 3 times consecutively

Check E: Space Ratio Check
-20 IF ((WHITESPACE_COUNT * 100) / NON_WHITESPACE_COUNT) < 20 ELSE +20
-20 IF all character in the letter is whitespace

Check F: Run-on Sentence Check
-150 IF the letter length > 75 characters AND no punctuation in the letter

Check G: Space Every 32-characters Check
-20 FOR each group of 32-characters that doesn't have any whitespace

FINALLY: good response IF total points >= 100 ELSE (bad response IF total points < 50)
