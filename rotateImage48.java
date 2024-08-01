// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]

// Example 2:
// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]


// brute force algorithm

// 1.Create a new matrix to store the rotated version of the original matrix.
// 2.For each element in the original matrix, calculate its new position in the rotated matrix.
//3. Copy the rotated matrix back to the original matrix.

// import java.util.Arrays;

// public class rotateImage48 {
//   public static void bruteForce(int matrix[][]){
//     int n=matrix.length;
//     //  create rotate matrix
//     int rotate[][]=new int[n][n];

//     for(int i=0; i<n; i++){
//       for(int j=0; j<n; j++){
//         rotate[j][n-i-1]=matrix[i][j];

//       }
//     }
//     // Copy the rotated matrix back to the original matrix
//     for(int i=0; i<n; i++){
//       for(int j=0; j<n; j++){
//         matrix[i][j]=rotate[i][j];

//       }
//     }

//   }

//   public static void main(String[] args) {
//     int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//         int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

//         bruteForce(matrix1);
//         bruteForce(matrix2);

//         System.out.println(Arrays.deepToString(matrix1)); // Output: [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
//         System.out.println(Arrays.deepToString(matrix2)); // Output: [[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]]
    
//   }
// }


// optimized solution
// Optimized:

// Transpose: We swap elements across the main diagonal.
// Reverse Rows: We reverse each row to get the final rotated matrix.

import java.util.Arrays;

public class rotateImage48 {
  public static void optimize(int matrix[][]){
    int n=matrix.length;
    // step tranpose the matrix
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=matrix[i][j];

      }
    }
    // // reverse the row
    for(int i=0; i<n; i++){
      for(int j=0; j<n/2; j++){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[i][n-j-1];
        matrix[i][n-j-1]=temp;

      }
    }

  }

  public static void main(String[] args) {
    int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

        optimize(matrix1);
        optimize(matrix2);

        System.out.println(Arrays.deepToString(matrix1)); // Output: [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
        System.out.println(Arrays.deepToString(matrix2)); // Output: [[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]]
    
  }
}
