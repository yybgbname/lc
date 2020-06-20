package com.yyb.lc.greedy;

public class P55 {
    public static void main(String[] args) {
        P55 p = new P55();
        p.canJump(new int[]{3, 2, 1, 0, 4});
    }

    private boolean canJump(int[] nums) {
        int jumpMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (jumpMost >= i) {
                jumpMost = Math.max(jumpMost, nums[i] + i);
                if (jumpMost >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

