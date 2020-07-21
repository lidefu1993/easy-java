package com.ldf.easy.leetcode;

import java.util.*;
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
//        String[] dictionary = {"wccm","wiw","uwwiwcmiiiwmmwicuwu","mw"};
//        String sentence = "iwiwwwmuiccwwwwwmumwwwmcciwwuiwcicwwuwicuiwciwmiwicwuwwmuimccwucuuim";
//        int respace = restoreSpace.respace3(dictionary, sentence);
//        System.out.println(respace);
        String[] dictionary = {"looked","just","like","her","brother"};
        String sentence = "jesslookedjustliketimherbrother";
        int respace = restoreSpace.respace3(dictionary, sentence);
        System.out.println(respace);
    }

    /**
     * 字典树
     * @param dictionary -
     * @param sentence -
     * @return -
     */
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();

        Trie root = new Trie();
        for (String word: dictionary) {
            root.insert(word);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.next[t];
            }
        }
        return dp[n];
    }

    class Trie {
        public Trie[] next;
        public boolean isEnd;

        public Trie() {
            next = new Trie[26];
            isEnd = false;
        }

        public void insert(String s) {
            Trie curPos = this;

            for (int i = s.length() - 1; i >= 0; --i) {
                int t = s.charAt(i) - 'a';
                if (curPos.next[t] == null) {
                    curPos.next[t] = new Trie();
                }
                curPos = curPos.next[t];
            }
            curPos.isEnd = true;
        }
    }


    static final long P = Integer.MAX_VALUE;
    static final long BASE = 41;

    public int respace2(String[] dictionary, String sentence) {
        Set<Long> hashValues = new HashSet<Long>();
        for (String word : dictionary) {
            hashValues.add(getHash(word));
        }

        int[] f = new int[sentence.length() + 1];
        Arrays.fill(f, sentence.length());

        f[0] = 0;
        for (int i = 1; i <= sentence.length(); ++i) {
            f[i] = f[i - 1] + 1;
            long hashValue = 0;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a' + 1;
                hashValue = (hashValue * BASE + t) % P;
                if (hashValues.contains(hashValue)) {
                    f[i] = Math.min(f[i], f[j - 1]);
                }
            }
        }

        return f[sentence.length()];
    }

    public long getHash(String s) {
        long hashValue = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            hashValue = (hashValue * BASE + s.charAt(i) - 'a' + 1) % P;
        }
        return hashValue;
    }


    public int respace3(String[] dictionary, String sentence) {
        if(sentence==null||sentence.length()==0)
            return 0;
        int n=sentence.length();
        if(dictionary==null||dictionary.length==0)
            return n;
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i]=dp[i-1]+1;
            for(String word:dictionary){
                int wlen=word.length();
                if(i-wlen>=0&&sentence.substring(i-wlen,i).equals(word)){
                    dp[i]=Math.min(dp[i-wlen],dp[i]);
                }
            }
        }
        return dp[n];
    }

    public int respace4(String[] dictionary, String sentence) {
        int m = sentence.length();
        int[] dp = new int[m+1];
        for(int i=1;i<=m;i++){                 //外层循环字符串
            for(String word:dictionary){             //内层循环字典
                int len = word.length();
                if(i >= len && word.equals(sentence.substring(i-len,i))){
                    dp[i] = Math.max(dp[i],dp[i-len]+len);  //状态转移
                }else{
                    dp[i] = Math.max(dp[i],dp[i-1]);
                }
            }
        }
        return m-dp[m];
    }


}
