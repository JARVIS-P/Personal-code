/**
 * 39.组合总和
 *
 * 对于这类寻找所有可行解的题，我们都可以尝试用「搜索回溯」的方法来解决。
 *
 * 在kotlin中寻找一个集合的终点下标可以调用：array.lastIndex
 * 在kotlin中创建一个集合的副本(array集合)可以调用：val temp=ArrayList<Int>(); trmp.addAll(array);
 */
val ans=ArrayList<ArrayList<Int>>()

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()
    solve(candidates,target,0,0,java.util.ArrayList())
    return ans
}

fun solve(array: IntArray,target: Int,sum: Int,index: Int,list: ArrayList<Int>){//暴力递归回溯
    for(i in index..array.lastIndex){//从index开始遍历，避免重复
        if(array[i]+sum==target){
            val l=ArrayList<Int>()
            l.addAll(list)
            l.add(array[i])
            ans.add(l)//这里要添加一个副本，因为list集合在下方有所改动(本质上传递的是地址，可能会引起ans中已存在改动)
            return
        }else if(array[i]+sum>target){
            return
        }else {
            list.add(array[i])
            solve(array,target,sum+array[i],i,list)
            list.remove(array[i])//return后进行回溯
        }
    }
}