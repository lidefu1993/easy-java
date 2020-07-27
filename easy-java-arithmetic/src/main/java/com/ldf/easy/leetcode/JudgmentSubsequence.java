package com.ldf.easy.leetcode;

/**
 * 判断子序列
 * @author lidefu
 * @date 2020年07月27日14:37
 **/
public class JudgmentSubsequence {

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
     字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     示例 1:
     s = "abc", t = "ahbgdc"
     返回 true.
     示例 2:
     s = "axc", t = "ahbgdc"
     返回 false.
     */

    public static void main(String[] args) {
        JudgmentSubsequence js = new JudgmentSubsequence();
        boolean b = js.isSubsequence("abc", "caabac");
        System.out.println(b);
    }

    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0 && t.length() == 0){
            return true;
        }
        if(t.length() == 0){
            return false;
        }
        int index = 0;
        for(int i=0; i<s.length(); i++){
            if(index >= t.length()){
                return false;
            }
            while (index<t.length()){
                if(t.charAt(index++) == s.charAt(i)){
                    break;
                }else {
                    if(index >= t.length()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isSubsequence2(String s, String t){
        int m=0, n=0;
        while (m < s.length() && n < t.length()){
            if(s.charAt(m) == t.charAt(n)){
                m++;
            }
            n++;
        }
        return m==s.length();
    }

}
