/**
 * 15.三数之和
 *
 * 注意审题(关注题中的关键字，往往能给出一些提示)   数组题常用的方法：排序，双指针
 *
 * mutableListOf kotlin中的可变列表
 * 在kotlin中可以用when代替大量的if else
 */
fun threeSum(nums: IntArray): List<List<Int>> {//排序后再采用双指针法
    var result= mutableListOf<List<Int>>()//构建一个可变列表
    if(nums.size<3){
        return result
    }

    nums.sort()//排序，好去重也好判断该找大的数还是小的数
    for(i in 0 until nums.size-2){//从左到右依次寻找，因此只需考虑当前数以右的数即可
        if(nums[i]>0) break//当nums[i]>0时，其右的数都比其大，因此不可能凑出0
        if(i>0&&nums[i-1]==nums[i]) continue//避免当前元素重复
        var j=i+1
        var k=nums.size-1
        while(j<k){
            var sum=nums[i]+nums[j]+nums[k]
            when{
                sum>0->k--//大于0，证明过大那么k减小
                sum==0->{
                    result.add(listOf(nums[i],nums[j],nums[k]))
                    while(j<k&&nums[j]==nums[++j]){//避免j对应的元素重复

                    }
                    while(j<k&&nums[k]==nums[--k]){//避免k对应的元素重复

                    }
                }
                else->j++//小于0，证明过小那么j增大
            }
        }
    }

    return result
}