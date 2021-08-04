/**
 * 33.搜索旋转排序数组(二分查找的妙用)
 */
fun search(nums: IntArray, target: Int): Int {//二分查找：时间复杂度O(log(n))
    val n=nums.size
    if(n==0){
        return -1
    }
    if(n==1){
        return if(nums[0]==target) 0 else -1
    }

    var l=0
    var r=n-1

    while(l<=r){
        val mid=(l+r)/2
        if(nums[mid]==target) return mid
        if(nums[0]<=nums[mid]){//旋转数组从中间分开一定有一边的数组是有序的，由此改变二分查找的上下界
            if(nums[0]<=target&&target<nums[mid]){
                r=mid-1
            }else {
                l=mid+1
            }
        }else {
            if(nums[mid]<target&&target<=nums[n-1]){
                l=mid+1
            }else {
                r=mid-1
            }
        }
    }

    return -1
}

fun search01(nums: IntArray, target: Int): Int {//暴力破解：时间复杂度O(n)
    for(i in 0..nums.size-1){
        if(nums[i]==target){
            return i
        }
    }
    return -1
}