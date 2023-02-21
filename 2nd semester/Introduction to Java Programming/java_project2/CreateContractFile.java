import java.util.*;
import java.io.*;




public class CreateContractFile{
	
	
		
	
	
	public void CreateContractFile (Services service,contract c,int start) {	
		
		FileWriter writer = null;
		
		try	{
			if (start==1){
				writer = new FileWriter(new File("contracts.txt"));
				writer.write ("CONTRACT_LIST"+"\n"+"{"+"\n");
				System.out.println(" >>>>>>> Write data from ARRAYLIST to CONTRACTS FILE...");
				}
			else{
				writer = new FileWriter("contracts.txt",true);
			}
				if (c!=null){
					if (service instanceof symvolaio) {
						writer.write ("\t"+"CONTRACT"+"\n"+"\t"+"{"+"\n"+"\t"+"  "+"CONTRACT_NUMBER "+service.getId()
									+ "\n"+"\t"+"  "+"SERVICE_NAME Kinhth Thlefvnia 1000"
									+ "\n"+"\t"+"  "+"CUSTOMER "+ c.getName()+ " "+ c.getSurname()
									+ "\n"+"\t"+"  "+"PHONE_NUMBER "+ c.getPhone()
									+ "\n"+"\t"+"  "+"ACTIVATION_DATE "	+ c.getDate()
									+ "\n"+"\t"+"  "+"DISCOUNT " + c.getSale()
									+ "\n"+"\t"+"  "+"MONTHLY USAGE "+ "\n"+"\t"+"  "+"{"+ "\n"+"\t"+"    "+"PHONE_MINUTES "+ (service.getFreeOmilia()+service.getXreosiOmilia())
									+ "\n"+"\t"+"    "+"SMS "+ (service.getFreeSMS()+service.getXreosiSMS())
									+ "\n"+"\t"+"  "+"}"+"\n"+"\t"+"}"+"\n");
					}//symvolaio
					else if (service instanceof kartosymvolaio) {
							writer.write ("\t"+"CONTRACT"+"\n"+"\t"+"{"+"\n"+"\t"+"  "+"CONTRACT_NUMBER "+service.getId()
									+ "\n"+"\t"+"  "+"SERVICE_NAME KartoSymbolaio 20"
									+ "\n"+"\t"+"  "+"CUSTOMER "+ c.getName()+ " "+ c.getSurname()
									+ "\n"+"\t"+"  "+"PHONE_NUMBER "+ c.getPhone()
									+ "\n"+"\t"+"  "+"ACTIVATION_DATE "	+ c.getDate()
									+ "\n"+"\t"+"  "+"DISCOUNT " + c.getSale()
									+ "\n"+"\t"+"  "+"MONTHLY USAGE "+ "\n"+"\t"+"  "+"{"+ "\n"+"\t"+"    "+"PHONE_MINUTES "+ (service.getFreeOmilia()+service.getXreosiOmilia())
									+ "\n"+"\t"+"    "+"SMS "+ (service.getFreeSMS()+service.getXreosiSMS())
									+ "\n"+"\t"+"    "+"SPENT "+ service.getMiniaioYpoloipo() 
									+ "\n"+"\t"+"  "+"}"+"\n"+"\t"+"}"+"\n");
					}//kartosymvolaio
					else if (service instanceof mobInternet) {
							writer.write ("\t"+"CONTRACT"+"\n"+"\t"+"{"+"\n"+"\t"+"  "+"CONTRACT_NUMBER "+service.getId()
									+ "\n"+"\t"+"  "+"SERVICE_NAME Mobile Internet 5"
									+ "\n"+"\t"+"  "+"CUSTOMER "+ c.getName()+ " "+ c.getSurname()
									+ "\n"+"\t"+"  "+"PHONE_NUMBER "+ c.getPhone()
									+ "\n"+"\t"+"  "+"ACTIVATION_DATE "	+ c.getDate()
									+ "\n"+"\t"+"  "+"DISCOUNT " + c.getSale()
									+ "\n"+"\t"+"  "+"MONTHLY USAGE "+ "\n"+"\t"+"  "+"{"+ "\n"+"\t"+"    "+"VOLUME "+ (service.getFreeMB()+service.getXreosiMB())
									+ "\n"+"\t"+"  "+"}"+"\n"+"\t"+"}"+"\n");
					
					}//mobile-internet
				
				writer.close();
			}
				
			}//try
			
			catch (IOException e) {
				System.err.println("Error writing file.");
			}
	}
	
	
	
	
	
