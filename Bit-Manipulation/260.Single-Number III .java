// --------   260. Single Number III      ------
/*
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

EXAMPLE 1 :
Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer

EXAMPLE 2 :
Input: nums = [0,1]
Output: [1,0]

*/
/*
----------------------  Approach -----------------------

This question can easily solved using some simple bit manipulation in O(n) time and O(1) space.

The solution can be broken into the following parts:

    1.Firstly take a xor of all numbers in nums array, since xor of duplicate numbers is 0 therefore at the end we will be left with the xor of the two distinct numbers.
      So we have xor=a^b; where a and be are the distinct numbers to be found.

    2.Now we will have to divide the array nums in two groups such that a and b are in different groups,
      the reason behind this is that in these groups also all other elements will occur twice except for a and b then we can simply take xor in the respective groups and we will be left with the numbers.

    3.Now we have to find on what basis we can divide these groups.
      We know that there is atleast one set bit in xor because it is obviously not equal to zero.
      We find the last set bit which means there is a 0 at this position in a and a 1 in b. (xor of 0 and 1 is 1).

This becomes the basis of division and we can easily find the numbers with that particular bit as 0(will go in group 1 with a) and numbers with bit as 1(will go in group 2 with b).

Below is the Java code with Comments.

*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0; // this will provide us the xor of the two distict numbers.
           for(int n:nums){
            xor=xor^n;
               }

        int set_bit=0; // this finds the last set bit of xor.
        
        for(int i=0;i<32;i++){
            if((xor&(1<<i))!=0){
                set_bit=1<<i;
            }
        }
        
        int[] ans=new int[2];// to divide nums into two groups which will eventually contain the required distinct numbers.
        
        for(int n:nums){
            if((n&set_bit)==0){
                ans[0]^=n;
            }else{
                ans[1]^=n;
            }
        }
        
        return ans;
        
    }
	}

/*
  Time Complexity : O(n)
  Space Complexity :  O(1)  Constant Space
  
 */
