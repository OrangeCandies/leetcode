package anything.sort;

import java.util.Random;

public class QuickSort {


    public static void main(String[] args) {
        Random random = new Random();
        int [] arrayList = new int[1000];
        for(int i =0 ; i < 1000; i++){
           arrayList[i] = random.nextInt(1000);
        }
        sort(arrayList,0,arrayList.length-1);

        boolean b = checkArray(arrayList);
        System.out.println(b);
        for(int i =0 ; i < arrayList.length; i ++){
            System.out.print(arrayList[i]+" ");
        }

    }

    private static boolean checkArray(int[] arrayList) {
      for(int i =1; i < arrayList.length; i ++){
          if(arrayList[i-1] > arrayList[i]){
              return false;
          }
      }
      return true;
    }

    public static void sort(int[] data, int l, int r){
        if(r <= l){
            return;
        }
        int i = l, j = r;
        int temp = data[l];
        while(i < j){
            while(i < j && data[j] > temp){
                j--;
            }
            if(i < j){
                data[i++] = data[j];
            }
            while(i < j && data[i] < temp){
                i++;
            }
            if(i < j){
                data[j--] = data[i];
            }
        }
        data[i] = temp;
        sort(data,l,i-1);
        sort(data,i+1,r);
    }
}
