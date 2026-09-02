class Solution {
    public String reorganizeString(String s) {
        if(s.length() == 1)return s;
        if(s.length() == 2 && s.charAt(0) == s.charAt(1) )return "";
        Map<Character,Integer> map = new HashMap<>();
        for( char ch : s.toCharArray()){
            map.put( ch, map.getOrDefault(ch,0) +1 );
        };
        for( int n : map.values()){
            if( n > (s.length() + 1)/2) return "";
        }
        PriorityQueue<Map.Entry<Character,Integer>> maxh = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());
        maxh.addAll(map.entrySet());
        StringBuilder ans = new StringBuilder();
        Map.Entry<Character,Integer> prev = null;
        while( !maxh.isEmpty() ){
            Map.Entry<Character,Integer> curr = maxh.poll();
            ans.append(curr.getKey());
            curr.setValue(curr.getValue() - 1); 
            if( prev != null && prev.getValue() > 0){
                maxh.offer(prev);
            };
            prev = curr;
        };
        return ans.toString();
    }
}