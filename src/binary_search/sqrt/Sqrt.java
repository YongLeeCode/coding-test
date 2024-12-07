package binary_search.sqrt;

public class Sqrt {

    public static int solution(int x) {
        if(x==0 || x== 1) return x;

        int start = 1;
        int end = x;
        int result = 0;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(mid == x / mid) {
                return mid;
            } else if( mid < x / mid) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int root = solution(5);
        System.out.println(root);
    }
}
