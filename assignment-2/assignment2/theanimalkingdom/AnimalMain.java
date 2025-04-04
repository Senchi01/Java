package assignment2.theanimalkingdom;

/**
 * main.
 */
public class AnimalMain {
  
  /**
   * run code.
   */
  public static void main(String[] args) {
    Bird pigeon = new Bird("pigeon", "Columbidae", 0.3, "ooo", false, true, "on tree");
    Mammal cow = new Mammal("cow", "Bos taurus", 720, "muuu!", "brown", true);
    Reptile crocodile = new Reptile("krokodile ", " Crocodylidae ", 100, " hooo ", " amphibian ", false);

    System.out.println("A " + cow.getName() + " with " + cow.getFurColor() + " says: " + cow.makeSound());

    System.out.println("A " + pigeon.getName() + " tweets: " + pigeon.makeSound());

    System.out.println("A " + crocodile.getName() + " hizzes: " + crocodile.makeSound());



  }

}
