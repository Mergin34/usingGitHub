package day14_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        String fileWay = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(fileWay);
        Workbook workbook= WorkbookFactory.create(fis);
        String actualData=workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString();

    }
}
