package task;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {
    private Euro discount;

    public PriceDiscountPurchase() {
        super();
        this.discount = new Euro();
    }

    public PriceDiscountPurchase(String productName, Euro price, int quantity, Euro discount) {
        super(productName, price, quantity);
        this.discount = discount;
    }

    public PriceDiscountPurchase(Scanner sc) {
        super(sc);
        this.discount = new Euro(sc.nextInt());
    }

    public Euro getDiscount() {
        return discount;
    }

    public void setDiscount(Euro discount) {
        this.discount = discount;
    }

    @Override
    public Euro getCost() {
        Euro discountedPrice = new Euro(super.getPrice().getCents() - discount.getCents());
        return new Euro(discountedPrice.getCents() * super.getQuantity());
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}
