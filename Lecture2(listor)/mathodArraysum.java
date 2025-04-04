package Lecture2;

import java.util.Random;

public class mathodArraysum {
    public static int sumofarray(int[] array){
        int sum = 0;
        for (int i = 0; i<array.length; i++){
            sum += array[i];
        }
        return sum;
    }   
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] arr = new int[5];
        for (int i = 0; i<arr.length; i++){
            arr[i] = rnd.nextInt(100)+1;
            System.out.println(arr[i]);

        }
        System.out.println("The sum is: "+ sumofarray(arr));
    }
}
