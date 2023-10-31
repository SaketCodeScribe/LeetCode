class Solution {
    public int twoEggDrop(int n) {
        int i, j;
        int[] moves = new int[n+1];

        Arrays.fill(moves, Integer.MAX_VALUE);
        moves[0] = 0;
        for(i=1; i<=n; i++){
            for(j=1; j<=i; j++)
                moves[i] = Math.min(moves[i], Math.max(moves[i-j]+1, j));
        }
        return moves[n];
    }
}