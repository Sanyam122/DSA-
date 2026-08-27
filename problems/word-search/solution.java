class Solution {
    public boolean exist(char[][] grid, String word) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visit[][] = new boolean[n][m];

        for( int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if( helper(grid, visit, i, j, n, m, word, 0) ) return true;
            }
        }
        return false;
    };

    private boolean helper(char[][] grid, boolean[][] visit, int i, int j, int n, int m, String word, int index){
        if( index == word.length() )return true;

        if( i < 0 || j < 0 || i >= n || j >= m || visit[i][j] == true ) return false;
        
        if( grid[i][j] != word.charAt(index))return false;
        visit[i][j] = true;
        
       boolean found =  helper(grid, visit, i-1, j, n, m, word, index+1) ||
        helper(grid, visit, i, j-1, n, m, word, index+1) ||
        helper(grid, visit, i, j+1, n, m, word, index+1) ||
        helper(grid, visit, i+1, j, n, m, word, index+1);


        visit[i][j] = false;
        return found;
    }
}