public class a6_KnapsackMem {
    private static int maxProfitMem(int[] val, int[] wt, int W, int n, int[][] dp) {
//        int n = val.length; int m = wt.length;
        if(n == 0 || W == 0){
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }
        //valid
        if(wt[n-1] <= W){
            // include
            int ans1 = val[n-1] + maxProfitMem(val, wt, W - wt[n-1], n-1, dp);
            // exclude
            int ans2 = maxProfitMem(val, wt, W, n-1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }
        // not-valid
        dp[n][W] = maxProfitMem(val, wt, W, n-1, dp);
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2 ,5 ,1 ,3 ,4};
        int W = 7;

        int dp[][] = new int[val.length + 1][W + 1];

//        int dp[][] = new int[val.length + 1][wt.length + 1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(maxProfitMem(val, wt, W, val.length, dp));
    }
}
