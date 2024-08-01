// Example 1:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true

// Example 2:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true

// Example 3:
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
 



// optimized

// 1.exist Function: Loops through each cell in the board to start a DFS (Depth-First Search) if the cell matches the first character of the word.

// 2.dfs Function: Performs the recursive DFS. It:
//        Checks if the current index matches the length of the word, which means we have found the word.
//        Checks the bounds of the current cell and if the character matches the current character in the word.
//       Temporarily marks the current cell as visited by setting it to a space character.
//       Recursively checks all four possible directions.
//      Restores the cell's original value after exploring all directions.


public class wordSearch79 {
  public static boolean optimize(char board[][],String word){
    int m=board.length; // row
    int n=board[0].length;

    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        if(dfs(board,word,i,j,0));
        return true;
      }
    }
    return false;
  }
  public static boolean dfs(char board[][],String word,int i,int j,int index){
    if(index==word.length()){
      return true;
    }
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
      return false;
  }
  char temp = board[i][j];
  board[i][j] = ' ';
  boolean found = dfs(board, word, i - 1, j, index + 1)
          || dfs(board, word, i + 1, j, index + 1)
          || dfs(board, word, i, j - 1, index + 1)
          || dfs(board, word, i, j + 1, index + 1);
  board[i][j] = temp;

  return found;

  }

  public static void main(String[] args) {
    char[][] board1 = {
      {'A', 'B', 'C', 'E'},
      {'S', 'F', 'C', 'S'},
      {'A', 'D', 'E', 'E'}
};
System.out.println(optimize(board1, "ABCCED")); // Output: true
System.out.println(optimize(board1, "SEE"));    // Output: true
System.out.println(optimize(board1, "ABCB"));   // Output: false

    
  }
}