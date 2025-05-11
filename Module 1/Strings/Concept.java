import java.util.Locale;

public class Concept {

    public static void main(String[] args) {
//        String s = "hello";
//
//        System.out.println(s);
//        int n = s.length();
//        System.out.println(n);
//
//        char c = 'a';
//        char b = (char) ((int)c-32);
//        System.out.println(b);

//        String s1 = "hello";
//        int n = s1.length();
//
//        // reverse the string
//        String s2 = "";
//        for(int i=n-1;i>=0;i--) {
//            s2 = s2 + s1.charAt(i);
//        }

//        System.out.println(s2);

//        String s1 = "abc";
//        System.out.println(s1.toUpperCase());
//
//        // impl
//        String ans1 = "";
//        for(int i=0;i<s1.length();i++) {
//            ans1 = ans1 + (char)(s1.charAt(i)-32);
//        }
//        System.out.println(ans1);
//
//        String s2 = "ABC";
//        System.out.println(s2.toLowerCase());

//        String a = "abc";
//        String b = "Abc";
//
//        if(a.equalsIgnoreCase(b)) {
//            System.out.println("Equal");
//        }
//        else {
//            System.out.println("Not Equal");
//        }

//        String a = "hello";
//        String b = "hello";

//        String a = new String("hello");
//        String b = new String("hello");

//        if(a == b) {
//            System.out.println("Equal");
//        }
//        else {
//            System.out.println("Not equal");
//        }

//        String s = "hello";
//        System.out.println(s.indexOf('e'));
//        System.out.println(s.lastIndexOf('l'));
//
//        String s1 = "acciojob";
//        System.out.println(s1.substring(1));
//
//        String x = "abc";
//        x = x + "bcd";
//        System.out.println(x);

//        String s = "acciojob";
//        String b = "cci";
//        System.out.println(s.contains("a"));

//        int n = s.length();
//        for(int i=0;i<n;i++) {
//            String str = "";
//            for(int j=i;j<n;j++) {
//                str = str + s.charAt(i);
//                if(str.equals(b)) {
//                    System.out.println("Present");
//                    return;
//                }
//            }
//        }
//        System.out.println("Not Present");

        String s = "hello";
        char a = 'o';
        char b = 'd';
//        System.out.println(s.replace('l','d'));

        String ans = "";
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)==a) {
                ans = ans + b;
            }
            else {
                ans = ans + s.charAt(i);
            }
        }

        System.out.println(ans);

//        String s = 'a' + "";
    }
}
