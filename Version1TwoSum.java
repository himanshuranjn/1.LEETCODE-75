// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]

// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]



// Algorithm Explanation:
// 1.Nested Loops for Pair Checking:
//        The outer loop iterates through each element in the array with index i.
//        The inner loop iterates through the elements following the i-th element, with index j.
// 2.Sum Check:
//        For each pair of elements (nums[i], nums[j]), the algorithm checks if their sum equals the target.
//        If the sum equals the target, it returns the indices [i, j].
// 3.No Solution Case:
//       If no such pair is found by the end of the loops, the algorithm throws an IllegalArgumentException.







// public class Version1TwoSum {
//   // Method to find two indices in the array that sum up to the target
//   public static int[] twoSum(int[] nums, int target) {
//       // Iterate over each element in the array
//       for (int i = 0; i < nums.length; i++) {
//           // For each element, iterate over the subsequent elements
//           for (int j = i + 1; j < nums.length; j++) {
//               // Check if the sum of the current pair equals the target
//               if (nums[i] + nums[j] == target) {
//                   // If true, return the indices of the elements
//                   return new int[] { i, j };
//               }
//           }
//       }
//       // If no such pair is found, throw an exception
//       throw new IllegalArgumentException("No two sum solution");
//   }

//   // Main method to test the twoSum method
//   public static void main(String[] args) {
//       // Test case 1
//       int[] nums1 = {2, 7, 11, 15};
//       int target1 = 9;
//       int[] result1 = twoSum(nums1, target1);
//       System.out.println("Output: [" + result1[0] + "," + result1[1] + "]");

//       // Test case 2
//       int[] nums2 = {3, 2, 4};
//       int target2 = 6;
//       int[] result2 = twoSum(nums2, target2);
//       System.out.println("Output: [" + result2[0] + "," + result2[1] + "]");

//       // Test case 3
//       int[] nums3 = {3, 3};
//       int target3 = 6;
//       int[] result3 = twoSum(nums3, target3);
//       System.out.println("Output: [" + result3[0] + "," + result3[1] + "]");
//   }
// }


// Time Complexity:
// The time complexity is 
//  O(n^2) because it uses two nested loops, each iterating through the array.

// Space Complexity:
// The space complexity is 
// O(1) because it uses a constant amount of extra space.







// better solution


// algorithm

// 1.Initialization: Create a HashMap to store the number and its index.
// 2.Iteration: Loop through the array using a for loop.
// 3.Complement Calculation: For each element nums[i], calculate complement = target - nums[i].
// 4.Complement Check:
//      If the complement exists in the map, it means we have found two numbers that add up to the target.
//      Return the indices of the complement and the current element.

// 5.Map Update: If the complement does not exist in the map, add the current element and its index to the map.

// 6.Edge Case Handling: Though the problem guarantees a solution, return an empty array if no solution is found (this line is more for safety).


import java.util.HashMap;

public class Version1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the value and its corresponding index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the complement (target - current element) exists in the map
            if (map.containsKey(complement)) {
                // If it exists, return the indices of the current element and the complement
                return new int[] { map.get(complement), i };
            }
            
            // If it doesn't exist, add the current element and its index to the map
            map.put(nums[i], i);
        }
        
        // If no solution is found, return an empty array (though the problem guarantees one solution)
        return new int[0];
    }

    public static void main(String[] args) {
        Version1TwoSum solution = new Version1TwoSum();
        
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Output: [" + result1[0] + "," + result1[1] + "]"); // Output: [0,1]
        
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Output: [" + result2[0] + "," + result2[1] + "]"); // Output: [1,2]
        
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Output: [" + result3[0] + "," + result3[1] + "]"); // Output: [0,1]
    }
}


// time complexity =O(n)
// space complexicity=O(n)






