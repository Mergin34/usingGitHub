package day15_writeExcel_screenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {
    @Test
    public void writeExcelTest() throws IOException {
        String fileWay="src/resources/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(fileWay);
        Workbook workbook= WorkbookFactory.create(fis);
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(1500000);
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue(250000);
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue(540000);
        FileOutputStream fos =new FileOutputStream(fileWay);
        workbook.write(fos);
        fis.close();
        fos.close();
    }
}
