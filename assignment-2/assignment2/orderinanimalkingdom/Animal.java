package assignment2.orderinanimalkingdom;

/**
 * abstract class.
 */
public abstract class Animal implements Comparable<Animal> {
  private String name;
  private String latinName;
  private double weight;
  protected String sound;

  /**
   * constoctor.
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
  public String makeSound() {
    return latinName;

  }

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
    return (int) weight;
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

  /**
   * method from comparable interface.
   */
  @Override
  public int compareTo(Animal animal) {
    int sort = this.latinName.compareTo(animal.latinName);
    if (sort == 0) {
      return this.name.compareTo(animal.name);
    } else {
       return sort;
    }    
  }

  
}
