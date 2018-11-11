//code provided by professor
import java.util.Random;

public class radix{

  static int THRESHOLD = 1;//

  static int ARRAYSIZE = 0;
  static int[] POW2 = {1, 2, 4, 8, 16, 32, 64, 128, 256};

  static void Sort(Integer[] A) {
    assert THRESHOLD > 0 :
           "Usage: Sortmain [+/-] <size> <threshold>, " +
           "MUST SET THRESHOLD AS NUMBER OF BITS IN RADIX";

    Integer[] temp = new Integer[A.length];
    int[] count = new int[POW2[THRESHOLD]];

    radix(A, temp, 16/THRESHOLD, POW2[THRESHOLD], count);
  }

  static void radix(Integer[] A, Integer[] B,
                    int k, int r, int[] count) {
    int i, j, rtok;

    for (i=0, rtok=1; i<k; i++, rtok*=r) {
      for (j=0; j<r; j++) count[j] = 0;
      for (j=0; j<A.length; j++) count[(A[j]/rtok)%r]++;
      for (j=1; j<r; j++) count[j] = count[j-1] + count[j];

      for (j=A.length-1; j>=0; j--)
        B[--count[(A[j]/rtok)%r]] = A[j];

      for (j=0; j<A.length; j++) A[j] = B[j];
    }
  }

  static void printArr(Integer[] arr){
    for(int i=0;i<arr.length;i++){
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args){
    //generate test array
    Integer[] arr = new Integer[256];
    Random rand = new Random();
    for(int i=0;i<arr.length;i++){
      arr[i] = rand.nextInt(1000);
    }
    Stopwatch timer = new Stopwatch();
    Sort(arr);
    printArr(arr);
    double time = timer.elapsedTimeMillis();
    System.out.println("The total running time is: ");
    System.out.print(time);
  }

}
