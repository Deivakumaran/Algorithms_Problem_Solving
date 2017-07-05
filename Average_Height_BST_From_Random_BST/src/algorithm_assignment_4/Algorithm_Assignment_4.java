/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm_assignment_4;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

/**
 *
 * @author deivakumaran
 */
public class Algorithm_Assignment_4 {

    /**
     * @param args the command line arguments
     */
    static int MAX;
    int index;
    static int[] avgHtArray;
    static String[] outputArray;

    public Algorithm_Assignment_4() {
        outputArray = new String[1024];
        avgHtArray = new int[100];
        MAX = 10;
        index = 0;
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

    public void splitArray(String[] outputArray) {

        Binary_Search_Tree tree = new Binary_Search_Tree();
        for (int k = 0; k < outputArray.length; k++) {
            shuffleArray(outputArray);
            tree.insert(outputArray[k]);
        }
        //  tree.inorder();
        int height = tree.height();
        averageHeight(height);
        //System.out.println("Height of binary tree :"+height);

    }

    public void shuffleArray(String[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }

    }

    public void averageHeight(int height) {

        avgHtArray[index] = height;
        index++;

    }

    public static void main(String[] args) {
        // TODO code application logic here4

        int sum = 0;
        int average = 0;
        Algorithm_Assignment_4 al = new Algorithm_Assignment_4();

        String inputString = "abcdefghijklmnopqrst";

        Binary_Search_Tree bst = new Binary_Search_Tree();

        int count = 0;
        for (int i = 0; i < 1024; i++) {
            String outputString = al.splitStringFunction(inputString);
            outputArray[i] = outputString;

            bst.insert(outputString);
            count++;
        }

        //  bst.inorder(
        int height = bst.height();
        al.averageHeight(height);

        //System.out.println("Height of binary tree :"+height);
        for (int i = 0; i < MAX; i++) {

            al.splitArray(outputArray);

        }

        for (int i = 0; i < MAX + 1; i++) {
            sum = sum + avgHtArray[i];
            System.out.println(avgHtArray[i]);
        }

        average = sum / MAX + 1;

        System.out.println("The average height of BST from random set of BST : " + average);

    }

}
