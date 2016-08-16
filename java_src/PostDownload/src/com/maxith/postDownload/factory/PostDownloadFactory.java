package com.maxith.postDownload.factory;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import com.maxith.postDownload.base.FileInfoCache;
import com.maxith.postDownload.service.ICacheService;
import com.maxith.postDownload.service.IPostDownloadService;

/**
 * post下载工厂
 * Description: 
 * Copyright: Maxith
 * Date: 2016年8月16日
 * Time: 下午3:44:20
 * @author Maxith
 * @version 1.0
 */
public class PostDownloadFactory {

	private IPostDownloadService downloadService;
	private ICacheService cacheService;
	
	public PostDownloadFactory(IPostDownloadService downloadService,ICacheService cacheService){
		this.downloadService = downloadService;
		this.cacheService = cacheService;
	}
	
	public String createTempFile(Object param){
		try {
			byte[] in = downloadService.createFileByte(param);
			
			FileInfoCache cache = cacheService.createCacheFile();
			
			String realPath = cache.getFilePath();
			if(in != null){
				
				File targetFile = new File(realPath);
				
				// 如果父目录不存在则创建
				File parentFile = targetFile.getParentFile();
				if(parentFile != null && !parentFile.exists()){
					parentFile.mkdirs();
				}
				
				FileOutputStream out = new FileOutputStream(targetFile);
				BufferedOutputStream outBuff = new BufferedOutputStream(out);
				
				outBuff.write(in);

				// 刷新此缓冲的输出流
				outBuff.flush();

				// 关闭流
				outBuff.close();
				
				out.close();
			}
			
			return cacheService.write(cache);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
