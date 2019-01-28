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
分类讨论，设当前结点为root，如果root->left 和 root->right都为NULL，则返回1；
如果root->left不为NULL但是root->right为NULL，返回root->left为根节点的子树的最大层数+1；
如果root->right不为NULL但是root->left为NULL，返回root->right为根节点的子树的最大层数+1；
如果root->right和root->right都不为NULL，则返回以root->left为根节点的子树的层数和以root->right为根节点的子树的层数中的较大的那个值+1。
 */
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if(root==NULL)return 0;
        else if(root->left==NULL&&root->right==NULL)return 1;
        else if(root->left!=NULL&&root->right==NULL)return maxDepth(root->left)+1;
        else if(root->left==NULL&&root->right!=NULL)return maxDepth(root->right)+1;
        int lD=maxDepth(root->left);
        int rD=maxDepth(root->right);
        return lD>rD?lD+1:rD+1;
    }
};