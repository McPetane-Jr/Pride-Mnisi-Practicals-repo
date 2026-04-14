import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
    //Method from last prac
    //This method reads the file and returns an array of words
    static String[] readWordsFromFile(String filename) throws IOException {

        //For holding the words we read
        ArrayList<String> words = new ArrayList<>();


        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {

            // convert to lowercase
            line = line.toLowerCase();

            // remove punctuation and replace with an empty string
            line = line.replaceAll("[^a-z ]", "");

            //Split the line into words using whitespace as a delimiter
            String[] parts = line.split("\\s+");

            //Add the words to our list
            // ignoring empty strings
            for (String word : parts) {
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        }

        reader.close();

        //Convert the list of words to an array and return it
        return words.toArray(new String[0]);
    }

    //Main method to test the heapsort implementation
    public static void main(String[] args) throws IOException {

        String[] arr = readWordsFromFile("joyce1992_ulysses.txt");

        int startTime0 = (int) System.currentTimeMillis();
        String[] sortedArr = topDownHeapSort(arr);
        int endTime0 = (int) System.currentTimeMillis();

        int startTime = (int) System.currentTimeMillis();
        sortedArr = bottomUpHeapSort(arr);
        int endTime = (int) System.currentTimeMillis();


        
        System.out.println("====================\nSorted array:");
        for (String str : sortedArr) {
            System.out.println(str);
        }
        System.out.println("Time taken to sort using top-down heap sort: " + (endTime0 - startTime0) + " milliseconds");

        System.out.println("Time taken to sort using bottom-up heap sort: " + (endTime - startTime) + " milliseconds");

    }

    //topDownHeap
    static void topDownHeap(String[] arr) {
        heap = new String[arr.length]; //initialize the heap array
        size = 0; //initialize the size of the heap

        //Inserting each element from the input array into the heap
        for (String word : arr) {
            insert(word);
        }
    }

    //Method to insert an element into the heap
    static void insert(String word) {

        //Placing the new word at the end of the heap
        heap[size] = word;
        heapifyUp(size); //heapifying up from the last index to restore the heap property
        size++; //incrementing the size of the heap
    }

    //Method to heapify up from a given index
    static void heapifyUp(int index) {

        while (index>0) { //while the index is not the root node 
            
        
            int parentIndex = (index - 1) / 2; //Calculating the index of the parent node

            //Comparing the current node with its parent and swapping if necessary
            if (heap[index].compareTo(heap[parentIndex]) > 0) {
                swap(index, parentIndex); //swap the current node with its parent
                index = parentIndex; //update the index to the parent's index to continue heapifying up
            }else break; //if the current node is not greater than its parent, we can stop heapifying up
        }
    }

    static String[] topDownHeapSort(String[] arr) {
        topDownHeap(arr); //building the heap using the top-down method

        //Loop that removes the largest element (the root of the heap) and places it at the end of the array
        for (int i = size - 1; i > 0; i--){
            
            swap(0, i); //swap the root of the heap with the last element
            size--; //reduce the size of the heap by one
            heapifyDown(0); //heapify down from the root to restore the heap property
        }

        return heap; //sorted
    }



    
}
