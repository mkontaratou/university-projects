public class List{

    public Node head;
    //private Node head=null;
    private int size=0;

    public List(String item) {
        head=new Node(item);
        size=1;
    }

    public List(){
    }

    public boolean isEmpty() {
        return head == null;
    }


    //insert
    public void insertAtList(String item) {
        Node n = new Node(item);
        if (isEmpty()) {
            head = n;
            n.next=null;
        } else {
            n.next=head;
            head=n;
        }
        size++;
    }

    //remove str from list
    public void removeFromList(String item){
        while(isInList(item)){
            Node tmp=head;
            Node prev=head;
            int pos=0;

            if(tmp.getItem().equals(item)){
                head=head.getNext();
                size--;
                return;
            }

            while(!tmp.getItem().equals(item)){
                tmp=tmp.getNext();
                pos++;
            }

            for(int i=0;i<pos-1;i++)
                prev=prev.getNext();
            prev.next=prev.next.next;
            size--;
        }
    }




    //check if string is in list
    public boolean isInList(String item){
        Node tmp= head;
        for(int i =0;i<size();i++){
            if(tmp.getItem().equals(item))
                return true;
            tmp=tmp.getNext();
        }
        return false;
    }

    //size of list
    public int size(){
        return size;
    }

    //getting first element from node
    public Node getHead(){
        return head;
    }

    public void printList(){
        Node tmp=head;
        while(tmp!=null){
            System.out.println(tmp.getItem());
            tmp=tmp.getNext();
        }
    }


}




