// code.split()
// 조건문 r == i%q
// code answer += code[i]
package basicTrainingCodingTest.qr_code;

public class QRcode {

    public static String solution(int q, int r, String code) {
        StringBuilder output = new StringBuilder();
        String[] characters = code.split("");
        for (int i = 0; i < characters.length; i++) {
            if (r == i % q) {
                output.append(characters[i]);
            }
        }
        return String.valueOf(output);
    }

    public static void main(String[] args) {
        String output = solution(3, 1, "qjnwezgrpirldywt");
        System.out.println(output);
    }
}
