Project assignment from JetBrains Academy (www.hyperskill.org), Java Developer track.

This project scores the readability of a body of text.

The user supplies the text file via the command line and the program determines the text's readabiliy with four different methods.
The readability score and the age of comprehension of a given text is scored via the formulas below (wiki references included)

1) Automated readability index: 4.71 * (characters / words) + 0.5 (words /sentences) - 21.43

wiki reference: https://en.wikipedia.org/wiki/Automated_readability_index

2) Flesch-Kincaid readability tests: 0.39 * (words / sentences) + 11.8 * (syllables / words) - 15.59

wiki reference: https://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests

3) SMOG index: 1.043 * square root of (polysyllables * 30 / sentences) + 3.1291

wiki reference: https://en.wikipedia.org/wiki/SMOG

4) Coleman-Liau index: 0.0588 * L - 0.296 * S - 15.8, where L denotes number of characters per 100 words and S denotes number of
sentences per 100 words.

wiki reference: https://en.wikipedia.org/wiki/Coleman%E2%80%93Liau_index

The program counts and prints the number of sentences, words, characters, syllables, and polysyllables in the supplied text. The
user is then prompted with a number of choices where they can select to score the text's readability via only one method or try 
out all methods. In the latter case, the average readability via all four methods is also determined.

August 19th, 2023--description by E. Hsu (nahandove@gmail.com)