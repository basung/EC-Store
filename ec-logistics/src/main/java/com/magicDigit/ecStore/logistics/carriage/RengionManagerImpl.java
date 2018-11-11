package com.magicDigit.ecStore.logistics.carriage;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-11-02-下午1:40
 */

@Transactional
@Service
public class RengionManagerImpl extends GenericManagerImpl<Region, String, GlobalException> implements RegionManager {

    @Resource
    RegionDao regionDao;

    protected GenericDao<Region, String> getDao() {
	  return regionDao;
    }

}
