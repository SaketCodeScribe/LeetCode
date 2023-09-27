class Solution {
    private long cnt;
	
	public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        cnt = 0;
        int[] arr = IntStream.range(0, nums1.length).map(i -> nums1[i]-nums2[i]).toArray();
        Arrays.stream(arr).forEach(a->System.out.print(a+" "));
        System.out.println();
        mergeSort(arr, diff, 0, arr.length-1);
        Arrays.stream(arr).forEach(a->System.out.print(a+" "));
        return cnt;
    }
    private void mergeSort(int[] arr, int diff, int lo, int hi) {
    	if (lo < hi){
            int mid = lo+(hi-lo)/2;
            mergeSort(arr, diff, lo, mid);
            mergeSort(arr, diff, mid+1, hi);
            merge(lo, mid, mid+1, hi, arr, diff);
        }
	}
	private void merge(int ls, int le, int rs, int re, int[] arr, int diff) {
		int i, j, k, m = le-ls+1, n = re-rs+1;
        // System.out.println(le+" "+ls+" "+re+" "+rs);
		int[] left = new int[m];
		int[] right = new int[n];
		int [] temp = new int[m+n];
		for(i=ls; i<=le; i++)
			left[i-ls] = arr[i];
		for(i=rs; i<=re; i++)
			right[i-rs] = arr[i];
		i = 0;
		j = 0;
		k = 0;
        while (i <m && j <n) {
			if (left[i] <= right[j]+diff) {
                cnt += n-j;
                i++;
			}
			else
                j++;
		}
        i = j = 0;
		while (i <m && j <n) {
			if (left[i] < right[j]) 
				temp[k++] = left[i++];
			else 
				temp[k++] = right[j++];
		}
		while (j <n) {
			temp[k++] = right[j++];
		}
		while(i <m) {
			temp[k++] = left[i++];
		}
        k = 0;
        for(i=ls; i<=re; i++ )
            arr[i] = temp[k++];
	}
}