package parser.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import parser.PageObject.DateParserPage;
import parser.Utilities.XLUtils;

public class ParseDate extends BaseClass {
	
	@Test(dataProvider = "Dates")
	public void ParserDD(String dates, String expectedDate) throws IOException, InterruptedException {
		
		DateParserPage dp = new DateParserPage(driver);
		
			dp.setDate(dates);
			dp.clickSubmitButton();
			Thread.sleep(1000);
			String parsedDate = dp.getresultDate().getText();
			
			Assert.assertEquals(parsedDate, expectedDate, "Date is not parsed properly!");
		
	}

	@DataProvider(name = "Dates")
	Object[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\test\\java\\parser\\TestData\\Dates_Data.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		Object dates[][] = new Object[rownum][];

		for (int i = 1; i <= rownum; i++) {
			String dateValue = XLUtils.getCellData(path, "Sheet1", i, 0);
			String expectedDate = XLUtils.getCellData(path, "Sheet1", i, 1);
			dates[i - 1] = new Object[] { dateValue, expectedDate };
		}

		return dates;

	}

}
