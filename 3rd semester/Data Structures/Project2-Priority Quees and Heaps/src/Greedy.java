import java.io.File;
import java.util.Scanner;
import java.io.*;


public class Greedy {
    static int makespan1=0;


    public static void main(String[] args){
        greed(args[0]);
    }

    public static void greed(String k){
        File f = new File(k);
        Scanner reader = null;

        try {
            reader = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (reader!=null) {

            MaxPQ pcs;
            int processorN = reader.nextInt(); //first line of txt file: number of processors
            int taskN = reader.nextInt();//second line of txt file: number of tasks

            pcs = new MaxPQ(processorN); //create a priority queue with capacity of processorN

            //calling the algorithm 1
            MaxPQ queue = greedyOne(processorN,taskN,pcs,reader);
            printOutput(processorN,taskN,queue);

        }
    }


    //greedy algorithm
    static MaxPQ greedyOne(int processorN,int taskN,MaxPQ pcs,Scanner reader){
        for (int i = 0; i < processorN; i++) {
            //adding processor in PQ
            pcs.insert(new Processor());
        }

        for (int i = 0; i<taskN; i++) {
            //after the first 2 lines of txt file
            int taskid = reader.nextInt(); //TaskID
            int time = reader.nextInt(); //processing time of each task
            Task t = new Task(taskid, time);

            Processor Max = pcs.max(); //maximum priority processor
            Max.getProcessedTasks().insertAtBack(time); //puts time in maximum priority processor
            pcs.sink(1); //change maximum priority
        }

        return pcs;
    }


    //greedyDec
    public static MaxPQ greedyDec(int processorN, int taskN, MaxPQ pcs, Scanner reader) {

        for (int i = 0; i < processorN; i++) {
            pcs.insert(new Processor());
        }

        //array for quicksort algorithm
        int[] proc = new int[taskN];
        for (int i = 0; i<taskN; i++) {

            int taskid = reader.nextInt();
            proc[i]=reader.nextInt();
            Task t = new Task(taskid, proc[i]);

        }
        Sort.quickSort(proc,0,proc.length-1);
        for(int i=0;i<proc.length;i++){
            Processor Max = pcs.max(); //maximum priority processor
            Max.getProcessedTasks().insertAtBack(proc[i]); //puts time in maximum priority processor
            pcs.sink(1);//change maximum priority
        }

        return pcs;
    }



    //printing output
    public static void printOutput(int processorN,int taskN,MaxPQ queue){
        for (int i = 0; i < processorN; i++) {
            Processor tmp = queue.getmax(); //temporary processor with hoghest priority which is then removed
            //if task number>50 print the makespan
            if (taskN<50)
                System.out.println("id " + tmp.getId() + ", load=" + tmp.getActiveTime() + ": " + tmp.getProcessedTasks());
            //in every loop we check whether or not the active time of the processor is bigger than the previous makespan
            if (tmp.getActiveTime() > makespan1)
                makespan1 = tmp.getActiveTime();
        }

        System.out.println("Makespan = " + makespan1);
    }
}
