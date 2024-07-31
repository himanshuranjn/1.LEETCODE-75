// Example 1:
// Input: n = 00000010100101000001111010011100
// Output:    964176192 (00111001011110000010100101000000)
// Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.

// Example 2:
// Input: n = 11111111111111111111111111111101
// Output:   3221225471 (10111111111111111111111111111111)
// Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.


// brute force
// reverseBitsBruteForce Method:
//    Initialize result to 0.
//    Iterate through all 32 bits of the integer.
//    Shift result left by 1 bit to make room for the next bit.
//    Use bitwise AND with 1 to get the least significant bit of n and add it to result.
//    Shift n right by 1 bit to process the next bit.
// Return result.

 

// public class reverseBits190 {
//   public static int reverseBitsBruteForce(int n) {
//     int result = 0;
//     for (int i = 0; i < 32; i++) {
//         result <<= 1;
//         result |= (n & 1);
//         n >>= 1;
//     }
//     return result;
// }

//   public static void main(String[] args) {
//     int n1 = 0b00000010100101000001111010011100;
//         int result1 = reverseBitsBruteForce(n1);
//         System.out.println("Input: " + Integer.toBinaryString(n1));
//         System.out.println("Output: " + result1 + " (" + Integer.toBinaryString(result1) + ")");
    
//   }
// }



// optimized 

// reverseBitsOptimized Method:
// Perform bitwise operations to reverse the bits in an efficient manner:
// Swap the higher 16 bits with the lower 16 bits.
// Swap 8-bit blocks within the 16-bit blocks.
// Swap 4-bit blocks within the 8-bit blocks.
// Swap 2-bit blocks within the 4-bit blocks.
// Swap individual bits within the 2-bit blocks.
// Return the result



public class reverseBits190 {
  public static int reverseBitsOptimized(int n) {
    n = (n >>> 16) | (n << 16);
    n = ((n & 0xFF00FF00) >>> 8) | ((n & 0x00FF00FF) << 8);
    n = ((n & 0xF0F0F0F0) >>> 4) | ((n & 0x0F0F0F0F) << 4);
    n = ((n & 0xCCCCCCCC) >>> 2) | ((n & 0x33333333) << 2);
    n = ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
    return n;
}


  public static void main(String[] args) {
    int n1 = 0b00000010100101000001111010011100;
        int result1 = reverseBitsOptimized(n1);
        System.out.println("Input: " + Integer.toBinaryString(n1));
        System.out.println("Output: " + result1 + " (" + Integer.toBinaryString(result1) + ")");
    
  }
}