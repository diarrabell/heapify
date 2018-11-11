import java.util.ArrayList;

public class Heap{
    int parent, lChild, rChild, max=0;
    /*
    takes an array of integers as input and converts it to a max heap
     */
    public int[] heapify(int[] arr) {
        max=0;

        for(int i=0; i<arr.length-1; i++) {
            if (arr[i+1]> max) {
                max = arr[i+1];
            }
        }

        while (arr[0]< max) {
            int i=0;
            lChild=0;
            rChild=0;
            parent=0;
            while (lChild != -1 || (rChild != -1 && lChild != -1)) {
                compare(arr, i);
                i++;
            }
        }

        return arr;
    }
    /*
    compares parent to its child
     */
    public void compare(int[] arr, int i) {
        getChild(arr,i);
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

    /*
    gets the higher numbered child of the specified node/index
     */
    public int getChild (int[] arr, int i){
        if(lChild<arr.length && rChild<arr.length && parent<arr.length) {
            parent = i;

            if(i<arr.length) {
                lChild = 2 * i + 1;
                rChild = 2 * i + 2;
            }

            i++;
        }

        if(rChild>=arr.length) {
            rChild = -1;
        }

        if(lChild>=arr.length) {
            lChild = -1;
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
        int[] sorted = new int[arr.length];

        while(arr.length>0) {
            ArrayList<Integer> temp;
            heapify(arr);
            swap(arr, 0, arr.length - 1);
            sorted[arr.length-1] = arr[arr.length-1];
            temp = toArrayList(arr);
            temp.remove(arr.length - 1);
            arr = toArray(temp);
        }

        return sorted;
    }

    /*
    turns arraylist into array to be passed into sort and heapify methods
     */
    public int[] toArray (ArrayList<Integer> arr) {
        int[] temp = new int[arr.size()];

        for (int i=0; i<arr.size(); i++) {
            temp[i] = arr.get(i);
        }
        return temp;
    }

    /*
    turns array into array list to easily remove last item
     */
    public ArrayList<Integer> toArrayList(int[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i=0; i<arr.length; i++) {
            temp.add(arr[i]);
        }
        return temp;
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
