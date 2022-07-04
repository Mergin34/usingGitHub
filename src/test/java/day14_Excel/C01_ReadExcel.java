package day14_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        String fileWay = "src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(fileWay);
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sheet=workbook.getSheet("Sayfa1");
        Row row=sheet.getRow(3);
        Cell cell=row.getCell(3);
        System.out.println(cell);
    }
}
