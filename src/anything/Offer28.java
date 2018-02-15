package anything;

import java.util.ArrayList;

public class Offer28 {

    public static ArrayList<Integer> getMinKNumber(int [] data,int K){
        if(K > data.length){
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int minPos = 0;
        for(int i=0;i<K;i++){
            minPos = i;
            for(int j = i+1;j<data.length;j++){
                if(data[j] < data[minPos]){
                    minPos  = j;
                }
            }
            int temp = data[minPos];
            data[minPos] = data[i];
            data[i] = temp;
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data = new int[]{9,8,7,6,5,14,3,2,1,0};
        System.out.println(getMinKNumber(data,14));
    }
}
