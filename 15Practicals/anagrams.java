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

    public static void main(String[] args) {

        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat", "listen", "silent", "enlist"};

        anagrams obj = new anagrams();

        List<List<String>> result = obj.groupAnagrams(words);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }
    
}
