// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

// Example 2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


// Brute Force Approach

//1. Copy the original matrix: We create a copy of the matrix to avoid modifying the original matrix during iteration.
// 2.Set rows and columns to zero in the copy matrix: We iterate through the original matrix. If an element is zero, we set the entire row and column in the copy matrix to zero.
// 3.Copy back to the original matrix: Finally, we copy the modified copy matrix back to the original matrix.


// import java.util.Arrays;

// public class SetMatrixZeroes73{
//     public static void setZeroes(int[][] matrix) {
//         int rows = matrix.length;
//         int cols = matrix[0].length;
//         int[][] copy = new int[rows][cols];

//         // Copy the original matrix
//         for (int i = 0; i < rows; i++) {
//             copy[i] = Arrays.copyOf(matrix[i], cols);
//         }

//         // Set rows and columns to zero in the copy matrix
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 if (matrix[i][j] == 0) {
//                     // Set the entire row to zero
//                     for (int k = 0; k < cols; k++) {
//                         copy[i][k] = 0;
//                     }
//                     // Set the entire column to zero
//                     for (int k = 0; k < rows; k++) {
//                         copy[k][j] = 0;
//                     }
//                 }
//             }
//         }

//         // Copy the modified matrix back to the original matrix
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 matrix[i][j] = copy[i][j];
//             }
//         }
//     }

//     public static void main(String[] args) {
//         int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//         int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

//         setZeroes(matrix1);
//         setZeroes(matrix2);

//         System.out.println(Arrays.deepToString(matrix1));
//         System.out.println(Arrays.deepToString(matrix2));
//     }
// }




// optimized solution


// 1.Determine if the first row and column should be zeroed: We iterate through the first row and first column and set flags (firstRowZero and firstColZero) to true if any element in the first row or column is zero.
// 2.Mark zeros in the first row and column: For the rest of the matrix, if any element is zero, we set the corresponding element in the first row and column to zero.
//3. Zero out cells based on markers: Using the markers in the first row and column, we set the appropriate cells to zero.
//4. Zero out the first row and column if needed: Finally, we use the flags to determine if the first row and column should be zeroed.

import java.util.Arrays;

public class SetMatrixZeroes73 {
    public static void optimized(int matrix[][]){
        int m=matrix.length;// rows
        int n=matrix[0].length;// cols

        boolean firstRowZero=false;
        boolean firstColZero=false;
        // step 1 check if first row or first col is zero
        for(int i=0; i<m; i++){ // if first col is zero
            if(matrix[i][0]==0){
                firstColZero=true;
                break;

            }

        }
        // if first row is zero
        for(int j=0; j<n; j++){
            if(matrix[0][j]==0){
                firstRowZero=true;
                break;
            }
        }

        //step 2 use first row and first col is as marker
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        // step 3 zero outcells based on the marker
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;

                }
            }
        }
        // step 3 zero out the first row and first col if needed
        if(firstRowZero){
            for(int j=0; j<n; j++){
                matrix[0][j]=0;
            }
        }
        if(firstColZero){
            for(int i=0; i<m; i++){
                matrix[i][0]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        optimized(matrix1);
        optimized(matrix2);

        System.out.println(Arrays.deepToString(matrix1));
        System.out.println(Arrays.deepToString(matrix2));

        
    }
}










// Example 1:
// Input: [[1, 1, 1], [1, 0, 1], [1, 1, 1]]

// Initialization:

// rows = 3
// cols = 3
// firstRowZero = false
// firstColZero = false
// Check if the first column should be zeroed:

// matrix[0][0] = 1 (no change)
// matrix[1][0] = 1 (no change)
// matrix[2][0] = 1 (no change)
// firstColZero = false
// Check if the first row should be zeroed:

// matrix[0][0] = 1 (no change)
// matrix[0][1] = 1 (no change)
// matrix[0][2] = 1 (no change)
// firstRowZero = false
// Use first row and column as markers:

// i = 1, j = 1, matrix[1][1] = 0 → matrix[1][0] = 0, matrix[0][1] = 0
// Matrix after marking: [[1, 0, 1], [0, 0, 1], [1, 1, 1]]
// i = 1, j = 2 (no change)
// i = 2, j = 1 (no change)
// i = 2, j = 2 (no change)
// Zero out cells based on markers:

// i = 1, j = 1, matrix[1][0] = 0 or matrix[0][1] = 0 → matrix[1][1] = 0
// i = 1, j = 2, matrix[1][0] = 0 → matrix[1][2] = 0
// i = 2, j = 1, matrix[0][1] = 0 → matrix[2][1] = 0
// i = 2, j = 2 (no change)
// Matrix after zeroing: [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
// Zero out the first row if needed:

// firstRowZero = false (no change)
// Zero out the first column if needed:

// firstColZero = false (no change)
// Output: [[1, 0, 1], [0, 0, 0], [1, 0, 1]]

