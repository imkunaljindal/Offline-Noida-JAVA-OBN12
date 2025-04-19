package Functions;

import java.util.Scanner;

public class BinaryToDecimal {
    public static long binaryToDecimal(long binaryNumber) {
        long ans = 0;
        long mul = 1;
        while (binaryNumber != 0) {
            long lastBit = binaryNumber % 10;
            ans = ans + lastBit * mul;
            mul = mul * 2;
            binaryNumber = binaryNumber/10;
        }

        return ans;
    }

    // decimal to binary

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long binaryNumber = scanner.nextInt();
        System.out.println(binaryToDecimal(binaryNumber));
        scanner.close();
    }
}
