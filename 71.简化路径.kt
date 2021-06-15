import java.lang.StringBuilder
import java.util.*
/**
 * 71.简化路径
 *
 * 遇到“..”就出栈遇到“.”不变其他情况都进栈
 *
 * 程序=算法+数据结构，选择合适的集合可以让解题事半功倍
 *
 * 注意：在使用下标遍历集合时需要时刻注意越界问题
 */
fun simplifyPath(path: String): String {
    val stack=Stack<String>()
    val result= StringBuilder()

    var temp = StringBuilder()
    var i=0
    while(i<path.length){
        if(path[i]!='/'){
            while (true){
                temp.append(path[i])
                i++
                if(i==path.length||path[i]=='/') break
            }
            if(".." == temp.toString()){
                if(!stack.isEmpty()){
                    stack.pop()
                }
            }else if("." != temp.toString()) {
                stack.push(temp.toString())
            }
            temp=StringBuilder()
        }else{
            i++
        }
    }

    if(stack.isEmpty()){
        return "/"
    }

    for(j in stack){
        result.append("/")
        result.append(j)
    }

    return result.toString()
}