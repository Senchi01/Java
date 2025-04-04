package classes;

import java.util.Random;

public class LiftArray {
  public static void main(String[] args) {
    Lift[] lifts = new Lift[3];
    Random rnd = new Random();

    lifts[0] = new Lift(1, 10, -1, "B1");
    lifts[1] = new Lift(1, 10, -1, "B2");
    lifts[2] = new Lift(1, 10, -1, "B3");

    for (int i = 0; i < lifts.length; i++) {
      lifts[i].toFloor(rnd.nextInt(lifts[i].getMaxFloor() - lifts[i].getMinFloor()) + lifts[i].getMinFloor());
    }
    for (int j = 0; j < lifts.length; j++) {
      System.out.println(lifts[j].getName() + " " + lifts[j].getcFloor());
    }
  }

}
