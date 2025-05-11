public class CountFrequency {

    public static void main(String[] args) {
        String s = "andnjsafhiausfoi";

        int freq[] = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            freq[c-'a']++;
        }

        for(int i=0;i<26;i++) {
            System.out.print(freq[i] + " ") ;
        }
    }
}
