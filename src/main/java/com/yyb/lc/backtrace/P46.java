package com.yyb.lc.backtrace;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class P46 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        int depth = 0;
        backtrace(nums, path, depth, visited, res);
        return res;
    }

    private void backtrace(int[] nums, Deque<Integer> path, int depth, boolean[] visited, List<List<Integer>> res) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i]) {
                continue;
            }
            path.addLast(i);
            visited[i] = true;
            backtrace(nums, path, depth + 1, visited, res);
            path.removeLast();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        P46 p = new P46();
        p.permute(new int[]{1, 2, 3});
    }
}
