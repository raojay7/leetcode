class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        int n=M.size();
        int cnt=n;
        father.resize(n);
        for (int i = 0; i < n; ++i) {
            father[i]=i;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if(M[i][j]==1){
                    int af=findFather(i);
                    int bf=findFather(j);
                    if(af!=bf){
                        father[af]=bf;
                        cnt--;
                    }
                }
            }
        }
        return cnt;
    }

private:
    vector<int> father;
    int findFather(int x){
        while(x!=father[x]){
            x=father[x];
        }
        return x;
    }

};
