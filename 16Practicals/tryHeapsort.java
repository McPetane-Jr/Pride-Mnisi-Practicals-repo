

public class tryHeapsort {

    static String[] heap;
    static int size;

    static void bottomUpHeap(String[] arr) {

        heap = arr.clone(); //cloning so that we don't modify the original array
        size = heap.length;

        int lastParent = (size - 2) / 2; //index of the last parent node

        //Moving from the last parent node to the root node and heapifying each node
        for (int i = lastParent; i >= 0; i--) {
            heapifyDown(i);
        }

    } 

    private static void heapifyDown(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'heapifyDown'");
    }




    
}
