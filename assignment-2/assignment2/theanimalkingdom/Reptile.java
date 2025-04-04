package assignment2.theanimalkingdom;

/**
 * reptile class.
 */
public class Reptile extends Animal {
  
  private String habitat;
  private boolean isPoisonous;
  
  /**
   * constructor.
   */
  public Reptile(String name, String latinName, double weight, String sound, String habitat, boolean ispoisonous) {
    super(name, latinName, weight, sound);
    this.habitat = habitat;
    this.isPoisonous = ispoisonous;
  
  }
  
  /**
   * return the sound.
   */
  public String makeSound() {
    return this.sound;
  }

  /**
   * the habitat to get.
   */
  public String getHabitat() {
    return habitat;
  }

  /**
   * the habitat to set.
   */
  public void setHabitat(String habitat) {
    this.habitat = habitat;
  }

  /**
   * the isPoisonous to check.
   */
  public boolean isPoisonous() {
    return isPoisonous;
  }

  /**
   * the isPoisonous to set.
   */
  public void setPoisonous(boolean isPoisonous) {
    this.isPoisonous = isPoisonous;
  }



}
