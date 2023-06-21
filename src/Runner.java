import task.Purchase;
import task.PurchaseFactory;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Purchase[] purchases = new Purchase[6];

        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchaseFactory.getPurchaseFromFactory(sc);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }

        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }

        Purchase maxCostPurchase = purchases[0];
        for (int i = 1; i < purchases.length; i++) {
            if (purchases[i].getCost().compareTo(maxCostPurchase.getCost()) > 0) {
                maxCostPurchase = purchases[i];
            }
        }
        System.out.println("Purchase with maximum cost: " + maxCostPurchase);

        boolean allPurchasesEqual = true;
        for (int i = 1; i < purchases.length; i++) {
            if (!purchases[i].equals(purchases[0])) {
                allPurchasesEqual = false;
                break;
            }
        }
        System.out.println("Are all purchases equal? " + allPurchasesEqual);
    }
}