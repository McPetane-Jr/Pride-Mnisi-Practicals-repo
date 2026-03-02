

import java.io.IOException;
import java.text.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class timeMethods{

    public static int N = 1<<20; //This is 2^20, which is 1,048,576. You can set this to a different value as needed.
    
    private static class Node {
        String key;
        String value;

        Node(String key, String value)
        {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String args[]) throws IOException {

        Integer[] keys = new Integer[N];

        for (int i = 0; i < N; i++) {
            keys[i] = i; // Assuming keys are from 0 to N-1
        }

        List<Integer> keyList = Arrays.asList(keys); // Convert array to list for shuffling
        Collections.shuffle(keyList); // Shuffle the list to randomize the order of keys
        //keyList.toArray(keys); // Convert back to array if needed

        //number the shuffled keys from 1 to N and use the String value of this number 
        // as the data value for each key. So for each key there is now also a corresponding different
        // String valued number. 

        Node[] nodeArr = new Node[N];

        for (int i = 0; i < N; i++){

            String key = String.valueOf(keyList.get(i)); // converted the shuffled key to String
            String value = String.valueOf(i + 1); // converted the index (numbered from 1 to N) to String
            nodeArr[i] = new Node(key, value); // Create a new Node with the key and value and store it in the array
        }
    }
        
    // Linear Search for Key
    

    // Binary Search for Key
   
        
    // Read file and create a Node Array
    

}

