/**
 * 48.旋转图像(只能在原数组中进行修改)
 *
 * 本题我们可以通过翻转来代替旋转，先水平翻转再沿主对角线进行翻转
 */
fun rotate(matrix: Array<IntArray>): Unit {
    val n=matrix.size
    //水平翻转(我们只需遍历上半部分的数组即可)
    for(i in 0 until n/2){
        for(j in 0..n-1){
            val temp=matrix[i][j]
            matrix[i][j]=matrix[n-i-1][j]
            matrix[n-i-1][j]=temp
        }
    }
    //沿主对角线翻转(我们只需遍历主对角线下方的数组即可)
    for(i in 0..n-1){
        for(j in 0..i-1){
            val temp=matrix[i][j]
            matrix[i][j]=matrix[j][i]
            matrix[j][i]=temp
        }
    }
}