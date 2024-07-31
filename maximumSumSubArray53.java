// Example 1:
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

// Example 2:
// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.

// Example 3:
// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


// bruteforce 

// algorithm
// 1.Outer Loop (i): Iterates over the starting point of the subarray.
//2. Middle Loop (j): Iterates over the ending point of the subarray.
// 3.Inner Loop (k): Sums up the elements of the subarray from i to j.
//4. Max Sum Check: After summing up the elements of the current subarray, check if the current sum is greater than the maxSum. If it is, update maxSum.


// public class maximumSumSubArray53 {
//   public static int bruteforce(int arr[]){
//     int maxSum=Integer.MIN_VALUE;
//     int n=arr.length;
//     for(int i=0; i<n; i++){ // outer loop iterate  over the starting point of the subarray
//       for(int j=i; j<n; j++){// middile loop :iterate for the ending point of the subarray
//         int currentSum=0;
//         for(int k=i; k<=j; k++){
//           currentSum+=arr[k];

//         }
//         if(currentSum>maxSum){
//           maxSum=currentSum;
//         }

//       }


//     }
//     return maxSum;
//   }

//   public static void main(String[] args) {
//     int arr[]={-2,1,-3,4,-1,2,1,-5,4};
//     System.out.println("maximum subarray"+" "+bruteforce(arr));
    
//   }
// }



// optimized solution
// algorithm
// 1.Initialization:
//     a.maxCurrent is initialized to the first element of the array. This keeps track of the maximum subarray sum ending at the current position.
//    b.maxGlobal is also initialized to the first element of the array. This keeps track of the maximum subarray sum found so far.

// 2.Iteration:
//     a.Loop through the array starting from the second element.
//     b.For each element, update maxCurrent to be the maximum of the current element itself or the sum of maxCurrent and the current element. This decides whether to start a new subarray at the current element or to continue with the existing subarray.
//    c.If maxCurrent is greater than maxGlobal, update maxGlobal to be maxCurrent.

// 3.Return Result:
//     After the loop, maxGlobal contains the maximum subarray sum, which is returned as the result.


// public class maximumSumSubArray53 {
//   public static int optimized(int arr[]){
//     int n=arr.length;
//     // step 1
//     int maxCurrent=arr[0];
//     int maxGlobal=arr[0];
//     // step 2
//     for(int i=1; i<n; i++){
//       maxCurrent=Math.max(arr[i],maxCurrent+arr[i]);
//       // step 3
//       if(maxCurrent>maxGlobal){

//         maxGlobal=maxCurrent;

//       }


//     }
//     return maxGlobal;

//   }
//   public static void main(String[] args) {
//     int arr[]={-2,1,-3,4,-1,2,1,-5,4};
//     System.out.println("maximum subarray"+" "+optimized(arr));
    
    
//   }
// }



