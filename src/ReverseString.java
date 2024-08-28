import java.util.Arrays;

public class ReverseString
{
    public static void main(String[] args) {
        char[] arr = {'h','e','l','l','o'};
        int size = arr.length;
        int i = 0;
        char temp;
        while(i<size/2){
            temp = arr[i];
            arr[i] = arr[size-i-1];
            arr[size-i-1] = temp;
            i++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
