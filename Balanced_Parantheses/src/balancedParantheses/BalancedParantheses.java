/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancedParantheses;

import java.util.Stack;

/**
 *
 * @author deivakumaran
 */
class BalancedParantheses {

    static Stack<Character> stack = new Stack<>();

    public static boolean evaluate(char[] input) {

        for (int i = 0; i < input.length; i++) {
            char ch = input[i];

            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {

                if (stack.isEmpty()) {
                    return false;
                } else {
                    char popChar = stack.pop();

                    boolean status = checkMatching(popChar, input[i]);

                    if (status == false) {
                        return false;
                    }
                }
            }

        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkMatching(char popChar, char inputCh) {

        if (popChar == '(' && inputCh == ')') {
            return true;
        } else if (popChar == '{' && inputCh == '}') {
            return true;

        } else if (popChar == '[' && inputCh == ']') {
            return true;

        }
        return false;
    }

    // Driver method 
    public static void main(String[] args) {

        char exp[] = {'{', '(',')','}', '[', ']'};
        boolean status = evaluate(exp);

        System.out.println(status);
    }

}
