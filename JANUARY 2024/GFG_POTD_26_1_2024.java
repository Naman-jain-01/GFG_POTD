package JANUARY;

import java.util.*;
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class Pair
{
    private final double ratio;
    private final int index;

    public Pair(double ratio, int index) {
        this.ratio = ratio;
        this.index = index;
    }

    public double getRatio() {
        return ratio;
    }

    public int getIndex() {
        return index;
    }
}
class Solution26 {
    double fractionalKnapsack(int W, Item[] arr, int n) {

        ArrayList<Pair> ratiolist=new ArrayList<>();

        for (int i = 0; i < n; i++) {

            double ratio = (double) arr[i].value / arr[i].weight;
            Pair p=new Pair(ratio,i);
            ratiolist.add(p);
        }
        ratiolist.sort(Comparator.comparingDouble(Pair::getRatio).reversed());

        int currwt=0;
        double profit=0;

        for(int i=0;i<n;i++)
        {
            int index = ratiolist.get(i).getIndex();

            if(currwt + arr[index].weight <=W)
            {
                currwt+=arr[index].weight;
                profit+=arr[index].value;
            }

            else {
                int remain=W-currwt;
                profit+=ratiolist.get(i).getRatio()*((double) remain);
            }
        }
        return profit;
    }
}
