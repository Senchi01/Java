package classes;

public class Car {
  private String make;
  private String model;
  private int distance;

  public Car(String thisMake, String thisModel, int thisDistance) {
    this.make = thisMake;
    this.model = thisModel;
    setDistance(distance);
  }

  /**
   * @return the make
   */
  public String getMake() {
    return make;
  }

  /**
   * @param make the make to set
   */
  public void setMake(String make) {
    this.make = make;
  }

  /**
   * @return the model
   */
  public String getModel() {
    return model;
  }

  /**
   * @param model the model to set
   */
  public void setModel(String model) {
    this.model = model;
  }

  /**
   * @return the distance
   */
  public int getDistance() {
    return distance;
  }

  /**
   * @param distance the distance to set
   */
  public void setDistance(int disTance) {
    if (disTance > 0 && distance < 1000000) {
      this.distance = disTance;
    } else {
      this.distance = 0;
    }
  }

}
