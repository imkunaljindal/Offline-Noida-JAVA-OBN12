import java.util.*;

public class Main {

    public static List<Integer> asteroidCollision(int[] asteroids) {
           // write your code here
           Stack<Integer> st = new Stack<>();

            for (int asteroid : asteroids) {
                if (asteroid > 0) {
                    // Positive value -> asteroid moving to the right
                    // Right-moving asteroids are always safe to push
                    st.push(asteroid);
                } else {
                    // Negative value -> asteroid moving to the left
                    // Now we check possible collisions with right-moving asteroids on top of the stack

                    // Destroy smaller right-moving asteroids until:
                    //   - Stack is empty, OR
                    //   - Top asteroid is moving left, OR
                    //   - Top asteroid is bigger or equal in size
                    while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroid)) {
                        st.pop(); // Right-moving asteroid destroyed
                    }

                    // If top asteroid is same size but opposite direction -> both destroyed
                    if (!st.isEmpty() && st.peek() > 0 && st.peek() == Math.abs(asteroid)) {
                        st.pop(); // Remove the right-moving asteroid, left asteroid also vanishes
                    }

                    // If top asteroid is bigger -> left asteroid destroyed (do nothing)
                    else if (!st.isEmpty() && st.peek() > 0 && st.peek() > Math.abs(asteroid)) {
                        continue; // Skip pushing the left asteroid
                    }

                    // Otherwise -> push the left asteroid (safe because no collision possible)
                    else {
                        st.push(asteroid);
                    }
                }
            }

            // Convert stack to list in correct order
            List<Integer> ans = new ArrayList<>();
            while (!st.isEmpty()) {
                ans.add(st.pop());
            }
            Collections.reverse(ans); // Because stack pops in reverse order

            return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] asteroids = new int[n];

        for (int i = 0; i < n; i++) {
            asteroids[i] = scanner.nextInt();
        }

        List<Integer> ans = asteroidCollision(asteroids); 

        if(ans.size()==0){
             System.out.print(-1);
        }else{
              for (int asteroid : ans) {
                 System.out.print(asteroid + " ");
              }
        }
    }
}
