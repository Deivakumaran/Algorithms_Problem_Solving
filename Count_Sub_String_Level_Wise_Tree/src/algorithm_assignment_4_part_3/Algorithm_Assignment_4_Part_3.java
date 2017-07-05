/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm_assignment_4_part_3;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

/**
 *
 * @author PeaceFull
 */
public class Algorithm_Assignment_4_Part_3 {

    /**
     * @param args the command line arguments
     */
    static int MAX;
  

    public Algorithm_Assignment_4_Part_3() {
        MAX = 10;
        
    }

    public String splitStringFunction(String inputString) {
        String outputString = "";
        char[] inputArray = new char[inputString.length()];

        for (int j = 0; j < inputString.length(); j++) {
            inputArray[j] = inputString.charAt(j);

        }

        shuffleStringArray(inputArray);

        for (int i = 0; i < inputArray.length; i++) {
            outputString = outputString + inputArray[i];

        }

        return outputString;
    }

    public void shuffleStringArray(char[] ar) {

        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            char a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }

    }

    


    public static void main(String[] args) {
        // TODO code application logic here4

       
        Algorithm_Assignment_4_Part_3 al = new Algorithm_Assignment_4_Part_3();

        String inputString = "abcrfdehgn";

        Level_Order_Traversal lot = new Level_Order_Traversal();

        int count = 0;
        for (int i = 0; i < MAX; i++) {
            String outputString = al.splitStringFunction(inputString);
           
            lot.insert(outputString);
            count++;
        }

         String subString="ab";

         lot.printLevelOrder(subString);
        
        
    }

}
