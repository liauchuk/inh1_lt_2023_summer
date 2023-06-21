import org.junit.Assert;
import org.junit.Test;
import task.*;

import java.util.Scanner;

public class TestRunner {
    @Test
    void testEuroClass() {
        Euro euro = new Euro(100);
        Euro euro1 = new Euro(euro);
        Euro euro2 = new Euro(1, 0);
        Euro euro3 = new Euro(200);

        Assert.assertEquals(true, euro.equals(euro1));
        Assert.assertEquals(true, euro.equals(euro2));
        Assert.assertEquals(euro3, euro.add(euro1));
        Assert.assertEquals(euro2, euro.subtract(euro1));
        Assert.assertEquals(euro3, euro.multiply(2));
    }

    @Test
    void testRegularPurchase() {
        Purchase purchase = new Purchase("Apple", new Euro(100), 5);
        Purchase purchase1 = new Purchase("Apple", new Euro(100), 5);

        Assert.assertEquals(new Euro(500), purchase.getCost());
        Assert.assertEquals("Apple", purchase.getName());
        Assert.assertEquals(new Euro(100), purchase.getPrice());
        Assert.assertEquals(5, purchase.getQuantity());
        Assert.assertEquals(true, purchase.equals(purchase1));
    }

    @Test
    void testPercentDiscountPurchase() {
        PercentDiscountPurchase purchase = new PercentDiscountPurchase("Apple", new Euro(100), 5, 10.0, 4);
        PercentDiscountPurchase purchase1 = new PercentDiscountPurchase("Apple", new Euro(100), 5, 10.0, 4);

        Assert.assertEquals(new Euro(450), purchase.getCost());
        Assert.assertEquals("Apple", purchase.getName());
        Assert.assertEquals(new Euro(100), purchase.getPrice());
        Assert.assertEquals(5, purchase.getQuantity());
        Assert.assertEquals(10.0, purchase.getPercentDiscount(), 0.0001);
        Assert.assertEquals(4, purchase.getQuantityThreshold());
        Assert.assertEquals(true, purchase.equals(purchase1));
    }

    @Test
    void testPriceDiscountPurchase() {
        PriceDiscountPurchase purchase = new PriceDiscountPurchase("Apple", new Euro(100), 5, new Euro(10));
        PriceDiscountPurchase purchase1 = new PriceDiscountPurchase("Apple", new Euro(100), 5, new Euro(10));

        Assert.assertEquals(new Euro(450), purchase.getCost());
        Assert.assertEquals("Apple", purchase.getName());
        Assert.assertEquals(new Euro(100), purchase.getPrice());
        Assert.assertEquals(5, purchase.getQuantity());
        Assert.assertEquals(new Euro(10), purchase.getDiscount());
        Assert.assertEquals(true, purchase.equals(purchase1));
    }

    @Test
    void testPurchaseFactorySimplePurchase() {
        String purchaseInput = "PURCHASE Apple 100 5";
        Scanner scanner = new Scanner(purchaseInput);
        Purchase purchase = PurchaseFactory.getPurchaseFromFactory(scanner);

        Assert.assertEquals(new Euro(500), purchase.getCost());
        Assert.assertEquals("Apple", purchase.getName());
        Assert.assertEquals(new Euro(100), purchase.getPrice());
        Assert.assertEquals(5, purchase.getQuantity());
    }

    @Test
    void testPurchaseFactoryPercentDiscountPurchase() {
        String purchaseInput = "PERCENT_DISCOUNT_PURCHASE Apple 100 5 10.0 4";
        Scanner scanner = new Scanner(purchaseInput);
        Purchase purchaseResult = PurchaseFactory.getPurchaseFromFactory(scanner);

        Assert.assertTrue(purchaseResult instanceof PercentDiscountPurchase);

        PercentDiscountPurchase purchase = (PercentDiscountPurchase) purchaseResult;

        Assert.assertEquals(new Euro(450), purchase.getCost());
        Assert.assertEquals("Apple", purchase.getName());
        Assert.assertEquals(new Euro(100), purchase.getPrice());
        Assert.assertEquals(5, purchase.getQuantity());
        Assert.assertEquals(10.0, purchase.getPercentDiscount(), 0.0001);
        Assert.assertEquals(4, purchase.getQuantityThreshold());
    }

    @Test
    void testPurchaseFactoryPriceDiscountPurchase() {
        String purchaseInput = "PRICE_DISCOUNT_PURCHASE Apple 100 5 10";
        Scanner scanner = new Scanner(purchaseInput);
        Purchase purchaseResult = PurchaseFactory.getPurchaseFromFactory(scanner);

        Assert.assertTrue(purchaseResult instanceof PriceDiscountPurchase);

        PriceDiscountPurchase purchase = (PriceDiscountPurchase) purchaseResult;

        Assert.assertEquals(new Euro(450), purchase.getCost());
        Assert.assertEquals("Apple", purchase.getName());
        Assert.assertEquals(new Euro(100), purchase.getPrice());
        Assert.assertEquals(5, purchase.getQuantity());
        Assert.assertEquals(new Euro(10), purchase.getDiscount());
    }
}
