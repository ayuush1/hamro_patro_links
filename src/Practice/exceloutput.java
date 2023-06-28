package Practice;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;


public class exceloutput {

        private Workbook workbook;
        private Sheet sheet;
        private int rowNumber;

        public exceloutput() {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Links");
            rowNumber = 0;
        }

        public void addLink(String url, int responseCode, String description) {
            Row row = sheet.createRow(rowNumber++);
            Cell urlCell = row.createCell(0);
            Cell statusCell = row.createCell(1);
            Cell descriptionCell = row.createCell(2);

            urlCell.setCellValue(url);
            statusCell.setCellValue(responseCode);
            descriptionCell.setCellValue(description);
        }

        public void saveToFile(String filePath) throws IOException {
            FileOutputStream outputFile = new FileOutputStream(filePath);
            workbook.write(outputFile);
            outputFile.close();
        }
    }


