package org.eu.cn.apache.leetcode.basic_algorithm;

/**
 * 给你一个浮点数 hour ，表示你到达办公室可用的总通勤时间。要到达办公室，你必须按给定次序乘坐 n 趟列车。另给你一个长度为 n 的整数数组 dist ，其中 dist[i] 表示第 i 趟列车的行驶距离（单位是千米）。
 * <p>
 * 每趟列车均只能在整点发车，所以你可能需要在两趟列车之间等待一段时间。
 * <p>
 * 例如，第 1 趟列车需要 1.5 小时，那你必须再等待 0.5 小时，搭乘在第 2 小时发车的第 2 趟列车。
 * 返回能满足你准时到达办公室所要求全部列车的 最小正整数 时速（单位：千米每小时），如果无法准时到达，则返回 -1 。
 * <p>
 * 生成的测试用例保证答案不超过 107 ，且 hour 的 小数点后最多存在两位数字 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：dist = [1,3,2], hour = 6
 * 输出：1
 * 解释：速度为 1 时：
 * - 第 1 趟列车运行需要 1/1 = 1 小时。
 * - 由于是在整数时间到达，可以立即换乘在第 1 小时发车的列车。第 2 趟列车运行需要 3/1 = 3 小时。
 * - 由于是在整数时间到达，可以立即换乘在第 4 小时发车的列车。第 3 趟列车运行需要 2/1 = 2 小时。
 * - 你将会恰好在第 6 小时到达。
 * 示例 2：
 * <p>
 * 输入：dist = [1,3,2], hour = 2.7
 * 输出：3
 * 解释：速度为 3 时：
 * - 第 1 趟列车运行需要 1/3 = 0.33333 小时。
 * - 由于不是在整数时间到达，故需要等待至第 1 小时才能搭乘列车。第 2 趟列车运行需要 3/3 = 1 小时。
 * - 由于是在整数时间到达，可以立即换乘在第 2 小时发车的列车。第 3 趟列车运行需要 2/3 = 0.66667 小时。
 * - 你将会在第 2.66667 小时到达。
 * 示例 3：
 * <p>
 * 输入：dist = [1,3,2], hour = 1.9
 * 输出：-1
 * 解释：不可能准时到达，因为第 3 趟列车最早是在第 2 小时发车。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == dist.length
 * 1 <= n <= 105
 * 1 <= dist[i] <= 105
 * 1 <= hour <= 109
 * hours 中，小数点后最多存在两位数字
 *
 * @author adonis lau
 * @email adonis.lau.dev@gmail.com
 * @date 2023/8/13 00:48
 */
class Minimum_Speed_to_Arrive_on_Time {

    public static void main(String[] args) {
        int[] dist = new int[]{1, 8, 10000001};
        double hour = 3;
        System.out.println(minSpeedOnTime(dist, hour));
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        // 设置左右初始化值
        int left = 1, right = 10000000;

        // 二分循环体
        while (left < right) {
            // 游标值初始化为平均值（二分）
            int middle = (left + right) >>> 1;

            // 根据需求写判断条件，取左侧值或右侧值
            if (check(dist, hour, middle)) {
                // 中位数速度满足要求，取左侧更慢速度
                right = middle;
            } else {
                // 中位数速度不满足要求，取右侧更快速度
                left = middle + 1;
            }
        }
        return check(dist, hour, left) ? left : -1;
    }

    /**
     * 判断当前速度是否可以满足时间要求
     * 将每段路程都除以当前速度，sum出总时间
     * 时间小于要求时间即可，向上取整
     *
     * @param dist
     * @param hour
     * @param speed
     * @return
     */
    private static boolean check(int[] dist, double hour, double speed) {
        // 初始化总消耗时间为0
        double sum = 0;
        // 循环计算每段路程所用时间
        for (int i = 0; i < dist.length; i++) {
            double cost = dist[i] / speed;
            // 计算路程所用时间之和
            sum += (i == dist.length - 1 ? cost : Math.ceil(cost));
        }
        return sum <= hour;
    }
}
