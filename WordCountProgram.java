import java.util.*;
import java.io.*;

public class WordCountProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Word Count Program");
        System.out.println("1. Enter text");
        System.out.println("2. Provide a file");
        System.out.print("Select an option: ");
        
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        
        String text = "";
        
        switch (option) {
            case 1:
                System.out.print("Enter text: ");
                text = scanner.nextLine();
                break;
            case 2:
                System.out.print("Enter file path: ");
                String filePath = scanner.nextLine();
                text = readFile(filePath);
                break;
            default:
                System.out.println("Invalid option.");
                scanner.close();
                return;
        }
        
        String[] words = text.split("[\\s.,;?!()\"']+");
        int wordCount = words.length;
        
        System.out.println("Total word count: " + wordCount);
        
        // Additional features could be added here (e.g., ignoring common words, statistics, etc.).
        
        scanner.close();
    }
    
    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        
        return content.toString();
    }
}
