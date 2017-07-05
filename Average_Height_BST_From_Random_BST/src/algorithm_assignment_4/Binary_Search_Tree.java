/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm_assignment_4;

/**
 *
 * @author deivakumaran
 */
public class Binary_Search_Tree {
    class Node {
        String key;
        Node left, right;
 
        public Node(String item) {
            key = item;
            left = right = null;
        }
    }
 
    // Root of BST
    Node root;
 
    // Constructor
    Binary_Search_Tree() { 
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
        if (root.key.compareTo(key)>0)
            root.left = insertRec(root.left, key);
        else if (root.key.compareTo(key)<0)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
    
    
    void inorder()  {
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
    
    
    
   public int height(){
      int avg= heightDepth(root);
      return avg;
   }
    
    int heightDepth(Node root) 
    {
        if (root == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = heightDepth(root.left);
            int rDepth = heightDepth(root.right);
  
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
    }
}
