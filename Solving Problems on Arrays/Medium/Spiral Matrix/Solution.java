// Given an m x n matrix, return all elements of the matrix in spiral order(clockeise).

// left->right, top->bottom, right->left, bottom->top

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> ans = new ArrayList<>();

        int m = matrix.length; //number of rows
        int n = matrix[0].length; //number of columns

        int minRow = 0; //top boundry
        int minCol = 0; //left boundry
        int maxRow = m-1; //bottom boundry
        int maxCol = n-1; //right boundry

        int count = 0; //count of elements we've added to the result
        int totalEle = m*n; //total number of elements in the matrix

        //while we haven't added all elements to the result
        while(count < totalEle){
            //top (left->right)
            for(int i=minRow, j=minCol; j<=maxCol && count<totalEle; j++){
                ans.add(matrix[i][j]);
                count++;
            }
            minRow++; //move the top boundary down

            //right (top->bottom)
            for(int i=minRow, j=maxCol; i<=maxRow && count<totalEle; i++){
                ans.add(matrix[i][j]);
                count++;
            }
            maxCol--; //move the right boundary left

            //bottom (right->left)
            for(int i=maxRow, j=maxCol; j>=minCol && count<totalEle; j--){
                ans.add(matrix[i][j]);
                count++;
            }
            maxRow--; //move the bottom boundary up

            //left (bottom->top)
            for(int i=maxRow, j=minCol; i>=minRow && count<totalEle; i--){
                ans.add(matrix[i][j]);
                count++;
            }
            minCol++; //move the left boundary right
        }

        return ans;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(spiralOrder(matrix));
    }
}
