import java.lang.Integer.min

/**
 * @author JuanLv created at 2023/3/15
 * olbbme@gmail.com
 */
/**
4. 寻找两个正序数组的中位数 困难
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
算法的时间复杂度应该为 O(log (m+n)) 。
示例 1：
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：
输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
提示：
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val size1 = nums1.size
    val size2 = nums2.size
    val isEven = (size1 + size2) % 2 == 0
    val left = (size1 + size2 + 1) / 2
    val right = (size1 + size2 + 2) / 2
    return if (!isEven) {
        findSubArray(nums1, 0, size1 - 1, nums2, 0, size2 - 1, left).toDouble()
    } else {
        (findSubArray(nums1, 0, size1 - 1, nums2, 0, size2 - 1, left) +
                findSubArray(nums1, 0, size1 - 1, nums2, 0, size2 - 1, right)) / 2.0
    }
}

fun findSubArray(nums1: IntArray, start1: Int, end1: Int, nums2: IntArray, start2: Int, end2: Int, cursor: Int): Int {
    val size1 = end1 - start1 + 1
    val size2 = end2 - start2 + 1
    //保证size2 > size1, 这样有数组空了一定是nums1
    if (size1 > size2) {
        return findSubArray(nums2, start2, end2, nums1, start1, end1, cursor)
    } else if (size1 == 0) {
        return nums2[start2 + cursor - 1]
    }
    if (cursor == 1) return min(nums1[start1], nums2[start2])

    val next1 = start1 + min(size1, cursor/2) - 1
    val next2 = start2 + min(size2, cursor/2) - 1
    val n1 = nums1[next1]
    val n2 = nums2[next2]

    return if (n1 > n2) {
        findSubArray(nums1, start1, end1, nums2, next2 + 1, end2, cursor - (next2 - start2 + 1))
    } else {
        findSubArray(nums1, next1 + 1, end1, nums2, start2, end2, cursor - (next1 - start1 + 1))
    }
}

fun findMedianSortedArrays1(nums1: IntArray, nums2: IntArray): Double {
    val size1 = nums1.size
    val size2 = nums2.size
    val size = size1 + size2
    val isEven = size % 2 == 0
    if (nums1.isEmpty() || nums2.isEmpty()) {
        return if (nums1.isEmpty()) {
            if (isEven) {
                (nums2[size/2-1] + nums2[size/2]).toDouble()/2
            } else {
                nums2[size/2].toDouble()
            }
        } else {
            if (isEven) {
                (nums1[size/2-1] + nums1[size/2]).toDouble()/2
            } else {
                nums1[size/2].toDouble()
            }
        }
    }

    var index1 = 0
    var index2 = 0
    if (size == 0) {
        return 0.0
    }
    var num = 0
    var oldNum = 0
    val l = size / 2 + 1
    while (index1 + index2 < l) {
        oldNum = num
        num = if (index1 >= size1 || index2 < size2 && nums1[index1] > nums2[index2]) {
            nums2[index2++]
        } else {
            nums1[index1++]
        }
    }

    return if (isEven) {
        (oldNum + num).toDouble()/2
    } else {
        num.toDouble()
    }
}


//时间复杂度O(m+n)
fun fakeResult(nums1: IntArray, nums2: IntArray): Double {
    val array = IntArray(nums1.size + nums2.size)
    var index1 = 0
    var index2 = 0
    //合并数组
    for (i in array.indices) {
        if (index1 >= nums1.size) {
            array[i] = nums2[index2]
            index2++
            continue
        }
        if (index2 >= nums2.size) {
            array[i] = nums1[index1]
            index1++
            continue
        }
        if (nums1[index1] < nums2[index2]) {
            array[i] = nums1[index1]
            index1++
        } else {
            array[i] = nums2[index2]
            index2++
        }

    }
    //计算中位数
    val size = array.size
    return if (size%2 == 0) {
        (array[size/2-1] + array[size/2]).toDouble()/2
    } else {
        array[size/2].toDouble()
    }
}