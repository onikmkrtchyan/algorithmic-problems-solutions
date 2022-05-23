import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(reverse(str));

    }

    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        int size = arr.length;
        int i = 0;
        char temp;
        while (i < size / 2) {
            temp = arr[i];
            arr[i] = arr[size - i - 1];
            arr[size - i - 1] = temp;
            i++;
        }
        return String.valueOf(arr);
    }
}
