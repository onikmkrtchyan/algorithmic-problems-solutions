package factorialAndFibonacci;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(fibonacciRecursive(n));
        System.out.println(fibonacciArray(n));
        System.out.println(fibonacci(n));

    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    //  1 2 3 4 5 6 7  8  9
    //  0 1 1 2 3 5 13 21 34
    public static int fibonacciArray(int n) {
        if (n < 1)
            return n;
        if (1 == n)
            return 0;

        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n - 1];
    }

    public static int fibonacci(int n) {
        if (n < 1)
            return n;

        int a = 0, b = 1, s;

        for (int i = 0; i < n; i++) {
            s = a + b;//1 1 2 3 5 8
            b = a;//0 1 1 2 3 5
            a = s;//1 1 2 3 5 8
        }

        return b;
    }
}
