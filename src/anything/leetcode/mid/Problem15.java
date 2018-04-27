package anything.leetcode.mid;

public class Problem15 {

    class Solution {
        boolean [][] visited = null;
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            int ans = 0;
            visited = new boolean[grid.length][grid[0].length];
            for(int i = 0 ; i < grid.length ; i ++){
                for(int j = 0; j < grid[i].length; j++){
                    if(!visited[i][j] && grid[i][j] == '1'){
                        dfs(grid,i,j);
                        ans ++;
                    }
                }
            }
            return ans;
        }

        public void dfs(char [][] g, int i ,int j){
            visited[i][j] = true;
            if(i-1 >= 0 && !visited[i-1][j] && g[i-1][j] == '1'){
                visited[i-1][j] = true;
                dfs(g,i-1,j);
            }
            if(i+1 < g.length && !visited[i+1][j] &&  g[i+1][j] == '1'){
                visited[i+1][j] = true;
                dfs(g,i+1,j);
            }
            if(j-1 >= 0 && !visited[i][j-1]&& g[i][j-1] == '1'){
                visited[i][j-1] = true;
                dfs(g,i,j-1);
            }
            if(j+1 < g[i].length && !visited[i][j+1]&&  g[i][j+1] == '1'){
                visited[i][j+1] = true;
                dfs(g, i, j+1);
            }
        }
    }


}
