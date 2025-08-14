import java.util.*;
public class Main {
    static String intToRoman(int num){
        String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hdrs[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String thds[] = {"","M","MM","MMM"};

        return thds[num/1000] + hdrs[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(intToRoman(n));
    }
}