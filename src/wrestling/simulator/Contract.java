package wrestling.simulator;

import java.io.Serializable;

public class Contract implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final Promotion promotion;
    private final int monthlyPay;
    private final int durationMonths;
    private int monthsRemaining;

    public Contract(Promotion promotion, int monthlyPay, int durationMonths) {
        if (promotion == null) {
            throw new IllegalArgumentException("Promotion cannot be null");
        }
        
        this.promotion = promotion;
        this.monthlyPay = Math.max(500, monthlyPay); // Minimum $500
        this.durationMonths = Math.max(1, durationMonths); // Minimum 1 month
        this.monthsRemaining = durationMonths;
    }

    /**
     * Processes payment to wrestler and advances contract timer
     * @return Amount paid
     */
    public int processPayment(Wrestler wrestler) {
        if (isExpired()) return 0;
        
        wrestler.setMoney(wrestler.getMoney() + monthlyPay);
        monthsRemaining--;
        return monthlyPay;
    }

    // Getters
    public Promotion getPromotion() { return promotion; }
    public int getMonthlyPay() { return monthlyPay; }
    public int getDurationMonths() { return durationMonths; }
    public int getMonthsRemaining() { return monthsRemaining; }
    public boolean isExpired() { return monthsRemaining <= 0; }

    @Override
    public String toString() {
        return String.format(
            "%s: $%d/month (%d/%d months)", 
            promotion.getName(), 
            monthlyPay,
            monthsRemaining,
            durationMonths
        );
    }
}
