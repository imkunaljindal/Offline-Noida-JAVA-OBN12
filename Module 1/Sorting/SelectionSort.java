public class SelectionSort {

    static void selectionSort(int arr[]) {
        int n = arr.length;
        for(int i=0;i<n;i++) {
            int minIdx = i;
            for(int j=i+1;j<n;j++) {
                if(arr[j]<arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {-6,-3,-7,-9,1,4};
        selectionSort(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
