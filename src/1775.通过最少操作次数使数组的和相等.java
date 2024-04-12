/*
 * @lc app=leetcode.cn id=1775 lang=java
 *
 * [1775] 通过最少操作次数使数组的和相等
 *
 * https://leetcode.cn/problems/equal-sum-arrays-with-minimum-number-of-operations/description/
 *
 * algorithms
 * Medium (56.48%)
 * Likes:    193
 * Dislikes: 0
 * Total Accepted:    25.6K
 * Total Submissions: 45.3K
 * Testcase Example:  '[1,2,3,4,5,6]\n[1,1,2,2,2,2]'
 *
 * 给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
 * 
 * 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
 * 
 * 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * 输出：-1
 * 解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
 * 
 * 
 * 示例 3：
 * 
 * 输入：nums1 = [6,6], nums2 = [1]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
 * - 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
 * - 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums1.length, nums2.length <= 10^5
 * 1 <= nums1[i], nums2[i] <= 6
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        // 1. 计算两个数组的和
        int sum1 = 0, sum2 = 0;
        for (int num : nums1) {
            sum1 += num;
        }
        for (int num : nums2) {
            sum2 += num;
        }
        // 2. 如果两个数组的和相等，返回0
        if (sum1 == sum2) {
            return 0;
        }
        // 3. 如果两个数组的和相差太大，返回-1
        if (sum1 > sum2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tempSum = sum1;
            sum1 = sum2;
            sum2 = tempSum;
        }
        int diff = sum2 - sum1;
        // 4. 计算两个数组的和的差值
        int[] count = new int[6];
        for (int num : nums1) {
            count[6 - num]++;
        }
        for (int num : nums2) {
            count[num - 1]++;
        }
        // 5. 计算最少操作次数
        int result = 0;
        for (int i = 5; i > 0; i--) {
            // need表示需要多少个i来填补差值
            int need = diff / i;
            if (diff % i != 0) {
                need++;
            }
            if (count[i] >= need) {
                diff -= need * i;
                result += need;
            } else {
                diff -= count[i] * i;
                result += count[i];
            }
            if (diff <= 0) {
                return result;
            }
        }
        return -1;
    }
}
// @lc code=end

