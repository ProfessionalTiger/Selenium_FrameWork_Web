package parser.Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		try {
		
		File src= new File ("./Configuration/config.properties");
		
		FileInputStream str=new FileInputStream(src);
		pro =new Properties();
		pro.load(str);
				
	}catch(Exception e){ 
		System.out.println("Exception is "+ e.getMessage());
	}
	}

	public String getbaseURL()
	{
		String url=pro.getProperty("baseURL");
		return url;		
	}
	public String getdate()
	{
		String date=pro.getProperty("date");
		return date;		
	}
	
	
	public String getchorompath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;		
	}
	public String getfirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;		
	}
	public String getiepath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;		
	}
	
}
