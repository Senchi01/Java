package assignment2.theanimalkingdom;

/**
 * bird class.
 */
public class Bird extends Animal {

  private boolean isMigrant;
  private boolean canFly;
  private String nestType;

  /**
   * constructor.
   */
  public Bird(String name, String latinName, double weight, String sound, boolean isMigrant, boolean canFly, 
      String nestType) {
    super(name, latinName, weight, sound);
    this.isMigrant = isMigrant;
    this.canFly = canFly;
    this.nestType = nestType;
  }

  

  /**
   * the isMigrant to check.
   */
  public boolean isMigrant() {
    return isMigrant;
  }


  /**
   * the isMigrant to set.
   */
  public void setMigrant(boolean isMigrant) {
    this.isMigrant = isMigrant;
  }


  /**
   * the canFly to check.
   */
  public boolean isCanFly() {
    return canFly;
  }


  /**
   * the canFly to set. 
   */
  public void setCanFly(boolean canFly) {
    this.canFly = canFly;
  }


  /**
   * the nestType to get.
   */
  public String getNestType() {
    return nestType;
  }


  /**
   * the nestType to set.
   */
  public void setNestType(String nestType) {
    this.nestType = nestType;
  }

  /**
   * return the sound.
   */
  public String makeSound() {
    return this.sound;
  }

}
