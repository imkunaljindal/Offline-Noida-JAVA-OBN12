//import java.util.*;
//
//public class Main {
//
//    public static int longestkSubstr(int n, int k,String s){
//        int ans = -1;
//        //<char,freq>
//        Map<Character,Integer> freqMap = new HashMap<>();
//
//        int start = 0;
//        int end = 0;
//
//        while(end < n) {
//            char c = s.charAt(end);
//            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
//            if(freqMap.size()==k) {
//                ans = Math.max(ans,end-start+1);
//            }
//            end++;
//            while(freqMap.size() > k) {
//                char x = s.charAt(start);
//                freqMap.put(x,freqMap.getOrDefault(x,0)-1);
//                if(freqMap.get(x)==0) {
//                    freqMap.remove(x);
//                }
//                start++;
//            }
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) throws Throwable {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        String s = sc.next();
//        int ans = longestkSubstr(n,k,s);
//        System.out.println(ans);
//    }
//}