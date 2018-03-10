package interview.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * binary search tree.
 */
public class BST {
    private class Node {
        int key;
        int value;
        Node left, right;
        // duplicate element count

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int count;
    private int duplicateCount;
    private Node root;

    public void insert(int key, int value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, int key, int value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (key == node.key) {
            duplicateCount ++;
            node.value = value;
        } else if (key < node.key) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    public int search(int key) {
        return search(root, key);
    }

    private int search(Node node, int key) {
        if (node == null) {
            return -1;
        }
        if (key == node.key) {
            return node.value;
        } else if (key > node.key) {
            return search(node.right, key);
        } else {
            return search(node.left, key);
        }
    }

    public boolean contain(int key) {
        return contain(root, key);
    }

    private boolean contain(Node node, int key) {
        if (node == null) {
            return false;
        }
        if (key == node.key) {
            return true;
        } else if (key > node.key) {
            return contain(node.right, key);
        } else {
            return contain(node.left, key);
        }
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    public void levelOrder() {
        if (root == null) {
            return ;
        }
        Deque<Node> deque = new ArrayDeque<>();
        Node node = root;
        deque.add(node);
        while (!deque.isEmpty()) {
            Node current = deque.pop();
            System.out.print(current.value);
            System.out.print(" ");
            if (current.left != null) {
                deque.add(current.left);
            }
            if (current.right != null) {
                deque.add(current.right);
            }

        }
        System.out.println();
    }

    public int maximum() {
        if (root != null) {
            Node maximum = maximum(root);
            return maximum.value;
        }
        return -1;
    }

    public Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public int minimum() {
        if (root != null) {
            Node node = minimum(root);
            return node.value;
        }
        return -1;
    }

    private Node minimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            count --;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public void remove(int key) {
        if (root == null) {
            return ;
        }
        root = remove(root,key);
    }

    private Node remove(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key > node.key) {
            node.right = remove(node.right,key);
            return node;
        } else if (key < node.key) {
            node.left =  remove(node.left,key);
            return node;
        } else { // find key.
            if (node.left == null) {
                count --;
                return node.right;
            }
            if (node.right == null) {
                count -- ;
                return node.left;
            }
            // have right and left children
            // using minimum node of right tree of deleted node
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            count --;
            return successor;
        }
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value);
        System.out.print(" ");
        inOrder(node.right);
    }
}
