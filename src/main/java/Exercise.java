import java.util.Scanner;

public class Exercise {

    public static final String QUERY_PLAN = "Which billing plan are you using?";
    public static final String QUERY_MINUTES = "How many call-minutes do you plan to use each month?";
    public static final String QUERY_NEW_CUSTOMER = "Are you a new customer?";

    public static final String RESIDENTIAL = "Residential";
    public static final double RESIDENTIAL_BASE = 10.0;
    public static final double RESIDENTIAL_FREE = 120;
    public static final double RESIDENTIAL_MINUTE = 0.1;
    public static final double RESIDENTIAL_OFFER_LIMIT = 20.0;

    public static final String COMMERCIAL = "Commercial";
    public static final int COMMERCIAL_LIMIT = 300;
    public static final double COMMERCIAL_RATE = 0.15;
    public static final double COMMERCIAL_REDUCED = 0.07;

    public static final double LOYALTY_COST = 75.0;
    public static final double LOYALTY_LIMIT = 1000;

    public static void main(String[] args) {
        Exercise exercise = new Exercise();

        // query user input
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUERY_PLAN);
        String plan = scanner.nextLine();
        System.out.println(QUERY_MINUTES);
        int minutes = scanner.nextInt();
        scanner.nextLine();
        System.out.println(QUERY_NEW_CUSTOMER);
        String newCustomerInput = scanner.nextLine();

        calculateCost(plan, minutes, newCustomerInput);
    }

    static void calculateCost(String plan, int minutes, String newCustomerInput) {
        // new customer or old customer
        // new: residential, commercial
        if (isNewCustomer(newCustomerInput) && RESIDENTIAL.equalsIgnoreCase(plan)) {
            newCustomerOffer(2);
        } else if (isNewCustomer(newCustomerInput) && COMMERCIAL.equalsIgnoreCase(plan)) {
            newCustomerOffer(3);
        } else {
            System.out.println("Invalid plan!");
            return;
        }

        // old: loyalty, resident, commercial
        if (!isNewCustomer(newCustomerInput) && minutes > LOYALTY_LIMIT) {
            printCostEstimation(LOYALTY_COST);
        } else if (!isNewCustomer(newCustomerInput) && RESIDENTIAL.equalsIgnoreCase(plan)) {
            double cost = calculateResidentialCost(minutes);
            printCostEstimation(cost);
        } else if (!isNewCustomer(newCustomerInput) && COMMERCIAL.equalsIgnoreCase(plan)) {
            printCostEstimation(calculateCommercialCost(minutes));
        } else {
            System.out.println("Invalid plan!");
        }

    }

    static boolean isNewCustomer(String newCustomerInput) {
        return newCustomerInput.equalsIgnoreCase("y") || newCustomerInput.equalsIgnoreCase("yes");
    }

    static void newCustomerOffer(int months) {
        System.out.println("As a new customer you will have " + months + " months for free!");
    }

    static void printCostEstimation(double estimation) {
        System.out.printf("Your estimated cost is %.2f", estimation);
    }

    static double calculateResidentialCost(int minutes) {
        double cost = RESIDENTIAL_BASE;
        if (minutes > RESIDENTIAL_FREE) {
            cost += (minutes - 120) * RESIDENTIAL_MINUTE;
        }
        return cost;
    }

    static double calculateCommercialCost(int minutes) {
        double cost;
        if (minutes > COMMERCIAL_LIMIT) {
            cost = COMMERCIAL_LIMIT * COMMERCIAL_RATE + (minutes - COMMERCIAL_LIMIT) * COMMERCIAL_REDUCED;
        } else {
            cost = minutes * COMMERCIAL_RATE;
        }
        return cost;
    }
}
