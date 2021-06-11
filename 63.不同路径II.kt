/**
 * 63.不同路径II(带障碍物)
 *
 * 动态规划(分析问题要尽量把方方面面都想到)
 */
fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val m=obstacleGrid.size
    val n=obstacleGrid[0].size

    val dp=Array(m){IntArray(n)}

    for(i in 0 until m){
        if(obstacleGrid[i][0]==1){//在第一列中，障碍物之后的地方都是无法达到的
            break
        }
        dp[i][0]=1
    }

    for(i in 0 until n){
        if(obstacleGrid[0][i]==1){//在第一行中，障碍物之后的地方都是无法达到的
            break
        }
        dp[0][i]=1
    }

    for(i in 1 until m){
        for(j in 1 until n){
            if(obstacleGrid[i][j]!=1){
                dp[i][j]=dp[i-1][j]+dp[i][j-1]
            }
        }
    }

    return dp[m-1][n-1]
}