#define ll long long int
#define v vector<ll>

class NumArray {
public:
    ll n;
    v tree={};
    
    NumArray(vector<int>& nums) {
        ll i, j;
        n=nums.size();
        tree={};
        tree.assign(2*n, 0);
        for(i=n, j=0; j<n; i++, j++)
            tree[i]=nums[j];
        for(i=n-1; i>0; i--)
            tree[i]=tree[2*i]+tree[2*i+1];
    }
    
    void update(int i, int val) {
        ll pos=i+n, left, right;
        tree[pos]=val;
        while(pos>0){
            left=right=pos;
            if(pos&1)
                left=pos-1;
            else
                right=pos+1;
            pos/=2;
            tree[pos]=tree[left]+tree[right];
        }
        return;
    }
    
    int sumRange(int i, int j) {
        ll ans=0;
        i+=n;
        j+=n;
        while(i<=j){
            if(i&1){
                ans+=tree[i];
                i++;
            }
            if(!(j&1)){
                ans+=tree[j];
                j--;
            }
            i/=2;
            j/=2;
        }
        return ans;
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(i,val);
 * int param_2 = obj->sumRange(i,j);
 */