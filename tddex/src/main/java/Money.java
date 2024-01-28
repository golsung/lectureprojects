public class Money {
    private int value;
    public Money(int value) {
        this.value = value;
    }

    public Money add(Money money2) {
        return new Money(this.value + money2.getValue());
    }

    public int getValue() {
        return this.value;
    }
}
