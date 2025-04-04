package assignment1;

import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * hello!.
 */

public class DangerousWork {

  /**
   * run code.
   * 
   */

  public static void main(String[] args) {

    Scanner lon = new Scanner(System.in, "utf-8");
    System.out.print("How much would you like to earn? ");
    double salary = lon.nextDouble();
    double start = 0.01;
    double x = (Math.log10(salary / start)) / Math.log10(2);
    DecimalFormat dformat = new DecimalFormat("0");
    String days = dformat.format(x);

    System.out.print("You will have your money in " + days + " days");
    lon.close();
  }
}
