package Lecture2;

public class sortedArray {
    public static boolean isSorted(int[] array){
        for(int i = 0; i<array.length - 1; i++){
            if(array[i+1]<array[i]){
                return false;
            }
            
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int[] sarr = new int[]{1,2,7,6,5};
        System.out.println("is sorted? "+ isSorted(arr));
        System.out.println("is sorted? "+ isSorted(sarr));


    }   
}
