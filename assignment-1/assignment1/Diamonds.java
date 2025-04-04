package assignment1;

import java.util.Scanner;

/**
 * hello.
 */

public class Diamonds {
  /**
   * run code.
   */
  public static void main(String[] args) {
    System.out.print("Give a positive number: ");
    Scanner amount = new Scanner(System.in, "utf-8");
    int n = amount.nextInt();
    if (n > 0) {
      for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
          System.out.print(" ");
        }
        for (int j = 0; j < i; j++) {
          System.out.print("*");
        }
        for (int j = 1; j < i; j++) {
          System.out.print("*");
        }

        System.out.println();
      }
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j < i; j++) {
          System.out.print(" ");
        }
        for (int j = i; j < n; j++) {
          System.out.print("*");
        }
        for (int j = i; j <= n; j++) {
          System.out.print("*");
        }

        System.out.println();
      }
    } else {
      System.out.println("The number must be positive");
    }
    amount.close();

  }
}
