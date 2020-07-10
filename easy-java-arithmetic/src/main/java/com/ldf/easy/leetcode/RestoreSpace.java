package com.ldf.easy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 恢复空格
 * @author lidefu
 * @date 2020年07月09日17:13
 **/
public class RestoreSpace {

    /**
     * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
     注意：本题相对原题稍作改动，只需返回未识别的字符数

     示例：
     输入：
     dictionary = ["looked","just","like","her","brother"]
     sentence = "jesslookedjustliketimherbrother"
     输出： 7
     解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
     提示：
     0 <= len(sentence) <= 1000
     dictionary中总字符数不超过 150000。
     你可以认为dictionary和sentence中只包含小写字母。

     */

    public static void main(String[] args) {
        RestoreSpace restoreSpace = new RestoreSpace();
        String[] dictionary = {"wccm","wiw","uwwiwcmiiiwmmwicuwu","mw"};
        String sentence = "iwiwwwmuiccwwwwwmumwwwmcciwwuiwcicwwuwicuiwciwmiwicwuwwmuimccwucuuim";
        int respace = restoreSpace.respace(dictionary, sentence);
        System.out.println(respace);
    }

    /**
     * 没做出来！！！
     * @param dictionary -
     * @param sentence -
     * @return -
     */
    public int respace(String[] dictionary, String sentence) {
        StringBuilder r = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        char[] chars = sentence.toCharArray();
        for(int i =0; i<chars.length; i++){
            temp.append(chars[i]);
            int match = match(dictionary, temp.toString());
            if(match == 2){
                //继续

            }else if(match == 1){
                //匹配上
                temp = new StringBuilder();
            }else {
                r.append(temp.substring(0, temp.length()-1));
                temp = new StringBuilder();
                if(i>0) i--;
            }

        }
        return r.length();
    }

    private int match(String[] dictionary, String c){
        List<String> list = Arrays.stream(dictionary).filter(d -> d.startsWith(c)).collect(Collectors.toList());
        if(list.size() == 0){
            return 0;
        }else {
            for(String item : list){
                if(item.equals(c)){
                    return 1;
                }
            }
        }
        return 2;
    }

}
