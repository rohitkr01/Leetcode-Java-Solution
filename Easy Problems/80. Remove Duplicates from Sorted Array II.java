class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        
        int indx = 2;
        for(int i = 2 ; i < nums.length ; i++){
            if(nums[i] != nums[indx-2]){
                nums[indx]=nums[i];
                indx++;
            }
        }
         return indx;
    }
}
