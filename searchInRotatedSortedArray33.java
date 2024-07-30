// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1

// Example 3:
// Input: nums = [1], target = 0
// Output: -1




// bruteforce 
//algorithm
// 1.Initialization:
//     Check if the input array nums is null or empty. If it is, return -1 as the target cannot be found in an empty array.
// 2.Iteration:
//     a.Loop through each element in the array.
//     b.If the current element matches the target, return its index.
// 3.Return Result:
//     If the loop completes without finding the target, return -1 to indicate the target is not in the array.


// public class searchInRotatedSortedArray33 {
//   public static int bruteforce(int arr[],int target){
//     int n=arr.length;
//     // base case condition
//     if(arr==null || n==0){
//       return -1;
//     }

//     for(int i=0; i<n; i++){
//       if(arr[i]==target){
//         return i;
//       }
//     }
//     return -1;
//   }

//   public static void main(String[] args) {
//     int arr[]={5,4,1,2,3};
//     int target=2;
//     System.out.println("search in rotated sorted array"+" "+bruteforce(arr,target));
    
//   }
// }


// tc=O(n)
// sc=O(1)

// this is not optimized solution...binary search is optimized solution because array is given to sorted

// algorithm



public class searchInRotatedSortedArray33 {
  public static int optimized(int arr[],int target){
    int n=arr.length;
    // base condition
    if(arr==null || arr.length==0){
      return -1;
    }
    int left=0;
    int right=n-1;
    while(left<right){
      int mid=left+(right-left)/2;
      if(target==arr[mid]){
        return mid;
      }
      
      // determine which part is sorted ..left or right
      // left part is sorted
      if(target>arr[left]){
        if(target>=arr[left] && target<arr[mid]){
          right=mid-1;
        }
        else{
          left=mid+1;
        }
      }
      // right part is sorted
      else{
        if(target<=arr[right]&& target>arr[mid]){
          left=mid+1;
        }
        else{
          right=mid-1;
        }
      }

    }
    return -1;
  }

  public static void main(String[] args) {
    int arr[]={5,4,1,2,3};
    int target=2;
    System.out.println("search in rotated sorted array"+" "+optimized(arr, target));
    
  }
}