	public boolean ReadContractFile(ArrayList<Services> yphresies){
		
		BufferedReader reader = null;
		
		boolean flag =false;
        String line;
        try {
			
			reader = new BufferedReader(new FileReader(new File("contracts.txt")));
            line = reader.readLine();
			
			
			
				if (line.trim().equals("CONTRACT_LIST")) {
					line = reader.readLine();
					if (line.trim().equals("{")) {
						line = reader.readLine();
						for( Services s:yphresies){
							if(line!=null){
								if (line.trim().startsWith("CONTRACT")) {
									line = reader.readLine();
									if (line.trim().equals("{")) 
										line = reader.readLine();
									if (line.trim().startsWith("CONTRACT_NUMBER")) 
										if (line.trim().substring(16).trim().equals(String.valueOf(s.getId())))
											line = reader.readLine();
										if (line.trim().equals("SERVICE_NAME Kinhth Thlefvnia 1000")){
												line = reader.readLine();
											if (line.trim().startsWith("CUSTOMER"))
												line = reader.readLine();
											if (line.trim().startsWith("PHONE_NUMBER "))
												line = reader.readLine();
											if (line.trim().startsWith("ACTIVATION_DATE "))
												line = reader.readLine();
											if (line.trim().startsWith("DISCOUNT"))
												line = reader.readLine();
											if (line.trim().startsWith("MONTHLY USAGE"))
												line = reader.readLine();
											if (line.trim().equals("{")) 
												line = reader.readLine();
											if (line.trim().startsWith("PHONE_MINUTES"))
												if (!(line.trim().substring(14).trim().equals(String.valueOf(s.getFreeOmilia()+s.getXreosiOmilia()))))
													flag=true;
												line = reader.readLine();
											if (line.trim().startsWith("SMS"))
												if (!(line.trim().substring(4).trim().equals(String.valueOf(s.getFreeSMS()+s.getXreosiSMS()))))
													flag=true;
												line = reader.readLine();
												
											if (line.trim().equals("}")) 
												line = reader.readLine();
												
											if (line.trim().equals("}")) 
												line = reader.readLine();
										} // contract
									else if (line.trim().equals("SERVICE_NAME KartoSymbolaio 20")) {
											line = reader.readLine();
											if (line.trim().startsWith("CUSTOMER"))
												line = reader.readLine();
											if (line.trim().startsWith("PHONE_NUMBER "))
												line = reader.readLine();
											if (line.trim().startsWith("ACTIVATION_DATE "))
												line = reader.readLine();
											if (line.trim().startsWith("DISCOUNT"))
												line = reader.readLine();
											if (line.trim().startsWith("MONTHLY USAGE"))
												line = reader.readLine();
											if (line.trim().equals("{")) 
												line = reader.readLine();
											if (line.trim().startsWith("PHONE_MINUTES"))
												
												if (!(line.trim().substring(14).trim().equals(String.valueOf(s.getFreeOmilia()+s.getXreosiOmilia()))))
													flag=true;
												line = reader.readLine();
											if (line.trim().startsWith("SMS"))
												if (!(line.trim().substring(4).trim().equals(String.valueOf(s.getFreeSMS()+s.getXreosiSMS()))))
													flag=true;
												line = reader.readLine();
											if (line.trim().startsWith("SPENT"))
												if (!(line.trim().substring(6).trim().equals(String.valueOf(s.getMiniaioYpoloipo() ))))
													flag=true;
												line = reader.readLine();
											if (line.trim().equals("}")) 
												line = reader.readLine();
											if (line.trim().equals("}")) 
												line = reader.readLine();
										
									}//card
									else if (line.trim().equals("SERVICE_NAME Mobile Internet 5")) {
											line = reader.readLine();
											if (line.trim().startsWith("CUSTOMER"))
												line = reader.readLine();
											if (line.trim().startsWith("PHONE_NUMBER "))
												line = reader.readLine();
											if (line.trim().startsWith("ACTIVATION_DATE "))
												line = reader.readLine();
											if (line.trim().startsWith("DISCOUNT"))
												line = reader.readLine();
											if (line.trim().startsWith("MONTHLY USAGE"))
												line = reader.readLine();
											if (line.trim().equals("{")) 
												line = reader.readLine();
											if (line.trim().startsWith("VOLUME"))
												
												if (!(line.trim().substring(7).trim().equals(String.valueOf(s.getFreeMB()+s.getXreosiMB()))))
													flag=true;
												line = reader.readLine();
											if (line.trim().equals("}")) 
												line = reader.readLine();
											if (line.trim().equals("}")) 
												line = reader.readLine();
									}//mobile-internet
								
								
								}
							} //null
						}//for
					} 
					line = reader.readLine();
								
					
				}//contract-list
				reader.close();
			
			
		} //try

		catch (IOException e) {
            System.out.println	("Error reading line ...");
		}
		
		return flag;
		
	} // ReadFile
	
	
	
