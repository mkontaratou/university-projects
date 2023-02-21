public class mobTelephony extends Services{

    private int freeOmilia, freeSMS;
    private int xreosiOmilia, xreosiSMS;

    public mobTelephony(String onoma, double pagio, int freeOmilia,int freeSMS, int xreosiOmilia, int xreosiSMS) {
        super(onoma, pagio);
        this.freeOmilia = freeOmilia;
        this.freeSMS = freeSMS;
        this.xreosiOmilia= xreosiOmilia;
        this.xreosiSMS= xreosiSMS;

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

    @Override
    public String toString() {
        return "\n-Mobile phone-" +
                "\nFree talk time to mobile and stable phones: "+ freeOmilia +
                "\nFree SMS: "+ freeSMS +
                "\nCharge after the free talk time: " + xreosiOmilia +
                "\nCharge after the free SMS: " + xreosiSMS +
                super.toString();
    }
}
