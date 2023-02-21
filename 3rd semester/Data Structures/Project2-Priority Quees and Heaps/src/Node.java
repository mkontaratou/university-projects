public class Node {
    protected int data;
    protected Node next = null;

    Node(int data) {
        this.data = data;
    }

    public int getData() {
        // return data stored in this node
        return data;
    }

    public Node getNext() {
        // get next node
        return next;
    }

}
