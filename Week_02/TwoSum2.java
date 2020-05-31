import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valIdxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            valIdxMap.put(num, i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer j = valIdxMap.get(target - num);
            if (j != null && j != i) {
                return new int[]{i, j};
            }
        }
        return new int[]{};
    }
}
