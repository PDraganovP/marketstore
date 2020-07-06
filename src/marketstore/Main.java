package marketstore;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //You can use scanner if you prefer. In this case you have to input data from the console.

        /*Scanner scanner = new Scanner(System.in);
        String discountCardTypeLine = scanner.nextLine();
        String mockData = scanner.nextLine();*/

        //This is second variant. Only run the program.
        //Using sample bellow you can input data that you want.

        String discountCardTypeLine = "Bronze:";
        String mockData = "Mock data: turnover $0, purchase value $150;";

        int startIndexOfDiscountCardType = 0;
        int endIndexOfDiscountCardType = discountCardTypeLine.indexOf(":");
        String discountCardType = discountCardTypeLine
                .substring(startIndexOfDiscountCardType, endIndexOfDiscountCardType);

        String turnoverSearchWord = "turnover $";
        int startIndexOfTurnover = mockData.indexOf(turnoverSearchWord);
        int endIndexOfTurnover = mockData.indexOf(",");
        String turnoverValueString = mockData.substring(startIndexOfTurnover +
                "turnover $".length(), endIndexOfTurnover);
        double turnoverValue = Double.parseDouble(turnoverValueString);

        String purchaseSearchWord = "purchase value $";
        int startIndexOfPurchase = mockData.indexOf(purchaseSearchWord);
        int endIndexOfPurchase = mockData.indexOf(";");
        String purchaseValueString = mockData.substring(startIndexOfPurchase +
                purchaseSearchWord.length(), endIndexOfPurchase);
        double purchaseValue = Double.parseDouble(purchaseValueString);

        DiscountCard discountCard = new DiscountCard();
        discountCard.setTurnoverForPreviousMonth(turnoverValue);
        CardType type = CardType.valueOf(discountCardType.toUpperCase());
        discountCard.setCardType(type);

        CardType cardType = discountCard.getCardType();
        double turnoverForPreviousMonth = discountCard.getTurnoverForPreviousMonth();

        PurchaseCalculator purchaseCalculator = new PurchaseCalculator();
        double discountRate = purchaseCalculator.calculateDiscountRate(turnoverForPreviousMonth, cardType);
        double discount = purchaseCalculator.calculateDiscount(purchaseValue, discountRate);
        double totalPurchaseValue = purchaseCalculator.calculateTotalPurchaseValue(purchaseValue, discount);

        purchaseCalculator.printPurchaseInformation(purchaseValue, discountRate, discount, totalPurchaseValue);
    }
}
