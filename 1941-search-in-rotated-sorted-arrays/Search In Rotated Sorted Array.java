import java.util.Arrays;

public class Solution {
    public static int search(int arr[], int key) {
        int low = 0, high = arr.length-1, mid;

        while (low<=high){
            mid = low+(high-low)/2;
            if (arr[mid] == key)
                return mid;
            if (arr[low] <= arr[mid]){
                if (arr[mid] > key && arr[low] <= key)
                    high = mid-1;
                else
                    low = mid+1;
            }
            else{
                if (arr[mid] < key && arr[high] >= key)
                    low = mid+1;
                else
                    high = mid-1;

            }
        }
        return -1;
    }
}