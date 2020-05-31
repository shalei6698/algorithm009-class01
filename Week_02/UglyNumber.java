import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 面试题49. 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class UglyNumber {
    public int nthUglyNumber(int n) {
        Queue<Long> heap = new PriorityQueue<>();
        Set<Long> numSet = new HashSet<>();
        numSet.add((long) 1);
        heap.offer((long) 1);

        long[] keyNums = new long[]{2, 3, 5};
        long num = (long) 1;

        for (int i = 0; i < n; i++) {
            num = heap.poll();
            for (int j = 0; j < keyNums.length; j++) {
                Long val = num * keyNums[j];
                if (!numSet.contains(val)) {
                    heap.offer(val);
                    numSet.add(val);
                }
            }
        }
        return (int) num;
    }

}
