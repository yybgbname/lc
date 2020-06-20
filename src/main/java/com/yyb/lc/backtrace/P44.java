package com.yyb.lc.backtrace;

/**
 * two zhizheng
 */
public class P44 {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int pIdx = 0;
        int sIdx = 0;
        int startIdx = -1;
        int sTmpIdx = -1;
        while (sIdx < sLen) {
            if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                ++sIdx;
                ++pIdx;
                // If pattern character = '*'
            } else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                // Check the situation
                // when '*' matches no characters
                startIdx = pIdx;
                sTmpIdx = sIdx;
                ++pIdx;
                // If pattern character != string character
                // or pattern is used up
                // and there was no '*' character in pattern
            } else if (startIdx == -1) {
                return false;
                // If pattern character != string character
                // or pattern is used up
                // and there was '*' character in pattern before
            } else {
                // Backtrack: check the situation
                // when '*' matches one more character
                pIdx = startIdx + 1;
                sIdx = sTmpIdx + 1;
                sTmpIdx = sIdx;
            }
        }
        for (int i = pIdx; i < pLen; i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P44 p = new P44();
        System.out.println(p.isMatch("aafjun", "aa*uun"));
    }
}
