// Example 1:
// Input: s = "()"
// Output: true

// Example 2:
// Input: s = "()[]{}"
// Output: true

// Example 3:
// Input: s = "(]"
// Output: false

// 1.Initialization:
//          Stack: A stack is used to keep track of opening parentheses.
// 2.Iteration Through the String:
//          a.  Opening Parentheses: When an opening parenthesis ((, {, [) is encountered, push it onto the stack.
//           b.  Closing Parentheses: When a closing parenthesis (), }, ]) is encountered:
//          Check Stack: Ensure the stack is not empty (i.e., there is an opening parenthesis to match with).
//        Match Check: Check if the top of the stack matches the corresponding opening parenthesis for the current closing parenthesis.
//            Pop Stack: If the match is successful, pop the stack. If not, return false immediately since the string is invalid.
//    c.Invalid Characters: If the character is not a valid parenthesis or does not match the expected closing parenthesis, return false.
// 3.Final Check:
// After processing all characters, the stack should be empty if all opening parentheses have matching closing parentheses. If the stack is not empty, return false.

import java.util.Stack;

public class ValidParenthesesOptimized {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; // Invalid closing parenthesis or mismatch
            }
        }
        return stack.isEmpty(); // Check if all opening parentheses are matched
    }

    public static void main(String[] args) {
        String s1 = "({[]})";
        String s2 = "({[})";

        System.out.println(s1 + " is " + (isValid(s1) ? "valid." : "not valid."));
        System.out.println(s2 + " is " + (isValid(s2) ? "valid." : "not valid."));
    }
}


// Example 1: s = "({[]})"
// Initialization:

// stack = [] (empty stack)
// Processing Each Character:

// Character '(':

// It's an opening bracket, so push it onto the stack.
// stack = ['(']
// Character '{':

// It's an opening bracket, so push it onto the stack.
// stack = ['(', '{']
// Character '[':

// It's an opening bracket, so push it onto the stack.
// stack = ['(', '{', '[']
// Character ']':

// It's a closing bracket. Check the top of the stack.
// Top of the stack is '[', which matches, so pop it from the stack.
// stack = ['(', '{']
// Character '}':

// It's a closing bracket. Check the top of the stack.
// Top of the stack is '{', which matches, so pop it from the stack.
// stack = ['(']
// Character ')':

// It's a closing bracket. Check the top of the stack.
// Top of the stack is '(', which matches, so pop it from the stack.
// stack = []
// Final Check:

// The stack is empty, meaning all opening brackets had matching closing brackets.
// The result is true.
// Example 2: s = "({[}