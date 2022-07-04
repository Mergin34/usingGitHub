package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        Map<String, String> ulkelerMap = new HashMap<>();
        String fileWay = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(fileWay);
        Workbook workbook = WorkbookFactory.create(fis);
        int lastSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <= lastSatirIndex; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + "," +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + "," +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);

        }
        System.out.println(ulkelerMap);
        Assert.assertTrue(ulkelerMap.keySet().contains("Ghana"));
    }
}
