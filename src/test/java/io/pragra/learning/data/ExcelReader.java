package io.pragra.learning.data;

import io.pragra.learning.conf.FrameWorkConfig;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {
    private static ExcelReader instance;

    private Workbook workbook;//Represent Excel File

    private ExcelReader() {
        Path path = Paths.get(FrameWorkConfig.getProperty("data.dir"), FrameWorkConfig.getProperty("data.filename"));
        try (InputStream stream = Files.newInputStream(path)) {
            workbook = new XSSFWorkbook(stream);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static List<Object[]> getDataFromSheet(String sheetName, boolean skipHeader){
        List<Object[]> sheetData = new ArrayList<>();
        initializeExcelReader();
        Sheet sheet = instance.workbook.getSheet(sheetName);
        getDataFromSheet(skipHeader, sheetData, sheet);

        return sheetData;
    }
    public static List<Object[]> getDataFromSheet(int index,boolean skipHeader){
        List<Object[]> sheetData = new ArrayList<>();
        initializeExcelReader();
        Sheet sheet = instance.workbook.getSheetAt(index);
        getDataFromSheet(skipHeader, sheetData, sheet);
        return sheetData;
    }

    private static void getDataFromSheet(boolean skipHeader, List<Object[]> sheetData, Sheet sheet) {
        Iterator<Row> rowIterator = sheet.rowIterator();
        if(skipHeader && rowIterator.hasNext()) rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            List<Object> cellData = new ArrayList<>();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if( cell.getCellType()== CellType.STRING){
                    cellData.add( cell.getStringCellValue()  );
                }
                if( cell.getCellType()== CellType.BOOLEAN){
                    cellData.add( cell.getBooleanCellValue()  );
                }
                if( cell.getCellType()== CellType.NUMERIC){
                    cellData.add( cell.getNumericCellValue()  );
                }

            }
            sheetData.add(cellData.toArray());
        }
    }

    private static void initializeExcelReader() {
        if(instance==null) {
           synchronized (ExcelReader.class){
               instance = new ExcelReader();
           }
        }
    }


}
