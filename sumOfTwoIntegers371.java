// Example 1:
// Input: a = 1, b = 2
// Output: 3

// Example 2:
// Input: a = 2, b = 3
// Output: 5
 
// algorithm
// 1.Main Method: This is the entry point of the program.
// 2.add Method: This method takes two integers as input and returns their sum.
// 3.Example 1 and Example 2: These demonstrate how to call the add method with different inputs and print the results.



// public class sumOfTwoIntegers371 {
//   public static int bruteforce(int a,int b){
//     return a+b;
//   }

//   public static void main(String[] args) {
//     int a=1;
//     int b=4;
//     System.out.println("sum of two integers"+" "+bruteforce(a, b));
    
//   }
// }


// optimize  using bits operation

// algorithm
// addUsingBits Method: This method adds two integers using bitwise operations:
//   1.carry = a & b: Computes the carry bits.
//   2. a = a ^ b: Computes the sum of a and b without the carry.
//   3.b = carry << 1: Shifts the carry bits to the left by one position.
//   4.The loop continues until there are no more carry bits left.

public class sumOfTwoIntegers371 {
  public static int optimize(int a,int b){
    while(b!=0){
      int carry=a & b;
    a=a^b;
    b=carry<<1;
    }
    return a;
  }

  public static void main(String[] args) {
    int a=1;
        int b=4;
        System.out.println("sum of two integers"+" "+optimize(a, b));
    
  }
}


// For the input a = 2 and b = 3:

// Initial values: a = 2, b = 3 (binary: a = 0010, b = 0011)
// First Iteration:

// carry = a & b
// 0010 & 0011 = 0010
// carry = 2
// a = a ^ b
// 0010 ^ 0011 = 0001
// a = 1
// b = carry << 1
// 0010 << 1 = 0100
// b = 4
// Second Iteration:

// carry = a & b
// 0001 & 0100 = 0000
// carry = 0
// a = a ^ b
// 0001 ^ 0100 = 0101
// a = 5
// b = carry << 1
// 0000 << 1 = 0000
// b = 0
// The loop ends because b = 0.

// return a results in 5.
// Output: 5