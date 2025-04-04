package assignment2.orderinanimalkingdom;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Main class.
 */
public class AnimalMain {
  /**
   * main method to run the program.
   */
  public static void main(String[] args) {
    ArrayList<Animal> list = new ArrayList<>();
    list.add(new Bird("Kiwi", "Apteryx mantelli", 100, "koko koko", true, true, "the tree."));
    list.add(new Bird("peafowl", "Pavo cristatus", 501, "koko koko", true, true, "the ground."));
    list.add(new Mammal("Cow", "Bos taurus", 200, "muuu!", "red and white.", true));
    list.add(new Mammal("Tiger", "Panthera tigris", 500, "Roar", "yellow and black.", true));
    list.add(new Reptile("Turtle", "Chelonia mydas", 300, "chirping", "the sea.", false));
    list.add(new Reptile("Corcodile", "Crocodilus niloticus", 300, "chirping", "fresh water.", true));

    Collections.sort(list);
    for (Animal a : list) {
      if (a.getClass() == Bird.class) {
        System.out.println(a.getLatinName() + " puts its egg in/on a whole " + ((Bird) a).getNestType());
      } else if (a.getClass() == Mammal.class) {
        System.out.println(a.getLatinName() + " has a fur that is " + ((Mammal) a).getFurColor());
      } else if (a.getClass() == Reptile.class) {
        System.out.println(a.getLatinName() + " lives in " + ((Reptile) a).getHabitat());
      }
    }
  }
}
