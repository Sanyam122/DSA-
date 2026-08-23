class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visit[] = new boolean[rooms.size()];
        ArrayList<Integer> canBeUnlocked = new ArrayList<>();
        canVisitUtil( rooms,  0, visit, canBeUnlocked );
        for( int i = 0 ; i < visit.length ; i++){
            if(!visit[i]) return false;
        };
        return true;
    };

    public void canVisitUtil(List<List<Integer>> rooms, int curr, boolean[] visit, ArrayList<Integer> canBeUnlocked){
        visit[curr] = true;
        for( int i = 0 ; i < rooms.get(curr).size(); i++){
            int edge = rooms.get(curr).get(i);
            if( !visit[edge] ){
                canBeUnlocked.add(edge);
                canVisitUtil(rooms, edge, visit, canBeUnlocked);
            };
        };
    }
}