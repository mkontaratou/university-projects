//Omada 55
//Melh omadas
// p3200078, Maria Kontaratou
// p3200083, Giorgos Koumoundouros
// p3200089, Panagiotis Konstantinakos




import java.util.*;
import java.io.*;

public class mainReadApp {
    
	public static ArrayList<Services> yphresies = new ArrayList<Services>();
	public  static ArrayList<contract> symvolaia = new ArrayList<contract>();

	public void ReadfileS(){
		
		BufferedReader reader = null;
		Services s = null;
        String line;
		System.out.println("\n >>>>>>> Adding Objects (Services) from File to List ...");
        try {
			reader = new BufferedReader(new FileReader(new File("services_read.txt")));
            line = reader.readLine();
            while (line != null) {
                if (line.trim().equals("SERVICE_LIST")) {
                    line = reader.readLine();
                    if (line.trim().equals("{")) {
                        line = reader.readLine();
                        if (line.trim().startsWith("SERVICE_NAME")) {
                            if (line.trim().substring(13).trim().equals("Kinhth Thlefvnia 1000")) {
                                s = new symvolaio(" ",0,0,0,0,0);
                                line = reader.readLine();
                                if (line.trim().startsWith("TYPE"))
                                    s.setOnoma(line.substring(5).trim());
                                line = reader.readLine();
                                if (line.trim().startsWith("MONTHLY_PRICE"))
                                    s.setPagio(Double.parseDouble(line.trim().substring(14).trim()));
                                line = reader.readLine();
                                if (line.trim().startsWith("FREE_MINUTES"))
                                    s.setFreeOmilia(Integer.parseInt(line.substring(13).trim()));
                                line = reader.readLine();
                                if (line.trim().startsWith("FREE_SMS"))
                                    s.setFreeSMS(Integer.parseInt(line.substring(9).trim()));
                                line = reader.readLine();
                                if (line.trim().startsWith("MINUTES_COST"))
                                    s.setXreosiOmilia(Integer.parseInt(line.substring(13).trim()));
                                line = reader.readLine();
								if (line.trim().startsWith("SMS_COST"))
                                    s.setXreosiSMS(Integer.parseInt(line.substring(9).trim()));
									line = reader.readLine();
                                if (line.trim().equals("}"))
                                   yphresies.add(s);
							} // Contract
							else if (line.trim().substring(13).trim().equals("KartoSymbolaio 20")) {
                                s = new kartosymvolaio(" ",0,0,0,0,0,0);
                                line = reader.readLine();
                                if (line.trim().startsWith("TYPE"))
                                    s.setOnoma(line.substring(5).trim());
                                line = reader.readLine();
                                if (line.trim().startsWith("MONTHLY_PRICE"))
                                    s.setPagio(Double.parseDouble(line.trim().substring(14).trim()));
                                line = reader.readLine();
                                if (line.trim().startsWith("FREE_MINUTES"))
                                    s.setFreeOmilia(Integer.parseInt(line.substring(13).trim()));
                                line = reader.readLine();
                                if (line.trim().startsWith("FREE_SMS"))
                                    s.setFreeSMS(Integer.parseInt(line.substring(9).trim()));
                                line = reader.readLine();
                                if (line.trim().startsWith("MINUTES_COST"))
                                    s.setXreosiOmilia(Integer.parseInt(line.substring(13).trim()));
                                line = reader.readLine();
								if (line.trim().startsWith("SMS_COST"))
                                    s.setXreosiSMS(Integer.parseInt(line.substring(9).trim()));
								line = reader.readLine();
								if (line.trim().startsWith("MONTHLY_BALANCE"))
                                    s.setMiniaioYpoloipo(Double.parseDouble(line.trim().substring(16).trim()));
                                line = reader.readLine();
								if (line.trim().equals("}"))
                                   yphresies.add(s);
                            }//Card
							else if (line.trim().substring(13).trim().equals("Mobile Internet 5")) {
                                s = new mobInternet(" ",0,0,0);
                                line = reader.readLine();
                                if (line.trim().startsWith("TYPE"))
                                    s.setOnoma(line.substring(5).trim());
                                line = reader.readLine();
                                if (line.trim().startsWith("MONTHLY_PRICE"))
                                    s.setPagio(Double.parseDouble(line.trim().substring(14).trim()));
                                line = reader.readLine();
                                if (line.trim().startsWith("FREE_USAGE"))
                                    s.setFreeMB(Integer.parseInt(line.substring(11).trim()));
                                line = reader.readLine();
                                if (line.trim().startsWith("USAGE_COST"))
                                    s.setXreosiMB(Integer.parseInt(line.substring(11).trim()));
                                line = reader.readLine();
                                if (line.trim().equals("}"))
                                   yphresies.add(s);
                            }//Mobile-internet
                        } //services
                    }
                } 
				line = reader.readLine();
				
			}//while
			reader.close();
			
		} //try

		catch (IOException e) {
            System.out.println	("Error reading line ...");
		}
	
	} // ReadFile
	
	
	
	
	
	
	
	
	public void ReadfileC(){
		
		BufferedReader reader = null;
		contract c = null;
        String line;
		System.out.println("\n >>>>>>> Adding Objects (Contracts) from File to List ...");
        try {
			reader = new BufferedReader(new FileReader(new File("contracts_read.txt")));
            line = reader.readLine();
			int i =0;
			int cter=0;
			String nam="";
			char catr;
            
			if (line.trim().equals("CONTRACT_LIST")) {
                line = reader.readLine();
                if (line.trim().equals("{")) {
                    line = reader.readLine();
			
					while (line != null) {
						if (line.trim().equals("CONTRACT")) {
							line = reader.readLine();
							if (line.trim().equals("{")) {
								line = reader.readLine();
								if (line.trim().startsWith("CONTRACT_NUMBER")) {
									c = new contract(" "," "," "," "," ",0,null);
										c.setId(Integer.parseInt(line.trim().substring(16).trim()));
										line = reader.readLine();
										if (line.trim().startsWith("SERVICE_NAME"))
										line = reader.readLine();
										if (line.trim().startsWith("CUSTOMER"))
											cter=9;
											nam="";
											while ((line.trim().substring(cter,cter+1).trim()!="") & (line.trim().substring(9).trim().length()>cter)){
												nam+=line.trim().substring(cter,cter+1).trim();
												cter+=1;
											}
											c.setName(nam);
											c.setSurname(line.trim().substring(cter).trim());
										line = reader.readLine();
										if (line.trim().startsWith("PHONE_NUMBER"))
											c.setPhone(line.substring(16).trim());
										line = reader.readLine();
										if (line.trim().startsWith("ACTIVATION_DATE"))
											c.setDate(line.substring(19).trim());
										line = reader.readLine();
										if (line.trim().startsWith("DISCOUNT"))
											c.setSale(Double.parseDouble(line.trim().substring(9).trim()));
										line = reader.readLine();
										if (line.trim().startsWith("MONTHLY USAGE"))
											if (line.trim().equals("{"))
												line = reader.readLine();
												if (line.trim().equals("PHONE_MINUTES")){
													line = reader.readLine();
													if (line.trim().equals("SMS"))
														line = reader.readLine();
													if (line.trim().equals("}")){
														line = reader.readLine();
													}
													else if (line.trim().equals("SPENT")){
														line = reader.readLine();
														if (line.trim().equals("}"))
															line = reader.readLine();
													}
												}
												else if (line.trim().equals("VOLUME")){
													line = reader.readLine();
													if (line.trim().equals("}"))
														line = reader.readLine();
												}
												if (line.trim().equals("}"))
													line = reader.readLine();
									
													
											if (yphresies.size()>i){
												c.setYphres(yphresies.get(i));
												i+=1;
											}
										symvolaia.add(c);
								} // Contract
									
							} 
						}
					 
						line = reader.readLine();
							
					}//while
				}
			
			
			}
			
			reader.close();
			
		} //try

		catch (IOException e) {
            System.out.println	("Error reading line ...");
		}
	
	} // ReadFile
	
	
	
