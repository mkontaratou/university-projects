import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl implements StringStack {
    private Node head=null;
    private int size=0;


    @Override
    public boolean isEmpty() {return head==null;}

    @Override
    public void push(String item) {
        Node n = new Node(item);
        if (isEmpty())
            head=n;
        else{
            n.setNext(head);
            head=n;
        }
        size++;
		
    }

    @Override
    public String pop() throws NoSuchElementException {
        if(isEmpty())
            throw new NoSuchElementException();
        String item = head.getItem();
        head=head.getNext();
        size--;
        return item;
    }

    @Override
    public String peek() throws NoSuchElementException {
        if(isEmpty())
            throw new NoSuchElementException();
        return head.getItem();
    }

    @Override
    public void printStack(PrintStream stream) {
		Node n =head;
        if(!isEmpty()){
			while(n.getNext()!=null) {
				stream.println(n.getItem());
				n = n.next;
			}
			stream.println(n.getItem());
		}
	}

    @Override
    public int size() {
        return size;
    }
	
}
