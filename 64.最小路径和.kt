/**
 * 64.最小路径
 *
 * 动态规划：状态转移方程f(i,j)=f(i,j)+min(f(i-1,j),f(i,j-1))
 */
fun minPathSum(grid: Array<IntArray>): Int {
    val m=grid.size
    val n=grid[0].size

    val dp=grid

    //因为状态转移时出现了j-1及i-1，所以我们这里先对第一行和第一列进行状态转移
    for(i in 1 until m){
        dp[i][0]=dp[i-1][0]+dp[i][0]
    }

    for(i in 1 until n){
        dp[0][i]=dp[0][i-1]+dp[0][i]
    }

    for(i in 1 until m){
        for(j in 1 until n){
            dp[i][j]=dp[i][j] + if(dp[i-1][j]<dp[i][j-1]) dp[i-1][j] else dp[i][j-1]
        }
    }

    return dp[m-1][n-1]
}