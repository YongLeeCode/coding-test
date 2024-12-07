package brute_force.mock_exam;

import java.util.Arrays;

public class MockExam {

    public static void solution() {
        int[] answers = {1,3,2,4,2};
        int[] results = checkAnswer(answers);
        System.out.println(Arrays.toString(results));
        String firstPrize = "";
        int firstPersonResult = results[0];
        for(int i = 0; i <= 2; i++) {
            if(firstPersonResult == results[i]){
                firstPrize += String.valueOf(i+1);
            } else if(firstPersonResult < results[i]){
                firstPersonResult = results[i];
                firstPrize = String.valueOf(i+1);
            }
        }
        System.out.println(firstPrize);
    }

    private static int[] checkAnswer(int[] answers) {
        int[][] studentAnswers = peopleAnswers();
        int[] correctProblems = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if(answers[i%answers.length] == studentAnswers[0][i%studentAnswers[0].length]) {
                correctProblems[0]++;
            }
            if(answers[i%answers.length] == studentAnswers[1][i%studentAnswers[1].length]) {
                correctProblems[1]++;
            }
            if(answers[i%answers.length] == studentAnswers[2][i%studentAnswers[2].length]) {
                correctProblems[2]++;
            }
        }
        return correctProblems;
    }

    private static int[][] peopleAnswers() {
        return new int[][]{
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
    }
}
