public class FinallyConcept {
    public static void main(String[] args) {
        System.out.println("A");
        try {
            System.out.println("B");
            int x = 5/2;
            System.out.println("C");

        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("E");
        }
        finally {
            System.out.println("F");
        }

        try{
            int arr[] = new int[5];
            arr[10] = 5;
        }
        catch (Exception e) {
            System.out.println("G");
        }
        finally {
            System.out.println("H");
        }
        System.out.println("D");
    }
}
