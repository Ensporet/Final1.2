package com.Ens_Library.Excel;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public interface IExcel {

    Workbook getWorkbook();

    Sheet[] getAllSheet();

    Sheet getSheet(String nameSheet);

    Sheet getSheet();

    Row getRow(String nameSheet, int indexRow);

    Row getRow(int indexRow);

    Row getRow();

    Cell getCell(String nameSheet, int indexRow, int indexColum);


    Cell getCell(int indexColum);

    Cell getCell();


}
