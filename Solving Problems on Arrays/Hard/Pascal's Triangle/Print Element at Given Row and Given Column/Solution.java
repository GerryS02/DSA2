// Given a row index r and a column index c, print the element at the rth row and cth column 
// in Pascal’s Triangle

// using C(r, c) = r!/(c! *(r-c)!)

public class Solution {
    //Function to compute nCr (n = row, r = col)
    public static int combination(int row, int col){
        long res = 1; //long to prevent overflow during calculation

        for(int i=0; i<col; i++){
            res = res * (row-i); //calculate the top part
            res = res/(i+1); //the bottom part
        }

        return (int) res;
    }

    public static void main(String[] args) {
        int row = 5;
        int col = 2;

        int value = combination(row, col);
        System.out.println("Value at row " + row + ", column " + col + " is: " + value);
    }
}
