/**
 * 29.两数相除
 *
 * 用快速逼近法解决
 *
 * 暴力做解固然简单但很容易超时，做题前的想法一定要优雅
 */

fun divide(dividend: Int, divisor: Int): Int {//快速逼近结果(加法逼近的话效率太慢易超时)
    //对特殊情况进行处理
    if(dividend==0) return 0
    if(divisor==1) return dividend
    if(divisor==-1){
        if(dividend>Int.MIN_VALUE) return -dividend
        return Int.MAX_VALUE//在int类型的表示范围内负数比整数多了个1，所以此时若dividend<Int.MIN_VALUE的话我们不能直接返回-dividend而是要返回Int.MAX_VALUE
    }

    var a:Long=dividend.toLong()
    var b:Long=divisor.toLong()
    var sign=1

    if((a>0&&b<0)||(a<0&&b>0)){
        sign =-1
    }
    a=if (a>0) a else -a
    b=if (b>0) b else -b

    val result=div(a, b)
    if(sign>0) {
        return if(result>Int.MAX_VALUE) Int.MAX_VALUE else result.toInt()
    }
    return -result.toInt()
}

fun div(a:Long,b:Long):Long{//举例：a=11，b,tb=3，count=1;3<11，3翻倍，count=2翻倍;6<11，6翻倍，count=4翻倍;12>11，所以结果在2到4之间(result=2+?);
                            //接着观察(11-6)/3的值(递归思想得出现)，最终得到结果为result=count+div(a-tb,b)
    if(a<b) return 0
    var count:Long=1
    var tb:Long=b//之后我们不再改变b的值
    while((tb+tb)<=a){
        count=count+count//最小解翻倍
        tb=tb+tb//当前测试值翻倍
    }
    return count+div(a-tb,b)
}

fun divide01(dividend: Int, divisor: Int): Int {//用加法模拟乘法(超出时间限制)
    var f=true
    var a=dividend.toLong()
    var b=divisor.toLong()
    var sum=0

    a=Math.abs(a)
    b=Math.abs(b)

    if((dividend<0&&divisor>0)||(dividend>0&&divisor<0)){
        f=false
    }

    if(dividend<=Int.MIN_VALUE){
        a=a-1
    }

    if(a<b){
        return 0
    }

    val temp=b
    while (a>=b){
        b=b+temp
        sum++
    }

    if(f){
        return sum
    }

    return 0-sum
}