// Example 1:
// Input: nums = [1,2,3,1]
// Output: true

// Example 2:
// Input: nums = [1,2,3,4]
// Output: false

// Example 3:
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true



// brute force solution

// algorithm
// 1.Outer Loop: Iterate through each element in the array using index i.
// 2.Inner Loop: For each element indexed by i, iterate through the remaining elements (from i+1 to the end of the array) using index j.
// 3.Check for Duplicates:
//     If arr[i] equals arr[j], a duplicate is found, so return true.
// 4.Continue Searching: If the loops complete without finding duplicates, return false




// public class ContainsDuplicate217 {
//   public static boolean bruteForce(int arr[]){
//     int n=arr.length;
//     for(int i=0; i<n; i++){
//       for(int j=i+1; j<n; j++){
//         if(arr[i]==arr[j]){
//           return true;
//         }
//       }
//     }
//     return false;

//   }

//   public static void main(String[] args) {
//     int arr[] ={1,2,3,1};
//     System.out.println("duplicate Element"+" "+bruteForce(arr));
    
//   }
// }


// tc=0(n^2)
// sc=O(1)





// brute force 2 using sorting method

// algorithm
// 1.Edge Case Handling: Added a check for arrays with fewer than 2 elements. Such arrays cannot contain duplicates, so the method returns false immediately.

// 2.Sort the Array: Used Arrays.sort(arr) to sort the array. This ensures that any duplicates will be adjacent to each other in the sorted array.

// 3.Check Adjacent Elements:
//    Iterated from 0 to n-2 (i.e., i < n - 1) to avoid an ArrayIndexOutOfBoundsException when accessing arr[i + 1].








// import java.util.Arrays;

// public class ContainsDuplicate217 {
//   public static boolean bruteForce(int arr[]){
//     int n=arr.length;
//     // Handle the edge case where array length is less than 2
//         if (n < 2) {
//             return false;
//         }
//     Arrays.sort(arr);
//     for(int i=0; i<n-1; i++){
//         if(arr[i]==arr[i+1]){
//           return true;
//         }
      
//     }
//     return false;
//   }

//   public static void main(String[] args) {
//     int arr[] ={1,2,3,1};
//     System.out.println("duplicate Element"+" "+bruteForce(arr));
    
//   }
// }



// tc=O(nlogn) due to sorting method
// sc=O(1)





// better solution using hashMap or HashSet

// Algorithm using hashMap
//    1.Use of HashMap:
//            HashMap is used to keep track of elements we have already seen.
//            Key: The element itself.
//            Value: Here, we don't actually use the value, so it can be a dummy value like 1.

//    2.Loop Through Array:
//          For each element num in the array, check if it is already present in the HashMap.
//          If it is present, return true (duplicate found).
//           If it is not present, add it to the HashMap.
// 3.Return Result:
//   If the loop completes without finding duplicates, return false.

// Time Complexity:
// Time Complexity: O(n), where n is the number of elements in the array. This is because each insertion and lookup operation in a HashMap is on average O(1).
// Space Complexity: O(n) due to the space required to store up to n elements in the HashMap.





// import java.util.Arrays;
// import java.util.HashMap;

// public class ContainsDuplicate217 {
//   public static boolean betterSolution(int arr[]){
//     HashMap<Integer,Integer> map=new HashMap<>();
    

//     for(int nums:arr ){
//       if(map.containsKey(nums)){
//         return true;
//       }
//       else{
//         map.put(nums,1);
//       }
      
//     }
//     return false;
//   }
    

//   public static void main(String[] args) {
//     int arr[] ={1,2,3,1};
//     System.out.println("duplicate Element"+" "+betterSolution(arr));
    
//   }
// }







