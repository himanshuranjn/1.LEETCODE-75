// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.

// Example 2:
// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.

// Example 3:
// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.
 


// brute force algorithm

// 1.Sorting:
//     The array is sorted to help handle duplicates and make it easier to find triplets.

// 2.Triple Loop:
//     a.The outer loop iterates through the array for the first number of the triplet.
//     b.The middle loop iterates for the second number of the triplet.
//     c.The inner loop iterates for the third number of the triplet.
//     d.For each combination of numbers, check if their sum is zero.

// 3.Avoiding Duplicates:
//     a.Before proceeding to the next iteration, check if the current number is the same as the previous one. If it is, skip the iteration to avoid duplicate triplets.

// 4.Adding to Result:
//    If the sum of the triplet is zero, add it to the result list.

//5. Return Result:
//    After all iterations, return the list of unique triplets that sum up to zero.

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// public class threeSum15 {
//   public static List<List<Integer>> bruteforce(int arr[]){
//     List<List<Integer>> result=new ArrayList<>();
//     // Sort the array to handle duplicates and make it easier to find triplets
//     Arrays.sort(arr);
//     int n=arr.length;
//     for(int i=0; i<n; i++){
//        // Avoid duplicates for the first number
//       if(i>0 && arr[i]==arr[i-1]) continue;
//       for(int j=i+1; j<n; j++){
//         // Avoid duplicates for the second number
//         if(j>i+1 && arr[j]==arr[j-1]) continue;
//         for(int k=j+1; k<n; k++){
//           // Avoid duplicates for the third number
//           if(k>j+1 && arr[k]==arr[k-1]) continue;
//           if(arr[i]+arr[j]+arr[k]==0){
//             result.add(Arrays.asList(arr[i],arr[j],arr[k]));
  
//           }
//         }  
//       }

//     }  
//       return result;

//   }

//   public static void main(String[] args) {
//     int arr[]={-1,0,1,2,-1,-4};
//     System.out.println("threeSum"+" "+bruteforce(arr));
    
//   }
// }




// optimized solution


// algorithm
// 1.Sorting:
//     Sort the array to simplify finding duplicates and to use the two-pointer technique effectively.

//2. Iterate and Search:
//     a.Iterate through the array with index i. For each i, use two pointers (left and right) to find two numbers such that the sum of nums[i], nums[left], and nums[right] is zero.
//     b.If the sum is zero, add the triplet to the result list. Skip duplicates by moving the left and right pointers past duplicate values.
//     c.If the sum is less than zero, move the left pointer to the right to increase the sum.
//     d.If the sum is greater than zero, move the right pointer to the left to decrease the sum.

// 3.Avoid Duplicates:
//    Skip over duplicate elements for the i index and for the left and right pointers to ensure that each triplet is unique.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum15 {
  public static List<List<Integer>> optimized(int arr[]){
    List<List<Integer>> result=new ArrayList<>();
    // base condition
    int n=arr.length;
    if(arr==null || n==0){
      return result;

    }

    Arrays.sort(arr);

    for(int i=0; i<n-2; i++){
      // skip the first duplicate element
      if(i>0 && arr[i]==arr[i-1]) continue;

      
      // take two pointer left and right
      int left=0;
      int right=n-1;
      while(left<right){
        int sum=arr[i]+arr[left]+arr[right];
        if(sum==0){
          result.add(Arrays.asList(arr[i],arr[left],arr[right]));

          // skip duplicates values for second and third element
          while(left<right && arr[left]==arr[left+1]){
            left++;
          }
          while(left<right && arr[right]==arr[right-1]){
            right--;
          }
          left++;
          right--;

        }
        else if(sum<0){
          left++;
        }
        else{
          right--;

        }

      }


    }
    return result;
    
  }

  public static void main(String[] args) {
    int arr[]={-1,0,1,2,-1,-4};
    System.out.println("threeSum"+" "+optimized(arr));
    
  }
}