/*
15. 3Sum 
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    for(int i = 0; i < nums.length-2; i++) {
        if(i > 0 && (nums[i] == nums[i-1])) continue; // avoid duplicates
        for(int j = i+1, k = nums.length-1; j<k;) {
            if(nums[i] + nums[j] + nums[k] == 0) {
                list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                j++;k--;
                while((j < k) && (nums[j] == nums[j-1]))j++;// avoid duplicates
                while((j < k) && (nums[k] == nums[k+1]))k--;// avoid duplicates
            }else if(nums[i] + nums[j] + nums[k] > 0) k--;
            else j++;
        }
    }
    return list;
    }
}
