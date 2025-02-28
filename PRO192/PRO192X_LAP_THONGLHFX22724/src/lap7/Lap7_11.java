package lap7;

import java.util.Scanner;

public class Lap7_11{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int capacity = sc.nextInt();
        int[] arr = getIntegers(capacity);
    }
    public static int[] getIntegers(int capacity){
        int[] arrayInterger = new int[capacity];
        for(int i = 0; i < capacity; i++){
            arrayInterger[0] = sc.nextInt();
        }
        return arrayInterger;
    }
}
