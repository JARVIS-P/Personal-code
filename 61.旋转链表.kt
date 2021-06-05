/**
 * 61.旋转链表
 *
 * 链表迭代时应注意截止条件是node!=null还是node.next!=null(行动前想想有没有更好的想法)
 */
fun rotateRight(head: ListNode?, k: Int): ListNode? {//闭合为环，在n+1-(k%n)处断开
    if(head==null){
        return head
    }
    var tail=head
    var size=1
    while(tail?.next!=null){
        tail=tail.next
        size++
    }

    tail?.next=head
    val n=size-(k%size)

    var temp=head
    for(i in 0 until n-1){//找到应断开节点的前一个节点
        temp=temp?.next
    }
    val result=temp?.next
    temp?.next=null//断开
    return result
}

fun rotateRight01(head: ListNode?, k: Int): ListNode? {//用数组暂存数据
    if(head==null){
        return head
    }
    val array= arrayListOf<Int>()
    var tail=head
    var size=1
    while(tail?.next!=null){
        array.add(tail.`val`)
        tail=tail.next
        size++
    }
    array.add(tail!!.`val`)

    tail.next=head
    val n=k%size

    var temp=head
    for(i in 0 until n){//找到开始赋值的起始点
        temp=temp?.next
    }

    for(i in 0 until size){//从起始点往后依次赋数组中的值
        temp?.`val`=array[i]
        temp=temp?.next
    }

    tail.next=null
    return head
}