
//APACHE POI 사용- 엑셀 workbook + sheet 만들
package study.library.apache_poi;

import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test02 {
  public static void main(String[] args) throws Exception{

    XSSFWorkbook workbook = new XSSFWorkbook();

    try (FileOutputStream out = new FileOutputStream("temp/test.xlsx")) {
      workbook.write(out);
    }

    System.out.println("엑셀 파일 생성 완료!");
  }

}
