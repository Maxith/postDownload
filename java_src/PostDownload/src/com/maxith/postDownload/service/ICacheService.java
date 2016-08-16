package com.maxith.postDownload.service;

import com.maxith.postDownload.base.FileInfoCache;
/**
 * 文件信息缓存
 * Description: 
 * Copyright: Maxith
 * Date: 2016年8月16日
 * Time: 下午3:53:11
 * @author Maxith
 * @version 1.0
 */
public interface ICacheService {
	/**
	 * 创建文件信息缓存对象
	 * @return
	 * Description: 
	 * Date: 2016年8月16日
	 * Time: 下午4:16:33
	 * @author Maxith
	 */
	public FileInfoCache createCacheFile();
	
	/**
	 * 写缓存
	 * @param cache 缓存对象
	 * @return	缓存文件key
	 * Description: 
	 * Date: 2016年8月16日
	 * Time: 下午3:53:24
	 * @author Maxith
	 */
	public String write(FileInfoCache cache);
	
	/**
	 * 读缓存
	 * @param fileKey 缓存文件key
	 * @return	缓存对象
	 * Description: 
	 * Date: 2016年8月16日
	 * Time: 下午3:53:32
	 * @author Maxith
	 */
	public FileInfoCache read(String fileKey);
	/**
	 * 删除缓存
	 * @param fileKey
	 * Description: 
	 * Date: 2016年8月16日
	 * Time: 下午4:49:08
	 * @author Maxith
	 */
	public void del(String fileKey);
}
