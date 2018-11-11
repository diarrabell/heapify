public class Heap{
    int parent, lChild, rChild;
    /*
    takes an array of integers as input and converts it to a max heap
     */
    public int[] heapify(int[] arr) {
        getBottomRight(arr);
        compare(arr);
        return arr;
    }

    /*
    compares parent to its children
     */
    public void compare(int[] arr) {
        if(rChild != -1) {
            if (arr[parent]<arr[lChild] || arr[parent]<arr[rChild]) {
                if (arr[lChild] > arr[rChild]) {
                    swap(arr, lChild, parent);
                } else {
                    swap(arr, rChild, parent);
                }
            }
        } else {
            if (arr[parent]<arr[lChild]) {
                swap(arr,parent,lChild);
            }
        }

    }

    public int getBottomRight (int[] arr){
        int i=0;

        while (lChild<arr.length && rChild<arr.length) {
            parent = i; //(i - 1) / 2;
            lChild = 2 * i + 1;
            rChild = 2 * i + 2;
//            System.out.println(arr.length);
//            System.out.println(i + ":" + parent + "-" + lChild + "-" + rChild);
            i++;
        }

        if(rChild>=arr.length) {
            rChild = -1;
//            System.out.println(i + ":" + parent + "-" + lChild + "-" + rChild);
        }

        if(rChild>lChild && rChild<arr.length){
            return rChild;
        }

        if(lChild<arr.length) {
            return lChild;
        }

        //indicates there is no node
        return -1;
    }




    /*
    swaps indexes of a and b
     */
    public void swap (int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /*
    takes an integer array and sorts it  (ascending order)
     */
    public int[] heapsort(int[] arr) {
        return arr;
    }

    /*
    prints heap as array
     */
    public String printHeap(int[] arr) {
        String s= "";

        for (int i=0; i<arr.length; i++) {
            s = s + arr[i] + " ";
        }

        return s;
    }
}
