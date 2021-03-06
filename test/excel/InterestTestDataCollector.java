package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class InterestTestDataCollector {
    public static final int DATA_STT = 0;
    public static final int DATA_ACCOUNTNUMBER = 1;
    public static final int DATA_CASH = 2;
    public static final int DATA_INTERESTRATE = 3;
    public static final int DATA_TERM = 4;
    public static final int DATA_STARTDATE = 5;
    public static final int DATA_ENDATE = 6;
    public static final int DATA_EXPRESULT = 7;
    public static final int DATA_RESULT = 8;
    public static final int DATA_PASS = 9;
    public static final int DATA_NOTE = 10;


    public InterestTestDataCollector() {
    }


    public Map<Integer, String> getData(int rowNum) {
        DataFormatter dataFormatter = new DataFormatter();
        Map<Integer, String> result = new HashMap<>();
        try {
            XSSFWorkbook workbook = (XSSFWorkbook) XSSFWorkbookFactory.create(new File("./testcase/InterestTestData.xlsx"));
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            Row row = sheet.getRow(rowNum);
            result.put(DATA_STT, dataFormatter.formatCellValue(row.getCell(DATA_STT)));
            result.put(DATA_ACCOUNTNUMBER, dataFormatter.formatCellValue(row.getCell(DATA_ACCOUNTNUMBER)));
            result.put(DATA_CASH, dataFormatter.formatCellValue(row.getCell(DATA_CASH)));
            result.put(DATA_INTERESTRATE, dataFormatter.formatCellValue(row.getCell(DATA_INTERESTRATE)));
            result.put(DATA_TERM, dataFormatter.formatCellValue(row.getCell(DATA_TERM)));
            result.put(DATA_STARTDATE, dataFormatter.formatCellValue(row.getCell(DATA_STARTDATE)));

            result.put(DATA_ENDATE, dataFormatter.formatCellValue(row.getCell(DATA_ENDATE)));
            result.put(DATA_EXPRESULT, dataFormatter.formatCellValue(row.getCell(DATA_EXPRESULT)));
            result.put(DATA_RESULT, dataFormatter.formatCellValue(row.getCell(DATA_RESULT)));
            result.put(DATA_PASS, dataFormatter.formatCellValue(row.getCell(DATA_PASS)));
            result.put(DATA_NOTE, dataFormatter.formatCellValue(row.getCell(DATA_NOTE)));

            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addResult(int rowNum, double result, String pass) {
        try {
            File fileIn = new File("./testcase/InterestTestData.xlsx");
            File fileOut = new File("./testcase/InterestTestDataResult.xlsx");
            if (fileOut.exists()) {
                fileIn = fileOut;
            }
            FileInputStream fis = new FileInputStream(fileIn);
//            XSSFWorkbook workbook = (XSSFWorkbook) XSSFWorkbookFactory.create(fileIn);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            fis.close();
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            Row row = sheet.getRow(rowNum);
            Cell resultCell = row.createCell(DATA_RESULT);
            Cell passCell = row.createCell(DATA_PASS);
            resultCell.setCellValue(result);
            passCell.setCellValue(pass);
            FileOutputStream out = new FileOutputStream(fileOut);
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
