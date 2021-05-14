/**
 * 49.字母异位词分组
 *
 * 给每个字符串进行排序，可以很简单的处理这个问题(思考问题要尽量全面，尽可能把所有情况都考虑到)
 *
 * kotlin中集合的forEach{...}方法，相当于给每一个集合中的元素都执行一遍{}里的代码
 * kotlin中map集合可以按照数组的方式进行访问
 */
fun groupAnagrams(strs: Array<String>): List<List<String>> {//排序法，将每个字符串排好序就可以很轻易的进行字母异位词分组了
    if(strs.isEmpty()) return listOf()
    val map= hashMapOf<String,ArrayList<String>>()
    strs.forEach {
        val sorted=it.toCharArray()
        sorted.sort()
        val str= String(sorted)
        if(map[str]==null){
            map[str]= arrayListOf(it)
        } else {
            map[str]?.add(it)
        }
    }

    return map.values.toList()
}

fun groupAnagrams01(strs: Array<String>): List<List<String>> {//把字符串每个字母的Ascll码相加代替字符串(错误)，存在巧合事件
    val result= arrayListOf<ArrayList<String>>()
    val temp= arrayListOf<Int>()
    val number= arrayListOf<Int>()
    for(i in 0..strs.lastIndex){
        var t=0
        for(j in 0..strs[i].lastIndex){
            t=t+strs[i][j].hashCode()
        }
        if(t !in number){
            number.add(t)
        }
        temp.add(t)
    }
    for(i in 0..number.lastIndex){
        val str= arrayListOf<String>()
        for(j in 0..temp.lastIndex){
            if(temp[j]==number[i]){
                str.add(strs[j])
            }
        }
        result.add(str)
    }
    return result
}