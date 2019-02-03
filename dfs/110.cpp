#include <iostream>
#include <vector>
using namespace std;

int main() {
    cout << "Hello, World!" <<endl;
    return 0;
}


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
/**
 判断一棵二叉树是否为平衡二叉树
 设当前结点为root，设两个变量l和r分别表示
 以root为根节点的子树的左边的高度和右边的高度。
 如果root结点没有左孩子，那么l = 0；否则l = dfs(root->left)；
 如果root结点没有右孩子，那么r = 0；否则r = dfs(root->right)；
 以root为根节点的子树的高度为它的左边的高度l和右边的高度r两个中较大的那一个+1；
 当root根节点为空的时候，说明它的父结点的高度为1。
 如果l和r的绝对值大于等于2则返回false(在这里将标志flag置为0)。
 */
class Solution {
public:
    int flag=1;
    int dfs(TreeNode* root){
        if(root==NULL)return 1;
        int l,r;
        if (root->left==NULL)l=0;
        else{
            l=dfs(root->left);
        }
        if (root->right==NULL)r=0;
        else{
            r=dfs(root->right);
        }
        if (abs(l-r)>=2){
            flag=0;
        }
        return (l>r?l:r)+1;
    }
    bool isBalanced(TreeNode* root) {
        dfs(root);
        return flag;
    }
};
