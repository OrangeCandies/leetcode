package anything.neteasy;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

    }

    private String getPath(int target,int pos){
        if(pos*2+1 == target){
            return "1";
        }

        if(pos*2+2 == target){
            return "2";
        }
        if(pos * 2 + 2 > target){
            return "";
        }
        return "";
    }
}
