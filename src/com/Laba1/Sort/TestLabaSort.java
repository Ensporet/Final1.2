package com.Laba1.Sort;

import com.Laba1.Fill.Laba_Fill;

import java.util.Arrays;

public class TestLabaSort {

    private Laba_Fill laba_fill = new Laba_Fill();
    private Laba_Sort laba_sort = new Laba_Sort();
    private int   []  array     = new int[12];

    public static void main(String[] args) {

        TestLabaSort testLabaSort = new TestLabaSort();

        testLabaSort.fill();
        testLabaSort.laba_sort.sortBubbleMinMax(testLabaSort.array);
        testLabaSort.printlnArray("Bubble maxMin");


        testLabaSort.fill();
        testLabaSort.laba_sort.sortBubbleMaxMin(testLabaSort.array);
        testLabaSort.printlnArray("Bubble minMax");

        testLabaSort.fill();
        testLabaSort.laba_sort.sortRecursion(testLabaSort.array);
        testLabaSort.printlnArray("Recursion");

        testLabaSort.fill();
        testLabaSort.laba_sort.sortExchange(testLabaSort.array);
        testLabaSort.printlnArray("Exchange");

        testLabaSort.fill();
        testLabaSort.laba_sort.sortArrays(testLabaSort.array);
        testLabaSort.printlnArray("Arrays");


    }



    private void fill() {
        laba_fill.fillRandom(array);
    }

    private void printlnArray() {
        System.out.println(Arrays.toString(array));
    }

    private void printlnArray(String text) {
        System.out.println(text + " : " + Arrays.toString(array));
    }
}
