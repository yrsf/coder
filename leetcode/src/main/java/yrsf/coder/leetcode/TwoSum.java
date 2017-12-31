package yrsf.coder.leetcode;

/**
 * Created by yrsf on 5/7/17.
 * <p>
 * 1.Two Sum
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly yrsf.leetcode.problems.one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {

            int second = search(nums, i + 1, target - nums[i]);

            if (second == 0) {
                continue;
            }

            result[0] = i;
            result[1] = second;

            break;

        }
        return result;
    }

    private int search(int[] nums, int from, int target) {
        for (int i = from; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return 0;
    }

}