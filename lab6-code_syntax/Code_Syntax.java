/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab_project_6;

/**
 *
 * @author panka
 */
public class Code_Syntax {

    
    // You will need a functioning Stack implementation (like ArrayStack) for this to work.
    // interface Stack { ... }
    // class ArrayStack implements Stack { ... }
    public interface Stack {
        void push(char item);
        char pop();
        char peek();
        boolean isEmpty();
    }

    static class ArrayStack implements Stack {
        private char[] data;
        private int top=-1;

        public ArrayStack(int capacity) {
            data = new char[capacity];
        }

        public void push(char item) {
            if (top == data.length - 1) {
                throw new IllegalStateException("Stack overflow");
            }
            data[++top] = item;
        }

        public char pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack underflow");
            }
            return data[top--];
        }

        public char peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return data[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

        
    
    public class SyntaxChecker {

        /**
         * Uses a stack to check if a line of code has balanced symbols.
         * @param line The string of code to check.
         * @return true if symbols are balanced, false otherwise.
         */
        public static boolean isBalanced(String line) {
            // TODO: Implement this method using a Stack.
            Stack buffer = new ArrayStack(line.length());
    
            
            for (int i=0;i<line.length();i++) {
                char symbol=line.charAt(i);
                if ((symbol == '(') || (symbol == '{') || (symbol == '[')) {
                    buffer.push(symbol);   
                    }
                else if ((symbol == ')') || (symbol == '}') || (symbol == ']')) {
                    if (buffer.isEmpty()) {
                        return false;
                    }
                    char open = buffer.pop();
                    if ((symbol == ')' && open != '(') || (symbol == '}' && open != '{') || (symbol == ']' && open != '[')) {
                        return false;
                    }   
                }
            }
            
            //return false; // Placeholder
            return buffer.isEmpty();
        }       
    }
     public static void main(String[] args) {
            String line1 = "public static void main(String[] args) { ... }"; // Should be true
            String line2 = "int x = (5 + [a * 2]);"; // Should be true
            String line3 = "System.out.println('Hello');)"; // Should be false (extra closing parenthesis)
            String line4 = "List list = new ArrayList<{String>();"; // Should be false (mismatched)
            String line5 = "if (x > 0) {"; // Should be false (unmatched opening brace)

            System.out.println("Line 1 is balanced: " + line1 + " " + SyntaxChecker.isBalanced(line1));
            System.out.println("Line 2 is balanced: " + line2 + " " + SyntaxChecker.isBalanced(line2));
            System.out.println("Line 3 is balanced: " + line3 + " " + SyntaxChecker.isBalanced(line3));
            System.out.println("Line 4 is balanced: " + line4 +  " " +SyntaxChecker.isBalanced(line4));
            System.out.println("Line 5 is balanced: " + line5 +  " " +SyntaxChecker.isBalanced(line5));
    }
}
