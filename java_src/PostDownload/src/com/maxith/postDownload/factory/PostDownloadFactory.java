package com.maxith.postDownload.factory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

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

	/**
	 * 创建临时文件,并返回缓存key
	 * @param cache
	 * @param param
	 * @return
	 */
	public String createTempFile(FileInfoCache cache,Object param){
		try {
			byte[] in = downloadService.createFileByte(param);

			String realPath = cache.getFileTempPath() + File.separator + cache.getFileName() + ".data";
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

	public void getTempFile(String fileKey,OutputStream out){
		FileInfoCache cache = cacheService.read(fileKey);
		try {
			String tempPath = cache.getFileTempPath() + File.separator + cache.getFileName() + ".data";

			File file = new File(tempPath);

			if(!file.exists()){
				throw new Exception("未找到临时文件!PATH=" + tempPath);
			}

			FileInputStream input = new FileInputStream(file);
			BufferedInputStream in = new BufferedInputStream(input);
			BufferedOutputStream outBuff = new BufferedOutputStream(out);

			//写出
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = in.read(buff, 0, buff.length))) {
				out.write(buff, 0, bytesRead);
			}
			// 刷新此缓冲的输出流
			outBuff.flush();

			input.close();


			// 关闭流
			outBuff.close();

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
