package assignment2.planetwithmoon;

/**
 * moon class.
 */
public class Moon {
  private String name;
  private int kmSize;

  /**
   * constoctor.
   */
  public Moon(String name, int kmSize) {
    this.name = name;
    this.kmSize = kmSize;
  }

  /**
   * the kmSize to return.
   */
  public int getInKmSize() {
    return kmSize;
  }

  /**
   * the kmSize to set.
   */
  public void setInKmSize(int kmSize) {
    this.kmSize = kmSize;
  }

  /**
   * the name to return.
   */
  public String getName() {
    return name;
  }

  /**
   * the name to set.
   */
  public void setName(String name) {
    this.name = name;
  }

}
