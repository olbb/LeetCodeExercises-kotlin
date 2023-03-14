/**
 * @author JuanLv created at 2023/3/14
 * olbbme@gmail.com
 */
/**
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。

示例 1：
输入：s = "()"
输出：true
示例 2：
输入：s = "()[]{}"
输出：true
示例 3：
输入：s = "(]"
输出：false

提示：
1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
 */

fun isValid(s: String): Boolean {
    if (s.isEmpty()) return false
    if (s.length % 2 != 0) return false

    val acceptChars = setOf('(', ')', '{', '}', '[', ']')
    val stack = mutableListOf<Char>()

    for (c in s) {
        if (!acceptChars.contains(c)) return false
        val index = acceptChars.indexOf(c)
        if (index % 2 == 0) {
            stack.add(c)
        } else {
            if (stack.isEmpty()) return false
            if (stack.last() != acceptChars.elementAt(index - 1)) return false
            stack.removeAt(stack.lastIndex)
        }
    }
    return stack.isEmpty()
}