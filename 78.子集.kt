/**
 * 78.子集
 *
 * 迭代或递归枚举所有子集：已知第一个数的子集就可以得知前两个数的子集，已知前两个数的子集就可以得知前三个数的子集...，
 * 例：(1,2)已知无参时子集为空[],第一个参数的子集为将1插入每个已有子集之后即为[][1]，第二个参数的子集为将2插入每个已有自己之后即为[][1][2][1,2]
 *
 * 注意，直接用=复制对象时，这两者指向的是同一对象。(改变其中之一，另一个也会跟着改变)
 */
fun subsets(nums: IntArray): List<List<Int>> {
    val result = arrayListOf<ArrayList<Int>>()
    result.add(arrayListOf())

    for(i in nums){
        val c=ArrayList(result)
        val n=c.size
        for(j in 0 until n){
            val temp=ArrayList(c[j])
            temp.add(i)
            c.add(temp)
        }
        result.clear()
        result.addAll(c)
    }

    return result
}