/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * https://leetcode-cn.com/problems/rotate-array/
 *
 */
class RotateArray {
    public static void rotate(int[] nums, int k) {
        // 异常判断和参数处理都是一样的
        if (nums.length < 2) {
            return;
        }
        int kk = k % nums.length;

//        rotate_1(nums, kk);
//        rotate_2(nums, kk);
        rotate_3(nums, kk);
    }

    public static void rotate_1(int[] nums, int k) {
        // 暂存
        int[] kNums = new int[k];
        int j = 0;
        System.out.println();
        for (int i = nums.length - k; i < nums.length; i++, j++) {
            kNums[j] = nums[i];
        }
        // 反向遍历，避免覆盖
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        // 复制 0 ~ k
        System.arraycopy(kNums, 0, nums, 0, k);
    }

    public static void rotate_2(int[] nums, int k) {
        int[] copyNums = new int[nums.length];
        // 复制
        System.arraycopy(nums, 0, copyNums, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = copyNums[(i + nums.length - k) % nums.length];
        }
    }

    public static void rotate_3(int[] nums, int k) {
        // 两次反转，空间复杂度 O(1)
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse(nums, k, nums.length);
    }

    public static void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            int temp = nums[i];
            nums[start] = nums[j];
            nums[j] = temp;
            i ++;
            j --;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(nums);
    }
}