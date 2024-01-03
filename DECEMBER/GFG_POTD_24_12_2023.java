package DECEMBER;


import java.util.*;


class Solution {

    class Pair
    {
        int Price;
        int Day;

        public Pair(int price, int day) {
            Price = price;
            Day = day;
        }

        public int getPrice() {
            return Price;
        }

        public int getDay() {
            return Day;
        }
    }
    public int buyMaximumProducts(int n, int k, int[] price)
    {
        ArrayList<Pair> price_day=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            price_day.add(new Pair(price[i],i+1));
        }

        price_day.sort(Comparator.comparingInt(Pair::getPrice));

        int max_stocks=0;
        for (int i = 0; i < n; i++) {
            int currPrice=price_day.get(i).getPrice();
            int currDay=price_day.get(i).getDay();

            int purchase=Math.min(k/currPrice,currDay);
            k-=purchase*currPrice;
            max_stocks+=purchase;
        }
        return max_stocks;
    }
}

