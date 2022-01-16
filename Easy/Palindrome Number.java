class Solution {
    
    public static boolean isPalindrome(int num) {
        int val = num;
        if(num<0){
           return false;
        } 

             int rev =0;
            while(num !=0){
                rev = rev *10 + num%10 ;
                num = num/10;
            } 
               
     return rev == val;       
    }   
}
