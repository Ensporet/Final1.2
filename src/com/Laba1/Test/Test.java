package com.Laba1.Test;

import com.Ens_Library.Excel.ElementСonstructors.Chart.ExcelChartLine;
import com.Ens_Library.Excel.Excel;
import com.Ens_Library.Excel.IExcel;
import com.Laba1.MyAnnotation.MyFill;
import com.Laba1.MyAnnotation.MySort;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Class for test sorters
 */
public class Test implements ITest {

    @Override
    public void run(String searchPacket, int sizeSteps, int lengthStep) {

        run(searchPacket, sizeSteps, lengthStep, "SaveTest\\excelFile.xlsx");
    }

    @Override
    public void run(String searchCatalog, int step, int length_step, String packForSaveTest) {

        List<Class<?>> listClass = ClassFinder.find(searchCatalog); //AllClass in the packet

        long time;
        Excel excel = new Excel(new File(packForSaveTest));
        int indexRow = 0;


        for (Class cl : listClass) {                                       //Search class with myAnnotation (MethodFill)
            Object classFill = null;
            for (Method method : cl.getMethods()) {
                for (Annotation annotation : method.getAnnotations()) {
                    if (annotation instanceof MyFill) {
                        if (classFill == null) {
                            try {
                                classFill = cl.newInstance();

                            } catch (InstantiationException | IllegalAccessException e) {
                                e.printStackTrace();
                                continue;
                            }
                        }


                        indexRow++;                                         //excel index row


                        for (int iteration = 1; iteration <= step; iteration++) {//iterations step length element array
                            int[] arrayIntegers = new int[iteration * length_step];


                            try {
                                method.invoke(classFill, (Object) arrayIntegers);//Activation fill array
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                                continue;
                            }


                            /*
                              Space to display information in the console, between the methods of filling
                             */
                            System.out.println();

                            for (Class cl1 : listClass) {           //Search class with myAnnotation (MethodSort)
                                Object classSort = null;

                                for (Method method1 : cl1.getMethods()) {
                                    for (Annotation annotation1 : method1.getAnnotations()) {
                                        if (annotation1 instanceof MySort) {
                                            if (classSort == null) {
                                                try {
                                                    classSort = cl1.newInstance();
                                                } catch (InstantiationException | IllegalAccessException e) {
                                                    e.printStackTrace();
                                                    continue;
                                                }
                                            }

                                            try {              //test methodSort with methodFill and return time
                                                long timeStart = System.nanoTime();
                                                method1.invoke(classSort, (Object) arrayIntegers);
                                                time = System.nanoTime() - timeStart;
                                            } catch (IllegalAccessException | InvocationTargetException e) {
                                                e.printStackTrace();
                                                continue;
                                            }


                                            /**
                                             *  println information about result test Sort
                                             */
                                            System.out.println(
                                                    "|Method fill : " + ((MyFill) annotation).title() +
                                                            "|Method sort : " + ((MySort) annotation1).title() +
                                                            "|Length array : " + (iteration * length_step) +
                                                            "|Time run nanosecond : " + time
                                            );

                                            /**
                                             * write result to a workbook
                                             */
                                            writeToWorkBook(excel, indexRow, iteration, time,
                                                    ((MyFill) annotation).title(),
                                                    ((MySort) annotation1).title(),
                                                    iteration * length_step);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        final int width = 20;
        final int height = 25;
        int iteration = 0;
        for (Sheet sheet : excel.getAllSheet()) {                       // create charts

            aftSizeColumn(sheet, step + 1);

            createChart(sheet, null, width, height, -1, -1);
            createChart(sheet, excel.getSheet("All Charts"), width, height,
                    iteration++ * height, 0);
        }

        excel.writeAndCloseWrite();
        excel.close();

    }


    private void writeToWorkBook(IExcel excel, int indexRow, int indexColumn, long time,
                                 String nameFill, String nameSort, int lengthCurrentArray) {

        excel.getCell(                              //set value
                nameSort,
                indexRow,
                indexColumn
        ).setCellValue(time);
        excel.getCell().setCellStyle(cellStyle(excel.getWorkbook()));


        excel.getCell(0).setCellValue(nameFill);                //set name row
        excel.getCell().setCellStyle(cellStyleName(excel.getWorkbook()));


        excel.getCell(                                              // set name column
                nameSort,
                0,
                indexColumn
        ).setCellValue(lengthCurrentArray);
        excel.getCell().setCellStyle(cellStyleName(excel.getWorkbook()));

    }


    private void createChart(Sheet lacationData, Sheet locationChart, int width, int height,
                             int replaceRow, int replaceColumn) {

        new ExcelChartLine().addToSheet(
                lacationData, 0, 0, -1, -1,
                locationChart, replaceRow, replaceColumn, width, height,
                "Length array", "Method fill", lacationData.getSheetName()
        );

    }


    private void aftSizeColumn(Sheet sheet, int column) {

        for (int i = 0; i < column; i++) {
            Row row = sheet.getRow(0);
            if (row.getCell(i) == null) {
                row.createCell(i);
            }
            sheet.autoSizeColumn(i);
        }

    }


    public CellStyle cellStyle(Workbook workbook) {

        CellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setBorderBottom(BorderStyle.HAIR);
        cellStyle.setBorderRight(BorderStyle.HAIR);
        cellStyle.setBorderLeft(BorderStyle.HAIR);
        cellStyle.setBorderTop(BorderStyle.HAIR);

        return cellStyle;
    }

    public CellStyle cellStyleName(Workbook workbook) {

        CellStyle cellStyle = workbook.createCellStyle();
        BorderStyle borderStyle = BorderStyle.MEDIUM;

        Font font = workbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);

        cellStyle.setBorderBottom(borderStyle);
        cellStyle.setBorderRight(borderStyle);
        cellStyle.setBorderLeft(borderStyle);
        cellStyle.setBorderTop(borderStyle);

        return cellStyle;
    }
}
