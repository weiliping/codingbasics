package com.algorithm.contest.weeklycontest307;

public class MinNumberOfHours {
    public static void main(String[] args) {
//        int initialEnergy = 5, initialExperience = 3, energy[] = new int[] { 1, 4, 3, 2 }, experience[] =
//                new int[] { 2, 6, 3, 1 };
//        System.out.println(minNumberOfHours(initialEnergy, initialExperience, energy, experience));
//
//        int initialEnergy2 = 2, initialExperience2 = 4, energy2[] = new int[]{1}, experience2[] = new int[]{3};
//        System.out.println(minNumberOfHours(initialEnergy2, initialExperience2, energy2, experience2));
//
//        int initialEnergy3 = 1, initialExperience3 = 1, energy3[] = new int[]{1, 1, 1, 1}, experience3[] = new int[]{1, 1, 1, 50};
//        System.out.println(minNumberOfHours(initialEnergy3, initialExperience3, energy3, experience3));
        int initialEnergy4 = 11,
            initialExperience4 = 23,
            energy4[] = new int[]{69,22,93,68,57,76,54,72,8,78,88,15,58,61,25,70,58,91,79,22,91,74,90,75,31,53,31,7,51,96,76,17,64,89,83,54,28,33,32,45,20},
            experience4[] = new int[]{51,81,46,80,56,7,46,74,64,20,84,66,13,91,49,30,75,43,74,88,82,51,72,4,80,30,10,19,40,27,21,71,24,94,79,13,40,28,63,85,70};

        System.out.println(minNumberOfHours(initialEnergy4, initialExperience4, energy4, experience4));
        System.out.println(minNumberOfHoursI(initialEnergy4, initialExperience4, energy4, experience4));
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int minNumber = 0, n = energy.length, sumEnergy = 0;
        for (int i = 0; i < n; i++) {
            sumEnergy += energy[i];
            if (initialExperience > experience[i]) {
                initialExperience += experience[i];
            } else {
                int gap = experience[i] - initialExperience + 1;
                initialExperience += gap + experience[i];
                minNumber += gap;
            }
        }
        if (initialEnergy > sumEnergy) {
            return minNumber;
        }
        minNumber += sumEnergy - initialEnergy + 1;
        return minNumber;
    }

    public static int minNumberOfHoursI(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int a = 0;
        int time = 0;
        int n = energy.length;
        for (int i = 0; i < n; i++) {
            a += energy[i];
            if (initialExperience > experience[i]) {
                initialExperience += experience[i];
            } else {
                int other = experience[i] - initialExperience + 1;
                time += experience[i] - initialExperience + 1;
                initialExperience += experience[i] + other;
            }
        }

        if (a < initialEnergy) {
            return time;
        } else {
            time += (a - initialEnergy) + 1;
            return time;
        }
    }
}
