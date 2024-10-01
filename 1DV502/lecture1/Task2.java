package lecture1;

import java.util.Scanner;

public class Task2 {
    /**
     * ask for a qoute and when enterd, pritns with qoutation marks.
     * 
     *  
     */
    public void doTheTask(){
        System.out.println("enter");

        Scanner input = new Scanner(System.in);
        String quote = input.nextLine();
        quoteWithMarks(quote);


    }

    private void quoteWithMarks(String quote){
        System.out.println("\"" + quote + "\"");
    }

    /* private String getQuote(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();



    } */
}
