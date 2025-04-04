package assignment2.theanimalkingdom;

/**
 * mammal class.
 */
public class Mammal extends Animal {
  private String furColor;
  private boolean hasWinterFur;
  
  /**
   *constructor.
   */
  public Mammal(String name, String latinName, double weight, String sound, String furColor, boolean hasWinterFur) {
    super(name, latinName, weight, sound);
    this.furColor = furColor;
    this.hasWinterFur = hasWinterFur;
  }

  /**
   * return the sound.
   */
  public String makeSound() {
    return this.sound;
  }

  /**
   * the furColor to get.
   */
  public String getFurColor() {
    return furColor;
  }

  /**
   * the furColor to set.
   */
  public void setFurColor(String furColor) {
    this.furColor = furColor;
  }

  /**
   * the hasWinterFur to get.
   */
  public boolean isHasWinterFur() {
    return hasWinterFur;
  }

  /**
   * the hasWinterFur to set.
   */
  public void setHasWinterFur(boolean hasWinterFur) {
    this.hasWinterFur = hasWinterFur;
  }


}
