package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.base.DriverSetup;

public class FileIO extends DriverSetup
{

	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	Properties prop;
	public static String userDir = System.getProperty("user.dir");
	
	//This method print the output of collections submenu
	public static void Output(String[] prodname)
	{
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("output"+1);
		for(int i=0; i<7; i++)
		{
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(prodname[i]);
		}
		sheet.autoSizeColumn(0);
		
		try {
			fos = new FileOutputStream(System.getProperty("user.dir")+"\\displayBookshelves-OutPut\\excelFiles\\CollectionsSubmenu.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//This method print the output of Top Three Suggestions of bookshelves which excludes out of stock
	public static void output1(String[] name, String[] price)
	{
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("output"+1);
		
		for(int i=0; i<3; i++)
		{
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(name[i]);
			row.createCell(1).setCellValue(price[i]);
		}
		sheet.autoSizeColumn(0);
		
		try {
			fos = new FileOutputStream(System.getProperty("user.dir")+"\\displayBookshelves-OutPut\\excelFiles\\TopThreeBookshelves.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	//This method print the output of Top Three Suggestions of bookshelves which includes out of stock
	public static void output2(String[] name, String[] price)
	{
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("output");
		
		for(int i=0; i<3; i++)
		{
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(name[i]);
			row.createCell(1).setCellValue(price[i]);
		}
		sheet.autoSizeColumn(0);
		
		try {
			fos = new FileOutputStream(System.getProperty("user.dir")+"\\displayBookshelves-OutPut\\excelFiles\\TopThreeStudyChairs.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	//This method print the output of Top Three Suggestions of Study chairs
	public static void output3(String[] name, String[] price)
	{
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("output"+1);
		
		for(int i=0; i<3; i++)
		{
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(name[i]);
			row.createCell(1).setCellValue(price[i]);
		}
		sheet.autoSizeColumn(0);
		
		try {
			fos = new FileOutputStream(System.getProperty("user.dir")+"\\displayBookshelves-OutPut\\excelFiles\\TopThreeBookshelvesIncludingOutOfStock.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}
