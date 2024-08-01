// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

// brute force algorithm

// 1.Initialize maxLength to 0.
//2. Loop through each character in the string (i from 0 to s.length() - 1).
// 3.For each character, check every possible substring starting from that character (j from i to s.length() - 1).
//4. For each substring, check if all characters are unique using a helper function allUnique.
//5. If the substring has all unique characters, update maxLength.
//6. Return maxLength.


// public class longestSubstringWithoutRepeatingCharacter3 {
//   public static int bruteforce(String s){
//     int maxLength=0;
//     for(int i=0; i<s.length(); i++){
//       for(int j=0; j<s.length(); j++){
//         if(allUnique(s,i,j)){
//           maxLength=Math.max(maxLength,j-i+1);
//         }
//       }
//     }
//     return maxLength;
//   }

//   public static boolean allUnique(String s,int start,int end){
    

// // boolean[] chars = new boolean[128]; initializes a boolean array of size 128.
// // The size 128 is chosen because it covers all ASCII characters (0 to 127).
//     boolean[] chars = new boolean[128];
//     for (int i = start; i <= end; i++) {
//         if (chars[s.charAt(i)]) {
//             return false;
//         }
//         chars[s.charAt(i)] = true;
//     }
//     return true;


//   }

//   public static void main(String[] args) {
//     System.out.println(bruteforce("abcabcbb")); // Output: 3
//         System.out.println(bruteforce("bbbbb"));    // Output: 1
//         System.out.println(bruteforce("pwwkew"));   // Output: 3
    
//   }
// }



// optimized solution

// using sliding window

// 1.Initialization:
//    Map<Character, Integer> map: This map stores the most recent index of each character.
//    int maxLength = 0: This keeps track of the maximum length of substrings without repeating characters.
//     int left = 0: This represents the starting index of the current window of characters being examined.

// 2.Sliding Window:
//      a.Iterate over the string with a right pointer (for (int right = 0; right < s.length(); right++)).
//     b.Update the Left Pointer:
//           If the current character (s.charAt(right)) is already in the map (i.e., it has been seen before), update the left pointer to the right of the last occurrence of the current character. This ensures the substring starting from the new left position to right contains no duplicate characters.
//          left = Math.max(left, map.get(s.charAt(right)) + 1);
//     b. Update the Map:
//           Update the map with the current character's latest index.
//            map.put(s.charAt(right), right);
//      c.Calculate Maximum Length:
//         Update maxLength with the maximum value between the current maxLength and the length of the current window (right - left + 1).

// Return the Result:
// After processing all characters, maxLength contains the length of the longest substring without repeating characters.

import java.util.HashMap;

public class longestSubstringWithoutRepeatingCharacter3 {
  public static int optimize(String s){
    int maxLength=0;
    int left=0;
    HashMap<Character,Integer> map=new HashMap<>();
    for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }
            map.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(optimize("abcabcbb")); // Output: 3
        System.out.println(optimize("bbbbb"));    // Output: 1
        System.out.println(optimize("pwwkew"));   // Output: 3

    
  }
}