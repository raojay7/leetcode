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

class Solution {
public:
    vector<string> v;

    void dfs(TreeNode* node,string s){
        if(node->left == NULL && node->right == NULL) {
            v.push_back(s);
            return ;
        }
        if(node->left != NULL) {
            dfs(node->left, s + "->" + to_string(node->left->val));
        }
        if(node->right != NULL) {
            dfs(node->right, s + "->" + to_string(node->right->val));
        }
    }
    vector<string> binaryTreePaths(TreeNode* root) {
        if(root==NULL){
            return v;
        }
        else{
            dfs(root,to_string(root->val));
            return v;
        }
    }
};