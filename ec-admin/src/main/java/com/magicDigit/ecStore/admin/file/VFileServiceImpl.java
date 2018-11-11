package com.magicDigit.ecStore.admin.file;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Date: 2018-10-18-下午2:51
 */

@Transactional
@Service
public class VFileServiceImpl extends GenericManagerImpl<VFile, String, GlobalException> implements VFileService {

    @Resource
    VFileRepository vFileRepository;

    protected GenericDao<VFile, String> getDao() {
	  return vFileRepository;
    }

    public Boolean existsByMD5(String md5){

        return vFileRepository.existsByFileMd5(md5);
    }

    public VFile getFileByMd5(String md5){

        return vFileRepository.getByFileMd5(md5);

    }

}
