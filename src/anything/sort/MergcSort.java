package anything.sort;

import java.util.Random;

public class MergcSort {

    public void sort(int[] data, int []temp, int l, int r){
        if(l == r){
            return;
        }
        int mid = l + (r-l)/2;
        sort(data,temp,l,mid);
        sort(data,temp,mid+1,r);
        int i = l, j = mid+1;
        int loc = l;
        while(i <= mid && j <= r){
            if(data[i] < data[j]){
                temp[loc++] = data[i++];
            }else{
                temp[loc++] = data[j++];
            }
        }
        while(i <= mid){
            temp[loc++] = data[i++];
        }
        while (j <= r){
            temp[loc++] = data[j++];
        }

        for(int x = l; x<=r; x++){
            data[x] = temp[x];
        }
    }


    public static void main(String[] args) {
        int [] data = new int[100];
        Random random = new Random();
        for(int i =0; i < 100 ; i++){
            data[i] = random.nextInt(1000);
        }
        int [] temp = new int[100];
        MergcSort sort = new MergcSort();

        sort.sort(data,temp,0,99);
        for(int i : data){
            System.out.print(i+" ");
        }
    }
}
