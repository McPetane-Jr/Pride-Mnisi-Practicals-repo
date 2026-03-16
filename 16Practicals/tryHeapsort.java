

public class tryHeapsort {

    static String[] heap;
    static int size;

    static void bottomUpHeap(String[] arr) {

        heap = arr.clone(); //cloning so that we don't modify the original array
        size = heap.length; //size of the heap

        int lastParent = (size - 2) / 2; //index of the last parent node

        //Moving from the last parent node to the root node and heapifying each node
        for (int i = lastParent; i >= 0; i--) {
            heapifyDown(i);
        }

    } 
    
    private static void heapifyDown(int i) {
        int largest = i; //initialize largest as the current node

        //Calculating the indices of the left and right children
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        //Comparing the left child with the current largest

        //leftChild < size compares the index of the left child 
        //with the size of the heap to ensure we don't go out of bounds

        //heap[leftChild].compareTo(heap[largest]) > 0 compares the value of the 
        //left child with the value of the current largest node.

        if(leftChild < size && heap[leftChild].compareTo(heap[largest]) > 0) {
            largest = leftChild;
        }

        //Comparing the right child with the current largest
        if(rightChild < size && heap[rightChild].compareTo(heap[largest]) > 0) {
            largest = rightChild;
        }

        //If the largest node is not the current node, 
        //we need to swap and heapify down
        if (largest != i) {
            
        swap(i, largest); //swap the current node with the largest node
        heapifyDown(largest);//recursively heapify the affected subtree to preserve the heap property
        }
    
    }

    //Method to swap two nodes in the heap
    private static void swap(int i, int j) {
        String temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    //Method to perform heapsort using the bottom-up heap
    static String[] bottomUpHeapSort(String[] arr){

        bottomUpHeap(arr); //building the heap using the bottom-up method

        //Loop that removes the largest element (the root of the heap) and places it at the end of the array
        for (int i = size - 1; i > 0; i--){
            
            swap(0, i); //swap the root of the heap with the last element
            size--; //reduce the size of the heap by one
            heapifyDown(0); //heapify down from the root to restore the heap property
        }

        return heap; //sorted
    }

    





    
}
