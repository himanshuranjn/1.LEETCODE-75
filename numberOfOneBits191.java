// Example 1:
// Input: n = 11
// Output: 3
// Explanation:
// The input binary string 1011 has a total of three set bits.

// Example 2:
// Input: n = 128
// Output: 1
// Explanation:
// The input binary string 10000000 has a total of one set bit.

// Example 3:
// Input: n = 2147483645
// Output: 30
// Explanation:

// The input binary string 1111111111111111111111111111101 has a total of thirty set bits.

 
// brute force approach

// algorithm
// Brute Force Algorithm (countSetBitsBruteForce):

// a.Initialize count to 0.
// b.While n is greater than 0:
// c.Increment count if the least significant bit of n is 1 (n & 1).
// d.Right-shift n by 1 bit (n >>= 1).
// e.Return count.

// public class numberOfOneBits191 {
//   public static int bruteforce(int n){
//     int count=0;
//     while(n>0){
//       count+=n&1;
//       n>>=1;
//     }
//     return count;
//   }

//   public static void main(String[] args) {
//     int n=11;
//     System.out.println("number of 1 bits"+" "+bruteforce(n));
    
//   }
// }

// Step-by-step of Iteration 1:
// 1. Initial n = 11 (binary: 1011), count = 0
// 2. n & 1:
//    1011
//  & 0001
//    ----
//    0001  => n & 1 = 1
// 3. Update count: count = 0 + 1 = 1
// 4. Right shift n: n >> 1 = 0101 (binary) = 5




// optimized solution

// algorithm

// Optimized Algorithm (countSetBitsOptimized):

// 1.Initialize count to 0.
//2. While n is greater than 0:
// 3.Use the operation n &= (n - 1) to clear the least significant set bit.
//4. Increment count.
// 5.Return count.


public class numberOfOneBits191 {
  public static int optimize(int n){
    int count=0;
    while(n>0){
      n&=n-1;
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    int n=11;
    System.out.println("number of 1 bits"+" "+optimize(n));
    
  }
}
