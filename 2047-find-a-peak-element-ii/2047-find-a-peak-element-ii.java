class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int lc = 0, hc = mat[0].length, r, mc;

        while (lc <= hc){
            r = 0;
            mc = lc+(hc-lc)/2;
            for(int i = 0; i<mat.length; i++){
                if (mat[i][mc] > mat[r][mc])
                    r = i;
            }
            if (mc > 0 && mat[r][mc] < mat[r][mc-1])
                hc = mc-1;
            else if (mc < mat[0].length-1 && mat[r][mc] < mat[r][mc+1])
                lc = mc+1;
            else
                return new int[]{r,mc};
        }
        return new int[]{-1,-1};
    }
}