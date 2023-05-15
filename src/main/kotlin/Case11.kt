import kotlin.math.min

/**
 * @author JuanLv created at 2023/5/15
 */
/**
11. 盛最多水的容器 中等
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
说明：你不能倾斜容器。
 */
fun maxArea(height: IntArray): Int {
    var max = 0
    var left = 0
    var right = height.size - 1
    while (left < right) {
        val area = (right - left) * min(height[left], height[right])
        if (area > max) {
            max = area
        }
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }
    return max
}



fun maxAreaOld(height: IntArray): Int {
    var max = 0
    for (i in height.indices) {
        for (j in i + 1 until height.size) {
            val area = (j - i) * min(height[i], height[j])
            if (area > max) {
                max = area
            }
        }
    }
    return max
}