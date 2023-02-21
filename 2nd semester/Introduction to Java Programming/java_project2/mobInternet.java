public class mobInternet extends Services{

    private int freeMB, xreosiMB;
    private double ekptwsi;


    public mobInternet(String onoma, double pagio, int freeMB, int xreosiMB) {
        super(onoma, pagio);
        this.freeMB=freeMB;
        this.xreosiMB=xreosiMB;
        ekptwsi=0.3;
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
	
	@Override
    public String toString() {
        return "\n-Mobile Internet-" +
                "\nFree data: " + freeMB +
                "\nCharge after the free data: " + xreosiMB +
                super.toString();
    }
}
