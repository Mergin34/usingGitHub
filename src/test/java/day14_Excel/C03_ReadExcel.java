package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        int satirNo = 12;
        int sutunNo = 2;
        String expectedData = "Baku";
        String actualData = getMeDate(satirNo - 1, sutunNo - 1);
        Assert.assertEquals(expectedData,actualData);
    }

    public static String getMeDate(int satirIndex, int sutunIndex) throws IOException {
        String istenenData = "";
        String fileWay="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(fileWay);
        Workbook workbook= WorkbookFactory.create(fis);
        istenenData=workbook.getSheet("Sayfa1").getRow(satirIndex).getCell(sutunIndex).toString();


        return istenenData;
    }

}
