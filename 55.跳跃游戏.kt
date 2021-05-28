/**
 * 55.跳跃游戏
 *
 * 一个算是比较简单的贪心算法的应用，贪心算法这块还是得加强
 */
fun canJump(nums: IntArray): Boolean {//贪心算法，maxPos用于存储当前能达到的最大值
    val n=nums.size
    var maxPos=0
    for(i in 0..n-1){
        if(i<=maxPos){//可能跳到到某一个位置就没法跳了，因此需要判断跳跃是否会中断
            maxPos=kotlin.math.max(maxPos,i+nums[i])
            if(maxPos>=n-1){
                return true
            }
        }
    }
    return false
}

fun canJump01(nums: IntArray): Boolean {//根据跳跃游戏II改编得来的，不过跳跃游戏II默认可以到达，所以没做是否会中断的检测，所以代码存在问题
    var end=0
    var maxPos=0
    if(nums.size>1&&nums[0]==0){
        return false
    }
    for(i in 0 until nums.size-1){
        maxPos=kotlin.math.max(maxPos,nums[i]+i)
        if(i==end){
            end=maxPos
        }
    }
    if(maxPos>=nums.lastIndex){
        return true
    }
    return false
}