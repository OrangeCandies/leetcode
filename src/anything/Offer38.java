package anything;

public class Offer38 {

    public static int getNumberOfKInSortedArray(int[] array, int K) {
        if(array == null || array.length==0){
            return -1;
        }
        int begin = getFristK(array,K);
        int end = getLastK(array, K);
        if(begin == -1 || end == -1)
            return 0;
        return end-begin+1;
    }

    public static int getLastK(int[] a, int K) {
        int begin = 0;
        int end = a.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin)/2;
            if (a[mid] > K) {
                end = mid - 1;
            } else if (a[mid] < K) {
                begin = mid + 1;
            } else if (mid + 1 < a.length && a[mid + 1] == K) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int getFristK(int[] a, int K) {
        int begin = 0;
        int end = a.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin)/2;
            if (a[mid] > K) {
                end = mid - 1;
            } else if (a[mid] < K) {
                begin = mid + 1;
            } else if (mid - 1 >= 0 && a[mid - 1] == K) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] data = new int[]{1,2,3,3,3,3};
        System.out.println(getNumberOfKInSortedArray(data,3));
    }
}
