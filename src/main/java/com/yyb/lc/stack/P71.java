package com.yyb.lc.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class P71 {
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return "/";
        }
        Deque<String> deque = new ArrayDeque<>();
        for (String str : path.split("/")) {
            if (str.isEmpty() || ".".equals(str)) {
                continue;
            }
            if ("..".equals(str) && !deque.isEmpty()) {
                deque.pop();
                continue;
            }
            deque.push(str);
        }
        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        Deque<String> retTemp = new ArrayDeque<>();
        while (!deque.isEmpty()) {
            retTemp.push(deque.pop());
        }
        while (!retTemp.isEmpty()) {
           builder.append("/").append(retTemp.pop());
        }
        return builder.toString().substring(0, builder.length());
    }

    public static void main(String[] args) {
        P71 p = new P71();
        System.out.println(p.simplifyPath("/a//b////c/d//././/.."));
    }
}
