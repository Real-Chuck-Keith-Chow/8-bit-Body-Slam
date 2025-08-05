package wrestling.simulator;

import java.io.Serializable;

public class Contract implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Promotion promotion;
    private int monthlyPay;
    private int durationMonths;

    public Contract(Promotion promotion, int monthlyPay, int durationMonths) {
        this.promotion = promotion;
        this.monthlyPay = monthlyPay;
        this.durationMonths = durationMonths;
    }

    // Getters
    public Promotion getPromotion() { return promotion; }
    public int getMonthlyPay() { return monthlyPay; }
    public int getDurationMonths() { return durationMonths; }
}

