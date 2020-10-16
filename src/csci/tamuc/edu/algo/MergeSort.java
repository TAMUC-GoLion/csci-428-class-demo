package csci.tamuc.edu.algo;

/**
 * @author ruby_
 * @create 2020-10-11-14:01
 */

public class MergeSort {

    public void sort(int[] a) {
        if(a == null || a.length < 2) return;

        // [0, a.len  - 1]
        mergeSort(a, 0, a.length - 1, new int[a.length]);
    }

    private void mergeSort(int[] a, int start, int end, int[] tmp) {
        //recursive exist point
        if(start >= end) return;

        final int mid = start + (end - start) / 2;
        mergeSort(a, start, mid, tmp);// assume this already sort [0, mid] for us
        mergeSort(a, mid + 1, end, tmp);// assume this already sort [0, mid] for us

        merge(a, start, end, tmp);
    }

    //                 index =>    start:0            end:5
    // len = end - start + 1   a {.., -1, 0 , 2, 2, 3, 5, ..}
    // a[start, mid] ==> {-1, 0, 2}
    //                              ^p1
    // a[mid + 1, end] ==> {2, 3, 5}
    //                      ^p2
    //==> tmp [start, end] ==> {-1,  0, 2,  2, 3, 5}
    //                                      ^i
    // final, copy all sorted elements in tmp in range [start, end] back to your original array a
    private void merge(int[] a, int start, int end, int[] tmp) {

        final int mid = start + (end - start) / 2;
        int p1 = start, p2 = mid + 1, i = start;
        for(; i <= end && p1 <= mid && p2 <= end; i++) {
            tmp[i] = a[p1] < a[p2] ? a[p1++] : a[p2++];
        }

        while(p1 <= mid) tmp[i++] = a[p1++];
        while(p2 <= end) tmp[i++] = a[p2++];

        //copy back from tmp ==> original
        System.arraycopy(tmp, start, a, start, end - start + 1);
    }
}
