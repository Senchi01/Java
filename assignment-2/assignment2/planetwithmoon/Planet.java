package assignment2.planetwithmoon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * planet class.
 */
public class Planet {
  private String name;
  private int position;
  private int noOfMoons;
  private int aphelion;
  private int perihelion;
  private ArrayList<Moon> moons = new ArrayList<>();

  /**
   * constractor.
   */
  public Planet(String name, int position, int noOfMoon, int aphelion, int perihelion) {
    setName(name);
    setPosition(position);
    this.noOfMoons = noOfMoon;
    setPerihelion(perihelion);
    setAphelion(aphelion);
  }

  /**
   * name getter.
   */
  public String getName() {
    return name;
  }

  /**
   * name setter.
   */
  public void setName(String name) {
    if (name.length() < 2) {
      this.name = "This name is invalid";
    } else {
      this.name = name;
    }
  }

  /**
   * aphelion getter.
   */
  public int getAphelion() {
    return aphelion;
  }

  /**
   * aphelion setter.
   */
  public void setAphelion(int aphelion) {
    if (aphelion > 0) {
      this.aphelion = aphelion;
    } else {
      this.aphelion = 0;
    }
  }

  /**
   * NoOfMoons getter.
   */
  public int getNoOfMoons() {
    return noOfMoons;
  }

  /**
   * noofmoon setter.
   */
  public void addMoon(Moon newMoon) {
    moons.add(newMoon);

  }

  /**
   * the moons to be returned.
   */
  public Moon[] getMoons() {
    Moon[] moonsArray = new Moon[moons.size()];
    moonsArray = moons.toArray(moonsArray);
    Moon[] moonsArrayCopy = Arrays.copyOf(moonsArray, moonsArray.length);
    return moonsArrayCopy;
  }

  /**
   * perihelion getter.
   */
  public int getPerihelion() {
    return perihelion;
  }

  /**
   * perihelion setter.
   */
  public void setPerihelion(int perihelion) {
    if (perihelion > 0) {
      this.perihelion = perihelion;
    } else {
      this.perihelion = 0;
    }
  }

  /**
   * position getter.
   */
  public int getPosition() {
    return position;
  }

  /**
   * position setter.
   */
  public void setPosition(int position) {
    if (position > 1) {
      this.position = position;
    }
  }

}
