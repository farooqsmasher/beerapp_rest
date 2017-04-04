package com.webteam_rest.util;

public class FileUtil {
	public String getFileExtension(String fileName) throws Exception{
		String[] fileNamArr = fileName.split("\\.");
		return fileNamArr[fileNamArr.length-1];
	}
}
