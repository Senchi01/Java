 package Lecture2;

import java.util.ArrayList;
import java.util.Random;

public class removingArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rnd = new Random();

        for(int i = 0; i<10; i++){
            list.add(rnd.nextInt(10)+1);
        }
        for(int n: list){
            System.out.print(n + " ");
        }
        System.out.println();
        while(list.contains(3)){
            list.remove(list.indexOf(3));
        }
        for(int n: list){
            System.out.print(n + " ");
        }
    }
}
