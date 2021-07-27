import kotlin.math.absoluteValue

/**
 * 16.最接近的三数之和
 *
 *  解法：排序后再用双指针法
 *
 *  kotlin中创建集合若直接用集合构造器的话需要传入size大小，而用...of函数的话则直接传入数据即可
 */
fun main() {
    println(threeSumClosest(intArrayOf(1,1,1,0),100))
}

fun threeSumClosest(nums: IntArray, target: Int): Int {//排序后再用双指针法
    nums.sort()
    var temp:Int
    var result=nums[0]+nums[1]+nums[2]-target
    for(i in 0 until nums.size-2){
        var j=i+1
        var k=nums.size-1
        if(i>0&&nums[i-1]==nums[i]) continue//保证nums[i]不重复，其中i>0要先判断不然会出错(优化)
        //if(nums[i]==nums[j]) 我的最初写法，是有问题的(该判断是保证重复数中的最后一个进入循环，但数组中的最后两个数是不进入循环的因此可能会导致错误的发生)
        while(j<k){
            temp=nums[i]+nums[j]+nums[k]-target
            if(Math.abs(temp)<Math.abs(result)){//判断两个数是否接近，比较的是绝对值
                result=temp
            }
            if(temp==0) break
            if(temp<0){
                var j0=j+1
                while(j0<k&&nums[j0]==nums[j]){//避免nums[j]之后的元素与其重复(优化)
                    j0++
                }
                j=j0
            }
            if(temp>0){
                var k0=k-1
                while(j<k0&&nums[k]==nums[k0]){//避免nums[k]之前的元素与其重复(优化)
                    k0--
                }
                k=k0
            }
        }
    }
    return result+target
}