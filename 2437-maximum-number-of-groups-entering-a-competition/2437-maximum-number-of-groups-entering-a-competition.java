class Solution {
    public int maximumGroups(int[] grades) {
        return (-1+(int)Math.sqrt(1+4*grades.length*2))/2;
    }
}