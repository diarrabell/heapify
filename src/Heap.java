public class Heap{
    /*
    takes an array of integers as input and converts it to a max heap
     */
    public int[] heapify(int[] arr) {
        return arr;
    }

    /*
     */
        if(rChild != -1) {
            if (arr[parent]<arr[lChild] || arr[parent]<arr[rChild]) {
                if (arr[lChild] > arr[rChild]) {
                    swap(arr, lChild, parent);
                } else {
                    swap(arr, rChild, parent);
                }
            }
        } else if (lChild !=-1){
            if (arr[parent]<arr[lChild]) {
                swap(arr,parent,lChild);
            }
        }
    }


            i++;
        }

        if(rChild>=arr.length) {
            rChild = -1;
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
