// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:
// Input: s = "rat", t = "car"
// Output: false



// algorithm
// 1.Check Lengths: If the lengths of the two strings are different, they cannot be anagrams.
//2. Count Frequencies: Use an array of size 26 (for each letter of the alphabet) to count the frequency of each character in both strings.
// 3.Compare Frequencies: If the frequency counts of all characters match, the strings are anagrams; otherwise, they are not.

public class validAnagram242 {
  public static boolean optimize(String s,String t){
        // If lengths are different, they cannot be anagrams

    if(s.length()!=t.length()){
      return false;
    }
        // Create a frequency count array for 26 letters

    int count []=new int[26];
        // Increment count for characters in s and decrement for characters in t

    for(int i=0; i<s.length(); i++){
      count[s.charAt(i)-'A']++;
      count[t.charAt(i)-'A']--;
    }
        // Check if all counts are zero

    for(int i=0; i<26; i++){
      if(count[i]!=0){
        return true;
      }

    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(optimize("anagram", "nagaram")); // Output: true
    System.out.println(optimize("rat", "car")); // Output: false

    
  }
}


// Example 1: s = "anagram", t = "nagaram"
// Initial Length Check:

// s.length() = 7
// t.length() = 7
// Lengths are equal, so we proceed.
// Frequency Array Initialization:

// count = [0, 0, 0, ..., 0] (26 zeros).
// Update Frequency Array:

// For i = 0:
// s.charAt(0) = 'a' → count['a' - 'a']++ → count[0]++ → count[0] = 1
// t.charAt(0) = 'n' → count['n' - 'a']-- → count[13]-- → count[13] = -1
// For i = 1:
// s.charAt(1) = 'n' → count['n' - 'a']++ → count[13]++ → count[13] = 0
// t.charAt(1) = 'a' → count['a' - 'a']-- → count[0]-- → count[0] = 0
// For i = 2:
// s.charAt(2) = 'a' → count['a' - 'a']++ → count[0]++ → count[0] = 1
// t.charAt(2) = 'g' → count['g' - 'a']-- → count[6]-- → count[6] = -1
// For i = 3:
// s.charAt(3) = 'g' → count['g' - 'a']++ → count[6]++ → count[6] = 0
// t.charAt(3) = 'a' → count['a' - 'a']-- → count[0]-- → count[0] = 0
// For i = 4:
// s.charAt(4) = 'r' → count['r' - 'a']++ → count[17]++ → count[17] = 1
// t.charAt(4) = 'r' → count['r' - 'a']-- → count[17]-- → count[17] = 0
// For i = 5:
// s.charAt(5) = 'a' → count['a' - 'a']++ → count[0]++ → count[0] = 1
// t.charAt(5) = 'a' → count['a' - 'a']-- → count[0]-- → count[0] = 0
// For i = 6:
// s.charAt(6) = 'm' → count['m' - 'a']++ → count[12]++ → count[12] = 1
// t.charAt(6) = 'm' → count['m' - 'a']-- → count[12]-- → count[12] = 0
// Check Frequency Array:

// All elements in count are 0.
// Return true.
// Output: true

// Example 2: s = "rat", t = "car"
// Initial Length Check:

// s.length() = 3
// t.length() = 3
// Lengths are equal, so we proceed.
// Frequency Array Initialization:

// count = [0, 0, 0, ..., 0] (26 zeros).
// Update Frequency Array:

// For i = 0:
// s.charAt(0) = 'r' → count['r' - 'a']++ → count[17]++ → count[17] = 1
// t.charAt(0) = 'c' → count['c' - 'a']-- → count[2]-- → count[2] = -1
// For i = 1:
// s.charAt(1) = 'a' → count['a' - 'a']++ → count[0]++ → count[0] = 1
// t.charAt(1) = 'a' → count['a' - 'a']-- → count[0]-- → count[0] = 0
// For i = 2:
// s.charAt(2) = 't' → count['t' - 'a']++ → count[19]++ → count[19] = 1
// t.charAt(2) = 'r' → count['r' - 'a']-- → count[17]-- → count[17] = 0
// Check Frequency Array:

// count array has non-zero values (count[2] = -1, count[19] = 1).
// Return false.
// Output: false

