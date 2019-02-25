package com.Laba1.Fill;


import java.util.Arrays;

public class TestLabaFill {

    private final int [] array = new int[12];
    private final Laba_Fill laba_fill = new Laba_Fill();

    public static void main(String[] args) {

        TestLabaFill testLabaFill = new TestLabaFill();

        testLabaFill.laba_fill.fillRandom(testLabaFill.array);
        testLabaFill.printlnArray();

        testLabaFill.laba_fill.fillMinMax(testLabaFill.array);
        testLabaFill.printlnArray();

        testLabaFill.laba_fill.fillMaxMin(testLabaFill.array);
        testLabaFill.printlnArray();

        testLabaFill.laba_fill.fillMaxMinPlusRandomNumber(testLabaFill.array);
        testLabaFill.printlnArray();

    }


    private void printlnArray() {
        System.out.println(Arrays.toString(array));
    }

}
