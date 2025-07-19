import java.util.HashMap;
import java.util.Map;

public class Concept {

    public static void main(String[] args) {
        String s = "aabccddtrz";

        int freq[] = new int[26];
        Map<Character,Integer> freqMap = new HashMap<>();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            //freq[c-'a']++;
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }

//        for(int i=0;i<26;i++) {
//            System.out.println(i + "->" + freq[i]);
//        }

        for(Character c: freqMap.keySet()) {
            System.out.println(c + "->" + freqMap.get(c));
        }
    }
}
