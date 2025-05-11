public class StringSplit {
    public static void main(String[] args) {
        String s = "acciojob,kunal,dsa";
       String st[] = s.split(",");

       for(int i=0;i<st.length;i++) {
           System.out.println(st[i]);
       }

    }
}
