class Solution {
    public int countDigitOne(int n) {
        int i, q = 10, m = 1, ans = 0;

        while (n/m > 0){
            ans += n/q*m+Math.min(Math.max(n%q-m+1,0),m);
            q *=10;
            m *= 10;
        }
        return ans;
    }
}