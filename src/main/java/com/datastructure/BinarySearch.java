package com.datastructure;

public class BinarySearch {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 5, 7, 9, 11, 13, 16, 19, 21};

        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(nums, 13));
        System.out.println(bs.binarySearch(nums, 9));
        System.out.println(bs.binarySearch(nums, 12));

        int[] nums2 = new int[] {1, 3, 5, 7, 9, 11, 11, 16, 19, 21};
        System.out.println(bs.searchFirstEqual(nums2, 11));
        System.out.println(bs.searchLastEqual(nums2, 11));
        System.out.println(bs.searchFirstNotLess(nums2, 8));
        System.out.println(bs.searchLastNotGreater(nums2, 10));
    }

    public int binarySearch(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == val) {
                return mid;
            }
            if (nums[mid] < val) {
                low = mid + 1;
                continue;
            }
            high = mid - 1;
        }
        return -1;
    }

    public int searchFirstEqual(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, n = nums.length, high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= val) {
                high = mid - 1;
                continue;
            }
            low = mid + 1;
        }

        if (low < n && nums[low] == val) {
            return low;
        }
        return -1;
    }

    public int searchLastEqual(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, n = nums.length, high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > val) {
                high = mid - 1;
            } else if (nums[mid] < val) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (nums[mid + 1] != val)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public int searchFirstNotLess(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, n = nums.length, high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= val) {
                if ((mid == 0) || (nums[mid - 1] < val)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
                continue;
            }
            low = mid + 1;
        }
        return -1;
    }

    public int searchLastNotGreater(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, n = nums.length, high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > val) {
                high = mid - 1;
                continue;
            }
            if ((mid == n - 1) || (nums[mid + 1] > val)) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
