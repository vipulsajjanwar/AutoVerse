package nexgen.automation.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import nexgen.automation.framework.util.XLUtils;
import nexgen.automation.framework.constant.Constant;
import nexgen.automation.framework.constant.ExecutionResult;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	static final Logger log = Logger.getLogger(XLUtils.class);

	public void setExcelWBook(InputStream excelFile) {
        try {
            wb = new XSSFWorkbook(excelFile);
        } catch (IOException e) {
            log.error("Error setting the Excel workbook: " + e.getMessage(), e);
        }
    }

	public int getRowCount(String xlfile, String xlsheet) {
	    int rowCount = 0;
	    try (FileInputStream fis = new FileInputStream(xlfile);
	    		XSSFWorkbook wbs = new XSSFWorkbook(fis)) {

	        ZipSecureFile.setMinInflateRatio(0);
	        XSSFSheet wss = wbs.getSheet(xlsheet);

	        if (wss != null) {
	            rowCount = wss.getLastRowNum();
	        } else {
	            log.warn("Sheet not found: {}" + xlsheet);
	        }

	    } catch (FileNotFoundException e) {
	        log.error("Excel file not found: {}"+ xlfile, e);
	    } catch (IOException e) {
	        log.error("Error reading Excel file: {}"+ xlfile, e);
	    }

	    return rowCount;
	}

    public int getCellCount(String xlfile, String xlsheet, int rownum) {
        int cellcount = 0;
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(xlfile);
            wb = new XSSFWorkbook(fi);
            ws = wb.getSheet(xlsheet);
            row = ws.getRow(rownum);
            if (row != null) {
                cellcount = row.getLastCellNum();
            }
        } catch (FileNotFoundException e) {
            log.error("Excel file not found: " + xlfile, e);
        } catch (IOException e) {
            log.error("Error reading Excel file: " + e.getMessage(), e);
        } finally {
            try {
                if (wb != null) wb.close();
                if (fi != null) fi.close();
            } catch (IOException e) {
                log.error("Error closing Excel resources: " + e.getMessage(), e);
            }
        }
        return cellcount;
    }

    public String getCellData(String xlfile, String xlsheet, int rownum, int colnum) {
        String data = null;
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(xlfile);
            wb = new XSSFWorkbook(fi);
            ws = wb.getSheet(xlsheet);
            row = ws.getRow(rownum);
            if (row != null) {
                cell = row.getCell(colnum);
                if (cell != null) {
                    DataFormatter formatter = new DataFormatter();
                    data = formatter.formatCellValue(cell);
                }
            }
        } catch (FileNotFoundException e) {
            log.error("Excel file not found: " + xlfile, e);
        } catch (IOException e) {
            log.error("Error reading Excel file: " + e.getMessage(), e);
        } catch (Exception e) {
            log.error("Error getting cell data: " + e.getMessage(), e);
        } finally {
            try {
                if (wb != null) wb.close();
                if (fi != null) fi.close();
            } catch (IOException e) {
                log.error("Error closing Excel resources: " + e.getMessage(), e);
            }
        }
        return data;
    }

	public void writeToExcel(String text, String path, int row, int column) {

		XSSFSheet sheet = null;
		try (FileInputStream file = new FileInputStream(new File(path));
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				FileOutputStream outFile = new FileOutputStream(new File(path));) {
			sheet = workbook.getSheetAt(0);
			CellStyle style = null;
			if (text.equals("Pass")) {

				style = workbook.createCellStyle();
				style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				Font font = workbook.createFont();
				font.setColor(IndexedColors.BLACK.getIndex());
				style.setFont(font);

			} else {

				style = workbook.createCellStyle();
				style.setFillForegroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				Font font = workbook.createFont();
				font.setColor(IndexedColors.BLACK.getIndex());
				style.setFont(font);

			}
			// 'Write data to excel'
			sheet.getRow(row).createCell(column).setCellValue(text);
			sheet.getRow(row).getCell(column).setCellStyle(style);

			workbook.write(outFile);

		} catch (IOException e) {
			log.error(e.getMessage());
		}

	}

	public void writeToExcel(String text, String fileName, String sheetName, int rowNumber, String columnName)
			throws IOException {

		String xlSheetName = sheetName;
		String cellData = "";
		String file = fileName;

		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheetName);

		row = ws.getRow(0);

		int cellcount = row.getLastCellNum();

		for (int i = 0; i < cellcount; i++) {

			cell = row.getCell(i);
			DataFormatter formatter = new DataFormatter();
			cellData = formatter.formatCellValue(cell);
			CellStyle style = wb.createCellStyle();
			if (cellData.equalsIgnoreCase(columnName)) {
				row = ws.getRow(rowNumber);
				cell = row.getCell(i);

				if (text.equalsIgnoreCase("Pass")) {

					style = wb.createCellStyle();
					style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
					style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					Font font = wb.createFont();
					font.setColor(IndexedColors.BLACK.getIndex());
					style.setFont(font);

				} else if (text.equalsIgnoreCase("Fail")) {

					style = wb.createCellStyle();
					style.setFillForegroundColor(IndexedColors.RED1.getIndex());
					style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					Font font = wb.createFont();
					font.setColor(IndexedColors.BLACK.getIndex());
					style.setFont(font);

					// 'Write data to excel'
					ws.getRow(rowNumber).createCell(i).setCellValue(text);
					ws.getRow(rowNumber).getCell(i).setCellStyle(style);
				}
				ws.getRow(rowNumber).createCell(i).setCellValue(text);
				ws.getRow(rowNumber).getCell(i).setCellStyle(style);

			}

		}

		FileOutputStream outFile = new FileOutputStream(new File(fileName));
		wb.write(outFile);
		wb.close();
		outFile.close();
		wb.close();

	}

	// Write the data in zephyr report file
	// public void setCellData(String xlfile, String xlsheet, int rownum, int
	// colnum, String data)
	public void setCellData(String xlfile, int rownum, int colnum, String data) {

		try (FileInputStream file = new FileInputStream(new File(xlfile));
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				FileOutputStream outFile = new FileOutputStream(new File(xlfile))) {

			XSSFSheet sheet = workbook.getSheetAt(0);

			if (colnum == 1) {

				sheet.createRow(rownum).createCell(colnum).setCellValue(data);

			} else {

				sheet.getRow(rownum).createCell(colnum).setCellValue(data);

			}
			workbook.write(outFile);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	public void cleanSheet(String xlfile, String xlsheet) throws IOException {
		try (FileInputStream file = new FileInputStream(new File(xlfile));
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				FileOutputStream outFile = new FileOutputStream(new File(xlfile))) {
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rowCount = getRowCount(xlfile, xlsheet);

			for (int rowNum = 0; rowNum < rowCount; rowNum++) {

				int rowNumber = rowNum + 1;

				sheet.removeRow(sheet.getRow(rowNumber));

			}
			workbook.write(outFile);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	public static String createWorkBook() {
		String file = null;

		String timeStamp = new SimpleDateFormat("HH_mm_ss_MM_dd_yyyy").format(new Date());

		File fileName = new File(System.getProperty("user.dir") + Constant.EXCELPATH + "_" + ExecutionResult.suitename
				+ "_" + timeStamp + ".xlsx");
		try (FileOutputStream fos = new FileOutputStream(fileName); XSSFWorkbook workbook = new XSSFWorkbook()) {

			workbook.createSheet("Sheet1");

			workbook.write(fos);
			fos.flush();

			file = fileName.toString();

		} catch (Exception ex) {

			log.error(ex.getMessage());

		}

		return file;

	}

	public String[] readDataFromExcelUsingColumnName(String columnName) {
		String xlSheetName = "Sheet1";
		String cellData = "";
		String userDetails;
		
		userDetails = System.getProperty("user.dir") + Constant.QAINSTANCELOGINDETAILS;
	
		String[] resturDetails = new String[3];
		try {
			fi = new FileInputStream(userDetails);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlSheetName);
			String user = "";
			String pass = "";
			String temppass = "";
			row = ws.getRow(0);

			int cellcount = row.getLastCellNum();

			for (int i = 0; i < cellcount; i++) {

				cell = row.getCell(i);
				DataFormatter formatter = new DataFormatter();
				cellData = formatter.formatCellValue(cell);
				if (cellData.equalsIgnoreCase(columnName)) {
					log.info(cellData);

					row = ws.getRow(1);
					cell = row.getCell(i);
					DataFormatter formatter2 = new DataFormatter();
					user = formatter2.formatCellValue(cell);
					log.info(user);

					row = ws.getRow(2);
					cell = row.getCell(i);
					DataFormatter formatter3 = new DataFormatter();
					pass = formatter3.formatCellValue(cell);
				//	log.info(pass);
					
					row = ws.getRow(3);
					cell = row.getCell(i);
					DataFormatter formatter4 = new DataFormatter();
					temppass = formatter4.formatCellValue(cell);
				//	log.info(pass);
					
					
				}

			}
			resturDetails[0] = user;

			resturDetails[1] = pass;
			
			resturDetails[2] = temppass;

		} catch (Exception ex) {

			log.error(ex.getMessage());
		}
		return resturDetails;
	}
	
	public String[] readDataFromExcelUsingColumnName(String filePath,String columnName) {
		String xlSheetName = "Sheet1";
		String cellData = "";
	
		String[] resturDetails = new String[5];
		try {
			fi = new FileInputStream(filePath);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlSheetName);
		/**	String connectionType = "";*/
			String connectionName = "";
			String schema = "";
			String table = "";
			String connType = "";
			String fileConnectionType = "";
			row = ws.getRow(0);
 
			int cellcount = row.getLastCellNum();
 
			for (int i = 0; i < cellcount; i++) {
 
				cell = row.getCell(i);
				DataFormatter formatter = new DataFormatter();
				cellData = formatter.formatCellValue(cell);
				if (cellData.equalsIgnoreCase(columnName)) {
					log.info(cellData);
 
					row = ws.getRow(1);
					cell = row.getCell(i);
					DataFormatter formatter3 = new DataFormatter();
					connectionName = formatter3.formatCellValue(cell);
					row = ws.getRow(2);
					cell = row.getCell(i);
					DataFormatter formatter4 = new DataFormatter();
					schema = formatter4.formatCellValue(cell);
					row = ws.getRow(3);
					cell = row.getCell(i);
					DataFormatter formatter5 = new DataFormatter();
					table = formatter5.formatCellValue(cell);
					row = ws.getRow(4);
					cell = row.getCell(i);
					DataFormatter formatter6 = new DataFormatter();
					connType = formatter6.formatCellValue(cell);
					row = ws.getRow(5);
					cell = row.getCell(i);
					DataFormatter formatter7 = new DataFormatter();
					fileConnectionType = formatter7.formatCellValue(cell);


				}
 
			}
			resturDetails[0] = connectionName;
 
			resturDetails[1] = schema;
			resturDetails[2] = table;
			resturDetails[3] = connType;
			resturDetails[4] = fileConnectionType;
		} catch (Exception ex) {
 
			log.error(ex.getMessage());
		}
		return resturDetails;
	}

	/*
	 * public String readUsingColName(String fileName, String sheetName, int
	 * rowNumber, String columnName) throws IOException { String xlSheetName =
	 * sheetName; String cellData = ""; String file = fileName;
	 * 
	 * fi = new FileInputStream(file); wb = new XSSFWorkbook(fi); ws =
	 * wb.getSheet(xlSheetName); String value = "";
	 * 
	 * row = ws.getRow(0);
	 * 
	 * int cellcount = row.getLastCellNum();
	 * 
	 * for (int i = 0; i < cellcount; i++) {
	 * 
	 * cell = row.getCell(i); DataFormatter formatter = new DataFormatter();
	 * cellData = formatter.formatCellValue(cell); if
	 * (cellData.equalsIgnoreCase(columnName)) { row = ws.getRow(rowNumber); cell =
	 * row.getCell(i); DataFormatter formatter2 = new DataFormatter(); value =
	 * formatter2.formatCellValue(cell); switch(cell.getCellType()) {
	 * 
	 * case FORMULA: value = cell.getStringCellValue(); break; default:
	 * DataFormatter formatter2 = new DataFormatter(); value =
	 * formatter2.formatCellValue(cell); break; } }
	 * 
	 * }
	 * 
	 * String resturDetails = value;
	 * 
	 * wb.close();
	 * 
	 * return resturDetails;
	 * 
	 * }
	 */

	public String readUsingColName(String fileName, String sheetName, int rowNumber, String columnName)
			throws EncryptedDocumentException, IOException {
		String sheetName1 = sheetName;
		String cellData = "";
		String file = fileName;

		String resturDetails="";
		try {
			fi = new FileInputStream(file);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(sheetName1);
			String value = "";

			row = ws.getRow(0);

			int cellcount = row.getLastCellNum();

			for (int i = 0; i < cellcount; i++) {

				cell = row.getCell(i);
				DataFormatter formatter = new DataFormatter();
				cellData = formatter.formatCellValue(cell);
				if (cellData.equalsIgnoreCase(columnName)) {
					// System.out.println(cellData);
					row = ws.getRow(rowNumber);
					cell = row.getCell(i);
					DataFormatter formatter2 = new DataFormatter();
					value = formatter2.formatCellValue(cell);
					// System.out.println(value);

				}

			}

			resturDetails = value;
			
			
			wb.close();
			
		} catch (Exception e) {
			log.error(e.getMessage());
			
		}finally {
			if(resturDetails==null) {
				resturDetails="";
			}

		}

		return resturDetails;

	}

	public List<String> getDetails(List<String> input, int rowNumber, String sheetName, XLUtils xl, String filepath)
			throws Exception {
		int length = input.size();
		List<String> result = new ArrayList<String>();
		try {
			if (length >= 1) {
				for (int i = 0; i < length; i++) {

					result.add(xl.readUsingColName(filepath, sheetName, rowNumber, input.get(i)));

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// result=loop(length,input,rowNumber, sheetName, xl,filepath);

		return result;
	}
	public String zipFile(String filePath, String extention, String fileLocation) {
		String zipFileName = null;
		try {
			File file = new File(filePath);
			zipFileName = fileLocation+"/"+file.getName().concat(extention);
			FileOutputStream fos = new FileOutputStream(zipFileName);
			ZipOutputStream zos = new ZipOutputStream(fos);
			zos.putNextEntry(new ZipEntry(file.getName()));
			byte[] bytes = Files.readAllBytes(Paths.get(filePath));
			zos.write(bytes, 0, bytes.length);
			zos.closeEntry();
			zos.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
		return zipFileName;

	}
	
	public long getFileSizeNIO(String fileName) {

		Path path = Paths.get(fileName);
		long kilobytes = 0;
		try {
			long bytes = Files.size(path);
			kilobytes = bytes / 1024;
		} catch (IOException e) {
			e.getMessage();
		}
		return kilobytes;

	}
	

	//read column specific table using reference data in another column
	public String readUsingColNameAndCellContains(String fileName, String sheetName, String refcolumnName, String refcellValue, String anotherColumnName) {
        String result = null;
        int foundRow = -1; // Store the row number where cellValue is found
        int anotherColumnIndex = -1; // Store the index of the anotherColumnName
        ZipSecureFile.setMinInflateRatio(0);
        try{
            fi = new FileInputStream(fileName);
            wb = new XSSFWorkbook(fi);
            ws = wb.getSheet(sheetName);

            int columnIndex = -1;
            Row headerRow = ws.getRow(0);

            // Find the column index based on the column name
            for (Cell cell1 : headerRow) {
                if (cell1.getCellType() == CellType.STRING && cell1.getStringCellValue().equalsIgnoreCase(refcolumnName)) {
                    columnIndex = cell1.getColumnIndex();
                   
                    break;
                }  
            }

            // Find the index of the anotherColumnName
            for (Cell cell2 : headerRow) {
                if (cell2.getCellType() == CellType.STRING && cell2.getStringCellValue().equalsIgnoreCase(anotherColumnName)) {
                    anotherColumnIndex = cell2.getColumnIndex();
                   
                    break;
                } 
            }

            if (columnIndex == -1 || anotherColumnIndex == -1) {
                // The specified column names were not found
                return "Column not found";
            }
            DataFormatter dataFormatter = new DataFormatter();
            // Iterate through the rows to find the cell with the specified value and its row number
            for (int rowNum = 0; rowNum <= ws.getLastRowNum(); rowNum++) {
                Row row2 = ws.getRow(rowNum);
                Cell cell2 = row2.getCell(columnIndex);
                if (cell2 != null) {
                    String cellData = dataFormatter.formatCellValue(cell2);
                    if (cellData.contains(refcellValue)) {
                        foundRow = rowNum; // Store the row number
                     /**   result = cellData;**/
                        break; // Break if the cell value is found
                    }
                }
            }

            if (foundRow != -1) {
                // Read data from the anotherColumnName on the found row
                Row foundDataRow = ws.getRow(foundRow);
                Cell anotherCell = foundDataRow.getCell(anotherColumnIndex);
                if (anotherCell != null) {
                    result = dataFormatter.formatCellValue(anotherCell);
                    log.info("----- Reading excel data for key : "+refcellValue+" and column "+anotherColumnName+" as :: "+result);
                    
                    if(result==null) {
                    	result="";
                    }
                }else {
                	result="";
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (wb != null) {
                    wb.close();
                }
                if (fi != null) {
                    fi.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

	public static String readDataFromTextFile(String filePath) {
        String lastLine = null;

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                lastLine = scanner.nextLine(); // captures only the last line
            }
        } catch (Exception e) {
        	e.getMessage();
        }

        return lastLine;
    }
	
	public Object[][] getDataFromExcel(String filePath, String sheetName, int from, int to){

		FileInputStream fis;
		XSSFWorkbook workbook;
		Object[][] data = null;
		int a=1;
		int b=0;
		try {
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName); // Replace "Sheet1" with your sheet name
			 DataFormatter dataFormatter = new DataFormatter();
			 
			 if(from!=0) {
				 a=from;
			 }
			
			 
			 
			int rowCount = sheet.getLastRowNum() + 1; // Add 1 to account for header row
			int colCount = sheet.getRow(0).getLastCellNum(); // Get column count from header row
			 if(to!=0) {
				 b=to+1;
			 }else {
				 b=rowCount;
			 }
			data = new Object[b - 1][colCount];
			int dataRow = 0;
			
			

			for (int i = a; i < b; i++) { // Skip header row
				Row row = sheet.getRow(i);
				if (row == null) {
					continue; // Handle empty rows gracefully
				}

				for (int j = 0; j < colCount; j++) {
					Cell cell = row.getCell(j);
					String cellValue = dataFormatter.formatCellValue(cell);;
					data[dataRow][j] = cellValue;
				}
				dataRow++;
			}

			fis.close();
			workbook.close();

		}  catch (Exception e) {
			e.getMessage();
		}



		return data;
	}
	
	 public String readUsingColNameFromCSV(String fileName, int rowNumber, String columnName) {
	        String value = "";
	        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            int currentRow = 0;
	            String[] headers = null;

	            while ((line = br.readLine()) != null) {
	                String[] cells = line.split(",", -1); // -1 keeps trailing empty strings

	                if (currentRow == 0) {
	                    headers = cells;
	                } else if (currentRow == rowNumber) {
	                    if (headers != null) {
	                        for (int i = 0; i < headers.length; i++) {
	                            if (headers[i].trim().equalsIgnoreCase(columnName.trim())) {
	                                value = i < cells.length ? cells[i] : "";
	                                break;
	                            }
	                        }
	                    }
	                    break;
	                }
	                currentRow++;
	            }
	        } catch (IOException e) {
	            log.error("Error reading CSV: " + e.getMessage());
	        }

	        return value != null ? value : "";
	    }
	 
	 public int getCSVRowCount(String csvFilePath) {
	        int rowCount = 0;

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
	            while (br.readLine() != null) {
	                rowCount++;
	            }
	        } catch (IOException e) {
	            System.err.println("Error reading CSV file: " + csvFilePath);
	            e.printStackTrace();
	        }

	        return rowCount - 1; // subtracting header row
	    }
		
}