/* Ομάδα Χρηστών 55
* Συγγραφείς: ΜΑΡΙΑ ΚΟΝΤΑΡΑΤΟΥ(3200078) ΓΕΩΡΓΙΟΣ ΚΟΥΜΟΥΝΔΟΥΡΟΣ(3200083) ΠΑΝΑΓΙΩΤΗΣ ΚΩΝΣΤΑΝΤΙΝΑΚΟΣ(3200089) */

import java.util.ArrayList;
import java.util.Scanner;

public class mainApp {
    public static void main(String[] args){
		
		//arxikopoihsh timwn se Eurw gia ta statistika xrhshs(SMS, lepta omilias, MB) ana 1
		double ConSMSCost = 0.1;
		double ConOmiliaCost = 0.2;
		double CaSMSCost = 0.05;
		double CaOmiliaCost = 0.3;
		double MBCost = 0.2;
		
		
        // zhtoumeno c
		stats stat = new stats();
        ArrayList<Services> yphresies = new ArrayList<Services>();
        yphresies.add(new symvolaio("Contract",7,20,100,150,15));
		yphresies.add(new symvolaio("Contract",7,30,150,150,8));
        yphresies.add(new kartosymvolaio("Card",8, 600, 50,5,10,13));
        yphresies.add(new kartosymvolaio("Card",8, 450, 80,10,5,18));
        yphresies.add(new mobInternet("Mobile Internet", 10,300,6));
        yphresies.add(new mobInternet("Mobile Internet", 10,150,4));
		

        //ArrayList<contract> symvolaia = new ArrayList<contract>();
        contract c1 =new contract("Maria", "Kontaratou","690000000","26/02/21","cash",0.4, yphresies.get(0));
        stat.addContract(c1);
		contract c2 = new contract("Panagioths", "Kwnstantinakos","690000001","13/02/20","card",0.45,yphresies.get(1));
        stat.addContract(c2);
		contract c3 =new contract("Giwrgos", "Koumoundouros","690000002","30/06/20","cash",0.2, yphresies.get(2));
        stat.addContract(c3);
		contract c4 =new contract("Nikolas", "Papadopoulos","690000003","16/01/21","cash",0.15, yphresies.get(3));
        stat.addContract(c4);
		contract c5 =new contract("Aggelikh", "Merkourh","690000004","26/03/21","cash",0.15, yphresies.get(4));
        stat.addContract(c5);
		contract c6 =new contract("Kwnstantina", "Papaiwannou","690000005","23/08/20","cash",0.15, yphresies.get(5));
		stat.addContract(c6);
		
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
							stat.addContract(ob1);
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
							stat.addContract(ob2);
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
							stat.addContract(ob3);
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
									stat.findContract(id2);
								}
                            }
                            break;
                        case 2:
                            for (Services service: yphresies){
                                if(service instanceof kartosymvolaio)
                                    id2= service.getId();
									stat.findContract(id2);
                            }
                            break;
                        case 3:
                            for (Services service: yphresies){
                                if(service instanceof mobInternet)
                                    id2= service.getId();
									stat.findContract(id2);
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
							cid = stat.checkName(cname,csurname );
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
							cid = stat.checkName(cname,csurname );
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
							cid = stat.checkName(cname,csurname );
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
									es = stat.returnSale(id2);
									x1 = service.getXreosiSMS();
									x2 = service.getXreosiOmilia();
									totalcost = service.getPagio()+ x1*ConOmiliaCost + x2*ConSMSCost - (service.getPagio()+ x1*ConOmiliaCost + x2*ConSMSCost )*20/100 - es;
									System.out.println("Name and surname: " +stat.NameAndSurname(id2)+ "\nMonthly cost: "+ String.format("%.2f",totalcost));
									
									
								}
                            }
							break;
						case 2:
							for (Services service: yphresies){
								if(service instanceof kartosymvolaio){
									id2= service.getId();
									es = stat.returnSale(id2);
									x1 = service.getXreosiSMS();
									x2 = service.getXreosiOmilia();
									totalcost = service.getPagio()+ x1*CaOmiliaCost + x2*CaSMSCost - (service.getPagio()+ x1*CaOmiliaCost + x2*CaSMSCost )*25/100 - es;
									System.out.println("Name and surname: " +stat.NameAndSurname(id2)+ "\nMonthly cost: "+String.format("%.2f",totalcost));
										
										
								}
							}
							
							break;
						case 3:
							for (Services service: yphresies){
                                if(service instanceof mobInternet){
									id2= service.getId();
									es = stat.returnSale(id2);
									x1 = service.getXreosiMB();
									totalcost = service.getPagio()+ x1*MBCost - (service.getPagio()+ x1*MBCost )*30/100 - es;
									System.out.println("Name and surname: " +stat.NameAndSurname(id2)+ "\nMonthly cost: "+String.format("%.2f",totalcost));
									
									
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
							fid = stat.checkName(fname,fsurname );
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
							fid = stat.checkName(fname,fsurname );
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
										double es2 = stat.returnSale(fid);
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
							fid = stat.checkName(fname,fsurname );
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
