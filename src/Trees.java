import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }


//class Tree {
//    public static void postOrder(Node root) {
//        //List result = new ArrayList();
//
//        if (root != null) {
//            //postOrder(root.left);
//            //postOrder(root.right);
//
//        }
//
//        public static int height(Node root) {
//            // Write your code here.
//            if(root == null){
//                return -1;
//            }
//
//            else{
//                /* compute the depth of each subtree */
//                int lDepth = height(root.left);
//                int rDepth = height(root.right);
///* use the larger one */
//                if (lDepth > rDepth)
//                    return (lDepth + 1);
//                else
//                    return (rDepth + 1);
//            }
//        }
//
//
//    }

    public static Node insert(Node root,int data) {
        if (root == null){
            return new Node(data);
        }
        if (root.data > data){
            if (root.left == null){
                root.left = new Node(data);
                return root;
            }
            insert(root.left, data);
        } else {
            if (root.right == null){
                root.right = new Node(data);
                return root;
            }
            insert(root.right, data);
        }

        return root;
    }

    public static void main(String args[])
    {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(9);
        root.left.left = new Node(2);
        root.right.left = new Node(8);
        root.right.right = new Node(10);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(3);
        root.right.left.left = new Node (7);

//        postOrder(root);

        root = insert(root, 11);
    }
}
