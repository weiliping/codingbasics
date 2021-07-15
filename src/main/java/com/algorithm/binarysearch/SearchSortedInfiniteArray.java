package com.algorithm.binarysearch;

import java.util.ArrayList;

public class SearchSortedInfiniteArray {

    class ArrayReader {
        ArrayList<Integer> infinitArray = new ArrayList<>();

        public int get(int index) {
            return infinitArray.get(index);
        }
    }

    /**
     * @param reader
     * @param target
     * @return
     */
    public static int search(ArrayReader reader, int target) {
        int start = 0, end = Integer.MAX_VALUE;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == reader.get(mid)) {
                return mid;
            } else if (target < reader.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (reader.get(start) == target) {
            return start;
        } else if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }

    public static int searchII(ArrayReader reader, int target) {
        int hi = 1;
        while (reader.get(hi) < target) {
            hi = hi * 2;
        }
        int low = hi / 2;
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            int val = reader.get(mid);
            if (val == target) {
                return mid;
            } else if ( val > target) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
