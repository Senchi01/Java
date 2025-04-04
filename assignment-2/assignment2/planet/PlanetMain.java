package assignment2.planet;

/**
 * main class to implament planet class.
 */
public class PlanetMain {
  /**
   * main method.
   */
  public static void main(String[] args) {
    Planet earth = new Planet("Earth", 3, 1, 152097701, 147098074);
    int earthPosition = earth.getPosition();
    String earthName = earth.getName();
    int earthMoon = earth.getNoOfMoons();
    int earthAphelion = earth.getAphelion();
    int earthPerihelion = earth.getPerihelion();
    System.out.println(earthName + ": ");
    System.out.println("  Position: " + earthPosition);
    System.out.println("  Moons: " + earthMoon);
    System.out.println("  Aphelion: " + earthAphelion + " km");
    System.out.println("  Perihelion: " + earthPerihelion + " km");

    Planet mars = new Planet("Mars", 4, 2, 249209300, 20666900);
    int marsPosition = mars.getPosition();
    String marsName = mars.getName();
    int marsMoon = mars.getNoOfMoons();
    int marsAphelion = mars.getAphelion();
    int marsPerihelion = mars.getPerihelion();

    System.out.println();
    System.out.println(marsName + ":");
    System.out.println("  Position: " + marsPosition);
    System.out.println("  Moons: " + marsMoon);
    System.out.println("  Aphelion: " + marsAphelion + " km");
    System.out.println("  Perihelion: " + marsPerihelion + " km");
  }

}
