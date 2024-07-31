// Example 1:

// Input: nums = [3,0,1]
// Output: 2
// Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

// Example 2:
// Input: nums = [0,1]
// Output: 2
// Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

// Example 3:
// Input: nums = [9,6,4,2,3,5,7,0,1]
// Output: 8
// Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.



//brute force 
// Brute Force Algorithm (missingNumberBruteForce):
// Main Method:
//    For each input array nums, calls missingNumberBruteForce and prints the result.
// missingNumberBruteForce Method:
//     Iterates through each number i from 0 to n (inclusive).
//     For each i, iterates through the array to check if i is present.
//    If i is not found in the array, returns i as the missing number

// import java.util.Arrays;

// public class missingNumber238 {
//   public static int bruteForce(int [] arr){
//     int n=arr.length;
//     for(int i=0; i<n; i++){
//       boolean found=false;
//       for(int j=0; j<n; j++){
//         if(arr[j]==i){
//           found= true;
//           break;
//         }
//       }
//       if(!found){
//         return i;
//       }
//     }
//     return -1;

//   }

//   public static void main(String[] args) {
//     int[] nums1 = {3, 0, 1};
//         int result1 = bruteForce(nums1);
//         System.out.println("Input: nums = " + Arrays.toString(nums1));
//         System.out.println("Output: " + result1);
    
//   }
// }







// Example 1: nums = [3, 0, 1]
// Initial Values:
// nums = [3, 0, 1]
// n = 3 (length of nums)
// Iterations:
// i = 0:

// found = false
// Inner loop checks:
// nums[0] = 3, not equal to 0
// nums[1] = 0, equal to 0
// found = true
// Since found = true, continue to the next i.
// i = 1:

// found = false
// Inner loop checks:
// nums[0] = 3, not equal to 1
// nums[1] = 0, not equal to 1
// nums[2] = 1, equal to 1
// found = true
// Since found = true, continue to the next i.
// i = 2:

// found = false
// Inner loop checks:
// nums[0] = 3, not equal to 2
// nums[1] = 0, not equal to 2
// nums[2] = 1, not equal to 2
// Since found = false, return i = 2.
// Output: 2



// optimized solution
// Optimized Algorithm (missingNumberOptimized):

// Main Method:
// For each input array nums, calls missingNumberOptimized and prints the result.
// missingNumberOptimized Method:
// Calculates the expected sum of the first n natural numbers using the formula n * (n + 1) / 2.
// Computes the actual sum of the elements in the array.
// Returns the difference between the expected sum and the actual sum as the missing number.



import java.util.Arrays;

public class missingNumber238 {
  public static int optimized(int [] arr){
    int n=arr.length;
    int exceptedSum=(n*(n+1))/2;
    int actualSum=0;
    for(int num:arr){
      actualSum+=num;

    }
    return exceptedSum-actualSum;
  }

  public static void main(String[] args) {
    int[] nums1 = {3, 0, 1};
        int result1 = optimized(nums1);
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + result1);
    
  }
}

