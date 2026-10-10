package assinment;

public class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.prices = new double[capacity];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (price > 0 && itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    // Computed on request, avoiding out-of-sync stored totals
    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        
        System.out.println("Total: " + cart.getTotal());       // 500.0
        System.out.println("Item Count: " + cart.getItemCount()); // 3
    }
}
