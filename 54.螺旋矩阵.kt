/**
 * 54.螺旋矩阵
 *
 * 模拟顺时针螺旋即可
 */
fun main() {
    val t=spiralOrder(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9), intArrayOf(10,11,12)))
    println(t)
}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    if(matrix.isEmpty()) return listOf()

    var l=0
    var r=matrix[0].size-1
    var t=0
    var b=matrix.size-1

    val result= arrayListOf<Int>()

    while(true){//下列for循环按照顺序依次执行，模拟顺时针螺旋
        for(i in l..r) result.add(matrix[t][i])
        if(++t>b) break

        for(i in t..b) result.add(matrix[i][r])
        if(--r<l) break

        for(i in r downTo l) result.add(matrix[b][i])
        if(--b<t) break

        for(i in b downTo t) result.add(matrix[i][l])
        if(++l>r) break
    }
    return result
}