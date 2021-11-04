class Solution {
public:
    int res=0;
    int sumOfLeftLeaves(TreeNode* root) 
    {
        bool fl=true;
        return helpr(root, fl);
    }
    
    int helpr(TreeNode* root, bool fl)
    {
      if(root==NULL)
        return 0;
      if(root->left==NULL && root->right==NULL && fl==true)
      {
        res+=root->val;
        return 0;
      }
      helpr(root->left, true);
      helpr(root->right, false);
      return res;
    }
};
