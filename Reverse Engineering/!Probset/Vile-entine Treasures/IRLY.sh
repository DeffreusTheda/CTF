#!/bin/zsh

LOVE=$(tput setaf 211)
LOVELOVE=$(tput setaf 197)
YOU=$(tput setaf 161)
CLEAR=$(tput sgr0)

irly() {
  echo """Dear ${1:-my loved one},

  i love you <3"""

  sleep 4

  IRLY=(
    'your laugh'
    # 'your personality'
    # 'your hair'
    'your insecurities'
    # 'your accomplishments '
    # 'your failures '
    # 'your eyes'
    'your handsomeness'
    'you on your happy days'
    # 'you on your sad days'
    ''
    'you on the days you feel lonely'
    'you on the days you feel helpless'
    'you on the days you feel like no one cares'
    'you on the days you feel forgotten'
    'you on the days you feel unmotivated'
    # 'you on the days you feel loved'
    'you on the days you feel sick'
    'you on the days you feel motivated'
    'you on the days you feel depressed'
    # 'you on the days you feel stresses'
    'you on the days you feel crazy'
    'you on the days you feel hopeful'
    # 'you on the days you feel cuddly'
    'you on the days you feel clingy'
    # 'you on the days you feel amazing'
    'you on the days you feel beautiful'
    'you on the days you feel like a failure'
    'you on the days you feel angry'
    'you on the days you feel aggressive'
    # 'you on the days you feel horrible'
    # 'you on the days you feel safe'
    # 'you on the days you feel unsafe'
    # 'you on the days you feel vulnerable'
    'you on the days you feel weird'
    'you on the days you feel ok'
    ''
    # 'how you sing'
    'how you hum the music'
    # 'your taste in music'
    # 'your taste in movies'
    'your taste in tv shows'
    # 'the way you move'
    'the way you dance'
    'the way you act'
    ''
    # 'you when you cry '
    'you when you'\''re healthy'
    # 'you when you're mean'
    # 'you when you're alone'
    'you when you can'\''t feel'
    # 'you when you feel too much'
    # 'you when you can't take life anymore'
    # 'you when you feel like it's too much'
    # 'you when you're asleep '
    # 'you when you have nightmares'
    'you when you have dreams'
    # 'how you believe'
    'you when you believe in yourself'
    # 'you when you doubt'
    # 'you when you hate yourself'
    ''
    'you when you love yourself'
    'the way you think'
    'your problems'
    'your solutions'
    # 'how you support'
    'you when you'\''re adventurous '
    # 'you when you're energetic'
    # 'you when you're tired'
    'you when you'\''re in pain'
    'you when you'\''re hurt'
    # 'you when you're scared'
    # ''
    # 'your promises'
    # 'your secrets'
    'your attitude'
    'your creativity'
    'your voice'
    'your hand gestures'
    # 'your stories'
    # 'your wounds'
    'your scars'
    # 'your face'
    # 'your past'
    'your future'
    # 'your present'
    # 'your outfits'
    # 'your style'
    # 'your art'
    # 'your honesty'
    'your imperfections'
    # 'your perfections'
    ''
    # 'how you look'
    # 'you when you worry'
    'you when you talk'
    # 'you when you have a headache'
    'you when you have a stomach ache'
    'you when you help others'
    # 'you when you need help'
    # 'you when life is meh'
    # 'you when you'\''re irresponsible'
    # 'you when you fight'
    'you when you'\''re mature'
    'you when you'\''re immature'
    'you in the hard times'
    # 'you in the easy times'
    'you in your darkest moments'
    # 'you in your brightest moments'
    # 'your heart'
    'you in the day'
    'you in the night'
    'you at midnight'
    # 'you at 3 am '
    'you at all times'
    'you at your best'
    # 'you at your worst '
    # 'the little things you do'
  )

  echo
  for ILY in "${IRLY[@]}"; do
    sleep 0.25
    if [[ -n $ILY ]]; then echo -n $LOVE'i love '$CLEAR; fi
    echo $(echo $ILY | sed -E 's:(you\w*):'$YOU'\1'$CLEAR':')
  done

  IRRLY=(
    'you when you'\''are listening to breakcore'
    'your handwriting'
    'how you cook'
    'you when you'\''re avoiding my eyes'
    'you on the days you don'\''t know what to do'
    'you when you hide your remorse'
    'you when you'\''re working hard'
    'you when you'\''re tired'
    'you when you'\''re kind'
    'your smile'
  )

  echo
  for ILY in "${IRRLY[@]}"; do
    sleep 1.25
    echo -n $LOVE'i love '$CLEAR
    echo $ILY | sed -E 's:(you\w*):'$YOU'\1'$CLEAR':'
  done

  echo
  sleep 2
  echo $LOVE'i love'$CLEAR' all about you' | sed -E 's:(you\w*):'$YOU'\1'$CLEAR':'
  sleep 2
  echo $LOVE'i love'$CLEAR' you when you'\''re you' | sed -E 's:(you\w*):'$YOU'\1'$CLEAR':'

  echo
  sleep 1.5
  echo -n $LOVE'i '
  sleep 1.5
  echo -n $LOVE'love '
  sleep 2
  echo -n $LOVELOVE'𝙮𝙤𝙪 '
  sleep 1.5
  echo -n $LOVE"forever. "
  echo

  echo
  sleep 1
  echo "I promise that you can always come to me and sit with me, or you can talk to me, I promise, I will get back to you."
  sleep 6
  echo "You can always vent if you are in need of doing so, you can also pour your problems on me, I wont mind it."
  sleep 6
  echo "I think about you everyday, so never think if you are not good enough. <3"
  sleep 4
  echo "I love you dearly, so pick up your confidence and make sure you remember you're loved."
  sleep 4

  echo
  echo "- .effie"
}

