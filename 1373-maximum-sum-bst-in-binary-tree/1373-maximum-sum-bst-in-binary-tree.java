/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class NodeVal{
    public int max,min,sum;
    NodeVal(int max,int min,int sum){
        this.max = max;
        this.min = min;
        this.sum = sum;
    }
}
class Solution {
    private int maxSum;
    public NodeVal bstHelper(TreeNode root){
        if(root==null)
            return new NodeVal(Integer.MIN_VALUE,Integer.MAX_VALUE,0);

        NodeVal left = bstHelper(root.left);
        NodeVal right = bstHelper(root.right);

        if(left.max < root.val && root.val < right.min){
            int curSum = left.sum+right.sum+root.val;
            maxSum = Math.max(curSum, maxSum);
            return new NodeVal(Math.max(root.val,right.max) , Math.min(root.val,left.min) , curSum);
        }
            

        return new NodeVal(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left.sum,right.sum));
    }
    public int maxSumBST(TreeNode root) {
        maxSum=0;
        bstHelper(root);
        return maxSum;
    }
}