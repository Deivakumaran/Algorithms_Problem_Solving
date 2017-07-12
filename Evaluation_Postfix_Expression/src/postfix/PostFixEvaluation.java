/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfix;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author PeaceFull
 */
class PostFixEvaluation {
  
    static Stack<Integer> stack = new Stack<>();

    public static void evaluate(String input) {

        Scanner sc = new Scanner(input);
   
        int length = input.split(" ").length;
        for (int i = 0; i < length; i++) {
            String str = sc.next();

            int status = checkOperator(str);
            if (status == 1) {
                stack.push(Integer.parseInt(str));
            } else {

                int x = stack.pop();
                int y = stack.pop();
                switch (str) {

                    case "*":
                        stack.push(y * x);
                        break;
                    case "+":
                        stack.push(y + x);
                        break;
                    case "-":
                        stack.push(y - x);
                        break;
                    case "/":
                        stack.push(y / x);
                        break;
                    case "^":
                        stack.push(y ^ x);
                        break;
                }

            }

        }

        System.out.println(stack.pop());
    }

    public static int checkOperator(String a) {

        if (a.equals("+") || a.equals("*") || a.equals("/") || a.equals("-") || a.equals("^")) {
            return 0;
        } else {
            return 1;
        }
    }

    // Driver method 
    public static void main(String[] args) {

        String input = "2 3 1 * + 9 -";
        evaluate(input);

    }

}
