class Solution {
  public int findNumbers(int[] nums) {
   int count=0;
   for(int i = 0 ; i<nums.length ;i++){
      count += String.valueOf(nums[i]).length() % 2 == 0 ? 1 : 0;
     }
   return count;
  }
}
