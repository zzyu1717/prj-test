package interview.tree;

public class BSTTest {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(40,40);
        bst.insert(37,37);
        bst.insert(45,45);
        bst.insert(30,30);
        bst.insert(39,39);
        bst.insert(43,43);
        bst.insert(51,51);

        bst.inOrder();
        bst.remove(40);
        bst.inOrder();
        bst.levelOrder();
    }
}
