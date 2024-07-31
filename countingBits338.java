// Example 1:
// Input: n = 2
// Output: [0,1,1]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10

// Example 2:
// Input: n = 5
// Output: [0,1,1,2,1,2]
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// 3 --> 11
// 4 --> 100
// 5 --> 101


// brute forc3e algorithm
// Brute Force Algorithm (countBitsBruteForce):

// 1.Main Method:
// For each input n, calls countBitsBruteForce and prints the result.
//2. countBitsBruteForce Method:
//      .Creates an array result of size n + 1.
//      .Iterates through each number i from 0 to n.
//      .Calls countSetBits to count the set bits of i and stores the result in result[i].3
// 3.countSetBits Method:
// Counts the number of set bits in num using bitwise operations and right shifts.

// public class countingBits338 {
//   public static int[] bruteforce(int n){
//     int result[]=new int[n+1];
//     for(int i=0; i<=n; i++){
//       result[i]=countSetBits(i);
//     }
//     return result;

//   }

//   public static int countSetBits(int num){
//     int count=0;
//     while(num>0){
//       count+=num&1;
//       num>>=1;


//     }
//     return count;
//   }

//   public static void main(String[] args) {
//     int n1 = 2;
//         int[] result1 = bruteforce(n1);
//         System.out.println("Input: n = " + n1);
//         System.out.println("Output: " + java.util.Arrays.toString(result1));
    
//   }
// }


// optimized solution
// countBitsOptimized Method:

// 1.Creates an array result of size n + 1.
// 2.Iterates through each number i from 1 to n.
// 3.Uses the formula result[i] = result[i >> 1] + (i & 1):
//4. i >> 1 shifts i to the right by 1 bit (essentially divides by 2).
// 5.i & 1 checks if the least significant bit of i is 1.
// 6.This formula effectively builds on previously computed results



public class countingBits338 {
    public static int[] optimized(int n){
      int result[]=new int[n+1];
      for(int i=0; i<=n; i++){
        result[i]=result[i>>1]+(i&1);
      }
      return result;
  
    }
  
    public static int countSetBits(int num){
      int count=0;
      while(num>0){
        count+=num&1;
        num>>=1;
  
  
      }
      return count;
    }
  
    public static void main(String[] args) {
      int n1 = 2;
          int[] result1 = optimized(n1);
          System.out.println("Input: n = " + n1);
          System.out.println("Output: " + java.util.Arrays.toString(result1));
      
    }
  }
  
  