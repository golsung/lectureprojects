public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.setPriceManager(new RealPriceManager());
    }
}
