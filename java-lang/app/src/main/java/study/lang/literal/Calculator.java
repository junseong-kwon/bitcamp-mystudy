package study.lang.literal;

public class Calculator {
    int a = 1, b = 2;

    /**
     * 두 정수를 더하여 결과를 반환합니다.
     *
     * @param a 첫 번째 정수
     * @param b 두 번째 정수
     * @return 덧셈 결과
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * 두 정수를 곱하여 결과를 반환합니다.
     *
     * @param a 첫 번째 정수
     * @param b 두 번째 정수
     * @return 곱셈 결과
     */
    public int multiply(int a, int b) {
        return a * b;
    }
}
