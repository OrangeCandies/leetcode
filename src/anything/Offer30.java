package anything;

public class Offer30 {

    public static int maxNumberAndInArray(int[] number){
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        for(int i=0;i<number.length;i++){
            count = count+number[i];
            if(count > maxCount ){
                maxCount = count;
            }
            if(count < 0){
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberAndInArray(new int[]{6,-3,-2,7,-15,1,2,2}));
    }
}
