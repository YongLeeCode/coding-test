package brute_force.minimum_cost_of_buying_candies_with_discount;

import java.util.Arrays;

public class MinimumCostCandies {

    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int result = Arrays.stream(cost).sum();
        int cumulative = 0;
        int j = cost.length - 1;
        for(int i = 0; i < cost.length; i++) {
            if(i >= j){
                break;
            }
            if(cumulative + cost[j] / 3 >= cost[i]){
                cumulative = cumulative + cost[j] - 3 * cost[i];
                result -= cost[i];
                j--;
            } else if(cumulative + cost[j] / 3 < cost[i]){
                while(cumulative + cost[j] / 3 < cost[i]){
                    if(j == 1){
                        return result;
                    }
                    cumulative += cost[j];
                    j--;
                    if(cumulative + cost[j] / 3 >= cost[i]){
                        cumulative = cumulative + cost[j] - 3 * cost[i];
                        result -= cost[i];
                        j--;
                    }

                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] cost = {1,3,2};
        int result = minimumCost(cost);
        System.out.println(result);
    }
}
