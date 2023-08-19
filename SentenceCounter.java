package readability;

public class SentenceCounter {
    public double countSentence(String text) {
        return text.trim().split("[!.?]").length;
    }
}
