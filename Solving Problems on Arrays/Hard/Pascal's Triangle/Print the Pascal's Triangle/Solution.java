// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //function to generate the row in the triangle
    public List<Integer> generateRow(int r){
        List<Integer> row = new ArrayList<>();
        row.add(1); //the first element of every row is always 1

        long ans = 1;

        //generate the rest of the elements in the row using combination logic
        for(int col=0; col<r; col++){
            ans = ans*(r-col);
            ans = ans/(col+1);

            row.add((int) ans); //add the computed value to the row
        }

        return row;
    }

    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans = new ArrayList<>();

        //loop through rows from 1 to numRows
        for(int i=1; i<=numRows; i++){
            ans.add(generateRow(i)); //generate the i-th row and add it to the result
        }

        return ans;
    }
}
