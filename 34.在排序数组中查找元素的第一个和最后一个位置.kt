/**
 * 34.在排序数组中查找元素的第一个和最后一个位置
 *
 * 借助二分法可以以O(log(n))的时间复杂度解决该问题
 */
fun searchRange(nums: IntArray, target: Int): IntArray {//二分查找得到其中一个目标值的下标，再利用该下标在其左右找到待查元素得第一个和最后一个位置
    var start=-1
    var end=-1

    if(nums.size==0) return intArrayOf(start,end)
    if(nums.size==1){
        if(nums[0]==target){
            start=0
            end=0
            return intArrayOf(start,end)
        }
    }

    var result=find(nums, target)
    if(result==-1) return intArrayOf(start,end)
    var temp=result
    while(temp>=0&&nums[temp]==target) temp--
    start=temp+1
    while(result<=nums.size-1&&nums[result]==target) result++
    end=result-1

    return intArrayOf(start,end)
}

fun find(nums: IntArray,target: Int): Int{//正经二分查找
    var l=0
    var r=nums.size-1
    while(l<=r){
        val mid=(l+r)/2
        if(nums[mid]==target) return mid
        if(nums[mid]<target){
            l=mid+1
        }else {
            r=mid-1
        }
    }
    return -1
}

fun searchRange01(nums: IntArray, target: Int): IntArray {//暴力破解
    var start=-1
    var end=-1

    if(nums.size==0) return intArrayOf(start,end)
    if(nums.size==1){
        if(nums[0]==target){
            start=0
            end=0
            return intArrayOf(start,end)
        }
    }
    for(i in 0..nums.size-1){
        if(nums[i]==target){
            start=i
            var t=i+1
            while(t<=nums.size-1&&nums[t]==target) t=t+1
            end=t-1
            break
        }
    }
    return intArrayOf(start,end)
}
