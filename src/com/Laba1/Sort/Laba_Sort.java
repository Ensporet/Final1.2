package com.Laba1.Sort;

import com.Laba1.MyAnnotation.MySort;

import java.util.Arrays;

public class Laba_Sort {

    /**
     * Sort using library "java.util.Arrays"
     *
     * @param array
     */
    @MySort(title = "Sort of java.util.Arrays")
    public void sortArrays(int[] array) {

        if (array == null) {
            return;
        }

        Arrays.sort(array);

    }

//......................................................................................................................

    /**
     * Bubble sorting with building from maximum to minimum
     */
    @MySort(title = "Sort bubble max to min")
    public void sortBubbleMaxMin(int[] array) {

        if (array == null) {
            return;
        }

        for (int iterations = 0; iterations < (array.length - 1); iterations++) {

            sortIterateMaxMin(array, iterations);

        }

    }

    private void sortIterateMaxMin(int[] integerArray, final int indexFinalist) {

        for (int index = (integerArray.length - 1); index > indexFinalist; index--) {

            max_min(integerArray, index, (index - 1));
        }
    }


    private void max_min(int[] integerArray, int indexOne, int indexTwo) {

        if (integerArray[indexOne] > integerArray[indexTwo]) {

            int i = integerArray[indexOne];
            integerArray[indexOne] = integerArray[indexTwo];
            integerArray[indexTwo] = i;
        }
    }
//......................................................................................................................

    /**
     * Bubble sorting with building from minimum to maximum
     */
    @MySort(title = "Sort bubble min to max")
    public void sortBubbleMinMax(int[] array) {

        if (array == null) {
            return;
        }

        for (int iterations = (array.length - 1); iterations > 0; iterations--) {
            sortIterateMinMax(array, iterations);
        }

    }


    private void sortIterateMinMax(int[] integerArray, final int indexFinalist) {

        for (int index = 0; index < indexFinalist; index++) {

            min_max(integerArray, index, (index + 1));

        }
    }

    private void min_max(int[] integerArray, int indexOne, int indexTwo) {

        if (integerArray[indexOne] > integerArray[indexTwo]) {

            int i = integerArray[indexTwo];
            integerArray[indexTwo] = integerArray[indexOne];
            integerArray[indexOne] = i;
        }
    }

    //..................................................................................................................

    @MySort(title = "Sort exchange")
    public void sortExchange(int[] array) {

        if (array == null) {
            return;
        }


        for (int integer = 0; integer < array.length; integer++) {

            int min = integer;
            for (int searthMin = integer + 1; searthMin < array.length; searthMin++) {

                if (array[min] > array[searthMin]) {
                    min = searthMin;
                }
            }

            if (min != integer) {

                int chen = array[integer];
                array[integer] = array[min];
                array[min] = chen;
            }
        }
    }

    //..............................................................................................................
    @MySort(title = "Sort recursion and separation ")
    public void sortRecursion(int in[]) {
        sortRecursion(in, 0, in.length - 1);
    }

    public void sortRecursion(int in[], int a, int b) {
        int i, j;
        double sr = 0;
        if (a >= b) {
            return;
        }
        for (i = a; i <= b; i++) {
            sr += in[i];
        }
        sr = sr / (b - a + 1);
        for (i = a, j = b; i <= j; ) {
            if (in[i] < sr) {
                i++;
                continue;
            }
            if (in[j] >= sr) {
                j--;
                continue;
            }
            int c = in[i];
            in[i] = in[j];
            in[j] = c;
            i++;
            j--;
        }
        if (i == a) {
            return;
        }

        sortRecursion(in, a, j);
        sortRecursion(in, i, b);
    }

    //..............................................................................................................


}