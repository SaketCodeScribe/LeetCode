class Solution {
    final int MOD = (int)Math.pow(10,9)+7;
    public int maxNiceDivisors(int primeFactors) {
    	if (primeFactors == 1)
    		return 1;
    	if (primeFactors%3 == 0)
    		return (int)pow(3,primeFactors/3);
    	if (primeFactors%3 == 1)
    		return (int)(4*pow(3,primeFactors/3-1)%MOD);
		return (int)(2*pow(3,primeFactors/3)%MOD);
    }

	private long pow(long a, int b) {
		if (b == 1)
			return a;
		if (b == 0)
			return 1;
		long ans = pow((a*a)%MOD,b/2);
		return b%2 != 0 ? (ans*a)%MOD : ans;
	}
}