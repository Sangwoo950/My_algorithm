class Solution {
    public long solution(int price, int money, int count) {
        long totalCost = (long) price * count * (count + 1) / 2;
        long shortfall = totalCost - money;
        return shortfall > 0 ? shortfall : 0;
    }
}