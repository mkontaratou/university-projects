import java.util.*;
import java.io.*;


public class CreateFile{

	


	public void CreateFile (ArrayList<Services> yphresies) {	
		System.out.println(" >>>>>>> Write data from ARRAYLIST to SERVICES FILE...");
		
		FileWriter writer = null;

		try	{
			writer = new FileWriter(new File("services.txt"));
		
			for (Services service:yphresies)

				if (service instanceof symvolaio) {
					writer.write ("SERVICE_LIST"+"\n"+"{"+"\n"+"\t"+"SERVICE_NAME Kinhth Thlefvnia 1000"
								+ "\n"+"\t"+"TYPE "+ service.getOnoma()
								+ "\n"+"\t"+"MONTHLY_PRICE "+ service.getPagio()
								+ "\n"+"\t"+"FREE_MINUTES "	+ service.getFreeOmilia()
								+ "\n"+"\t"+"FREE_SMS " + service.getFreeSMS()
								+ "\n"+"\t"+"MINUTES_COST "	+ service.getXreosiOmilia()
								+ "\n"+"\t"+"SMS_COST "	+ service.getXreosiSMS()
								+ "\n"+"}"+"\n");
				}//symvolaio
				else if (service instanceof kartosymvolaio) {
						writer.write ("SERVICE_LIST"+"\n"+"{"+"\n"+"\t"+"SERVICE_NAME KartoSymbolaio 20"
								+ "\n"+"\t"+"TYPE "+ service.getOnoma()
								+ "\n"+"\t"+"MONTHLY_PRICE "+ service.getPagio()
								+ "\n"+"\t"+"FREE_MINUTES "	+ service.getFreeOmilia()
								+ "\n"+"\t"+"FREE_SMS " + service.getFreeSMS()
								+ "\n"+"\t"+"MINUTES_COST "	+ service.getXreosiOmilia()
								+ "\n"+"\t"+"SMS_COST "	+ service.getXreosiSMS()
								+ "\n"+"\t"+"MONTHLY_BALANCE "	+ service.getMiniaioYpoloipo()
								+ "\n"+"}"+"\n");
				}//kartosymvolaio
				else if (service instanceof mobInternet) {
						writer.write ("SERVICE_LIST"+"\n"+"{"+"\n"+"\t"+"SERVICE_NAME Mobile Internet 5"
								+ "\n"+"\t"+"TYPE "+ service.getOnoma()
								+ "\n"+"\t"+"MONTHLY_PRICE "+ service.getPagio()
								+ "\n"+"\t"+"FREE_USAGE "	+ service.getFreeMB()
								+ "\n"+"\t"+"USAGE_COST "	+ service.getXreosiMB()
								+ "\n"+"}"+"\n");
				
				}//mobile-internet
				writer.close();
				
			}//try
			
			catch (IOException e) {
				System.err.println("Error writing file.");
			}
	}
	
	
	public void ReadFile(ArrayList<Services> yphresies){
		
		BufferedReader reader = null;
		
		boolean flag =false;
        String line;
        try {
			
			reader = new BufferedReader(new FileReader(new File("services.txt")));
            line = reader.readLine();
			
			
			
			
            
                for( Services s:yphresies){
					if(line!=null){
					
					if (line.trim().equals("SERVICE_LIST")) {
						line = reader.readLine();
						if (line.trim().equals("{")) {
							line = reader.readLine();
							if (line.trim().startsWith("SERVICE_NAME ")) {
								if (line.trim().substring(12).trim().equals("Kinhth Thlefvnia 1000")) {
									
									line = reader.readLine();
									if (line.trim().startsWith("TYPE "))
									if (line.trim().substring(5).trim().equals("Contract")) 
									line = reader.readLine();
									if (line.trim().startsWith("MONTHLY_PRICE "))
										line = reader.readLine();
									if (line.trim().startsWith("FREE_MINUTES "))
										if (!(line.trim().substring(13).trim().equals(String.valueOf(s.getFreeOmilia()))))
											flag=true;
										line = reader.readLine();
									if (line.trim().startsWith("FREE_SMS "))
										if (!(line.trim().substring(9).trim().equals(String.valueOf(s.getFreeSMS()))))
											flag=true;
											
									line = reader.readLine();
									if (line.trim().startsWith("MINUTES_COST "))
										if (!(line.trim().substring(13).trim().equals(String.valueOf(s.getXreosiOmilia()))))
											flag=true;
									line = reader.readLine();
									if (line.trim().startsWith("SMS_COST "))
										if (!(line.trim().substring(9).trim().equals(String.valueOf(s.getXreosiSMS()))))
											flag=true;
									line = reader.readLine();
								
								} // contract
								else if (line.trim().substring(12).trim().equals("KartoSymbolaio 20")) {
									line = reader.readLine();
									if (line.trim().startsWith("TYPE "))
										line = reader.readLine();
									if (line.trim().substring(5).trim().equals("Card")) 
										line = reader.readLine();
									if (line.trim().startsWith("MONTHLY_PRICE "))
										line = reader.readLine();
									if (line.trim().startsWith("FREE_MINUTES "))
										if (!(line.trim().substring(13).trim().equals(String.valueOf(s.getFreeOmilia()))))
											flag=true;
									line = reader.readLine();
									if (line.trim().startsWith("FREE_SMS "))
										if (!(line.trim().substring(9).trim().equals(String.valueOf(s.getFreeSMS()))))
											flag=true;
									line = reader.readLine();
									if (line.trim().startsWith("MINUTES_COST "))
										if (!(line.trim().substring(13).trim().equals(String.valueOf(s.getXreosiOmilia()))))
											flag=true;
									line = reader.readLine();
									if (line.trim().startsWith("SMS_COST "))
										if (!(line.trim().substring(9).trim().equals(String.valueOf(s.getXreosiSMS()))))
											flag=true;
									line = reader.readLine();
									if (line.trim().startsWith("MONTHLY_BALANCE "))
										if (!(line.trim().substring(16).trim().equals(String.valueOf(s.getMiniaioYpoloipo()))))
											flag=true;
									line = reader.readLine();
								}//card
								else if (line.trim().substring(12).trim().equals("Mobile Internet 5")) {
									line = reader.readLine();
									if (line.trim().startsWith("TYPE "))
										line = reader.readLine();
									if (line.trim().substring(5).trim().equals("Mobile Internet")) 
										line = reader.readLine();
									if (line.trim().startsWith("MONTHLY_PRICE "))
										line = reader.readLine();
									if (line.trim().startsWith("FREE_USAGE "))
										if (!(line.trim().substring(11).trim().equals(String.valueOf(s.getFreeMB()))))
											flag=true;
									line = reader.readLine();
									if (line.trim().startsWith("USAGE_COST "))
										if (!(line.trim().substring(11).trim().equals(String.valueOf(s.getXreosiMB()))))
											flag=true;
									line = reader.readLine();
								}//mobile-internet
							
							
							
							} 
						}
					} //service-list
					line = reader.readLine();
					
				}//null
			}//for
			reader.close();
			
			
		} //try

		catch (IOException e) {
            System.out.println	("Error reading line ...");
		}
	if (flag==true){ 
	CreateFile(yphresies);}
	} // ReadFile
	



