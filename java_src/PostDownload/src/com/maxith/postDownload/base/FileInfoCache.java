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

	/**
	 * 文件名(不带后缀)
	 */
	private String fileName;
	/**
	 * 文件后缀
	 */
	private String fileSuffix;
	/**
	 * 临时文件绝对路径
	 */
	private String fileTempPath;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public String getFileTempPath() {
		return fileTempPath;
	}

	public void setFileTempPath(String fileTempPath) {
		this.fileTempPath = fileTempPath;
	}

}
