//import java.util.*;
//
//public class Main {
//
//    public static String DistinctWindow(String s){
//        int n = s.length();
//        boolean isExist[] = new boolean[26];
//        int distinct = 0;
//
//        for(int i=0;i<n;i++) {
//            char c = s.charAt(i);
//            if(isExist[c-'a']==false) {
//                isExist[c-'a'] = true;
//                distinct++;
//            }
//        }
//
//        int start = 0;
//        int end = 0;
//
//        // <Char,freq>
//        Map<Character,Integer> freqMap = new HashMap<>();
//        int ansLen = Integer.MAX_VALUE;
//        int startIdx = -1;
//
//        while(end<n) {
//            char c = s.charAt(end);
//            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
//
//            // shrink till window is valid
//            while(freqMap.size()==distinct) {
//                if(end-start+1 < ansLen) {
//                    ansLen = Math.min(ansLen,end-start+1);
//                    startIdx = start;
//                }
//
//                // shrinkng
//                char x = s.charAt(start);
//                freqMap.put(x,freqMap.getOrDefault(x,0)-1);
//                if(freqMap.get(x)==0) {
//                    freqMap.remove(x);
//                }
//                start++;
//            }
//            end++;
//        }
//
//        return s.substring(startIdx,startIdx+ansLen);
//    }
//
//    public static void main(String[] args) throws Throwable {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String ans = DistinctWindow(s);
//        System.out.println(ans);
//    }
//}