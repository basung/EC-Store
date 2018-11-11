package com.magicDigit.ecStore.wares.brand;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-10-19-上午10:13
 */

@Transactional
@Service
public class BrandManagerImpl extends GenericManagerImpl<Brand, String, GlobalException> implements BrandManager {

    @Resource
    BrandDao brandDao;

    protected GenericDao<Brand, String> getDao() {
	  return brandDao;
    }
}
