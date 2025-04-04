package assignment1;

import java.util.Scanner;

/**
 * start.
 */

public class Hex2Dec {

  /**
   * converting.
   * 
   */

  public static int hexToDecimal(String hex) {
    String letter = "0123456789ABCDEF";
    hex = hex.toUpperCase();
    int sum = 0;

    for (int i = 0; i < hex.length(); i++) {

      char c = hex.charAt(i);
      int p = letter.indexOf(c);
      sum = 16 * sum + p;

    }

    return sum;
  }

  /**
   * run code.
   * 
   */

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in, "utf-8");  
    System.out.print("Enter a hex number: ");
    String hex = input.nextLine();
    String hexa = hex;
    System.out.println("The decimal value for " + hexa + " is " + hexToDecimal(hexa));
    input.close();
  }
}
