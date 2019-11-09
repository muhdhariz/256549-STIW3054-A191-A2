package com.github.muhdhariz;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

class CreateExcelSheet {
    static void sheet(XSSFSheet sheet, Object[][] data, int rowNum) {

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
