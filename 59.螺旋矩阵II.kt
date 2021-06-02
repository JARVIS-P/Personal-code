/**
 * 59.螺旋矩阵II
 *
 * 模拟顺序向数组中添加元素
 *
 * kotlin中定义二维数组的方法：Array(n){IntArray(n)}
 */
fun generateMatrix(n: Int): Array<IntArray> {
    val result=Array(n){IntArray(n)}//二维数组定义方法

    var l=0
    var r=n-1
    var t=0
    var b=n-1

    var num=1
    val max=n*n

    while(num<=max){
        for(i in l..r) result[t][i]=num++
        t++

        for(i in t..b) result[i][r]=num++
        r--

        for(i in r downTo l) result[b][i]=num++
        b--

        for(i in b downTo t) result[i][l]=num++
        l++
    }
    return result
}
