import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//package 15Practicals;

public class anagrams {

    public List<List<String>> groupAnagrams(String[] strs){

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String keys = new String(chars);
            //This line checks if the key already exists in the map.
            //If it does, it adds the string to the existing list.
            //If it doesn't, it creates a new list and adds the string to it.
            anagramGroups.computeIfAbsent(keys, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(anagramGroups.values());
    }

    //This method reads the file and returns an array of words
    public static String[] readWordsFromFile(String filename) throws IOException {

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

    public static void main(String[] args) throws Exception {

        String[] words = readWordsFromFile("joyce1992_ulysses.txt");

        anagrams obj = new anagrams();

        List<List<String>> anagramGroups = obj.groupAnagrams(words);
        for (String w : words) System.out.println(w);
        //writeLatex(anagrams, "theAnagrams.tex");

        System.out.println("Done!");
    }

}
