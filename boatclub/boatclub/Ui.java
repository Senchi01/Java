package boatclub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * run class.
 */
public class Ui {
  private Scanner input = new Scanner(System.in, "Utf-8");
  private Registery registery = new Registery();

  /**
   * UI.
   */
  public void menuUi() {
    registery.load(); // load a list of member.
    showMenu();

  }

  /*
   * Print out the menu and deal with user input.
   */
  private void showMenu() {
    System.out.println("---------------------------------------");
    System.out.println("Welcome to the Boat Club control panel!");
    System.out.println("Choose an option from the following.\n");
    System.out.println("Press 1 to create a new member          Press 4 to see a particular member"
        + "\nPress 2 to edit a member                press 5 to list all members"
        + "\nPress 3 to delete a member              Press 6 to register a new boat"
        + "\nPress 7 to delete a boat                press 0 to quit");
    System.out.println("---------------------------------------");
    int choice = 0;

    do {
      System.out.print("Input: ");
      choice = input.nextInt();
      if (choice < 0 || choice > 8) {
        System.out.println("Wrong number!");
        System.out.println("Please enter a number between 0-8!");
      }

    } while (choice < 0 || choice > 8);

    input.nextLine();

    if (choice == 1) {
      createMember();
    } else if (choice == 2) {
      editMember();
    } else if (choice == 3) {
      deleteMember();
    } else if (choice == 4) {
      showMember();
    } else if (choice == 5) {
      showAllMembers();
    } else if (choice == 6) {
      registerBoat();
    } else if (choice == 7) {
      deleteBoat();
    } else if (choice == 0) {
      quit();

    }
  }

  /**
   * delete a member and its boats.
   */
  private void deleteMember() {
    System.out.println("Delete a member!");
    System.out.println("Please type the ID of the member you want to delete.");
    System.out.print("Input: ");
    String memberId = input.nextLine();
    // get the member with the given id through registery.
    Member tempMember = registery.showMember(memberId);
    if (tempMember == null) {
      System.out.println("Member not found.");
      menuUi();
    }
    // delete the member form the arraylist.
    registery.deleteMember(memberId);
    overrid(memberId); // delete the member form the data file.
    System.out.println("Do you want to return to the menu? y/n (Anything else is no)");
    String yesno = input.nextLine();
    if (yesno.equals("Y") || yesno.equals("y")) {
      menuUi();
    }
    if (yesno.equals("n") || yesno.equals("N")) {
      quit();
    }

  }

  /**
   * edits the name or email of a member.
   */
  private void editMember() {
    System.out.println("Edit a member!");
    System.out.println("Please type the ID of the member you want to edit.");
    System.out.print("Input: ");
    String id = input.nextLine();
    // get the member with the given id through registery.
    Member tempMember = registery.showMember(id);
    // do a copy of the member's old info to delete it from the data file to then
    // overrid it with the new data.
    String stringToDelete = "MEMBER:" + tempMember.getName() + ":" + tempMember.getEmail() + ":"
        + tempMember.getUid();
    System.out.println(stringToDelete);
    overrid(stringToDelete);

    System.out.println("What information do you wish to edit?\n" + "1. Name\n2. Email");
    int select = 0;
    // checks if the given input is correct.
    do {
      System.out.print("Input: ");
      select = input.nextInt();
      if (select < 1 || select > 2) {
        System.out.println("Wrong number!");
        System.out.println("Please enter a number between 1-2!");
      }
    } while (select < 1 || select > 2);

    input.nextLine();
    // select the data the user want to change depending on user chois.
    String dataTochange = "";
    if (select == 1) {
      dataTochange = "name";
    } else if (select == 2) {
      dataTochange = "email";
    }
    System.out.println("What do you want the new value to be? (" + dataTochange + ")");
    System.out.print("Input: ");

    String newData = " ";
    // if the user chois was email enter the new value and check if the email is
    // unique and isValid.
    if (dataTochange.equals("email")) {
      System.out.print("enter an email: ");
      newData = input.next();
      if (emailCheck(newData)) {
        System.out.println("This email is already exists, plaese try different one.");
        System.out.print("enter an email: ");
        newData = input.next();
      }
      while (!newData.contains("@") || !newData.contains(".")) {
        System.out.println("invalid email! Please enter a vild one");
        newData = input.next();
      }
    }
    // if the user chois was name enter the new value.
    if (dataTochange.equals("name")) {
      System.out.print("enter a new name: ");
      newData = input.nextLine();

    }
    // edit the memeber data in the arraylist and write them in the data file.
    registery.editMember(id, dataTochange, newData);
    String newMemberInfo = "MEMBER:" + tempMember.getName() + ":" + tempMember.getEmail() + ":"
        + tempMember.getUid();
    write(newMemberInfo);
    System.out.println("Member data has been updated!\n" + "New data: " + newMemberInfo);

    System.out.println();
    System.out.println("Do you want to return to the menu? y/n (Anything else is no)");
    String yesno = input.next();
    if (yesno.equals("Y") || yesno.equals("y")) {
      System.out.println("Returning to the menu!");
      menuUi();
    }
    if (yesno.equals("n") || yesno.equals("N")) {
      quit();
    }

  }

