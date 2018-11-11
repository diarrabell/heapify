import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
    //TODO: function to get max value in array
    public static int maxValue(int[] array) {
        int max = array[0];
        for (int i = 1; i<array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    //TODO: function to get number of bits required to store number
    public static int numBits(int num){
        int amt = 0;
        while (num > 0){
            amt += num & 1;
            num >>=1;
        }
        return amt;
    }

    //TODO: function to sort array using radix sort
    public static void radixSort(int[] array) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int max = maxValue(array);
        int bits = numBits(max);

        for (int i = 0; i < bits; i++) {
            int shift = 1 << i;
            for (int j = 0; j < array.length; j++) {
                if ((array[j] & shift) == 0) {
                    q1.add(array[j]);
                } else {
                    q2.add(array[j]);
                }
            }
                int index = 0;
                while (!q1.isEmpty()) {
                }
                while (!q1.isEmpty()) {
                    array[index++] = q2.poll();
                }
            }
            System.out.println(Arrays.toString(array));
        }

    public static void main(String [] args){
        int [] array = new int[4];
        array[0] = 222;
        array[1] = 223;
        array[2] = 221;
        array[3] = 228;
        radixSort(array);
    }
}