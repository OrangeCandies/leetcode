package anything;

public class Bag01 {

    public int knaspck01(int[] weight,int []value,int cost){
        int n = weight.length-1;
        return bestValue(weight,value,n-1,cost);
    }

    // 记忆化搜索
    private int bestValue(int [] weight, int [] value, int index, int cost){
       if(index < 0 || cost <= 0){
           return 0;
       }
       int res = bestValue(weight,value,index-1,cost);

       if(cost >= weight[index]){
           res = Math.max(res, value[index]+bestValue(weight,value,index,cost-weight[index]));
       }
       return res;
    }

    // 0/1 背包问题
    // 动态规划解决
    public int knaspck01Dsy(int[] weight,int []value,int cost){

        if(weight == null || weight.length == 0) {
            return 0;
        }
        assert weight.length == value.length;
        int [][] ans = new int[weight.length][cost+1];
        for(int i=0; i<cost+1;i++){
            ans[0][i] = (i > weight[0] ? value[0]:0);
        }
        for(int i=1;i<weight.length;i++){
            for(int j=0;j<cost;j++){
                ans[i][j] = ans[i-1][j];
                if(j >= weight[i]){
                    ans[i][j] = Math.max(ans[i][j],ans[i-1][j-weight[i]]+value[i]);
                }
            }
        }
        return ans[weight.length][cost];
    }
}
