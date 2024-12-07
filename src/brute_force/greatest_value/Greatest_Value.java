package brute_force.greatest_value;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Greatest_Value {

    public static void solution(String expression) {
        List<String> numbers = getNumbers(expression);
        List<String> operators = getOperators(expression);
        String[][] symbolOrder = orderSymbol();

        List<Long> results = new ArrayList<>();

        for (String[] order : symbolOrder) {
            long result = calculate(new ArrayList<>(numbers), new ArrayList<>(operators), order);
            results.add(result);
        }

        long maxAbsoluteValue = 0;
        for (Long number : results) {
            if (Math.abs(number) > Math.abs(maxAbsoluteValue)) {
                maxAbsoluteValue = number;
            }
        }

        System.out.println(Math.abs(maxAbsoluteValue));
    }

    private static List<String> getNumbers(String expression) {
        List<String> numbers = new ArrayList<>();
        Pattern numberPattern = Pattern.compile("\\d+");
        Matcher numberMatcher = numberPattern.matcher(expression);
        while (numberMatcher.find()) {
            numbers.add(numberMatcher.group());
        }
        return numbers;
    }

    private static List<String> getOperators(String expression) {
        List<String> operators = new ArrayList<>();
        Pattern operatorPattern = Pattern.compile("[+\\-*/]");
        Matcher operatorMatcher = operatorPattern.matcher(expression);
        while (operatorMatcher.find()) {
            operators.add(operatorMatcher.group());
        }
        return operators;
    }

    public static String[][] orderSymbol() {
        return new String[][]{
                {"*", "-", "+"},
                {"*", "+", "-"},
                {"-", "*", "+"},
                {"-", "+", "*"},
                {"+", "-", "*"},
                {"+", "*", "-"},
        };
    }

    private static long calculate(List<String> numbers, List<String> operators, String[] order) {
        for (String op : order) {
            while (operators.contains(op)) {
                int index = operators.indexOf(op);

                long num1 = Long.parseLong(numbers.get(index));
                long num2 = Long.parseLong(numbers.get(index + 1));
                long result = evaluate(num1, num2, op);

                numbers.set(index, String.valueOf(result));
                numbers.remove(index + 1);
                operators.remove(index);
            }
        }
        return Long.parseLong(numbers.get(0));
    }

    private static long evaluate(long num1, long num2, String operator) {
        return switch (operator) {
            case "*" -> num1 * num2;
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            default -> throw new IllegalArgumentException("잘못된 연산자: " + operator);
        };
    }
}