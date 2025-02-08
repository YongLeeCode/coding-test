package exam4;

public class NQueen {

    private static int answer;
    private static int[] board;

    public static int solution(int n) {
        board = new int[n];
        findSafeZone(0, n);
        return answer;
    }

    private static void findSafeZone(int index, int n) {
        if (index >= n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[index] = i;
            if (valid(index)) {
                findSafeZone(index + 1, n);
            }
        }
    }

    private static boolean valid(int index) {
        for (int j = 0; j < index; j++) {
            if (board[index] == board[j]) {
                return false;
            }
            if (Math.abs(index - j) == Math.abs(board[index] - board[j])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int result = solution(4);
        System.out.println(result);
    }
}
