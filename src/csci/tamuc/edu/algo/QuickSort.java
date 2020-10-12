package csci.tamuc.edu.algo;

import csci.tamuc.edu.common.Util;

/**
 * @author ruby_
 * @create 2020-10-11-14:00
 */

public class QuickSort {
    
    public void sort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        
        quickSort(arr, 0, arr.length - 1);
    }

    // l            r
    //  0  1  2  3  4
    // [5, 4, 3, 2, 1] ==> O(n^2) ==> Integer.MAX_VALUE
    private void quickSort(int[] arr, int start, int end) {
        //recursive exit
        int l = start, r = end; //type overflow
        int pivot = arr[l + (r - l) / 2]; //pick up any position
        while(l <= r) {
            while(l <= r && arr[l] < pivot) l++;
            while(l <= r && arr[r] > pivot) r--;

            if(l <= r) {
                Util.swap(arr, l++, r--);
            }
        }

        //  l  r
        //  p
        //  r   l
        // [start, r] x [l, end]
        if(r > start) quickSort(arr, start, r);
        if(l < end) quickSort(arr, l, end);
    }
}
