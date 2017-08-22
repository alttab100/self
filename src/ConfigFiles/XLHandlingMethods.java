package ConfigFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.NumberToTextConverter;

public class XLHandlingMethods {
	
	private static HSSFWorkbook HWB;
	private static HSSFSheet HWS;
	private static HSSFRow row;
	private static HSSFCell col;
	public static int rowcount;
	public static int colcount;
	private static String CellValue;
	
	//File Path Setting
	
	public static void setfilepath(String Filepath, String SheetName) throws IOException
	{
		try
		{
			FileInputStream FIS=new FileInputStream(Filepath);
			HWB=new HSSFWorkbook(FIS);
			HWS=HWB.getSheet(SheetName);
		}
		catch(Exception e)
		{
			System.out.println("File Exceptions : "+e);
		}
	}
	
	//Counting Row in Excel Sheet
	public static int rowcount()
	{
		rowcount=HWS.getLastRowNum();
		System.out.println("Rows Available in Excel Sheet : "+rowcount);
		return rowcount;
	}
	
	//Counting Column in Excel Sheet
	public static void colcount(int rowindex)
	{
		colcount=HWS.getRow(rowindex).getPhysicalNumberOfCells();
		System.out.println("Columns available for "+rowindex+" row is : "+colcount);
	}

	//Read Data From Excel File
	@SuppressWarnings("deprecation")
	public static String readdata(int rowindex, int cellindex)
	{
		try
		{
			row=HWS.getRow(rowindex);
			col=row.getCell(cellindex);							
			if(col.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				CellValue= NumberToTextConverter.toText(col.getNumericCellValue());
			}else if(col.getCellType() == Cell.CELL_TYPE_STRING)
			{
				CellValue=col.getStringCellValue();
			}
			return CellValue;
		}
		catch(Exception e)
		{
			System.out.println("Data Reading Exceptions : "+e);
			return "";
		}
	}
	
	//Write Data to excel sheet
	
	@SuppressWarnings("deprecation")
	public static void writedata(String TestResults, String FilePath,int rowindex, int cellindex)
	{
		try
		{
			row=HWS.getRow(rowindex);
			col=row.createCell(cellindex);
			col.setCellValue(Cell.CELL_TYPE_STRING);
			col.setCellValue(TestResults);
			FileOutputStream FOS=new FileOutputStream(FilePath);
			HWB.write(FOS);
			FOS.close();
		}
		catch(Exception e)
		{
			System.out.println("Updating Test Results in Excell Sheet : "+e);
		}
	}
}
