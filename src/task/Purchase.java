package task;

import java.util.Objects;
import java.util.Scanner;

public class Purchase {
    private String name;
    private Euro price;
    private int quantity;

    public Purchase() {
        this.name = "";
        this.price = new Euro();
        this.quantity = 0;
    }

    public Purchase(String productName, Euro price, int quantity) {
        this.name = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Purchase(Scanner sc) {
        this.name = sc.next();
        this.price = new Euro(sc.nextInt());
        this.quantity = sc.nextInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Euro getPrice() {
        return price;
    }

    public void setPrice(Euro price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Euro getCost() {
        return new Euro(price.getCents() * quantity);
    }

    protected String fieldsToString() {
        return getClass().getSimpleName() + ";" + name + ";" + price + ";" + quantity;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Purchase other = (Purchase) obj;
        return Objects.equals(name, other.name) &&
                Objects.equals(price, other.price);
    }
}
