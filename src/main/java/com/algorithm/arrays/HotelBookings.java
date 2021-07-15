package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotelBookings {

    /**
     * https://www.interviewbit.com/problems/hotel-bookings-possible/
     *
     * Description:
     *  Input :
     *          Arrivals :   [1 3 5]
     *          Departures : [2 6 8]
     *          K : 1
     *
     *  Return : False / 0
     *
     *  At day = 5, there are 2 guests in the hotel. But I have only one room.
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(new Integer[] { 1, 3, 5 }));
        ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(new Integer[] { 2, 6, 8 }));
        System.out.println(hotel(arrive, depart, 1));
    }

    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        int count = 0, n = arrive.size();
        Collections.sort(arrive);
        Collections.sort(depart);
        int indexArrive = 0, indexDepart = 0;

        while (indexArrive < n && indexDepart < n) {
            if (arrive.get(indexArrive) < depart.get(indexDepart)) {
                indexArrive++;
                count++;

                if (count > K) {
                    return false;
                }
            } else {
                indexDepart++;
                count--;
            }
        }
        return true;
    }

}
