class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length; 
        int left = 0 , right = 0;

        while( right < nums.length ){
            int count = 1;
            
            while( right + 1 < nums.length && nums[ right ] == nums[ right + 1] ){
                count++;
                right++;
            };
            for( int i = 1 ; i <= Math.min(2, count); i++){
                nums[ left ] = nums[ right ];
                left++;
            };

            right++;
        };
        return left;
    }
}