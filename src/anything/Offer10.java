package anything;

public class Offer10 {

    /**
     *   返回二进制数中1的个数
     * @param n
     * @return
     */
    public  static int NumberOf1(int n){
        int count = 0;
        while(n != 0){
            count ++;
            n = n&(n-1);  // 10010101 10010100 & 10010011 = 10010000
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(-127));
    }
}
