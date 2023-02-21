public class Node {
    protected String item;
    protected Node next;

    Node(String item) {
        this.item = item;
        next=null;
    }

    public String getItem() {
        return item;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        // get next node
        return next;
    }

}
