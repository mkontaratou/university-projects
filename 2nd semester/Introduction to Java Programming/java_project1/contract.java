public class contract {
    private int id;
    private static int id2 = 1;
    private String name,surname;
    private String phone;
    private String date;
    private String troposExoflisis;
    private double sale;
    Services yphres;

    public contract(String name, String surname, String phone, String date, String troposExoflisis, double sale,Services yphres) {
        this.id = id2++;
        this.name = name;
        this.surname=surname;
        this.phone = phone;
        this.date = date;
        this.troposExoflisis = troposExoflisis;
        this.sale = sale;
        this.yphres=yphres;

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getDate() {
        return date;
    }

    public String getTroposExoflisis() {
        return troposExoflisis;
    }

    public double getSale() {
        return sale;
    }
	
	public Services yphres(){
		return yphres;
	}
	
    @Override
    public String toString() {
        return "\n-Contract-" +
                "\nCode: " + id +
                "\nName: " + name +  
                "\nSurname: "+ surname +
				"\nPhone number: " + phone +
                "\nStarting date: " + date +
                "\nPayment method: " + troposExoflisis +
                "\nExtra sale: " + sale +
				"\nServices: " + yphres ;
    }
}
