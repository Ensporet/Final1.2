package com.Laba1.Fill;

import com.Laba1.MyAnnotation.MyFill;

import java.util.Random;

public class Laba_Fill {

    /**
     * "Fill max ... 3,2,1"
     *
     * @param array
     */
    @MyFill(title = "Fill max ... 3,2,1")
    public void fillMaxMin(int[] array) {

        if (array == null) {
            return;
        }

        int curentNumber = array.length - 1;
        for (int i = 0 ; i < array.length ; i++) {
            array[i] = curentNumber--; ;
        }
    }

    /**
     * "Fill 1,2,3 ... max"
     *
     * @param array
     */
    @MyFill(title = "Fill 1,2,3 ... max")
    public void fillMinMax(int[] array) {

        if (array == null) {
            return;
        }

        for (int i = array.length - 1; i >= 0 ; i--) {
            array[i] = i;
        }
    }

    /**
     * Fill 1,2,3 ... max, plus random number
     *
     * @param array
     */
    @MyFill(title = "Fill 1,2,3 ... max, plus random number")
    public void fillMaxMinPlusRandomNumber(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        for (int index = 0; index < array.length; index++) {

            array[index] = index;
        }

        array[array.length - 1] = new Random().nextInt();

    }


    /**
     * Fill random number
     *
     * @param array
     */
    @MyFill(title = "Fill random number ")
    public void fillRandom(int[] array) {

        if (array == null) {
            return;
        }
        Random random = new Random();


        for (int index = 0; index < array.length; index++) {

            array[index] = random.nextInt(array.length);
        }
    }

}
