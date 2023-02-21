public class kartosymvolaio extends mobTelephony{

    private double miniaioYpoloipo,ekptwsi;

    public kartosymvolaio(String onoma, double pagio, int freeOmilia, int freeSMS, int xreosiOmilia, int xreosiSMS, double miniaioYpoloipo) {
        super(onoma, pagio, freeOmilia, freeSMS, xreosiOmilia, xreosiSMS);
        this.miniaioYpoloipo=miniaioYpoloipo;
        ekptwsi=0.25;
    }

    public double getMiniaioYpoloipo() {
        return miniaioYpoloipo;
    }
	
	public void setMiniaioYpoloipo(double newMiniaioYpoloipo) {
        miniaioYpoloipo = newMiniaioYpoloipo;
    }

    @Override
    public String toString() {
        return "\n-Card contract-"+
                "\nMonthly available remaining money: " + miniaioYpoloipo +
                super.toString();
    }
}
