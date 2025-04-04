package classes;

public class LiftMain {
  public static void main(String[] args) {
    Lift building = new Lift(1, 3, -1, "B-building");
    System.out.println(building.getcFloor());
    System.out.println(building.toFloor(2));
    System.out.println(building.getcFloor());
  }
}
