class Solution {
    public int trap(int[] arr) {
        int i=0, n = arr.length;
        long ht, ans = 0;
        Stack<Integer> stack = new Stack();
        
        while (i<n) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ht = arr[stack.pop()];
                if (!stack.isEmpty())
                    ans += (Math.min(arr[stack.peek()], arr[i])-ht)*(i-stack.peek()-1);
            }
            stack.add(i++);
        }
        return (int)ans; 
    }
}