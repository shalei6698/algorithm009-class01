import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
    static class State {
        static int[][] directions = new int[][]{
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{-1, 0},
        };

        int direction = 0;
        int posX = 0;
        int posY = 0;

        void turnLeft() {
            this.direction = this.direction == 0 ? 3 : this.direction - 1;
        }
        void turnRight() {
            this.direction = this.direction == 3 ? 0 : this.direction + 1;
        }

        void move(int step, Map<Integer, List<Integer>> obsXMap, Map<Integer, List<Integer>> obsYMap) {
            Integer limitStep;
            switch (this.direction) {
                case 0:
                    limitStep = getLimitStep(this.posY, obsXMap.get(this.posX), true);
                    break;
                case 1:
                    limitStep = getLimitStep(this.posX, obsYMap.get(this.posY), true);
                    break;
                case 2:
                    limitStep = getLimitStep(this.posY, obsXMap.get(this.posX), false);
                    break;
                default:
                    limitStep = getLimitStep(this.posX, obsYMap.get(this.posY), false);
            }
            realMove((limitStep != null && limitStep < step) ? limitStep : step);
        }

        private void realMove(int i) {
            // System.out.println(i);
            this.posX += directions[this.direction][0] * i;
            this.posY += directions[this.direction][1] * i;
        }

		Integer getLimitStep(int val, List<Integer> list, boolean b) {
            // 二分查找
            if (list == null || list.size() == 0) {
                return null;
            }
            if (list.get(0) > val) {
                return b ? list.get(0) - val - 1 : null;
            }
            if (list.get(list.size() - 1) < val) {
                return b ? null : val - list.get(list.size() - 1) - 1;
            }

            int left = 0;
            int right = list.size() - 1;
            while (left <= right - 2) {
                int mid = (left + right) / 2;
                if (list.get(mid) > val) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return b ? list.get(right) - val -1 : val - list.get(left) - 1;
	    }
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        State state = new State();
        Map<Integer, List<Integer>> obsXMap = new HashMap<>();
        Map<Integer, List<Integer>> obsYMap = new HashMap<>();
        for (int[] obs: obstacles) {
            if (obs[0] == 0 && obs[1] == 0) {
                continue;
            }
            if (obsXMap.containsKey(obs[0])) {
                obsXMap.get(obs[0]).add(obs[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(obs[1]);
                obsXMap.put(obs[0], list);
            }
            if (obsYMap.containsKey(obs[1])) {
                obsYMap.get(obs[1]).add(obs[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(obs[0]);
                obsYMap.put(obs[1], list);
            }
        }
        // sort
        sortMap(obsXMap);
        sortMap(obsYMap);

        for (int command: commands) {
            switch (command) {
                case -2:
                    state.turnLeft();
                    break;
                case -1:
                    state.turnRight();
                    break;
                default:
                    state.move(command, obsXMap, obsYMap);
            }
        }
        System.out.println(state.posX);
        System.out.println(state.posY);
        System.out.println(state.direction);

        return state.posY * state.posY + state.posX *state.posX;
    }

	private void sortMap(Map<Integer, List<Integer>> map) {
        for (List<Integer> val: map.values()) {
            val.sort(Integer::compare);
        }
	}
}
// @lc code=end

