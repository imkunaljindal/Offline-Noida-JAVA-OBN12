import java.util.*;

class Solution {
    public static int solve(List<List<Integer>> A) {
        Collections.sort(A,(a,b) -> a.get(1)-b.get(1));

        int endTime = -1;
        int intervalsPicked = 0;

        for(int i=0;i<A.size();i++) {
            if(A.get(i).get(0) > endTime) {
                intervalsPicked++;
                endTime = A.get(i).get(1);
            }
        }
        return intervalsPicked;
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}
