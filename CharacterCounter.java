package readability;

public class CharacterCounter {
    public double countCharacter(String text) {
        double sentenceEndCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '!' || text.charAt(i) == '.' || text.charAt(i) == '?') {
                sentenceEndCount++;
            }
        }

        double characterCount = sentenceEndCount;

        String[] sentences = text.trim().split("[!.?]");

        for (String sentence: sentences) {
            String[] words = sentence.split("\\s+");
            for (String word: words) {
                characterCount += word.length();
            }
        }
        return characterCount;
    }
}
