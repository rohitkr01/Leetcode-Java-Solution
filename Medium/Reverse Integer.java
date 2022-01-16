class Solution {
    public static int reverse(int x) {
        
        int rev = 0;
          
        while(x!=0){
         int rem=x%10;
            
           x=x/10;
            
if(rev>Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && rem>7))
    return 0;
if(rev<Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && rem<-8))
    return 0;
            rev=rev*10 + rem;
        }
        return rev;
        
    }
    public static void main(String args[]){
    Scanner sc= new Scanner(System.in);
    System.out.print("x = ");
    int x=sc.nextInt();
    
     System.out.print(reverse(x));
    }   
}
