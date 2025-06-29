import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}

class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Node head=null;
        Node phead=null;
        int n=sc.nextInt();
        while(n-->0){
            int n1=sc.nextInt();
            if(head==null)
                head=new Node(n1);
            else
                addHead(head,n1);
        }
        int m=sc.nextInt();
        while(m-->0){
            int n1=sc.nextInt();
            if(phead==null)
                phead=new Node(n1);
            else{
                addHead(phead,n1);
            }
        }
        Solution g=new Solution();
        System.out.println(g.multiplyLists(head,phead));
    }

    public static void addHead(Node node,int a) {
        if (node == null)
            return;
        if(node.next==null)
            node.next=new Node(a);
        else
            addHead(node.next,a);
    }
}

class Solution{
    public long multiplyLists(Node l1,Node l2){
        int mod = 1000000007;
        long num1 = 0;
        Node curr1 = l1;

        while(curr1!=null) {
            num1 = (num1*10 + curr1.data)%mod;
            curr1 = curr1.next;
        }

        long num2 = 0;
        Node curr2 = l2;
        while(curr2!=null) {
            num2 = (num2*10 + curr2.data)%mod;
            curr2 = curr2.next;
        }
        long ans = (num1*num2)%mod;
        return ans;
    }
}
