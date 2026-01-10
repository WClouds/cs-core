import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("List of operations: add subtract multiply divide alphabetize");
    System.out.println("Enter an operation:");
    String operation = input.nextLine().toLowerCase();
    switch (operation) {
      case "add": {
        System.out.println("Enter two integers:");
        if (!input.hasNextInt()) {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        int a = input.nextInt();
        if (!input.hasNextInt()) {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        int b = input.nextInt();
        System.out.println("Answer: " + (a + b));
        break;
      }
      case "subtract": {
        System.out.println("Enter two integers:");
        if (!input.hasNextInt()) {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        int a = input.nextInt();
        if (!input.hasNextInt()) {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        int b = input.nextInt();
        System.out.println("Answer: " + (a - b));
        break;
      }
      case "multiply": {
        System.out.println("Enter two doubles:");
        if (!input.hasNextDouble()) {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        double a = input.nextDouble();
        if (!input.hasNextDouble()) {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        double b = input.nextDouble();
        System.out.printf("Answer: %.2f\n", (a * b));
        break;
      }
      case "divide": {
        System.out.println("Enter two doubles:");
        if (!input.hasNextDouble()) {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        double a = input.nextDouble();
        if (!input.hasNextDouble()) {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        double b = input.nextDouble();
        if (b == 0) {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        System.out.printf("Answer: %.2f\n", (a / b));
        break;
      }
      case "alphabetize": {
        System.out.println("Enter two words:");
        String a = input.next();
        String b = input.next();
        if (a.toLowerCase().compareTo(b.toLowerCase()) == 0) {
          System.out.println("Answer: Chicken or Egg.");
        } else if (a.compareTo(b) < 0) {
          System.out.println("Answer: " + a + " comes before " + b + " alphabetically.");
        } else {
          System.out.println("Answer: " + b + " comes before " + a + " alphabetically.");
        }
        break;
      }
      default:
        System.out.println("Invalid input entered. Terminating...");
        break;
    }
  }

}
