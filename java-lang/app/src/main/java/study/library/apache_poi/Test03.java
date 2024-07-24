
//APACHE POI 라이브러리 사용법 - 엑셀 workbook + sheet 만들
package study.library.apache_poi;

import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test03 {
  public static void main(String[] args) throws Exception{

    XSSFWorkbook workbook = new XSSFWorkbook();
    workbook.createSheet("users");

    try (FileOutputStream out = new FileOutputStream("temp/test.xlsx")) {
      workbook.write(out);
    }

    System.out.println("엑셀 파일 생성 완료!");
  }

}
