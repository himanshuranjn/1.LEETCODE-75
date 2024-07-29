// Example 1:
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

// Example 2:
// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]
 


// brute force algorithm

// 1.Initialize the Result Array:
//       a.Create an array result of the same length as nums and initialize all its elements to 1.

// 2.Nested Loops to Calculate the Product:
//     a. Use a nested loop where the outer loop iterates over each element in nums, and the inner loop calculates the product of all elements except the current one.
//      b.If the indices i and j are not the same, multiply the current element of result[i] by nums[j].

// 3.Output:
//    Print the result array for each input array.

// import java.util.Arrays;

// public class ProductOfArrayExceptSelf238 {
//   public static int [] bruteForce(int arr[]){
//     int n=arr.length;
//     // step 1 initilize result array with same size and all ara 1
//     int result[]=new int[n];
//     for(int i=0; i<n;i++){
//       result[i]=1;
//     }
//     // step 2 calculate the product of arr using nested loop
//     for(int i=0; i<n; i++){
//       for(int j=0; j<n; j++){
//         if(i!=j){
//           result[i]*=arr[j];
//         }
//       }
//     }
//     return result;
//   }

//   public static void main(String[] args) {
//     int arr1[]={1,2,3,4};
//     int result1[]=bruteForce(arr1);
//     System.out.println("output"+" "+Arrays.toString(result1));
//     // System.out.println("output");
//     // for(int num:result1){
//     //   System.out.print(num+" ");
//     // }
//     // System.out.println();
    
//   }
// }


// tc=O(n^2)
// sc=O(1)




// optimized solution


// algorithm
// 1.Initialize the result array: Start with an array result of the same length as nums and fill it with 1.

// 2.Calculate left products: Traverse the nums array from left to right, keeping track of the running product of all the elements to the left of the current element. Store this running product in the result array.

// 3.Calculate right products: Traverse the nums array from right to left, keeping track of the running product of all the elements to the right of the current element. Multiply the result array values with this running product.


import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {
  public static int [] bruteForce(int arr[]){
    int n=arr.length;
    // step 1 initilize result array with same size and all ara 1
    int result[]=new int[n];
    for(int i=0; i<n;i++){
      result[i]=1;
    }
    // step 2 calculate left product
    int leftProduct=1;
    for(int i=0; i<n; i++){
      result[i]*=leftProduct;
      leftProduct*=arr[i];
      
    }
    // step 3 calculate right product and update in leftproduct
    int rightProduct=1;
    for(int i=n-1;i>=0; i--){
      result[i]*=rightProduct;
      rightProduct*=arr[i];
    }
    return result;
  }

  public static void main(String[] args) {
    int arr1[]={1,2,3,4};
    int result1[]=bruteForce(arr1);
    System.out.println("output"+" "+Arrays.toString(result1));
    // System.out.println("output");
    // for(int num:result1){
    //   System.out.print(num+" ");
    // }
    // System.out.println();
    
  }
}


// Example 1: nums = [1, 2, 3, 4]
// Initialization:

// nums = [1, 2, 3, 4]
// length = 4
// result = [1, 1, 1, 1]
// Calculate Left Products:

// leftProduct = 1
// Iteration over nums:

// i = 0:

// result[0] *= leftProduct → result[0] = 1
// leftProduct *= nums[0] → leftProduct = 1 * 1 = 1
// result = [1, 1, 1, 1]
// i = 1:

// result[1] *= leftProduct → result[1] = 1
// leftProduct *= nums[1] → leftProduct = 1 * 2 = 2
// result = [1, 1, 1, 1]
// i = 2:

// result[2] *= leftProduct → result[2] = 2
// leftProduct *= nums[2] → leftProduct = 2 * 3 = 6
// result = [1, 1, 2, 1]
// i = 3:

// result[3] *= leftProduct → result[3] = 6
// leftProduct *= nums[3] → leftProduct = 6 * 4 = 24
// result = [1, 1, 2, 6]
// Calculate Right Products:

// rightProduct = 1
// Iteration over nums from end to start:

// i = 3:

// result[3] *= rightProduct → result[3] = 6
// rightProduct *= nums[3] → rightProduct = 1 * 4 = 4
// result = [1, 1, 2, 6]
// i = 2:

// result[2] *= rightProduct → result[2] = 2 * 4 = 8
// rightProduct *= nums[2] → rightProduct = 4 * 3 = 12
// result = [1, 1, 8, 6]
// i = 1:

// result[1] *= rightProduct → result[1] = 1 * 12 = 12
// rightProduct *= nums[1] → rightProduct = 12 * 2 = 24
// result = [1, 12, 8, 6]
// i = 0:

// result[0] *= rightProduct → result[0] = 1 * 24 = 24
// rightProduct *= nums[0] → rightProduct = 24 * 1 = 24
// result = [24, 12, 8, 6]
// Final output for nums1 is [24, 12, 8, 6].