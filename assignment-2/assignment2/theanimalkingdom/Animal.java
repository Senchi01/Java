package assignment2.theanimalkingdom;

/**
 * abstract class.
 */
public abstract class Animal {
  private String name;
  private String latinName;
  private double weight;
  protected String sound;

  /**
   *constoctor.
   */
  public Animal(String name, String latinName, double weight, String sound) {
    this.name = name;
    this.latinName = latinName;
    this.sound = sound;
    this.weight = weight;
  }
  
  /**
   * abstract method.
   */
  public abstract String makeSound();

  /**
   * the name to get.
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

  /**
   * the latinName get.
   */
  public String getLatinName() {
    return latinName;
  }

  /**
   * the latinName to set.
   */
  public void setLatinName(String latinName) {
    this.latinName = latinName;
  }

  /**
   * the weight get.
   */
  public double getWeight() {
    return weight;
  }

  /**
   * the weight to set.
   */
  public void setWeight(double weight) {
    this.weight = weight;
  }

  /**
   * the sound get.
   */
  public String getSound() {
    return sound;
  }

  /**
   * the sound to set.
   */
  public void setSound(String sound) {
    this.sound = sound;
  }

  
}
