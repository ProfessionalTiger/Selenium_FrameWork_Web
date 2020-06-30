package parser.Utilities;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
	
		wb.close();
		fi.close();
		return rowcount;

	}

	public static int getcellCount(String xlfile, String xlsheet, int rownumber) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownumber);
		int cellcount = row.getLastCellNum();
		
		wb.close();
		fi.close();
		return cellcount;

	}

	public static String getCellData(String xlfile, String xlsheet, int rownumber, int column) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownumber);
		cell = row.getCell(column);

		String data;
		try {
			DataFormatter dataformatter = new DataFormatter();
			String celldata = dataformatter.formatCellValue(cell);
			return celldata;
		} catch (Exception e) {
			data = "";
		}

		wb.close();
		fi.close();

		return data;
	}

	public static void setCellData(String xlfile, String xlsheet, int rownumber, int column, String data)
			throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownumber);
		cell = row.getCell(column);
		cell.setCellValue(data);

		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}

}
