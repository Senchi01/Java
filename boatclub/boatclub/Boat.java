package boatclub;

/**
 * boat class.
 */
public class Boat {
  private int length;
  private String name;
  private String type;
  private int depth;
  private int enginPower;

  /**
   * empty constuctor.
   */
  public Boat() {

  }

  /**
   * consturctor for Sailboat ana Motorboat.
   */
  public Boat(String name, String t, int length, int depthengine) {
    this.type = t;
    this.depth = depthengine;
    this.enginPower = depth;
    this.length = length;
    this.name = name;
  }

  /**
   * consturctor for Canoe.
   */
  public Boat(String name, String t, int length) {
    this.type = t;
    this.length = length;
    this.name = name;
  }

  /**
   * consturctor for Motorsailer.
   */
  public Boat(String name, String t, int length, int depth, int enginpower) {
    this.type = t;
    this.enginPower = enginpower;
    this.length = length;
    this.depth = depth;
    this.name = name;
  }

  /**
   * return the length.
   */
  public int getLength() {
    return length;
  }

  /**
   * the length to set.
   */
  public void setLength(int length) {
    this.length = length;
  }

  /**
   * return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * param name the name to set.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * return the depth.
   */
  public int getDepth() {
    return depth;
  }

  /**
   * depth to set.
   */
  public void setDepth(int depth) {
    this.depth = depth;
  }

  /**
   * return the enginPower.
   */
  public int getEnginPower() {
    return enginPower;
  }

  /**
   * param enginPower the enginPower to set.
   */
  public void setEnginPower(int enginPower) {
    this.enginPower = enginPower;
  }

  /**
   * return the boat typs and their properties.
   */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
