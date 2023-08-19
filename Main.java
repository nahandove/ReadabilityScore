package readability;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String text = "";

    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {

            while (fileReader.ready()) {
                text += fileReader.readLine();
            }

            ReadabilityCalculator calculator = new ReadabilityCalculator();
            
            calculator.printCounts(text);
            String input = getInput();

            calculator.printResults(input);
            
        } catch (IOException e) {
            System.out.println("Something went wrong while trying to read file");
        }
    }
    
    public static String getInput() {

        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter the score you want to calculate(ARI, FK, SMOG, CL, all): ");
            return inputReader.readLine();

        } catch (IOException e) {
            System.out.println("Invalid input.");
        }
        return null;
    }
}
