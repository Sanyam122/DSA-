class Solution {
    public int numIslands(char[][] grid) {
        int island = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        for( int i = 0; i < grid.length ; i++){
            for( int j = 0; j < grid[0].length; j++ ){

                if( grid[i][j] == '1' && visit[i][j] == false ){
                    helper( grid, visit, i, j, n, m);
                    island++;
                };
            };
        };
        return island;
    };

    private void helper(char[][] grid, boolean[][] visit, int row, int col, int n, int m ){
        if( row < 0 || col < 0 || row >= n || col >= m || grid[row][col] !='1' || visit[row][col] ){
            return;
        };
        visit[row][col] = true;
        helper( grid, visit, row-1, col, n, m);
        helper( grid, visit, row+1, col, n, m);
        helper( grid, visit, row, col+1, n, m);
        helper( grid, visit, row, col-1, n, m);

        return;
    }
}