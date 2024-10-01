package lecture3;

public class Lift {
  private int cFloor;
  private String name;
  private int minFloor;
  private int maxFloor;

  public Lift(int cFloor, int maxFloor, int minFloor, String name) {
    if (maxFloor > -5 && maxFloor < 200) {
      this.maxFloor = maxFloor;
    }
    if (minFloor >= -5 && minFloor <= 0) {
      this.minFloor = minFloor;
    }
    if (cFloor >= minFloor && cFloor <= maxFloor) {
      this.cFloor = cFloor;
    }
    this.name = name;
  }
  public boolean toFloor(int floor) {
    if (floor >= minFloor && floor <= maxFloor) {
      cFloor = floor;
      return true;
    }
    return false;
  }

  /**
   * @return the maxFloor
   */
  public int getMaxFloor() {
    return maxFloor;
  }

  /**
   * @param maxFloor the maxFloor to set
   */
  public void setMaxFloor(int maxFloor) {
    this.maxFloor = maxFloor;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the minFloor
   */
  public int getMinFloor() {
    return minFloor;
  }

  /**
   * @param minFloor the minFloor to set
   */
  public void setMinFloor(int minFloor) {
    this.minFloor = minFloor;
  }

  /**
   * @return the cFloor
   */
  public int getcFloor() {
    return cFloor;
  }

  /**
   * @param cFloor the cFloor to set
   */
  public void setcFloor(int cFloor) {
    this.cFloor = cFloor;
  }

}
