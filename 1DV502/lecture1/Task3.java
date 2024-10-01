package lecture1;

import java.util.Scanner;

public class Task3 {
    public void doTheTask(){
        String s = "";
        Scanner input = new Scanner(System.in);

        int i = input.nextInt();
        if (i % 2==0){
            s += "even. ";
        } else {
            s += "odd. ";
        }
        if (i > 0 ){
            s += "more than zero";
        }else if(i==0){
            s += "zero";
        }else{
            s += "less than zero";

        }

        System.out.println(s);

    }
}
