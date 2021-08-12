import java.lang.StringBuilder

/**
 * 44.字符串相乘
 *
 * 用加法模拟乘法
 *
 * 在kotlin中将字符转为Int类型，可能会出错，建议先将字符转为字符串再转为Int类型：“8”.toString().toInt()
 * 在kotlin中直接用str=str+'8'做字符串拼接，可能出错，建议用StringBuilder的append方法字符串的拼接
 */
fun main() {
    println(multiply("7188","102"))
}

fun multiply(num1: String, num2: String): String {
    var result="0"
    var temp=""
    val long=if(num1.length>num2.length) num1 else num2
    val short=if(long==num1) num2 else num1
    val tNum2=short.reversed()
    for(i in 0..short.length-1){
        temp=one(long,tNum2[i].toString())
        for(j in 0..i-1){
            temp=temp+"0"
        }
        result=add(result,temp)
    }
    return result
}

fun one(num:String,num2: String):String{//一个个位数与字符串相乘
    if(num2=="0"){
        return "0"
    }
    var num3=""
    val num1=num.reversed()
    val m=num2.toInt()
    var temp=0;
    for(i in 0..num.length-1){
        var middle=0
        middle=((num1[i].toString().toInt())*m+temp)%10;
        num3=num3+middle
        temp=((num1[i].toString().toInt())*m+temp)/10
    }
    if(temp==0) return num3.reversed()
    return (num3+temp).reversed()
}

fun add(num: String,num02: String):String{//字符串相加
    var num3=StringBuilder("")
    val num1=num.reversed()
    val num2=num02.reversed()
    var temp=0;
    val long=if(num1.length>num2.length) num1.length else num2.length
    for(i in 0..long-1){
        var middle=0
        if(i>=num1.length){
            middle=(num2[i].toString().toInt()+temp)%10;
            num3=num3.append(middle);
            temp=(num2[i].toString().toInt()+temp)/10;
        } else if(i>=num2.length){
            middle=(num1[i].toString().toInt()+temp)%10;
            num3=num3.append(middle);
            temp=(num1[i].toString().toInt()+temp)/10;
        } else {
            middle=(num1[i].toString().toInt()+num2[i].toString().toInt()+temp)%10;
            num3=num3.append(middle);
            temp=(num1[i].toString().toInt()+num2[i].toString().toInt()+temp)/10
        }
    }
    if(temp==0) return num3.toString().reversed()
    return (num3.append(temp)).toString().reversed()
}