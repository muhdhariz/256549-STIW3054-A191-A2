package com.github.muhdhariz;

import java.io.File;
import java.io.IOException;

class CreateExcelTempFile {
    static File temp;

    public static void main(String[] args) throws IOException {
        temp = File.createTempFile("Assignment2_", ".xlsx");
    }
}
