import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//package 15Practicals;

public class anagrams {

    public Map<String, List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            anagramGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return anagramGroups;
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


    public static List<List<String>> sortAnagramGroups(Map<String, List<String>> map) {

        List<List<String>> groups = new ArrayList<>(map.values());

        groups.sort((a, b) -> a.get(0).compareTo(b.get(0)));

        return groups;
    }

    public static void writeLatexFile(List<List<String>> groups) {

        try {

            PrintWriter writer = new PrintWriter("theAnagrams.tex");

            for (List<String> group : groups) {

                if (group.size() > 1) {

                    Collections.sort(group);

                    writer.println(String.join(", ", group) + "\\\\");
                }

            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error writing LaTeX file.");

        }
    }
    public static void main(String[] args) throws Exception {

        String[] words = readWordsFromFile("joyce1992_ulysses.txt");

        anagrams obj = new anagrams();

        //List<List<String>> anagramGroups = obj.groupAnagrams(words);
        //for (String w : words) System.out.println(w);
        //writeLatex(anagrams, "theAnagrams.tex");

        //System.out.println(anagramGroups);
        Map<String, List<String>> anagramMap = obj.groupAnagrams(words);
        List<List<String>> sortedGroups = sortAnagramGroups(anagramMap);
        //System.out.println(sortedGroups);

        writeLatexFile(sortedGroups);


    }

}
