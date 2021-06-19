/**
 * 74.搜索二维矩阵
 *
 * 最优解：列上二分行上二分
 *
 * 二分的循环条件为l<=r
 */
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {//列上遍历行上二分
    val m=matrix.size
    val n=matrix[0].size

    if(target<matrix[0][0]||target>matrix[m-1][n-1]) return false

    var x=0
    var y=(n-1)/2
    var l=0
    var r=n-1

    for(i in 0 until m){
        if(matrix[i][n-1]==target){
            return true
        }
        if(matrix[i][n-1]>target){
            x=i
            break
        }
    }

    if(target<matrix[x][0]){
        return false
    }

    while (l<=r){
        if(matrix[x][y]==target) return true
        if(matrix[x][y]<target){
            l=y+1
        }else if(matrix[x][y]>target){
            r=y-1
        }
        y=(l+r)/2
    }

    return false
}