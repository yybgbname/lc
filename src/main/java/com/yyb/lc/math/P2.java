package com.yyb.lc.math;

import com.yyb.common.structure.ListNode;

public class P2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        add(l1, l2, res);
        return res;
    }

    public ListNode add(ListNode l1, ListNode l2, ListNode res) {
        if (l1 == null && l2 == null) {
            return res;
        }
        int v1 = l1 == null ? 0 : l1.val;
        int v2 = l2 == null ? 0 : l2.val;
        ListNode next1 = l1 == null ? null : l1.next;
        ListNode next2 = l2 == null ? null : l2.next;
        int sum = v1 + v2 + res.val;
        res.val = sum > 9 ? sum - 10 : sum;
        if (next1 != null || next2 != null || sum > 9) {
            if (sum > 9) {
                res.next = new ListNode(1);
            } else {
                res.next = new ListNode(0);
            }
        }
        return add(next1, next2, res.next);
    }

}
