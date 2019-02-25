package com.Laba1.Test;

/**
 * Class for sorting test
 */
public interface ITest {


    /**
     * Start test
     *
     * @param searchPacket The name of the directory in which the required classes are located.
     * @param sizeSteps    The number of steps that must be completed
     * @param lengthStep   Increasing the array length with each step
     */
    void run(String searchPacket, int sizeSteps, int lengthStep);

    /**
     * Start test
     *
     * @param searchPacket    The name of the directory in which the required classes are located.
     * @param sizeSteps       The number of steps that must be completed
     * @param lengthStep      Increasing the array length with each step
     * @param packForSaveTest The path where the test result file will be saved
     */
    void run(String searchPacket, int sizeSteps, int lengthStep, String packForSaveTest);

}
