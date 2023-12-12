package com.h3d.ui.utilities;

import com.h3d.ui.constants.FilePathConstants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.log4testng.Logger;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ReadExcel {

    static HashMap<String, String> data = null;
    static Logger logger = Logger.getLogger(ReadExcel.class);

    /**
     * This method is used to read the data based on testCaseID
     *
     * @param TestCaseID
     * @return
     */
    public static HashMap<String, String> getUserData(String TestCaseID) {
        try {
            File file = new File(FilePathConstants.TESTDATA_HOME);
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(FilePathConstants.TESTDATA_SHEET);
            data = new HashMap<String, String>();

            for (int row = 0; row <= sheet.getLastRowNum(); row++) {

                // Unique Field for particular test case
                String testCase = sheet.getRow(row).getCell(0).getStringCellValue();

                if (testCase.contains(TestCaseID)) {
                    for (int index = 1; index < sheet.getRow(0).getLastCellNum(); index++) {

                        String key = sheet.getRow(0).getCell(index).getStringCellValue();
                        Cell CellValue = sheet.getRow(row).getCell(index);

                        logger.info("KEY" + key);
                        logger.info("CellValue" + CellValue);
                        String value = null;
                        if (CellValue != null) {
                            value = CellValue.getStringCellValue();
                        }
                        data.put(key, value);
                    }
                }
            }
            workbook.close();

        } catch (Exception e) {
            logger.error("Excel read is not performed" + e);
        }

        return data;
    }


    /**
     * This method is used to read the data based on testCaseID and sheetname
     *
     * @param TestCaseID
     * @param sheetName
     * @return
     */
    public static HashMap<String, String> getUserData(String TestCaseID, String sheetName) {
        try {
            File file = new File(FilePathConstants.TESTDATA_HOME);
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            data = new HashMap<String, String>();

            for (int row = 0; row <= sheet.getLastRowNum(); row++) {

                // Unique Field for particular test case
                String testCase = sheet.getRow(row).getCell(0).getStringCellValue();

                if (testCase.contains(TestCaseID)) {
                    for (int index = 1; index < sheet.getRow(0).getLastCellNum(); index++) {

                        String key = sheet.getRow(0).getCell(index).getStringCellValue();
                        Cell CellValue = sheet.getRow(row).getCell(index);

                        String value = null;
                        if (CellValue != null) {
                            value = CellValue.getStringCellValue();
                        }
                        data.put(key, value);
                    }
                }
            }
            workbook.close();

        } catch (Exception e) {
            logger.error("Excel read is not performed");
        }

        return data;
    }

    /**
     * This method is used to read the data based on sheetName
     *
     * @param sheetName
     * @return
     */
    public static List<Map<String, String>> getExcelData(String sheetName) {
        List<Map<String, String>> testDataAllRows = null;
        Map<String, String> testData = null;
        String filePath = FilePathConstants.TESTDATA_HOME;
        try {
            FileInputStream fielInput = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fielInput);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
            List<String> headers = new ArrayList<String>();
            for (int index = 0; index < columnCount; index++) {
                Row titleRow = sheet.getRow(0);
                Cell titleCell = titleRow.getCell(index);
                String headerData = titleCell.getStringCellValue();
                headers.add(headerData);
            }
            testDataAllRows = new ArrayList<Map<String, String>>();

            for (int row = 1; row < rowCount; row++) {
                Row rowData = sheet.getRow(row);
                testData = new LinkedHashMap<String, String>();
                for (int column = 0; column < columnCount; column++) {
                    Cell cell = rowData.getCell(column);
                    String data = cell.getStringCellValue();
                    testData.put(headers.get(column), data);
                }
                testDataAllRows.add(testData);
            }
            workbook.close();
        } catch (FileNotFoundException fileNotFoundException) {
            logger.error("File not found Exception occured on excel file read");
        } catch (IOException ioException) {
            logger.error("IO exception occured on excel file read");
        } catch (Exception exception) {
            logger.error("Excel read is not performed");
        }
        return testDataAllRows;
    }


}
