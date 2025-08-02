import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Solution ob =new Solution();
        ob.evaluation(exp);
    }
}

// 46-
// 4-6

class Solution{

    static boolean isOperator(char c) {
        return (c=='+' || c=='-' || c=='/' || c=='*');
    }

    static int calculate(int op1, int op2, char operand) {
        if(operand=='+') return op1+op2;
        if(operand=='-') return op1-op2;
        if(operand=='*') return op1*op2;
        return op1/op2;
    }

    static void solve(String exp) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<exp.length();i++) {
            char c = exp.charAt(i);
            if(isOperator(c)) {
                int op2 = st.pop();  // 6
                int op1 = st.pop(); // 4
                st.push(calculate(op1,op2,c));  //4-6
            }
            else {
                //operand
                st.push(c-'0');
            }
        }
        System.out.println(st.pop());
    }

    // 264*8/+3-  -> (4*6)
    static void postfixToInfix(String exp) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<exp.length();i++) {
            char c = exp.charAt(i);
            if(isOperator(c)) {
                String op2 = st.pop();  // 6
                String op1 = st.pop(); // 4
                st.push("(" + op1 + c + op2 + ")");
            }
            else {
                //operand
                st.push(c + "");
            }
        }
        System.out.println(st.pop());
    }

    static void postfixToPrefix(String exp) {
        Stack<String> st = new Stack<>();

        for(int i=0;i<exp.length();i++) {
            char c = exp.charAt(i);
            if(isOperator(c)) {
                String op2 = st.pop();
                String op1 = st.pop();
                st.push(c + op1 + op2);
            }
            else {
                st.push(c+"");
            }
        }

        System.out.println(st.pop());
    }

    public void evaluation(String exp){
        solve(exp);
        postfixToInfix(exp);
        postfixToPrefix(exp);
    }
}                         