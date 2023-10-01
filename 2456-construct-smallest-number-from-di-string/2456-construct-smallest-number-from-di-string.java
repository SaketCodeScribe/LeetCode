class Solution {
    public String smallestNumber(String pattern) {
        int start = 1, cnt = 0, i = 0;
        char[] ans = new char[pattern.length()+1];
        ans[i++] = 1+'0';
        for(var ch:pattern.toCharArray()) {
        	if (ch == 'I') {
        		if (cnt > 0) {
	        		int temp;
	        		temp = start = start+cnt;
	        		i--;
	        		while(cnt-- >= 0) 
	        			ans[i++] = (char) ((temp--)+'0');
        		}
        		start++;
    			ans[i++] = (char) (start+'0');
    			cnt = 0;
        	}
        	else {
        		cnt++;
        	}
        }
        if (cnt > 0) {
	        int temp = start = start+cnt;
	        i--;
			while(cnt-- >= 0) 
				ans[i++] = (char) ((temp--)+'0');
        }
        return new String(ans);
    }
}