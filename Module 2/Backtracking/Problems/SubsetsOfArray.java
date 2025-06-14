package Problems;

import java.lang.reflect.Array;
import java.util.*;

class SubsetsOfArray{

    public static void sort2DArrayList(ArrayList<ArrayList<Integer>> list) {
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> sublist1, ArrayList<Integer> sublist2) {
                // Compare values up to the minimum of their sizes
                int minLength = Math.min(sublist1.size(), sublist2.size());
                for (int i = 0; i < minLength; i++) {
                    int valueComparison = Integer.compare(sublist1.get(i), sublist2.get(i));
                    if (valueComparison != 0) {
                        return valueComparison;
                    }
                }

                // If values are the same, compare sizes
                return Integer.compare(sublist1.size(), sublist2.size());
            }
        });
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] arr, int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subSet = new ArrayList<>();
        helper(arr,0,ans,subSet);
        return ans;
    }

    static void helper(int arr[], int idx, ArrayList<ArrayList<Integer>> ans,
    ArrayList<Integer> subSet) {
        if(idx>=arr.length){
            ans.add(new ArrayList<>(subSet));
            return;
        }

        subSet.add(arr[idx]);
        helper(arr,idx+1,ans,subSet); //include
        subSet.remove(subSet.size()-1);
        helper(arr,idx+1,ans,subSet);
    }

    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            int []A=new int[n];
            for(int i=0;i<n;i++){
                A[i]=sc.nextInt();
            }

            Arrays.sort(A);
            ArrayList <ArrayList<Integer>> res = subsets(A,n);

            sort2DArrayList(res);

            for (int i = 0; i < res.size (); i++)
            {
                for (int j = 0; j < res.get(i).size (); j++)
                {
                    System.out.print(res.get(i).get(j)+" ");
                }
                System.out.println();

            }
        }
    }
}