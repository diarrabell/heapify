import java.util.Random;

public class radix{

  static int THRESHOLD = 1;// ****Notice this is changed to 1 - this makes the code work

  static int ARRAYSIZE = 0;
  static int[] POW2 = {1, 2, 4, 8, 16, 32, 64, 128, 256};

  @SuppressWarnings("unchecked") // Generic array allocation
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
    // Count[i] stores number of records in bin[i]
    int i, j, rtok;

    for (i=0, rtok=1; i<k; i++, rtok*=r) { // For k digits
      for (j=0; j<r; j++) count[j] = 0;    // Initialize count

      // Count the number of records for each bin on this pass
      for (j=0; j<A.length; j++) count[(A[j]/rtok)%r]++;

      // count[j] will be index in B for last slot of bin j.
      for (j=1; j<r; j++) count[j] = count[j-1] + count[j];

      // Put records into bins, working from bottom of bin
      // Since bins fill from bottom, j counts downwards
      for (j=A.length-1; j>=0; j--)
        B[--count[(A[j]/rtok)%r]] = A[j];

      for (j=0; j<A.length; j++) A[j] = B[j]; // Copy B back
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
    //sort array and print result
      Stopwatch timer = new Stopwatch();
    Sort(arr);
    printArr(arr);
      double time = timer.elapsedTimeMillis();
      System.out.println("The total running time is: ");
      System.out.print(time);
  }

}
