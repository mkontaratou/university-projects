public class Services {
    private String onoma;
    private double pagio,miniaioYpoloipo;
	private int freeOmilia, freeSMS, xreosiOmilia, xreosiSMS, freeMB, xreosiMB;
	
	private int id;
    private static int id2 = 1;

    public Services(String onoma,double pagio){
        this.onoma=onoma;
        this.pagio=pagio;
		this.id = id2++; 
    }


    public String getOnoma() {
        return onoma;
    }

    public double getPagio() {
        return pagio;
    }
	
	
	public int getId() {
        return id;
    }

	public int getFreeOmilia() {
        return freeOmilia;
    }

    public int getFreeSMS() {
        return freeSMS;
    }

    public int getXreosiOmilia() {
        return xreosiOmilia;
    }

    public int getXreosiSMS() {
        return xreosiSMS;
    }
	
	public void setOnoma(String newOnoma ) {
		onoma = newOnoma;
	}
	
	
	public void setPagio(double newPagio ) {
		pagio = newPagio;
	}
	
	
	public void setFreeOmilia(int newFreeOmilia ) {
		freeOmilia = newFreeOmilia;
	}
	
	public void setFreeSMS(int newFreeSMS) {
		freeSMS = newFreeSMS;
	}
	
	public void setXreosiOmilia(int newXreosiOmilia) {
		xreosiOmilia = newXreosiOmilia;
	}
	
	public void setXreosiSMS(int newXreosiSMS) {
		xreosiSMS = newXreosiSMS;
	}
	
	public int getFreeMB() {
        return freeMB;
    }

    public int getXreosiMB() {
        return xreosiMB;
    }
	
	
	
	public void setFreeMB(int newFreeMB) {
		freeMB = newFreeMB;
	}
	
	public void setXreosiMB(int newXreosiMB) {
		xreosiMB = newXreosiMB;
	}
	
	
	 public double getMiniaioYpoloipo() {
        return miniaioYpoloipo;
    }
	
	public void setMiniaioYpoloipo(double newMiniaioYpoloipo) {
        miniaioYpoloipo = newMiniaioYpoloipo;
    }
	


    @Override
    public String toString() {
        return "\nName of service:" + onoma +
                "\nMonthly fixed cost: " + pagio;

    }
}
