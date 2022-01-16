public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null){
            return false;
        }
        
        int len = nums.length;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < len; i++){
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
