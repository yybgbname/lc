package com.yyb.lc.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class P20 {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (deque.isEmpty()) {
                deque.push(ch);
            } else {
                char first = deque.getFirst();
                if (isValid(first, ch)) {
                    deque.pop();
                } else {
                    deque.push(ch);
                }
            }
        }
        return deque.isEmpty();
    }

    private boolean isValid(char before, char later) {
        return (before == '(' && later == ')')
                || (before == '{' && later == '}')
                || (before == '[' && later == ']');
    }

    public static void main(String[] args) {
        P20 p = new P20();
        System.out.println(p.isValid("([[])]"));
    }
}
