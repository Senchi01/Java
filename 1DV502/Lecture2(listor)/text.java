package Lecture2;

public class text {
    public static boolean check(String text , char character){
        for(int i=0; i<text.length(); i++){
            if(text.charAt(i)==character){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "qwerty";
        System.out.println("q "+check(s, 'q'));
        System.out.println("c "+check(s, 'c'));    
    }


}
