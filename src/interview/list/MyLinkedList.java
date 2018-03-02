package interview.list;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;


    public void add(int value) {
        Node newNode = new Node(value);
        if (tail == null) { // current linked list is empty
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        size ++;
        tail = newNode; // tail point the last element.
    }

    public int[] toArray() {
        int[] arr = new int[size];
        Node curr = head;
        int i = 0;
        while(curr != null) {
            arr[i++] = curr.getValue();
            curr = curr.getNext();
        }
        return arr;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void sort() {
        int n = size;
        // the length of sub-sequence from 1(inclusive) to n(exclusive).
        for (int len = 1; len < n; len*=2) {
            // sorted [i,i+len-1] and [i+len,i+2*len-1]
            for (int i = 0; i < n-len; i+=2*len) {
                merge(i,i+len-1,Math.min(i+2*len-1,n-1));
            }
        }
    }

    private void merge(int l, int mid, int r) {
        // merge [i,mid] and [mid+1,r]
        int i = l;
        int j = mid+1;
        // head of left and right part of linked list.
        Node lHead = getNode(i);
        Node rHead = getNode(j);
        while(i <= mid && j <= r) {
            if (lHead.getValue() > rHead.getValue()) {
                swapValue(lHead,rHead);
                rHead = rHead.getNext();
            } else {
                swapValue(lHead,rHead);
                lHead = lHead.getNext();
            }
        }
    }
    public void swapValue(Node node1,Node node2) {
        int temp = node1.getValue();
        node1.setValue(node2.getValue());
        node2.setValue(temp);
    }


    /**
     * get the node by index. return null if not exist
     * @param index start from 0.
     * @return
     */
    private Node getNode(int index) {
        Node curr = head;
        while (index-- >= 0 && curr != null) {
            curr = curr.getNext();
        }
        return curr;
    }

    public Node getPre(Node node) {
        if (node == null) {
            return null;
        }
        Node curr = head;
        Node pre = null;
        while (curr != null) {
            if (node.getValue() == curr.getValue()) {
                return pre;
            }
            pre = curr;
            curr = curr.getNext();
        }
        return null;
    }
}
