class Solution {

    public int maxArea(int[] ht){
        int ar = 0, i = 0, n = ht.length;
        Stack<Integer> stack = new Stack<Integer>();
        
        while (i<n){
            while (stack.size() > 0 && ht[stack.peek()] >= ht[i]){
                int id = stack.peek();
                int h = ht[stack.pop()];
                int b = i-(stack.size() > 0 ? stack.peek() : -1)-1;
                ar = Math.max(ar, h*b);
            }
            stack.push(i++);
        }
        while (stack.size() > 0){
            int id = stack.peek();
            int h = ht[stack.pop()];
            int b = n - (stack.size() > 0 ? stack.peek() : -1)-1;
            ar = Math.max(ar, h*b);
        }
        return ar;
    }

    public int maximalRectangle(char[][] matrix) {
        int i, j, m = matrix.length, n = matrix[0].length, ans = 0;
        int [] ht = new int[n];
        
        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if(matrix[i][j] == '1')
                    ht[j]++;
                else
                    ht[j] = 0;
            }
            ans = Math.max(ans, maxArea(ht));
        }
        return ans;
    }
}