/**
 * 31.下一个排列(返回字典序中的下一个)
 *
 * kotlin中的sort函数可以指定排序的起点和终点
 */
fun main() {
    var nums= intArrayOf(5,1,2,4,3)
    nextPermutation(nums)
}

fun nextPermutation(nums: IntArray): Unit {//从右到左，找到第一个下降的数字，交换到后面最后一个比其大的数字，然后将后面的数字逆序排列
    var sort=true
    for(i in 0 until nums.size-1){
        if(nums[i]<nums[i+1]) sort=false
    }

    if(sort) return nums.reverse()

    var flag=-1
    for(i in nums.size-2 downTo 0){//找到第一个降序的位置，记为flag
        if(nums[i]<nums[i+1]){
            flag=i
            break
        }
    }

    for(i in nums.size-1 downTo flag){
        if(nums[i]>nums[flag]){//从后往前找到第一个比flag大的元素，两者交换位置
            val temp=nums[i]
            nums[i]=nums[flag]
            nums[flag]=temp
            break
        }
    }

    nums.sort(flag+1,nums.size)//flag之后的元素按升序排列
}