import java.util.Stack

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
    val stack = Stack<Char>()
    for (c in s) {
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c)
        } else {
            if (stack.isEmpty()) return false
            val last = stack.pop()
            if (c == ')' && last != '(')  return false
            if (c == ']' && last != '[')  return false
            if (c == '}' && last != '{')  return false
        }
    }
    return stack.isEmpty()
}