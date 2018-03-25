package anything;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        char[] chars = data.toCharArray();

        int maxValue = Integer.MIN_VALUE;
        int ans = 0;
        boolean isNeg = false;
        for (int i = 0; i < chars.length; i++){

            if(chars[i] == '-' && i < chars.length-1 && Character.isDigit(chars[i+1])){
                isNeg = true;
                continue;
            }
            if(Character.isDigit(chars[i]) ){
                ans *= 10;
                ans += isNeg ? -1 * chars[i]-'0' :chars[i]-'0'  ;


                if(ans > maxValue){
                    maxValue = ans;
                    System.out.println(maxValue);
                }
            }else{
                isNeg = false;
                ans = 0;
            }
        }

        System.out.println(maxValue);
    }

}
