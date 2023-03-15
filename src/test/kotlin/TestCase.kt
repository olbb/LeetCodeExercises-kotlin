import kotlin.test.Test

/**
 * @author JuanLv created at 2023/3/14
 * olbbme@gmail.com
 */
class TestCase {

    @Test
    fun testCase1() {
        //示例 1：
        //输入：nums = [2,7,11,15], target = 9
        //输出：[0,1]
        //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
        //示例 2：
        //输入：nums = [3,2,4], target = 6
        //输出：[1,2]
        //示例 3：
        //输入：nums = [3,3], target = 6
        //输出：[0,1]
        //提示：
        //2 <= nums.length <= 104
        //-109 <= nums[i] <= 109
        //-109 <= target <= 109
        //只会存在一个有效答案
        //进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
        assert(twoSum(intArrayOf(2, 7, 11, 15), 9).contentEquals(intArrayOf(0, 1)))
        assert(twoSum(intArrayOf(3, 2, 4), 6).contentEquals(intArrayOf(1, 2)))
        assert(twoSum(intArrayOf(3, 3), 6).contentEquals(intArrayOf(0, 1)))

        assert(twoSumCase2(intArrayOf(2, 7, 11, 15), 9).contentEquals(intArrayOf(0, 1)))
        assert(twoSumCase2(intArrayOf(3, 2, 4), 6).contentEquals(intArrayOf(1, 2)))
        assert(twoSumCase2(intArrayOf(3, 3), 6).contentEquals(intArrayOf(0, 1)))
    }

    @Test
    fun testCase2() {
        //示例 1：
        //输入：l1 = [2,4,3], l2 = [5,6,4]
        //输出：[7,0,8]
        //解释：342 + 465 = 807.
        //示例 2：
        //输入：l1 = [0], l2 = [0]
        //输出：[0]
        //示例 3：
        //输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        //输出：[8,9,9,9,0,0,0,1]

        var l1 = ListNode(2)
        l1.next = ListNode(4)
        var next = l1.next
        next?.next = ListNode(3)

        var l2 = ListNode(5)
        l2.next = ListNode(6)
        next = l2.next
        next?.next = ListNode(4)
        assert(addTwoNumbers(l1, l2).toString() == "7->0->8")

        l1 = ListNode(0)
        l2 = ListNode(0)
        assert(addTwoNumbers(l1, l2).toString() == "0")

        l1 = ListNode(9)
        l1.next = ListNode(9)
        next = l1.next
        next?.next = ListNode(9)
        next = next?.next
        next?.next = ListNode(9)
        next = next?.next
        next?.next = ListNode(9)
        next = next?.next
        next?.next = ListNode(9)
        next = next?.next
        next?.next = ListNode(9)

        l2 = ListNode(9)
        l2.next = ListNode(9)
        next = l2.next
        next?.next = ListNode(9)
        next = next?.next
        next?.next = ListNode(9)
        assert(addTwoNumbers(l1, l2).toString() == "8->9->9->9->0->0->0->1")




    }

    @Test
    fun testCase20() {
        //示例 1：
        //输入：s = "()"
        //输出：true
        //示例 2：
        //输入：s = "()[]{}"
        //输出：true
        //示例 3：
        //输入：s = "(]"
        //输出：false
        assert(isValid("()"))
        assert(isValid("()[]{}"))
        assert(!isValid("(]"))
        assert(!isValid("["))
        assert(!isValid("(("))
    }


}