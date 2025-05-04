public class InsertionSort {

    static void insertionSort(int arr[]) {
        for(int i=1;i<arr.length;i++) {
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

//        for(int i=0;i<arr.length;i++) {
//            System.out.print(arr[i] + " ");
//        }
        for(int x: arr) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        int arr[] = {4,-2,7,1,6,3};

        insertionSort(arr);
//
//        for(int i=0;i<arr.length;i++) {
//            System.out.print(arr[i] + " ");
//        }
    }
}
