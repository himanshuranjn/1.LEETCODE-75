// Example 1:
// Input: nums = [3,4,5,1,2]
// Output: 1
// Explanation: The original array was [1,2,3,4,5] rotated 3 times.

// Example 2:
// Input: nums = [4,5,6,7,0,1,2]
// Output: 0
// Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times

// Example 3:
// Input: nums = [11,13,15,17]
// Output: 11
// Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
 

// brute force 

// algorithm
//1. Initialization:
//    a.Check if the input array is null or empty and throw an exception if it is.
//    b.Initialize the min variable to the first element of the array.

//2. Iteration:
//    a.Loop through the array starting from the second element.
//    b.For each element, compare it with min. If the current element is smaller than min, update min.

// 3.Return Result:
//      After the loop, min contains the minimum element of the array, which is returned as the result.


// public class findMinimumInRotatedSortedArray153 {
//   public static int bruteforce(int arr[]){
//     int n=arr.length;
//     // step1 
//     int min=arr[0];

//     for(int i=1; i<n; i++){
//       if(arr[i]<min){
//         min=arr[i];
//       }
//     }
//     return min;
//   }

//   public static void main(String[] args) {
//     int arr[]={5,4,1,2,3};
//     System.out.println("minumum Rotated element"+" "+bruteforce(arr));
    
//   }
// }

// tc=O(n)
// sc=O(1)

// but here array is sorted so binary search is optimized solution


// optimized solution

// algorithm
// 1.Initialization:
//     left is initialized to the start of the array.
//     right is initialized to the end of the array.

// B2.inary Search:
//     a.While left is less than right, compute mid as the middle index between left and right.
//     b.Compare the middle element nums[mid] with the rightmost element nums[right].
//     c.If nums[mid] is greater than nums[right], it means the minimum element is to the right of mid, so set left to mid + 1.
//     d.Otherwise, the minimum element is at mid or to the left of mid, so set right to mid.

// 3.Return Result:
//    When the loop terminates, left will be pointing to the smallest element in the array. Return nums[left].


public class findMinimumInRotatedSortedArray153 {
  public static int optimized(int arr[]){
    int n=arr.length;
    int left=0;
    int right=n-1;

    while(left<right){
      int mid=left+(right-left)/2;
      if(arr[mid]>arr[right]){
        left=mid+1;
      }
      else{
        right=mid;

      }

    }
    return arr[left];
  }

  public static void main(String[] args) {
    int arr[]={5,4,1,2,3};
    System.out.println("findMinimum Rotated sorted array"+" "+optimized(arr));
    
  }
}