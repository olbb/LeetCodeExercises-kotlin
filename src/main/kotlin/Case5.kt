/**
 * @author JuanLv created at 2023/3/17
 * olbbme@gmail.com
 */
/**
5. 最长回文子串 中等
给你一个字符串 s，找到 s 中最长的回文子串。
如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：
输入：s = "cbbd"
输出："bb"
提示：
1 <= s.length <= 1000
s 仅由数字和英文字母组成
 */
fun longestPalindrome(s: String): String {
    var maxStr = ""
    val l = s.length
    s.forEachIndexed { index, c ->
        var left = index
        var right = index
        var selfAlign = true
        while (left >= 0 && right < l - 1) {
            if (left > 0 && s[left-1] == s[right+1]) {
                left--
                right++
                selfAlign = false
            } else if (selfAlign && left > 0 && s[left - 1] == c) {
                left--
            } else if (selfAlign && s[right + 1] == c) {
                right++
            } else {
                break
            }
        }
        if (right - left + 1 > maxStr.length) {
            maxStr = s.substring(left, right + 1)
//            println("set maxStr to $maxStr")
        }
    }
    return maxStr
}