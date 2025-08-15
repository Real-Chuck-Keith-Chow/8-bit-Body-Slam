package wrestling.simulator;

public class Wrestler {
	private String name;
    private int health = 100;
    private int popularity = 0;
    private int money = 5000;
    private int week = 0;

    public Wrestler(String name) {
        this.name = name;
    }

    // Getters & Setters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getPopularity() { return popularity; }
    public int getMoney() { return money; }
    public int getWeek() {return week;}

	public void setMoney(int i) {
		 this.money = Math.max(0, money);
		// TODO Auto-generated method stub
		
	}

	public void setHealth(int i) {
		this.health = Math.min(100, Math.max(0, health));
		// TODO Auto-generated method stub
		
	}

	public void setPopularity(int i) {
		  this.popularity = Math.max(0, popularity); // Prevent negative popularity
		
		// TODO Auto-generated method stub
		
	}

	public void setWeek(int i) {
		
		 this.week = Math.max(0, week); // Prevent negative weeks
		// TODO Auto-generated method stub
		
	}
	private Contract contract;

	public void signContract(Contract newContract) {
	    this.contract = newContract;
	}

	public void processContractPayment() {
	    if (contract != null && !contract.isExpired()) {
	        contract.processPayment(this);
	    }
	}
	
	

}
