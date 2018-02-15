package anything;

public class Offer31 {

    public static int getUglyNumber(int index) {
        if(index == 0){
            return 0;
        }
        int[] numbers = new int[index];
        numbers[0] = 1;
        int u2=1,u3=1,u5=1;
        for (int i = 0; i < index-1; i++) {
            int maxUgly = numbers[i];
            for(int j=0;j<=i;j++){
                if(2*numbers[j] > maxUgly){
                    u2 = 2*numbers[j];
                    break;
                }
            }
            for(int j=0;j<=i;j++){
                if(3*numbers[j] > maxUgly){
                    u3 = 3*numbers[j];
                    break;
                }
            }
            for(int j=0;j<=i;j++){
                if(5*numbers[j] > maxUgly){
                    u5 = 5*numbers[j];
                    break;
                }
            }
            int minValue = Math.min(u2,u3);
            minValue = Math.min(minValue,u5);
            numbers[i+1] = minValue;
        }
        return numbers[index-1];
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(1));
        System.out.println(getUglyNumber(2));
        System.out.println(getUglyNumber(3));
        System.out.println(getUglyNumber(9));
    }
}
