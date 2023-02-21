import java.util.Comparator;
import java.lang.IllegalStateException;

public class MaxPQ implements PQInterface {
    private int size;
    private Processor[] heap; //heap to store data in
    private Comparator<Processor> comparator; // the comparator to use between the objects


    public MaxPQ(int c) throws IllegalStateException{
        if(c<1)
            throw new IllegalStateException();
        this.heap = new Processor[c+1];
        this.size = 0;

    }


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    // insert the object x to the queue
    public void insert(Processor x) {
        if(x==null) throw new IllegalArgumentException();
        if(size==heap.length-1) throw new IllegalStateException();
        //Available space of processor
        if((double)size/(heap.length-1)>=0.75)
            resize();
        // Place processor at the next available position
        heap[++size]= x;
        //Let newly added processor swim
        swim(size);
    }

    //doubling the array when the queue is full by 75%
    public void resize(){
        Processor[] tmp = new Processor[heap.length*2];
        for (int i=1;i<size;i++)
            tmp[i]=heap[i];
        heap=tmp;
    }


    //return without removing the object with the highest priority
    @Override
    public Processor max() {
        //queue not empty
        if (size() == 0) throw new IllegalStateException();
        return heap[1];
    }

    @Override
    public Processor getmax() {
        //Queue is not empty
        if (size() == 0) throw new IllegalStateException();
        //Keep a reference to the root item
        Processor root= heap[1];
        // Replace root item with the one at rightmost leaf
        if(size>1)
            heap[1]=heap[size];
        //Dispose the rightmost leaf
        heap[size--]=null;
        // Sink the new root element
        sink(1);
        return root;
    }


    //Helper function to swim items to the top
    //move from top to bottom of queue
    private void swim(int i) {
        // compare parent with child i
        while (i>1) {
            int parent = i / 2;
            if(heap[parent].compareTo(heap[i])>0){
                swap(i, parent);
                i = parent;
            }
        }
    }

    //Helper function to swim items to the bottom
    //move from top to bottom of queue
    protected void sink(int parent){
        // determine left, right child
        int left = 2 * parent;
        int right = left + 1;

        // while haven't reached the leafs
        while (left <= size) {
            if (left<size && (heap[left].compareTo(heap[right])>0))
                left++;
            if (!(heap[parent].compareTo(heap[left])>0))
                break;
            swap(parent,left);
            parent=left;
        }
    }

    //Helper function to swap two elements in the heap
    private void swap(int i, int j) {
        Processor tmp = heap[i];
        heap[i]=heap[j];
        heap[j]=tmp;
    }
}
