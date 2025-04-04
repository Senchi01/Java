package boatclub;

import java.util.ArrayList;

/**
 * member class.
 */
public class Member {
  private String name;
  private String email;
  private String uid;
  private ArrayList<Boat> boats = new ArrayList<>();

  public Member() {

  }

  /**
   * member consturctor.
   */
  public Member(String name, String email, String uid, ArrayList<Boat> boat) {
    this.name = name;
    this.uid = uid;
    this.email = email;
    this.boats = boat;
  }

  /**
   * return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * name to set.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * return the email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * email to set.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * return the uid.
   */
  public String getUid() {
    return uid;
  }

  /**
   * generates a 6 alphaNumeric id as a string.
   */
  public String setUid() {
    // chose a Character random from this String.
    String alphaNumericString = "0123456789abcdefghijklmnopqrstuvxyz";

    // create StringBuffer size of 6 characters.
    StringBuilder sb = new StringBuilder(6);

    for (int i = 0; i < 6; i++) {
      // generate a random number between.
      // 0 to AlphaNumericString variable length.
      int index = (int) (alphaNumericString.length() * Math.random());

      // add Character one by one in end of sb.
      sb.append(alphaNumericString.charAt(index));
    }
    return this.uid = sb.toString();

  }

  /**
   * does a copy of the arraylist and returns it.
   */
  public ArrayList<Boat> getBoats() {
    ArrayList<Boat> boatList = new ArrayList<>();
    boatList.addAll(boats);
    return boatList;
  }

}
