import kotlin.test.Test

/**
 * @author JuanLv created at 2023/3/14
 * olbbme@gmail.com
 */
class TestCase {

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