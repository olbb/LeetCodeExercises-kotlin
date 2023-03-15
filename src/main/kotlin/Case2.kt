/**
 * @author JuanLv created at 2023/3/15
 * olbbme@gmail.com
 */
/*
2. 两数相加 中等
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例 1：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：
输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
提示：
每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零
 */

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val node = sum(l1, l2, 0)
    var next1 = l1?.next
    var next2 = l2?.next
    var tmp = node
    while (tmp != null) {
        val left = tmp.`val` / 10
        tmp.`val` = tmp.`val` % 10
        tmp.next = sum(next1, next2, left)
        tmp = tmp.next
        next1 = next1?.next
        next2 = next2?.next
    }
    return node
}

private fun sum(l1: ListNode?, l2: ListNode?, left: Int): ListNode? {
    if (l1 == null && l2 == null && left == 0) {
        return null
    }
    val sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + left
    return ListNode(sum, null)
}

data class ListNode(var `val`: Int, var next:ListNode?) {

    override fun toString(): String {
        StringBuilder().apply {
            var tmp:ListNode? = this@ListNode
            while (tmp != null) {
                if (tmp != this@ListNode) {
                    append("->")
                }
                append(tmp.`val`)
                tmp = tmp.next
            }
        }.let {
            return it.toString()
        }
    }

    constructor(`val`: Int) : this(`val`, null)
}