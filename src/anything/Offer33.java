package anything;

public class Offer33 {
    public static void Permutation(String str) {
        char[] chars = str.toCharArray();
        dfs(chars,0,str.length());
    }

    private static int count =0;
    private static void dfs(char[] chars,int pos,int len){
        if(pos == len-1){
            String str = new String(chars);
            count++;
            System.out.println(str);
        }
        for(int i=pos;i<len;i++){
            char a = chars[pos];
            chars[pos] = chars[i];
            chars[i] = a;
            dfs(chars,pos+1,len);
        }
    }

    public static void main(String[] args) {
        dfs("ABCDEF".toCharArray(),0,6);
        System.out.println(count);
    }
}
