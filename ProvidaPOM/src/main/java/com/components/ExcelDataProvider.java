package com.components;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class ExcelDataProvider {
	
    private final String dataPath;
    private List<HashMap<String, String>> totalData;
    private List<String> headerList;
    private int currentRow;

    public String getParameter(int row, String param) {
        return totalData.get(row).get(param);
    }

    public String getParameter(String param) {
        return totalData.get(currentRow).get(param);
    }

    public void saveParameter(int row, String param, String value) {
        totalData.get(row).put(param, value);
    }

    public void saveParameter(String param, String value) {
        this.saveParameter(this.currentRow, param, value);
    }


    public int getRow() {
        return this.currentRow;
    }

    public void setRow(int numRow) {
        if(numRow >= 0 && numRow < totalData.size()) {
            this.currentRow = numRow;
        }
    }

    public void saveToExcel(String filePath) throws IOException {
        //crea el archivo excel con este nombre.
        //crea el archivo excel con este nombre.
//        FileInputStream fis = new FileInputStream(new File(filePath));
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("data");
        Row headersRow = sheet.createRow(0);
        for(int i = 0; i < headerList.size(); i++) {
            headersRow.createCell(i).setCellValue(headerList.get(i));
        }
        for(int i = 0; i < totalData.size(); i++) {
            Row nextRow = sheet.createRow(i + 1);
            for(int j = 0; j < headerList.size(); j++) {
                nextRow.createCell(j).setCellValue(totalData.get(i).get(headerList.get(j)));
            }
        }

        OutputStream fileOut = new FileOutputStream(filePath);
        wb.write(fileOut);
        fileOut.close();

    }

    public void saveToExcel() throws IOException {
        this.saveToExcel(this.dataPath);
    }

    public ExcelDataProvider(String dataPath) throws IOException {
        currentRow = 0;
        this.dataPath = dataPath;

        FileInputStream fis = new FileInputStream(new File(dataPath));
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        Row headerRow = sheet.getRow(0);
        headerList = new ArrayList<String>();
        totalData = new ArrayList<HashMap<String, String>>();
        for(Cell c: headerRow) {
            headerList.add(c.getStringCellValue());
        }
        System.out.println(headerList.size());
        int numRows = sheet.getLastRowNum();
        for(int i = 1; i <= numRows; i++ ) {
            Row r = sheet.getRow(i);
            HashMap<String, String> currentMap = new HashMap<String, String>();
            for(int j = 0; j < headerList.size(); j++) {
                Cell c = r.getCell(j);
                String currentValue = "";
                CellType ct = null;
                if(c != null) {
                    ct = formulaEvaluator.evaluateInCell(c).getCellType();
                    if (ct == CellType.NUMERIC) {
                        currentValue = c.getNumericCellValue() + "";
                    } else if (ct == CellType.STRING) {
                        currentValue = c.getStringCellValue();
                    } else if (ct == null) {

                    }
                }
                currentMap.put(headerList.get(j), currentValue);
            }
            totalData.add(currentMap);

        }

    }

    public int getNumRows() {

        return this.totalData.size();
    }
}