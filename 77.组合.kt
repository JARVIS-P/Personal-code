/**
 * 77.组合
 *
 * 回溯算法：如果解决一个问题有多个步骤，每一个步骤有多种方法，题目又要我们找出所有的方法，可以使用回溯算法(类似于树的遍历算法)；
 *
 * kotlin中，集合的remove(i)方法是删除集合中所有数据为i的元素，而removeAt(i)方法是删除第i位的元素
 */
val array = arrayListOf<List<Int>>()
val temp= arrayListOf<Int>()

fun combine(n: Int, k: Int): List<List<Int>> {
    dfs(1,n,k)
    return array
}

fun dfs(cur: Int, n: Int, k: Int){//一般情况下都是这个模板
    //剪枝操作，temp长度加上区间[cur,n]的长度小于k，不可能构造出长度为k的temp
    if(temp.size+(n-cur+1)<k){
        return
    }

    //记录合法答案
    if(k==temp.size){
        array.add(ArrayList(temp))
        return
    }

    //考虑选择当前位置
    temp.add(cur)
    dfs(cur+1,n,k)
    //考虑不选择当前位置
    temp.removeAt(temp.lastIndex)
    dfs(cur+1,n,k)
}