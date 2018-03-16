package anything;

public class Leetcode657 {
    class Solution {
        public boolean judgeCircle(String moves) {
            int i = 0;
            int j = 0;
            for(char c : moves.toCharArray()){
                switch (c){
                    case 'U':
                        j++;
                        break;
                    case 'D':
                        j--;
                        break;
                    case 'L':
                        i--;
                        break;
                    case 'R':
                        i++;
                        break;
                }
            }

            if(i == 0 && j == 0){
                return true;
            }else {
                return false;
            }
        }
    }
}
