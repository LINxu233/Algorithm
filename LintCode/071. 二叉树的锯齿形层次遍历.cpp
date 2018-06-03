class Solution 
{
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode *root) 
    {
        vector<vector<int> > result;
        vector<int> cur;
        if(root==NULL)
            return result;
        queue<TreeNode*> Q;
        int counter1=1;
        int counter2=0;
        Q.push(root);
        while(!Q.empty())
        {
            while(counter1-->0)
            {
                TreeNode* temp=Q.front();
                cur.push_back(temp->val);
                Q.pop();
                if(temp->left!=NULL)
                {
                    Q.push(temp->left);
                    ++counter2;
                }
                if(temp->right!=NULL)
                {
                    Q.push(temp->right);
                    ++counter2;
                }
            }
            result.push_back(cur);
            cur.clear();
            counter1=counter2;
            counter2=0;
        }
        for(int i=1;i<result.size();i=i+2)
        {
            reverse(result[i].begin(),result[i].end());
        }
        return result;
    }
};
