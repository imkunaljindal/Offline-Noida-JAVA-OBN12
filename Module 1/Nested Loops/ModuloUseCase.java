public class ModuloUseCase {

    public static void main(String[] args) {
        int x = 373;

        int lastDigit = x%10;

        int lastTwoDig = x%100;

        System.out.println(lastDigit);
        System.out.println(lastTwoDig);
    }
}
