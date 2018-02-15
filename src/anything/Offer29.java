package anything;

public class Offer29 {

    public static int partition(int[] n) {
        if(n == null){
            return 0;
        }
        int value = function(n, 0, n.length - 1);
        return value;
    }

    private static int function(int[] n, int l, int r) {
        int temp = n[l];
        int i = l, j = r;
        if(r >= l){
            return n[r];
        }
        while (i < j) {
            while (i < j && n[j] > temp) {
                j--;
            }
            if (i < j) {
                n[j] = n[i++];
            }
            while (i < j && n[i] < temp) {
                i++;
            }
            if (i < j) {
                n[i] = n[j--];
            }
        }
        n[j] = temp;
        if( j == n.length/2){
            return temp;
        }else if(j < n.length/2){
            return function(n,l,j);
        }else{
            return function(n,j,r);
        }
    }

    public static void main(String[] args) {
        int []data = new int[]{1,2,3,2,4,2,5,2,3};
        System.out.println(partition(data));
    }

}
