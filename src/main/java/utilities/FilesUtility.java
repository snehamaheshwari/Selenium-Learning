package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Properties;

public class FilesUtility {
	
	Path currentRelativePath = Paths.get("");
	String s = currentRelativePath.toAbsolutePath().toString();
	String basePath = s + File.separator;
	
	public String getValueFromPropertyFile(String key) throws IOException {
		InputStream input = new FileInputStream(basePath + "src" + File.separator +"main" + File.separator + "java"+File.separator+"config" + File.separator + "config.properties");
		Properties prop = new Properties();
		prop.load(input);
		String keyValue = prop.getProperty(key);
		return keyValue;
	}
}
