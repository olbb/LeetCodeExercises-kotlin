import kotlin.math.ceil

/**
 * @author JuanLv created at 2023/3/20
 * olbbme@gmail.com
 */
/*
6. N 字形变换 中等
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);
示例 1：
输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
示例 3：
输入：s = "A", numRows = 1
输出："A"
提示：
1 <= s.length <= 1000
s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000
 */

fun convert(s: String, numRows: Int): String {
    //每一次循环能排列的字符数为2*numRows-2
    //每一次循环需要的列数为numRows-1
    //所以每次循环的总列数为字符长度
    //ceil(len/(2*numRows-2))*(numRows-1)

    val len = s.length
    if (len <= numRows || numRows == 1) {
        return s
    }
    val sb = StringBuffer()
    val perCount = 2 * numRows - 2
    val cycles = ceil(len.toDouble() / perCount).toInt()
    val col = cycles * (numRows - 1)
    for (i in 0 until numRows) {
        for (j in 0 until col) {
            val index = j * perCount + i
            if (index < len) {
                sb.append(s[index])
            }
            if (i != 0 && i != numRows - 1) {
                val index2 = (j + 1) * perCount - i
                if (index2 < len) {
                    sb.append(s[index2])
                }
            }
        }
    }
    return sb.toString()
}