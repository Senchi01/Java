package assignment1;

import java.util.Random;
import java.util.Scanner;
/**
 * hello.
 */

public class GameRps {
  private static final Random rnd = new Random();
  /**
   * Run Code.
   */

  public static void main(String[] args) {

    int pscore = 0;
    int cscore = 0;
    int dscore = 0;

    Scanner choiseScanner = new Scanner(System.in, "utf-8");
    
    while (true) {

      int[] alt = { 1, 2, 3 };
      System.out.print("Scissor (1), rock (2), paper (3) or 0 to quit: ");

      int choise = choiseScanner.nextInt();
      int crnd = alt[rnd.nextInt(alt.length)];

      if (choise == 1 && crnd == 2) {
        System.out.println("You lost, computer had rock!");
        cscore += 1;
      } else if (choise == 1 && crnd == 3) {
        System.out.println("You won, computer had paper!");
        pscore += 1;
      } else if (choise == 1 && crnd == 1) {
        System.out.println("It's a draw!");
        dscore += 1;
      } else if (choise == 2 && crnd == 1) {
        System.out.println("You won, computer had scissor!");
        pscore += 1;
      } else if (choise == 2 && crnd == 3) {
        System.out.println("You lost, computer had paper!");
        cscore += 1;
      } else if (choise == 2 && crnd == 2) {
        System.out.println("It's a draw!");
        dscore += 1;
      } else if (choise == 3 && crnd == 1) {
        System.out.println("You lost, computer had paper!");
        cscore += 1;
      } else if (choise == 3 && crnd == 2) {
        System.out.println("You won, computer had rock!");
        pscore += 1;
      } else if (choise == 3 && crnd == 3) {
        System.out.println("It's a draw!");
        dscore += 1;
      } else if (choise == 0) {
        System.out.println("Score: " + pscore + " (you) " + cscore + " (computer) " + dscore + " (draw).");
        break;
      }
    }
    choiseScanner.close();

  }
}
