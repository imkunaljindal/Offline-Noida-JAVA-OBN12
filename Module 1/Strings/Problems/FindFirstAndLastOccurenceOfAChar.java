package Problems;

public class FindFirstAndLastOccurenceOfAChar {

    public static void main(String[] args) {
        String s = "helloledb";
        char x = 'e';

        int n = s.length();

        // first occurence
        int firstIndex = -1;
        for(int i=0;i<n;i++) {
            if(s.charAt(i)==x) {
                firstIndex = i;
                break;
            }
        }

        //last occurence
        int lastIndex = -1;
        for(int i=0;i<n;i++) {
            if(s.charAt(i)==x) {
                lastIndex = i;
            }
        }
        System.out.println(lastIndex);

    }
}
