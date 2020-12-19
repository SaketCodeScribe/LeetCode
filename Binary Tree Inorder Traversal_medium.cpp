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
#define ll long long int
#define pb push_back
#define pu push
#define po pop
#define v vector<int>
#define s stack<TreeNode*>
#define tn TreeNode

class Solution{
public:
    v res={};
    
    void rec_dfs(tn* root){
        if(root){
            rec_dfs(root->left);
            res.pb(root->val);
            rec_dfs(root->right);
        }
        return;
    }
    
    void iter_dfs(tn* root){
        s st={};
        tn* curr=root;
        while(!st.empty() || curr){
            while(curr){
                st.pu(curr);
                curr=curr->left;
            }
            tn* top=st.top();
            st.po();
            res.pb(top->val);
            if(top->right)
                curr=top->right;
        }
        return;
    }
    
    vector<int> inorderTraversal(TreeNode* root) {
        res={};
        /*
            1. Recusrive approach
                rec_dfs(root);
        */
        
        /*
            2. Iterative Approach
        */
        iter_dfs(root);
        return res;
    }
};