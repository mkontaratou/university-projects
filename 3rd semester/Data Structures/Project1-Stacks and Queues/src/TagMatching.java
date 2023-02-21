
import java.util.*;
import java.io.*;

public class TagMatching {
    //stack gia kathe tag
    static StringStack s = new StringStackImpl();


    public static void main(String[] args){

        BufferedReader reader = null;
        try {
            FileReader fileR=new FileReader(args[0]);
            reader= new BufferedReader(fileR);
			String currLine,tok,ts,first;
			String sum="";
            StringTokenizer st;
            //int count =0;
            
            while ((currLine= reader.readLine())!=null){
				String line=currLine.trim();
				st= new StringTokenizer(line,"<");
				while (st.hasMoreTokens()){
					tok=st.nextToken().toString();
					char in = tok.charAt(0);
					ts=String.valueOf(in);
					sum=ts;
					first=ts;
					int i=1;
					while (!ts.trim().equals(">") & i<tok.length()){
						in = tok.charAt(i);
						ts=String.valueOf(in);
						sum=sum+ts;
						i++;
					}
					
					if (!first.trim().equals("/")){
						s.push(sum);
					}
					else if (sum.trim().equals("/"+s.peek())){
						s.pop();
					}
				}	
				

            }

             

        }//try
		catch (IOException e) {
            System.out.println	("Error reading line ...");
		}

			
         finally {

            try {
                if(reader!=null)
                  reader.close();
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }


    if (s.isEmpty())
        System.out.println("tags are matching");
    else
        System.out.println("tags are not matching");
    }

}
