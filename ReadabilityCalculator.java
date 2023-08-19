package readability;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static readability.Main.text;

public class ReadabilityCalculator {
    SentenceCounter sentenceCounter = new SentenceCounter();
    WordCounter wordCounter = new WordCounter();
    CharacterCounter characterCounter = new CharacterCounter();
    SyllableCounter syllableCounter = new SyllableCounter();

    double sentenceCount;
    double wordCount;
    double characterCount;
    double syllableCount;
    double polySyllableCount;

    public ReadabilityCalculator() {
        sentenceCount = sentenceCounter.countSentence(text);
        wordCount = wordCounter.countWord(text);
        characterCount = characterCounter.countCharacter(text);
        syllableCount = syllableCounter.countSyllables(text);
        polySyllableCount = syllableCounter.countPolysyllables(text);
    }
    
    public double calculateAutomatedIndex() {
        return 4.71 * characterCount / wordCount + 0.5 * wordCount / sentenceCount - 21.43;
    }
    public double calculateFleschKincaid() {
        return 0.39 * (wordCount / sentenceCount) + 11.8 * (syllableCount / wordCount) - 15.59;
    }
    
    public double calculateGobbledygook() {
        return 1.043 * Math.sqrt(polySyllableCount * 30 / sentenceCount) + 3.1291;
    }
    
    public double calculateColemanLiau() {
        double L = characterCount / wordCount * 100;
        double S = sentenceCount / wordCount * 100;

        return 0.0588 * L - 0.296 * S - 15.8;
    }

    public double calculateAverageIndex() {
        return (calculateAutomatedIndex() + calculateFleschKincaid() + calculateGobbledygook() + calculateColemanLiau()) / 4;
    }

    public int calculateReadingAge(double index) {
        double roundedScore = Math.ceil(index);
        int age = (int) (5 + roundedScore);

        if (age == 18) {
            age = 22;
        }

        return age;
    }

    public double calculateAverageAge() {
        return (calculateReadingAge(calculateAutomatedIndex()) + calculateReadingAge(calculateFleschKincaid())
                + calculateReadingAge(calculateGobbledygook()) + calculateReadingAge(calculateColemanLiau())) / 4.0;
    }

    public void printCounts(String text) {
        System.out.print("The text is:\n"
        + text + "\n\n"
        + "Words: " + (int) wordCount + "\n"
        + "Sentences: " + (int) sentenceCount + "\n"
        + "Characters: " + (int) characterCount + "\n"
        + "Syllables: " + (int) syllableCount + "\n"
        + "Polysyllables: " + (int) polySyllableCount + "\n");
    }

    public void printResults(String input) throws IOException {
        System.out.println();

        double result = 0;

        List<Double> fullResults = new ArrayList<>();
        String[] indices = {"Automated Readability Index: ", "Flesch-Kincaid readability tests: ", "Simple Measure of Gobbledygook: ", "Coleman-Liau index: "};

        switch (input) {
            case "ARI":
                result = calculateAutomatedIndex();
                System.out.print("Automated Readability Index: ");
                break;
            case "FK":
                result = calculateFleschKincaid();
                System.out.print("Flesch-Kincaid readability tests: ");
                break;
            case "SMOG":
                result = calculateGobbledygook();
                System.out.print("Simple Measure of Gobbledygook: ");
                break;
            case "CL":
                result = calculateColemanLiau();
                System.out.print("Coleman-Liau index: ");
                break;
            case "all":
                result = calculateAverageIndex();
                fullResults.add(calculateAutomatedIndex());
                fullResults.add(calculateFleschKincaid());
                fullResults.add(calculateGobbledygook());
                fullResults.add(calculateColemanLiau());
                break;
            default:
                throw new IOException();
        }

        if (fullResults.size() == 0) {
            System.out.print(String.format(Locale.ENGLISH, "%.2f ", result));
            System.out.println(String.format("(about %d-year-olds).", calculateReadingAge(result)));
        } else {
            for (int i = 0; i < fullResults.size(); i++) {
                System.out.print(indices[i]);
                System.out.print(String.format(Locale.ENGLISH, "%.2f ", fullResults.get(i)));
                System.out.println(String.format("(about %d-year-olds).", calculateReadingAge(fullResults.get(i))));
            }
            System.out.println(String.format(Locale.ENGLISH, "This text should be understood in average by %.2f-year-olds", calculateAverageAge()));
        }
    }
}
