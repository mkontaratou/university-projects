import java.io.*;
import java.util.NoSuchElementException;
//to read txt file
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

//match-pattern
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class NetBenefit {
    static IntQueue queueBuy= new IntQueueImpl();
    static IntQueue queuePrice = new IntQueueImpl();
    static int kerdos=0;


    public static void main(String[] args) {

        BufferedReader reader = null;

        //lista
        Integer[] list =new Integer[2];

        try {
            FileReader fileR=new FileReader(args[0]);
            reader= new BufferedReader(fileR);
            String currLine;


            while ((currLine = reader.readLine()) != null) {
                //gia na vrethei arithmos
                Pattern p=Pattern.compile("[0-9]+");
                Matcher m=p.matcher(currLine);

                for (int i=0;m.find();i++){
                    //lista me length osous arithmous vrei ana seira(2) pou tous metatrepei apo string se int
                    list[i] = Integer.parseInt(m.group());
                }

                if(currLine.matches("buy\\s*(\\d+)\\s+price\\s*(\\d+)")){
                    //apothikeyw dedomena stis 2 oures me put
                    queueBuy.put(list[0]);
                    queuePrice.put(list[1]);

                }else if(currLine.matches("sell\\s*(\\d+)\\s+price\\s*(\\d+)")){

                    //statheres metavlites oi sell kai price
                    int sell = list[0];
                    int price = list[1];


                    try {
                        while (sell > 0) {
                            // an to sell megalytero tou prwtou stoixeiou ths ouras buy
                            if (sell >= queueBuy.peek()) {
                                kerdos += queueBuy.peek() * (price - queuePrice.peek());
                                queuePrice.get();
                                sell -= queueBuy.get();
                            } else {
                                kerdos += sell * (price - queuePrice.peek());
                                queueBuy.getHead(queueBuy.peek()-sell);
                                break;//sell=0;
                            }
                        }
                    } catch (NoSuchElementException e){
                        System.out.println("Error reading. No more investments");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading line...");


        }  finally {

            try {
                if (reader != null)
                    reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            System.out.println("Total profit/damage: "+ kerdos);
        }
    }
}

