import java.util.*;

class Queue {
    int arr[];
    int front, rear, len;
    //Write your code here
    public Queue() {
        //Write your code here
        arr = new int[1000];
        front = -1;
        rear = -1;
        len = 0;
    }

    public void push(int newElement) {
        rear++;
        arr[rear] = newElement;
        len++;
    }
    public int pop() {
        if(len == 0) return -1;

        len--;
        front++;
        return arr[front];

    }
    public int front() {
        //Write your code here
        if(len == 0) return -1;

        return arr[front + 1];
    }
    public int size() {
        //Write your code here
        return len;
    }
}
public class QueueUsingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if(op == 1) {
                int x = sc.nextInt();
                q.push(x);
            }
            else if(op == 2) {
                System.out.println(q.pop());
            }
            else if(op == 3)
                System.out.println(q.front());
            else if(op == 4)
                System.out.println(q.size());
        }
    }
}