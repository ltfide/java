package dev.local.array;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MultidimensionalArrayApp {

    /*
     * ======|| col 1 || col 2
     * ========================
     * row 1 || 1 || 2
     * ========================
     */
    @Test
    void twoMultiArray() {
        int[][] arr = new int[1][2];

        arr[0][0] = 1;
        arr[0][1] = 2;

        System.out.println("row 1 col 1: " + arr[0][0]);
        System.out.println("row 1 col 2: " + arr[0][1]);
    }

    /*
     * 3d array that can hold a maximum of 24 (3*4*2) elements of type String.
     */
    @Test
    void threeMultiArray() {
        String[][][] arr = new String[3][4][2];

        System.out.println(arr.length);
        System.out.println(arr[0].length);
        System.out.println(arr[0][0].length);
    }

    @Test
    void initializeTwoMultiArray() {
        int[][] arr = {
                { 1, 2, 3 },
                { 1, 2 },
                { 1 }
        };

        // [[], [], []]
        System.out.println(Arrays.toString(arr));

        // calculate the length of each row
        System.out.println("Length of row 1: " + arr[0].length); // 3
        System.out.println("Length of row 2: " + arr[1].length); // 2
        System.out.println("Length of row 3: " + arr[2].length); // 1
    }

    @Test
    void forTwoMultiArray() {
        int[][] arr = {
                { 1, 2, 3 },
                { 1, 2 },
                { 1 }
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }

        // output
        // 1, 2, 3, 1, 2, 1
    }

    @Test
    void forEachTwoMultiArray() {
        int[][] arr = {
                { 1, 2, 3 },
                { 1, 2 },
                { 1 }
        };

        for (int[] arr1 : arr) {
            for (int arr2 : arr1) {
                System.out.println(arr2);
            }
        }
    }

    @Test
    void initializeThreeMultiArray() {
        int[][][] arr = {
                {
                        { 1, -2, 3 },
                        { 2, 3, 4 }
                },
                {
                        { -4, -5, 6, 9 },
                        { 1 },
                        { 2, 3 }
                }
        };

        // [[[]], [[]]]
        System.out.println(Arrays.toString(arr));
    }

    @Test
    void forThreeMultiArray() {
        int[][][] arr = {
                {
                        { 1, -2, 3 },
                        { 2, 3, 4 }
                },
                {
                        { -4, -5, 6, 9 },
                        { 1 },
                        { 2, 3 }
                }
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    System.out.println(arr[i][j][k]);
                }
            }
        }
    }

    @Test
    void forEachThreeMultiArray() {
        int[][][] arr = {
                {
                        { 1, -2, 3 },
                        { 2, 3, 4 }
                },
                {
                        { -4, -5, 6, 9 },
                        { 1 },
                        { 2, 3 }
                }
        };

        for (int[][] arr1 : arr) {
            for (int[] arr2 : arr1) {
                for (int arr3 : arr2) {
                    System.out.println(arr3);
                }
            }
        }
    }
}
