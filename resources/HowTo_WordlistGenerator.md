# Wordlist for Hangman 
This is a HowTo for the Wordlist-Generator. The Command below only selects nouns between the length of 10 and 20.
##command:
`cat ngerman | awk 'length(bash)>10 && length(bash)<20' | grep -o '\<[A-Z][a-z]*\>' > nouns_10-20.txt `

##origin of word list:
https://github.com/davidblitz/german-wordlist
