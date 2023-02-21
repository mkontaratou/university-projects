public interface PQInterface {

    //check if the queue is empty
    public boolean isEmpty();

    //return the number of active elements in the queue
    public int size();

    // insert the object x to the queue
    public void insert(Processor x);

    //return without removing the object with the highest priority
    public Processor max();

    // remove and return the object with the highest priority
    public Processor getmax();

}
