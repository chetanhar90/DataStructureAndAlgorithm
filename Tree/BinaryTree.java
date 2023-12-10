package Tree;

public class BinaryTree {

    Node root;
    BinaryTree(){
        root=null;
    }
    BinaryTree(int item){
        root=new Node(item);
    }
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);
        printTree(tree.root, "", false);
    }
    public static void printTree(Node root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "L--- " : "R--- ") + root.key);
            printTree(root.left, prefix + (isLeft ? "    " : "│   "), true);
            printTree(root.right, prefix + (isLeft ? "    " : "│   "), false);
        }
    }

}
class Node{
    int key;
    Node left,right;
    public Node(int item){
        key=item;
        left=right=null;
    }
}