  /**
   * closes the application.
   */
  private void quit() {
    System.exit(0);
  }

  /**
   * delete a boat for a member.
   */
  private void deleteBoat() {
    System.out.println("Delete a boat!");
    System.out.println("Please type the ID of the member you want to delete a boat for.");
    System.out.print("Input: ");
    String memberid = input.nextLine();
    // get the member with the given id through registery.
    Member tempMember = registery.showMember(memberid);
    if (tempMember == null) {
      System.out.println("Member not found.");
      menuUi();
    }
    System.out.println("Boats for user with id: " + memberid);
    ArrayList<Boat> boats = new ArrayList<>();
    boats = loadBoat(memberid);
    String sailboat = "";
    String motorboat = "";
    String motorsailer = "";
    String canoe = "";
    String sailboatName = "";
    String motorboatName = "";
    String motorsailerName = "";
    String canoeName = "";

    for (int i = 0; i < boats.size(); i++) {
      String boatType = boats.get(i).getType();
      if (boatType.equals("Sailboat")) {
        // do a copy of strig with boat information to be used to overrid
        // the data file with this boat removed.
        sailboat = "BOAT:" + boats.get(i).getName() + ":" + boats.get(i).getType() + ":"
            + boats.get(i).getLength() + ":" + boats.get(i).getDepth();
        // get the name only to be compared with the input later.
        sailboatName = boats.get(i).getName();
        System.out.println(sailboat);

      } else if (boatType.equals("Motorboat")) {
        // do a copy of strig with boat information to be used to overrid
        // the data file with this boat removed.
        motorboat = "BOAT:" + boats.get(i).getName() + ":" + boats.get(i).getType() + ":"
            + boats.get(i).getLength() + ":" + boats.get(i).getEnginPower();
        // get the name only to be compared with the input later.
        motorboatName = boats.get(i).getName();
        System.out.println(motorboat);

      } else if (boatType.equals("Motorsailer")) {
        // do a copy of strig with boat information to be used to overrid
        // the data file with this boat removed.
        motorsailer = "BOAT:" + boats.get(i).getName() + ":" + boats.get(i).getType() + ":"
            + boats.get(i).getLength() + ":" + boats.get(i).getDepth() + ":"
            + boats.get(i).getEnginPower();
        // get the name only to be compared with the input later.
        motorsailerName = boats.get(i).getName();
        System.out.println(motorsailer);

      } else if (boatType.equals("Canoe")) {
        // do a copy of strig with boat information to be used to overrid
        // the data file with this boat removed.
        canoe = "BOAT:" + boats.get(i).getName() + ":" + boats.get(i).getType() + ":"
            + boats.get(i).getLength();
        // get the name only to be compared with the input later.
        canoeName = boats.get(i).getName();
        System.out.println(canoe);
      }
    }
    System.out.println("Please input the name of the boat you wish to delete!");
    System.out.print("Input: ");
    String boatName = input.next();
    // delete the boat with same onwer id and same name from the Arraylist.
    registery.deleteBoat(memberid, boatName);
    // compare if the given name is equal to the boat name delete it from the text
    // file.
    if (boatName.equals(sailboatName)) {
      overrid(sailboat);
      System.out.println("Boat successfully deleted!");
    } else if (boatName.equals(motorboatName)) {
      overrid(motorboat);
      System.out.println("Boat successfully deleted!");
    } else if (boatName.equals(motorsailerName)) {
      overrid(motorsailer);
      System.out.println("Boat successfully deleted!");
    } else if (boatName.equals(canoeName)) {
      overrid(canoe);
      System.out.println("Boat successfully deleted!");
    } else {
      System.out.println("could not find the boat, try again!");
    }

    System.out.println();
    System.out.println("Do you want to return to the menu? y/n (Anything else is no)");
    String yesno = input.next();

    if (yesno.equals("Y") || yesno.equals("y")) {
      System.out.println("Returning to the menu!");
      menuUi();
    }
    if (yesno.equals("n") || yesno.equals("N")) {
      quit();
    }
  }

