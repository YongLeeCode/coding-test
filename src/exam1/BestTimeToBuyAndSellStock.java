package exam1;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int result = 0;
        int price = 1000000;

        for (int j : prices) {
            if (j < price) {
                price = j;
            } else {
                if (result < j - price) {
                    result = j - price;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(prices);
        System.out.println(result);
    }
}
