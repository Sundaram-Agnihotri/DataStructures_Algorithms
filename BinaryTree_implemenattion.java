import java.util.*;

public class Binary_Tree<T>{

    public static class BinaryTree<T>{
        T data;
        BinaryTree<T> left;
        BinaryTree<T> right;

        public BinaryTree(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        

    }

    public static void printTree(BinaryTree<Integer> root){
      if(root == null)
      return;

      System.out.println(root.data + " ");
      printTree(root.left);
      printTree(root.right);
    }

    public static void main(String[] args, int T) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>(1);
        BinaryTree<Integer> lefttree = new BinaryTree<Integer>(2);
        BinaryTree<Integer> righttree = new BinaryTree<Integer>(3);
        tree.left = lefttree;
        tree.right = righttree;

        printTree(tree);

        
    }
}
