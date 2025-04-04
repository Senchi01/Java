package assignment2.planetwithmoon;

/**
 * planet with moons class.
 */
public class PlanetMoonMain {
  /**
   * main class.
   */
  public static void main(String[] args) {
    Planet mars = new Planet("Mars", 4, 2, 249209300, 20666900);
    System.out.println("The planet is called " + mars.getName() + " and has the following moons:");
    Moon[] marsMoons = new Moon[mars.getNoOfMoons()];
    marsMoons[0] = new Moon("Phobos", 22);
    marsMoons[1] = new Moon("Deimos", 12);
    mars.addMoon(marsMoons[0]);
    mars.addMoon(marsMoons[1]);
      
    for (int i = 0; i < marsMoons.length; i++) {
      System.out.println("Moon " + (i + 1) + " is called " + mars.getMoons()[i].getName()
          + " (" + mars.getMoons()[i].getInKmSize() + "km)");
    }
    System.out.println();
    //#region(earth)
    Planet earth = new Planet("Earth", 3, 1, 152097701, 147098074);
    System.out.println("The planet is called " + earth.getName() + " and has the following moons:");
    Moon[] earthMoons = new Moon[earth.getNoOfMoons()];
    earthMoons[0] = new Moon("the moon", 3474);
    earth.addMoon(earthMoons[0]);
    for (int i = 0; i < earthMoons.length; i++) {
      System.out.println("Moon " + (i + 1) + " is called " + earth.getMoons()[i].getName()
          + " (" + earth.getMoons()[i].getInKmSize() + "km)");
    }
    //#endregion
  }
}
