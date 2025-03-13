/*
You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].

For each queries[i]:

Select a subset of indices within the range [li, ri] in nums.
Decrement the values at the selected indices by 1.
A Zero Array is an array where all elements are equal to 0.

Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.

 

Example 1:

Input: nums = [1,0,1], queries = [[0,2]]

Output: true

Explanation:

For i = 0:
Select the subset of indices as [0, 2] and decrement the values at these indices by 1.
The array will become [0, 0, 0], which is a Zero Array.
*/

class LT_isZeroArray{
    public static void main(String args[]){
        int[] nums = {1,0,1};
        int[][] queries = {{0,2}};
        System.out.println(isZeroArray(nums, queries));
    }
    static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for(int[] query : queries){
            diff[query[0]]--;
            diff[query[1] + 1]++;
        }
        int currentDecrement = 0;
        for(int i = 0; i < n; i++){
            currentDecrement+=diff[i];
            if(nums[i] + currentDecrement > 0) return false;
        }
        return true;
    }
}