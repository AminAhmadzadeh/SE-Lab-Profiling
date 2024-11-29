package sharif.selab.profiling;

import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {
        unoptimizedPrint();
        optimizedPrint();
    }

    public static void unoptimizedPrint() {
        int n = 10000;
        System.out.println("Unoptimized");
        for (int i = 0; i < 10000; i++)
            System.out.println("Sum of squares: " + calculateSumOfSquares(n));
    }

    public static void optimizedPrint() {
        int n = 10000;
        long sumOfSquares = calculateSumOfSquaresByFormula(n);
        System.out.println("Optimized");
        for (int i = 0; i < 10000; i++) {
            System.out.println("Sum of squares: " + sumOfSquares);
        }
    }

    private static long calculateSumOfSquares(int n) {
        return IntStream.rangeClosed(1, n).map(i -> i * i).asLongStream().sum();
    }

    private static long calculateSumOfSquaresByFormula(int n) {
        return n * (n + 1) * (2L * n + 1) / 6;
    }
}
