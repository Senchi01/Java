package Lecture2;

import java.util.Random;

public class Arraysum {

    public static void main(String[] args) {
        int[] theArray = new int[5];
        Random rnd = new Random();
        for(int i =0; i<5; i++){
            theArray[i] = rnd.nextInt(1,100)+1;
        }
        int sum = 0;
        for (int j = 0; j<5; j++){
            sum+=theArray[j];
            System.out.println(theArray[j]);
        }
        System.out.println("the sum is: "+ sum);
    }
}
