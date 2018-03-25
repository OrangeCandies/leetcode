package anything;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] data = new int[len];
        for(int i =0; i < data.length; i ++){
            data[i] = scanner.nextInt();
        }
        String ans = "";
        for(int i =0; i < data.length; i ++){
            ans += data[i]+",";
        }

        int pre;
        int count = 1;
        for(int i =0; i < ans.length(); i ++ ){
            if(Character.isDigit(ans.charAt(i))){
                pre = i;
                int to = 0;
                for(int j =i + 2; j < ans.length(); j+=2 ){
                    if(Character.isDigit(ans.charAt(j)) && ans.charAt(j)-ans.charAt(j-2) == 1){
                        pre = ans.charAt(j)-'0';
                        to = j;
                        count ++;
                    }else{
                        break;
                    }
                }

                if(count >=3 ){

                    if(to + 2 < ans.length())

                        ans = ans.substring(0,i) + (ans.charAt(i)-'0') +"-"+ (pre)+","+ ans.substring(to+2);
                    else
                        ans = ans.substring(0,i) + (ans.charAt(i)-'0') +"-"+ (pre);
                    i = pre;
                    count  = 0;
                }

            }
        }
        if(ans.charAt(ans.length()-1) == ','){
            ans = ans.substring(0,ans.length()-1);
        }
        System.out.println(ans);

    }
}
