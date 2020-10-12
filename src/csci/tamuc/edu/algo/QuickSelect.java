package csci.tamuc.edu.algo;

import csci.tamuc.edu.common.Util;

/**
 * @author ruby_
 * @create 2020-10-12-2:55 PM
 */

public class QuickSelect {

    //{2, 5, -1, 4, 2, 3} len = 6, len - k index
    public int kthLargest(int[] arr, int k) {
        if(arr == null || k > arr.length || k < 0) return -1;

        return quickSelect(arr, 0, arr.length - 1, arr.length - k);
    }

    private int quickSelect(int[] arr, int start, int end, int k) {
        int l = start, r = end;
        int pivot = arr[l + (r - l) / 2];
        while(l <= r) {
            while(l <= r && arr[l] < pivot) l++;
            while(l <= r && arr[r] > pivot) r--;

            if(l <= r) Util.swap(arr, l++, r--);
        }

        //[start, r] (pivot) [l, end]
        if(start <= r && k <= r) quickSelect(arr, start, r, k);
        if(l <= end && k >= l) quickSelect(arr, l, end, k);
        return pivot;
    }

}
