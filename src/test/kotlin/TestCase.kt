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
    fun  testCase6() {
        //示例 1：
        //输入：s = "PAYPALISHIRING", numRows = 3
        //输出："PAHNAPLSIIGYIR"
        //示例 2：
        //输入：s = "PAYPALISHIRING", numRows = 4
        //输出："PINALSIGYAHRPI"
        //解释：
        //P     I    N
        //A   L S  I G
        //Y A   H R
        //P     I
        //示例 3：
        //输入：s = "A", numRows = 1
        //输出："A"
        assert(convert("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR")
        assert(convert("PAYPALISHIRING", 4) == "PINALSIGYAHRPI")
        assert(convert("A", 1) == "A")
    }

    @Test
    fun testCase7() {
        //示例 1：
        //输入：x = 123
        //输出：321
        //示例 2：
        //输入：x = -123
        //输出：-321
        //示例 3：
        //输入：x = 120
        //输出：21
        //示例 4：
        //输入：x = 0
        //输出：0
        assert(reverse(123) == 321)
        assert(reverse(-123) == -321)
        assert(reverse(120) == 21)
        assert(reverse(0) == 0)
        assert(reverse(1534236469) == 0)
    }

    @Test
    fun testCase8() {
        //示例 1：
        //输入：s = "42"
        //输出：42
        //解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
        //第 1 步："42"（当前没有读入字符，因为没有前导空格）
        //第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
        //第 3 步："42"（读入 "42"）
        //解析得到整数 42 。
        //由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
        //示例 2：
        //
        //输入：s = "   -42"
        //输出：-42
        //解释：
        //第 1 步："   -42"（读入前导空格，但忽视掉）
        //第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
        //第 3 步："   -42"（读入 "42"）
        //解析得到整数 -42 。
        //由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
        //示例 3：
        //输入：s = "4193 with words"
        //输出：4193
        //解释：
        //第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
        //第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
        //第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
        //解析得到整数 4193 。
        //由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
        assert(myAtoi("42") == 42)
        assert(myAtoi("   -42") == -42)
        assert(myAtoi("4193 with words") == 4193)
        assert(myAtoi("-91283472332") == -2147483648)
    }

    @Test
    fun testCase9() {
        //示例 1：
        //输入：x = 121
        //输出：true
        //示例 2：
        //输入：x = -121
        //输出：false
        //解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
        //示例 3：
        //输入：x = 10
        //输出：false
        //解释：从右向左读, 为 01 。因此它不是一个回文数。
        //示例 4：
        //输入：x = -101
        //输出：false
        assert(isPalindrome(121))
        assert(!isPalindrome(-121))
        assert(!isPalindrome(10))
        assert(!isPalindrome(-101))
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