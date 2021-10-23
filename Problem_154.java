import java.util.*;

class Solution {
    public int findMin(int[] nums) {
        int low=0, high=nums.length-1;
        while(low<high){
            int midIndex=low+(high-low)/2;
            if(nums[midIndex]>nums[high]){
                low=midIndex+1;
            }else if(nums[midIndex]<nums[high]){
                high=midIndex;
            }else{
                //handle repetition
                high--;
            }
        }

        return nums[high];
    }
}