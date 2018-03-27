package anything.neteasy;

import java.util.Scanner;

public class QQ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int sum = 0;
        for(int i = k; i < n ; i ++){
            sum += (n-i);
        }
        for(int i = k+1; k < n; k++){
            System.out.println((((n/k)+1)*k-n));
            sum += (i-k)*((n/k)+1)-(((n/k)+1)*k-n);
        }
        System.out.println(sum);
    }
}