validate_answer() {
  local input=$1
  local method=$2
  local expected=''

  (for i in {0..2}; do sleep 0.1; echo -n '.'; done; echo -n ' ')

  case $method in
    1) # we're often alone together
       stream=$(while read -r LINE; do if [[ $LINE =~ .*#.* ]]; then echo -n 0; else echo -n 1; fi; done <<<$(head -n 134 IRLY.sh | tail -n 119)); for i in {0..16}; do expected+=$(printf '%x' $(echo "ibase=2; ${stream:$((i * 7)):7}" | bc) | xxd -r -p); done
       [[ ${input:0:17} == $expected ]] && return 0 || return 1
       ;;
    
    2) # i went all it through hoping things will get better for him
       local temp=${input//[aeiou]/_}
       [[ ${temp:gs/_/x} == ${expected:gs/[aeiou]/x} ]]
       ;;
    
    3) # he plead my help for his love on someone else
       setopt extendedglob
       [[ $input == ${~expected} ]]
       ;;

    4) # can you imagine how it felt?
       typeset -A matrix_wannabe=(
         [0,0]=193 [0,1]=154 [0,2]=28 [0,3]=114 [0,4]=80 [0,5]=65 
         [1,0]=83 [1,1]=85 [1,2]=254 [1,3]=228 [1,4]=128 [1,5]=71 
         [2,0]=236 [2,1]=75 [2,2]=99 [2,3]=213 [2,4]=151 [2,5]=241 
         [3,0]=135 [3,1]=239 [3,2]=251 [3,3]=209 [3,4]=103 [3,5]=194 
         [4,0]=148 [4,1]=171 [4,2]=132 [4,3]=56 [4,4]=85 [4,5]=130 
         [5,0]=183 [5,1]=245 [5,2]=194 [5,3]=132 [5,4]=137 [5,5]=124 
       )
       hurtful=( 634 849 1015 1131 722 1015 )
       for i in {0..63}; do [[ ${matrix_wannabe[$i]} == ${expected} ]]; done
       [[ $result == $expected ]] || exit 1
       ;;

    5) # I couldn've cried if I were okay
       ;;
  esac
}

# Hide parts of answers in environment variables using indirection
typeset -A hints=(
    [1]=${${${PATH}#*/}%/*}    # Extract middle path component
    [2]=${$(ls -la)[(w)3]}     # Extract third word from ls output
)

# Use subshells to modify cursor position and reveal hints
reveal_hint() {
    local pos=$1
    (
        # Move cursor up several lines and print hint
        echo -en "\033[${pos}A"
        echo -en "\033[20C"
        echo "${hints[$1]}"
        # sleep 0.1
        # Clean up
        echo -en "\033[${pos}B"
    )
}

# Collect answers in a way that requires understanding of zsh arrays
final_key() {
    local -a answers
    answers=(${(v)collected_answers})
    
    # Use parameter expansion flags to transform answers
    local key=${(j:|:)answers}
    key=${key:l}  # Convert to lowercase
    key=${key//[^a-z0-9]/}  # Remove special chars
    
    # Use command substitution with sha256sum
    echo $key | sha256sum | cut -d' ' -f1
}

# Decrypt final message using OpenSSL
decrypt_flag() {
    local key=$(final_key)
    openssl enc -aes-256-cbc -d -in flag.txt -pass pass:$key
}

########################################################################################

typeset -A story=(
  [memory_1]="It's funny how we get along together because of a goddamn gacha game. Don't you remember?"
  [memory_2]=""
)

for i in {1..${#story}}; do
  memory="memory_$i"
    
  # typing effect
  for ((j=1; j<=${#story[$memory]}; j++)); do
    echo -n "${story[$memory]:0:$j}"
    # sleep 0.04
    echo -n $'\r'
  done
  echo "${story[$memory]}"

  read -r input
  if ! validate_answer $input $i; then
    echo 'Who are you?'
    exit 1
  fi
done

secret=${${(f)$(<$0)}[0,24]} # Gets lines 10-20
echo $secret
