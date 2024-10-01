package Lecture2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class arraylist {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        System.out.print("How many integer u want? ");
        int num = scan.nextInt();

        for (int i = 0; i < num; i++){
            list.add(rnd.nextInt(100)+1);
            System.out.println(list);
        }
        int sum = 0;
        for (int n: list){
            sum += n;
        }
        System.out.println("Medelvärde: "+ sum/list.size());
        scan.close();
    }
}
