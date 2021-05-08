/**
 * 47.全排列II
 *
 * 全排列的进阶版(原集合中可以存在重复的数，但结果中不能有重复的集合)
 *
 * 只需要在添加最终答案的时候进行判断即可
 */
fun main() {
    val nums=permuteUnique(intArrayOf(1,1,2,2))
    for(i in nums){
        println(i)
    }
}

fun permuteUnique(nums: IntArray): List<List<Int>> {
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
                if(!res.contains(t)){
                    res.add(t)
                }
            }
            val t=ArrayList<Int>()
            t.addAll(temp[j])
            t.add(nums[i])
            if(!res.contains(t)){
                res.add(t)
            }
        }
        temp = res
        if(i!=nums.lastIndex) res=arrayListOf<ArrayList<Int>>()
    }
    return res
}