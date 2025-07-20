package Problems;
// A Java program to print all anagrams together
import java.util.*;

public class GroupAnagrams {
    // Given a list of words in wordArr[],

    static String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    static void printAnagramsTogether(String wordArr[], int size) {
        // <sortedKey, list<String>
        Map<String,List<String>> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for(String word: wordArr) {
            String sortedKey = sortString(word);
            if(!map.containsKey(sortedKey)) {
                map.put(sortedKey,new ArrayList<>());
                List<String> anagrams = map.get(sortedKey);
                anagrams.add(word);
                ans.add(word);
            }
            else {
                List<String> anagrams = map.get(sortedKey);
                anagrams.add(word);
            }
        }

        // output processing
        Collections.sort(ans);
        List<String> finalAns = new ArrayList<>();
        for(String v: ans) {
            String key = sortString(v);
            finalAns.addAll(map.get(key));
        }

        for(int i=0;i<finalAns.size();i++) {
            System.out.print(finalAns.get(i) + " ");
        }

    }

    // Driver program to test above functions
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] wordArr = new String[n];
        for (int i = 0; i < n; i++)
            wordArr[i] = sc.next();
        sc.close();
        printAnagramsTogether(wordArr, n);
    }
}