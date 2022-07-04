package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        String fileWay = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(fileWay);
        Workbook workbook = WorkbookFactory.create(fis);
      int lastSatir=  workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(lastSatir);
        String satirdakiData="";
        for (int i = 0; i <=lastSatir ; i++) {
           satirdakiData=C03_ReadExcel.getMeDate(i,1);
            System.out.println(satirdakiData);
        }
    }
}
