/**
 * 50.Pow(x,n)
 *
 * 快速幂的迭代和递归两种实现，新知识需要理解记忆
 */
fun myPow(x: Double, n: Int): Double {
    return if(n>0) quickMul(x,n.toLong()) else 1.0/quickMul(x,-n.toLong())
}

fun quickMul(x :Double,n :Long): Double {//快速幂+迭代
    //举例：x^77:x*x^4*x^8*x^64(因为1+4+8+64=77，而这刚好是77的二进制中每个1的位：1001101，因此我们可以利用二进制的拆分来解决这个问题)
    var ans=1.0
    var dynamic=x
    var temp=n
    while(temp>0){
        if(temp%2==1L){
            ans=ans*dynamic//每当二进制位为1时，乘入ans中
        }

        dynamic=dynamic*dynamic
        temp=temp/2
    }
    return ans
}

fun quickMul01(x :Double,n :Long): Double {//快速幂+递归(x开始，每次直接把上一次的结果进行平方，而不用每次都乘x)
    //举例：x^64:x->x^2->x^4->x^8->x^16->x^32->x^64
    //举例：x^77:x->x^2->x^4->x^9->x^19->x^38->x^77
    if(n==0L){
        return 1.0
    }
    val y=quickMul(x,n/2)//每次为除法向下取整，因此每次当n%2==1时就要给结果多乘一个x
    return if(n%2==0L) y*y else y*y*x
}