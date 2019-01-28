#include <iostream>
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
    bool dfs(TreeNode* l,TreeNode* r){
        if(l==NULL&&r==NULL)return true;
        if (l!=NULL&&r!=NULL){
            return dfs(l->left,r->right)&&dfs(r->left,r->right);
        }
        return false;
    }
    bool isSymmetric(TreeNode* root) {
        if(root==NULL)return true;
        else return dfs(root->left,root->right);
    }
};