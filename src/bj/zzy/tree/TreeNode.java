package bj.zzy.tree;

public class TreeNode {
    private final char val;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;

    public TreeNode(char val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public char getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
        if (this.left != null) {
            this.left.setParent(this);
        }
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
        if (this.right != null) {
            this.right.setParent(this);
        }
    }

    private void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getParent() {
        return parent;
    }
}
