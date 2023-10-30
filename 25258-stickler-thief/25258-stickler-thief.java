class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
       
        int i, prev = -1, curr, pprev = 0;
        prev = arr[0];
        
        for(i=1; i<n; i++){
            curr = Math.max(pprev+arr[i], prev);
            pprev = Math.max(prev, pprev);
            prev = curr;
        }
        return prev;
    }
}