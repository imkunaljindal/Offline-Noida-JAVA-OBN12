import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = sc.next();
        int k = sc.nextInt();
        sc.close();
        Node tree = levelOrderCreateTree(arr);
        System.out.println(timeToBurnTree(tree, k));
    }

    public static void getChildParentMap(Node root, Map<Node, Node> childToParentMap) {
        if(root==null) return;

        if(root.left!=null) {
            childToParentMap.put(root.left,root);
        }
        if(root.right!=null) {
            childToParentMap.put(root.right,root);
        }

        getChildParentMap(root.left,childToParentMap);
        getChildParentMap(root.right,childToParentMap);
    }

    public static Node findNode(Node root, int target) {
        if(root==null) return null;

        if(root.data==target) return root;

        Node leftSub = findNode(root.left,target);
        if(leftSub!=null) return leftSub;

        Node rightSub = findNode(root.right,target);
        return rightSub;
    }

    public static int timeToBurnTree(Node root, int start) {

        Map<Node, Node> childToParentMap = new HashMap<>();
        getChildParentMap(root,childToParentMap);

        Node startNode = findNode(root,start);

        Queue<Node> q = new ArrayDeque<>();
        int time = -1;
        Set<Node> vis = new HashSet<>();

        q.add(startNode);
        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i=0;i<sz;i++) {
                Node currNode = q.poll();
                vis.add(currNode);

                if(currNode.left!=null && !vis.contains(currNode.left)) {
                    q.add(currNode.left);
                }
                if(currNode.right!=null && !vis.contains(currNode.right)) {
                    q.add(currNode.right);
                }
                if(childToParentMap.containsKey(currNode)) {
                    Node parent = childToParentMap.get(currNode);
                    if(!vis.contains(parent)) {
                        q.add(parent);
                    }
                }
            }
            time++;
        }
        return time;
    }

    static void createTree(Node node, int i, String[] arr) {
        if (node != null) {
            if (2 * i + 1 < arr.length) {
                if (arr[2 * i + 1].equals("null")) {
                    node.left = null;
                } else {
                    node.left = new Node(Integer.parseInt(arr[2 * i + 1]));
                }
                createTree(node.left, 2 * i + 1, arr);
            }
            if (2 * i + 2 < arr.length) {
                if (arr[2 * i + 2].equals("null")) {
                    node.right = null;
                } else {
                    node.right = new Node(Integer.parseInt((arr[2 * i + 2])));
                }
                createTree(node.right, 2 * i + 2, arr);
            }
        }
    }

    static Node levelOrderCreateTree(String[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(
                Integer.parseInt(arr[0])
        );
        createTree(head, 0, arr);
        return head;
    }
}

class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
