package anything.didi;

import java.util.LinkedList;
import java.util.List;

public class Problem4 {

    public static boolean canBeCircle(String[] data) {
       List<String> strings = new LinkedList();
        for(String s : data){
            strings.add(s);
        }

        for(int i = 0; i < data.length; i ++){
            String s = data[i];
            strings.remove(s);
            if(function(strings,s.charAt(s.length()-1),s.charAt(0))){
                return true;
            }
            strings.add(s);
        }
        return false;
    }

    private static boolean function(List<String> list, char begin, char end) {


        for(int i =0; i < list.size(); i ++) {
            String s = list.get(i);
            if (list.size() == 1) {
                return s.charAt(0) == begin && s.charAt(s.length() - 1) == end;
            }
            if (s.charAt(0) == begin) {

                list.remove(s);
                if (function(list, s.charAt(s.length() - 1), end)) {
                    return true;
                } else {
                    list.add(s);
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        String[] testData = new String[]{"cp","open","echo","grep","nc","ping","pstree"};
        boolean b = canBeCircle(testData);
        System.out.println(b);
    }

}
