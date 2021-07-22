import java.lang.StringBuilder

/**
 * 8.字符串转换整数
 *
 * kotlin中的字符串可以当字符数组用
 * Int.MAX_VALUE和Int.MIN_VALUE代表Int类型的最大最小值
 */

fun myAtoi(s: String): Int {
    val string=s.trim()//去除多余括号
    val result= StringBuilder("")
    if(string.isEmpty()) return 0

    var index=0
    var m=1
    if(string.first()=='+'){//判读首位，同时确定正负
        index=1
    }else if(string.first()=='-'){
        index=1
        m=-1
    }else if(string.first()-'0'<0||string.first()-'0'>9){
        return 0
    }
    while(index<string.length){//循环读入字符
        val data=string[index]-'0'

        if(data>=0&&data<=9){
            result.append(data)
            if(result.toString().toLong()*m>=Int.MAX_VALUE){//判断是否越界(每添加一个字符都进行以一次判断，以免最终结果超过Long的范围)
                return Int.MAX_VALUE
            }else if(result.toString().toLong()*m<=Int.MIN_VALUE){
                return Int.MIN_VALUE
            }
        }else{
            break
        }

        index++
    }

    if(result.isEmpty()){
        return 0
    }

    val a:Int=result.toString().toInt()*m

    return a
}