#include <iostream>
using namespace std;

int main() {
    cout << "Hello, World!" <<endl;
    return 0;
}
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
/*
 这道题既可以用深度优先搜索DFS，也可以用广度优先搜索BFS。
 深度优先搜索的思路为：
 传入root的左子树和右子树。如果两个都为NULL，则是对称的。如果两边都不为NULL并且两边的所对应的val相等，那就判断root->left->left和root->left->right是否对称，且判断root->left->right和root->right->left是否对称。。。
 其余情况下return false;
 */
class Solution {
public:
    bool func(TreeNode *left, TreeNode *right) {
        if(left == NULL && right == NULL)
            return true;
        if(left != NULL && right != NULL && left->val == right->val) {
            return func(left->left, right->right) && func(left->right, right->left);
        }
        return false;
    }
    bool isSymmetric(TreeNode* root) {
        if(root == NULL)
            return true;
        return func(root->left, root->right);
    }
};
