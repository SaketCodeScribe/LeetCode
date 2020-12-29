/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
#define tn TreeNode
#define ll long long int
class Solution {
public:
    tn* prev=NULL;
    
    bool ValidBST_usinginorder(tn* root){
        if(root){
            if(!ValidBST_usinginorder(root->left))
                return false;
            if(prev && prev->val>=root->val)
                return false;
            prev=root;
            return ValidBST_usinginorder(root->right);
        }
        return true;
    }
    
    bool ValidBST(tn* root, ll mi, ll mx){
        return !root || (root->val>mi && root->val<mx && ValidBST(root->left, mi, root->val) && ValidBST(root->right, root->val, mx));
    }
    
    bool isValidBST(TreeNode* root) {
        prev=NULL;
        // return ValidBST_usinginorder(root);
        return ValidBST(root, LLONG_MIN, LLONG_MAX);
    }
};