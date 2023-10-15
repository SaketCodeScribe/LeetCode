class Solution {
    public int trap(int[] arr) {
        int left = 0, right = arr.length-1;
        long ans = 0, lmax = arr[left], rmax = arr[right];

        while (left <= right){
            if (arr[left] <= arr[right]){
                lmax = Math.max(lmax, arr[left]);
                ans += lmax-(long)arr[left++];
            }
            else{
                rmax = Math.max(rmax, arr[right]);
                ans += rmax-(long)arr[right--];
            }
        }
        
        return (int)ans;
    }
}