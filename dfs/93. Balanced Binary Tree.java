
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}


public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        //遍历树，通过记录每个结点的子树高度来判断
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root==null)return 0;
        int l=maxDepth(root.left);
        int r=maxDepth(root.right);
        //存在不平衡返回-1
        if (l==-1||r==-1||Math.abs(l-r)>1){
            return -1;
        }
        return Math.max(l,r)+1;
    }
}
