package boatclub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * registery class.
 */
public class Registery {
  private ArrayList<Member> members = new ArrayList<>();
  private ArrayList<Boat> boats;

  /**
   * read every thing in the data file and if it contains "MEMBER" add the
   * information into.
   * the list of members.
   */
  public void load() {
    String line = "";
    String name = "";
    String email = "";
    String id = "";
    Member tempMember = new Member();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("Data.data",
          StandardCharsets.UTF_8));

      while ((line = reader.readLine()) != null) {
        String[] splited = line.split(":");
        if (splited[0].equals("MEMBER")) {
          name = splited[1];
          email = splited[2];
          id = splited[3];
          tempMember = new Member(name, email, id, boats);
          members.add(tempMember);

        }
      }
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  // #region Members
  /**
   * register members and adds them to a list.
   */
  public void membersRegisterer(Member newMember) {
    String name = newMember.getName();
    String id = newMember.getUid();
    String email = newMember.getEmail();
    boats = newMember.getBoats();
    Member tempMem = new Member(name, email, id, boats);
    members.add(tempMem);

  }

  /**
   * check if member exists.
   * loops through every member in the list and if its id matches with user input
   * gets that user.
   */
  public Member showMember(String selectedMemberid) {
    for (int i = 0; i < members.size(); i++) {
      String memberid = members.get(i).getUid();
      if (memberid.equals(selectedMemberid.toLowerCase())) {
        return members.get(i);
      }

    }
    return null;
  }

  /**
   * chenck if the member exists and if so... remove it.
   * loops through every member in the list and if its id matches with user input
   * renmove that user.
   */
  public void deleteMember(String selectedMemberid) {
    for (int i = 0; i < members.size(); i++) {
      String memberid = members.get(i).getUid();
      if (memberid.equals(selectedMemberid)) {
        members.remove(i);
      }
    }
  }

  /**
   * Edit a member from the ArrayList.
   * loops through every member in the list and if its id matches with user input.
   * see what is will change and change it with the new data.
   */
  public void editMember(String selectedMemberid, String change, String newData) {
    for (int i = 0; i < members.size(); i++) {
      Member tempMember = members.get(i);
      String memberid = tempMember.getUid();
      if (memberid.equals(selectedMemberid)) {
        if (change.equals("name")) {
          tempMember.setName(newData);

        } else if (change.equals("email")) {
          tempMember.setEmail(newData);
        }
      }

    }
  }

  /**
   * Return the whole list of members.
   */
  public ArrayList<Member> showAllMembers() {
    ArrayList<Member> memberList = new ArrayList<>();
    memberList.addAll(members);
    return memberList;
  }
  // #endregion

  // #region Boats

  /**
   * Register a boat to a member and updates the data in the ArrayList.
   * loops through every member in the list and if its id matches with user input
   * get that member.
   * add the new boat that member's boatlist.
   */
  public void registerBoat(Boat newBoat, String selectedMemberid) {
    Ui ui = new Ui();
    for (int i = 0; i < members.size(); i++) {
      Member tempMember = members.get(i);
      String memberId = tempMember.getUid();
      if (memberId.equals(selectedMemberid.toLowerCase())) {

        try {
          boats = ui.loadBoat(memberId);
          newBoat = new Boat(newBoat.getName(), newBoat.getType(), newBoat.getLength(),
              newBoat.getDepth(), newBoat.getEnginPower());
          boats.add(newBoat);
        } catch (Exception e) {
          e.printStackTrace();

        }
      }
    }
  }

  /**
   * Delete a boat from selected member and updates the ArrayList.
   * loops through every member in the list and if its id matches with user input
   * get the list of -.
   * the boats created in run class.
   * if the name of the boat matches with user input remove it from the list.
   */
  public void deleteBoat(String selectedMemberid, String selectedBoatname) {
    Ui ui = new Ui();
    for (int i = 0; i < members.size(); i++) {
      Member tempMember = members.get(i);
      String memberId = tempMember.getUid();

      if (memberId.equals(selectedMemberid.toLowerCase())) {
        boats = ui.loadBoat(memberId);
        try {
          for (int j = 0; boats.size() > j; j++) {
            Boat tempBoat = boats.get(j);
            if (tempBoat.getName().equals(selectedBoatname)) {
              boats.remove(j);
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    }
  }
  // #endregion

}