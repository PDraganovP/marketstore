package marketstore;

public class PurchaseCalculator {

    public double calculateDiscountRate(double turnoverForPreviousMonth, CardType cardType) {
        String cardTypeValue = cardType.getType();
        String cardTypeValueToUpperCase = cardTypeValue.toUpperCase();
        double discountRate = 0;

        switch (cardTypeValueToUpperCase) {
            case "BRONZE":
                if (turnoverForPreviousMonth >= 0 && turnoverForPreviousMonth < 100) {
                    discountRate = 0;
                } else if (turnoverForPreviousMonth >= 100 && turnoverForPreviousMonth <= 300) {
                    discountRate = 0.01;
                } else if (turnoverForPreviousMonth > 300) {
                    discountRate = 0.025;
                } else {
                    throw new IllegalArgumentException("Please enter positive turnover value");
                }
                break;
            case "SILVER":
                if (turnoverForPreviousMonth >= 0 && turnoverForPreviousMonth <= 300) {
                    discountRate = 0.02;
                } else if (turnoverForPreviousMonth > 300) {
                    discountRate = 0.035;
                } else {
                    throw new IllegalArgumentException("Please enter positive turnover value");
                }
                break;
            case "GOLD":
                double initialDiscountRate = 0.02;
                if (turnoverForPreviousMonth >= 0 && turnoverForPreviousMonth < 100) {
                    discountRate = initialDiscountRate;
                } else if (turnoverForPreviousMonth >= 100 && turnoverForPreviousMonth < 900) {
                    int discountForEachOneHundred = (int) (turnoverForPreviousMonth / 100);
                    discountRate = initialDiscountRate + (discountForEachOneHundred * 0.01);
                } else if (turnoverForPreviousMonth >= 900) {
                    discountRate = 0.1;
                } else {
                    throw new IllegalArgumentException("Please enter positive turnover value");
                }
                break;
            default:
                System.out.println("Please enter valid card type");
                break;
        }
        return discountRate;
    }

    public double calculateDiscount(double valueOfPurchase, double discountRate) {
        double discount = valueOfPurchase * discountRate;
        return discount;
    }

    public double calculateTotalPurchaseValue(double valueOfPurchase, double discount) {
        double totalPurchaseValue = valueOfPurchase - discount;

        return totalPurchaseValue;

    }

    public void printPurchaseInformation(double purchaseValue, double discountRate, double discount, double totalPurchaseValue) {
        System.out.printf("Purchase value: $%.2f%n" +
                        "Discount rate: %.1f%%%n" +
                        "Discount: $%.2f%n" +
                        "Total: $%.2f",
                purchaseValue, discountRate * 100, discount, totalPurchaseValue);
    }
}
