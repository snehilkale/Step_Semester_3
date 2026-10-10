package assignemnt;

import java.util.*;

public class WordFrequencyReport {
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }
        
        // Define stop words list/set
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));
        
        // Normalize: lowercase and strip punctuation (periods and commas)
        String normalized = feedback.toLowerCase().replace(".", "").replace(",", "");
        
        // Split by whitespace pattern
        String[] words = normalized.split("\\s+");
        
        // Count frequencies using HashMap
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        
        // Sort by count in descending order
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        // Print results
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
    }
}

