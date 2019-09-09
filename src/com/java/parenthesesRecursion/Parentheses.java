package com.java.parenthesesRecursion;

import java.util.Scanner;

class Parentheses {
    
    public static void printParentheses(int n) {
        validatedParentheses(n, n, "");
    }
    
    public static void validatedParentheses(int openP, int closeP, String string) {
        if(openP == 0 && closeP == 0) {
            System.out.println(string);
        }
        
        if(openP > closeP){
            return;
        }
        
        if(openP > 0){
            validatedParentheses(openP-1, closeP, string + "(");
        }
        
        if(closeP > 0){
            validatedParentheses(openP, closeP-1, string + ")");
        }
    }
    
    public static void main(String args[]) throws Exception {
        Scanner reader = new Scanner(System.in);
        int val = reader.nextInt();
        printParentheses(val);
        reader.close();
    }
}
