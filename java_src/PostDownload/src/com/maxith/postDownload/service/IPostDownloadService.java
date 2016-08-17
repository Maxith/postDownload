package com.maxith.postDownload.service;

/**
 * post下载数据接口service
 * Description:
 * Copyright: Maxith
 * Date: 2016年8月16日
 * Time: 下午3:44:20
 * @author Maxith
 * @version 1.0
 */
public interface IPostDownloadService {
	/**
	 * 创建文件字节数组
	 * @param param
	 * @return
	 */
	public byte[] createFileByte(Object param);
}
