class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 1)return nums[0] == target;
        for( int i = 0; i < nums.length/2 ; i++){
            if( nums[i] == target )return true;
        };
        for( int i = nums.length/2 ; i < nums.length ; i++){
            if( nums[i] == target )return true;
        };
        return false;
    }
}