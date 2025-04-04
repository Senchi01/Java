package assignment1;

import java.util.Scanner;

/**
 * main class.
 */
public class PrintCalendar {

  /**
   * get name of the month.
   */
  private static String getMonth(int month) {
    String nameOfMonth = " ";
    if (month == 1) {
      nameOfMonth = "Januari";
    } else if (month == 2) {
      nameOfMonth = "Februari";
    } else if (month == 3) {
      nameOfMonth = "Mars";
    } else if (month == 4) {
      nameOfMonth = "April";
    } else if (month == 5) {
      nameOfMonth = "May";
    } else if (month == 6) {
      nameOfMonth = "Juni";
    } else if (month == 7) {
      nameOfMonth = "Juli";
    } else if (month == 8) {
      nameOfMonth = "Augusti";
    } else if (month == 9) {
      nameOfMonth = "September";
    } else if (month == 10) {
      nameOfMonth = "Oktober";
    } else if (month == 11) {
      nameOfMonth = "November";
    } else if (month == 12) {
      nameOfMonth = "December";
    }
    return nameOfMonth;
  }

  /**
   * check if a year is a leap year(skottår).
   */

  private static boolean leapYear(int year) {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
  }

  /**
   * check how many day does a month has.
   * 
   */

  private static int days(int year, int month) {
    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
      return 31;
    }

    if (month == 4 || month == 6 || month == 9 || month == 11) {
      return 30;
    }

    if (month == 2 && leapYear(year)) {
      return 29;
    } else if (month == 2 && !leapYear(year)) {
      return 28;
    }
    return 0;
  }

  /**
   * count days since 1800.
   */
  private static int numberOfDay(int year, int month) {
    int total = 0;

    // Get the total days from 1800 to year - 1

    for (int i = 1800; i < year; i++) {
      if (leapYear(i)) {
        total += 366;
      } else {
        total += 365;
      }
    }
    // Add days from January to the month prior to the calendar month

    for (int i = 1; i < month; i++) {
      total += days(year, i);
    }
    return total;
  }

  /**
   * check start day of the month.
   */
  private static int startDay(int year, int month) {
    // strat day is Monday == 2.
    int startDay = 2;

    int totalDays = numberOfDay(year, month);
    return (totalDays + startDay) % 7;

  }

  /**
   * print the date body.
   */

  private static void printMonth(int year, int month) {
    int startDay = startDay(year, month);
    int numberOfDay = days(year, month);
    for (int i = 0; i < startDay; i++) {
      System.out.print("    ");

    }

    for (int i = 1; i <= numberOfDay; i++) {
      if (i < 10) {
        System.out.print("  0" + i);
      } else {
        System.out.print("  " + i);
      }
      if ((i + startDay) % 7 == 0) {
        System.out.println();
      }
    }
    System.out.println();

  }

  /**
   * run code.
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in, "utf-8");
    System.out.print("Enter a year after 1800: ");
    int year = input.nextInt();
    System.out.print("Enter a month (1-12): ");
    int month = input.nextInt();
    input.close();

    if (month < 1 || month > 12 || year < 1800) {
      System.out.println("Fel inmattning!");

    } else {
      System.out.println(getMonth(month) + " " + year);
      System.out.println("----------------------------");
      System.out.println(" Mon Tue Wed Thu Fri Sat Sun");
      printMonth(year, month);
    }
  }
}
