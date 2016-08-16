package com.maxith.postDownload.base;
/**
 * 文件缓存信息对象
 * Description: 
 * Copyright: Maxith
 * Date: 2016年8月16日
 * Time: 下午3:56:10
 * @author Maxith
 * @version 1.0
 */
public class FileInfoCache {

	public static final String FILE_NAME_KEY = "file_name";
	
	public static final String FILE_PATH_KEY = "file_path";
	
	private String fileName;
	
	private String filePath;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
