import java.util.HashMap;
import java.util.Map;

public class ArithmeticMean {
    public static void main(String[] args) {
        int [] arr = {2,1,3};

        //        System.out.println(quantityOfArithmeticMean(2,));
        System.out.println(solution(arr,2));

    }



    public static int solution(int[] A, int S) {

        HashMap<Integer, Integer> element = new HashMap<>();
        int[] arrayOne = new int[A.length + 1];
        int[] arrayTwo = new int[A.length + 1];
        int result = 0;
        element.put(0, 1);
        arrayOne[0] = 0;
        arrayTwo[0] = 0;
        for (int i = 1; i < A.length + 1; i++) {
            arrayOne[i] = arrayOne[i - 1] + A[i - 1];
            arrayTwo[i] = arrayOne[i] - S * i;
            if (!element.containsKey(arrayTwo[i])) {
                element.put(arrayTwo[i], 1);
            } else {
                Integer value = element.get(arrayTwo[i]);
                value++;
                element.put(arrayTwo[i], value);
            }
        }
        for (Map.Entry<Integer, Integer> entry : element.entrySet()) {
            int value = entry.getValue();
            result += value * (value - 1) / 2;
        }
        return Math.min(result, 1000000000);
    }

    /**
     * Find quantity of all possible subarrays, which arithmetic mean equals to N
     * @param N value of arithmetic mean
     * @param arr arr of integers
     * @return quantity of all possible subarrays, which arithmetic mean equals to N
     */
    public static int quantityOfArithmeticMean(int[] arr, int N){

        return 0;
    }
}
