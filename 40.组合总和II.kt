/**
 * 40.组合总和II
 *
 * 与组合总和类似都是寻找所有可行解的问题，一样是采用「搜索回溯」的方法进行解决
 */
fun main() {
    val a= intArrayOf(10,1,2,7,6,1,5)
    val temp= combinationSum2(a,8)
    for(i in temp){
        for(j in i){
            print(j)
            print(" ")
        }
        println()
    }
}

val anim=ArrayList<ArrayList<Int>>()

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()
    dfs(candidates,target,0,0, ArrayList())
    return anim
}

fun dfs(array: IntArray,target: Int,sum: Int,index: Int,temp: ArrayList<Int>) {
    for(i in index..array.lastIndex){
        if(i!=index && array[i]==array[i-1]) continue//取重
        if(target-sum-array[i]==0){
            //在这里并不需要给temp集合添加array[i]元素，temp要添加元素总是需要伴随着index增加
            val a=ArrayList<Int>()
            a.addAll(temp)
            a.add(array[i])
            anim.add(a)
            return
        }

        if(target-sum-array[i]<0){
            return
        }

        temp.add(array[i])
        dfs(array,target,sum+array[i],i+1,temp)
        temp.remove(array[i])
    }
}