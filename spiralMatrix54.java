// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

// Example 2:
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]



 
// algorithm

// 1.Initialization:
//       a.Define the boundaries top, bottom, left, and right to keep track of the edges of the matrix that have not been traversed yet.
//       b.Initialize top to 0, bottom to the last row index, left to 0, and right to the last column index.
//      c.Create a list result to store the elements in spiral order.

// 2.Traversal:
//       a. Use a while loop that runs as long as top is less than or equal to bottom and left is less than or equal to right.

// 3.Traverse the top row:
//          Loop through columns from left to right and add the elements of the top row to the result list.
//         Increment the top boundary.
//4. Traverse the right column:
//          Loop through rows from top to bottom and add the elements of the right column to the result list.
//          Decrement the right boundary.

// 5.Traverse the bottom row (if necessary):
//       Check if top is still less than or equal to bottom.
//          If true, loop through columns from right to left and add the elements of the bottom row to the result list.
//        Decrement the bottom boundary.
// 6.Traverse the left column (if necessary):
//     Check if left is still less than or equal to right.
//     If true, loop through rows from bottom to top and add the elements of the left column to the result list.
//      Increment the left boundary.

import java.util.ArrayList;
import java.util.List;
public class spiralMatrix54 {
  public static List<Integer> optimized(int matrix[][]){
    List<Integer> result=new ArrayList<>();
    int top=0;
    int bottom=matrix.length;
    int left=0;
    int right=matrix[0].length;

    while(top<=bottom && left<=right){
      // step1 Traverse from left to right along the top row
      for(int j=left; j<=right; j++){
        result.add(matrix[top][j]);
      }
      top++;
       // step 2 Traverse from top to bottom along the right column
       for(int i=top; i<=bottom; i++){
        result.add(matrix[i][right]);
       }
       right--;

       // // step 3 Traverse from right to left along the bottom row
       if(top<=bottom){
        for(int j=right; j<=left; j--){
          result.add(matrix[bottom][j]);

        }
        bottom--;
       }

       // step 4 Traverse from bottom to top along the left column
       if(left<=right){
        for(int i=bottom; i<=top; i--){
          result.add(matrix[i][left]);
        }
        left++;
       }


    }
    return result;




  }

  public static void main(String[] args) {
    int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        System.out.println(optimized(matrix1)); // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
        System.out.println(optimized(matrix2)); // Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

    
  }

}