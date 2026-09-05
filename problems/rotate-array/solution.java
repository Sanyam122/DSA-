class Solution {
    public void rotate(int[] nums, int k) {
        
        k = k % nums.length;
        int l = 0, r = nums.length - 1;
        while( l <= r ){
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r--;
        };
        l =0;
        r = k-1;
        while( l < r ){
         
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r--;
        }
        r = nums.length - 1;
        l = k;
         while( l < r ){
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r--;
        }
        
    }
}