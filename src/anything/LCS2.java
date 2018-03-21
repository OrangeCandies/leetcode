package anything;

public class LCS2 {

    public static void main(String[] args) {
        int lcs = getLCS("wrod", "wrod");
        System.out.println(lcs);

    }

    public static int getLCS(String a, String b) {
        int[][] ans = new int[a.length()][b.length()];
        int maxLen = 0;

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i > 0 && j > 0) {
                        ans[i][j] = ans[i-1][j-1] + 1;
                    }else{
                        ans[i][j] = 1;
                    }
                }

                if(ans[i][j] > maxLen){
                    maxLen = ans[i][j];
                }
            }
        }
        return maxLen;
    }
}
