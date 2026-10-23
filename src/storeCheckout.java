
import java.util.Scanner;

public class storeCheckout {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Task 7");

        System.out.print("Enter total amount of purchase: ");
        double amount = scanner.nextDouble();

        if (amount < 0) {
            System.out.println("Invalid amount. Purchase amount cannot be negative.");
        } else {
            System.out.print("Are you a premium member? (true/false): ");
            boolean isPremium = scanner.nextBoolean();

            System.out.print("Enter previous orders count: ");
            int orders = scanner.nextInt();

            if (orders < 0) {
                System.out.println("Invalid orders count.");
            } else {
                System.out.print("Do you have a coupon? (true/false): ");
                boolean hasCoupon = scanner.nextBoolean();

                System.out.print("Is it your birthday month? (true/false): ");
                boolean isBirthday = scanner.nextBoolean();

                int discount = 0;

                if (amount >= 200 && isPremium && (hasCoupon || isBirthday)) {
                    discount = 20;
                } else if (amount >= 150 && (isPremium || orders >= 10)) {
                    discount = 15;
                } else if (amount >= 100 && hasCoupon) {
                    discount = 10;
                }

                double discountAmount = (amount * discount) / 100.0;
                double finalPrice = amount - discountAmount;

                System.out.println("--- Summary ---");
                System.out.println("Discount: " + discount + "%");
                System.out.printf("Discount amount: $", discountAmount);
                System.out.printf("Final price: $", finalPrice);
            }
        }

        scanner.close();
    }
}