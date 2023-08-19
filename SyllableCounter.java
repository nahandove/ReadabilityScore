package readability;

import java.util.List;

public class SyllableCounter {
    static List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public double countSyllables(String text) {
        String[] words = text.split("\\s+");
        double syllableCount = 0;

        for (String word: words) {
            int syllablesPerWord = 0;

            if (vowels.contains(word.charAt(0))) {
                syllableCount++;
                syllablesPerWord++;
            }

            for (int i = 1; i < word.length(); i++) {

                if (vowels.contains(word.charAt(i))) {
                    if (vowels.contains(word.charAt(i - 1))) {
                        continue;
                    }
                    syllableCount++;
                    syllablesPerWord++;
                }
            }

            if (word.endsWith("e") && syllablesPerWord >= 2) {
                syllableCount--;
            }
        }

        return syllableCount;
    }
    public double countPolysyllables(String text) {
        String[] words = text.split("\\s+");

        int syllablesPerWord = 0;
        int polysyllableCount = 0;

        for (String word: words) {
            syllablesPerWord = 0;

            if (vowels.contains(word.charAt(0))) {
                syllablesPerWord++;
            }

            for (int i = 1; i < word.length(); i++) {
                if (vowels.contains(word.charAt(i))) {
                    if (vowels.contains(word.charAt(i - 1))) {
                        continue;
                    }
                    syllablesPerWord++;
                }
            }

            if (word.endsWith("e") && syllablesPerWord >= 2) {
                syllablesPerWord--;
            }

            if (syllablesPerWord > 2) {
                polysyllableCount++;
            }
        }

        return polysyllableCount;
    }
}
