import java.util.*;

public class stats{
	
	

		
	
	
	public int checkName (String theName, String theSurname,ArrayList<contract> symvolaia  ) {
		boolean found = false;
		for (contract c: symvolaia){
			if (c.getName().equals(theName)& c.getSurname().equals(theSurname) ){
				found = true;
				int key = c.getId();
				return key;
				
			}
		}
		if (!found) System.out.println ("Name not found...");
		return -1;
	}
	
	
	public void changeStats(int id,int newfreeOmilia, int newfreeSMS, int newxreosiOmilia, int newxreosiSMS,int newFreeMB, int newXreosiMB,double newMiniaioYpoloipo, Services s, int type){
		if (type ==1 | type == 2) {
			s.setFreeOmilia(newfreeOmilia);
			s.setFreeSMS(newfreeSMS);
			s.setXreosiOmilia(newxreosiOmilia);
			s.setXreosiSMS(newxreosiSMS);
			if (type == 2) {
				s.setMiniaioYpoloipo(newMiniaioYpoloipo);
			}
			System.out.println("Stats have been changed...");
		}
		else if (type==3){
			s.setFreeMB(newFreeMB);
			s.setXreosiMB(newXreosiMB);
			System.out.println("Stats have been changed...");
		}
			
		
		
	}
	
	
	public void findContract(int id,ArrayList<contract> symvolaia ){
		boolean found = false;
		for(contract c: symvolaia){
			if (c.getId() == id){
				found = true;
				System.out.println(c);
				
			}
		}
		
	}
	
	public double returnSale(int id,ArrayList<contract> symvolaia ){
		boolean found = false;
		double s = 0;
		for(contract c: symvolaia){
			if (c.getId() == id){
				found = true;
				s = c.getSale();
			}
		}
		return s;
	}
	
	public String NameAndSurname(int id,ArrayList<contract> symvolaia ) {
		boolean found = false;
		String n="",s="";
		for(contract c: symvolaia){
			if (c.getId() == id){
				found = true;
				n = c.getName();
				s = c.getSurname();
			}
		}
		return n+" "+s;
	}
				
	
		
	//method for 2nd part
	public contract returnContract(int id,ArrayList<contract> symvolaia ){
		contract con=null;
		for(contract c: symvolaia){
			if (c.getId() == id)
				con =c;
		}
		return con;
	}
	
		
	
}
	