public class List{

    private Node head=null;
    private Node tail=null;
    private int size=0;

    public List() {}

    public boolean isEmpty() {
        return head == null;
    }
    

    //insert
    public void insertAtBack(int data) {
        Node n = new Node(data);
        if (isEmpty()) {
            head = n;
            tail = n;
            n.next=null;
        } else {
            tail.next=n;
            tail = n;
        }
        size++;
    }

    //size of list
    public int size(){
        return size;
    }
    
    //getting first element from node
    public Node getHead(){
        return head;
    }



    public String toString() {
        if(isEmpty())
            return null;
        Node tmp=head;
        StringBuilder s= new StringBuilder();
        while(tmp!=null){
            s.append(tmp.getData()).append(" ");
            tmp=tmp.getNext();
        }
        return s.toString();
    }
}




