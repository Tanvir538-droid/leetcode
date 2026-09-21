

class Solution {
    public int[][] fillTheNumber(int[][] image,int sr,int sc,int color,int original){
        
        if (original==color) {
            return image;
        }
        if (image[sr][sc]!=original) {
            return image;
        }
        image[sr][sc] = color;
        if (sr<image.length-1) {
            fillTheNumber(image, sr+1, sc, color,original);
        }
        
        if (sr>0) {
            fillTheNumber(image, sr-1, sc, color,original);
        }
        if (sc<image[0].length-1) {
            fillTheNumber(image, sr, sc+1, color,original);
        }
        
        if (sc>0) {
            fillTheNumber(image, sr, sc-1, color,original);
        }
        
        return  image;

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        return fillTheNumber(image, sr, sc, color, original);
    }
}