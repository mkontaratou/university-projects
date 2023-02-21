import java.io.PrintStream;
import java.util.NoSuchElementException;

public class IntQueueImpl implements IntQueue {
    private Node head=null;
    private Node tail=null;
    private int size=0;


    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public void put(int item) {
        Node n = new Node(item);
        if(isEmpty()){
            head=n;
            tail=n;
        }
        else {
            tail.next=n;
            tail=n;
        }
        size++;

    }

    @Override
    public int get() throws NoSuchElementException {
        if(isEmpty())
            throw new NoSuchElementException();
        int data=head.getData();
        head= head.getNext();
        size--;
        return data;
    }

    @Override
    public int peek() throws NoSuchElementException {
        if(isEmpty())
            throw new NoSuchElementException();
        return head.getData();
    }

    @Override
    public void printQueue(PrintStream stream) {
        Node n =head;
		if(!isEmpty()){
			while(n.getNext()!=null) {
				stream.println(n.getData());
				n = n.next;
			}
			stream.println(n.getData());
		}
	}

    @Override
    public int size() {
        return size;
    }

    //gia NetBenefit
    public void getHead (int item){
        head.item= String.valueOf(item);
    }

}
