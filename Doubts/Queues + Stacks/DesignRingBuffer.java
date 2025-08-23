import java.util.*;

class AccioQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor to initialize queue
    public AccioQueue(int k) {
        arr = new int[k];
        capacity = k;
        front = -1;
        rear = -1;
        size = 0;
    }

    // Get front element
    public int Front() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    // Get rear element
    public int Rear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }

    // Insert element
    public boolean enQueue(int value) {
        if (isFull()) return false;

        if (isEmpty()) {
            front = 0;
            rear = 0;
            arr[rear] = value;
        } else {
            rear = (rear + 1) % capacity;
            arr[rear] = value;
        }
        size++;
        return true;
    }

    // Delete element
    public boolean deQueue() {
        if (isEmpty()) return false;

        if (front == rear) {
            // Only one element
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return true;
    }

    // Check empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check full
    public boolean isFull() {
        return size == capacity;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // number of queries
        AccioQueue queue = null;

        for (int i = 0; i < N; i++) {
            int type = sc.nextInt();

            switch (type) {
                case 0: // Initialize
                    int capacity = sc.nextInt();
                    queue = new AccioQueue(capacity);
                    System.out.println("null");
                    break;

                case 1: // Front
                    System.out.println(queue.Front());
                    break;

                case 2: // Rear
                    System.out.println(queue.Rear());
                    break;

                case 3: // enQueue
                    int val = sc.nextInt();
                    System.out.println(queue.enQueue(val));
                    break;

                case 4: // deQueue
                    System.out.println(queue.deQueue());
                    break;

                case 5: // isEmpty
                    System.out.println(queue.isEmpty());
                    break;

                case 6: // isFull
                    System.out.println(queue.isFull());
                    break;

                default:
                    System.out.println("Invalid Query");
            }
        }
        sc.close();
    }
}
