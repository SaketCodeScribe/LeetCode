import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        int i, n = prices.size(), mi = prices.get(0);
        long profit = 0;

        for(i=1; i<n; i++){
            profit = Math.max(profit, prices.get(i)-mi);
            mi = Math.min(mi, prices.get(i));
        }
        return (int)profit;
    }
}