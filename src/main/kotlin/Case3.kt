/**
 * @author JuanLv created at 2023/3/15
 * olbbme@gmail.com
 */
/**
 3. 无重复字符的最长子串 中等
 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 示例 1:
 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:
 输入: s = "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:
 输入: s = "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 提示：
 0 <= s.length <= 5 * 104
 s 由英文字母、数字、符号和空格组成
 */
fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0
    var maxStr = ""
    val tmpStr = StringBuilder()
    for (i in s.indices) {
        for (j in i until s.length) {
            if (tmpStr.contains(s[j])) {
                if (tmpStr.length > maxStr.length) {
                    maxStr = tmpStr.toString()
                }
                tmpStr.clear()
                break
            } else {
                tmpStr.append(s[j])
            }
        }
    }
    if (tmpStr.length > maxStr.length) {
        maxStr = tmpStr.toString()
    }
    return maxStr.length
}


fun lengthOfLongestSubstringNoStr(s: String): Int {
    if (s.isEmpty()) return 0
    var maxL = 0
    val tmpStr = mutableSetOf<Char>()
    for (i in s.indices) {
        for (j in i until s.length) {
            if (tmpStr.contains(s[j])) {
                if (tmpStr.size > maxL) {
                    maxL = tmpStr.size
                }
                tmpStr.clear()
                break
            } else {
                tmpStr.add(s[j])
            }
        }
    }
    if (tmpStr.size > maxL) {
        maxL = tmpStr.size
    }
    return maxL
}
