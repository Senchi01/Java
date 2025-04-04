package assignment1;

import java.util.Scanner;

/**
 * hello.
 */

public class Time {

  /**
   * run Code.
   */

  public static void main(String[] args) {
    System.out.println("Give a number of seconds: ");
    Scanner timeScanner = new Scanner(System.in, "Utf-8");

    int time = timeScanner.nextInt();

    int hours = time / 3600;
    time = time % 3600;
    int minutes = time / 60;
    time = time % 60;
    int seconds = time;

    System.out.println("This corresponds to: " + hours + " hours " + minutes + " minutes " + seconds + " seconds ");
    timeScanner.close();
  }

}
