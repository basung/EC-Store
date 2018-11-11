package com.magicDigit.ecStore.admin.file;


import com.magicDigit.ecStore.common.dao.GenericDao;

/**
 * Date: 2018-10-18-下午2:50
 */
public interface VFileRepository extends GenericDao<VFile, String> {

    Boolean existsByFileMd5(String md5);

    VFile getByFileMd5(String md5);

}
