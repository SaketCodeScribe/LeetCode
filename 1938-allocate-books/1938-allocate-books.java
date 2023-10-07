import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
		if (m > n)
			return -1;
        long low = arr.stream().max(Integer::compareTo).get(), mid, high=0;
        for(Integer val:arr)
            high += val;
        while (low < high){
            mid = low+(high-low)/2;
			if (noOfStudents(arr,mid, m) <= m)
                high = mid;
            else
                low = mid+1;
        }
        return (int) high;
    }

	private static int noOfStudents(ArrayList<Integer> arr, long mid, int m) {
		long pages = 0, students = 1;
		for(Integer val:arr) {
			if(pages+val <= mid)
				pages += val;
			else {
				students++;
				pages = val;
			}
		}
		return (int) students;
	}
}