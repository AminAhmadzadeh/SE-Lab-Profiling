package sharif.selab.profiling;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class JavaCup {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press number1: ");
        int i = scanner.nextInt();
        System.out.println("Press number2: ");
        int j = scanner.nextInt();
        System.out.println("Press number3: ");
        int k = scanner.nextInt();
        temp();
        eval(i, j, k);
    }
    public static void eval(int i, int j, int k)
    {
        if (i * i + j * j == k * k || i * i == j * j + k * k || j * j == i * i + k * k)
        {
            System.out.println("YES");
        }
        else { System.out.println("NO"); }
    }
    public static void temp() {
        ArrayList<Integer> a = new ArrayList<>(2000000);
        IntStream.range(0, 100).parallel().forEach(i -> {
            for (int j = 0; j < 20000; j++)
                synchronized (a) {
                    a.add(i + j);
                }
        });
    }
}
