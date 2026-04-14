import java.util.Random;

/**
 * Three different shuffle implementations for numbers in range [1..N].
 */
public class shuffles {
    
    private static Random rand = new Random();
    
    
    public static int[] slowshuffle(int n) {
        int[] shuffled = new int[n];  // store shuffled numbers from 1 to n (extracted balls)
        int[] isNotPresent = new int[n + 1];  // track unused numbers (indices 1..n)
        
        // Initialize: all numbers 1 to n are "not present" (haven't been picked yet)
        // isNotPresent[r] = 1 means number r is available
        // isNotPresent[r] = 0 means number r has been picked
        for (int i = 1; i <= n; i++) {
            isNotPresent[i] = 1;
        }
        
        // Fill shuffled array with n-1 numbers
        int i = 0;
        while (i < n - 1) {
            int r = 1 + rand.nextInt(n);  // generate random number from 1 to n
            
            if (isNotPresent[r] == 1) {  // if this number hasn't been picked yet
                shuffled[i] = r;          // add to shuffled array
                isNotPresent[r] = 0;      // mark as used
                i++;
            }
            // else: r was already picked, continue loop and generate another random number
        }
        
        // Find the last remaining unused number (without generating random numbers)
        for (int j = 1; j <= n; j++) {
            if (isNotPresent[j] == 1) {  // find the one number still marked as "not present"
                shuffled[n - 1] = j;
                break;
            }
        }
        
        return shuffled;
    }
    
    
    public static int[] biasedshuffle(int n) {
        int[] shuffled = new int[n];
        // Initialize array with [1..n]
        for (int i = 0; i < n; i++) {
            shuffled[i] = i + 1;
        }
        
        // BIASED shuffle: swap with ANY position in array [0..n-1]
        // This is WRONG because elements can be moved multiple times
        for (int i = 0; i < n; i++) {
            int r = rand.nextInt(n);  // BUG: picks from entire array, including positions already processed
            // Swap shuffled[i] with shuffled[r]
            int temp = shuffled[i];
            shuffled[i] = shuffled[r];
            shuffled[r] = temp;
        }
        
        return shuffled;
    }
    
    
    public static int[] shuffle(int n) {
        int[] arr = new int[n];
        // Initialize array with [1..n]
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        
        // Correct Fisher-Yates shuffle: extract balls from jar
        for (int i = n - 1; i > 0; i--) {
            int randomIndex = rand.nextInt(i + 1);  // random index in [0..i] (remaining balls)
            // Swap arr[i] with arr[randomIndex]
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        
        return arr;
    }
    
    
    
    
    
}
