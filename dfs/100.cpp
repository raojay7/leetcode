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
 递归函数每次传入两棵树中的各一个结点。
 先传入两个树的root结点。若root结点均不为空，
 则判断这两个结点的值是否相等，
 和这两个结点的左孩子、右孩子是否相等
 如果都满足则return true，否则return false
 若传入的结点不是都不空的，判断是否同时都空
 如果一个空一个不空那么是false
 所以最后要加上一句return p == NULL && q == NULL
 */
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
       //进一步判断
       if(p!=NULL&&q!=NULL){
           return p->val==q->val&&isSameTree(p->left,q->left)&&isSameTree(p->right,q->right);
       }
       //不相同直接返回false
       return p==NULL&&q==NULL;
    }
};