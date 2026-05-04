public class Practical23A {

    // Method to print the ternary heap
    public static void print(int heap[]) {

        // Edge case: null or too small
        if (heap == null || heap.length <= 1) {
            System.out.println("Heap is empty");
            return;
        }

        // Loop through all parent nodes
        for (int i = 1; i < heap.length; i++) {

            int left = 3 * i - 1;
            int middle = 3 * i;
            int right = 3 * i + 1;

            // If no children exist, skip
            if (left >= heap.length) continue;

            System.out.print("Node " + heap[i] + " -> ");

            // Print children only if they exist
            if (left < heap.length)
                System.out.print(heap[left]);

            if (middle < heap.length)
                System.out.print(", " + heap[middle]);

            if (right < heap.length)
                System.out.print(", " + heap[right]);

            System.out.println();
        }
    }

    //Validation methd
    public static int validate(int heap[]) {

        //checking if the heap is null or has only one element
        if (heap == null || heap.length <= 1) {
            return 1; 
        }

        //flags to check if it's a min-heap or max-heap
        boolean isMinHeap = true;
        boolean isMaxHeap = true;

        for (int i = 1; i < heap.length; i++) {

            int left = 3 * i - 1;
            int middle = 3 * i;
            int right = 3 * i + 1;

            // Check each child if it exists
            if (left < heap.length) {
                if (heap[i] > heap[left]) isMinHeap = false;
                if (heap[i] < heap[left]) isMaxHeap = false;
            }

            if (middle < heap.length) {
                if (heap[i] > heap[middle]) isMinHeap = false;
                if (heap[i] < heap[middle]) isMaxHeap = false;
            }

            if (right < heap.length) {
                if (heap[i] > heap[right]) isMinHeap = false;
                if (heap[i] < heap[right]) isMaxHeap = false;
            }
        }

        if (isMinHeap || isMaxHeap) {
            return 1;
        } else {
            return -1;
        }
    }

    //Test cases
    public static void main(String[] args) {

        // Example heap 
        //Index 0 is unused to simplify parent-child calculations
        //because in a ternary heap, the children of node at index i are at 3*i-1, 3*i, and 3*i+1
        int[] minHeap = {0, 2, 4, 6, 8, 9, 13, 28};

        int[] maxHeap = {0, 28, 13, 9, 8, 6, 5, 1};

        int[] invalidHeap = {0, 28, 16, 25, 4};

        System.out.println("Heap 1:");
        System.out.println();
        print(minHeap);

        System.out.println("\nHeap 2:");
        System.out.println();
        print(maxHeap);
        System.out.println("\nHeap 3:");
        System.out.println();
        print(invalidHeap);

        System.out.println("\n=== VALIDATE METHOD ===");
        System.out.println("Heap1: " + validate(minHeap));
        System.out.println("Heap2: " + validate(maxHeap));
        System.out.println("Heap3: " + validate(invalidHeap));
    }
}