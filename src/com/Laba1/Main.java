package com.Laba1;

import com.Laba1.Test.Test;


public class Main {

    /**
     * Package where you need to test sorters with annotation @MYSort  @MYFill
     */
    private static final String PACKET = Main.class.getPackage().getName();

    /**
     * Number of test steps
     */
    private static final int    SIZE_STEP = 10;

    /**
     * Increase items for each step
     */
    private static final int    LENGTH_STEP = 2000;

    /**
     * Path for result save test
     */
    private static final String savePath = "SaveDataTest\\excelFile.xlsx" ;


    public static void main(String args[]) {

    new Test().run(
            Main.PACKET ,
            Main.SIZE_STEP ,
            Main.LENGTH_STEP ,
            Main.savePath
    );

}}

