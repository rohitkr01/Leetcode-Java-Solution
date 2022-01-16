class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int[] result = new int[n1 + n2];
        
        System.arraycopy(nums1,0,result , 0 ,n1);
        System.arraycopy(nums2 , 0,result,n1,n2);
        
        Arrays.sort(result);
        int n = result.length;
        
        double  median = 0.0;
        if(n%2==0){
            median = result[n/2]+ result[n/2 - 1];
            median = median / 2;
        }
        else{
            median = result[n/2];
        }
        return median;
    }
}
