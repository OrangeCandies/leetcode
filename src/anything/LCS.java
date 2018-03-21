package anything;

public class LCS {

    public static void main(String[] args) {
        int lcs = getLCS("BDCABA", "ADCBDAB");
        System.out.println(lcs);
    }

    public static int getLCS(String a, String b) {
        int[][] ans = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i <= a.length(); i++){
            for(int j = 1; j <= b.length(); j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    ans[i][j] = ans[i-1][j-1] + 1;
                }else if(ans[i-1][j] > ans[i][j-1]){
                    ans[i][j] = ans[i-1][j];
                }else{
                    ans[i][j] = ans[i][j-1];
                }
            }
        }

        return ans[a.length()][b.length()];
    }
}
