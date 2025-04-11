package com.datastructure;

public class BinarySearchV2 {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 3, 3, 5, 7, 12, 13};
        BinarySearchV2 bs = new BinarySearchV2();
        // System.out.println(bs.binarySearch(nums, 3)); // 1
        // System.out.println(bs.binarySearch(nums, 5)); // 3
        // System.out.println(bs.binarySearch(nums, 8)); // -1
        // System.out.println(bs.binarySearch(nums, 0)); // -1
        // System.out.println(bs.binarySearch(nums, 13)); // 6
        // System.out.println(bs.binarySearch(nums, 3)); 
        // System.out.println(bs.binarySearch(nums, 3)); 
        // System.out.println(bs.binarySearch(nums, 3)); 
        // System.out.println(bs.binarySearch(nums, 3)); 
        // System.out.println(bs.bsFirstEqual(nums, 3)); 
        // System.out.println(bs.bsLastEqual(nums, 3)); 
        System.out.println(bs.bsFristEqualG(nums, 2)); 
        System.out.println(bs.bsLastEqualL(nums, 3)); 
        System.out.println(bs.bsLastEqualL(nums, 6));
        // System.out.println(bs.bsLastEqual(nums, 6));
    }
    
    public int binarySearch(int[] nums, int val) {
        if (nums[0] > val) {
            return -1;
        }

        if (nums[nums.length - 1] < val) {
            return nums.length;
        }

        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + ((j - i) >> 1);
            if (nums[m] == val) {
                return m;
            } else if (nums[m] < val) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return -1;
    }

    public int bsFirstEqual(int[] nums, int val) {
        if (nums[0] > val) {
            return -1;
        }

        if (nums[nums.length - 1] < val) {
            return nums.length;
        }
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + ((j - i) >> 1);
            if (nums[m] == val) {
                if (m == 0 || nums[m - 1] < val) {
                    return m;
                }
                j = m - 1;
            } else if (nums[m] < val) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return -1;
    }

    public int bsLastEqual(int[] nums, int val) {
        if (nums[0] > val) {
            return -1;
        }

        if (nums[nums.length - 1] < val) {
            return nums.length;
        }
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + ((j - i) >> 1);
            if (nums[m] == val) {
                if (m == nums.length - 1 || nums[m + 1] > val) {
                    return m;
                }
                i = m + 1;
            } else if (nums[m] < val) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return -1;
    }

    public int bsFristEqualG(int[] nums, int val) {
        if (nums[0] > val) {
            return -1;
        }

        if (nums[nums.length - 1] < val) {
            return nums.length;
        }

        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int m = i + ((j - i) >> 1);
            if (nums[m] >= val) {
                if (m == 0 || nums[m - 1] < val) {
                    return m;
                }
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    public int bsLastEqualL(int[] nums, int val) {
        if (nums[0] > val) {
            return -1;
        }

        if (nums[nums.length - 1] < val) {
            return nums.length;
        }

        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int m = i + ((j - i) >> 1);
            if (nums[m] <= val) {
                if (m == nums.length - 1 || nums[m + 1] > val) {
                    return m;
                }
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
