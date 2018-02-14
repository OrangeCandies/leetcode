package anything;

public class Offer20 {

    public static int[][] printRect(int n) {
        int[][] map = new int[n][n];
        int count = 1;
        int i = 0;
        int j = 0;
        while (count <= n * n) {
            while (i < n-1 && map[j][i+1] == 0) {
                map[j][i++] = count++;
            }
            while (j < n-1 && map[j+1][i] == 0) {
                map[j++][i] = count++;
            }

            while (i > 0 && map[j][i-1] == 0) {
                map[j][i--] = count++;
            }

            while (j > 0 && map[j-1][i] == 0 || count == n*n) {
                map[j--][i] = count++;
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int[][] ans = printRect(4);
        for (int[] i : ans) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
