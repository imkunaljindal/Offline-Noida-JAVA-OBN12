import java.util.*;

class StackQueue{

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void Push(int a){
        s1.push(a);
    }

    int Pop()  {

        if(s1.isEmpty()) return -1;
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int data = s2.pop();
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return data;
    }
}

class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackQueue s = new StackQueue();
        int q = scanner.nextInt();

        while (q-- > 0) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int a = scanner.nextInt();
                s.Push(a);
            } else if (queryType == 2) {
                System.out.print(s.Pop() + " ");
            }
        }
    }
}
