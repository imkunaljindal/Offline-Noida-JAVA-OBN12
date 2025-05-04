public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {30,40,10,20};

        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(swapped==false) {
                break;
            }
        }

        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
