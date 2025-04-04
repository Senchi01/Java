package assignment1;

import java.util.Scanner;

/**
 * HELLO!.
 */

public class DayOfWeek {
  /**
   * run code. 
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in, "utf-8");
    System.out.print("Enter year: ");
    int year = scan.nextInt();

    System.out.print("Enter month(1-12): ");
    int m = scan.nextInt();
    System.out.print("day of the month (1-31): ");
    int q = scan.nextInt();
    int j = year / 100;
    if (m == 1) {
      m = 13;
      year -= 1;
    } else if (m == 2) {
      m = 14;
      year -= 1; 
    }
    int k = year % 100;
    int h = (q + (26 * (m + 1) / 10) + k + (k / 4) + (j / 4) + 5 * j) % 7;

    if (h == 0) {
      System.out.println("Day of week is: Saturday");
    } else if (h == 1) {
      System.out.println("Day of week is: Sunday");
    } else if (h == 2) {
      System.out.println("Day of week is: Monday");
    } else if (h == 3) {
      System.out.println("Day of week is: Tusday");
    } else if (h == 4) {
      System.out.println("Day of week is: Wednesday");
    } else if (h == 5) {
      System.out.println("Day of week is: Thursday");
    } else {
      System.out.println("Day of week is: Friday");
    }
    scan.close();
  }

}
