/*
Diarra Bell & Anya Greenberg
CSC 172
Lab 6: Heapify & Radix Sort
 */

import java.util.Arrays;
import java.util.Random;

public class RadixSort {
    //TODO: function to sort array using radix sort(using bitshifting)
    public static void radixSort(int [] array){
        for (int i = Integer.SIZE-1; i > -1; i--){
            int[] a2 = new int[array.length];
            int numZeroes = 0;
            for (int j = 0; j< array.length; j++){
                boolean shift = array[j] << i >=0;
                if((i == 0) != shift){
                    a2[numZeroes] = array[j];
                    numZeroes++;
                }else{
                    array[j - numZeroes] = array[j];
                }
            }
            for (int k = numZeroes; k < a2.length; k++){
                a2[k] = array[k-numZeroes];
            }
            array = a2;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String [] args){
        //the following are randomly created test arrays:
        int[] array = new int[100];
        Random rand = new Random();
        for(int i=0;i<array.length;i++){
            array[i] = rand.nextInt(1000);
        }
        Stopwatch timer = new Stopwatch(); //Stopwatch.java and related code provided by professor
        radixSort(array);
        double time = timer.elapsedTimeMillis();
        System.out.println("The total running time is: ");
        System.out.print(time);
    }
}