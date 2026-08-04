class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for( int n : nums ){
            min = Math.min(min,n);
            max = Math.max(max,n);
            set.add(n);
        };

        for( int i = min ; i <= max; i++){
            if( !set.contains(i) )ls.add(i);
        };

        return ls;
    }
}