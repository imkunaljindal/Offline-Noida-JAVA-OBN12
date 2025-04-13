import java.util.Scanner;

public class CountNumberOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;
        while (n!=0) {
            int lastDig = n % 10;
            //System.out.println(lastDig);
            count++;
            n = n / 10;
        }
        System.out.println(count);
    }
}
