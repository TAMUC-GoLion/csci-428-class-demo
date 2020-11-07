package edu.tamuc.csci.algo;

/**
 * Binary Search Code Template
 *
 * Use the template to practice the following LeetCode questions:
 * <ul>
 *   <li><a href="https://leetcode.com/problems/binary-search/">704. Binary Search</a></li>
 *   <li><a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34. Find First and Last Position of Element in Sorted Array</a></li>
 * </ul>
 */

public class BinarySearch {

    /**
     * Binary search through a sorted array {@code nums} and return the index of the target value {@code target}, return -1 if not found
     *
     * @param nums
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {//NOTE here: understand why not use start < end as condition
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] < target) start = mid;
            else end = mid;
        }

        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }

    public static int searchFirst(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < target) start = mid;
            else end = mid;
        }

        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }

    public static int searchLast(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] > target) end = mid;
            else start = mid;
        }

        if(nums[end] == target) return end;
        if(nums[start] == target) return start;
        return -1;
    }
}
