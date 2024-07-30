// Example 1:
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

// Example 2:
// Input: height = [1,1]
// Output: 1


//brute force 

// algorithm
// Example 1:
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

// Example 2:
// Input: height = [1,1]
// Output: 1



// public class containerWithMostWater15 {
//   public static int bruteforce(int height[]){
//     int n=height.length;
//     if(height==null || n<2){
//       return 0;
//     }

//     int maxArea=0;
//     for(int i=0; i<n-1; i++){
//       for(int j=i+1; j<n; j++){
//         //find width and height
//         int width=j-i;
//         int h=Math.min(height[i],height[j]);
//         // find area 
//         int area=width*h;
//         if(area>maxArea){
//           maxArea=area;
//         }
//       }
//     }
//     return maxArea;

//   }

//   public static void main(String[] args) {
//     int arr[]={1, 8, 6, 2, 5, 4, 8, 3, 7};
//     System.out.println("maxArea"+" "+bruteforce(arr));
    
//   }
// }




// optimized solution

// algorithm

// 1.Initialization:
//      a.left pointer is initialized to the start of the array.
//      b.right pointer is initialized to the end of the array.
//      c.maxArea is initialized to zero to keep track of the maximum area found.
// 2.Two-Pointer Technique:
//     a.While left is less than right:
//              1.Calculate the current area using the shorter of the two lines (Math.min(height[left], height[right])) and the distance between them (right - left).
//          2.Update maxArea if the current area is larger.
//         3.Move the pointer pointing to the shorter line inward, because moving the taller line inward won't increase the area (as the height is determined by the shorter line).

// 3.Return Result:
// Once the loop exits, maxArea contains the maximum area of water that can be contained by the two lines in the array.

public class containerWithMostWater15 {
  public static int optimized(int height[]){
    int n=height.length;
    if(height==null || n<2){
      throw new IllegalArgumentException("Invalid input");
    }

    int left=0;
    int right=n-1;
    int maxArea=0;

    while(left<right){
      int currentArea=Math.min(height[left],height[right])*(right-left);
       maxArea=Math.max(currentArea,maxArea);
      if(height[left]<height[right]){
        left++;
      }
      else{
        right--;
      }

    }
    
    
    return maxArea;

  }

  public static void main(String[] args) {
    int arr[]={1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println("maxArea"+" "+optimized(arr));
    
  }
}


