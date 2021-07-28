/**
 * 17.电话号码的字母组合
 *
 * 用回朔算法求解(递归)
 *
 * 无返回值的递归算法中不需要进行return只需要if else结构体即可，可以用传参的形式保存递归时的中间值直至获得最终结果
 *
 * kotlin中常用的list类型：ArrayList       常用的map类型：HashMap
 * 在处理字符串及集合时，可以优先考虑调用api辅助完成
 */
val result= arrayListOf<String>()
val map= hashMapOf<Int,String>(2 to "abc",3 to "def",4 to "ghi",5 to "jkl",6 to "mno",7 to "pqrs",8 to "tuv",9 to "wxyz")

fun main() {
    letterCombinations("234")
    for(i in result){
        println(i)
    }
}

fun letterCombinations(digits: String): List<String> {
    return if(digits.isEmpty()){
        arrayListOf()
    }else {
        dfs("",digits)
        result
    }
}

fun dfs(key: String,value: String){
    if(value.length==0){
        result.add(key)
    }else {
        for(char in map[value.substring(0,1).toInt()]!!){
            dfs(key+char, value.substring(1,value.length))
        }
    }
}