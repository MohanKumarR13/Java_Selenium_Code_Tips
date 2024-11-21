package parkingpaymentcalculator;

import java.util.Scanner;

public class ParkingPaymentCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the time parked in minutes: ");
        int parkedMinutes = scanner.nextInt();
        
        double payment = calculatePayment(parkedMinutes);
        
        System.out.printf("The parking payment is: $%.2f%n", payment);
        
        scanner.close();
    }

    public static double calculatePayment(int minutes) {
        if (minutes <= 15) {
            return 0.0; // 0-15 mins
        } else if (minutes <= 120) { // 15 mins to 2 hrs
            return 5.0;
        } else if (minutes <= 300) { // 2 to 5 hrs
            return 10.0;
        } else { // More than 5 hrs
            int extraHours = (minutes - 300) / 60; // Calculate full additional hours
            return 10.0 + extraHours; // Base fee + $1 for each additional hour
        }
    }
}