	public void AppendContractFile (Services service,contract c) {	
		System.out.println(" >>>>>>> Add data from ARRAYLIST to CONTRACTS FILE...");
		
		FileWriter writer = null;

		try	{
			writer = new FileWriter("contracts.txt",true);
		
			

				if (service instanceof symvolaio) {
						writer.write ("\t"+"CONTRACT"+"\n"+"\t"+"{"+"\n"+"\t"+"  "+"CONTRACT_NUMBER "+service.getId()
									+ "\n"+"\t"+"  "+"SERVICE_NAME Kinhth Thlefvnia 1000"
									+ "\n"+"\t"+"  "+"CUSTOMER "+ c.getName()+ " "+ c.getSurname()
									+ "\n"+"\t"+"  "+"PHONE_NUMBER "+ c.getPhone()
									+ "\n"+"\t"+"  "+"ACTIVATION_DATE "	+ c.getDate()
									+ "\n"+"\t"+"  "+"DISCOUNT " + c.getSale()
									+ "\n"+"\t"+"  "+"MONTHLY USAGE "+ "\n"+"\t"+"  "+"{"+ "\n"+"\t"+"    "+"PHONE_MINUTES "+ (service.getFreeOmilia()+service.getXreosiOmilia())
									+ "\n"+"\t"+"    "+"SMS "+ (service.getFreeSMS()+service.getXreosiSMS())
									+ "\n"+"\t"+"  "+"}"+"\n"+ "\n"+"\t"+"}"+"\n");
					}//symvolaio
					else if (service instanceof kartosymvolaio) {
							writer.write ("\t"+"CONTRACT"+"\n"+"\t"+"{"+"\n"+"\t"+"  "+"CONTRACT_NUMBER "+service.getId()
									+ "\n"+"\t"+"  "+"SERVICE_NAME KartoSymbolaio 20"
									+ "\n"+"\t"+"  "+"CUSTOMER "+ c.getName()+ " "+ c.getSurname()
									+ "\n"+"\t"+"  "+"PHONE_NUMBER "+ c.getPhone()
									+ "\n"+"\t"+"  "+"ACTIVATION_DATE "	+ c.getDate()
									+ "\n"+"\t"+"  "+"DISCOUNT " + c.getSale()
									+ "\n"+"\t"+"  "+"MONTHLY USAGE "+ "\n"+"\t"+"  "+"{"+ "\n"+"\t"+"    "+"PHONE_MINUTES "+ (service.getFreeOmilia()+service.getXreosiOmilia())
									+ "\n"+"\t"+"    "+"SMS "+ (service.getFreeSMS()+service.getXreosiSMS())
									+ "\n"+"\t"+"    "+"SPENT "+ service.getMiniaioYpoloipo() 
									+ "\n"+"\t"+"  "+"}"+"\n"+ "\n"+"\t"+"}"+"\n");
					}//kartosymvolaio
					else if (service instanceof mobInternet) {
							writer.write ("\t"+"CONTRACT"+"\n"+"\t"+"{"+"\n"+"\t"+"  "+"CONTRACT_NUMBER "+service.getId()
									+ "\n"+"\t"+"  "+"SERVICE_NAME Mobile Internet 5"
									+ "\n"+"\t"+"  "+"CUSTOMER "+ c.getName()+ " "+ c.getSurname()
									+ "\n"+"\t"+"  "+"PHONE_NUMBER "+ c.getPhone()
									+ "\n"+"\t"+"  "+"ACTIVATION_DATE "	+ c.getDate()
									+ "\n"+"\t"+"  "+"DISCOUNT " + c.getSale()
									+ "\n"+"\t"+"  "+"MONTHLY USAGE "+ "\n"+"\t"+"  "+"{"+ "\n"+"\t"+"    "+"VOLUME "+ (service.getFreeMB()+service.getXreosiMB())
									+ "\n"+"\t"+"  "+"}"+"\n"+ "\n"+"\t"+"}"+"\n");
					
					}//mobile-internet
				writer.close();
				
			}//try
			
			catch (IOException e) {
				System.err.println("Error writing file.");
			}
	}
	
	
	
}