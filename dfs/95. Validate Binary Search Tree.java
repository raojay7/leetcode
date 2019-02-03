public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    boolean dfs(TreeNode root,Long min,Long max){
        //分治
        if(root==null){
            return true;
        }
        if (root.val <= min || root.val >= max){
            return false;
        }
        return dfs(root.left,min,Math.min(max,root.val))&&dfs(root.right,Math.max(min,root.val),max);
    }
}
