//  Brute-force method

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int w = 1; w < nums.length; w++){
            for (int x = w; x < nums.length; x++){
                if (nums[x] == target - nums[x-w]){
                    return new int[]{x-w, x};
                }
            }
        }
        return null;
    }
}
