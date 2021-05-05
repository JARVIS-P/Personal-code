/**
 * 46.全排列
 *
 * 回溯算法：一种通过探索所有可能的候选解来找出所有的解的算法。如果候选解被确认不是一个解（或者至少不是最后一个解），回溯算法会通过在上一步进行一些变化抛弃该解，
 * 即回溯并且再次尝试。
 *
 * kotlin中可以使用集合的contains方法来检测集合中是否含有某一元素
 */
fun permute(nums: IntArray): List<List<Int>> {
    val res=ArrayList<ArrayList<Int>>()
    backTrack(nums,ArrayList(),res)
    return res
}

fun backTrack(nums: IntArray,list: ArrayList<Int>,res: ArrayList<ArrayList<Int>>){
    //回朔算法(我们从左往右依此填入题目给定的n个数，每个数只能使用一次，穷举即可)
    if(list.size==nums.size){
        val t=ArrayList<Int>()
        t.addAll(list)
        res.add(t)
        return
    }

    for(i in 0..nums.size-1){
        if(list.contains(nums[i])) continue//判断list中是否存在nums[i](去除已使用的n)
        list.add(nums[i])
        backTrack(nums,list,res)//添加本层的数字后，进入下一层
        list.removeAt(list.size-1)//回溯
    }
}

fun permute01(nums: IntArray): List<List<Int>> {//观察出规律，直接暴力破解
    if(nums.size==1){
        return arrayListOf(arrayListOf(nums[0]))
    }
    var res = arrayListOf<ArrayList<Int>>()
    var temp = arrayListOf<ArrayList<Int>>()
    for(i in 0..nums.lastIndex){
        if(i==0){
            temp.add(arrayListOf(nums[i]))
            continue
        }
        for(j in 0..temp.size-1){
            for(m in 0..temp[j].size-1){
                val t=ArrayList<Int>()
                t.addAll(temp[j])
                t.add(m,nums[i])
                res.add(t)
            }
            val t=ArrayList<Int>()
            t.addAll(temp[j])
            t.add(nums[i])
            res.add(t)
        }
        temp = res
        if(i!=nums.lastIndex) res=arrayListOf<ArrayList<Int>>()
    }
    return res
}
