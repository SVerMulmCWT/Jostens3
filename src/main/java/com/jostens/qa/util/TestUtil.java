package com.jostens.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.DataProvider;

public class TestUtil {
	
	//Initialize Variable(s)
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	//Location of the Excel File
	private static String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\jostens\\qa\\testdata\\Jostens.xlsx";
	public static String sheetName = "";
	
	/*
	 * This method takes a screenshot of the entire web browser
	 * 
	 * This method is used in the @AfterMethod method in the 'LoginPageTest.java' class (underneath the 'src/test/java' folder & 'com.jostens.qa.testcases' package)
	 */
	public static String getScreenshot(EventFiringWebDriver eDriver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) eDriver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		//FileUtils.copyFile(source, finalDestination);
		FileHandler.copy(source, finalDestination);
		return destination;
	}
	
	/*
	 * This method is used when the xpath of a WebElement cannot be pre-determined
	 *    (aka. Either the WebElement has a changing xpath, or a different WebElement may need to be referenced, depending on the test)
	 * This method can be called by using...
	 *    .createXPath("//a[contains(text(), \"{0}\")]", varName0);
	 *    .createXPath("//a[contains(text(), \"{0}\") and @name=\"{1}\"]", varName0, varName1);
	 *    .createXPath("//a[contains(text(), \"{0}\") and @name=\"{1}\"] and @type=\"{2}\"]", varName0, varName1, varName2);
	 *    etc..., where varName0 will replace {0}, varName1 will replace {1}, varName2 will replace {2}, etc.
	 *    Calling this method will work with any number of varName# entries, as long as there are {#} to coincide with them
	 * 
	 * This method is used in the 'selectProduct' method in the 'SchoolStorePage.java' class (underneath the 'src/main/java' folder & 'com.jostens.qa.pages' package)
	 */
	public String createXPath(String xpathExp, Object ...args) {
		
		for (int i = 0; i < args.length; i++) {
			xpathExp = xpathExp.replace("{" + i + "}", (CharSequence) args[i]);
		}
		
		return xpathExp;
	}
	
	public String stateAbbreviation(String state) {
		//Initialize Variable(s)
		String stateAbb = "";
		state = state.toLowerCase();
		
		switch(state) {
			case "alabama":
				stateAbb = "AL";
				break;
			case "alaska":
				stateAbb = "AK";
				break;
			case "arizona":
				stateAbb = "AZ";
				break;
			case "arkansas":
				stateAbb = "AR";
				break;
			case "california":
				stateAbb = "CA";
				break;
			case "colorado":
				stateAbb = "CO";
				break;
			case "connecticut":
				stateAbb = "CT";
				break;
			case "delaware":
				stateAbb = "DE";
				break;
			case "florida":
				stateAbb = "FL";
				break;
			case "georgia":
				stateAbb = "GA";
				break;
			case "hawaii":
				stateAbb = "HI";
				break;
			case "idaho":
				stateAbb = "ID";
				break;
			case "illinois":
				stateAbb = "IL";
				break;
			case "indiana":
				stateAbb = "IN";
				break;
			case "iowa":
				stateAbb = "IA";
				break;
			case "kansas":
				stateAbb = "KS";
				break;
			case "kentucky":
				stateAbb = "KY";
				break;
			case "louisiana":
				stateAbb = "LA";
				break;
			case "maine":
				stateAbb = "ME";
				break;
			case "maryland":
				stateAbb = "MD";
				break;
			case "massachusetts":
				stateAbb = "MA";
				break;
			case "michigan":
				stateAbb = "MI";
				break;
			case "minnesota":
				stateAbb = "MN";
				break;
			case "mississippi":
				stateAbb = "MS";
				break;
			case "missouri":
				stateAbb = "MO";
				break;
			case "montana":
				stateAbb = "MT";
				break;
			case "nebraska":
				stateAbb = "NE";
				break;
			case "nevada":
				stateAbb = "NV";
				break;
			case "new hampshire":
				stateAbb = "NH";
				break;
			case "new jersey":
				stateAbb = "NJ";
				break;
			case "new mexico":
				stateAbb = "NM";
				break;
			case "new york":
				stateAbb = "NY";
				break;
			case "north carolina":
				stateAbb = "NC";
				break;
			case "north dakota":
				stateAbb = "ND";
				break;
			case "ohio":
				stateAbb = "OH";
				break;
			case "oklahoma":
				stateAbb = "OK";
				break;
			case "oregon":
				stateAbb = "OR";
				break;
			case "pennsylvania":
				stateAbb = "PA";
				break;
			case "rhode island":
				stateAbb = "RI";
				break;
			case "south carolina":
				stateAbb = "SC";
				break;
			case "south dakota":
				stateAbb = "SD";
				break;
			case "tennessee":
				stateAbb = "TN";
				break;
			case "texas":
				stateAbb = "TX";
				break;
			case "utah":
				stateAbb = "UT";
				break;
			case "vermont":
				stateAbb = "VT";
				break;
			case "virginia":
				stateAbb = "VA";
				break;
			case "washington":
				stateAbb = "WA";
				break;
			case "west virginia":
				stateAbb = "WV";
				break;
			case "wisconsin":
				stateAbb = "WI";
				break;
			case "wyoming":
				stateAbb = "WY";
				break;
		}
		
		return stateAbb;
	}
	
	public void setSheetName(String desiredSheetName) {
		sheetName = desiredSheetName;
	}
	
	//Method returns the current time when called
	public String getCurrentDateTime() {
		//Get the current time - will be used to indicate when the test finished for the Excel File output
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
		LocalDateTime currentDateTime = LocalDateTime.now();
		String currentDateTimeStr = dateTimeFormat.format(currentDateTime);
		
		return currentDateTimeStr;
	}
	
	//Retrieve a single row of a DataSheet - each row of a DataSheet is iterated through by another method in this java class before sending off the DataSheet to the active script
	public static String[] retrieveRow(XSSFRow row, int numCols) {
		//Initialize Variable(s)
		String[] importRow = new String[numCols];
		XSSFCell cell;
		
		for (int i = 0; i < row.getLastCellNum(); i++) {
			//Set the values for Variable(s)
			cell = row.getCell(i);
			
			//If a cell has no value, create a cell & specify it as blank, then add that cell
			if(cell != null) {
				importRow[i] = cell.toString();
			} else {
				row.createCell(i);
				importRow[i] = row.getCell(i).toString();
			}
		}
		
		importRow[numCols-1] = "0";
		
		return importRow;
	}
	
	//Retrieve an Excel DataSheet for automation testing
	@DataProvider(name="inputs")
	public String[][] getDataTable() {
		
		//Initialise Variable(s)
		String[][] importDataTable = null;
		System.out.println(path + " - " + sheetName);
		try {
			//Open the Excel File
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			
			//System.out.println(path + " - " + sheetName + " - " + ExcelWSheet.getPhysicalNumberOfRows());
			
			int numRows = ExcelWSheet.getPhysicalNumberOfRows() - 1;
			int numCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells() + 1;
			
			importDataTable = new String[numRows][numCols];
			
			//Setup an 2D ArrayList to use as Parameters
			for (int i = 1; i < ExcelWSheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = ExcelWSheet.getRow(i);
				importDataTable[i-1] = retrieveRow(row, numCols);
			}
			
			for (int i = 0; i < importDataTable.length; i++) {
				importDataTable[i][numCols-1] = String.valueOf(i+1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return importDataTable;
	}

	public String getDataTableCell(int rowNum, int colNum) {
		//Initialize Variable(s)
		String cellValue = "";
		
		try {
			//Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(path);
			
			//Access the Excel DataSheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			
			Row = ExcelWSheet.getRow(rowNum);
			Cell = Row.getCell(colNum);
			
			if (Cell == null) {
				cellValue = "";
			} else {
				cellValue = Cell.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cellValue;
	}

	//Send output to a specific DataSheet cell
	public void setDataTableCell(String result, int rowNum, int colNum) {
		//Initialize Variable(s)
		colNum = colNum - 1; //Reduce the colNum by 1, since the ExcelSheet starts with 0. (no need to do this with rowNum, since the rows have row #0 dedicated to column titles)
		
		try {
			//Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(path);
			
			//Access the Excel DataSheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			
			Row = ExcelWSheet.getRow(rowNum);
			Cell = Row.getCell(colNum);
			
			if (Cell == null) {
				Cell = Row.createCell(colNum);
				Cell.setCellValue(result);
			} else {
				Cell.setCellValue(result);
			}
			
			//Open the file to write the results
			FileOutputStream outputFile = new FileOutputStream(path);
			
			ExcelWBook.write(outputFile);
			outputFile.flush();
			outputFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Send output to a specific DataSheet cell
	public void setDataTableCell(Double result, int rowNum, int colNum) throws Exception {
		try {
			//Ouput to the Excel File
			Row = ExcelWSheet.getRow(rowNum);
			Cell = Row.getCell(colNum);
			
			if (Cell == null) {
				Cell = Row.createCell(colNum);
				Cell.setCellValue(result);
			} else {
				Cell.setCellValue(result);
			}
			
			//Open the file to write the results
			FileOutputStream outputFile = new FileOutputStream(path);
			
			ExcelWBook.write(outputFile);
			outputFile.flush();
			outputFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getScreenshot(WebDriver eDriver, String screenshotName) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) eDriver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		//FileUtils.copyFile(source, finalDestination);
		
		try {
			FileHandler.copy(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destination;
	}
	
	//~~~~~~ ~~~~~~ Additional Methods ~~~~~~ ~~~~~~//
	
	public int getRowCount(String specifySheetName) {
		
		//Initialize Variable(s)
		int index = ExcelWBook.getSheetIndex(specifySheetName);
		
		//Return the row count of the specified sheet name (if the sheet name does not exist, return zero)
		if (index == -1) {
			return 0;
		} else {
			ExcelWSheet = ExcelWBook.getSheetAt(index);
			int number = ExcelWSheet.getLastRowNum() + 1;
			return number;
		}
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public String getCellData(String specifySheetName, String colName, int rowNum) {
		
		try {
			//If the row is 0 or below, return an empty string, since the row value is invalid
			if (rowNum <= 0) {
				return "";
			}
			
			//Initialize Variable(s)
			int index = ExcelWBook.getSheetIndex(specifySheetName);
			int colNum = -1;
			
			//If the index is pointing to an invalid sheet reference return an empty string
			if (index == -1) {
				return "";
			}
			
			//Open the relevant WorkSheet & read the first row (to find the relevant Header/Column name)
			ExcelWSheet = ExcelWBook.getSheetAt(index);
			Row = ExcelWSheet.getRow(0);
			
			//Iterate through the first row & locate the relevant Header/Column name
			for (int i = 0; i < Row.getLastCellNum(); i++) {
				if (Row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
					colNum = i;
				}
			}
			
			//If the colNum is invalid, return an empty string
			if (colNum == 1) {
				return "";
			}
			
			//Retrieve the specified row
			ExcelWSheet = ExcelWBook.getSheetAt(index);
			Row = ExcelWSheet.getRow(rowNum - 1);
			
			//If the row has no valid value(s), return an empty string
			if (Row == null) {
				return "";
			}
			
			//Retrieve the specified cell
			Cell = Row.getCell(colNum);
			
			//If the cell has no valid value(s), return an empty string
			if (Cell == null) {
				return "";
			}
			
			//Return the value of the cell, if it is a string
			if (Cell.getCellType().name().equals("STRING")) {
				return Cell.getStringCellValue();
			} else if (Cell.getCellType().name().equals("NUMERIC") || Cell.getCellType().name().equals("FORMULA")) {
				String cellText = String.valueOf(Cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(Cell)) {
					//format in form of M/D/YY
					double d = Cell.getNumericCellValue();
					
					Calendar calender = Calendar.getInstance();
					calender.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(calender.get(Calendar.YEAR))).substring(2);
					cellText = calender.get(Calendar.DAY_OF_MONTH) + "/" + calender.get(Calendar.MONTH) + 1 + "/" + cellText;
				}
				
				//Return the numeric or date value of the cell data
				return cellText;
			} else if (Cell.getCellType().BLANK != null) {
				return "";
			} else {
				return String.valueOf(Cell.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "row '" + rowNum + "' or column '" + colName + "' does not exist in the Excel File";
		}
	}
	
	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = ExcelWBook.getSheetIndex(sheetName);

			if (index == -1)
				return "";

			ExcelWSheet = ExcelWBook.getSheetAt(index);
			Row = ExcelWSheet.getRow(rowNum - 1);
			if (Row == null)
				return "";
			Cell = Row.getCell(colNum);
			if (Cell == null)
				return "";

			//
			if (Cell.getCellType().name().equals("STRING"))
				return Cell.getStringCellValue();

			//
			// if (cell.getCellType().STRING != null)
			// return cell.getStringCellValue();
			else if ((Cell.getCellType().name().equals("NUMERIC")) || (Cell.getCellType().name().equals("FORMULA"))) {

				String cellText = String.valueOf(Cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(Cell)) {
					// format in form of M/D/YY
					double d = Cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;

					// System.out.println(cellText);

				}

				return cellText;
			} else if (Cell.getCellType().BLANK != null)
				return "";
			else
				return String.valueOf(Cell.getBooleanCellValue());
		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}
	
	// returns true if data is set successfully else false
	public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
		try {
			fis = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(fis);

			if (rowNum <= 0)
				return false;

			int index = ExcelWBook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			ExcelWSheet = ExcelWBook.getSheetAt(index);

			Row = ExcelWSheet.getRow(0);
			for (int i = 0; i < Row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (Row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;

			ExcelWSheet.autoSizeColumn(colNum);
			Row = ExcelWSheet.getRow(rowNum - 1);
			if (Row == null)
				Row = ExcelWSheet.createRow(rowNum - 1);

			Cell = Row.getCell(colNum);
			if (Cell == null)
				Cell = Row.createCell(colNum);

			// cell style
			// CellStyle cs = workbook.createCellStyle();
			// cs.setWrapText(true);
			// cell.setCellStyle(cs);
			Cell.setCellValue(data);

			fileOut = new FileOutputStream(path);

			ExcelWBook.write(fileOut);

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// returns true if sheet is created successfully else false
	public boolean addSheet(String sheetname) {

		FileOutputStream fileOut;
		try {
			ExcelWBook.createSheet(sheetname);
			fileOut = new FileOutputStream(path);
			ExcelWBook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// returns true if sheet is removed successfully else false if sheet does not exist
	public boolean removeSheet(String sheetName) {
		int index = ExcelWBook.getSheetIndex(sheetName);
		if (index == -1)
			return false;

		FileOutputStream fileOut;
		try {
			ExcelWBook.removeSheetAt(index);
			fileOut = new FileOutputStream(path);
			ExcelWBook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	// returns true if column is created successfully
	public boolean addColumn(String sheetName, String colName) {
		// System.out.println("**************addColumn*********************");

		try {
			fis = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(fis);
			int index = ExcelWBook.getSheetIndex(sheetName);
			if (index == -1)
				return false;

			XSSFCellStyle style = ExcelWBook.createCellStyle();
			// style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			// style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

			ExcelWSheet = ExcelWBook.getSheetAt(index);

			Row = ExcelWSheet.getRow(0);
			if (Row == null)
				Row = ExcelWSheet.createRow(0);

			// cell = row.getCell();
			// if (cell == null)
			// System.out.println(row.getLastCellNum());
			if (Row.getLastCellNum() == -1)
				Cell = Row.createCell(0);
			else
				Cell = Row.createCell(Row.getLastCellNum());

			Cell.setCellValue(colName);
			Cell.setCellStyle(style);

			fileOut = new FileOutputStream(path);
			ExcelWBook.write(fileOut);
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	// removes a column and all the contents
	@SuppressWarnings("unused")
	public boolean removeColumn(String sheetName, int colNum) {
		try {
			if (!isSheetExist(sheetName))
				return false;
			fis = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(fis);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			XSSFCellStyle style = ExcelWBook.createCellStyle();
			// style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			XSSFCreationHelper createHelper = ExcelWBook.getCreationHelper();
			// style.setFillPattern(XSSFCellStyle.NO_FILL);
			for (int i = 0; i < getRowCount(sheetName); i++) {
				Row = ExcelWSheet.getRow(i);
				if (Row != null) {
					Cell = Row.getCell(colNum);
					if (Cell != null) {
						Cell.setCellStyle(style);
						Row.removeCell(Cell);
					}
				}
			}
			fileOut = new FileOutputStream(path);
			ExcelWBook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
	// find whether sheets exists
	public boolean isSheetExist(String sheetName) {
		int index = ExcelWBook.getSheetIndex(sheetName);
		if (index == -1) {
			index = ExcelWBook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}
	
	// returns number of columns in a sheet
	public int getColumnCount(String sheetName) {
		// check if sheet exists
		if (!isSheetExist(sheetName))
			return -1;

		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		Row = ExcelWSheet.getRow(0);

		if (Row == null)
			return -1;

		return Row.getLastCellNum();
	}
	
	public int getCellRowNum(String sheetName, String colName, String cellValue) {
		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		
		return -1;
	}
}