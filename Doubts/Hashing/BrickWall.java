import java.util.*;

public class BrickWall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<List<Integer>> wall = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            String s[] = sc.nextLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                row.add(Integer.parseInt(s[j]));
            }
            wall.add(row);
        }
        Solution solution = new Solution();
        System.out.println(solution.leastBricks(wall));
    }
}

class Solution {
    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edges = new HashMap<>();
        for (List<Integer> row : wall) {
            int curr = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                curr += row.get(i);
                edges.put(curr, edges.getOrDefault(curr, 0) + 1);
            }
        }
        int max_edges = 0;
        for (int key : edges.keySet()) {
            max_edges = Math.max(max_edges, edges.get(key));
        }
        return wall.size() - max_edges;
    }
}