package com.crm.vtiger.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary implements InterfaceAutoConst
{
	/******************** To Get Data From Properties File*****/
	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(PROP_PATH);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	/******************** To Get Data From XL**************/
	public String getData(String path, String sheet, int r, int c)
	{
		String v = "";
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
}

			
			
	