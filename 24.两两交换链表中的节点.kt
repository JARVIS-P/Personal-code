/**
 * 24.两两交换链表中的节点
 *
 * 可以用迭代或递归解决
 *
 * 迭代：在遍历链表时可以在每次循环中多定义中间变量，可以避免处理过多的指针关系(处理链表的指针关系时，可以依靠画图帮助理解)
 *
 * 递归：递归代码的本质依然是迭代(在递归中可以看到迭代的影子)
 */
fun main() {
    var head:ListNode?=ListNode(1)
    val node2=ListNode(2)
    val node3=ListNode(3)
    val node4=ListNode(4)
    val node5=ListNode(5)
    head?.next=node2
    node2.next=node3
    node3.next=node4
    node4.next=node5
    head=swapPairs(head)
    while (head!=null){
        println(head.`val`)
        head=head.next
    }
}

fun swapPairs(head: ListNode?): ListNode? {//迭代
    val mHead:ListNode?=ListNode(0)
    mHead?.next=head
    var temp=mHead
    var head01=head

    while(temp?.next!=null&&temp.next?.next!=null){
        val node01=temp.next
        val node02=temp.next?.next
        temp.next=node02
        node01?.next=node02?.next
        node02?.next=node01
        temp=node01
    }
    return mHead?.next
}

fun swapPairs02(head: ListNode?):ListNode?{//递归
    if(head==null||head.next==null){
        return head
    }

    //head为node1,newHead为node2
    val newHead=head.next
    head.next=swapPairs02(newHead?.next)//node1.next=node2.next
    newHead?.next=head//node2.next=node1
    return newHead
}