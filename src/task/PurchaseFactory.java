package task;

import java.util.Scanner;

public class PurchaseFactory {
    private enum PurchaseKind {
        PURCHASE {
            Purchase getPurchase(Scanner sc) {
                return new Purchase(sc);
            }
        },
        PRICE_DISCOUNT_PURCHASE {
            PriceDiscountPurchase getPurchase(Scanner sc) {
                return new PriceDiscountPurchase(sc);
            }
        },
        PERCENT_DISCOUNT_PURCHASE {
            PercentDiscountPurchase getPurchase(Scanner sc) {
                return new PercentDiscountPurchase(sc);
            }
        };

        abstract Purchase getPurchase(Scanner sc);
    }

    public static Purchase getPurchaseFromFactory(Scanner sc) {
        String id = sc.next();
        return PurchaseKind.valueOf(id).getPurchase(sc);
    }
}