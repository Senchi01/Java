package Lecture2;

public class Powerof {
    
    public static void main(String[] args) {
        System.out.println("Using math.pow(): "+Math.pow(4,3));
        System.out.println("Using Power: "+Power(4,3));

    }
    public static int Power(int b, int e){
        int answer = 1;
        for (int i=0; i<e; i++){
            answer *=b;
        }
        return answer; 

    }
    
}
