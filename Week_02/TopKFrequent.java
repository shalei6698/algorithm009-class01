import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    static class _Node implements Comparable {
        public Integer num;
        public Integer count;

        public _Node(Integer num, Integer count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Object o) {
            _Node other = (_Node) o;
            return -(count - other.count);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // map 统计数量
        final Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        // heap 获取 topk
        PriorityQueue<_Node> heap = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            _Node node = new _Node(entry.getKey(), entry.getValue());
            heap.add(node);
        }

        int[] ret = new int[k];

        for (int i = 0; i < k; i++) {
            ret[i] = heap.poll().num;
        }
        return ret;
    }
}
