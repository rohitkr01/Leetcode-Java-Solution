/*Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed and return the new length .
 
 Example: 
 Input: nums = [3,2,2,3], val = 3
 Output: 2, nums = [2,2,_,_]
 Explanation: Your function should return k = 2, with the first two elements of nums being 2.
              It does not matter what you leave beyond the returned k (hence they are underscores).  */
//Let's code....

class Solution {
    public int removeElement(int[] nums, int val) {
       if(nums.length==0) return 0;
        
        int j =0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}
