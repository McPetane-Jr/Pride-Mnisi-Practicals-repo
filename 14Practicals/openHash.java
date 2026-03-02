

public class openHash {

    //You will need a scatter function int hash(String key) that hashes the key and 
    // yields an integer index i ∈ [1..m] that has a random uniform distribution. Note N 
    // the number of key–value data pairs is smaller than m. If i has a biased distribution 
    // then the hash function hash(key) will flop.

    private static class Node{
        String key;
        String value;

        Node(String key, String value){
            this.key = key;
            this.value = value;
        }

        private Node[] table; // This will be our hash table
        private int m; // Size of the hash table
        private int size; // Number of key-value pairs in the hash table

        public openHash(int m){

            this.m = m;

            this.table = new Node[m + 1]; 
            this.size = 0;
        }

        private int hash(String key) {
            int hashValue = Math.abs(key.hashCode());
            return (hashValue % m) + 1;   
        }

        
            
    }
}