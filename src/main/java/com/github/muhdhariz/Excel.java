package com.github.muhdhariz;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class ShowOS {

    static File temp;

    public static void main(String[] args) throws IOException {
        temp = File.createTempFile("Assignment2_", ".xlsx");
    }
}

public class Excel {

    private static XSSFWorkbook workbook = new XSSFWorkbook();
    private static XSSFSheet sheet1 = workbook.createSheet("Sir Zamri Followers' Statistic");

    public static void main(String[] args) throws IOException {
        ShowOS.main(args);
        String FILE_NAME = ShowOS.temp.toString();
        Object[][] data1 = Main.Output;

        int rowNum = 0;
        System.out.println();
        System.out.println("Creating " + ShowOS.temp.getName() + " File");
        System.out.println("Excel Filepath: " + ShowOS.temp.getAbsolutePath());

        getRowNum(sheet1, data1, rowNum);

        excel(FILE_NAME, workbook);
    }

    private static void excel(String fileName, XSSFWorkbook workbook) {
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found or currently open");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }

    private static void getRowNum(XSSFSheet sheet, Object[][] data, int rowNum) {
        sheet(sheet, data, rowNum);
    }

    private static void sheet(XSSFSheet sheet, Object[][] data, int rowNum) {
        for (Object[] datatype : data) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                sheet.autoSizeColumn(rowNum);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        for (int x = 0; x < sheet.getRow(0).getPhysicalNumberOfCells(); x++) {
            sheet.autoSizeColumn(x);
        }
    }
}
