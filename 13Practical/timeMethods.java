import java.lang.Math;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.*;

public class timeMethods {

    public static int N = 0;   // you can set this later

    public static void main(String args[]) throws Exception {

        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        long start, finish;
        double runTime = 0, runTime2 = 0, time;
        double totalTime = 0.0;
        int n = N;
        int repetition, repetitions = 30;

        runTime = 0;

        Random randGen = new Random();

        String[] bookArr = readFileToArray("C:\\Users\\Mcpet\\IdeaProjects\\13Practical\\src\\ulysses.numbered");

        for (String line : bookArr)
        {
            System.out.println(line);
        }

        for (repetition = 0; repetition < repetitions; repetition++) {

            start = System.currentTimeMillis();

            int rand = randGen.nextInt(0, 32654);

            // call the procedures to time here:
//            linearSearch();
//            binarySearch();

            finish = System.currentTimeMillis();

            time = (double) (finish - start);
            runTime += time;
            runTime2 += (time * time);
        }

        double aveRuntime = runTime / repetitions;

        double stdDeviation =
                Math.sqrt(runTime2 - repetitions * aveRuntime * aveRuntime)
                        / (repetitions - 1);

        System.out.printf("\n\nStatistics\n");
        System.out.println("________________________________________________");
        System.out.println("Total time = " + runTime / 1000 + " s.");
        System.out.println("Total time^2 = " + runTime2);
        System.out.println("Average time = " + fiveD.format(aveRuntime / 1000)
                + " s. ± " + fourD.format(stdDeviation) + " ms.");
        System.out.println("Standard deviation = " + fourD.format(stdDeviation));
        System.out.println("n = " + n);
        System.out.println("Average time / run = "
                + fiveD.format(aveRuntime / n * 1000) + " microseconds");
        System.out.println("Repetitions = " + repetitions);
        System.out.println("________________________________________________");
        System.out.println();
        System.out.println();
    }

    // Linear Search Method
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Binary search method
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + (right - left)) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    static String[] readFileToArray(String filename) throws Exception {

        ArrayList<String> lines = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        reader.close();

        String[] arrayOfLines = lines.toArray(new String[0]);
        return arrayOfLines;
    }

}