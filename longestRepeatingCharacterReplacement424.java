// Example 1:
// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

// Example 2:
// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.

// brute force 
// algorithm

// 1.Initialize maxLength: This variable keeps track of the maximum length of the valid substring found so far.

// 2.Outer Loop (i loop): Iterate through each character in the string as the starting point of the substring (i from 0 to s.length() - 1).

// 3.Inner Loop (j loop): For each starting point i, iterate through the remaining characters as the ending point of the substring (j from i to s.length() - 1).

//4. Count Characters in Substring: For each substring defined by i and j, count the frequency of each character using an array count of size 26 (one entry for each letter of the alphabet).

//5. Find the Maximum Frequency Character: Determine the maximum frequency of any single character in the current substring.

//6. Check Replacement Feasibility: Calculate the number of replacements needed to make all characters in the substring the same. This is given by the length of the substring (j - i + 1) minus the count of the most frequent character. If this value is less than or equal to k, update maxLength if the current substring length is greater.

//7. Return maxLength: After all iterations, return the maximum length of a valid substring found.


// public class longestRepeatingCharacterReplacement424 {

//   public static int bruteForce(String s,int k){
//     int n=s.length();
//     int maxLength=0;

//     // outer loop: starting point of the  loop
//     for(int i=0; i<n; i++){
//       // inner loop: ending point of the substring
//       for(int j=i; j<n; j++){
//         // Array to count the frequency of each character in the current substring
//         int count[]=new int[26];
//         // Count the frequency of characters in the current substring
//         for(int l=i; l<j; l++){
//           count[s.charAt(l)-'A']++;
//         }
//         // Find the maximum frequency of any single character in the substring
//         int maxCharCount=0;
//         for(int c:count){
//           maxCharCount=Math.max( maxCharCount,c);

//         }
//         // Check if the number of replacements needed is within the allowed limit k
//         if (j - i + 1 - maxCharCount <= k) {
//           // Update maxLength if the current substring is valid and longer than previous ones
//           maxLength = Math.max(maxLength, j - i + 1);
//       }


//       }
//     }
//     return maxLength;


//   }

//   public static void main(String[] args) {
    // System.out.println(bruteForce("ABAB", 2)); // Output: 4
    //     System.out.println(bruteForce("AABABBA", 1)); // Output: 4

//   }
// }


// optimized solution using sliding window


// algorithm
// 1.Initialize Variables:
//      count: An array of size 26 to keep track of the frequency of each character in the current window.
//       maxCount: Tracks the count of the most frequent character in the current window.
//       maxLength: Keeps track of the maximum length of the valid substring found.
//      left: The left boundary of the sliding window.

//2. Expand the Window:
//      Iterate through each character in the string with the right boundary (right).
//      Increment the frequency count of the character at the right position and update maxCount to the highest frequency in the window.

// 3.Shrink the Window if Necessary:
//         If the number of replacements needed (right - left + 1 - maxCount) exceeds k, shrink the window from the left by incrementing the left pointer and decrementing the frequency count of the character at the left position.

// 4.Update Maximum Length:
//        Update maxLength to the maximum value between the current maxLength and the length of the current window (right - left + 1).

// 5.Return maxLength:
//     After processing all characters, return the maximum length of a valid substring found.


public class longestRepeatingCharacterReplacement424 {
  public static int optimize(String s,int k){
    int[] count = new int[26]; // Frequency array for characters
 int maxCount = 0; // Max frequency of any single character in the current window
 int maxLength = 0; // Max length of valid substring found

 // using sliding window
 int left=0;
 int n=s.length();

 for(int right=0; right<n; right++){
  //Increment the frequency count of the current character
   maxCount=Math.max(maxCount,++count[s.charAt(right)-'A']);
   // If replacements needed exceed k, shrink the window from the left
  while(right-left+1-maxCount<k){
    count[s.charAt(left)]--;
    left++;
  }
  // Update maxLength with the size of the current valid window
  maxLength=Math.max(maxLength, right-left+1);
 }
 return maxLength;

  }
  
  public static void main(String[] args) {
    System.out.println(optimize("ABAB", 2)); // Output: 4
        System.out.println(optimize("AABABBA", 1)); // Output: 4

    
  }
}