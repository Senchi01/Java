package Lecture2;

public class Makesum {
    public static int sum(int x, int y){
        return x + y;
    }

    public static double sum(double x, double y){
        return x + y;
    }
    public static void main(String[] args) {
        System.out.println("sum of 3 and 4: "+sum(3, 4));
        System.out.println("sum of 3.14 and 2.31: "+sum(3.14, 2.31));
    }
}
