package Problems;

import java.util.*;

public class TargetSubsetSums {
    public static ArrayList<ArrayList<Integer>> findSubsets(int[] arr, int tar) {
        // write code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subsSet = new ArrayList<>();
        helper(arr,tar,0,ans,subsSet);
        return ans;
    }

    static void helper(int arr[], int tar, int idx, ArrayList<ArrayList<Integer>> ans,
                       ArrayList<Integer> subSet) {
        if(tar==0 && !ans.contains(subSet)) {
            ans.add(new ArrayList<>(subSet));
            return;
        }
        if(tar<0 || idx >= arr.length) return;

        subSet.add(arr[idx]);
        helper(arr,tar-arr[idx],idx+1,ans,subSet);
        subSet.remove(subSet.size()-1);
        helper(arr,tar,idx+1,ans,subSet);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, tar;
        n = sc.nextInt();
        tar = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        ArrayList<ArrayList<Integer>> subsets = findSubsets(arr, tar);
        Collections.sort(subsets, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        if (subsets.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < subsets.size(); i++) {
                for (int j = 0; j < subsets.get(i).size(); j++)
                    System.out.print(subsets.get(i).get(j) + " ");
                System.out.println();
            }
        }
        sc.close();
    }
}