	public void AppendFile (Services service) {	
		System.out.println(" >>>>>>> Add data from ARRAYLIST to SERVICES FILE...");
		
		FileWriter writer = null;

		try	{
			writer = new FileWriter("services.txt",true);
		
			

				if (service instanceof symvolaio) {
					writer.write ("SERVICE_LIST"+"\n"+"{"+"\n"+"\t"+"SERVICE_NAME Kinhth Thlefvnia 1000"
								+ "\n"+"\t"+"TYPE "+ service.getOnoma()
								+ "\n"+"\t"+"MONTHLY_PRICE "+ service.getPagio()
								+ "\n"+"\t"+"FREE_MINUTES "	+ service.getFreeOmilia()
								+ "\n"+"\t"+"FREE_SMS " + service.getFreeSMS()
								+ "\n"+"\t"+"MINUTES_COST "	+ service.getXreosiOmilia()
								+ "\n"+"\t"+"SMS_COST "	+ service.getXreosiSMS()
								+ "\n"+"}"+"\n");
				}//symvolaio
				else if (service instanceof kartosymvolaio) {
						writer.write ("SERVICE_LIST"+"\n"+"{"+"\n"+"\t"+"SERVICE_NAME KartoSymbolaio 20"
								+ "\n"+"\t"+"TYPE "+ service.getOnoma()
								+ "\n"+"\t"+"MONTHLY_PRICE "+ service.getPagio()
								+ "\n"+"\t"+"FREE_MINUTES "	+ service.getFreeOmilia()
								+ "\n"+"\t"+"FREE_SMS " + service.getFreeSMS()
								+ "\n"+"\t"+"MINUTES_COST "	+ service.getXreosiOmilia()
								+ "\n"+"\t"+"SMS_COST "	+ service.getXreosiSMS()
								+ "\n"+"\t"+"MONTHLY_BALANCE "	+ service.getMiniaioYpoloipo()
								+ "\n"+"}"+"\n");
				}//kartosymvolaio
				else if (service instanceof mobInternet) {
						writer.write ("SERVICE_LIST"+"\n"+"{"+"\n"+"\t"+"SERVICE_NAME Mobile Internet 5"
								+ "\n"+"\t"+"TYPE "+ service.getOnoma()
								+ "\n"+"\t"+"MONTHLY_PRICE "+ service.getPagio()
								+ "\n"+"\t"+"FREE_USAGE "	+ service.getFreeMB()
								+ "\n"+"\t"+"USAGE_COST "	+ service.getXreosiMB()
								+ "\n"+"}"+"\n");
				
				}//mobile-internet
				writer.close();
				
			}//try
			
			catch (IOException e) {
				System.err.println("Error writing file.");
			}
	}



	



	
}