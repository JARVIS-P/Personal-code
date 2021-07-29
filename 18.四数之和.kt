/**
 * 18.四数之和
 *
 * 两数之和，三数之和，最接近的三数之和，四数之和等，这类题的解法思想都类似于先排序再采用双指针
 *
 * 双指针法可以用于降低循环层数(例；暴力法需两层循环，二双指针法则只需要一层循环)
 */
fun main() {
    val list = fourSum(intArrayOf(-2, -1, -1, 1, 1, 2, 2), 0)
    println(list)
}

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {//排序后再采用双指针法
    val result= arrayListOf<List<Int>>()
    if(nums.size<4){
        return listOf<List<Int>>()
    }
    nums.sort();

    var m:Int
    var n:Int
    for (i in 0 until nums.size-3){
        if(i>0&&nums[i]==nums[i-1]) continue//避免i位重复
        for (j in i+1 until nums.size-2){
            if(j>i+1&&nums[j]==nums[j-1]) continue//避免j位重复
            m=j+1
            n=nums.size-1
            while (m<n){
                val temp=nums[i]+nums[j]+nums[m]+nums[n]
                if(temp>target) n--
                if(temp==target) {
                    result.add(listOf(nums[i],nums[j],nums[m],nums[n]))
                    //只需要在计入result后避免重复即可，因此只需要在temp==target时进行避免重复操作
                    while(m<n&&nums[m]==nums[++m]){//避免m位重复

                    }
                    while(m<n&&nums[n]==nums[--n]){//避免n位重复

                    }
                }
                if(temp<target) m++
            }
        }
    }
    return result
}