import java.util.Scanner;

public class ArrayInputOutput {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double arr[] =  new double[3];

        for(int i=0;i<3;i++) {
            arr[i] = sc.nextDouble();
        }

        for(int i=0;i<3;i++) {
            System.out.println(arr[i]);
        }
    }
}
