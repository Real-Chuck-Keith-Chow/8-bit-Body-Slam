package wrestling.simulator;



import java.io.Serializable;

class Contract implements Serializable {
    private Promotion promotion;
    private int payPerShow;
    private int durationWeeks;
    
    public Contract(Promotion promotion, int payPerShow, int durationWeeks) {
        this.promotion = promotion;
        this.payPerShow = payPerShow;
        this.durationWeeks = durationWeeks;
    }
    
    // Getters
    public Promotion getPromotion() { return promotion; }
    public int getPayPerShow() { return payPerShow; }
    public int getDurationWeeks() { return durationWeeks; }
}
