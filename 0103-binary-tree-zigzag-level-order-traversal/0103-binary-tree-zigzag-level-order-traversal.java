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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> lst = new ArrayList<>(size);
            for(int i=0;i<size;i++)
                lst.add(0);
            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                int ind = flag ? i : (size-i-1);
                lst.set(ind,node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            flag = !flag;
            res.add(lst);
        }
        return res;
    }
}