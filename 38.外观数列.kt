import java.lang.StringBuilder

/**
 * 38.外观数组
 *
 * 一个比较简单的题，按照题目描述编写代码即可
 */
fun main() {
    println(countAndSay(5))
}

fun countAndSay(n: Int): String {
    var result= StringBuilder("1")
    for(i in 0..n-2){//迭代到需要的位置
        result=dfs(result, StringBuilder(""))
    }
    return result.toString()
}

fun dfs(str:StringBuilder,result:StringBuilder):StringBuilder{//描述当前的字符串
    var count=0
    var i=0
    while(i<=str.length-1){
        count=1
        var temp=i
        while(temp<=str.length-2&&str[temp]==str[temp+1]) {
            temp++
            count++
        }
        i=temp+1
        result.append(count)
        result.append(str[i-1])
    }
    return result

}