package datautility;

import java.io.FileInputStream;	
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.util.Properties; 

public class DataUtility  
{
	FileInputStream path;
	public String fetchData(String key)
	
	{
		try {
			 path=new FileInputStream("./src/test/resources/sele.properties");
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		Properties prop=new Properties();
		try {
			prop.load(path);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop.getProperty(key);
		
		
	}
}
