
	import java.util.*;
	import java.io.*;

	public class WordCounter {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter '1' to input text, '2' to read from a file:");
	        int choice = scanner.nextInt();
	        scanner.nextLine(); // Consume the newline character
	        
	        String text = "";
	        if (choice == 1) {
	            System.out.println("Enter your text:");
	            text = scanner.nextLine();
	        } else if (choice == 2) {
	            System.out.println("Enter the file path:");
	            String filePath = scanner.nextLine();
	            text = readFromFile(filePath);
	        } else {
	            System.out.println("Invalid choice.");
	            return;
	        }

	        String[] words = text.split("[\\s.,;!?()\\[\\]{}\"]+"); // Split on spaces and common punctuation
	        int wordCount = words.length;
	        
	        System.out.println("Total words: " + wordCount);
	    }

	    public static String readFromFile(String filePath) {
	        StringBuilder content = new StringBuilder();
	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                content.append(line).append("\n");
	            }
	        } catch (IOException e) {
	            System.out.println("Error reading from file: " + e.getMessage());
	        }
	        return content.toString();
	    }
	}

