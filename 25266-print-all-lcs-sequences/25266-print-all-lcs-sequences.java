class SortByString implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}	
}

class Solution
{
    static int[][] dp;
    static Map<String,Set<String>> map;
    static Set<String> findSub(String s1, String s2, int i, int j){
    	Set<String> ans = new HashSet<String>();
        Set<String> subs;
        StringBuilder res;
        if(i<=0 || j<=0)
            return ans;
        if(map.get(i+""+j) != null)
        	return map.get(i+""+j);
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            subs = findSub(s1,s2,i-1,j-1);
            if (subs.size() > 0){
                for(var sub:subs){
                    res = new StringBuilder(sub);
                    res.append(s1.charAt(i-1));
                    ans.add(res.toString());
                }
            }
            else
                ans.add(""+s1.charAt(i-1));
        }
        else if(dp[i-1][j] > dp[i][j-1]){
            subs = findSub(s1,s2,i-1,j);
            for(var sub:subs)
                ans.add(sub);
        }
        else if(dp[i-1][j] < dp[i][j-1]){
            subs = findSub(s1,s2,i,j-1);
            for(var sub:subs)
                ans.add(sub);
        }
        else{
            subs = findSub(s1,s2,i-1,j);
            for(var sub:subs)
                ans.add(sub);
            subs = findSub(s1,s2,i,j-1);
            for(var sub:subs)
                ans.add(sub);
        }
        map.put(i+""+j,ans);
        return ans;
    }
    public static List<String> all_longest_common_subsequences(String s1, String s2)
    {
        int i, j, s=s1.length(), t=s2.length();
        dp = new int[s+1][t+1];
        map = new HashMap<String, Set<String>>();
        
        for(i=1; i<=s; i++){
            for(j=1; j<=t; j++)
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
        }
        List<String> ans = new ArrayList<String>();
        ans.addAll(findSub(s1,s2,s,t));
        ans.sort(new SortByString());
        return ans;
    }
}