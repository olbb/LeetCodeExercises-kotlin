import kotlin.test.Test

/**
 * @author JuanLv created at 2023/3/14
 * olbbme@gmail.com
 */
class TestCase {

    @Test
    fun test1() {
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
    fun test20() {
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