class Solution {
    public int minFlipsMonoIncr(String s) {
        int i = 0, ones = 0, flips = 0;
        while ( i < s.length()){
            if (s.charAt(i++) == '1')
                    ones++;
            else
                flips++;
            flips = Math.min(flips, ones);
        }
        return flips;
    }
}