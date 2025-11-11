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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        rightside(lst,root,0);
        return lst;
    }
    public void rightside(List<Integer> ls, TreeNode root,int level){
        if(root==null){
            return;
        }
        
        if(level==ls.size())
            ls.add(root.val);
        rightside(ls,root.right,level+1);
        rightside(ls,root.left,level+1);
    }
}