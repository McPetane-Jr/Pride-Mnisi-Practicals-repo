public class practical12 {

     public static void main(String[] args) {

        int[] X = {1, -2, 3, 4, -5, 8};
        System.out.println("mcsOn3: " + mcsOn3(X));
        System.out.println("mcsOn2A: " + mcsOn2A(X));
        System.out.println("mcsOn2B: " + mcsOn2B(X));
        System.out.println("mcsOn: " + mcsOn(X));
        
    }



    private static int mcsOn3(int[] X) {

        int n = X.length;

        int maxsofar = 0;
        
        for (int low=0; low < n; low++) { 

            for (int high=low; high < n; high++) { 

                int sum = 0; 

                for (int r=low; r < high; r++) { 

                    sum += X[r]; 

                }

                if (sum > maxsofar) {

                    maxsofar = sum;

                }
            }
        }
        return maxsofar;
    }

    private static int mcsOn2A(int[] X) {

        int n = X.length;

        int maxsofar = 0;
        
        for (int low=0; low < n; low++) { 

            int sum = 0; 

            for (int r=low; r < n; r++) { 

                sum += X[r]; 

                if (sum > maxsofar) {

                    maxsofar = sum;

                }
            }
        }
        return maxsofar;
    }

    private static int mcsOn2B(int[] X) {
    int n = X.length;

    int[] sumTo = new int[n + 1];
    for (int i = 0; i < n; i++) {
        sumTo[i + 1] = sumTo[i] + X[i];
    }

    int maxsofar = 0;
    for (int low = 0; low < n; low++) {
        for (int high = low; high < n; high++) {
            int sum = sumTo[high + 1] - sumTo[low]; 
            if (sum > maxsofar) {
                maxsofar = sum;
            }
        }
    }

    return maxsofar;
}

private static double mcsOn(int[] X) {
    int N = X.length;
    double maxSoFar = 0.0;
    double maxToHere = 0.0;

    for (int i = 0; i < N; i++) { // [0, N)
        maxToHere = Math.max(maxToHere + X[i], 0.0);
        maxSoFar = Math.max(maxSoFar, maxToHere);
    }

    return maxSoFar;
}



        

   

}
