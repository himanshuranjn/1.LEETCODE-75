// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:

// Input: strs = [""]
// Output: [[""]]

// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]
 

// 1.Initialize a HashMap: This map will store lists of anagrams. The key is the sorted version of the string, and the value is a list of strings that, when sorted, match this key.

// 2.Process Each String:
//    Convert the string to a character array and sort it.
//    Convert the sorted character array back to a string to use as a key.
//    Use this key to add the original string to the list in the HashMap.

//3. Return Results:
//   Extract the values from the HashMap, which are lists of grouped anagrams.
import java.util.*;

public class groupAnagrams49 {
    public static List<List<String>> optimize(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Map to group anagrams
        HashMap<String, List<String>> map = new HashMap<>();
        
        // Process each string in the input array
        for (String str : strs) {
            // Convert string to char array and sort it
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            
            // Convert sorted char array back to string
            String sortedStr = new String(charArray);
            
            // Group anagrams based on the sorted string
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        
        // Return grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // Example 1
        String[] example1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(optimize(example1)); // Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
        
        // Example 2
        String[] example2 = {""};
        System.out.println(optimize(example2)); // Output: [[""]]
        
        // Example 3
        String[] example3 = {"a"};
        System.out.println(optimize(example3)); // Output: [["a"]]
    }
}



// Edge Case Handling:

// If strs is null or empty, return an empty list.
// HashMap Creation:

// map is a HashMap where the key is the sorted version of the string, and the value is a list of strings that match this key.
// Processing Strings:

// For each string, convert it to a character array, sort the array, and use the sorted array as a key in the map.
// Use computeIfAbsent to simplify adding the string to the list associated with the key. If the key does not exist, it creates a new list.
// Result Collection:

// Convert the values of the map to a list and return it.
// This code efficiently groups anagrams and handles various edge cases, maintaining simplicity and clarity.


