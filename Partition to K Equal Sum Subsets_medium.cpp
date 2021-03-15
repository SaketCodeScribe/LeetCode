#define ll long long int
#define v vector<ll>
class Solution {
public:
    ll sum=0;
    bool isSum(vector<int>& nums, vector<ll>& part, ll k, ll i){
        if(i==nums.size()){
            for(auto elt:part)
                if(elt!=sum)
                    return false;
            return true;
        }
        for(ll j=0; j<k; j++){
            if(part[j]+nums[i]<=sum){
                part[j]+=nums[i];
                if(!isSum(nums, part, k, i+1))
                    part[j]-=nums[i];
                else
                    return true;
            }
            if(!part[j])
                break;
        }
        return false;
    }
    
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        ll n=nums.size();
        sum=0;
        for(auto elt:nums)
            sum+=elt;
        if(sum%k || k>n)
            return false;
        v part(k);
        sum/=k;
        for(auto elt:nums)
            if(elt>sum)
                return false;
        return isSum(nums, part, k, 0);
    }
};