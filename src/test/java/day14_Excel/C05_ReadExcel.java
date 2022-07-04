package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        String fileWay = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(fileWay);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirIndex=workbook.getSheet("Sayfa2").getLastRowNum();
        int expectedSayisi=24;
        Assert.assertEquals(expectedSayisi,sonSatirIndex+1);
        int kullanilanSatirSayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        int expectedKullanilanSatirSayisi=18;
        Assert.assertEquals(expectedKullanilanSatirSayisi,kullanilanSatirSayisi);
    }
}
