import java.util.HashMap;
import java.util.Map;

public class CountFrequency {

    public static void main(String[] args) {
        int arr[] = {4,3,1,2,3,4,5,5,0,2,3};

        Map<Integer,Integer> freqMap = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
//            if(!freqMap.containsKey(arr[i])) {
//                freqMap.put(arr[i],1);
//            }
//            else {
//                int currFreq = freqMap.get(arr[i]);
//                freqMap.put(arr[i],currFreq+1);
//            }
            int value = freqMap.getOrDefault(arr[i],0);
            freqMap.put(arr[i],value+1);
        }

        for(int key: freqMap.keySet()) {
            System.out.println(key + " -> "+freqMap.get(key));
        }


    }
}
