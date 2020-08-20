package com.ldf.easy.leetcode;

import javax.swing.tree.TreeNode;
import javax.xml.soap.Node;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 平衡二叉树
 * @author lidefu
 * @date 2020年08月17日13:44
 **/
public class BalancedBinaryTree {


    /**
     *
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     本题中，一棵高度平衡二叉树定义为：
     一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     */

    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();
//        TreeNode treeNode = tree.testTreeNode(new Integer[]{1,2,3,4,5,null,6,7,null,null,null,null,8});
//        TreeNode treeNode = tree.testTreeNode(new Integer[]{1, null, 3, 2});
//        TreeNode treeNode = tree.testTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        TreeNode treeNode = tree.testTreeNode(new Integer[]{1,2,2,3,3,null,null,4,4});
//        System.out.println(tree.treeHeight(treeNode));
        System.out.println(tree.isBalanced(treeNode));
    }


    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(compare(root)){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private boolean compare(TreeNode root){
        return Math.abs(treeHeight(root.left)-treeHeight(root.right))>1;
    }

    private int treeHeight(TreeNode root){
        if (root == null) {
            return 0;
        }
        int ldep = treeHeight(root.left);
        int rdep = treeHeight(root.right);
        if (ldep > rdep) {
            return ldep + 1;
        } else {
            return rdep + 1;
        }
    }

    private TreeNode testTreeNode(Integer[] nums){
        if(nums.length == 0){
            return null;
        }
        TreeNode header = new TreeNode(nums[0]);
        treeNodeBuilder(header, nums, 0);
        return header;
    }

    private void treeNodeBuilder(TreeNode node, Integer[] nums, int index){
        if(index >= nums.length || nums[index] == null){
            return;
        }
        int nullCount = 0;
        for (int i=0; i<index; i++){
            if(nums[i] == null){
                nullCount++;
            }
        }
        int leftIndex = 2 * (index+1-nullCount)-1;
        int rightIndex = leftIndex+1;
        if(leftIndex < nums.length && nums[leftIndex] != null){
            node.left = new TreeNode(nums[leftIndex]);
            treeNodeBuilder(node.left, nums, leftIndex);
        }
        if(rightIndex < nums.length && nums[rightIndex] != null){
            node.right = new TreeNode(nums[rightIndex]);
            treeNodeBuilder(node.right, nums, rightIndex);
        }
    }



}
