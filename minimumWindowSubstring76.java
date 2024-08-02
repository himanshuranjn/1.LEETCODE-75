// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

// Example 2:
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.

// Example 3:
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.
 


// optimized
// 1.Initialize Variables:
//          tCount: A hashmap to count the frequency of each character in t.
//         windowCount: A hashmap to count the frequency of each character in the current window of s.
//           required: The number of unique characters in t that must be present in the window.
//           formed: The number of unique characters that meet the required frequency in the current window.
//          left, right: Pointers for the sliding window.
//         minLen, minLeft, minRight: To track the minimum window size and its boundaries.

// 2.Expand the Window:
//     Move the right pointer to expand the window.
//       Update windowCount and formed if the current character's frequency matches the required frequency in tCount.

// 3.Shrink the Window:
//       Move the left pointer to shrink the window from the left if all required characters are present.
//         Update minLen, minLeft, and minRight if a smaller valid window is found.
//       Adjust windowCount and formed accordingly.

// 4.Return Result:
// Return the minimum window substring if found; otherwise, return an empty string.

import java.util.HashMap;
import java.util.Map;

public class minimumWindowSubstring76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Count characters in t
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        // Number of unique characters in t that must be present in the window
        int required = tCount.size();

        // Sliding window pointers and other variables
        int left = 0, right = 0, formed = 0;
        Map<Character, Integer> windowCount = new HashMap<>();
        int minLen = Integer.MAX_VALUE, minLeft = 0, minRight = 0;

        // Expand the window
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if (tCount.containsKey(c) && windowCount.get(c).intValue() == tCount.get(c).intValue()) {
                formed++;
            }

            // Shrink the window
            while (left <= right && formed == required) {
                c = s.charAt(left);
                
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }

                windowCount.put(c, windowCount.get(c) - 1);
                if (tCount.containsKey(c) && windowCount.get(c).intValue() < tCount.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);
    }

    public static void main(String[] args) {
        minimumWindowSubstring76 solution = new minimumWindowSubstring76();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
        System.out.println(solution.minWindow("a", "a")); // Output: "a"
        System.out.println(solution.minWindow("a", "aa")); // Output: ""
    }
}

