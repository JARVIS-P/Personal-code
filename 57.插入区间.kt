/**
 * 57.插入区间
 *
 * 本质上是一道偏简单的题，以后再做题时需要更加细致认真的分析问题
 *
 * kotlin中的Array本质上是一个数组，要与ArrayList集合区分开来
 * 我们可以用emptyArray方法来创建一个空数组
 */
fun insert(intervals: Array<IntArray>, newInterval: IntArray): ArrayList<IntArray> {
    var left=newInterval[0]
    var right=newInterval[1]
    var flag=false
    val result=ArrayList<IntArray>()

    for(list in intervals){
        if(list[0]>right){//当区间在待插入区间右侧时直接加入答案
            if(!flag){//当第一次发现有区间在待插入区间右侧时则先插入合并后的待插入区间
                result.add(intArrayOf(left,right))
                flag=true
            }
            result.add(list)
        } else if(list[1]<left){//当区间在待插入区间左侧时则直接加入答案
            result.add(list)
        } else {//当区间与待插入区间有交集时，则合并两区间并更新left和right
            left=kotlin.math.min(left,list[0])
            right=kotlin.math.max(right,list[1])
        }
    }

    if(!flag){//处理不需要合并区间的情况
        result.add(intArrayOf(left,right))
    }

    return result
}