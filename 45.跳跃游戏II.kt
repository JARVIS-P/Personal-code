/**
 * 45.跳跃游戏II
 *
 * 很典型的一道贪心算法题(贪心算法：用每步的最优解得出全局的最优解)
 *
 * 贪心算法的核心在于：判断好那种情形是最优解(一般根最终达到的目的相关)
 *
 * 在kotlin中可以用kotlin.math来调用kotlin中的math库中的方法
 */
fun main() {
    println(jump(intArrayOf(2,3,1,1,4)))
}

fun jump(nums: IntArray): Int {//贪心算法：找出能达到的最大位置(正确)
    var steps=0
    var end=0
    var maxPos=0
    for(i in 0 until nums.size-1){
        maxPos=kotlin.math.max(maxPos,nums[i]+i)//nums[i]+i：若到达该位置则下一次能到达的最远位置。整段代码用来选出能到达的最远距离
        if (i==end){//每次到达最远距离时，更新最远距离及所用步数
            end=maxPos
            steps++
            println(end)
        }
    }
    return steps
}

fun jump02(nums: IntArray): Int {//贪心算法：找下一步中的最大步数(有问题)
    if(nums.size==1){
        return 0
    }
    var i=0;
    var count=0;
    while(i<nums.lastIndex){
        var max=nums[i+1];
        var index=i+1;
        if(i+nums[i]>=nums.lastIndex){
            return count+1
        }
        for(j in 0..nums[i]-1){
            if(nums[i+j+1]>=max) {
                max=nums[i+j+1]
                println(max)
                index=i+j+1
            }
        }
        i=index
        count++
        if(i+nums[i]>=nums.lastIndex){
            return count+1
        }
    }
    return count
}