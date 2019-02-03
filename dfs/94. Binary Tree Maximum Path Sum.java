
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        dfs(root);
        return res;
    }
    int dfs(TreeNode node){
        if (node==null)return 0;
        int left=dfs(node.left);
        int right=dfs(node.right);
        int cur=node.val+Math.max(0,left)+Math.max(0,right);
        res=Math.max(cur,res);
        return node.val+Math.max(left,Math.max(right,0));
    }
}
