import java.util.Arrays;

class Solution{
    public int[] JobScheduling(int[][] jobs){
        //jobs = { id, deadline, profit }
        Arrays.sort(jobs, (a,b) -> (b[2] - a[2]));

        int d = 0;
        for(int[] j : jobs){
            d = Math.max(d, j[1]);
        }

        int[] slots = new int[d];
        Arrays.fill(slots, -1);

        int maxProfit = 0;
        int countJobs = 0;

        for(int[] j : jobs){
            int deadline = j[1];

            for(int i = 1; i <= deadline; i++){
                if(slots[i] == -1){
                    slots[i] = j[0];
                    countJobs++;
                    maxProfit += j[2];
                }
            }
        }

        return new int[]{countJobs, maxProfit};
    }
}