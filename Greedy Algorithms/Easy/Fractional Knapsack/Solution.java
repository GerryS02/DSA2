import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution{
    public double fractionalKnapsack(long[] val, long[] wt, long capacity){
        double ans = 0.0;

        //create list to store {value, weight}
        List<long[]> items = new ArrayList<>();

        for(int i=0; i<val.length; i++){
            items.add(new long[]{val[i], wt[i]});
        }

        //sort items based on value/weight ratio (descending)
        Collections.sort(items, (a,b) ->{
            double r1 = (double) a[0]/a[1];
            double r2 = (double) b[0]/b[1];

            return Double.compare(r2, r1);
        });

        for(int i=0; i<items.size(); i++){

            long value = items.get(i)[0];
            long weight = items.get(i)[1];

            if(capacity >= weight){
                ans += value;
                capacity -= weight;
                continue;
            }

            double valPerWeight = (double) value/weight;
            ans += valPerWeight * capacity;
            capacity = 0;
            break;
        }

        return ans;
    }
}