class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public void dfs( int[][] image, int i , int j, int orgColor, int newColor){
        if( i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] == newColor || image[i][j] != orgColor){
            return ;
        };
        image[i][j] = newColor;

        dfs( image, i, j+1, orgColor, newColor);
        dfs( image, i+1, j, orgColor, newColor);
        dfs( image, i-1, j, orgColor, newColor);
        dfs( image, i, j-1, orgColor, newColor);
    };
}