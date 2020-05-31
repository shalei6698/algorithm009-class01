import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 */
public class RemoveDuplicate {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 双指针
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                if (j > i) {
                    nums[i] = nums[j];
                }
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3};
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

}
