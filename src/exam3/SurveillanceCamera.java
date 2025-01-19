package exam3;

//
public class SurveillanceCamera {

    public static int solution(int[][] routes) {
        int maxCamera = routes.length;

        for(int i = 0; i < routes.length - 1; i++) {
            int stack = 0;
            for(int j = i + 1; j < routes.length; j++) {
                int currDep = Math.min(routes[i][0], routes[i][1]);
                int currArr = Math.max(routes[i][0], routes[i][1]);

                int compDep = Math.min(routes[i][0], routes[i][1]);
                int compArr = Math.max(routes[i][0], routes[i][1]);

                if(currDep >= compDep && currDep <= compArr) {
                    stack++;
                } else if(currArr >= compDep && currArr <= compArr) {
                    stack++;
                }
            }
            if(stack == 1) {
                maxCamera--;
            } else if(stack > 1) {
                maxCamera++;
            }
        }
        return maxCamera;
    }

    public static void main(String[] args) {
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int result = solution(routes);
        System.out.println(result);
    }
}
