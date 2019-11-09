package com.github.muhdhariz;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class CreateExcel {

    CreateExcel(String fileName, XSSFWorkbook workbook) {
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

}
