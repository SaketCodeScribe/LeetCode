class Solution {
    public int[][] multiply(int[][] a, int[][] b){
        int i, j, k;
        int[][] mat = new int[2][2];
        
        for(i=0; i<2; i++){
            for(j=0; j<2; j++)
                for(k=0; k<2; k++)
                    mat[i][j] += a[i][k]*b[k][j];
        }
        
        return mat;
    }
    public int[][] fibonacciNumber(int[][] mat, int n){
        if (n == 0)
            return new int[][]{{0,1},{1,1}};
        if (n == 1)
            return mat;
        int[][] a = fibonacciNumber(multiply(mat, mat), n/2);
        return n%2 != 0 ? multiply(a,mat) : a;
    }
    public int fib(int n) {
        if (n < 2)
            return n;
        int[][] mat = fibonacciNumber(new int[][]{{0,1},{1,1}}, n-1);
        return mat[1][1];
    }
}