	public static void main(String[] args){
		
		//arxikopoihsh timwn se Eurw gia ta statistika xrhshs(SMS, lepta omilias, MB) ana 1
		double ConSMSCost = 0.1;
		double ConOmiliaCost = 0.2;
		double CaSMSCost = 0.05;
		double CaOmiliaCost = 0.3;
		double MBCost = 0.2;
		
		
        
		stats stat = new stats();
		mainReadApp Rfs = new mainReadApp();
		Rfs.ReadfileS(); 
		Rfs.ReadfileC();
		
        Scanner s = new Scanner(System.in);
		int i = 6;
		  
        boolean not=true;
        while(not) {
            System.out.println("\n-------------------------------------------------------------------------------");
            System.out.println("1. Print available services ");
            System.out.println("2. Create new contract ");
            System.out.println("3. Print active contracts for a specific type of service ");
            System.out.println("4. Update statistics of usage of a contract");
            System.out.println("5. Calculate total monthly cost and monthly available remaining money" );
            System.out.println("6. Calculate free talk time and free SMS or free MB or remaining money"); 
			System.out.println("7. Exit");
            System.out.println("-------------------------------------------------------------------------------\n");
            System.out.print("> ");
			int x = s.nextInt();
            switch(x) {
                case 1:
                    System.out.println("1.Services of mobile telephony (Contract programs or card contract programs)");
                    System.out.println("2.Services mobile- Internet");
                    break;
                case 2:
                    System.out.println("Create new contract: 1. Contract program 2. card contract program 3. Program mobile-Internet ");
                    int y = s.nextInt();
                    String name1,surname,phone,date,payment, theName,theSurname,ctype;
                    double pagio1,ekptwsi1,miniaioYpoloipo1,sale,avmon;
                    int freeOmilia1,freeSMS1,xreosiOmilia1,xreosiSMS1,freeMB1,xreosiMB1;
                    switch (y) {
                        case 1:
                            System.out.println("Create contract program");
                            System.out.println("Name: ");
                            s.nextLine();
                            name1=s.nextLine();
							System.out.println("Surname: ");
							surname = s.nextLine();
							System.out.println("Phone: ");
							phone = s.nextLine();
							System.out.println("Starting date of contract: ");
							date = s.nextLine();
							System.out.println("Payment method: ");
							payment = s.nextLine();
                            System.out.println("Contract sale: 20% ");
							System.out.println("Extra sale of contract: ");
							sale = s.nextDouble();
                            System.out.println("Fixed cost of contract: 7");
                            pagio1=7;
                            System.out.println("Free talk time to mobile phones and stable networks: ");
                            freeOmilia1=s.nextInt();
                            System.out.println("Free SMS: ");
                            freeSMS1=s.nextInt();
                            System.out.println("Charge for talk time to mobile phones and stable networks after the free talk time: ");
                            xreosiOmilia1=s.nextInt();
                            System.out.println("Charge for SMS after the free SMS: ");
                            xreosiSMS1=s.nextInt();
						    ctype = "Contract";
                            yphresies.add(new symvolaio(ctype,pagio1,freeOmilia1,freeSMS1,xreosiOmilia1,xreosiSMS1));
                            contract ob1 = new contract(name1,surname,phone,date,payment,sale,yphresies.get(i));
							i+=1;
							symvolaia.add(ob1);
							break;
                        case 2:
                            System.out.println("Create card contract program");
                            System.out.println("Name: ");
                            s.nextLine();
                            name1=s.nextLine();
							System.out.println("Surname: ");
							surname = s.nextLine();
							System.out.println("Phone: ");
							phone = s.nextLine();
							System.out.println("Starting date of contract: ");
							date = s.nextLine();
							System.out.println("Payment method: ");
							payment = s.nextLine();
                            System.out.println("Sale of program 25% ");
							System.out.println("Extra sale of contract: ");
							sale =s.nextDouble();
                            System.out.println("Fixed cost of program: 8");
                            pagio1= 8 ;
                            System.out.println("Free talk time to mobile phones and stable networks: ");
                            freeOmilia1=s.nextInt();
                            System.out.println("Free SMS: ");
                            freeSMS1=s.nextInt();
                            System.out.println("Charge for talk time to mobile phones and stable networks after the free talk time: ");
                            xreosiOmilia1=s.nextInt();
                            System.out.println("Charge for SMS after the free SMS: ");
                            xreosiSMS1=s.nextInt();
							System.out.println("Monthly available remaining money: ");
							avmon = s.nextDouble();
							ctype = "Card";
                            yphresies.add(new kartosymvolaio(ctype,pagio1,freeOmilia1,freeSMS1,xreosiOmilia1,xreosiSMS1,avmon));
							contract ob2 = new contract(name1,surname,phone,date,payment,sale,yphresies.get(i));
							i+=1;
							symvolaia.add(ob2);
                            break;
                        case 3:
                            System.out.println("Create program mobile-Internet");
                            System.out.println("Name: ");
                            s.nextLine();
                            name1=s.nextLine();
							System.out.println("Surname: ");
							surname = s.nextLine();
							System.out.println("Phone: ");
							phone = s.nextLine();
							System.out.println("Starting date of contract: ");
							date = s.nextLine();
							System.out.println("Payment method: ");
							payment = s.nextLine();
                            System.out.println("Sale of program: 30% ");
							System.out.println("Extra sale of contract: ");
							sale =s.nextDouble();
                            System.out.println("Fixed cost of program: 10 ");
                            pagio1=10;
                            System.out.println("Free MB: ");
                            freeMB1=s.nextInt();
                            System.out.println("Charge for MB after the free MB: ");
                            xreosiMB1=s.nextInt();
							ctype = "Mobile Internet";
                            yphresies.add(new mobInternet(ctype,pagio1,freeMB1,xreosiMB1));
							contract ob3 = new contract(name1,surname,phone,date,payment,sale,yphresies.get(i));
							i+=1;
							symvolaia.add(ob3);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Print active contracts for a specific type of service");
                    System.out.println("Choose type of contract: 1. Contract program 2. Card contract program 3. Program mobile-Internet ");
                    int z = s.nextInt();
					int id2 = 0;
                    switch (z) {
                        case 1:
                            for (Services service: yphresies){
                                if(service instanceof symvolaio){
									id2= service.getId();
									stat.findContract(id2,symvolaia);
								}
                            }
                            break;
                        case 2:
                            for (Services service: yphresies){
                                if(service instanceof kartosymvolaio)
                                    id2= service.getId();
									stat.findContract(id2,symvolaia);
                            }
                            break;
                        case 3:
                            for (Services service: yphresies){
                                if(service instanceof mobInternet)
                                    id2= service.getId();
									stat.findContract(id2,symvolaia);
                            }
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Update statistics of usage of a contract");
                    System.out.println("Choose type of contract: 1. Contract program 2. Card contract program 3. Program mobile-Internet ");
					int k = s.nextInt();
					int CfreeOmilia1,CfreeSMS1,CxreosiOmilia1,CxreosiSMS1,type, CfreeMB, CxreosiMB,cid;
					double Cavmon;
					String cname,csurname;
					switch(k) {
						case 1:
                            System.out.println("Write the contract's name holder: ");
                            s.nextLine();
							cname = s.nextLine();
							System.out.println("Write the contract's surname holder: ");
                            csurname=s.nextLine();
							cid = stat.checkName(cname,csurname,symvolaia );
							if (cid!=-1){
								System.out.println("Change your contract's stats"); 
								System.out.println("Free talk time to mobile phones and stable networks: ");
								CfreeOmilia1=s.nextInt();
								System.out.println("Free SMS: ");
								CfreeSMS1=s.nextInt();
								System.out.println("Charge for talk time to mobile phones and stable networks after the free talk time: ");
								CxreosiOmilia1=s.nextInt();
								System.out.println("Charge for SMS after the free SMS: ");
								CxreosiSMS1=s.nextInt();
								type = 1;
								for (Services s1: yphresies){
									if ( s1.getOnoma().equals("Contract")){
										if (s1.getId() == cid ){
											stat.changeStats(cid, CfreeOmilia1, CfreeSMS1, CxreosiOmilia1, CxreosiSMS1,0,0,0,  s1, type);
										}
									}
									
								}
								
							}
                            break;
						case 2:
							System.out.println("Write the contract's name holder: ");
							s.nextLine();
							cname = s.nextLine();
							System.out.println("Write the contract's surname holder: ");
							csurname=s.nextLine();
							cid = stat.checkName(cname,csurname,symvolaia );
							if (cid!=-1){
								System.out.println("Change your contract's stats");
								System.out.println("Free talk time to mobile phones and stable networks: ");
								CfreeOmilia1=s.nextInt();
								System.out.println("Free SMS: ");
								CfreeSMS1=s.nextInt();
								System.out.println("Charge for talk time to mobile phones and stable networks after the free talk time: ");
								CxreosiOmilia1=s.nextInt();
								System.out.println("Charge for SMS after the free SMS: ");
								CxreosiSMS1=s.nextInt();
								System.out.println("Monthly available remaining money: ");
								Cavmon = s.nextDouble();
								type = 2;
								for (Services s1: yphresies){
									if ( s1.getOnoma().equals("Card")){
										if (s1.getId() == cid){
											stat.changeStats(cid, CfreeOmilia1, CfreeSMS1, CxreosiOmilia1, CxreosiSMS1,0,0,Cavmon, s1, type);
										}
									}
										
								}
									
									
							}
							break;
						case 3:
							System.out.println("Write the contract's name holder: ");
							s.nextLine();
							cname = s.nextLine();
							System.out.println("Write the contract's surname holder: ");
							csurname=s.nextLine();
							cid = stat.checkName(cname,csurname,symvolaia );
							if (cid!=-1){
								System.out.println("Change your contract's stats");
								System.out.println("Free MB: ");
								CfreeMB=s.nextInt();
								System.out.println("Charge for MB after the free MB: ");
								CxreosiMB=s.nextInt();
								type = 3;
								for (Services s1: yphresies){
									if ( s1.getOnoma().equals("Mobile Internet")){
										if (s1.getId() == cid){
											stat.changeStats(cid,0, 0, 0, 0,CfreeMB, CxreosiMB,0, s1, type);
										}
									}
										
								}
									
									
							}
							break;
							
							
							

					}
					break;
				case 5:
					System.out.println("Calculate total monthly cost and monthly available remaining money" );
					System.out.println("Choose type of contract: 1. Contract program 2. Card contract program 3. Program mobile-Internet ");
					int m = s.nextInt();
					double es = 0;
					double totalcost = 0;
					double x1=0, x2=0;
					switch(m) {
						case 1:
							for (Services service: yphresies){
                                if(service instanceof symvolaio){
									id2= service.getId();
									es = stat.returnSale(id2,symvolaia);
									x1 = service.getXreosiSMS();
									x2 = service.getXreosiOmilia();
									totalcost = service.getPagio()+ x1*ConOmiliaCost + x2*ConSMSCost - (service.getPagio()+ x1*ConOmiliaCost + x2*ConSMSCost )*20/100 - es;
									System.out.println("Name and surname: " +stat.NameAndSurname(id2,symvolaia)+ "\nMonthly cost: "+ String.format("%.2f",totalcost));
									
									
								}
                            }
							break;
						case 2:
							for (Services service: yphresies){
								if(service instanceof kartosymvolaio){
									id2= service.getId();
									es = stat.returnSale(id2,symvolaia);
									x1 = service.getXreosiSMS();
									x2 = service.getXreosiOmilia();
									totalcost = service.getPagio()+ x1*CaOmiliaCost + x2*CaSMSCost - (service.getPagio()+ x1*CaOmiliaCost + x2*CaSMSCost )*25/100 - es;
									System.out.println("Name and surname: " +stat.NameAndSurname(id2,symvolaia)+ "\nMonthly cost: "+String.format("%.2f",totalcost));
										
										
								}
							}
							
							break;
						case 3:
							for (Services service: yphresies){
                                if(service instanceof mobInternet){
									id2= service.getId();
									es = stat.returnSale(id2,symvolaia);
									x1 = service.getXreosiMB();
									totalcost = service.getPagio()+ x1*MBCost - (service.getPagio()+ x1*MBCost )*30/100 - es;
									System.out.println("Name and surname: " +stat.NameAndSurname(id2,symvolaia)+ "\nMonthly cost: "+String.format("%.2f",totalcost));
									
									
								}
                            }
							break;

					}
					break;
				case 6:
					System.out.println("Calculate free talk time and free SMS or free MB or remaining money");
					System.out.println("Choose type of contract: 1. Contract program 2. Card contract program 3. Program mobile-Internet ");
					int f = s.nextInt();
					String fname, fsurname;
					int fid, spentOmilia = 0, spentSMS = 0,spentMB = 0;
					boolean flag;
					switch(f) {
						case 1:
							System.out.println("Write the contract's name holder: ");
                            s.nextLine();
							fname = s.nextLine();
							System.out.println("Write the contract's surname holder: ");
                            fsurname=s.nextLine();
							fid = stat.checkName(fname,fsurname,symvolaia );
							for (Services s2: yphresies){
								if ( fid==s2.getId() & s2.getOnoma().equals("Contract")){
									flag = true;
									while(flag){
										System.out.println("You had " + s2.getFreeOmilia() + " free minutes to talk, how much have you spent? ");
										spentOmilia=s.nextInt();
										if (spentOmilia <= s2.getFreeOmilia()) flag= false;
										else System.out.println("Invalid input, try again.");
									}
									flag = true;
									while(flag) {
										System.out.println("You had " + s2.getFreeSMS() + " free SMS, how much have you spent? ");
										spentSMS=s.nextInt();
										if (spentSMS <= s2.getFreeSMS()) flag= false;
										else System.out.println("Invalid input, try again.");
									}
									s2.setFreeOmilia(s2.getFreeOmilia()-spentOmilia);
									s2.setFreeSMS(s2.getFreeSMS()-spentSMS);
									System.out.println("You have " + s2.getFreeOmilia() + " free minutes to talk and " + s2.getFreeSMS() + " free SMS.");
									
									
								
								}
							}
							break;
						case 2:
							System.out.println("Write the contract's name holder: ");
                            s.nextLine();
							fname = s.nextLine();
							System.out.println("Write the contract's surname holder: ");
                            fsurname=s.nextLine();
							fid = stat.checkName(fname,fsurname,symvolaia );
							for (Services s2: yphresies){
								if ( fid==s2.getId() & s2.getOnoma().equals("Card")){
									flag = true;
									while(flag){
										System.out.println("You had " + s2.getFreeOmilia() + " free minutes to talk, how much have you spent? ");
										spentOmilia=s.nextInt();
										if (spentOmilia <= s2.getFreeOmilia()) flag= false;
										else System.out.println("Invalid input, try again.");
									}
									flag = true;
									while(flag) {
										System.out.println("You had " + s2.getFreeSMS() + " free SMS, how much have you spent? ");
										spentSMS=s.nextInt();
										if (spentSMS <= s2.getFreeSMS()) flag= false;
										else System.out.println("Invalid input, try again.");
									}
										System.out.println("You had " + s2.getMiniaioYpoloipo() + " remaining money!");
										double es2 = stat.returnSale(fid,symvolaia);
										double y1 = s2.getXreosiSMS();
										double y2 = s2.getXreosiOmilia();
										double tc =  y1*CaOmiliaCost + y2*CaSMSCost;
										double pay = 0;
										
										
							
									s2.setFreeOmilia(s2.getFreeOmilia()-spentOmilia);
									s2.setFreeSMS(s2.getFreeSMS()-spentSMS);
									System.out.println("You have " + s2.getFreeOmilia() + " free minutes to talk and " + s2.getFreeSMS() + " free SMS.");
									if (s2.getMiniaioYpoloipo()>0){
										System.out.println("You have to pay "+ tc + " euros for SMS and talk time.");
										if (s2.getMiniaioYpoloipo()>=tc){ 
											pay = s2.getMiniaioYpoloipo() - tc;
											System.out.println("Your new quantity of remaining money is " + String.format("%.2f",pay));}
										else if (s2.getMiniaioYpoloipo()<tc){
											pay = tc - s2.getMiniaioYpoloipo();
											System.out.println("You don't have any remaining money and you have to pay " + String.format("%.2f",pay) + " euros for SMS and talk time.");
										}
									}
									else System.out.println("You don't have any remaining money");
									
								
								}
							}
							break;
						
						case 3:
							System.out.println("Write the contract's name holder: ");
                            s.nextLine();
							fname = s.nextLine();
							System.out.println("Write the contract's surname holder: ");
                            fsurname=s.nextLine();
							fid = stat.checkName(fname,fsurname,symvolaia);
							for (Services s2: yphresies){
								if ( fid==s2.getId() & s2.getOnoma().equals("Mobile Internet")){
									flag = true;
									while(flag){
										System.out.println("You had " + s2.getFreeMB() + " free data, how much have you spent? ");
										spentMB=s.nextInt();
										if (spentMB <= s2.getFreeMB()) flag= false;
										else System.out.println("Invalid input, try again.");
									}
								
									s2.setFreeMB(s2.getFreeMB()-spentMB);
									System.out.println("You have " + s2.getFreeMB() + " free data.");
									
									
								
								}
							}
							break;
			
			
			
					}
					break;
					
					case 7:
						not = false;
					break;
			
			}




        }

    }

}
