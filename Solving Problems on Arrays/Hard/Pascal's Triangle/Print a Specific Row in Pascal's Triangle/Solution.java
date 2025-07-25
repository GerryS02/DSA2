import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> generateRow(int r){
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

    public static void main(String[] args){
        int row = 5;

        List<Integer> resRow = generateRow(row);

        System.out.println(resRow);
    }
}
