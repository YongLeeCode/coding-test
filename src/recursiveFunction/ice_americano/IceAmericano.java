package recursiveFunction.ice_americano;

public class IceAmericano {
    public int[] solution(int money) {
        return purchase(money, 0);
    }

    public static int[] purchase(int money, int count ) {
        int[] ans = {count, money};

        if(money < 5500){
            return ans;
        }

        money -= 5500;
        count++;

        ans = purchase(money, count);
        return ans;
    }
}
