package generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excellibrary implements Autoconstant
{
  public static String Excelfetchdata(String path,String sheet,int row,int cell) throws IOException
  {
	  FileInputStream f=new FileInputStream(excelfilepath);
	  XSSFWorkbook store=new XSSFWorkbook(f);
	  String p=store.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	return p;
  }
  
  
}
