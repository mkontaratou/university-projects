import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;


public class Comparisons {

    public static int Gspan=0;
    public static int GDspan=0;


    public static void main(String[] args) throws IOException {

        int [] N = {100,500,1000};
        for (int k : N) {
            for (int j = 0; j < 10; j++) {
                //create 10 files for N = 100,500,1000 total noFiles=30
                newFile("src/data/" + k + "test" +j+ ".txt", k);
            }

            for (int j = 0; j < 10; j++){
                //test files
                Test("src/data/"+k+"test"+j+".txt");
            }


            //find the average makespan for each case
            int avGspan = Gspan / 10;
            int avGBspan = GDspan / 10;

            System.out.println("Average greed makespan ("+k+") "+avGspan + "\n" + "Average greed-dec makespan ("+k+") "+avGBspan + "\n");
            //erase makespan for next loop
            Gspan=0;
            GDspan=0;
        }
    }

    private static void Test(String filename){
        greedy(filename,1); //Greedy
        greedy(filename,2); //Greedy Decimal
    }

    private static void newFile(String name, int n) throws IOException {
        Random r = new Random();
        Writer writer = new OutputStreamWriter(new FileOutputStream(name), StandardCharsets.UTF_8);
        writer.write((int)Math.round(Math.sqrt(n))+"\n"); //processorN
        writer.write(n + "\n"); //taskN

        for(int i=0;i<n;i++)
            //taskId and time
            writer.write((r.nextInt(100))+ " "+ (r.nextInt(100))+"\n");
        writer.flush();
        writer.close();
    }



    public static void greedy(String filename,int al){
        File f = new File(filename);
        Scanner reader = null;

        try {
            reader = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (reader!=null) {

            MaxPQ pcs;
            int processorN = reader.nextInt();
            int taskN = reader.nextInt();

            pcs = new MaxPQ(processorN);
            int makespan=0;
            if (al==1){
                MaxPQ queue = greedyOne(processorN,taskN,pcs,reader);
                //finding Greedy makespan
                for (int i = 0; i < processorN; i++) {
                    Processor tmp = pcs.getmax();
                    if(tmp.getActiveTime()>makespan) makespan = tmp.getActiveTime();
                }
                Gspan += makespan;
            }
            else {
                //finding Greedy Decimal makespan
                MaxPQ queue = greedyDec(processorN,taskN,pcs,reader);
                for (int i = 0; i < processorN; i++) {
                    Processor tmp = pcs.getmax();
                    if(tmp.getActiveTime()>makespan) makespan = tmp.getActiveTime();
                }
                GDspan += makespan;
            }

        }
    }

    //greedy algorithm
    private static MaxPQ greedyOne(int processorN, int taskN, MaxPQ pcs, Scanner reader){
        for (int i = 0; i < processorN; i++) {
            pcs.insert(new Processor());
        }

        for (int i = 0; i<taskN; i++) {

            int taskid = reader.nextInt();
            int time = reader.nextInt();
            Task t = new Task(taskid, time);

            Processor Max = pcs.max(); //maximum priority processor
            Max.getProcessedTasks().insertAtBack(time); //puts time in maximum priority processor
            pcs.sink(1);//change maximum priority
        }

        return pcs;
    }


    //greedyDec
    private static MaxPQ greedyDec(int processorN, int taskN, MaxPQ pcs, Scanner reader) {

        for (int i = 0; i < processorN; i++) {
            pcs.insert(new Processor());
        }


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


}
