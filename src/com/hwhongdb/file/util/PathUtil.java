package com.hwhongdb.file.util;

import java.io.File;

public class PathUtil {
	
	/**
	 * ·ÖÎÄ¼þ´æ´¢
	 * @param storeDirectory
	 * @param fileName
	 * @return
	 */
	public static String makeDir(String storeDiretory,String fileName) {
		int hashCode = fileName.hashCode();
		int dir_1 = hashCode&0xf;
		int dir_2 = (hashCode&0xf0)>>4;
		
		String newPath = "/" + dir_1 + "/" +dir_2;
		File file = new File(storeDiretory,newPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		return newPath;
	}
}
