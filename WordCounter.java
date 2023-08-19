package readability;

public class WordCounter {
    public double countWord(String text) {
        double wordCount = 0;

        String[] sentences = text.trim().split("[?.!]");

        for (String sentence : sentences) {
            String[] words = sentence.trim().split("\\s+");
            wordCount += words.length;
        }

        return wordCount;
    }
}
