/*
Print all possible subsets of the given array whose sum equal to given N.
example: Input: {1, 2, 3, 4, 5} N=6 Output: {1, 2, 3}, {1, 5}, {2, 4} 
*/

import java.util.*;

class SumofSubsets{
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5};
        int N = 6;
        List<List<Integer>> result = new ArrayList<>();
        findSumOfSubsets(arr, 0, new ArrayList<>(), N, 0, result);
        for(List<Integer> subset: result){
            System.out.println(subset);
        }

    }

    static void findSumOfSubsets(int[] arr, int index, List<Integer> currentSubset, int target, int currentsum, List<List<Integer>> result){

        if(currentsum == target){
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        if(index == arr.length || currentsum > target){
            return;
        }

        currentSubset.add(arr[index]);
        findSumOfSubsets(arr, index + 1, currentSubset, target, currentsum + arr[index], result);

        currentSubset.remove(currentSubset.size() - 1);

        findSumOfSubsets(arr, index + 1, currentSubset, target, currentsum, result);

    }
}