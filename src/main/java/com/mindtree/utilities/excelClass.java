package com.mindtree.utilities;


	import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class excelClass 
	{
		public ArrayList<String> getDetailsOfSheet() throws IOException
		{
			ArrayList<String> a=new ArrayList<String>();
			FileInputStream fis=new FileInputStream("C://Excel//Demosheet.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			int count=workbook.getNumberOfSheets();
			
			for(int i=0;i<count;i++)
			{
				
				if(workbook.getSheetName(i).equalsIgnoreCase("mysheet"))
				{
					XSSFSheet sheet=workbook.getSheetAt(i);
					
					Iterator<Row> rows=sheet.iterator();
					Row firstrow=rows.next();
					Iterator<Cell> ce=firstrow.cellIterator();
					int k=0;
					int column=0;
					while(ce.hasNext())
					{
						Cell c = ce.next();
						if(c.getStringCellValue().equalsIgnoreCase("Testcases"))
						{
							column=k;
						}
						k++;
					}
					while(rows.hasNext())
					{
						Row r=rows.next();
						if(r.getCell(i).getStringCellValue().equalsIgnoreCase("BooksList"))
						{
							Iterator<Cell> cv=r.cellIterator();
							while(cv.hasNext())
							{
								Cell cp=cv.next();
								
								a.add(cp.getStringCellValue());
								
							}
						}
					}
					
				}
			}
			return a;
		
		}
	}


