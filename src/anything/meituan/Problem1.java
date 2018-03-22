package anything.meituan;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String b = scanner.nextLine();

        String longString  = a, shortString = b;
        if(a.length() < b.length()){
            longString = b;
            shortString = a;
        }
        int answer = getAnswer(a, b);


        System.out.println(answer);

    }

    private static int getAnswer(String a,String b) {
        int count = 0;
        for(int i = 0 ; i < a.length()-b.length()+1; i ++){
            for(int j = 0; j < b.length(); j++){
                if(b.charAt(j) != a.charAt(i+j)){
                    count++;
                }
            }
        }
        return count;


    }

}
