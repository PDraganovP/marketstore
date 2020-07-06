package marketstore;

public enum CardType {
    BRONZE("Bronze"),
    SILVER("Silver"),
    GOLD("Gold");

    private String type;

    CardType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
