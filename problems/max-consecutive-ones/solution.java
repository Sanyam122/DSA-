class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0,  track = 0;
        for( int n : nums ){
            
            if( n == 1 ){
                track++;
            };
            if( n != 1){
                ans = Math.max( track, ans);
                track = 0;
            }
        };
        ans = Math.max(ans,track);
        return ans;
    }
}