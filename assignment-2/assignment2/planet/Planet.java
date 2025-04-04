package assignment2.planet;

/**
 * Planet class.
 */
public class Planet {
  private String name;
  private int position;
  private int noOfMoons;
  private int aphelion;
  private int perihelion;

  /**
   * constractor.
   */
  public Planet(String name, int position, int noOfMoon, int aphelion, int perihelion) {
    setName(name);
    setPosition(position);
    setNoOfMoons(noOfMoon);
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
  public void setNoOfMoons(int count) {
    if (count < 0) {
      this.noOfMoons = 0;
    } else {
      this.noOfMoons = count;
    }
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
