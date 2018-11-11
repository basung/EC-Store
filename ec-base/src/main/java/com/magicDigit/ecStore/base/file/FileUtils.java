package com.magicDigit.ecStore.base.file;

import com.magicDigit.ecStore.base.exception.ExceptionEnum;
import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.base.utils.UUIDUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * 文件上传工具包
 * <p>
 * Date: 2018-10-18-上午9:45
 */
public class FileUtils {

    /**
     * @param file 文件
     * @param path 文件存放路径
     * @return
     */
    public static String upload(MultipartFile file, String path) throws IOException {


	  // 生成新的文件名
	  //String realPath = path + "/" + FileNameUtils.getFileName(fileName);


	  //原文件名
	  String originalFileName = file.getOriginalFilename().replace("-", "");

	  // 生成新的文件名
	  String realFileName = UUIDUtils.getUUID() + '_' + originalFileName;

	  //使用原文件名
	  String realPath = path + realFileName;

	  File dest = new File(realPath);

	  //判断文件父目录是否存在
	  if (!dest.getParentFile().exists()) {
		dest.getParentFile().mkdir();
	  }

	  //文件上传
	  file.transferTo(dest);

	  return realPath;

    }

    /**
     * NIO way
     */
    public static byte[] toByteArray(String filename) {

	  File f = new File(filename);
	  if (!f.exists()) {
//		log.info("文件未找到！" + filename);
		throw new GlobalException(ExceptionEnum.FILE_NOT_FOUND);
	  }
	  FileChannel channel = null;
	  FileInputStream fs = null;
	  try {
		fs = new FileInputStream(f);
		channel = fs.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
		while ((channel.read(byteBuffer)) > 0) {
		    // do nothing
		    // System.out.println("reading");
		}
		return byteBuffer.array();
	  } catch (IOException e) {
		throw new GlobalException(ExceptionEnum.FILE_READING_ERROR);
	  } finally {
		try {
		    channel.close();
		} catch (IOException e) {
		    throw new GlobalException(ExceptionEnum.FILE_READING_ERROR);
		}
		try {
		    fs.close();
		} catch (IOException e) {
		    throw new GlobalException(ExceptionEnum.FILE_READING_ERROR);
		}
	  }
    }

    /**
     * 删除目录
     *
     * @author fengshuonan
     * @Date 2017/10/30 下午4:15
     */
    public static boolean deleteDir(File dir) {
	  if (dir.isDirectory()) {
		String[] children = dir.list();
		for (int i = 0; i < children.length; i++) {
		    boolean success = deleteDir(new File(dir, children[i]));
		    if (!success) {
			  return false;
		    }
		}
	  }
	  return dir.delete();
    }

    /**
     * 生成md5
     * @param file 图片文件
     * @return MD5值
     * @throws GlobalException
     */
    public static String getFileMd5(MultipartFile file) {
	  try {
		byte[] uploadBytes = file.getBytes();
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] digest = md5.digest(uploadBytes);
		String hashString = new BigInteger(1, digest).toString(16);
		return hashString;
	  } catch (Exception e) {
		throw new GlobalException(400,e.getMessage());
	  }
    }


}

