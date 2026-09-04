class Solution {
    public int maxNumberOfBalloons(String text) {
        if(text.length() < 6)return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for( char ch : text.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) +1);
        };
       if (!map.containsKey('b') || map.get('b') < 1 ||
           !map.containsKey('a') || map.get('a') < 1 ||
           !map.containsKey('l') || map.get('l') < 2 ||
           !map.containsKey('o') || map.get('o') < 2 ||
           !map.containsKey('n') || map.get('n') < 1) return 0;

        int af = map.get('a'), bf = map.get('b'), lf = map.get('l'), of = map.get('o'), nf = map.get('n');
        int count = 0;
        while( true ){
            if( bf < 1 || af < 1 || lf < 2 || of < 2 || nf < 1 )break;
            bf -= 1;
            af -= 1;
            lf -= 2;
            of -= 2;
            nf -= 1;
            count++; 
        };
        return count;   
    }
}