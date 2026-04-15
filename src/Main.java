import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==== SMARTPAY ====");
        System.out.println("Bill Calculation System");
        System.out.println("For Electricity & Water");
        System.out.println("=======================");
        System.out.println("Type Exit to stop the SmartPay");
        System.out.println();

        // keep asking user to enter the name
        while (true) {
            System.out.print("Customer name: ");
            String custName = sc.nextLine().trim();
            if (custName.equalsIgnoreCase("Exit")) {
                System.out.println("Thanks for using SmartPay");
                break;
            }
            // Blank name logic
            if (custName.isEmpty()) {
                System.out.println("Please enter the valid name");
                System.out.println();
                continue;
            }
            System.out.print("Previous Meter Reading: ");
            // Previous reading logic
            double prevMeter;
            try {
                prevMeter = Double.parseDouble(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("Please Enter a Valid Reading.");
                System.out.println();
                continue;

            }

            System.out.print("Current Meter Reading: ");

            // Current meter reading logic
            double currMeter;
            try {
                currMeter = Double.parseDouble(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println("Please Enter a Valid Reading.");
                System.out.println();
                continue;

            }
            // valid meter reading logic
            if (prevMeter < 0 || currMeter < 0) {
                System.out.println("Meter reading should not be less than zero.");
                System.out.println();
                continue;

            }

            // Previous reading should be less than or equal to Current reading
            if (prevMeter > currMeter) {
                System.out.println("Previous reading is greater than Current reading, please check the values.");
                System.out.println();
                continue;
            }

            Customer person = new Customer(custName, prevMeter, currMeter);
            BillCalculator myBill = new BillCalculator(person);
            myBill.printBill();

        }
        sc.close();
    }

}
