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

   
}