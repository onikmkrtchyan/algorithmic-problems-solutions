package factorial_fibonacci;

public class Factorial {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(factorialRecursive(n));
        System.out.println(factorialArray(n));
    }

    public static int factorialRecursive(int n) {
        if (n <= 1)
            return 1;

        return n * factorialRecursive(n - 1);
    }

    public static int factorialArray(int n) {
        int a = 1;

        for (int i = 2; i <= n; i++) {
            a = i * a;
        }

     return a;
    }

}
