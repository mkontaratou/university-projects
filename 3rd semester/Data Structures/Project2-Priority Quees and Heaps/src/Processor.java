public class Processor implements Comparable<Processor> {
    private final int id;
    private static int totalID=0;

    private List processedTasks;

    public Processor(){
        id=++totalID;
        processedTasks = new List();
    }

    public List getProcessedTasks() {
        return processedTasks;
    }

    public int getActiveTime() {
        int sumProcessingTimes=0;
        if (processedTasks.isEmpty())
            sumProcessingTimes=0;
        else{

            Node tmp = processedTasks.getHead();
            while (tmp != null) {
                sumProcessingTimes += tmp.getData();
                tmp=tmp.getNext();
            }
        }
        return sumProcessingTimes;
    }

    public int getId() {
        return id;
    }


    @Override
    public int compareTo(Processor o) {
        //if processor A has worked more than processor O
        if(this.getActiveTime()>o.getActiveTime())
            return 1;

        //if processor O has worked more than processor A
        else if (this.getActiveTime()<o.getActiveTime())
            return -1;

        //processors A and O have worked the same amount
        else{
            // whoever has the smaller id number, gets the "benefits"
            if (this.getId()<o.getId())
                return 1;
            else
                return -1;
        }

    }

}


