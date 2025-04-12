import java.util.Scanner;

public class SwitchCaseConcept {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();

//        if(n==1) {
//            System.out.println("Monday");
//        }
//        else if(n==2) {
//            System.out.println("Tuesday");
//        }
        switch (n) {
            case "Monday":
                System.out.println(1);
                break;
            case "Tuesday":
                System.out.println(2);
                break;
            case "Wednesday":
                System.out.println(3);
                break;
            default:
                System.out.println(0);
        }
    }
}
