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

  public static final double LOYALTY_COST= 75.0;
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

    // TODO write your code here
  }

}
