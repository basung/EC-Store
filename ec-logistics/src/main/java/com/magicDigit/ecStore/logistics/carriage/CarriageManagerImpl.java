package com.magicDigit.ecStore.logistics.carriage;

import com.magicDigit.ecStore.base.exception.GlobalException;
import com.magicDigit.ecStore.common.dao.GenericDao;
import com.magicDigit.ecStore.common.manager.impl.GenericManagerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Date: 2018-11-02-下午1:31
 */
@Transactional
@Service
public class CarriageManagerImpl extends GenericManagerImpl<Carriage, String, GlobalException> implements CarriageManager {

    @Resource
    CarriageDao carriageDao;

    protected GenericDao<Carriage, String> getDao() {
	  return carriageDao;
    }

}