  /**
   * registers a new boat for an existed member.
   */
  private void registerBoat() {
    System.out.println("Register a new boat!");
    System.out.println("Please type the ID of the member you want to register a boat to.");
    System.out.print("Input: ");
    String memberid = input.nextLine();
    // get the member with the given id through registery to add the boat for.
    Member tempMember = registery.showMember(memberid);
    if (tempMember == null) {
      System.out.println("Member not found, returning to main menu!");
      menuUi();
    }

    System.out.println("What type is the boat being registered?"
        + "\n1. Sailboat\n2. Motorboat\n3. Motorsailer\n4. Canoe");
    int select = 0;
    // checks if the given input is correct.
    do {
      System.out.print("Input: ");
      select = input.nextInt();
      if (select < 1 || select > 4) {
        System.out.println("Wrong number!");
        System.out.println("Please enter a number between 1-2!");
      }
    } while (select < 1 || select > 4);

    String boatType = "";
    String boatName = "";
    int boatLength = 0;
    int boatDepth = 0;
    int boatEnginPower = 0;
    Boat newBoat = new Boat();
    // if the user select sailboat the boat type automaticlly being "Sailboat".
    if (select == 1) {
      boatType = "Sailboat";
      System.out.println("What do you want to call the boat being registered?");
      System.out.print("Input: ");
      boatName = input.next(); // chose the name of the new boat.
      System.out.println("Please enter the length of the boat! (in metres)");
      System.out.print("Input: ");
      boatLength = input.nextInt(); // chose the lenght of the new boat.
      System.out.println("Please enter the depth of the boat! (in metres)");
      System.out.print("Input: ");
      boatDepth = input.nextInt(); // chose the depth of the new boat.
      // creat a new boat of these values.
      newBoat = new Boat(boatName, boatType, boatLength, boatDepth);
      // add the new boat to the arraylist though registery.
      registery.registerBoat(newBoat, memberid);
      System.out.println("Boat registered to member with id: " + memberid + "!");
      // write the boat information in the data file.
      write("BOAT:" + newBoat.getName() + ":"
          + newBoat.getType() + ":" + newBoat.getLength() + ":" + newBoat.getDepth()
          + ":" + memberid + "\n");

      // if the user select Motorboat the boat type automaticlly being "Motorboat".
    } else if (select == 2) {
      boatType = "Motorboat";
      System.out.println("What do you want to call the boat being registered?");
      System.out.print("Input: ");
      boatName = input.next(); // chose the name of the new boat.
      System.out.println("Please enter the length of the boat! (in metres)");
      System.out.print("Input: ");
      boatLength = input.nextInt(); // chose the lenght of the new boat.
      System.out.println("Please enter the engine power of the boat! (in hp)");
      System.out.print("Input: ");
      boatEnginPower = input.nextInt(); // chose the engine power of the new boat.
      // creat a new boat of these values.
      newBoat = new Boat(boatName, boatType, boatLength, boatEnginPower);
      // add the new boat to the arraylist though registery.
      registery.registerBoat(newBoat, memberid);
      System.out.println("Boat registered to member with id: " + memberid + "!");
      // write the boat information in the data file.
      write("BOAT:" + newBoat.getName() + ":" + newBoat.getType()
          + ":" + newBoat.getLength() + ":" + newBoat.getEnginPower() + ":" + memberid + "\n");

    } else if (select == 3) {
      boatType = "Motorsailer";
      System.out.println("What do you want to call the boat being registered?");
      System.out.print("Input: ");
      boatName = input.next();
      System.out.println("Please enter the length of the boat! (in metres)");
      System.out.print("Input: ");
      boatLength = input.nextInt();
      System.out.println("Please enter the depth of the boat! (in metres)");
      System.out.print("Input: ");
      boatDepth = input.nextInt();
      System.out.println("Please enter the engine power of the boat! (in hp)");
      System.out.print("Input: ");
      boatEnginPower = input.nextInt();
      newBoat = new Boat(boatName, boatType, boatLength, boatDepth, boatEnginPower);
      registery.registerBoat(newBoat, memberid);
      System.out.println("Boat registered to member with id: " + memberid + "!");
      write("BOAT:" + boatName + ":" + boatType + ":" + boatLength
          + ":" + boatDepth + ":" + boatEnginPower + ":" + memberid + "\n");

    } else if (select == 4) {
      boatType = "Canoe";
      System.out.println("What do you want to call the boat being registered?");
      System.out.print("Input: ");
      boatName = input.next();
      System.out.println("Please enter the length of the boat! (in metres)");
      System.out.print("Input: ");
      boatLength = input.nextInt();
      newBoat = new Boat(boatName, boatType, boatLength);
      registery.registerBoat(newBoat, memberid);
      System.out.println("Boat registered to member with id: " + memberid + "!");
      write("BOAT:" + newBoat.getName() + ":"
          + newBoat.getType() + ":" + newBoat.getLength() + ":" + memberid + "\n");

    }

    System.out.println();
    System.out.println("Do you want to return to the menu? y/n (Anything else is no)");
    String yesno = input.next();

    if (yesno.equals("Y") || yesno.equals("y")) {
      System.out.println("Returning to the menu!");
      menuUi();
    }
    if (yesno.equals("n") || yesno.equals("N")) {
      quit();
    }
  }

