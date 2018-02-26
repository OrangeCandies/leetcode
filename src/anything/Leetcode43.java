package anything;

import java.util.ArrayList;
import java.util.List;

public class Leetcode43 {

    public static List<List<Integer>> answer = new ArrayList<>();

    public static void getAnsewer(int index, ArrayList<Integer> ans){
        if(index == 6){
            answer.add((List<Integer>) ans.clone());
            return;
        }
        for(int i = 1; i <= 6; i++){
            ans.add(i);
            getAnsewer(index+1,ans);
            ans.remove(ans.size()-1);
        }
    }

    public static void main(String[] args) {
        getAnsewer(0,new ArrayList<>());

        for(List<Integer> s : answer){
            for(Integer i: s){
                System.out.print(i);
            }
            System.out.println();
        }
    }


}
