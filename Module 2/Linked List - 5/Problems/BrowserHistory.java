import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String homepage = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        BrowserHistory browserHistory = new BrowserHistory(homepage);
        for(int i = 0; i < n; i++) {
            String q = sc.nextLine();
            String[] query = q.split("\\s+");
            if(query[0].equals("visit")){
                browserHistory.visit(query[1]);
            } else if(query[0].equals("back")){
                browserHistory.back(Integer.parseInt(query[1]));
            } else if(query[0].equals("forward")){
                browserHistory.forward(Integer.parseInt(query[1]));
            }
        }
    }
}

class Node {
    String url;
    Node next;
    Node prev;

    public Node(String url) {
        this.url = url;
    }
}

class BrowserHistory {
    Node curr;
    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }
    public void visit(String url) {
        Node newNode = new Node(url);
        this.curr.next = newNode;
        newNode.prev = this.curr;
        this.curr = newNode;
    }
    public void back(int steps) {
        while(curr.prev!=null && steps > 0) {
            this.curr = this.curr.prev;
            steps--;
        }
        System.out.println(curr.url);
    }
    public void forward(int steps) {
        while(curr.next!=null && steps > 0) {
            this.curr = this.curr.next;
            steps--;
        }
        System.out.println(curr.url);
    }
}