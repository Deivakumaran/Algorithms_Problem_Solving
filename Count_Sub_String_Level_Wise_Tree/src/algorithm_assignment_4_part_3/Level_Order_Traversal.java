/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm_assignment_4_part_3;

/**
 *
 * @author PeaceFull
 */
public class Level_Order_Traversal {

    class Node {

        String key;
        Node left, right;

        public Node(String item) {
            key = item;
            left = right = null;
        }
    }
    int count = 0;
    // Root of BST
    Node root;

    // Constructor
    Level_Order_Traversal() {
        root = null;
    }

    void insert(String key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, String key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (root.key.compareTo(key) > 0) {
            root.left = insertRec(root.left, key);
        } else if (root.key.compareTo(key) < 0) {
            root.right = insertRec(root.right, key);
        }

        /* return the (unchanged) node pointer */
        return root;
    }

    void printLevelOrder(String subString) {
        int h = height(root);
        System.out.println("Height is :" + h);
        int i;

        for (i = 1; i <= h; i++) {

            System.out.println("Level = " + (i - 1) + '\n');
            printGivenLevel(root, i, subString);

            System.out.println('\n' + "Total Substring match count is :" + count);
            count = 0;
        }
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight) {
                return (lheight + 1);
            } else {
                return (rheight + 1);
            }
        }
    }

    /* Print nodes at the given level */
    public void printGivenLevel(Node root, int level, String subString) {
        if (root == null) {
            return;
        }
        if (level == 1) {

            System.out.print(root.key + " ");
            if (root.key.contains(subString)) {
                count++;
            }

        } else if (level > 1) {
            printGivenLevel(root.left, level - 1, subString);
            printGivenLevel(root.right, level - 1, subString);
        }

    }

    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

}
