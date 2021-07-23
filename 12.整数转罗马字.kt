fun main(){
    println(intToRoman02(3))
    println(intToRoman02(4))
    println(intToRoman02(9))
    println(intToRoman02(58))
    println(intToRoman02(1994))
}

/**
 * 12.整数转罗马数组(查表法，贪心算法)
 *
 * kotlin中数组的定义方法
 * var字符串可以随意向其尾部加入字符或字符串
 * 在kotlin中尽量用while循环代替java中灵活的for循环
 */
fun intToRoman(num: Int): String {//查表法(无脑硬解)
    val result=StringBuilder("")
    val t=num/1000
    val h=num/100%10
    val ten=num/10%10
    val o=num%10

    if (t!=0){
        for (i in 1..t){
            result.append("M")
        }
    }

    if(h==4){
        result.append("CD")
    }else if(1<=h && h<5){
        for(i in 1..h){
            result.append("C")
        }
    }else if(h==5){
        result.append("D")
    }else if(5<h && h<9){
        result.append("D")
        for(i in 1..(h-5)){
            result.append("C")
        }
    }else if(h==9){
        result.append("CM")
    }

    if(ten==4){
        result.append("XL")
    }else if(1<=ten && ten<5){
        for(i in 1..ten){
            result.append("X")
        }
    }else if(ten==5){
        result.append("L")
    }else if(5<ten && ten<9){
        result.append("L")
        for(i in 1..(ten-5)){
            result.append("X")
        }
    } else if(ten==9){
        result.append("XC")
    }

    if(o==4){
        result.append("IV")
    }else if(1<=o && o<5){
        for(i in 1..o){
            result.append("I")
        }
    }else if(o==5){
        result.append("V")
    }else if(5<o && o<9){
        result.append("V")
        for(i in 1..(o-5)){
            result.append("I")
        }
    }else if(o==9){
        result.append("IX")
    }

    return result.toString()
}

fun intToRoman02(num: Int): String {//贪心算法(贪心算法就是在一堆if else中选择当前最优的解法)
    val number= intArrayOf(1000,900,500,400,100,90,50,40,10,9,5,4,1)
    val string= arrayOf("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I")
    var index=0
    var end=""
    var tempNum=num
    while(index<number.size){
        while(number[index]<=tempNum){//最优情况就是尽可能选择最大的罗马数先去替换
            tempNum=tempNum-number[index]//持续相减直到进入下一个最大值
            end=end+string[index]
        }
        index++
    }
    return end
}

