package com.magicDigit.ecStore.admin.file;


import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.manager.GenericManager;

/**
 * Date: 2018-10-18-下午2:51
 */
public interface VFileService extends GenericManager<VFile, String, GlobalException> {

    Boolean existsByMD5(String md5);

    VFile getFileByMd5(String md5);

}
