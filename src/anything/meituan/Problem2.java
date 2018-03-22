package anything.meituan;

import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ;

        String ans = scanner.nextLine();
        int[] numbers = new int[10];

        for (char c : ans.toCharArray()) {
            numbers[c - '0']++;
        }
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            if (!compare(numbers, chars)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean compare(int[] a, char[] chars) {
        int[] numbers = new int[10];
        for (char c : chars) {
            numbers[c - '0']++;
        }
        for (int i = 0; i < 10; i++){
            if(a[i] < numbers[i]){
                return false;
            }
        }
        return true;
    }
}
