public class HeapTest {
    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] arr = {5, 18, 3, 25, 27, 45, 97, 88, 26, 16, 49, 67};
        int[] arr2 = {15, 99, 3, 77, 27, 45, 7, 88, 26, 5};
        int[] heapArr,sortArr;

//        heapArr = heap.heapify(arr);
        heap.printHeap(arr);

//        sortArr = heap.heapsort(arr2);
//        heap.printHeap(arr2);

        String s= "";

        for (int i=0; i<arr.length; i++) {
            s = s + arr[i] + " ";
        }

        System.out.print(s);

    }
}
