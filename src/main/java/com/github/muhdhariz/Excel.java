package com.github.muhdhariz;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class Excel {
    private static XSSFWorkbook workbook = new XSSFWorkbook();
    private static XSSFSheet sheet1 = workbook.createSheet("Sir Zamri Followers' Statistic");
    private static CreateExcelTempFile createExcelTempFile = new CreateExcelTempFile();

    public static void main(String[] args) throws IOException {
        createExcelTempFile.main(args);
        String FILE_NAME = CreateExcelTempFile.temp.toString();
        Object[][] data1 = Output.Output;

        int rowNum = 0;
        System.out.println();
        System.out.println("Creating " + CreateExcelTempFile.temp.getName() + " File");
        System.out.println("Excel Filepath: " + CreateExcelTempFile.temp.getAbsolutePath());

        CreateExcelSheet.sheet(sheet1, data1, rowNum);

        new CreateExcel(FILE_NAME, workbook);
    }
}
