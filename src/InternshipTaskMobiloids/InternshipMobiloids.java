package InternshipTaskMobiloids;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class InternshipMobiloids {

    //Java Exercise 1

    /**
     * Two words make a Reverse pair if one word is reverse of the other
     *
     * @param words as List
     * @return integer
     */
    int reversePairsCount(List<String> words) {
        int k = 0;
        for (int i = 0; i < words.size() - 1; i++) {
            String str = new StringBuilder(words.get(i)).reverse().toString();
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(j).equals(str)) {
                    k++;
                    words.remove(j);
                    break;
                }
            }
        }
        return k;
    }

    //Java Exercise 2

    /**
     * must find the minimum prime number, which is missed from given array
     *
     * @param numbers array
     * @return smallest prime number
     */
    int smallestPrime(int[] numbers) {
        int div, n = 2, count = 0;
        boolean check;
        while (count <= numbers.length + 1) {
            div = 2;
            if (!(n == 2 || n == 3))
                for (int i = 2; i <= n / 2; i++) {
                    if (n % i == 0)
                        div++;
                    if (div > 2)
                        break;
                }
            if (div == 2) {
                count++;
                check = false;
                for (int number : numbers) {
                    if (n == number) {
                        check = true;
                        break;
                    }
                }
                if (!check)
                    return n;
            }
            n++;
        }
        return n;
    }

    //java  Exercise 3

    /**
     * given 3 bishops need to collect them in same cell on the chess board using minimum steps
     * if it possible
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @return minimum quantity of moves
     */
    int minMoves(int x1, int y1, int x2, int y2, int x3, int y3) {
        int result = 0;
        if ((x1 % 2 == y1 % 2 && x2 % 2 == y2 % 2 && x3 % 2 == y3 % 2) || (x1 % 2 != y1 % 2 && x2 % 2 != y2 % 2 && x3 % 2 != y3 % 2)) {
            //if the first and second bishops are on the same diagonals but not in the same cell
            if (abs(x1 - x2) == abs(y1 - y2) && abs(x1 - x2) != 0) {
                result++;
            }
            // if first and second bishops are on the different diagonals
            if (abs(x1 - x2) != abs(y1 - y2))
                result += 2;
            // same checks for a third bishops
            if (abs(x3 - x2) == abs(y3 - y2) && abs(x3 - x2) != 0 || abs(x3 - x1) == abs(y3 - y1) && abs(x3 - x1) != 0)
                result++;
            // when third bishop does not locate with first or second bishops in the same diagonals
            if (abs(x3 - x2) != abs(y3 - y2) && abs(x3 - x1) != abs(y3 - y1))
                result += 2;
            return result;
        } else
            return -1;
    }

    //Java Exercise 4

    /**
     * checks if row is contain only 1 number return true, else false
     *
     * @param arr  array
     * @param size integer
     * @return boolean
     */
    boolean isAllAreOne(int[] arr, int size) {
        for (int i = 0; i < size; ++i)
            if (1 != arr[i])
                return false;
        return true;
    }

    /**
     * set all elements in array 1
     *
     * @param arr  array
     * @param size integer
     */
    void setAllZero(int[] arr, int size) {
        for (int i = 0; i < size; ++i)
            arr[i] = 0;
    }

    /**
     * if row contain only 1, change 1 into 0 and move it up
     *
     * @param board  2D array
     * @param height integer
     * @param width  integer
     */
    void moveDown(int[][] board, int height, int width) {
        int shift = 0;
        for (int i = height - 1; i >= 0; i--) {
            if (isAllAreOne(board[i], width)) {
                setAllZero(board[i], width);
                shift++;
            } else if (shift > 0) {
                //swap the place of rows
                int[] temp = board[i];
                board[i] = board[i + shift];
                board[i + shift] = temp;
            }
        }
    }


    public static void main(String[] args) {
        InternshipMobiloids internshipMobiloids = new InternshipMobiloids();

        int[] num = {2, 3, 5, 7, 13, 11, 19, 23, 29, 17};
        System.out.println(internshipMobiloids.smallestPrime(num));

        System.out.println(internshipMobiloids.minMoves(1, 3, 3, 3, 5, 3));


        List<String> MyList = new ArrayList<>();
        MyList.add("top");
        MyList.add("aaa");
        MyList.add("read");
        MyList.add("stop");
        MyList.add("aaa");
        MyList.add("table");
        MyList.add("pots");
        MyList.add("stop");
        MyList.add("pot");
        System.out.println(internshipMobiloids.reversePairsCount(MyList));

        int[][] arr = {{0, 0, 0, 0, 1},
                {1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1}};

        internshipMobiloids.moveDown(arr, 6, 5);


    }
}