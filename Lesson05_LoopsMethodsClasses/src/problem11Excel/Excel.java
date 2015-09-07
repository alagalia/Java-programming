package problem11Excel;
/*
You are given an Excel file Incomes-Report.xlsx holding an incomes report.
Your task is to read the report and to calculate the incomes sub-totals for each office (with VAT).
Order the offices alphabetically. Print the result at the console in format town Total -> incomes.
Finally calculate and print the grand total (the sum of all incomes in all offices).
 */
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Excel {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ROOT);
        InputStream excelFile= new FileInputStream("Incomes-Report.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = workbook.getSheetAt(0);
        TreeMap<String, Double> officeNameIncome = new TreeMap<>();

        Iterator<Row> rowIterator = sheet.rowIterator(); //RowIterator
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            if(row.getRowNum()!=0){
                String currentOfficeName = row.getCell(0).getStringCellValue();
                Double currentIncome = row.getCell(5).getNumericCellValue();

                if(officeNameIncome.containsKey(currentOfficeName)){
                    Double existingIncome = officeNameIncome.get(currentOfficeName);
                    officeNameIncome.put(currentOfficeName, existingIncome + currentIncome);
                }
                else {
                    officeNameIncome.put(currentOfficeName,currentIncome);
                }
            }
        }
        for(String key: officeNameIncome.keySet())
        System.out.printf(key + " Total: -> %.2f", officeNameIncome.get(key)).println();
        Double total = 0d;
        for (Double income : officeNameIncome.values()) {
            total+=income;
        }
        System.out.printf("Grand Total -> %.2f", total);


    }
}
