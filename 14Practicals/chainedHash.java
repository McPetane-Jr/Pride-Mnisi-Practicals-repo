public class chainedHash {

    private static class Node{
        String key;
        String value;

        Node(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    private Node[] table; // This will be our hash table
    private int m; // Size of the hash table
    private int size; // Number of key-value pairs in the hash table

    public chainedHash(int m){

        this.m = m;

        this.table = new Node[m + 1]; 
        this.size = 0;
    }

    private int hash(String key) {
        int hashValue = Math.abs(key.hashCode());
        return (hashValue % m) + 1;   
    }

    public void insert(String key, String value) { 

        if (size == m) {
            return;   // table full
        }

        int i = hash(key);

        while (table[i] != null) {

        // If key already exists, update value
        if (table[i].key.equals(key)) {
            table[i].value = value;
            return;
        }

        i = (i % m) + 1;  // linear probing
    }

    table[i] = new Node(key, value);
    size++;
        
            
    }

    public String search(String key) {

        int i = hash(key);

        while (table[i] != null) {

            if (table[i].key.equals(key)) {
                return table[i].value; // Key found, return value
            }

            i = (i % m) + 1; // linear probing
        }

        return null; // Key not found
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public Boolean isFull() {
        return size == m;
    }
    
}
