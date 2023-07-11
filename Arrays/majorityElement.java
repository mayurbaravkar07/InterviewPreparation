/*/* 
Moore's voting Algorithm:-
1] work by voting and devoting the elements
2] we start for index one and count the occurences 
3]if the element is same we increase the votes
4] if the votes are not the same then we decrease the votes
5] if votes becomes zero then we pick new voter element
6] at the end of the array if voter has at least one vote then that element is eligible for the majority element
7]we check the occurences in the array by reiterating if it's count >N/2 then it is majority element
8]else return -1 majority element is not found as 7th check not important because they said assume there will 
be always majority element is present in the array


*/ 

//TC-O(N)
//SC==O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int majorityElementIdx=0;
        int n=nums.length;
        int count=1;
        for(int index=1;index<nums.length;index++){
            if(nums[majorityElementIdx]==nums[index]){
                count++;
            }else{
                count--;
            }
            if(count==0){
                majorityElementIdx=index;
                count =1;
            }
        }
      if(isMajorityElement(nums,majorityElementIdx,n)){
          return nums[majorityElementIdx];
      }
      return -1;
    }
    boolean isMajorityElement(int nums[],int majorityElementIdx,int n){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==nums[majorityElementIdx]){
                count++;
            }
        }
        if(count>n/2){
            return true;
        }
        return false;
    }
}