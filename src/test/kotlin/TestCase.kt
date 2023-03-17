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
    fun test3() {
        //示例 1:
        // 输入: s = "abcabcbb"
        // 输出: 3
        // 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        // 示例 2:
        // 输入: s = "bbbbb"
        // 输出: 1
        // 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        // 示例 3:
        // 输入: s = "pwwkew"
        // 输出: 3
        // 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        assert(lengthOfLongestSubstring("abcabcbb") == 3)
        assert(lengthOfLongestSubstring("bbbbb") == 1)
        assert(lengthOfLongestSubstring("pwwkew") == 3)
        assert(lengthOfLongestSubstring(" ") == 1)

        assert(lengthOfLongestSubstringNoStr("abcabcbb") == 3)
        assert(lengthOfLongestSubstringNoStr("bbbbb") == 1)
        assert(lengthOfLongestSubstringNoStr("pwwkew") == 3)
        assert(lengthOfLongestSubstringNoStr(" ") == 1)
    }

    @Test
    fun testCase4() {
        //示例 1：
        //输入：nums1 = [1,3], nums2 = [2]
        //输出：2.00000
        //解释：合并数组 = [1,2,3] ，中位数 2
        //示例 2：
        //输入：nums1 = [1,2], nums2 = [3,4]
        //输出：2.50000
        //解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
        assert(findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)) == 2.0)
        assert(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)) == 2.5)
        assert(findMedianSortedArrays(intArrayOf(2, 2, 4, 4), intArrayOf(2, 2, 4, 4)) == 3.0)

        assert(findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)) == 2.0)
        assert(findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)) == 2.5)
        assert(findMedianSortedArrays(intArrayOf(0, 0), intArrayOf(0, 0)) == 0.0)
        assert(findMedianSortedArrays(intArrayOf(), intArrayOf(1)) == 1.0)
        assert(findMedianSortedArrays(intArrayOf(2), intArrayOf()) == 2.0)
    }

    @Test
    fun testCase5() {
        //示例 1：
        //输入：s = "babad"
        //输出："bab"
        //解释："aba" 同样是符合题意的答案。
        //示例 2：
        //输入：s = "cbbd"
        //输出："bb"
        //示例 3：
        //输入：s = "a"
        //输出："a"
        //示例 4：
        //输入：s = "ac"
        //输出："a"
        assert(longestPalindrome("babad") == "bab")
        assert(longestPalindrome("cbbd") == "bb")
        assert(longestPalindrome("a") == "a")
        assert(longestPalindrome("ac") == "a")
        assert(longestPalindrome("ccc") == "ccc")
        assert(longestPalindrome("bb") == "bb")
        assert(longestPalindrome("aaaa") == "aaaa")
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