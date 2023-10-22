class Solution {
    public String reverseParentheses(String s) {
        int i, j, n = s.length(), d=1;
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder ans = new StringBuilder();
        int[] wormhole = new int[n];

        for(i=0; i<n; i++){
            if (s.charAt(i) == '(')
                stack.push(i);
            else if (s.charAt(i) == ')'){
                wormhole[i] = stack.peek();
                wormhole[stack.pop()] = i;
            }
        }
        i=0;
        while (i<n){
            if (s.charAt(i) == '(' || s.charAt(i) == ')'){
                i = wormhole[i];
                d = -d;
            }
            else
                ans.append(s.charAt(i));
            i += d;
        }
        return ans.toString();
    }
}