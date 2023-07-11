//Approch 1 Generate all the possible subarrays with sum will run in n^3

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int currSum = 0; // Reset current sum for each subarray

                for (int k = i; k <= j; k++) {
                    currSum += nums[k];
                }

                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }

        return maxSum;
    }
}


//Approch 2  Prefix Sum 
/*store prefix array will store  sum of [ till index] 
 * using the formula 
 * prefixSum[end]-prefixSum[start-1]
 * 
 * and if the start ==0 give only PrefixSum[end] 
 * 
 * TC-->O(N^2)
 * sc-->o(N)
 */

 
class Solution{
    public int maxSubArraySum(int[] nums) {
       int currSum=0;
        int maxSum = Integer.MIN_VALUE;
        int prefixSum[]=new int[nums.length];

        prefix[0]=nums[0];

        for(int i=1;i<prefix.length;i++){
           prefix[i]=prefix[i-1]+nums[i];

        }

        for (int i = 0; i < nums.length; i++) {
            int start=i;
            for (int j = i; j < nums.length; j++) {
                int end=j;
                 currSum = 0; // Reset current sum for each subarray

                currSum=prefix[end]-(start==0?0:prefix[start-1]);
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
                
            }
        }
        
     return maxSum;
    }
}

//Approch 3
// Kadane's Algorithms
/*
iterate through array  maintain currSum and the maxSum
 if the currSum becomes the negative (or<0) make it zero and update only maxSum when currSum>maxSum

  * TC-->O(N)
 * sc-->o(1)

*/ 
class Solution {
    public int maxSubArraySum(int[] nums) {
     int currSum=0;
     int maxSum=Integer.MIN_VALUE;

     for(int i=0;i<nums.length;i++){
        currSum=currSum+nums[i]

        if(currSum<0){
            currSum=0;
        }
        maxSum=Math.max(currSum,maxSum);
     }
    }
}
