package com.ldf.easy.leetcode;

/**
 * @author lidefu
 * @date 2020年08月03日11:49
 **/
public class StringAddition {

    /**
    给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

    注意：

    num1 和num2 的长度都小于 5100.
    num1 和num2 都只包含数字 0-9.
    num1 和num2 都不包含任何前导零。
    你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
    */

    public static void main(String[] args) {
        StringAddition addition = new StringAddition();
        String num1 = "98", num2 = "9";
        String s = addition.addStrings(num1, num2);
        System.out.println(s);
        System.out.println("--------------------");
        System.out.println(addition.addStrings2(num1, num2));
    }

    /**
     *  '0' = 48 => 1 = '1'-'0'
     * @param num1 -
     * @param num2 -
     * @return -
     */
    public String addStrings(String num1, String num2) {
        if(num1.isEmpty() && num2.isEmpty()){
            return "";
        }
        if(num1.isEmpty()){
            return num2;
        }
        if(num2.isEmpty()){
            return num1;
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int index = 1, temp = 0;
        StringBuilder s = new StringBuilder();
        while (index <= l1 && index <= l2){
            int c1 = num1.charAt(l1 - index)-'0';
            int c2 = num2.charAt(l2-index)-'0';
            s.append((c1 + c2 + temp)%10);
            temp = c1 + c2 + temp >= 10 ? 1 : 0;
            index++;
        }
        if(index<=l1){
            for(; index<=l1; index++){
                int c = num1.charAt(l1 - index)-'0';
                s.append((c + temp)%10);
                temp = c + temp >= 10 ? 1 : 0;
            }
        }
        if(index<=l2) {
            for(; index<=l2; index++){
                int c = num2.charAt(l2 - index)-'0';
                s.append((c + temp)%10);
                temp = c + temp >= 10 ? 1 : 0;
            }
        }
        if(temp>0){
            s.append("1");
        }
        return s.reverse().toString();
    }

    public String addStrings2(String num1, String num2){
        int l1 = num1.length()-1, l2 = num2.length()-1, add=0;
        StringBuilder s = new StringBuilder();
        while (l1>=0 || l2>=0 || add>0){
            int x = l1>=0 ? num1.charAt(l1)-'0' : 0;
            int y = l2>=0 ? num2.charAt(l2)-'0' : 0;
            s.append((x+y+add)%10);
            add = (x+y+add)/10;
            l1--; l2--;
        }
        s.reverse();
        return s.toString();
    }

}
