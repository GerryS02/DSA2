class Solution {
    public int candy(int[] ratings) {
        int candies = 1;        //give 1 candy to the first child
        int i = 1;              //start checking from the second child
        int n = ratings.length; //total number of children

        while(i<n){
            //children with equal ratings -> they just get 1 candy
            if(ratings[i] == ratings[i-1]){
                candies++;  //add 1 candy

                i++;
            }

            //handle upward slope (ratings increasing)

            int peak = 1;   //start of upward slope, first child counts as 1

            while(i<n && ratings[i] > ratings[i-1]){
                peak++;             //increase candy for each higher child
                candies += peak;    //add to total

                i++;
            }

            //handle downward slope (ratings decreasing)

            int down = 1;   //start of downward ratings

            while(i<n && ratings[i] < ratings[i-1]){
                candies += down;    //add candy to total
                down++;             //next child gets more if slope continues

                i++;
            }

            //if downward slope is longer than upward slope -> ensure that the peak child has more candies than neighbors
            if(down > peak) candies += down - peak;
        }

        return candies; //return total candies
    }
}