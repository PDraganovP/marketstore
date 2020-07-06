package marketstore;

public class DiscountCard {
    private String owner;
    private double turnoverForPreviousMonth;
    private double initialDiscountRate;
    private CardType cardType;

    public DiscountCard() {
    }

    public DiscountCard(double turnoverForPreviousMonth, CardType cardType) {
        this.turnoverForPreviousMonth = turnoverForPreviousMonth;
        this.cardType = cardType;
    }

    public double getTurnoverForPreviousMonth() {
        return turnoverForPreviousMonth;
    }

    public void setTurnoverForPreviousMonth(double turnoverForPreviousMonth) {
        this.turnoverForPreviousMonth = turnoverForPreviousMonth;
    }

    public double getInitialDiscountRate() {
        return initialDiscountRate;
    }

    public void setInitialDiscountRate(double initialDiscountRate) {
        this.initialDiscountRate = initialDiscountRate;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

}
