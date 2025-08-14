import java.util.*;

public class Main {

    public static List<Integer> distinctNumbers(List<Integer> A, int B) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<B;i++) {
            freqMap.put(A.get(i),freqMap.getOrDefault(A.get(i),0)+1);
        }

        ans.add(freqMap.size());

        for(int i=B;i<A.size();i++) {
            freqMap.put(A.get(i),freqMap.getOrDefault(A.get(i),0)+1);

            int rem = A.get(i-B);
            freqMap.put(rem,freqMap.getOrDefault(rem,0)-1);
            if(freqMap.get(rem)==0) {
                freqMap.remove(rem);
            }
            ans.add(freqMap.size());
        }
        return ans;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        List<Integer> ans = distinctNumbers(arr, k);

        for (int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
