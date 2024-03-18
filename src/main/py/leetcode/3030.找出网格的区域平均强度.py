#
# @lc app=leetcode.cn id=3030 lang=python3
#
# [3030] 找出网格的区域平均强度
#
# https://leetcode.cn/problems/find-the-grid-of-region-average/description/
#
# algorithms
# Medium (49.58%)
# Likes:    6
# Dislikes: 0
# Total Accepted:    2.3K
# Total Submissions: 4.6K
# Testcase Example:  '[[5,6,7,10],[8,9,10,10],[11,12,13,10]]\n3'
#
# 给你一个下标从 0 开始、大小为 m x n 的网格 image ，表示一个灰度图像，其中 image[i][j] 表示在范围 [0..255]
# 内的某个像素强度。另给你一个 非负 整数 threshold 。
#
# 如果 image[a][b] 和 image[c][d] 满足 |a - c| + |b - d| == 1 ，则称这两个像素是 相邻像素 。
#
# 区域 是一个 3 x 3 的子网格，且满足区域中任意两个 相邻 像素之间，像素强度的 绝对差  小于或等于 threshold 。
#
# 区域 内的所有像素都认为属于该区域，而一个像素 可以 属于 多个 区域。
#
# 你需要计算一个下标从 0 开始、大小为 m x n 的网格 result ，其中 result[i][j] 是 image[i][j] 所属区域的 平均
# 强度，向下取整 到最接近的整数。如果 image[i][j] 属于多个区域，result[i][j] 是这些区域的 “取整后的平均强度” 的 平均值，也
# 向下取整 到最接近的整数。如果 image[i][j] 不属于任何区域，则 result[i][j] 等于 image[i][j] 。
#
# 返回网格 result 。
#
#
#
# 示例 1：
#
#
# 输入：image = [[5,6,7,10],[8,9,10,10],[11,12,13,10]], threshold = 3
# 输出：[[9,9,9,9],[9,9,9,9],[9,9,9,9]]
# 解释：图像中存在两个区域，如图片中的阴影区域所示。第一个区域的平均强度为 9 ，而第二个区域的平均强度为 9.67 ，向下取整为 9
# 。两个区域的平均强度为 (9 + 9) / 2 = 9 。由于所有像素都属于区域 1 、区域 2 或两者，因此 result 中每个像素的强度都为 9 。
# 注意，在计算多个区域的平均值时使用了向下取整的值，因此使用区域 2 的平均强度 9 来进行计算，而不是 9.67 。
#
#
# 示例 2：
#
#
# 输入：image = [[10,20,30],[15,25,35],[20,30,40],[25,35,45]], threshold = 12
# 输出：[[25,25,25],[27,27,27],[27,27,27],[30,30,30]]
# 解释：图像中存在两个区域，如图片中的阴影区域所示。第一个区域的平均强度为 25 ，而第二个区域的平均强度为 30 。两个区域的平均强度为 (25 +
# 30) / 2 = 27.5 ，向下取整为 27 。图像中第 0 行的所有像素属于区域 1 ，因此 result 中第 0 行的所有像素为 25
# 。同理，result 中第 3 行的所有像素为 30 。图像中第 1 行和第 2 行的像素属于区域 1 和区域 2 ，因此它们在 result 中的值为
# 27 。
#
#
# 示例 3：
#
#
# 输入：image = [[5,6,7],[8,9,10],[11,12,13]], threshold = 1
# 输出：[[5,6,7],[8,9,10],[11,12,13]]
# 解释：图像中不存在任何区域，因此对于所有像素，result[i][j] == image[i][j] 。
#
#
#
#
# 提示：
#
#
# 3 <= n, m <= 500
# 0 <= image[i][j] <= 255
# 0 <= threshold <= 255
#
#
#
from typing import List
# @lc code=start
class Solution:
    def resultGrid(self, image: List[List[int]], threshold: int) -> List[List[int]]:
        m, n = len(image), len(image[0])
        res = [[0 for _ in range(n)] for _ in range(m)]
        avg_arr = [[0 for _ in range(n)] for _ in range(m)]
        cp_row = [[False for _ in range(n)] for _ in range(m)]
        cp_col = [[False for _ in range(n)] for _ in range(m)]
        avg_cnts = [[0 for _ in range(n)] for _ in range(m)]
        sum_r = [[0 for _ in range(n)] for _ in range(m)]
        l_m, l_n = m - 1, n - 1
        for j in range(l_n):
            cp_row[l_m][j] = abs(image[l_m][j] - image[l_m][j + 1]) <= threshold
        for i in range(l_m):
            cp_col[i][l_n] = abs(image[i][l_n] - image[i + 1][l_n]) <= threshold
        for i in range(l_m):
            for j in range(l_n):
                cp_row[i][j] = abs(image[i][j] - image[i][j + 1]) <= threshold
                cp_col[i][j] = abs(image[i][j] - image[i + 1][j]) <= threshold

        for i in range(m):
            for j in range(n - 2):
                sum_r[i][j] = image[i][j] + image[i][j + 1] + image[i][j + 2]
        def is_valid(i: int, j: int, cp_row: List[List[bool]], cp_col: List[List[bool]]) -> bool:
            for ii in range(3):
                for jj in range(2):
                    if not cp_row[i + ii][j + jj]:
                        return False
            for ii in range(2):
                for jj in range(3):
                    if not cp_col[i + ii][j + jj]:
                        return False
            return True
        for i in range(m - 2):
            for j in range(n - 2):
                if is_valid(i, j, cp_row, cp_col):
                    sb_sum = sum_r[i][j] + sum_r[i + 1][j] + sum_r[i + 2][j]
                    v = sb_sum//9
                    for ii in range(3):
                        for jj in range(3):
                            avg_arr[i + ii][j + jj] += v
                            avg_cnts[i + ii][j + jj] += 1

        for i in range(m):
            for j in range(n):
                if avg_cnts[i][j] == 0:
                    res[i][j] = image[i][j]
                    continue
                if avg_cnts[i][j] == 1:
                    res[i][j] = avg_arr[i][j]
                    continue
                res[i][j] = avg_arr[i][j] // avg_cnts[i][j]
        return res
# image = [[5,6,7,10],[8,9,10,10],[11,12,13,10]]
# threshold = 3
# s = Solution()
# print(s.resultGrid(image, threshold))
# @lc code=end

