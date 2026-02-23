public class practicsl13 {
    public static void main(String[] args) {
        // code to read the data from ulysses.numbered and perform the linear and binary search
    }
    
    // Implement your linear search method here
    public static int linearSearch(Node[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].key == key) {
                return i; 
            }
        }
        return -1; 
    }

    // Binary search method
    public static int binarySearch(Node[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            int mid = (left + (right - left)) / 2;
            
            if (array[mid].key == key) {
                return mid; 
            } else if (array[mid].key < key) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        return -1; 
    }
   
}