package assignment1;

import java.util.Random;

/**
 * class Ants.
 */
public class Ants {

  /**
   * boolean method checks if the ant has walked trough whole chess board.
   */
  private static boolean chessBoard(int[][] board) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * main function.
   */
  public static void main(String[] args) {
    System.out.println("Ants");
    System.out.println("=====");
    System.out.println();
    Random rnd = new Random();
    double avrg = 0;

    for (int i = 1; i <= 10; i++) {
      int[][] board = new int[8][8];
      // set position to 0.
      for (int j = 0; j < 8; j++) {
        for (int n = 0; n < 8; n++) {
          board[j][n] = 0;
        }
      }
      int positionY = rnd.nextInt(8);
      int positionX = rnd.nextInt(8);
      // set start position to 1.
      
      board[positionY][positionX] = 1;

      int step = 0;

      // While loop makes the ant move until it pass all squares.
      while (!chessBoard(board)) {
        // set start position to 1.
        board[positionY][positionX] = 1;
        // generate dircetions Up, Down, Left and Right.
        int dircetions = rnd.nextInt(4) + 1;
        
        if (dircetions == 1) {
          if (positionX > 0) {
            step++;
            positionX--;
          }

        } else if (dircetions == 2) {
          if (positionX < 7) {
            step++;
            positionX++;
          }

        } else if (dircetions == 3) {
          if (positionY < 7) {
            step++;
            positionY++;
          }
        } else if (dircetions == 4) {
          if (positionY > 0) {
            step++;
            positionY--;
          }
        }
      }
      System.out.println("Number of steps in simulation " + i + ": " + step);
      avrg += step;
    }
    System.out.println("Average amount of steps: " + avrg / 10);
  }
}
