class Solution {
 public int[] findOrder(int v, int[][] edges) {
    int[][] adj = buildAdj(edges, v);
    if( checkCycle(adj , v) ) return new int[0];   
    int ans[] = new int[v];                         
    boolean visit[] = new boolean[v];
    Stack<Integer> stack = new Stack<>();
    
    for( int i = 0 ; i < v ; i++ ){
        if( !visit[i]){
            topSort(adj, i, visit, stack);
        }
    };
    int i = 0;
    while( !stack.isEmpty() ){
        ans[i] = stack.pop();
        i++;
    };
    return ans;
};

    public int[][] buildAdj(int[][] edges, int v){
        int[] outDegree = new int[v];
        for( int[] e : edges ){
            outDegree[e[1]]++;
        }
        int[][] adj = new int[v][];
        for( int i = 0 ; i < v ; i++ ){
            adj[i] = new int[outDegree[i]];
        }
        int[] fillIdx = new int[v];
        for( int[] e : edges ){
            int a = e[0], b = e[1];
            adj[b][fillIdx[b]] = a;
            fillIdx[b]++;
        }
        return adj;
    }

    public void topSort(int[][] edges, int curr, boolean[] visit, Stack stack){
        visit[curr] = true;
        for( int i = 0; i < edges[curr].length ; i++){
            int node = edges[curr][i];
            if( !visit[node]){
                topSort(edges, node, visit, stack);
            };
        };
        stack.push(curr);
    }
    public boolean checkCycle(int[][] edges, int v){
        boolean visit[] = new boolean[v];
        boolean reqStack[] = new boolean[v];

        for( int i = 0; i < v ; i ++){
            if( !visit[i]){
                if( checkCycleUtil( edges, i, visit, reqStack, v) ) return true;
            };
        };
        return false;
    }
    public boolean checkCycleUtil(int[][] edges, int curr, boolean[] visit, boolean[] reqStack, int v){
        visit[curr] = true;
        reqStack[curr] = true;

        for( int i = 0; i < edges[curr].length; i++ ){
            int node = edges[curr][i];
            if( !visit[node] ){
                if(checkCycleUtil(edges, node, visit, reqStack, v)) return true;
            }else if( reqStack[node] ){
                return true;
            }
        }

        reqStack[curr] = false;
        return false;
    }
}