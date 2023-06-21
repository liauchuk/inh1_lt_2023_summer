package task;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase {
    private double percentDiscount;
    private int quantityThreshold;

    public PercentDiscountPurchase() {
        super();
        this.percentDiscount = 0.0;
        this.quantityThreshold = 0;
    }

    public PercentDiscountPurchase(String productName, Euro price, int quantity, double percentDiscount, int quantityThreshold) {
        super(productName, price, quantity);
        this.percentDiscount = percentDiscount;
        this.quantityThreshold = quantityThreshold;
    }

    public PercentDiscountPurchase(Scanner sc) {
        super(sc);
        this.percentDiscount = sc.nextDouble();
        this.quantityThreshold = sc.nextInt();
    }

    public double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public int getQuantityThreshold() {
        return quantityThreshold;
    }

    public void setQuantityThreshold(int quantityThreshold) {
        this.quantityThreshold = quantityThreshold;
    }

    @Override
    public Euro getCost() {
        Euro discountedPrice = new Euro(super.getPrice().getCents() - (int) (super.getPrice().getCents() * percentDiscount / 100.0));
        Euro cost;
        if (super.getQuantity() > quantityThreshold) {
            cost = new Euro(discountedPrice.getCents() * super.getQuantity());
        } else {
            cost = new Euro(super.getPrice().getCents() * super.getQuantity());
        }

        return cost;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + percentDiscount + ";" + quantityThreshold;
    }
}

