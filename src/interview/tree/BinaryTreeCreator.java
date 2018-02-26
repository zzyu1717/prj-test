package interview.tree;

public class BinaryTreeCreator {
    /**
     * 根据前序遍历和中序遍历生成树
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
    public TreeNode createBypreOrderAndinOrder(String preOrder, String inOrder) {
        if (preOrder.isEmpty()) {
            return null;
        }
        char rootVal = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(rootVal);

        TreeNode root = new TreeNode(rootVal);
        // [a,b)半开半闭区间
        root.setLeft(createBypreOrderAndinOrder(preOrder.substring(1, 1 + rootIndex),
                inOrder.substring(0, rootIndex)));
        root.setRight(createBypreOrderAndinOrder(preOrder.substring(rootIndex + 1),
                inOrder.substring(rootIndex + 1)));
        return root;
    }

    public String createPostOrder(String preOrder, String inOrder) {
        if (preOrder.isEmpty()) {
            return "";
        }
        char rootVal = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(rootVal);
        // left+right+root
        return createPostOrder(preOrder.substring(1, 1 + rootIndex),inOrder.substring(0, rootIndex)) +
                createPostOrder(preOrder.substring(rootIndex + 1), inOrder.substring(rootIndex + 1))
                + rootVal;
    }

    public void postTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postTraversal(root.getLeft());
        postTraversal(root.getRight());
        System.out.print(root.getVal());
    }

    /**
     *  get next node of param node.
     * @param node
     * @return next node, null will be returned when node not exist next node.
     */
    public TreeNode next(TreeNode node) {
        if (node.getRight() != null) {
            // find first node which traverse node's right tree in middle order.
            TreeNode next = first(node.getRight());
            return next;
        } else {
            // find first parent which node as left child.
            while (node.getParent() != null && node.getParent().getRight() == node) {
                node = node.getParent();
            }
            return node.getParent();
        }
    }

    private TreeNode first(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            return ;
        }
        for ( node = first(node);node != null;node = next(node)) {
            System.out.print(node.getVal());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTreeCreator tree = new BinaryTreeCreator();
        TreeNode rootNode = tree.createBypreOrderAndinOrder("ABDEGCF", "DBGEACF");
      /*  tree.postTraversal(rootNode);
        System.out.println();
        String result = tree.createPostOrder("ABDEGCF", "DBGEACF");
        System.out.println(result);*/
        tree.postTraversal(rootNode);
        System.out.println();
        tree.traverse(rootNode);

    }
}
