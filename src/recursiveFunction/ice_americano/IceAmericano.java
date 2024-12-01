package recursiveFunction.ice_americano;

public class IceAmericano {
    public int[] solution(int money) {
        int[] answer = purchase(money, 0);
        return answer;
    }

    public static int[] purchase(int money, int count ) {
        int ans[] = {count, money};

        if(money < 5500){
            return ans;
        }

        int coffeePrice = 5500;

        money -= coffeePrice;
        count++;

        ans = purchase(money, count);
        return ans;
    }
}