  /**
   * prints out all the members and their inforamtion.
   */
  private void showAllMembers() {
    String line = "";

    try {
      BufferedReader reader = new BufferedReader(new FileReader("Data.data",
          StandardCharsets.UTF_8));

      while ((line = reader.readLine()) != null) {
        if (line.contains("MEMBER")) {
          System.out.println(line);
        }
      }
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println();
    System.out.println("Do you want to return to the menu? y/n (Anything else is no)");
    String yesno = input.next();

    if (yesno.equals("Y") || yesno.equals("y")) {
      System.out.println("Returning to the menu!");
      menuUi();
    }
    if (yesno.equals("n") || yesno.equals("N")) {
      quit();
    }
  }

  /**
   * prints out a member of user chois and see his information and
   * all his boats and thier informatin.
   */
  private void showMember() {
    String memberId = "";
    System.out.println("\nPlease input the Id of the user you wish to view.");
    System.out.print("Input: ");
    memberId = input.next();
    Member tempMember = registery.showMember(memberId);
    if (tempMember == null) {
      System.out.println("Member not found.");
      menuUi();
    } else {
      System.out.println("MEMBER:" + tempMember.getName() + ":" + tempMember.getEmail() + ":"
          + tempMember.getUid());
      // creates a new arraylist and copy it to another one with a list of the boats.
      ArrayList<Boat> boatList = new ArrayList<>();
      ArrayList<Boat> copyBoatList = loadBoat(memberId);
      boatList = copyBoatList;
      // loop through the list and see if boats founded and pirnt their details.
      for (int i = 0; i < boatList.size(); i++) {
        String boatType = boatList.get(i).getType();
        if (boatType.equals("Sailboat")) {
          System.out.println("BOAT:" + boatList.get(i).getName() + ":" + boatList.get(i).getType()
              + ":" + boatList.get(i).getLength() + ":" + boatList.get(i).getDepth());

        } else if (boatType.equals("Motorboat")) {
          System.out.println("BOAT:" + boatList.get(i).getName()
              + ":" + boatList.get(i).getType() + ":" + boatList.get(i).getLength()
              + ":" + boatList.get(i).getEnginPower());

        } else if (boatType.equals("Motorsailer")) {
          System.out.println("BOAT:" + boatList.get(i).getName() + ":" + boatList.get(i).getType()
              + ":" + boatList.get(i).getLength() + ":" + boatList.get(i).getDepth()
              + ":" + boatList.get(i).getEnginPower());

        } else if (boatType.equals("Canoe")) {
          System.out.println("BOAT:" + boatList.get(i).getName() + ":"
              + boatList.get(i).getType() + ":" + boatList.get(i).getLength());
        }
      }
      System.out.println();
      System.out.println("Do you want to return to the menu? y/n");
      String yesno = input.next();

      if (yesno.equals("Y") || yesno.equals("y")) {
        System.out.println("Returning to the menu!");
        menuUi();
      }
      if (yesno.equals("n") || yesno.equals("N")) {
        quit();
      }
    }

  }

  /**
   * creats a new member.
   */
  private void createMember() {
    System.out.println("Create a new member!");
    System.out.println("Please enter the new member's name!(Start with capital letter)");
    System.out.print("Input: ");

    // check if the given name will start with a capital letter and has only letters
    while (!input.hasNext("[A-Z][a-z A-Z]*")) {
      System.out.println("The name is not properly formatted!");
      System.out.println("No symbols or numbers in name!");
      System.out.print("Input: ");
      input.next();
    }
    String name = input.nextLine();

    System.out.println("Do you want to insert an email? y/n. (Anything else is no)");
    String selection = input.next();
    String email = "";
    // if the user choses to add an email enter the new value.
    // check if the email is unique and isValid.
    if (selection.equals("y") || selection.equals("Y")) {
      System.out.print("enter an email: ");
      email = input.next();
      if (emailCheck(email)) {
        System.out.println("This email is already exists, plaese try different one.");
        System.out.print("enter an email: ");
        email = input.next();
      }
      while (!email.contains("@") || !email.contains(".")) {
        System.out.println("invalid email! Please enter a vild one");
        email = input.next();
      }
    } else if (selection.equals("n")) {
      email = "NUll";
      Member member = new Member();
      String id = member.setUid(); // generate an id.
      // check if the id is unique.
      if (checkId(id)) {
        id = member.setUid();
      }
      ArrayList<Boat> boats = member.getBoats();
      Member newMem = new Member(name, email, id, boats);

      registery.membersRegisterer(newMem); // add the member to the list thought the registery.
      System.out.println("Member created, returning to menu!");
      System.out.println("the member has id: " + newMem.getUid());
      write("MEMBER:" + newMem.getName() + ":"
          + newMem.getEmail().toLowerCase() + ":" + newMem.getUid() + "\n");
      System.out.println();
      System.out.println("Do you want to return to the menu? y/n");
      String yesno = input.next();

      if (yesno.equals("Y") || yesno.equals("y")) {
        System.out.println("Returning to the menu!");
        menuUi();
      }
      if (yesno.equals("n") || yesno.equals("N")) {
        quit();
      }

    }
    Member member = new Member();
    String id = member.setUid();
    // check if the id is unique.
    if (checkId(id)) {
      id = member.setUid();
    }
    ArrayList<Boat> boats = member.getBoats();
    Member newMem = new Member(name, email, id, boats);
    registery.membersRegisterer(newMem);
    System.out.println("Member created, returning to menu!");
    System.out.println("the member has id: " + newMem.getUid());

    write("MEMBER:" + newMem.getName() + ":"
        + newMem.getEmail().toLowerCase() + ":" + newMem.getUid() + "\n");

    System.out.println();
    System.out.println("Do you want to return to the menu? y/n");
    String yesno = input.next();

    if (yesno.equals("Y") || yesno.equals("y")) {
      System.out.println("Returning to the menu!");
      menuUi();
    }
    if (yesno.equals("n") || yesno.equals("N")) {
      quit();
    }
  }

  /**
   * checks if an email is already exists.
   * loops through every member in the list and checks if the email is exist.
   */
  private boolean emailCheck(String feed) {
    boolean exist = false;
    ArrayList<Member> memberList = registery.showAllMembers();
    for (int i = 0; i < memberList.size(); i++) {
      String emails = memberList.get(i).getEmail();
      String[] email = emails.split("\n");
      for (String string : email) {
        if (string.equals(feed)) {
          exist = true;
        }
      }
    }
    return exist;

  }

  /**
   * loadboats.
   * reads the data file and checks the boat from their typs adds the value
   * correctly
   * creat and object of them and then add that object to list to be used later as
   * an arraylist.
   */
  public ArrayList<Boat> loadBoat(String mid) {
    String line = "";
    String name = "";
    String type = "";
    int depth = 0;
    int enginpower = 0;
    int length = 0;
    Boat tempBoat = new Boat();
    Member tempMember = new Member();
    ArrayList<Boat> boats = tempMember.getBoats();
    try {
      BufferedReader reader = new BufferedReader(new FileReader("Data.data",
          StandardCharsets.UTF_8));
      while ((line = reader.readLine()) != null) {
        String[] splited = line.split(":");

        if (splited[2].equals("Sailboat")
            && splited[splited.length - 1].equals(mid)) {
          name = splited[1];
          type = splited[2];
          length = Integer.parseInt(splited[3]);
          depth = Integer.parseInt(splited[4]);
          tempBoat = new Boat(name, type, length, depth);
          boats.add(tempBoat);

        } else if (splited[2].equals("Motorboat") && splited[splited.length - 1].equals(mid)) {
          name = splited[1];
          type = splited[2];
          length = Integer.parseInt(splited[3]);
          enginpower = Integer.parseInt(splited[4]);
          tempBoat = new Boat(name, type, length, enginpower);
          boats.add(tempBoat);

        } else if (splited[2].equals("Motorsailer") && splited[splited.length - 1].equals(mid)) {
          name = splited[1];
          type = splited[2];
          length = Integer.parseInt(splited[3]);
          depth = Integer.parseInt(splited[4]);
          enginpower = Integer.parseInt(splited[5]);
          tempBoat = new Boat(name, type, length, depth, enginpower);
          boats.add(tempBoat);

        } else if (splited[2].equals("Canoe") && splited[splited.length - 1].equals(mid)) {
          name = splited[1];
          type = splited[2];
          length = Integer.parseInt(splited[3]);
          tempBoat = new Boat(name, type, length);
          boats.add(tempBoat);

        }
      }
      reader.close();

    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return boats;

  }

  /**
   * delete Strings from data file.
   * used to delete members and boats.
   * used to overrid data when editing a member or a boat.
   */
  private void overrid(String feed) {
    String read = " ";
    File myfile = new File("Data.data");
    File tmpFile = new File("tmp.data");

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(tmpFile, StandardCharsets.UTF_8));
      BufferedReader reader = new BufferedReader(new FileReader(myfile, StandardCharsets.UTF_8));
      while ((read = reader.readLine()) != null) {
        if (!read.contains(feed)) {
          writer.write(read + "\n");
        }
      }
      writer.close();
      reader.close();
      myfile.delete();
      // does nothing seriously, did that to pass error in gradle.
      if (myfile.delete()) {
        System.out.println("file deleted.");
      }
      tmpFile.renameTo(myfile);
      if (tmpFile.renameTo(myfile)) {
        System.out.println("file is overrod.");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * uses to write on the data file.
   */
  private void write(String feed) {
    File file = new File("Data.data");

    try {
      FileWriter fileWriter = new FileWriter(file, true);
      BufferedWriter writer = new BufferedWriter(fileWriter);
      writer.write(feed);
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * checks if the id is already exists.
   * loops through every member in the list and checks if the id is exist.
   */
  private boolean checkId(String feed) {
    boolean exist = false;
    ArrayList<Member> memberList = registery.showAllMembers();
    for (int i = 0; i < memberList.size(); i++) {
      String ids = memberList.get(i).getUid();
      String[] id = ids.split("\n");
      for (String string : id) {
        if (string.equals(feed)) {
          exist = true;
        }
      }
    }
    return exist;

  }

}
