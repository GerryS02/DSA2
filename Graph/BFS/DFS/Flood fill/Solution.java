class Solution{
    
    void dfs(int[][] image, int i, int j, int newColor, int orgColor){
        // Stop if:
        // - index goes out of the image
        // - pixel is already the new color
        // - pixel is not the original color
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length ||
            image[i][j] == newColor || image[i][j] != orgColor){
                return;
            }

        image[i][j] = newColor; //change the current pixel to the new color

        dfs(image, i-1, j, newColor, orgColor); //top
        dfs(image, i, j+1, newColor, orgColor); //right
        dfs(image, i, j-1, newColor, orgColor); //left
        dfs(image, i+1, j, newColor, orgColor); //bottom
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color){
        dfs(image, sr, sc, color, image[sr][sc]);

        return image;
    }
}