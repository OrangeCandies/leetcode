package anything;

import java.util.Scanner;

/**
 * 输入一个数字n 按顺序打出0到最大n位数
 */
public class Offer12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        if(size <= 0){
            return;
        }
        char[] number = new char[size];
        increament(number,0);
    }

    private static void increament(char[] number,int depth){
        if(depth == number.length){
            print(number);
            return;
        }
        for(int i=0;i<10;i++){
            number[depth] = (char) (i+'0');
            increament(number,depth+1);
        }
    }
    private static void print(char[]number){
        for(int i=0;i<number.length;i++){
            System.out.print(number[i]);
        } System.out.println();
    }
}
