class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i, j, k, g, prev, n = nums.length;
        List<int[]> preSuf = new ArrayList<>();
        int[] temp;
        for(var group : groups) {
        	g = group.length;
        	temp = new int[g];
            Arrays.fill(temp, -1);
            i = 1;
            prev = -1;
            while (i < g){
                if (group[i] == group[prev+1])
                    temp[i++] = ++prev;
                else{
                    if (prev == -1)
                    	temp[i++] = prev;
                    else
                        prev = temp[prev];
                }
            }
            preSuf.add(temp);
        }
        j = k = 0;
        while(k<groups.length) {
        	int[] group = groups[k];
            i = 0;
	        while (i<group.length && j<n){
	            if (nums[j] == group[i]){
	                i++;
	                j++;
	            }
	            else{
	                if (i == 0)
	                    j++;
	                else
	                    i = preSuf.get(k)[i-1]+1;
	            }
	        }
	        if (i < group.length)
	        	break;
            k++;
        }
        return k==groups.length; 
    }
}