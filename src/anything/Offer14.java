package anything;

/**
 * 调整数组顺序  使奇数位于偶数的前面
 */
public class Offer14 {


    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9,0};
        swap(data);
        for(int i:data){
            System.out.println(i);
        }
    }

    /**
     *   使用了快速排序的交换思想
     * @param n
     */
    public static void swap(int[] n) {

        if(n == null || n.length == 0){
            return;
        }
        int i = 0;
        int j = n.length - 1;
        while (i < j) {
            while (i < j && isOdd(n[i])) {
                i++;
            }
            while (i < j && !isOdd(n[j])) {
                j--;
            }
            if (i < j) {
                int temp = n[i];
                n[i] = n[j];
                n[j] = temp;
                i++;
                j--;
            }
        }
    }

    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }

}
