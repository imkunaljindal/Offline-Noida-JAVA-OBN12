import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Concept {
    public static void main(String[] args) {
       // Queue<Integer> q = new ArrayDeque<>();

        Deque<Integer> dq = new ArrayDeque<>();

        dq.addFirst(10);
        dq.addFirst(20);
        dq.addLast(30);
        dq.addFirst(40);
        System.out.println(dq.pollLast());
        System.out.println(dq.peekFirst());
        System.out.println(dq.pollFirst());

//        q.offer(10);
//        q.offer(30);
//
//        System.out.println(q.poll());
//        System.out.println(q.peek());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
    }
}
