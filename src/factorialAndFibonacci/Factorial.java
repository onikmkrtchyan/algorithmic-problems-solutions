package factorialAndFibonacci;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorialRecursive(n));
        System.out.println(factorialArray(n));
    }

    public static int factorialRecursive(int n) {
        if (n <= 1)
            return 1;
        return n * factorialRecursive(n - 1);
    }

    public static int factorialArray(int n) {

     return 1;
    }

}
