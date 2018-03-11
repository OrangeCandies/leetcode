package anything;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Json {

    private static final int OBJECT = 1;
    private static final int STRING = 2;


    static class Value {
        int type;
        String val;

        Value(int type, String val) {
            this.type = type;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int n, query;
        Map<String, Value> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        query = scanner.nextInt();
        String pre = null;
        while (n-- >= 0) {
            String s = scanner.nextLine();
            if (s.startsWith("{") || s.startsWith("}")) {
                pre = null;
                continue;
            }
            String[] split = s.split(":");


            if (split.length == 2 && split[1].equals(" {")) {

                if (pre == null || pre.length() == 0) {
                    pre = split[0].substring(split[0].indexOf('\"')+1, split[0].lastIndexOf('\"'));
                } else {
                    pre = pre + "." + split[0].substring(split[0].indexOf('\"')+1, split[0].lastIndexOf('\"'));
                }

                map.put(pre, new Value(OBJECT, null));
                continue;
            }

            if (split.length == 2) {
                String key = pre == null ? split[0].substring(split[0].indexOf('\"')+1, split[0].lastIndexOf('\"'))
                        : pre + "." + split[0].substring(split[0].indexOf('\"')+1, split[0].lastIndexOf('\"'));
                key = regularString(key);
                String val = split[1].substring(split[1].indexOf('\"')+1, split[1].lastIndexOf("\""));
                val = regularString(val);
                System.out.println(key + " " + val);
                map.put(key, new Value(STRING, val));
            }
        }
        while (query-- > 0) {
            String q = scanner.nextLine();
            if(map.containsKey(q)){
                Value value = map.get(q);
                if(value.type == OBJECT){
                    System.out.println("OBJECT");
                }else{
                    System.out.println("STRING "+value.val);
                }
            }else{
                System.out.println("NOTEXIST");
            }
        }
    }

    private static String regularString(String input){
        char[] chars = input.toCharArray();
        StringBuilder s = new StringBuilder();
        boolean flag = false;
        for(int i = 0; i < chars.length;i++){
            if(chars[i] == '\\' && !flag){
                flag = true;
                continue;
            }
            flag = false;
            s.append(chars[i]);
        }
        return s.toString();
    }
}
