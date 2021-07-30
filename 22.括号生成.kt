/**
 * 22.括号生成
 *
 * 采用暴力回朔加剪枝的解法，也就是枚举所有类型再筛选出不符合要求的。
 *
 * 回溯法的中心思想：像这种强烈暗示要暴力遍历所有组合（遍历决策树）的题，明显应该采用回溯法
 * 本题结果字符串中的每一位不是'('就是')'，因此获得最终结果的方式是一种决策树机制
 *
 */
fun generateParenthesis(n: Int): List<String> {
    val result= arrayListOf<String>()
    if(n==0) return result
    return generate(n,0,0,"",result)
}

fun generate(n:Int,l:Int,r:Int,str:String,result:ArrayList<String>):List<String>{//暴力回朔加剪枝
    if(l>n||r>l) return result//当左括号大于上限或右括号数大于左括号数时，结束回朔

    if(l==n&&l==r) result.add(str)//当左右括号数均达到上限时向结果列表中加入该字符串

    if(l<n) generate(n,l+1,r,str+"(",result)

    if(r<l) generate(n,l,r+1,str+")",result)

    return result//当所有回朔完成之后才会调用
}