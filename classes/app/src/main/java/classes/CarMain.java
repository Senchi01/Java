package classes;

public class CarMain {
  public static void main(String[] args) {
    Car car = new Car("Volvo", "V60 Cross Country", 11000);
    System.out.println(car.getMake() + " " + car.getModel() + " has travled " + car.getDistance());
  }

}
