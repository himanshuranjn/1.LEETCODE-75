// Example 1:
// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// Example 2:
// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.




// bruteforce 
// algorithm
//1. Initialization:
//     a.maxProduct is initialized to the smallest possible integer value to handle negative numbers in the array.

//2.Nested Loop:
//    a.The outer loop iterates over each element of the array as the starting point of the subarray.
//    b.The inner loop iterates from the current starting point to the end of the array, calculating the product of the subarray that starts at the outer loop index and ends at the inner loop index.
//    c.currentProduct keeps the running product of the current subarray.

// 3.Update Maximum Product:
//    After calculating the product of the current subarray, update maxProduct if currentProduct is greater than maxProduct.

// 4.Return Result:
//     After iterating through all possible subarrays, maxProduct contains the largest product, which is returned as the result.


// public class maximumProductSubArray152 {
//   public static int bruteforce(int arr[]){
//     int n=arr.length;
//     int maxProduct=Integer.MIN_VALUE;
    
//     for(int i=0; i<n; i++){
//       int currentProduct=1;
//       for(int j=i; j<n; j++){
//         currentProduct*=arr[i];
//         maxProduct=Math.max(currentProduct,maxProduct);
//       }


//     }
//     return maxProduct;

//   }
//   public static void main(String[] args) {
//     int arr[]={2,3,-2,4};
//     System.out.println("maximum Product subArray"+" "+bruteforce(arr));
    
//   }
// }



// optimized solution

// algorithm
//1. Initialization:
//     a.maxProduct is initialized to the first element of the array. This keeps track of the maximum product subarray ending at the current position.
//     b.minProduct is also initialized to the first element of the array. This keeps track of the minimum product subarray ending at the current position (important for cases when the current element is negative).
//     c.result is initialized to the first element of the array. This will store the maximum product found so far.

// 2.Iteration:
//    a.Loop through the array starting from the second element.
//    b.If the current element is negative, swap maxProduct and minProduct because multiplying by a negative number flips the maximum and minimum.
//    c.Update maxProduct to be the maximum of the current element itself or the product of maxProduct and the current element.
//    d.Update minProduct to be the minimum of the current element itself or  the product of minProduct and the current element.
//    e.Update result to be the maximum of result and maxProduct.

// 3.Return Result:
//   After the loop, result contains the maximum product subarray, which is returned as the result.


public class maximumProductSubArray152 {
  public static int optimized(int arr[]){
    int n=arr.length;
    // step1
    int maxProduct=arr[0];
    int minProduct=arr[0];
    int result=arr[0];

    // step2 
    for(int i=1; i<n; i++){
      // step 3 if number is negative than swap between maxProduct and minProduct
      if(arr[i]<0){
        int temp=maxProduct;
        maxProduct=minProduct;
        minProduct=temp;
      }
      // update maxProduct and minproduct
      maxProduct=Math.max(arr[i],maxProduct*arr[i]);
      minProduct=Math.min(arr[i],minProduct*arr[i]);
      result=Math.max(result,maxProduct);
       

    }
    return result;


  }
  public static void main(String[] args) {
    int arr[]={2,3,-2,4};
    System.out.println("maximum Product subArray"+" "+optimized(arr));
    
    
  }
}


