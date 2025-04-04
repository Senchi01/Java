package assignment1;

import java.util.Random;
import java.util.Scanner;
/**
* hello!.
*/

public class Nine {
  private static final Random rnd = new Random();

  /**
   * run code.
   */
  public static void main(String[] args) {
    
    System.out.println("Playing a game");
    System.out.println("==============");
    System.out.println("\nReady to play? (y/n) ");

    Scanner yn = new Scanner(System.in, "utf-8");
    String answer1 = yn.nextLine();

    int random = rnd.nextInt(9) + 1;

    int total = 0;
    if (answer1.equals("n")) {
      System.exit(1);
    } else if (answer1.equals("y")) {
      System.out.println("you rolled a " + random);
      total += random;
    }

    int random2 = rnd.nextInt(9) + 1;
    System.out.println("Do you wanna play again? (y/n)");
    String answer2 = yn.nextLine();

    if (answer2.equals("y")) {
      total += random2;
      System.out.println("You rolled a " + random2 + " and in total you have " + total);
    } 
    int ctotal = 0;
    int crandom = rnd.nextInt(9) + 1;
    System.out.println("The computer rolled " + crandom);
    ctotal += crandom;
    if (ctotal <= 4) {
      int crandom2 = rnd.nextInt(9) + 1;
      ctotal += crandom2;

      System.out.println("The computer rolls and gets " + crandom2 + " in total " + ctotal);
    } else {
      System.out.println("The computer has in total " + ctotal);
    }
    if (total > 9 && ctotal > 9) {
      System.out.println("fat");

    } else if (total <= 9 && ctotal < total) {
      System.out.println("you win!!");

    } else if (total > 9 && ctotal <= 9) {
      System.out.println("The computer wins!!");

    } else if (ctotal > 9 && total <= 9) {
      System.out.println("You win!!");

    } else if (ctotal == total) {
      System.out.println("It is a tie!");
    } else {
      System.out.println("The computer wins!!");

    }

    yn.close();

  }
}
